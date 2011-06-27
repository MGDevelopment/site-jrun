/**
 * $Log: TematikaInit.java,v $
 * Revision 1.43  2009/02/02 11:50:20  msartori
 * - Cambios Rediseño
 *
 * Revision 1.42  2009/01/16 19:33:19  oClopez
 * no message
 *
 * Revision 1.41  2009/01/15 12:35:52  msartori
 * no message
 *
 * Revision 1.40  2008/08/14 13:28:56  msartori
 * - Eliminacion de Report y ReportLauncher, se reemplaza por Runner.
 * - Metodo getAll para DBO, con posibilidad de cantidad y ordenamiento. Se elimina la sobreescritura, los parametros null no se tienen en cuenta
 * - Reporte de socios registrados, sin compras y registracion corta.
 *
 * Revision 1.39  2008/07/07 19:00:15  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.38  2008/01/24 20:28:54  msartori
 * no message
 *
 * Revision 1.37  2007/11/15 13:52:54  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.36  2007/10/18 20:07:08  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.35  2007/03/29 17:36:29  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.34  2007/02/16 19:35:57  omsartori
 * no message
 *
 * Revision 1.33  2007/02/16 18:41:09  omsartori
 * - schedule de generacion de ranking y top de familias
 * - correccion bug paginacion de lista de deseos
 * - filtro de palabras para buscador
 * - estadisticas de homes, biografias e indices
 * - correccion de bug de aprobacion de comentarios
 *
 * Revision 1.32  2007/02/13 13:18:12  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.31  2007/01/22 17:43:22  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.30  2007/01/09 15:29:53  omsartori
 * - Correcciones en articulo. Componentes Ajax. Generador de articulos
 *
 * Revision 1.29  2006/12/13 17:16:19  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.28  2006/11/27 13:04:11  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.27  2006/09/28 14:58:19  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.26  2006/06/22 18:31:44  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.25  2006/04/04 15:10:22  omsartori
 * - recordar la palabra de busqueda siempre
 * - correccion de resaltado busqueda avanzada
 * - cambio de textos informativos de resultado de busqueda
 * - nueva pagina de notas de prensa sin pop up y con tags de EMKT
 *
 * Revision 1.24  2006/03/22 15:01:02  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 * Revision 1.23  2006/02/20 12:38:26  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.22  2006/02/09 16:15:37  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.21  2006/01/31 15:51:36  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.20  2006/01/13 15:45:52  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.19  2006/01/11 17:37:22  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.18  2005/12/29 17:45:28  omsartori
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
 * Revision 1.17  2005/11/04 15:30:06  oDZurita
 * - Desacoplamiento de algunos componentes en las home de cada categoría.
 * - Generador del componente que permite generar contenidos estáticos.
 * - Modificación en las búsquedas por palabra clave.
 * - Modificaciones especificadas en el documento de marketing nº9
 * - Permitir la generación de los componentes estáticas a través de la intranet.
 * - Implementación de una tercer lista en la home de inicio, solo aplicable cuando está habilitada alguna de las categorías de Dromo.
 * - Correccion de la paginación en el resultado de una búsqueda.
 * - Captura del error en el detalle del producto por inexistencia del producto.
 *
 * Revision 1.16  2005/09/29 12:45:31  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.15  2004/06/15 20:57:36  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.14  2004/06/09 18:50:26  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.13  2004/05/14 19:19:15  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.12  2004/05/04 18:11:11  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.11  2003/12/22 22:28:02  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.10  2003/12/04 17:21:32  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/10/13 04:09:15  SLizardo
 * no message
 *
 */
package com.tmk.setup;

import com.tmk.controllers.buscador.BuscadorHelper;
import com.tmk.kernel.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Date;



public final class TematikaInit extends HttpServlet {

	public void init(ServletConfig servletConfig) throws ServletException {
		TmkLogger.info("--------------------------------------------------------");
		TmkLogger.info("INICIALIZACION: " + new Date());

		Class claseALevantar;

		claseALevantar = Daemon.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = XMLLoader.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = DBUtil.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = Convert.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = Globals.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = ImageServer.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		claseALevantar = Contenido.class;
		TmkLogger.info(claseALevantar.getName() + "... loaded");

		//opciones de busqueda
		BuscadorHelper.cargarOpcionDeBusqueda();

		//cargo las opciones de busqueda nuevas
		com.tmk.service.buscador.BuscadorHelper.cargarOpcionDeBusqueda();
        
		//claseALevantar = Launcher.class;
		Launcher.getInstance();
        TmkLogger.info(claseALevantar.getName() + "... loaded");

		TmkLogger.info("Inicializando el Servlet...");
		Contenido.setServletContext(servletConfig.getServletContext());
	}
}
