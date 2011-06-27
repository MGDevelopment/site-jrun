/**
 * @author Lizardo Santiago
 *
 * $Log: EliminarProducto.java,v $
 * Revision 1.25  2009/03/25 15:11:25  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.24  2009/03/20 19:02:46  oClopez
 * cambio viernes
 *
 * Revision 1.23  2009/03/04 12:55:04  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.22  2008/05/30 16:05:49  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.21  2007/10/18 20:06:59  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.20  2007/02/13 13:18:11  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.19  2006/12/18 20:06:17  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.18  2006/09/14 18:25:00  omsartori
 * Promociones II
 *
 * Revision 1.17  2005/12/29 17:45:26  omsartori
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
 *
 * Revision 1.16  2005/12/13 16:16:45  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.15  2005/11/24 15:28:13  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.14  2005/11/04 12:55:41  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *

 *
 * Revision 1.11  2003/12/22 22:27:57  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.10  2003/12/11 20:53:30  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.9  2003/12/04 17:21:23  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/10/23 21:09:49  SLizardo
 * no message
 *
 */
package com.tmk.controllers.carrito;

import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.controllers.compra.CompraHelper;
//import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.controllers.CommonHelper;
import com.tmk.controllers.MainHelper;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.CarritoListaDeseosService;
import com.tmk.src.socio.SocioPK;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class EliminarProducto extends HttpServlet {

	private static int cantidadArticulosEliminados;

	public static int getCantidadArticulosEliminados() {
		return cantidadArticulosEliminados;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		synchronized (session) {
		SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
		OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
		Integer idArticulo = Convert.toNumber(request.getParameter(CommonHelper.ID_ARTICULO), (Integer) null);
		//por desarrollo de proceso nuevo
		if(idArticulo==null){
			idArticulo = Convert.toNumber(request.getParameter("idArticulo"), (Integer) null);
		}
		//fin
		if(ordenDAO==null ||idArticulo == null){
			response.sendRedirect("/index.jsp");
			return;
		}
		//borro promos
		ordenDAO.eliminarPromos();
		//borro gastos de envio
		ordenDAO.eliminarGastosDeEnvio();
		
        int posicionEnLista = Convert.toNumber(request.getParameter("posicionEnLista"), 0);

        if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
        	request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/carrito.jsp");
        	response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA );
			TmkLogger.info("REFERIDOS] No hay socio referente. ES SOCIO TMK Redireccion a registroSocioCadena");
			return;
		}

        
        ArticuloDAO articulo = ordenDAO.getArticuloById(idArticulo.intValue());
        if (articulo != null) {
			if (articulo.esParaListaDeseos()) {
				try {
					//bloque mio
					CarritoListaDeseosPK carritoPK = new CarritoListaDeseosPK(articulo.getSocioLDD().ID_SUCURSAL, articulo.getSocioLDD().ID_SOCIO, idArticulo);
					CarritoListaDeseosService servicio = ServiceLocator.getCarritoListaDeseosService();
					CarritoListaDeseos carritoDBO = servicio.findByPrimaryKey(carritoPK);
					carritoDBO.setEstado(0);
					servicio.update(carritoDBO);
					carritoDBO = null;
					//fin
				} catch (DBOInexistenteException ne) {
					TmkLogger.error(ne.getMessage());
				} catch (Exception fe) {
					TmkLogger.error(fe.getMessage());
				}
			}

			// mantiene el contador
			cantidadArticulosEliminados = cantidadArticulosEliminados + articulo.getCantidad();

	    	ordenDAO.removeArticuloByPosIDArticulo(posicionEnLista, idArticulo.intValue());
			if (socioPK != null) {
				ordenDAO.grabarCarritoCompra(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
			}


			/*Lo siguientes bloques contemplan la logica de medio de cobro*/
	        if(ordenDAO.tieneArticulos()) {
	        	if (ordenDAO.getMedioDeCobro() == null) {
		            // si no tengo medio de cobro borro todo lo que tenga que ver con tarjeta
		            ordenDAO.completarDatosTarjeta(null, null, 0, 0, null, null, 0, null);
		            ordenDAO.setTarjetaPlanDAO(null);
	            }
		        ordenDAO.setNRO_DOC_RECEPTOR(null);
		        ordenDAO.setTIPO_DOC_RECEPTOR(null);
		        ordenDAO.setRANGO_HORARIO_RECEPTOR(null);
	        }

			// recalcula gastos de envio, promociones, etc
			CompraHelper.recalcularConceptosFacturables(ordenDAO, socioPK);
        }
		String REFERER = request.getHeader("REFERER");
		response.sendRedirect((ordenDAO.tieneArticulos() && (REFERER != null)) ? REFERER : CompraHelper.PAGINA_HOME_SITIO);
	}
	}
}
