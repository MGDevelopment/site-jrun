/**
 * $Log: ConfirmarCompra.java,v $
 * Revision 1.33  2009/03/04 12:55:04  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.32  2009/01/15 12:35:46  msartori
 * no message
 *
 * Revision 1.31  2008/09/12 20:02:36  msartori
 * no message
 *
 * Revision 1.30  2008/09/02 19:42:20  msartori
 * - DBO select soportando campos hijos DBO y campos hijos array de DBO
 *
 * Revision 1.29  2008/05/30 16:05:52  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.28  2007/10/18 20:07:00  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.27  2007/09/03 13:42:16  msartori
 * no message
 *
 * Revision 1.26  2006/09/14 18:25:01  omsartori
 * Promociones II
 *
 * Revision 1.25  2006/02/09 16:15:35  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.24  2006/01/13 15:45:51  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.23  2005/12/29 17:45:27  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por código como por palabra.
 *    Se modificó el orden de las tarjetas en el plan de pago del detalle artículo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepción del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para órdenes que contengan artículos de Dromo.
 *
 * * Se filtró la localidad “ciudad autónoma de Buenos Aires” del listado de localidades válidas para tmk.
 *
 * * Doc Empro 10

 * - Grabación de hasta 2 formas de pago para la misma orden de compra.
 *
 * Revision 1.21  2005/10/14 16:05:32  omsartori
 * - Correccion en grabacion de orden de referente
 *
 * Revision 1.20  2005/06/28 16:37:43  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.19  2005/05/26 14:45:27  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.18  2005/02/23 13:45:29  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recuperacion del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.17  2005/02/17 12:14:23  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.16  2004/03/25 18:19:53  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.15  2004/01/06 15:29:49  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.14  2003/10/07 14:56:26  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.13  2003/09/08 13:54:45  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.12  2003/09/05 19:57:08  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.11  2003/09/04 21:40:02  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.10  2003/08/26 16:19:35  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.9  2003/08/25 20:46:27  SLizardo
 * Optimize Imports
 *
 * Revision 1.8  2003/08/21 17:48:38  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.7  2003/08/14 14:40:02  SLizardo
 * Se actualizo el Logger (Globals. a TmkLogger.)
 *
 * Revision 1.6  2003/08/13 18:51:57  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.5  2003/08/12 16:26:10  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.4  2003/08/07 18:10:25  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.3  2003/08/06 21:29:27  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.2  2003/08/04 22:17:58  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:32  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.orden.TarjetaPrepagaException;
import com.tmk.service.orden.OrdenService;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.src.socio.SocioPK;
import com.tmk.bus.socio.AlertaCompraSocios;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.controllers.carrito.CarritoUtil;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

public class ConfirmarCompra extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		TmkLogger.debug("Comienzo Confirmar Compra");
		HttpSession session = request.getSession();
		
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		
		OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");

		// Volver a la pagina si no corresponde
		if (!CompraHelper.continuaProceso(request, response, ordenDAO)) return;

		// Si se confirma y no tiene gastos, vuelve a la pantalla de confirmacion (a pedido)
		//si es la suscripcion pasa directamente.
        //if (!ordenDAO.tieneGastoBasico()) {
		if (!ordenDAO.tieneGastoBasico() && !CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))) {
			CompraHelper.proximoEstado(request, response, ordenDAO);
			return;
    	}
		
		try {
			// Como puede ocurrir en simultaneo, bloquea el segundo o tercer click, para no generar más de una orden
			synchronized (ordenDAO) {

				// Si llega a estar ya grabada, entonces sale (es solo en el caso de doble click)
				if (!CompraHelper.verificaOrdenAbierta(request, response, ordenDAO)) {
					TmkLogger.info("Orden #" + ordenDAO.getIdOrdenProcesada() + " ya fue grabada, se evito la duplicacion.");
					return;
				}

			    Integer idAlianza = (Integer) session.getAttribute(EstadisticaVisitas.ID_ALIANZA_SITIO);
				Integer idSeccion = ((Integer) session.getAttribute(EstadisticaVisitas.ID_SECCION_SITIO) == null)? new Integer(1):(Integer) session.getAttribute(EstadisticaVisitas.ID_SECCION_SITIO);
				Integer idAlianzaCookie = (Integer) session.getAttribute(EstadisticaVisitas.COOKIE_ID_ALIANZA);
				Integer idSeccionCookie = ((Integer) session.getAttribute(EstadisticaVisitas.COOKIE_ID_SECCION) == null)? new Integer(1):(Integer) session.getAttribute(EstadisticaVisitas.COOKIE_ID_SECCION);

				Integer alianzaOrden = idAlianza;
				Integer seccionOrden = idSeccion;
				if (alianzaOrden == null) {
					alianzaOrden = idAlianzaCookie;
					seccionOrden = idSeccionCookie;
				}

				if (alianzaOrden == null) {
					seccionOrden = null;
				}

				ordenDAO.setAlianza(alianzaOrden, seccionOrden);

				// Comienza la grabación protegida
				OrdenService.grabarOrden(ordenDAO, socioPK);
				//BLOQUE PARA ENVIO DE MAIL ALTERNATIVO
				String emailAlternativo = request.getParameter("emailAlternativo"); 
				if(emailAlternativo !=null && emailAlternativo.trim().length() > 0 && MainHelper.esEMail(emailAlternativo)){
					try{
						MailUtil.sendMail(
						        Globals.MAIL_CALL_CENTER,
						        emailAlternativo,
						        " Compra en " + Globals.NOMBRE_DEL_SITIO,
						        "Su compra ha sido recibida y comenzará a ser procesada a la brevedad. Muchas Gracias.",
						        "/mailing/confirmacionDeOrden.jsp?idOrden=" + ordenDAO.getIdOrdenProcesada());
						//lo guardo para mostrarlo despues en la pantalla de confirmacion
						request.getSession().setAttribute("email2", emailAlternativo);
					}catch(Exception e){
						TmkLogger.error("No se puedo enviar el mail a la direccion alternativa "+ emailAlternativo);
					}
				}				
				//FIN BLOQUE
				
				//BLOQUE PARA CERRAR LOS DATOS DEL MAPA DE COMPRA
				
				HashMap<String, Object> mapaDeDatos = (HashMap<String, Object>)request.getSession().getAttribute("mapaDeDatos");
				if(mapaDeDatos != null && mapaDeDatos.size() > 0 ){ 
					mapaDeDatos.put("fechaFinalizacion", new java.util.Date(System.currentTimeMillis()));
					mapaDeDatos.put("idOrden", ordenDAO.getIdOrdenProcesada());
					//boolean esProcesoNuevo = request.getSession().getAttribute("procesoDeCompraNuevo")!=null && request.getSession().getAttribute("procesoDeCompraNuevo").equals("true");
					boolean esProcesoNuevo = ProcesoCompraUtilImp.getInstance().esProcesoNueo(request);
					mapaDeDatos.put("esProcesoNuevo", esProcesoNuevo ? "Si" : "No");
					ProcesoCompraUtilImp.getInstance().guardarLoginConSuMapa((String)mapaDeDatos.get("login"), mapaDeDatos);
					request.getSession().removeAttribute("mapaDeDatos");
				}
				
				//FIN
				
				//PROGRAMA DE REFERIDOS
				// solo va a setear una de las dos
				ReferidoManager.setOrdenReferente(request, new Integer(ordenDAO.getIdOrdenProcesada()));
				ReferidoManager.setOrdenReferido(request, new Integer(ordenDAO.getIdOrdenProcesada()));
				//PROGRAMA DE REFERIDOS

				//Alerta de compra de socios
				try {
					Connection conn = DBUtil.buildConnection();
					try {
						Vector socio = AlertaCompraSocios.getALL(conn, new String[] {"acs.id_socio= " + socioPK.ID_SOCIO.toString(),
									"acs.id_sucursal= " + socioPK.ID_SUCURSAL.toString()});
						if (socio.size()>0) {
							AlertaCompraSocios acs = (AlertaCompraSocios)socio.get(0);
							try {
								//encontre el socio envio la alerta
								StringBuffer msg = new StringBuffer("");
								msg.append("Se ha registrado una compra en alerta.").append(Globals.ENTER);
								msg.append("Orden: ").append(ordenDAO.getIdOrdenProcesada()).append(Globals.ENTER);
								msg.append("Socio: ").append(acs.getIdSucursal().toString()).append("-");
								msg.append(acs.getIdSocio().toString()).append(Globals.ENTER).append("Nombre: ");
								msg.append(acs.getNombres()).append(" ").append(acs.getApellidos());

								MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_TARJETAS_VERIFICADAS, "Alerta de compra" , msg.toString());
							} catch (Exception e) {
								TmkLogger.error("Error en envio de alerta de compra]Envio de mail " + e.toString() + MainHelper.getMessage(e));
							}
						}
					} catch (Exception e) {
						TmkLogger.error("Error en envio de alerta de compra] Busqueda de socio " + e.toString() + MainHelper.getMessage(e));
					} finally {
						conn.close();
					}

				} catch (Exception e) {
					TmkLogger.error("Error en envio de alerta de compra] Conexion " + e.toString() + MainHelper.getMessage(e));
				}
				//Alerta de compra de socios
			}


			// Siguiente estado
			CompraHelper.proximoEstado(request, response, ordenDAO);

			// Borra la orden actual para no dejar ningun rastro en el server
			TmkLogger.info("Orden #" + ordenDAO.getIdOrdenProcesada() + " grabada y eliminada de la session.");
			session.removeAttribute("ordenDAO");

		} catch (TarjetaPrepagaException e) {
			TmkLogger.error(e.getMensajeAMostrar());
			CompraHelper.setAttribute(request, CompraHelper.CODIGO_ERROR, e.getMessage());
			CompraHelper.redirectTo(response, CompraHelper.PAGINA_PAGO_CON_FALLAS);
			return;
		} catch (Exception e) {
			TmkLogger.error(e.getMessage());
			CompraHelper.setAttribute(request, CompraHelper.CODIGO_ERROR, e.getMessage());
			CompraHelper.redirectTo(response, CompraHelper.PAGINA_PAGO_CON_FALLAS);
			return;
		}
		TmkLogger.debug("Fin Confirmar Compra");
	}

}
