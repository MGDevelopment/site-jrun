package com.tmk.action.compra;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;
import com.tmk.orden.TarjetaPrepaga;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class VistaPreviaAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String frwRedirect = ProcesoCompraUtilImp.getInstance().frwRedireccion(request, response, ProcesoCompraUtil.VISTA_PREVIA);
		if(frwRedirect != null ) {
			return mapping.findForward(frwRedirect);
		}
		frwRedirect = "frwVistaPrevia";

		//obtengo el servicio de socio,y la pk de la sesion
		SocioPK pk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		OrdenDAO ordenDao = (OrdenDAO)request.getSession().getAttribute("ordenDAO");

		//POR LO MAS BASICO LOS DOMICILIOS
		Vector<Hashtable<String, Object>> vecArticulos = new Vector<Hashtable<String,Object>>();
		Hashtable<String, Object>hasArticulos = null;
		Iterator it = ordenDao.getArticulos().iterator();
		ArticuloService servicio = ServiceLocator.getArticuloService();
		//total de descuentos en la UI nueva es lo que dice total beneficio 
		double totalDescuento = 0.0;
		while(it.hasNext()) {
			//datos por articulo					
			ArticuloDAO articulo = (ArticuloDAO)it.next();
			
			boolean prodPromo = ( (articulo.tienePromocion() && articulo.getPrecioConDescuento() != articulo.getPrecioPromocion())  || ((articulo.getPrecioPromocion() != articulo.getPrecioConImpuesto())
					&& articulo.getPrecioPromocion() != articulo.getPrecioConDescuento())) &&
					(articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion()) > 0.009;
			
			boolean prodDesc = articulo.tieneDescuento() && (articulo.getPrecioConDescuento() != articulo.getPrecioConImpuesto());
			//boolean tieneGasto = (articulo.getGastoDeEvio() != null);
			//boolean gasPromo = tieneGasto && (articulo.getGastoDeEvio().tienePromocion() || articulo.getGastoDeEvio().getPrecioPromocion()!= articulo.getGastoDeEvio().getPrecioConImpuesto());
			//boolean tienePapel = (articulo.getPapelDeRegalo() != null);
			//boolean papPromo = tienePapel && (articulo.getPapelDeRegalo().tienePromocion() || articulo.getPapelDeRegalo().getPrecioPromocion()!= articulo.getPapelDeRegalo().getPrecioConImpuesto());

			Articulo articuloBo = servicio.getArticuloParaCarrito(articulo.getId());
			hasArticulos  = new Hashtable<String, Object>();
			hasArticulos.put("idArticulo", articuloBo.getId_articulo().toString());
			hasArticulos.put("titulo", Convert.corregir(articuloBo.getTitulo(), true));
			hasArticulos.put("cantidadArticulo" ,articulo.getCantidad());
			//chequeo suscripcion quid, no le doy la posibilidad de que vea el detalle
			if(articuloBo.getId_articulo().equals(CarritoUtil.getAriculosExcluidos().get(0))){
				hasArticulos.put("urlDetalle", "#");	
			}else{
				hasArticulos.put("urlDetalle", articuloBo.getUrlDetalle());
			}	
			hasArticulos.put("textoSobre", (articulo.getSubArticulo()!=null)?articulo.getSubArticulo().getTitulo():"No");
			hasArticulos.put("tieneMensaje", (articulo.getNota()!=null && articulo.getNota().trim().length()>0)? "Si":"No");
			// fix mg20130425: nueva logica para la columna de regalo
			if (articulo.getSubArticulo()!=null){
				// Tiene papel
				// fix mg20130503: descripcion del papel
				String papel = 	articulo.getSubArticulo().getTitulo();
				hasArticulos.put("regalo", (papel.length() > 20) ? papel.substring(0,17) + "..." : papel);
			} else {
				// No papel
				hasArticulos.put("regalo", (articulo.getNota()!=null && articulo.getNota().trim().length()>0)? "Si":"No");
			}
			
			if (prodDesc) {
				hasArticulos.put("descuento",Contenido.precioToString((Math.abs(articulo.getAhorro()))* articulo.getCantidad()) );
				totalDescuento += Math.abs(articulo.getAhorro())* articulo.getCantidad();  
			}
			//promocion
            if (prodPromo) {
            	hasArticulos.put("descuento",Contenido.precioToString((articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion())* articulo.getCantidad()));
            	totalDescuento += (articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion())* articulo.getCantidad();
            }
            
            // fix mg20130425: modificacion de la logica para la columna descuento cuando es 0
            //si no hay descuento ni promocion
            if(!prodDesc && !prodPromo) {
            	hasArticulos.put("descuento", Contenido.precioToString(0));
            }
            
            // fix mg20130422: agregado del precio de articulo
//            hasArticulos.put("precio", Contenido.precioToString(articulo.getPrecioSitio()));
//            hasArticulos.put("subTotal", Contenido.precioToString(articulo.getPrecioSitio() * articulo.getCantidad()));
            // fix mg20130515: utilizo el precio original
            hasArticulos.put("precio", Contenido.precioToString(articulo.getPrecioOriginal()));
            hasArticulos.put("subTotal", Contenido.precioToString(articulo.getPrecioOriginal() * articulo.getCantidad()));
            if (articulo.getCantidad() > 1) {
            	hasArticulos.put("cantidadMayor1", true);
            } else {
            	hasArticulos.put("cantidadMayor1", false);
            }
            //descuento si, promcion no(PRECIO FINAL)
           /* if (prodDesc && !prodPromo) { 
            	hasArticulos.put("descuento",Contenido.precioToString((articulo.getPrecioPromocion()< articulo.getPrecioConDescuento())? articulo.getPrecioPromocion() * articulo.getCantidad(): articulo.getPrecioConDescuento() * articulo.getCantidad()));
            }*/
            //precio final
            /*if(prodPromo) { 
            	hasArticulos.put("descuento",Contenido.precioToString((articulo.getPrecioPromocion()< articulo.getPrecioConDescuento())? articulo.getPrecioPromocion() * articulo.getCantidad(): articulo.getPrecioConDescuento() * articulo.getCantidad()));
			}*/			
			vecArticulos.add(hasArticulos);
		}
		//instancio aca la temaplate por que recien aca la uso, no mas arriba de todo el codigo
		Template tmpDomicilios = (Template)ServiceLocator.getTemplateService().getTemplate("tmpVistaPrevia");
		tmpDomicilios.setParam("articulos", vecArticulos);
		
		//precio total,subtotal,papel de regalo		
		tmpDomicilios.setParam("subTotal", Contenido.precioToString(ordenDao.totalSitio()));
		tmpDomicilios.setParam("totalGastoEnvio", Contenido.precioToString(ordenDao.totalGastoDeEnvio()));
		tmpDomicilios.setParam("totalPapelRegalo", Contenido.precioToString(ordenDao.totalPapelDeRegalo()));
		// fix mg20130515: el total de descuento pasa a ser un numero negativo
		if (totalDescuento == 0) {
			tmpDomicilios.setParam("totalBeneficio", Contenido.precioToString(totalDescuento));
		} else {
			tmpDomicilios.setParam("totalBeneficio", Contenido.precioToString(Math.abs(totalDescuento) * -1));
		}
		tmpDomicilios.setParam("total", Contenido.precioToString(ordenDao.totalSitioCompleto()));
		tmpDomicilios.setParam("totalDolar", Contenido.precioDollarToString(ordenDao.totalSitioCompleto()));
		tmpDomicilios.setParam("totalEuro", Contenido.precioEuroToString(ordenDao.totalSitioCompleto()));
		// fix mg20130422: agregado de total para reembolsos
		tmpDomicilios.setParam("totalReembolso", Contenido.precioToString(ordenDao.getImporteReembolso()));
		
		//promocion aplicada
		String promosAplicadas = ordenDao.getPromocionesAplicadas("<br>&middot; ");
		tmpDomicilios.setParam("promocionAplicada",promosAplicadas.equals("")? "Ninguna ": promosAplicadas);
		
		//BLOQUE DE mensaje asociado a una promocion
		Map<String, String> mensaje = getMensajeDePromocion(ordenDao.getCupon());
		if(mensaje!=null){
			tmpDomicilios.setParam("tieneMensajeEnPromocion","true");
			tmpDomicilios.setParam("nombre",mensaje.get("nombres"));
			tmpDomicilios.setParam("texto",mensaje.get("texto"));
			tmpDomicilios.setParam("nota",mensaje.get("nota"));
			mensaje = null;
		}		
		//direccion de envio y facturacion
		setDOmicilio(tmpDomicilios,ordenDao.getDomicilioEnvio(),"E");
		setDOmicilio(tmpDomicilios,ordenDao.getDomicilioFacturacion(),"F");
		
		//nombre del receptor
		if(ordenDao.tieneOtroReceptor()) {
			tmpDomicilios.setParam("receptor",Convert.nombreCompleto(ordenDao.getNombresReceptor(), ordenDao.getApellidosReceptor()));
		}				
		tmpDomicilios.setParam("comentario","("+ Convert.toString(ordenDao.getComentario(), "Ninguno")+")");
		//horario entrega
		tmpDomicilios.setParam("horarioContacto",ordenDao.getHorarioContacto());
		
		//cnf/cnpj
		if (ordenDao.getDomicilioEnvio().getIdPais().intValue() == CompraHelper.PAIS_BRASIL) {
            tmpDomicilios.setParam("esBrasil", "true");
            String codCPF_CNPJ="";
            String descripcion = "";
            if (ordenDao.getCPF_CNPJ() !=  null) {
                if (ordenDao.getCPF_CNPJ().indexOf("CPF") >-1) {
                    codCPF_CNPJ = ordenDao.getCPF_CNPJ().replaceAll("CPF ", "");
                    descripcion = "CPF";
                } else {
                    codCPF_CNPJ = ordenDao.getCPF_CNPJ().replaceAll("CNPJ ", "");
                    descripcion = "CNPJ";
                }
            } 
           tmpDomicilios.setParam("valorCPF_CNPJ", codCPF_CNPJ);
           tmpDomicilios.setParam("descripcion", descripcion);           
     	}
		
		//METODO DE ENVIO DE PEDIDO
		tmpDomicilios.setParam("metodoEnvio",null!=ordenDao.getMetodoDeEnvio()?ordenDao.getMetodoDeEnvio():"");
		
		//MEDIO DE PAGO
		tmpDomicilios.setParam("medioDePago",ordenDao.getMedioDeCobro().getNombre());
		if(ordenDao.getMedioDeCobro().esTarjeta()){
			tmpDomicilios.setParam("estarjeta","true");
			tmpDomicilios.setParam("titularTarjeta",ordenDao.getNombreCliente());
			tmpDomicilios.setParam("nroTarjeta",Convert.toString(ordenDao.numeroTarjetaAMostrar()));//si es tarjeta de credito si no es""
			tmpDomicilios.setParam("cantidadCuotas",Convert.pluralCompleto(ordenDao.getTarjetaPlanDAO().getCuotas(), "cuota"));
			//si tiene interes las muestro
			if(ordenDao.getInteresCobradoDAO() != null) { 
				tmpDomicilios.setParam("interes", Contenido.precioToString(ordenDao.getInteresCobradoDAO().getPrecioPromocion()));
			}
		}else{
			tmpDomicilios.setParam("estarjeta","");
		}
		//TARJETA PREPAGA
		if(ordenDao.getMedioDeCobro().esTarjetaPrePaga()){
			tmpDomicilios.setParam("esTarjetaPrepaga","true");
			double totalImporteParaOrden = 0.0;
			Vector tarjetas = ordenDao.getTarjetasPrepagas();
			//boolean hayNoHabilitada = false;
						
			Vector<Hashtable<String,Object>> vecTarjeasCargadas = new Vector<Hashtable<String,Object>>(tarjetas.size());
			Hashtable<String, Object> hasTarjeasCargadas = null;
			
			for (int i=0; i<tarjetas.size(); i++) {
				TarjetaPrepaga tarjeta = (TarjetaPrepaga)tarjetas.get(i);
				hasTarjeasCargadas = new Hashtable<String, Object>();
				hasTarjeasCargadas.put("estaHabilitada", tarjeta.estaHabilitada());
				hasTarjeasCargadas.put("numeroDeTarjetaPrepaga", tarjeta.getNro());
				hasTarjeasCargadas.put("importeDeTarjetaPrepaga", Contenido.precioToString(tarjeta.getImporteParaOrden()));
	    	    totalImporteParaOrden += tarjeta.getImporteParaOrden();
				if (!tarjeta.estaHabilitada()) {
					hasTarjeasCargadas.put("detalle", "(No habilitada)");
				}
				vecTarjeasCargadas.add(hasTarjeasCargadas);
			}
			tmpDomicilios.setParam("tarjetasCargadas", vecTarjeasCargadas);
			//monto total de las sumatoria de tarjetas prepagas.
			tmpDomicilios.setParam("totalTarjetasPrepagas",Contenido.precioToString(totalImporteParaOrden));
			if (ordenDao.getTotalMedioDeCobro() > totalImporteParaOrden) {
				tmpDomicilios.setParam("mensajeError", "No cuenta con saldo suficiente para realizar esta compra.");
			}
			
		}		
		
		//PROGRAMA EXTRA
		if (Globals.FIDELIZACION_VIGENTE) {
			//si tiene tarjeta extra
			if (ordenDao.getPuntajeWrapper() != null) {
				String nroTarjeta = Convert.toString(ordenDao.getNumeroTarjetaExtra());
				tmpDomicilios.setParam("nroTarjetaExtra", nroTarjeta);
				tmpDomicilios.setParam("titularTarjetaExtra", Convert.nombreCompleto(ordenDao.getPuntajeWrapper().getNombreSocio(), ordenDao.getPuntajeWrapper().getApellidoSocio()));
			}else{
				tmpDomicilios.setParam("nroTarjetaExtra", "Ninguno");
			}
		 }else{
			 tmpDomicilios.setParam("nroTarjetaExtra", "Ninguno");
		 }		
		
		//mail de envio de confirmacion.
		tmpDomicilios.setParam("mailConfirmacion", ServiceLocator.getSocioService().getLogin(pk));
		//si es modo release muestro el script de google
		if(Globals.esModoRelease()) {
			tmpDomicilios.setParam("esRelease", "true");
			tmpDomicilios.setParam("googleAnalyticsSSL", Globals.getGoogleAnalyticsSSL());
		}		
		
		//obtengo las pantallas anterior y siguiente en base a la que estoy parado
		Map<String, String> direcciones = null;
		direcciones = ProcesoCompraUtilImp.getInstance().getDirecciones(ProcesoCompraUtil.VISTA_PREVIA);	
		tmpDomicilios.setParam("pantallaAnterior", direcciones.get("anterior"));
		tmpDomicilios.setParam("pantallaSiguiente", direcciones.get("siguiente"));

		request.setAttribute("template",tmpDomicilios.output());
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		
		return mapping.findForward(frwRedirect);
	}	
	
	private static final void setDOmicilio(Template tmpDomicilios, DomicilioDAO domicilio,String tipo) {		
		tmpDomicilios.setParam("pais"+tipo,Convert.nombrePropio(domicilio.getPais().getNombre(),false));
		tmpDomicilios.setParam("provincia"+tipo,Convert.nombrePropio(domicilio.getProvincia().getNombre(),false));
		tmpDomicilios.setParam("localidad"+tipo,Convert.nombrePropio(domicilio.getLocalidad().getNombre(),false));
		tmpDomicilios.setParam("direccion"+tipo,Convert.nombrePropio(getDireccionFormateada(domicilio),false));		
		tmpDomicilios.setParam("codigoPostal"+tipo,Convert.nombrePropio(domicilio.getCodigoPostal(),false));
		
		if(domicilio.getPiso()!=null) {
			tmpDomicilios.setParam("piso"+tipo,",Piso "+domicilio.getPiso().toString());
		}
		if(domicilio.getDepto()!=null) {
			tmpDomicilios.setParam("depto"+tipo,",Dpto "+domicilio.getDepto());
		}
		if(domicilio.getEdificio()!=null) {
			tmpDomicilios.setParam("edificio"+tipo,",Edificio "+domicilio.getEdificio());
		}
		
	}

	public static final String getDireccionFormateada(DomicilioDAO domicilio) {
		StringBuffer direccion = new StringBuffer();
		if(domicilio.getCalle()!=null){
			direccion.append(domicilio.getCalle()).append(" ");			
		}
		if(domicilio.getNumero()!=null){
			direccion.append(domicilio.getNumero()).append(" ");
		}		
		if(domicilio.getEdificio()!=null){
			direccion.append(domicilio.getEdificio()).append(" ");
		}
		if(domicilio.getPiso()!=null){
			direccion.append(domicilio.getPiso()).append(" ");
		}			
		return direccion.toString();
	}
	
	/**
	 * Devuelve map con el nombre del mensaje, texto y nota asociada a una promocion
	 * @param cupon
	 * @return
	 */
	private static Map<String,String> getMensajeDePromocion(String cupon){
		Map<String, String> mensajes = new HashMap<String, String>(0);
		String texto = "Usted ha ingresado un Cheque Obsequio por un valor de VALOR_CUPON Si el monto de su compra fuera menor a los VALOR_CUPON la diferencia no ser&aacute; reembolsable ni podr&aacute; ser utilizada en otra compra.";
		String nota = "el monto total incluye, si los hubiera, gastos de env&iacute;o adicional  e intereses por pago en cuotas con tarjeta de cr&eacute;dito.";
		mensajes.put("nota", nota);
		//Cheque obsequio Monsanto $40
		if (cupon != null
				&& cupon.length() > 2 && 
				cupon.length() > 12 && 
				(cupon.substring(0,2).equals("37")|| cupon.substring(0,2).equals("99"))&& 
				Convert.toNumber(cupon.substring(8,12),new Long(0).longValue()) < 1401 ) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO MONSANTO");						
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $40 ")) ;
			return mensajes;
		}
		//Cheque obsequio Disco $100
		if (cupon != null && cupon.length() > 2 && (cupon.substring(0,2).equals("38"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO DISCO");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $100 ")) ;
			return mensajes;
		}
		//Cheque obsequio Monsanto $100
		if (cupon != null && cupon.length() > 12 && ((cupon.substring(0,10).equals("9800000000")) || cupon.substring(0,12).equals("980000000109") || cupon.substring(0,12).equals("980000000110"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO MONSANTO");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $100 ")) ;
			return mensajes;
		}
		//Cheque obsequio Monsanto $30
		if (cupon != null && cupon.length() > 12 && (cupon.substring(0,10).equals("9800000001") && !cupon.substring(0,12).equals("980000000109") )) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO MONSANTO");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $30 ")) ;
			return mensajes;
		}
		//Cheque obsequio Speedy $100
		if (cupon != null && cupon.length() > 2 && (cupon.substring(0,2).equals("97"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO SPEEDY");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $100 ")) ;
			return mensajes;
		}
		//Cheque obsequio Speedy $150
		if (cupon != null && cupon.length() > 2 && (cupon.substring(0,2).equals("96"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO SPEEDY");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $150 ")) ;
			return mensajes;
		}
		//Cheque obsequio Speedy $50
		if (cupon != null && cupon.length() > 12 && (cupon.substring(0,2).equals("94")) && !(cupon.substring(0,12).equals("940000000502")) && !(cupon.substring(0,12).equals("940000000501"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO SPEEDY");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $50 ")+"por su compra en SPEEDY.COM.AR") ;
			return mensajes;
		}
		//Cheque obsequio Speedy $200
		if (cupon != null && cupon.length() > 12 && (cupon.substring(0,2).equals("94")) && (cupon.substring(0,12).equals("940000000502"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO SPEEDY");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $200 ")+"por su compra en SPEEDY.COM.AR") ;
			return mensajes;
		}
		//Cheque obsequio Speedy $300
		if (cupon != null && cupon.length() > 2 && (cupon.substring(0,2).equals("94")) && (cupon.substring(0,12).equals("940000000501"))) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO SPEEDY");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $300 ")+"por su compra en SPEEDY.COM.AR") ;
			return mensajes;
		}
		//Cheque obsequio Monsanto $50
		if (cupon != null && cupon.length() > 12
				&& cupon.substring(0,2).equals("99")
				&& Convert.toNumber(cupon.substring(8,12),new Long(0).longValue()) >= 1401
				&& Convert.toNumber(cupon.substring(8,12), new Long(0).longValue()) <= 2150) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO MONSANTO");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $50 ")) ;
			return mensajes;
		}
		//Cheque obsequio ACCENTURE $50
		if (cupon != null && cupon.length() > 12
				&& cupon.substring(0,2).equals("99")
				&& Convert.toNumber(cupon.substring(8,12),new Long(0).longValue()) >= 1401
				&& Convert.toNumber(cupon.substring(8,12), new Long(0).longValue()) <= 2150) {
			mensajes.put("nombres", "CHEQUE OBSEQUIO ACCENTURE SRL");
			mensajes.put("texto", texto.replace("VALOR_CUPON", " $50 ")) ;
			return mensajes;
		}
		return null;		
	}
}
