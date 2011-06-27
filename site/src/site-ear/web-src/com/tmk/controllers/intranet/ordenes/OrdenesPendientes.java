/**
 * $Log: OrdenesPendientes.java,v $
 * Revision 1.11  2008/05/30 16:06:00  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.10  2006/05/19 14:24:34  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.9  2005/07/05 13:20:46  omsartori
 * - Cambios en Referidos Finalizados
 *
 * Revision 1.8  2005/06/28 16:37:45  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.7  2005/04/26 17:32:09  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.6  2005/04/08 12:54:59  omsartori
 * - Consultas de Referidos
 * - Banner por seccinon configurable desde xml
 *
 * Revision 1.5  2005/02/23 13:45:33  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recuperacion del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.4  2005/02/18 13:15:37  omsartori
 * - Correccion en promociones, no enviaba el total de impuestos cuando era mas de un articulo, no grababa las promos sin impuestos.
 *
 * Revision 1.3  2005/02/17 12:14:24  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.2  2005/01/25 15:53:02  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.1  2003/10/28 00:22:10  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.5  2003/10/03 16:30:25  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.4  2003/09/15 22:31:44  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.3  2003/09/11 20:32:14  NRodriguez
 * - iteracion sobre todas las ordenes
 *
 * Revision 1.2  2003/09/05 19:57:08  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.1  2003/08/27 21:17:56  GPistoia
 * -Ordenes pendientes con tarjeta y sin tarjeta
 *
 * Revision 1.1  2003/08/27 18:44:03  GPistoia
 * -Comienzo Fraude
 *
 */
package com.tmk.controllers.intranet.ordenes;

import com.tmk.kernel.*;
import com.tmk.service.orden.OrdenService;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.controllers.intranet.admin.LoginIntranet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrdenesPendientes extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TmkLogger.info("Comienza proceso de cambio de estado de ordenes");

		// continuar con este proceso?
		if (!OrdenesHelper.continuaProceso(request, response)) return;

		// obtiene la cantidad de ordenes a procesar
		int cantidadOrdenes = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_CANTIDAD_ORDENES), 0);

		TmkLogger.info("Cantidad de ordenes: " + cantidadOrdenes);

		for (int i = 0; i < cantidadOrdenes; i++) {

			// orden actual

			String ordenStr = request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_ + i);

			if (ordenStr != null) {

				// numero de orden a cambiar
				int idOrden = Convert.toNumber(ordenStr, Integer.MIN_VALUE);

				try {
					// estado al cual tiene que cambiar
					String nuevoEstadoStr = request.getParameter(OrdenesHelper.CAMPO_ESTADO_ + idOrden);
					if ((nuevoEstadoStr == null) || (OrdenesHelper.DEJAR_ESTADO.equalsIgnoreCase(nuevoEstadoStr))) {
						TmkLogger.info("La Orden " + idOrden + " se deja en el estado actual.");

					} else {

						// Estado al cual debe pasar
						EstadoOrdenDAO estadoOrdenDAO = EstadoOrdenDAO.buscaEstadoOrden(nuevoEstadoStr);

						// Estado para los items
						EstadoItemOrdenDAO estadoItemOrdenDAO = estadoOrdenDAO.estadoItemsRelacionado();

						// aplica el cambio de estado
						UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);
						OrdenService.cambiarEstadoDeOrden(idOrden, estadoOrdenDAO, estadoItemOrdenDAO, usuarioDAO.getNombres() + ", " + usuarioDAO.getApellidos());


						if (Globals.referidoHabilitado()) {
							if (nuevoEstadoStr.equals(Globals.ESTADO_ORDEN_APROBADA.getId())) {
								Integer id_orden =  new Integer (idOrden);
								ReferidoManager.setCompraReferido(id_orden);
								//ReferidoManager.setCompraReferente(id_orden);
							} else {
								if (nuevoEstadoStr.equals(Globals.ESTADO_ORDEN_RECHAZADA.getId())) {
									Integer id_orden =  new Integer (idOrden);
									ReferidoManager.eliminaOrdenReferido (id_orden);
								//	ReferidoManager.eliminaOrdenReferente(id_orden);
								}
							}

						}
					}

    			} catch (Exception e) {
					TmkLogger.error("No se pudo cargar los datos de la orden " + idOrden);
				}
			}
		}

		OrdenesHelper.proximoEstado(request, response);
	}

}
