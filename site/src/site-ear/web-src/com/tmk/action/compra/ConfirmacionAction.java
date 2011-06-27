package com.tmk.action.compra;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.orden.ItemOrden;
import com.tmk.bus.orden.Orden;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ArcashService;
import com.tmk.soa.servicios.interfaces.DineroMailService;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class ConfirmacionAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String frwRedirect = "frwConfirmacion";		
		SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
		int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
		if (socioPK == null || idOrden == 0) {
			return mapping.findForward("frwMiCuenta");
		}
		//int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
		//if(idOrden == 0) {
		//	return mapping.findForward("frwMiCuenta");
		//}
		
		Template tmpOrden = (Template)ServiceLocator.getTemplateService().getTemplate("tmpConfirmacion");		
		request.getSession().removeAttribute("msgError");	

		Orden orden = null;		
		try {
			orden = ServiceLocator.getOrdenService().findByPrimaryKey(idOrden); 
			if (!orden.getSocio().getId_socio().equals(socioPK.ID_SOCIO) || !orden.getSocio().getId_sucursal().equals(socioPK.ID_SUCURSAL)) {
				tmpOrden.setParam("muestraPantalla", "");
				tmpOrden.setParam("mensaje", "Los datos de la orden deseas ver no corresponden al socio que ha iniciado sesión.");
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
				request.setAttribute("template",tmpOrden.output());
				return mapping.findForward(frwRedirect);
			}
		} catch (Exception e) {
	        frwRedirect = "frwMiCuenta";
	        return mapping.findForward(frwRedirect);
		}	
		
