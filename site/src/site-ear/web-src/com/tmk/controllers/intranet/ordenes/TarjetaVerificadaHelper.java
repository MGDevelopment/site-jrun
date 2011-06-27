/**
 * $Log: TarjetaVerificadaHelper.java,v $
 * Revision 1.3  2007/04/26 18:32:53  omsartori
 * no message
 *
 * Revision 1.2  2004/03/03 22:33:55  NRodriguez
 * - correccion de bugs en base de tarjetas
 *
 * Revision 1.1  2003/10/28 00:22:10  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.1  2003/10/14 05:26:12  NRodriguez
 * - Base de tarjetas fraudulentas - tarjetas verificadas
 *
 */
package com.tmk.controllers.intranet.ordenes;

public class TarjetaVerificadaHelper {

	public static String NUMERO_TARJETA = "NUMERO_TARJETA";
	public static String NOMBRE_SOCIO = "NOMBRE_SOCIO";
	public static String APELLIDO_SOCIO = "APELLIDO_SOCIO";
    public static String EMAIL = "EMAIL";
	public static String CALLE_ENVIO = "CALLE_ENVIO";
	public static String NUMERO_ENVIO = "NUMERO_ENVIO";
	public static String EDIFICIO_ENVIO = "EDIFICIO_ENVIO";
	public static String PISO_ENVIO = "PISO_ENVIO";
	public static String DEPTO_ENVIO = "DEPTO_ENVIO";
	public static String CP_ENVIO= "CP_ENVIO";
	public static String CALLE_FACTURACION = "CALLE_FACTURACION";
	public static String NUMERO_FACTURACION = "NUMERO_FACTURACION";
	public static String EDIFICIO_FACTURACION = "EDIFICIO_FACTURACION";
	public static String PISO_FACTURACION = "PISO_FACTURACION";
	public static String DEPTO_FACTURACION = "DEPTO_FACTURACION";
	public static String CP_FACTURACION = "CP_FACTURACION";
	public static String NIVEL_RIESGO = "NIVEL_RIESGO";
    public static String COMENTARIOS = "COMENTARIOS";

	public static String CAMPO_ERROR = "CAMPO_ERROR";

	public static String PAGINA_ALTA = "/236-TMK/ordenes/agregarTarjetaVerificada.jsp";
	public static String PAGINA_CANDIDATOS = "/236-TMK/ordenes/tarjetaVerificada.jsp";
}
