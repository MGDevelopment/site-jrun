/**
 * $Log: OrdenFax.java,v $
 * Revision 1.7  2008/05/30 16:06:00  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.6  2007/09/03 13:42:20  msartori
 * no message
 *
 * Revision 1.5  2006/05/19 14:24:34  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.4  2005/01/25 15:53:02  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2005/01/04 15:30:46  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.2  2004/01/08 20:30:25  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.1  2003/10/28 00:22:08  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.5  2003/10/03 16:30:25  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.4  2003/09/22 17:37:24  NRodriguez
 * - Cantidad de registros por pagina y navegacion entre ellas
 *
 * Revision 1.3  2003/09/17 19:30:40  NRodriguez
 * - toma los parametros de la pagina correctamente
 *
 * Revision 1.2  2003/09/15 22:31:43  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.1  2003/09/11 20:32:56  NRodriguez
 * - controller para lo orden pagada via fax
 *
 */
package com.tmk.controllers.intranet.ordenes;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.MedioDeCobroDAO;
//import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;
import com.tmk.service.orden.OrdenService;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrdenFax extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TmkLogger.debug("Obtengo los datos de la orden por fax");

		int idOrden = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_), Integer.MIN_VALUE);
		String numeroTarjeta = request.getParameter(OrdenesHelper.CAMPO_NUMERO_TARJETA);
		String tipoTarjeta = request.getParameter(OrdenesHelper.CAMPO_TIPO_TARJETA);
		String titular = request.getParameter(OrdenesHelper.CAMPO_TITULAR);
		String codigoSeguridad = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_CODIGO), null);
		int mesVencimiento = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_MES), 0);
		int anoVencimiento = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ANO), 0);
		String tipoDocumento = request.getParameter(OrdenesHelper.CAMPO_TIPO_DOC);
		long numeroDocumento = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_NRO_DOC), (long) 0);
		String domicilioResumen = request.getParameter(OrdenesHelper.CAMPO_DOMICILIO_ENVIO);

		StringBuffer parametros = new StringBuffer("?");
		parametros.append(OrdenesHelper.CAMPO_ID_ORDEN_ + "=");
		parametros.append(idOrden + "&");
		parametros.append(OrdenesHelper.CAMPO_NUMERO_TARJETA + "=");
		parametros.append(numeroTarjeta + "&");
		parametros.append(OrdenesHelper.CAMPO_TIPO_TARJETA + "=");
		parametros.append(tipoTarjeta + "&");
		parametros.append(OrdenesHelper.CAMPO_TITULAR + "=");
		parametros.append(titular + "&");
		parametros.append(OrdenesHelper.CAMPO_CODIGO + "=");
		parametros.append(codigoSeguridad + "&");
		parametros.append(OrdenesHelper.CAMPO_MES + "=");
		parametros.append(mesVencimiento + "&");
		parametros.append(OrdenesHelper.CAMPO_ANO + "=");
		parametros.append(anoVencimiento + "&");
		parametros.append(OrdenesHelper.CAMPO_TIPO_DOC + "=");
		parametros.append(tipoDocumento + "&");
		parametros.append(OrdenesHelper.CAMPO_NRO_DOC + "=");
		parametros.append(numeroDocumento + "&");
		parametros.append(OrdenesHelper.CAMPO_DOMICILIO_ENVIO + "=");
		parametros.append(domicilioResumen + "&");

		try {
			// carga la orden vieja
			OrdenDAO ordenPendienteDAO = OrdenService.cargarOrden(idOrden);

			// Nuevo medio de cobro
			MedioDeCobroDAO nuevoMedioDeCobro = MedioDeCobroDAO.buscaMedioDeCobro(tipoTarjeta);

			// le agrega todos los campos pero le deja la forma de pago actual
			ordenPendienteDAO.completarDatosTarjeta(
			        numeroTarjeta, codigoSeguridad,
			        mesVencimiento, anoVencimiento,
			        titular, tipoDocumento, numeroDocumento,
			        domicilioResumen);

			// graba los cambios
			UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);
			OrdenService.cerrarOrdenConTarjeta(ordenPendienteDAO, nuevoMedioDeCobro, usuarioDAO.getNombres() + ", " + usuarioDAO.getApellidos());

			parametros.append(OrdenesHelper.CAMPO_INFORMACION + "=");
			parametros.append("La orden se completo correctamente");

		} catch (Exception e) {
			parametros.append(OrdenesHelper.CAMPO_ERROR + "=");
			parametros.append(e.getMessage());

            TmkLogger.info("Se produjo una excepcion al ingresar datos de la orden " + idOrden + ": " + e.getMessage());

		} finally {
			// Borra la orden del cache por los cambios que hizo
			OrdenService.borrarOrdenDelCache(new Integer(idOrden));

			response.sendRedirect(OrdenesHelper.PAGINA_PAGO_FAX + parametros.toString());
		}
	}
}
