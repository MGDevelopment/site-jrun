/**
 * $Log: OrdenesHelper.java,v $
 * Revision 1.3  2007/04/26 18:32:53  omsartori
 * no message
 *
 * Revision 1.2  2004/12/13 18:52:33  omsartori
 * - reporte de ordenes discriminado por medio de pago
 * - js para validar mail de hotmail en registro del socio
 *
 * Revision 1.1  2003/10/28 00:22:09  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.5  2003/10/10 18:42:39  NRodriguez
 * - Administracion de ordenes EFCO
 *
 * Revision 1.4  2003/09/22 17:37:24  NRodriguez
 * - Cantidad de registros por pagina y navegacion entre ellas
 *
 * Revision 1.3  2003/09/15 22:31:44  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.2  2003/09/11 20:32:15  NRodriguez
 * - iteracion sobre todas las ordenes
 *
 * Revision 1.1  2003/08/27 21:17:55  GPistoia
 * -Ordenes pendientes con tarjeta y sin tarjeta
 *
 * Revision 1.1  2003/08/27 18:44:02  GPistoia
 * -Comienzo Fraude
 *
 */
package com.tmk.controllers.intranet.ordenes;

import com.tmk.kernel.TmkLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrdenesHelper {

	public static String CAMPO_ID_ORDEN_ = "ID_ORDEN_";
	public static String CAMPO_ESTADO_ = "ESTADO_";
	public static String CAMPO_CANTIDAD_ORDENES = "CANTIDAD_ORDENES";
	public static String CAMPO_TIPO_TARJETA = "TIPO_TARJETA";
	public static String CAMPO_NUMERO_TARJETA = "NUMERO_TARJETA";
	public static String CAMPO_CODIGO = "CAMPO_CODIGO";
	public static String CAMPO_MES = "CAMPO_MES";
	public static String CAMPO_ANO = "CAMPO_ANO";
	public static String CAMPO_TITULAR = "CAMPO_TITULAR";
	public static String CAMPO_TIPO_DOC = "CAMPO_TIPO_DOC";
	public static String CAMPO_NRO_DOC = "CAMPO_NRO_DOC";
	public static String CAMPO_DOMICILIO_ENVIO = "CAMPO_DOMICILIO_ENVIO";

	public static String CAMPO_HORARIO = "CAMPO_HORARIO";
	public static String CAMPO_TELEFONO = "CAMPO_TELEFONO";
	public static String CAMPO_COMENTARIO = "CAMPO_COMENTARIO";

	public static String CAMPO_INFORMACION = "CAMPO_INFORMACION";
	public static String CAMPO_ERROR = "CAMPO_ERROR";

	public static String DEJAR_ESTADO = "DEJAR_ESTADO";

	public static String ADMNISTRACION = "ADMINISTRACION";
	public static String MEDIO_COBRO = "MEDIO_COBRO";
	public static String CANTIDAD_ORDENES = "CANTIDAD_ORDENES";
	public static String ORDEN_INICIAL = "ORDEN_INICIAL";

    public static String PAGINA_INICIO = "/236-TMK/ordenes/index.jsp";
	public static String PAGINA_PAGO_FAX = "236-TMK/ordenes/pagoPorFax.jsp";
	public static String PAGINA_PAGO_EFCO = "/236-TMK/ordenes/pagoEFCO.jsp";

	public static String MEDIO_DE_COBRO = "medioDeCobro";

	public static final void redirectTo(HttpServletRequest request, HttpServletResponse response, String page) throws IOException {
		response.sendRedirect(page);
	}

	public static final boolean continuaProceso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TmkLogger.debug("Verifica si tiene permisos...");
		// TODO FALTA IMPLEMENTAR LA PARTE DE PERMISOS Y ROLES
		/*if (NO TIENE PERMISOS) {
			redirectTo(request, response, "/index.jsp");
			return false;
		}*/
		return true;
	}

	public static final void proximoEstado(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// No continuar con este proceso
		if (!continuaProceso(request, response)) return;

		redirectTo(request, response, request.getHeader("REFERER"));
	}

}
