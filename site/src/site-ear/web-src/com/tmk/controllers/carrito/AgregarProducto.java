/**
 * $Log: AgregarProducto.java,v $
 * Revision 1.51  2009/04/08 15:48:00  oClopez
 * modificaciones sobre feed back
 *
 * Revision 1.50  2008/05/30 16:05:47  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.49  2008/04/09 20:20:16  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.48  2008/01/24 20:28:51  msartori
 * no message
 *
 * Revision 1.47  2007/12/18 20:11:50  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.46  2007/09/03 13:42:13  msartori
 * no message
 *
 * Revision 1.45  2007/07/11 15:00:53  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.44  2007/05/28 19:21:13  omsartori
 * Buscador de inicio para todas las categorias deshabilitado
 * Estadísticas
 *      Se diferencias los resultados de busqueda de la siguiente forma
 *           Consultas correctas
 *           Consultas sin resultado
 *           Consultas timeout (fuera de tiempo)
 *           Consultas con error
 * Se discriminan los resultados de búsqueda por buscador
 * Circuito de prueba, se agregó la tarjeta nro 1234432112344321 como tarjeta de prueba para poder realizar el testeo de compra con tarjeta de crédito completo.
 * Aprobación de órdenes, se agregó un log para contabilizar la aprobación de cada item, para facilitar el seguimiento.
 * Se modificó el proceso de genereación de homes para sincronizar con la nueva versión de la tarea de subida de contenido de eclipse.
 *
 * Revision 1.43  2007/02/13 13:18:10  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.42  2006/12/13 17:16:17  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.41  2006/11/27 13:04:09  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.40  2006/11/08 15:41:07  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.39  2006/10/12 14:59:10  omsartori
 * no message
 *
 * Revision 1.38  2006/10/09 13:05:52  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.37  2006/09/14 18:25:00  omsartori
 * Promociones II
 *
 * Revision 1.36  2005/12/29 17:45:26  omsartori
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
 * Revision 1.35  2005/11/24 15:28:13  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.34  2005/11/22 20:49:58  oDZurita
 * - se implemento en el detalle del articulo la busqueda por id de autor en los recomendados y en ver mas productos del autor.
 * - se implemento en las biografias la busqueda por id de autor
 * - correccion del nombre de la editorial del link al sitio
 * - correccion en el tamaño de las imagenes mostradas en la primer lista de las homes.
 *
 * Revision 1.33  2005/11/14 13:47:54  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.32  2005/11/04 14:45:33  omsartori
 * no message
 *
 * Revision 1.31  2005/11/04 12:55:41  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.27  2005/10/04 19:59:56  omsartori
 * - correccion reporte beneficios referente
 * - Seguimiento empro, visitas por canal
 *
 * Revision 1.26  2005/09/22 18:38:49  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.25  2005/09/12 20:06:27  omsartori
 * - Promo Dia de la madre.
 *      - config por xml.
 *      - pantalla de carga.
 *      - validacion y grabacion.
 * - EJB reducido en homes de Categorias.
 *
 * Revision 1.24  2005/08/29 12:30:14  omsartori
 * - Redireccionamiento de dominio configurable.
 * - Campo comentario agregado en mail de tarjetas verificadas.
 * - Correccion tamanio de imagenes en ranking.
 *
 * Revision 1.23  2004/11/18 21:16:19  omsartori
 * - Carrito puede recibir + de un artículo a la vez y una pagina para redireccionar
 *
 * Revision 1.22  2004/07/12 19:52:05  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.21  2003/12/22 22:27:57  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.20  2003/12/11 20:53:29  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.19  2003/12/04 17:21:23  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.18  2003/11/27 01:57:48  GPistoia
 * -Gasto de envio no tenia impuestos
 *
 * Revision 1.17  2003/11/26 15:38:12  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.16  2003/11/03 20:57:28  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.15  2003/10/23 21:09:48  SLizardo
 * no message
 *
 * Revision 1.14  2003/10/07 14:56:24  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.13  2003/10/06 21:57:07  SLizardo
 * no message
 *
 * Revision 1.12  2003/10/06 14:17:58  SLizardo
 * Update Socios
 *
 * Revision 1.11  2003/10/03 16:30:16  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.10  2003/09/11 18:09:46  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.9  2003/09/08 13:54:44  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.8  2003/08/25 20:46:19  SLizardo
 * Optimize Imports
 *
 * Revision 1.7  2003/08/21 21:12:57  SLizardo
 * no message
 *
 * Revision 1.6  2003/08/19 19:27:28  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.5  2003/08/13 18:51:58  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.4  2003/08/11 14:26:53  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.3  2003/08/09 22:54:57  SLizardo
 * no message
 *
 * Revision 1.2  2003/08/08 20:13:46  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.1  2003/08/08 00:17:42  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.controllers.carrito;

import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.bus.articulo.ListaDeseos;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.controllers.filter.DateFilter;
import com.tmk.controllers.CommonHelper;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.src.listadeseos.ListaDeseosPK;
//import com.tmk.listaDeseos.*;
import com.tmk.setup.ImageServer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.ejb.FinderException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
//import java.util.Collection;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;

public class AgregarProducto extends HttpServlet {

	private static int cantidadArticulosAgregados;

	public static int getCantidadArticulosAgregados() {
		return cantidadArticulosAgregados;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Mantiene datos de alianzas y demás
		EstadisticaVisitas.mantenerEstadistica(request, response);

		boolean home = Convert.toBoolean(request.getParameter("home"), false);

        String idArticulo = Convert.toString(request.getParameter(CommonHelper.ID_ARTICULO),
			        Convert.toString(request.getParameter("ARTICULO"),
		                Convert.toString(request.getParameter("ID_PRODUCTO"), // por compatibilidad hacia atras
		                                 null)));
        String error="";

        String tituloArticulo = "";
        String pathImagen = "";
        String precio = "";
        String pagina = Convert.toString(request.getParameter(CommonHelper.PAGINA), null);
        String msgCarritoAdicional = "";
        //Si no se recibe idarticulo, no se agrega ningun producto, POR AHORA
		if (idArticulo == null) {
			response.sendRedirect("/index.jsp");
			return;
		}

       
		int [] idArticulos = Convert.toNumbers(idArticulo);

		try {
			SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
			OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
			if (ordenDAO == null) {
				ordenDAO = new OrdenDAO();
				session.setAttribute("ordenDAO", ordenDAO);
			}
//			borro promos
			ordenDAO.eliminarPromos();
			//borro gastos de envio
			ordenDAO.eliminarGastosDeEnvio();

            for (int i = 0; i < idArticulos.length; i++)
            {
                ArticuloDAO articuloDAO = new ArticuloDAO(idArticulos[i]);

				if (request.getParameter("ID_SUCURSAL") != null && request.getParameter("ID_SOCIO") != null) {
					Integer ID_SUCURSAL_SOCIO = Convert.toNumber(request.getParameter("ID_SUCURSAL"), (Integer)null);
					Integer ID_SOCIO = Convert.toNumber(request.getParameter("ID_SOCIO"), (Integer)null);
					articuloDAO.setSocioListaDD(new com.tmk.socio.SocioPK(ID_SUCURSAL_SOCIO, ID_SOCIO));

					//ListaDeseosLocalHome listaHome = (ListaDeseosLocalHome) DBUtil.getHome("ListaDeseos");
					//ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
					//ListaDeseosLocal lista = listaHome.findByPrimaryKey(listaPK);

					//bloque agregado
					ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
					ListaDeseos listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
					//fin
									
					//bloque agregado
					CarritoListaDeseosPK carritoPK = new CarritoListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO, new Integer (idArticulos[i]));
					CarritoListaDeseos carritoDBO = new CarritoListaDeseos(carritoPK);
					carritoDBO.setEstado(1);
					ServiceLocator.getDboService().update(carritoDBO);
					//fin
					
					if (listaDBO.getTipo_domicilio() != null) {
						articuloDAO.setSocioListaDD(new com.tmk.socio.SocioPK(ID_SUCURSAL_SOCIO, ID_SOCIO));
						//DomicilioDAO domicilioLDD = DomicilioDAO.load(ID_SUCURSAL_SOCIO, ID_SOCIO, lista.getTIPO_DOMICILIO());
						DomicilioDAO domicilioLDD = DomicilioDAO.load(ID_SUCURSAL_SOCIO, ID_SOCIO, listaDBO.getTipo_domicilio());
						if (domicilioLDD.esEnvio()) {
							ordenDAO.setDomicilioListaDeDeseos(domicilioLDD);
						} else {
							// no se puede mandar a una direccion que no sea de envio
							String message = "La dirección cargada en la lista no es domicilio de envio, suc: " + ID_SUCURSAL_SOCIO + " socio: " + ID_SOCIO;
							TmkLogger.error(message);
							MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, "Fallo en Lista de Deseos", message);
						}
					} else {
						// No tiene tipo_domicilio (hay muchos asi en la base)
						String message = "El producto de la lista no tiene tipo_domicilio, suc: " + ID_SUCURSAL_SOCIO + " socio: " + ID_SOCIO;
						TmkLogger.error(message);
						MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, "Fallo en Lista de Deseos", message);
					}
				}
				//Chequeo de disponibilidad
				if (!articuloDAO.tieneDisponibilidad()) {
					TmkLogger.error("AGREGARPRODUCTO] Intento de cargar en carrito articulo sin disponibilidad");
					if (home) {
						error = "El artículo que ud. quiere agregar a su carrito no tiene stock. Comuniquese con nuestro centro de atención para realizar un pedido especial.";
						StringBuffer destino = new StringBuffer("/componentes/comunes/responseCarrito.jsp?clave=");
						destino.append(Math.random()*Math.random());
						destino.append("&error=");
						destino.append(URLEncoder.encode(error,  "ISO-8859-1"));
						response.sendRedirect(destino.toString());
						return;
					} else {
						response.sendRedirect("/componentes/msgArticuloSinStock.jsp");
						return;
					}
				}

                // mantiene el contador
				cantidadArticulosAgregados++;
				ordenDAO.addArticulo(articuloDAO, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
				tituloArticulo = articuloDAO.getTitulo();

//				PARA PROMOCION ESPECIFICA
				boolean filtroPromoOK = false ;
				try {
					DateFilter dateFilter = new DateFilter("13/04/2008", "15/05/2008");
					dateFilter.execute();
					filtroPromoOK = dateFilter.isSuccess();
				} catch (Exception e) {
					TmkLogger.debug(e.toString() + MainHelper.getMessage(e));
				}

				if (articuloDAO.getId() == 461239 && filtroPromoOK) {
					ArticuloDAO articuloPromocionado = new ArticuloDAO(468792);
					ordenDAO.addArticulo(articuloPromocionado, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
					msgCarritoAdicional = "Se ha agregado el Diccionario de Expresiones Latinas sin cargo hasta el 14 de Mayo";
				}
				//PARA PROMOCION ESPECIFICA


//				PARA PROMOCION ESPECIFICA
				filtroPromoOK = false;
				try {
					DateFilter dateFilter = new DateFilter("17/04/2008", "01/06/2008");
					dateFilter.execute();
					filtroPromoOK = dateFilter.isSuccess();
				} catch (Exception e) {
					TmkLogger.debug(e.toString() + MainHelper.getMessage(e));
				}

				if ((articuloDAO.getId() == 465831 || articuloDAO.getId() == 466757) && filtroPromoOK) {
					ArticuloDAO articuloPromocionado = new ArticuloDAO(375337);
					ordenDAO.addArticulo(articuloPromocionado, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
					msgCarritoAdicional = "Se ha agregado 100 Mamiferos Argentinos sin cargo hasta el 31 de Mayo";
				}
//				PARA PROMOCION ESPECIFICA


				pathImagen = ImageServer.obtenerNombreDeTapa(articuloDAO.getId(), true, articuloDAO.getCategoriaSeccion(), 0, "", false);
				if (pathImagen == null || pathImagen.equals("")) {
					pathImagen = ImageServer.obtenerNombreDeTapa(articuloDAO.getId(), false, articuloDAO.getCategoriaSeccion(), 0, "", false);
				}
				if (pathImagen == null || pathImagen.equals("")) {
					pathImagen = ImageServer.nombreArticuloSinImagen(false, articuloDAO.getCategoriaSeccion());
				}
				DecimalFormat precioFormat = new DecimalFormat("#.00");
				precio = precioFormat.format(articuloDAO.getPrecioSitio());

            }
		    // calcula gasto de envio y demas
				CompraHelper.recalcularConceptosFacturables(ordenDAO, socioPK);

                if(request.getHeader("Referer") != null && request.getHeader("Referer").indexOf("confirmacion.jsp") != -1){
                    CompraHelper.proximoEstado(request, response, ordenDAO);
                }
			//} catch (FinderException fe) {
				//error = "El artículo que ud. quiere agregar a su carrito no existe en nuestro catálogo. Comuniquese con nuestro centro de atención.";
			} catch (Exception e) {
				error = "Error inesperado al agregar el artículo a su carrito. Comuniquese con nuestro centro de atención.";
				TmkLogger.error(e.toString());
		    }
        //indica la página destino.
		String referer = request.getHeader("REFERER");
        if (pagina != null) {
			referer = pagina;
		}
		else {
			if ((referer == null) || (referer.indexOf(Globals.PAGINA_SITIO) < 0) || (idArticulos.length > 1)) {
				referer = "/compra/carrito.jsp";
			}
		}
		if (home) {
			StringBuffer destino = new StringBuffer("/componentes/comunes/responseCarrito.jsp?clave=");
			destino.append(Math.random()*Math.random());
			destino.append("&titulo=");
			destino.append(URLEncoder.encode(tituloArticulo, "ISO-8859-1"));
			destino.append("&imagen=");
			destino.append(URLEncoder.encode(pathImagen, "ISO-8859-1"));
			destino.append("&error=");
			destino.append(URLEncoder.encode(error,  "ISO-8859-1"));
			destino.append("&precio=");
			destino.append(URLEncoder.encode(precio,  "ISO-8859-1"));
			destino.append("&msg=");
			destino.append(URLEncoder.encode(msgCarritoAdicional,  "ISO-8859-1"));
			response.sendRedirect(destino.toString());
		} else {
			response.sendRedirect(referer);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet (request, response);
	}
}
