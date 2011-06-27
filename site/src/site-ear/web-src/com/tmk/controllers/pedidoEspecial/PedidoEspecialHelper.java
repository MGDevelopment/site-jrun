/**
 * $Log: PedidoEspecialHelper.java,v $
 * Revision 1.5  2005/09/22 18:38:51  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.4  2005/01/07 17:47:00  oGFritz
 * - Corrección del buscador por un error de js
 * - Reporte de compras por alianzas agregado
 * - Agregado de combo para opinionar sobre el pedido especial
 * -
 *
 * Revision 1.3  2003/10/14 08:53:31  GPistoia
 * -Mail configurable en pedido especial
 *
 * Revision 1.2  2003/08/19 19:27:30  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.1  2003/08/15 16:00:17  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 */
package com.tmk.controllers.pedidoEspecial;

public class PedidoEspecialHelper {

	public static String CAMPO_ARTICULO = "ID_ARTICULO";
	public static String CAMPO_TELEFONO = "TELEFONO";
	public static String CAMPO_HORARIO = "HORARIO";
	public static String CAMPO_COMENTARIO = "COMENTARIO";
	public static String CAMPO_ID_CONSULTA = "ID_CONSULTA";
	public static String CAMPO_ID_OPINION = "ID_OPINION";

	public static String CAMPO_SUCURSAL = "SUCURSAL";
	public static String CAMPO_SOCIO = "SOCIO";

	public static String SERVLET = "/PedidoEspecial";
	public static String SERVLET_ = SERVLET + "?" + CAMPO_ARTICULO + "=";
	public static String PAGINA_DATOS_ = "/miCuenta/pedidoEspecial.jsp?" + CAMPO_ARTICULO + "=";
	public static String PAGINA_CONFIRMACION = "/miCuenta/pedidoEspecialConfirmado.jsp";

}