//------LOGICA PROPIA DE LA PANTALLA, POST VALIDACION----------------------------------------------------//		
				
		tmpOrden.setParam("idOrden", orden.getId_orden());
		tmpOrden.setParam("muestraPantalla", "true");
		
		//cual fue el medio de pago usado?
		//HOME BANKING o NETBANKING
		if(orden != null && orden.getPago_orden().getMediosDeCobro().esHomeBanking()|| orden.getPago_orden().getMediosDeCobro().esNetBanking()){
			tmpOrden.setParam("esBanking", "true");
			tmpOrden.setParam("totalSitio", Contenido.precioToString(orden.getTotal()));
		//FAX
		} else if(orden!=null && orden.getPago_orden().getMediosDeCobro().esFax()){
			tmpOrden.setParam("esFax", "true");
		} else if(orden!=null && orden.getPago_orden().getMediosDeCobro().requiereCuponDePago()){
			tmpOrden.setParam("requiereCuponDePago", "true");
			tmpOrden.setParam("urlIframe", "/CuponDePagoRender.do?idOrden="+idOrden);
		//PAGO DINERO MAIL
		} else	if(orden!=null && orden.getPago_orden().getMediosDeCobro().esDineroMail()) {
			tmpOrden.setParam("esDineroMailOArcash", "true");
			DineroMailService servicio = ServiceLocator.getDineroMailService();			
			Template frmDM = (Template)ServiceLocator.getTemplateService().getTemplate("tmpFormDM");
			Map<String,String> datosForm = new HashMap<String,String>();
			datosForm.put("total",""+orden.getTotal());
			datosForm.put("idOrden","" + orden.getId_orden());
			servicio.setParametros(datosForm,frmDM);
			tmpOrden.setParam("formulario", frmDM.output());
			frmDM = null;
			servicio = null;
		//PAGO ARCASH
		}else if (orden != null && orden.getPago_orden().getMediosDeCobro().esArcash()){
			tmpOrden.setParam("esDineroMailOArcash","true");
			ArcashService servicio =  ServiceLocator.getArcashService();		
			//armo el pass que despues lo usa el servicio para generar el token
			StringBuffer pass = new StringBuffer("");
			pass.append(servicio.getIdMerchant());
			pass.append("|");
				pass.append(orden.getTotal());
				pass.append("|").append("1").append("|");
				pass.append(servicio.getPasword());
			//Map con todos los parametros	
			Map<String,String> frm = new HashMap<String,String>();
			frm.put("action",servicio.getPathArash());						
			frm.put("Amount","" + orden.getTotal());					
			frm.put("Token",ServiceLocator.getArcashService().getToken(null,pass.toString()));
			frm.put("ExternalReference","" + orden.getId_orden());
			tmpOrden.setParam("formulario",servicio.getLinkDeFormulario(frm));
			frm = null;
		}
		//seteo de los datos necesarios para el script de google (tax) 
		double tax = 0;
		Hashtable<String, Object> hashArticulos = null;
		Vector<Hashtable<String,Object>> vecArticulo = new Vector<Hashtable<String,Object>>();
		for(int i = 0;i< orden.getItem_orden().length;i++) {
			ItemOrden item = orden.getItem_orden()[i];		
			if(!item.getArticulo().esGastoDeEnvio() && 
					!item.getArticulo().esPapelDeRegalo() ) {
				double precioArticulo = (item.getPrecio_promocion() < item.getPrecio_descuento())?
						item.getPrecio_promocion() * item.getCantidad():
							item.getPrecio_descuento() * item.getCantidad();
				double precioArticuloSinImp = item.getPrecio_promocion_sin_impuestos() * item.getCantidad();
				tax = Convert.round( tax + ((precioArticulo - precioArticuloSinImp)/Globals.TASA_DOLLAR));				
				if (item.getGastoDeEnvio()!=null) {
					precioArticulo = item.getGastoDeEnvio().getPrecio_promocion() * item.getGastoDeEnvio().getCantidad();
					precioArticuloSinImp = item.getGastoDeEnvio().getPrecio_promocion_sin_impuestos() * item.getGastoDeEnvio().getCantidad();
					tax = Convert.round( tax + ((precioArticulo - precioArticuloSinImp)/Globals.TASA_DOLLAR));
				}
				if (item.getPapelDeRegalo()!=null) {
					precioArticulo = item.getPapelDeRegalo().getPrecio_promocion() * item.getCantidad();
					precioArticuloSinImp = item.getPapelDeRegalo().getPrecio_promocion_sin_impuestos() * item.getPapelDeRegalo().getCantidad();
					tax = Convert.round( tax + ((precioArticulo - precioArticuloSinImp)/Globals.TASA_DOLLAR));
				}
				//System.out.println("tax : "+ tax);
				//datos que van dentro del script de doubleclik.
				hashArticulos = new Hashtable<String,Object>();
				hashArticulos.put("idOrden",orden.getId_orden().toString());
				hashArticulos.put("idArticulo",item.getArticulo().getId_articulo().toString());
				hashArticulos.put("titulo",Convert.capitalizar(item.getArticulo().getTitulo(),true));
				hashArticulos.put("idSeccion",item.getArticulo().getCategoria_seccion().toString());
				hashArticulos.put("totalSitioTasaDola",Convert.round(item.getPrecio_unitario()/Globals.TASA_DOLLAR));
				hashArticulos.put("cantidadArticulo",item.getCantidad().toString());
				vecArticulo.add(hashArticulos);
				//fin
			}
		}
		//System.out.println("tax : "+ tax);
		
		//datos par el js de doubleclick.		
		tmpOrden.setParam("articulos", vecArticulo);
		tmpOrden.setParam("idAlianza",(orden.getAlianza_seccion() != null) ? orden.getAlianza_seccion().getId_alianza().toString() : "");
		tmpOrden.setParam("totalSitioTasa",""+Convert.round(orden.getTotal()/Globals.TASA_DOLLAR));
		tmpOrden.setParam("tax",""+tax);
		tmpOrden.setParam("totalGastoDeEnvio",""+Convert.round(orden.totalGastoDeEnvio()/Globals.TASA_DOLLAR));
		tmpOrden.setParam("pais",orden.getDomicilioFacturacion().getDomicilioOrden().getPais().getDescripcion());
		if(orden.getDomicilioFacturacion().getDomicilioOrden().getProvincia()!=null) {
			tmpOrden.setParam("provincia",orden.getDomicilioFacturacion().getDomicilioOrden().getProvincia().getDescripcion());
		}else {
			tmpOrden.setParam("provincia","");	
		}		
		boolean tieneLocalidad = orden.getDomicilioFacturacion().getDomicilioOrden().getLocalidad()!=null;
		tmpOrden.setParam("localidad",tieneLocalidad ? orden.getDomicilioFacturacion().getDomicilioOrden().getLocalidad().getDescripcion() : "");			
		//fin
		
		tmpOrden.setParam("descripcionPago",orden.getPago_orden().getMediosDeCobro().getDescripcion());		
		//seteo los mail que eligio el socio
		
		tmpOrden.setParam("email1", orden.getSocio().getE_mail1());
		String email2 =  (String)request.getSession().getAttribute("email2");
		if(email2!=null && email2.trim().length() > 0 && MainHelper.esEMail(email2)) {
			tmpOrden.setParam("email2", email2.toUpperCase());
			tmpOrden.setParam("delimitador", " y ");
		}else {
			tmpOrden.setParam("delimitador", ".");
		}
		if(Globals.esModoRelease()) {
			tmpOrden.setParam("esRelease", "true");
			//tmpOrden.setParam("googleAnalyticsSSL", Globals.getGoogleAnalyticsSSL());
		}
		tmpOrden.setParam("totalOrden", orden.getTotal().toString());
		
		request.setAttribute("template",tmpOrden.output());
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		return mapping.findForward(frwRedirect);
	}

}
