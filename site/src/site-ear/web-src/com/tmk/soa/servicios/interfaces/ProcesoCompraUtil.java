package com.tmk.soa.servicios.interfaces;

import java.util.Map;

/**
 * Contiene todas las constantes del proceso de compras:
 * path de templates, constantes de nombres de servlet, action struts
 * contiene el mapa de recorrido que es un hasmap que indica recorrido hacia atras y adelante
 * @author oclopez
 */
public interface ProcesoCompraUtil {
	//NOMBRE DE LAS JSP QUE INTERVIENEN EN EL FLUJO DE COMPRA
	public final String PAGINA_HOME_SITIO   = "/index.jsp";
	public final String PAGINA_REGISTRACION = "/miCuenta/index.jsp";
	public final String CARRITO_COMPRAS 	= "/compra/carrito.do";
	public final String PAPEL_REGALO 		= "/compra/papelDeRegalo.do";
	public final String ENTREGA  			= "/compra/domicilio.do";
	public final String FORM_ENTREGA  		= "javascript:document.frm.submit();";
	public final String MEDIO_DE_PAGO  		= "javascript:submitDireccion(document.frmDireccion);";
	public final String VISTA_MEDIO_DE_PAGO = "/compra/medioDeCobro.do";
	public final String VISTA_PREVIA		= "/compra/vistaPrevia.do";
	public final String CONFIRMACION		= "javascript:validarMedioCobro();";
	public final String PAGINA_MI_CUENTA    = "/miCuenta/";
	public static final String PAGE_REGISTRO_SOCIO_CADENA = "/miCuenta/registroSocioCadena.jsp";
		
	public static String PAGINA_FAX                 = "/compra/pagoPorFax.jsp";
	
	public static String PAGINA_DETALLE_COMPRA_     = "/compra/confirmacion.do?idOrden=";
	public static String PAGINA_PAGO_CON_FALLAS     = "/compra/pagoConFallas.jsp";
	public static String PAGINA_ORDEN_MI_CUENTA     = "/compra/misOrdenes.jsp";
	
	//PATH DE SERVLETS
	public final String ELIMINAR_ARTICULO = "tmpCarrito";
	/**
	 * Obtiene las direcciones anterior y siguiente que le corresponde a una pantalla dentro del flujo de compra.
	 * @param poscionActual
	 * @return Map<String,String> que indica las pantallas anterior y siguiente.
	 */
	public Map<String, String> getDirecciones(String poscionActual);
	
}
