package com.tmk.action.compra;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.orden.CuponDePago;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.orden.OrdenDAO;
import com.tmk.orden.OrdenLocal;
import com.tmk.orden.OrdenLocalHome;
import com.tmk.service.orden.OrdenService;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class CuponDePagoRender extends Action {

	/**
	 * Levanta la tempalte de cupon de pago de dinero mail, y realiza los chequeos necesarios.
	 * como en frmDM.jsp  
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer idOrden = Convert.toNumber(request.getParameter("idOrden"),(Integer)null);
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");	
		Template template = (Template )ServiceLocator.getTemplateService().getTemplate("tmpCupon");
		
		boolean puedeVerCupon = true;
		String mensaje =null;
		if (socioPK == null) {
			puedeVerCupon = false;
			mensaje ="Para imprimir el cupón debes iniciar sesión con tu usuario y contraseña.";
			template.setParam("puedeVerCupon", puedeVerCupon);
			response.getWriter().print(template.output());
			return super.execute(mapping, form, request, response);
		}
		String socioLogueado = (String)request.getSession().getAttribute("Registracion.nombreCompleto");
		OrdenLocal orden = null;
		try {
			OrdenLocalHome ordenLH = (OrdenLocalHome)DBUtil.getHome("Orden");
			orden = ordenLH.findByPrimaryKey(idOrden);
			if (!orden.getID_SOCIO().equals(socioPK.ID_SOCIO) || !orden.getID_SUCURSAL_SOCIO().equals(socioPK.ID_SUCURSAL)) {
				puedeVerCupon = false;
				mensaje ="El cupón que intentas imprimir no corresponde al socio que ha iniciado sesión.";
			}
		} catch (Exception e) {
			puedeVerCupon = false;
			mensaje ="La orden no es válida.";
		}
		
		if (orden == null) {
			puedeVerCupon = false;
		}
												
		if (puedeVerCupon) {
			OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden.intValue());
	 		if ((ordenDAO != null) && (ordenDAO.getMedioDeCobro().requiereCuponDePago())) {
				
				Connection conn = DBUtil.buildConnection();
				CuponDePago cuponDePago = new CuponDePago();
				try {
					
					String param [] = new String[] {"id_orden = " + idOrden.toString()};
					cuponDePago.select(conn, param);
				} catch (Exception e) {
					mensaje ="La orden no tiene asignado un cupón de pago.";
				} finally {
					conn.close();
				}					
				if (cuponDePago.getCodigo() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(orden.getFECHA());
					cal.add(Calendar.DATE, 15);
					Date date = new Date(cal.getTimeInMillis());
					//Si todavia no vencio					
					if (cal.after(Calendar.getInstance())) {						
						template.setParam("fecha",Convert.toString(date));
						template.setParam("total",Contenido.precioToString(ordenDAO.totalSitioCompleto()));
						template.setParam("idOrden",ordenDAO.getIdOrdenProcesada());
						template.setParam("apynSocio",socioLogueado);
						template.setParam("codigoCuponDePago",cuponDePago.getCodigo());
						template.setParam("nombreMedioCobro",ordenDAO.getMedioDeCobro().getNombre());
						template.setParam("medioDeCobroId",ordenDAO.getMedioDeCobro().getId());
						template.setParam("nombreMedioCobro",ordenDAO.getMedioDeCobro().getNombre());
						template.setParam("cuponDePagoCodigo",cuponDePago.getCodigo());
					}else{
						template.setParam("mensaje","La fecha de pago del cupón ha vencido");
					}
				}else{
					template.setParam("mensaje","La orden no tiene asignado un cupón de pago.");
				}
	 		}
		}
		template.setParam("puedeVerCupon", puedeVerCupon);
		if(mensaje != null) {
			template.setParam("mensaje",mensaje);
		}
		response.getWriter().print(template.output());
		return super.execute(mapping, form, request, response);
	}
}
