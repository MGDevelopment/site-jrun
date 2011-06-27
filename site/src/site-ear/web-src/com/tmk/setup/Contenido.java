/**
 * $Log: Contenido.java,v $
 * Revision 1.103  2008/07/07 19:00:13  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.102  2008/05/30 16:06:17  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.101  2007/11/15 13:52:49  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.100  2007/09/03 13:42:22  msartori
 * no message
 *
 * Revision 1.99  2007/05/09 18:18:04  omsartori
 * * Busqueda de Inicio: Al aplicar un criterio de ordenamiento se mantiene la apertura de busquedas por sección, en la versión anterior la busqueda se acotaba a la última sección mostrada.
 * * Aprobación de Ordenes Intranet: Se agrego un chequeo para evitar la doble aprobación desde la intranet que genera movimientos duplicados en central.
 * * Validación de Formularios: Se agrego el foco de retorno en la validación de los siguientes formularios
 *                                             Carga de Comentarios
 *                                             Alta de Alianzas
 * * Orden de Autores: Se modificaron todas las consultas para mostrar en Tematika el mismo orden de autores que viene dado por comercial. (Se regenerarán los articulos involucrados luego de la implementación en productivo)
 * * Carrito de Compras: Se activo nuevamente el carrito de compras con tecnología ajax, que cambia de color cuando se agrega un artículo y evita la necesidad de recargar la página.
 * * Seguimiento de sesiones: Se corrigio la fecha de creación, ahora se toma la fecha dada por el servidor de aplicación para evitar diferencias con la fecha de base de datos.
 * * Directorio de acceso a intranet: Se modificó el directorio de acceso a intranet por requerimiento de seguridad junto con sus respectivos links, el directorio actual es /236-TMK
 *
 * Revision 1.98  2007/03/29 17:36:29  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.97  2006/12/29 13:27:15  oLSuarez
 * Detalle de Articulo:
 *    *linksDeContenido.jsp
 *
 * Modificaciones en ArticuloManager:
 * Nuevos metodos:
 *   * tieneBiografia()
 *   * tieneNotaDePrensa()
 *   * tienePrimerCaptitulo()
 *   * tieneEntrevista()
 *
 * Revision 1.96  2006/11/27 13:04:10  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.95  2006/08/14 13:29:24  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.94  2006/05/03 18:17:04  omsartori
 * - Modificacion de formulario de envio de CV
 * - Modificacion del proceso de generacion de detalles para commit
 * - proceso de indices a DB
 *
 * Revision 1.93  2006/03/22 15:01:01  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 *
 * Revision 1.92  2006/03/06 15:38:16  omsartori
 * - Medios de cobro VMA y MNA
 * - Indice de contenidos
 * - URL configurable para generacion
 *
 * Revision 1.91  2005/12/29 17:24:56  oDZurita
 * - interfaz para la generación estática de los detalles de artículos.
 * - modificaciones en el método de búsqueda de detalle de artículos.
 * - uso del sleep en el daemon de generación de detalles de articulos.
 * - creación del daemon para la generación de los recorrido de familias.
 * - corrección en las consultas de los mas vendidos.
 * - creación del servlet para la generación estática de los recorridos de familias.
 * - interfaz para la generación estática de los recorridos de familias.
 *
 * Revision 1.90  2005/12/13 16:16:45  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.89  2005/12/06 17:52:18  oDZurita
 * - uso de una sola imagen en los encabezados de las listas de la homes.
 * - reemplazo de la consulta para generar el árbol para el recorrido de las categorías.
 * - invocacion del componente de comentarios desde detalleArticulos.jsp y no desde c/detalle de las secciones.
 *
 * Revision 1.87  2005/08/16 16:09:27  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.86  2005/06/28 16:37:49  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.85  2005/05/26 14:45:29  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.84  2005/02/10 14:27:36  omsartori
 * - Habilitacion de referidos por xml
 * - Referidos: envio, reconocimiento y registro
 * - Cupones de referido y referente configurables por xml
 * - Cupon de registro configurable por xml
 *
 * Revision 1.83  2005/01/24 15:21:42  omsartori
 * - Cambio en archivo de contenido, en configuracion flag de solapasEnMultilinea, diasIgnoradosNovedad, y se renombró el flag diaConsideradoNovedad por diasConsideradosNovedad.
 * - Se modficó solapas.jsp para soportar multilinea
 *
 * Revision 1.82  2005/01/18 19:46:13  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.81  2005/01/11 15:14:02  oGPistoia
 * - Buscador de Novedades
 *
 * Revision 1.80  2005/01/04 15:30:47  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.79  2004/12/02 22:39:59  oGPistoia
 * - Queda aprobada la matriz de estados
 *
 * Revision 1.78  2004/12/02 22:23:03  oGPistoia
 * - PreRelease Agendas.
 * - Eliminacion de productos via XML porque se reemplaza por estado_articulos
 *
 * Revision 1.77  2004/11/30 22:19:26  oGPistoia
 * - Aplicacion de las reglas de estados de articulos
 * - Agregado de las novedades en el catalogo de eXtra
 *
 * Revision 1.76  2004/11/01 16:33:21  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.75  2004/10/13 17:51:49  oGPistoia
 * - Listado de promociones que vencen
 * - Reemplazo de las tapas que no pueden cargarse
 * - Salida de eXtra a produccion
 *
 * Revision 1.74  2004/10/05 21:29:46  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.73  2004/09/30 14:17:29  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.72  2004/09/23 18:45:11  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.71  2004/09/14 17:22:26  omsartori
 * Bug de imagenes con tam erroneos
 * Bug de direcciones (otra localidad, otra provincia)
 * Bug de inicio de sesion (link a pagina null)
 *
 * Revision 1.70  2004/09/10 15:13:26  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.69  2004/09/07 16:15:43  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.68  2004/08/03 15:48:50  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.67  2004/07/08 20:19:07  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.66  2004/07/05 15:44:17  oGPistoia
 * - Release 1.80 (y cambios menores)
 *
 * Revision 1.65  2004/06/30 18:23:42  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.64  2004/06/15 20:57:35  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.63  2004/06/09 18:50:24  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.62  2004/05/14 19:19:13  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.61  2004/05/04 18:11:11  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.60  2004/04/06 22:22:44  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.59  2004/03/25 18:19:56  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.58  2004/03/04 18:52:57  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.57  2004/02/27 13:44:54  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.56  2004/02/16 20:24:23  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.55  2004/02/11 19:34:36  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.54  2004/01/06 15:29:51  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.53  2003/12/22 22:28:01  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.52  2003/12/11 20:53:33  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.51  2003/12/04 17:21:31  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.50  2003/11/26 15:38:18  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.49  2003/11/13 20:11:49  GPistoia
 * -Cambio de direccion para generacion de mail por temas de firewall
 * -Extensibilidad en detalles de articulos para agregar html del usuario
 * -Mejora en pantalla de estado de ordenes
 * -Sincronizacion de estadisticas
 *
 * Revision 1.48  2003/11/11 17:52:14  GPistoia
 * -No muestra biografias habilitado si no hay biografias
 * -Correccion de link erroneo del dreamweaver
 *
 * Revision 1.47  2003/11/07 15:33:09  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.46  2003/10/28 01:40:26  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.45  2003/10/23 19:05:58  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.44  2003/10/21 22:05:42  GPistoia
 * -Arreglo de Formato
 * -Arreglo de recomendar solo disponibles
 * -Arreglo de recorrido por temas de solo disponibles.
 * -Arreglo solo 5 autores recomendados.
 *
 * Revision 1.43  2003/10/17 12:10:52  GPistoia
 * -Saque [mus]
 * -Revise promociones.
 *
 * Revision 1.42  2003/10/15 19:07:08  SLizardo
 * no message
 *
 * Revision 1.41  2003/10/13 18:15:06  NRodriguez
 * - Columna gris o no segun parametro en grupos
 *
 * Revision 1.40  2003/10/12 22:12:27  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.39  2003/10/12 15:02:48  NRodriguez
 * - Lo que Nacho llama "grupos"
 *
 * Revision 1.38  2003/10/07 16:29:16  GPistoia
 * -Correccion en contenido
 *
 * Revision 1.37  2003/09/30 20:17:10  GPistoia
 * -Cambios en site.xml para mejorar la configurabilidad.
 *
 * Revision 1.36  2003/09/29 17:21:07  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.35  2003/09/29 16:42:09  NRodriguez
 * - Administrador de contenido version 2
 *
 * Revision 1.34  2003/09/24 23:13:58  GPistoia
 * -Modificacion de descuento de articulo porque puede ser positivo.
 * -Modificacion de contenido con N paginas o solapas principales
 *
 * Revision 1.33  2003/09/24 21:22:33  SLizardo
 * no message
 *
 * Revision 1.32  2003/09/23 13:56:09  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.31  2003/09/17 19:32:18  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.30  2003/09/15 22:31:45  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.29  2003/09/11 18:09:48  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.28  2003/09/09 18:29:37  JMembrives
 * detalle articulo
 *
 * Revision 1.27  2003/09/09 13:28:40  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.26  2003/09/08 15:24:50  GPistoia
 * -Mejoras de pais-provincia-localidad terminadas
 *
 * Revision 1.25  2003/09/05 19:57:09  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.24  2003/09/04 21:40:04  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.23  2003/09/02 21:08:35  GPistoia
 * -Release 0.4
 *
 * Revision 1.22  2003/09/02 14:23:26  GPistoia
 * -Imagenes de productos grandes
 * -Campos en Articulo
 *
 * Revision 1.21  2003/09/01 13:54:59  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.20  2003/08/29 17:55:19  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.19  2003/08/27 18:44:03  GPistoia
 * -Comienzo Fraude
 */
package com.tmk.setup;

import com.tmk.articulo.ArticuloLocal;
import com.tmk.articulo.ArticuloLocalHome;
import com.tmk.kernel.*;
import com.tmk.kernel.server.types.ModoType;
import com.tmk.kernel.site.*;
import com.tmk.service.orden.OrdenService;

import javax.servlet.ServletContext;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.exolab.castor.xml.Marshaller;


public final class Contenido extends Daemon implements XMLLoader.Listener {

	private static final String DIRECTORIO_IMAGENES = "/imagenes";
	private static final String DIRECTORIO_ASOCIADAS = "/asociadas";
	private static final String DIRECTORIO_CAPITULOS = DIRECTORIO_ASOCIADAS + "/capitulos";
	private static final String DIRECTORIO_INDICES = DIRECTORIO_ASOCIADAS + "/indices";
	
	/*migrar a ArticuloManager*/
	//private static final String DIRECTORIO_BIOGRAFIAS = DIRECTORIO_ASOCIADAS + "/biografias";
	private static final String DIRECTORIO_ENTREVISTAS = DIRECTORIO_ASOCIADAS + "/entrevistas";
	private static final String DIRECTORIO_NOTAS_PRENSA = DIRECTORIO_ASOCIADAS + "/notasDePrensa";
	
	private static final String DIRECTORIO_EXTENSIONES = DIRECTORIO_ASOCIADAS + "/extensiones";
	
	
	private static final String EXTENSION_TXT = ".txt";
	
	private static final int IMAGE_SMALL_SIZE = 181;

	public static final int CANTIDAD_ITEMS_MAS_VENDIDOS = 5;

	public static final String URL_GRUPO = "URL_GRUPO";
	public static final String COSTADO_GRUPO = "COSTADO";
	public static final String HEADER_GRUPO = "HEADER_GRUPO";

	private static ServletContext servletContext;

	private static Site site;

	// cache para los mas vendidos
	//private static Hashtable masVendidos = new Hashtable();

	// guarda los hits por cada pagina
    public int hitsPorPagina[] = new int[0];

	/**
	 * El objeto del xml del sitio
	 */
	public static final Site getSite() {
		return site;
	}

	/** Hits por pagina */
	public int[] getHitsPorPagina() {
		return hitsPorPagina;
	}

	public void incrementaVisitaPagina(int indice) {
        hitsPorPagina[indice]++;
	}

	public static final Pagina getPagina(int seccion) {
		Paginas paginas = site.getPaginas();
		for (int i = 0; i < paginas.getPaginaCount(); i++) {
			Pagina pagina = paginas.getPagina(i);
			if (pagina.getId() == seccion) {
				return pagina;
			}
		}
		return null;
	}

	public static final String getLogo() {
		return site.getConfiguracion().getLogo();
	}

	public static final String getMensajeLogo() {
		return site.getConfiguracion().getMensajeLogo();
	}

	public static final void setServletContext(ServletContext servletContext) {
		Contenido.servletContext = servletContext;
	}

	public static final ServletContext getServletContext() {
		return servletContext;
	}

	public static final String sumarDirectorio(String originalDir, String originalFile) {
		return new StringBuffer(originalDir).append("/").append(originalFile).toString();
	}

	// Si el archivo no existe pone otro
	private static final String ensureFileExists(String originalDir, String originalFile, String defaultFile) {
		// No deberia ser nulo
		if (servletContext == null) {
			// confia en que la imagen original está
			return defaultFile;
		} else {
			String filePath = sumarDirectorio(originalDir, originalFile);
			File file = new File(servletContext.getRealPath(filePath));
			// intenta cargar la imagen sino pone una default
			return (file.exists()) ? filePath : ((defaultFile == null) ? null : sumarDirectorio(originalDir, defaultFile));
		}
	}

	/**
	 * Fecha de cuando un producto es considerado novedad
	 */
	private static final Date fechaComparacion() {
		Date fechaComparacion = new Date();
		fechaComparacion.setDate(fechaComparacion.getDate() - Globals.DIAS_CONSIDERADOS_NOVEDAD);
		return fechaComparacion;
	}

	public static final boolean esNovedad(ArticuloLocal articuloLocal) {
		Date fechaAlta = articuloLocal.getFECHA_ALTA();
		return ((fechaAlta != null) && (fechaAlta.after(fechaComparacion())));
	}

	// Si el archivo no existe pone otro
	static final String cargaImagenChica(int idArticulo) {
		ArticuloLocal articuloLocal = getArticulo(idArticulo);
		boolean esNovedad = esNovedad(getArticulo(idArticulo));
		return imageServer.obtenerNombreDeTapa(idArticulo, true, articuloLocal.getCATEGORIA_SECCION().intValue(), articuloLocal.getPORCENTAJE_DESCUENTO().intValue(), null, esNovedad);
	}

	// Si el archivo no existe pone otro
	static final String cargaImagenGrande(int idArticulo) {
		ArticuloLocal articuloLocal = getArticulo(idArticulo);
		boolean esNovedad = esNovedad(getArticulo(idArticulo));
		return imageServer.obtenerNombreDeTapa(idArticulo, false, articuloLocal.getCATEGORIA_SECCION().intValue(), articuloLocal.getPORCENTAJE_DESCUENTO().intValue(), null, esNovedad);
	}

	// Si el archivo no existe pone otro
	private static final String cargaImagen(int idArticulo, boolean priorizarGrande) {
		String image = (priorizarGrande) ? cargaImagenGrande(idArticulo) : cargaImagenChica(idArticulo);
		if (image == null && Globals.esModoRelease()) {
			image = (!priorizarGrande) ? cargaImagenGrande(idArticulo) : cargaImagenChica(idArticulo);
		}
		if (image == null) {
			ArticuloLocal articulo = getArticulo(idArticulo);
			boolean esNovedad = esNovedad(getArticulo(idArticulo));
			int seccion = articulo.getCATEGORIA_SECCION().intValue();
			image = (Globals.seccionHabilitada(seccion))
			        ? imageServer.nombreArticuloSinImagen(esNovedad, articulo.getCATEGORIA_SECCION().intValue())
			        : imageServer.nombreArticuloSinImagen(esNovedad);
			return image;
		}
		return image;
	}

	/**
	 * Existe el archivo de tapa chica
	 */
	public static final boolean tieneTapaChica(int idArticulo) {
		return imageServer.tieneTapa(idArticulo, true);
	}

	/**
	 * Existe el archivo de tapa grande
	 */
	public static final boolean tieneTapaGrande(int idArticulo) {
		return imageServer.tieneTapa(idArticulo, false);
	}

	/**
	 * Retorna el string con la imagen pero con el path completo
	 */
	public static final String getTapa(String originalDir, String originalFile, String defaultFile) {
		return ensureFileExists(originalDir, originalFile, defaultFile);
	}


	/**
	 * Retorna el string con la imagen del articulo
	 */
	public static final String getTapa(int idArticulo, int ancho, int alto) {
		return getTapa(idArticulo, (ancho > IMAGE_SMALL_SIZE) && (alto > IMAGE_SMALL_SIZE));
	}

	/**
	 * Retorna el string con la imagen del articulo
	 */
	public static final String getTapa(Producto producto, int ancho, int alto) {
		return getTapa(producto, (ancho > IMAGE_SMALL_SIZE) && (alto > IMAGE_SMALL_SIZE));
	}

	/**
	 * Retorna el string con la imagen del articulo
	 */
	public static final String getTapa(int idArticulo, boolean priorizarGrande) {
		return cargaImagen(idArticulo, priorizarGrande);
	}

	/**
	 * Retorna el string con la imagen del articulo
	 */
	public static final String getTapa(Producto producto, boolean priorizarGrande) {
		return (producto.getIcono() == null)
		        ? getTapa(producto.getId(), priorizarGrande)
		        : getTapa(DIRECTORIO_IMAGENES, producto.getIcono(), null);
	}

	/**
	 * Retorna el string con la imagen del link
	 */
	public static final String getImagen(Link link) {
		return ensureFileExists(DIRECTORIO_IMAGENES, link.getIcono(), imageServer.nombreArticuloSinImagen(false));
	}

	/**
	 * Retorna el string con la imagen del link
	 */
	public static final String getImagen(NivelDeRiesgoDAO nivelDeRiesgoDAO) {
		String imageName = "nivelDeRiesgo";
		String extension = ".gif";
		return ensureFileExists(DIRECTORIO_IMAGENES, imageName + nivelDeRiesgoDAO.getId() + extension, imageName + extension);
	}

	/** Retorna el texto contenido en un archivo */

	private static final String loadFileContent(String fileName, String finDeLinea) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(servletContext.getRealPath(fileName)));
			try {
				StringBuffer buffer = new StringBuffer();
				while (reader.ready()) {
					buffer.append(reader.readLine()).append(finDeLinea);
				}
				return buffer.toString();
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			return "No Disponible";
		}
	}

	public static final String getAyuda(Link link) {
		return Convert.htmlEscape((link.getHint() == null) ? link.getTexto() : link.getHint());
	}

	public static final String getAyuda(Producto producto) {
		StringBuffer text = new StringBuffer(getTitulo(producto));

		if (producto.getHint() != null) {
			text.append(". ").append(Globals.ENTER);
			text.append(producto.getHint());
		} else if (producto.getTexto() != null) {
			text.append(". ").append(Globals.ENTER);
			text.append(producto.getTexto());
		}

		return Convert.htmlEscape(text.toString());
	}

	/**
	 * Retorna el string del link
	 */
	public static final String getPagina(Link link) {
		return link.getPagina();
	}

	/**
	 * Retorna el string del texto
	 */
	public static final String getTexto(Link link) {
		return Convert.htmlEscape(link.getTexto());
	}

	// Si debe mostrar el detalle del producto o no
	public static boolean tieneDetalleDisponible(int idArticulo) {
		int categoria = Convert.toNumber(Contenido.getArticulo(idArticulo).getCATEGORIA_SECCION(), Integer.MAX_VALUE);
		return Globals.seccionHabilitada(categoria);
	}

	/**
	 * Retorna el titulo
	 */
	public static final String getTitulo(Producto producto) {
		return getTitulo(producto.getId());
	}

	/**
	 * Retorna el titulo
	 */
	public static final String getTitulo(Producto producto, int size) {
		return getTitulo(producto.getId(), size);
	}

	/**
	 * Retorna el titulo
	 */
	public static final String getTitulo(int idProducto) {
		return Convert.corregir(getArticulo(idProducto).getTITULO(), true);
	}

	/**
	 * Retorna el titulo
	 */
	public static final String getTitulo(int idProducto, int size) {
		return Convert.toString(getTitulo(idProducto), size);
	}

	/** Da el link a la pagina asociada */
	public static final String getPaginaAsociada(int idArticulo) {
		String result = ensureFileExists(DIRECTORIO_EXTENSIONES, idArticulo + ".htm", null);
		return (result == null) ? null : loadFileContent(result, "");
	}

	
	/**
	 * Devuelve el indice del libro
	 */
	public static final String getIndice(ArticuloLocal articulo) {
		String result = ensureFileExists(DIRECTORIO_INDICES, articulo.getID_ARTICULO() + EXTENSION_TXT, null);
		return (result == null) ? null : loadFileContent(result, "<br>");
	}

	public static boolean tieneIndice(Integer idArticulo, String ISBN) {
		File file1 = new File(servletContext.getRealPath(sumarDirectorio(DIRECTORIO_INDICES, idArticulo + ".txt")));
		File file2 = new File(servletContext.getRealPath(sumarDirectorio(DIRECTORIO_INDICES, "ISBN_" + ISBN + ".html")));
        return (file1.exists() || file2.exists());
	}

	public static String getIndice (Integer idArticulo, String ISBN) {
		File file2 = new File(servletContext.getRealPath(sumarDirectorio(DIRECTORIO_INDICES, "ISBN_" + ISBN + ".html")));
		if (file2.exists()) {
			return  loadFileContent(sumarDirectorio(DIRECTORIO_INDICES, "ISBN_" + ISBN + ".html"),"<br>&nbsp;");
		} else {
			File file1 = new File(servletContext.getRealPath(sumarDirectorio(DIRECTORIO_INDICES, idArticulo + ".txt")));
			return loadFileContent(sumarDirectorio(DIRECTORIO_INDICES, idArticulo + ".txt"),"<br>");
		}
	}

	/**
	 * Devuelve el primer capitulo del libro
	 */
	public static final String getPrimerCapitulo(ArticuloLocal articulo) {
		try {
			String result = ensureFileExists(DIRECTORIO_CAPITULOS, articulo.getID_ARTICULO() + EXTENSION_TXT, null);
			return (result == null) ? articulo.getPRIMER_CAPITULO() : loadFileContent(result, "<br>");
		} catch (Exception e) {
			return null;
		}
	}



	public static final String getEntrevistas(ArticuloLocal articulo) {
		try {
			String result = ensureFileExists(DIRECTORIO_ENTREVISTAS, articulo.getID_ARTICULO() + EXTENSION_TXT, null);
			return (result == null) ? null : loadFileContent(result, "<br>");
		} catch (Exception e) {
			return null;
		}
	}

	public static final String getEntrevistas(int idArticulo) {
		try {
			String result = ensureFileExists(DIRECTORIO_ENTREVISTAS, idArticulo + EXTENSION_TXT, null);
			return (result == null) ? null : loadFileContent(result, "<br>");
		} catch (Exception e) {
			return null;
		}
	}
	
	public static final String getNotasDePrensa(ArticuloLocal articulo) {
		try {
			StringBuffer full = new StringBuffer();
			// Agrega nota de la base
			if (articulo.getCRITICA() != null) full.append(articulo.getCRITICA());
			// Variable temporal de archivo disponible
			int i = 0;
			String temp = null;
			do {
				// Nombre del archivo
				String nombreDeArchivo = articulo.getID_ARTICULO() + ((i == 0) ? "" : ("_" + i))+ EXTENSION_TXT;
				// Carga el archivo
				temp = ensureFileExists(DIRECTORIO_NOTAS_PRENSA, nombreDeArchivo, null);
				// Pasa al proximo
				i++;
				// Agrega la nota anterior
				if (temp != null) {
					full.append(Globals.ENTER).append(Globals.ENTER);
					full.append("<strong>").append("Nota número ").append(i).append(": ").append("</strong>");
					full.append("<br><br>");
					full.append(loadFileContent(temp, "<br>"));
					full.append("<br><br>");
				}
			} while (temp != null);
			return (full.length() > 10) ? full.toString() : null;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Retorna el valor del producto
	 */
	public static final double getPrecioSitio(Producto producto) {
		return getPrecioSitio(producto.getId());
	}

	/**
	 * Retorna el valor del producto
	 */
	public static final double getPrecioSitio(int idProducto) {
		return getArticulo(idProducto).getPRECIO_SITIO().doubleValue();
	}

	/**
	 * Retorna el texto del detalle correspondiente
	 */
	public static final String getSinopsis(Producto producto) {
		return Convert.htmlEscape((producto.getTexto() == null) ? getSinopsis(producto.getId()) : producto.getTexto());
	}

	/**
	 * Retorna el texto del detalle correspondiente
	 */
	public static final String getSinopsis(int idProducto) {
		return getArticulo(idProducto).getSINOPSIS();
	}

	/**
	 * Retorna el texto del detalle correspondiente
	 */
	/*public static final String getAutores(int idProducto, int size) {
		ArticuloLocal articulo = getArticulo(idProducto);
		Vector autores = articulo.getAUTORES();
		if ((autores == null) || (autores.isEmpty())) return "&nbsp;";
		if (autores.size() == 1) return Convert.nombrePropio(Convert.toString(autores.firstElement().toString(), size));
		return "Varios";
	}*/

	/**
	 * Retorna el importe en moneda
	 */
	public static final String precioToString(double precio) {
		return Convert.PESO_FORMAT.format(precio);
	}

	/**
	 * Retorna el importe en moneda
	 */
	public static final String precioDollarToString(double precio) {
		return Convert.DOLLAR_FORMAT.format(precio / Globals.TASA_DOLLAR);
	}

	/**
	 * Retorna el importe en moneda
	 */
	public static final String precioEuroToString(double precio) {
		return Convert.EURO_FORMAT.format(precio / Globals.TASA_EURO);
	}

	/**
	 * Retorna el porcentaje
	 */
	public static final String porcentajeToString(double valor) {
		return Convert.PERCENT_FORMAT.format(valor);
	}

	public static String getBannerCategoria(int idSeccion, int idGrupo, int idFamilia, int idSubFamilia) {
		Pagina pagina = getPagina(idSeccion);
		
		if (pagina.getBannerCatalogo() != null && pagina.getBannerCatalogo().getBannerCatalogoItemCount()>0) {
			BannerGrupo bannerGrupo[] = pagina.getBannerCatalogo().getBannerCatalogoItem(0).getBannerGrupo();
			if (bannerGrupo != null) {
				for (int i=0; i<bannerGrupo.length; i++) {
					if (bannerGrupo[i].getId() == idGrupo) {
						if (idFamilia == -1) {
							return bannerGrupo[i].getUrl();
						} else {
							if (bannerGrupo[i].getBannerGrupoItemCount()>0) {
								BannerFamilia bannerFamilia[] = bannerGrupo[i].getBannerGrupoItem(0).getBannerFamilia();
								if (bannerFamilia != null) {
									for (int j=0; j<bannerFamilia.length; j++) {
										if (bannerFamilia[j].getId() == idFamilia) {
											if (idSubFamilia == -1) {
												return bannerFamilia[j].getUrl();
											} else {
												if (bannerFamilia[j].getBannerFamiliaItemCount()>0) {
													BannerSubFamilia bannerSubFamilia[] = bannerFamilia[j].getBannerFamiliaItem(0).getBannerSubFamilia();
													if(bannerSubFamilia != null) {
														for (int k=0; k<bannerSubFamilia.length; k++) {
															if (bannerSubFamilia[k].getId() == idSubFamilia) {
																return bannerSubFamilia[k].getUrl();
															}
														}
													}	
												}
											}
										}
									}
								}	
							}
						}
					}
				}	
			}
		}	
		return "";
	}
	
	/**
	 * Da las editoriales segun el nivel
	 */
	public static final Claves getClaves(Integer idSeccion, Integer idGrupo, Integer idFamilia) {
		RecorridoSecciones secciones = site.getRecorridoPorTemas().getRecorridoSecciones();
		if ((idSeccion != null) && (secciones != null)) {
			for (int s = 0; s < secciones.getRecorridoSeccionCount(); s++) {
				RecorridoSeccion seccion = secciones.getRecorridoSeccion(s);
				if ((seccion.getId() == idSeccion.intValue())) {
					RecorridoGrupos grupos = seccion.getRecorridoGrupos();
					if ((idGrupo != null) && (grupos != null)) {
						for (int g = 0; g < grupos.getRecorridoGrupoCount(); g++) {
							RecorridoGrupo grupo = grupos.getRecorridoGrupo(g);
							if ((grupo.getId() == idGrupo.intValue())) {
								RecorridoFamilias familias = grupo.getRecorridoFamilias();
								if ((idFamilia != null) && (familias != null)) {
									for (int f = 0; f < familias.getRecorridoFamiliaCount(); f++) {
										RecorridoFamilia familia = familias.getRecorridoFamilia(f);
										if (familia.getId() == idFamilia.intValue()) {
											//if (familia.getClaves() != null) return familia.getClaves(); A PEDIDO DEL USUARIO EL 24/06/2004
											return familia.getClaves();
										}
									}
								}
								//if (grupo.getClaves() != null) return grupo.getClaves(); A PEDIDO DEL USUARIO EL 24/06/2004
								return grupo.getClaves();
							}
						}
						//if (grupos.getClaves() != null) return grupos.getClaves(); A PEDIDO DEL USUARIO EL 24/06/2004
						return grupos.getClaves();
					}
					// if (seccion.getClaves() != null) return seccion.getClaves(); A PEDIDO DEL USUARIO EL 24/06/2004
					return seccion.getClaves();
				}
			}
			// if (secciones.getClaves() != null) return secciones.getClaves(); A PEDIDO DEL USUARIO EL 24/06/2004
			return secciones.getClaves();
		}
		return secciones.getClaves();
	}

	/**
	 * Retorna el articulo esperado para el producto
	 */
	public static final ArticuloLocal getArticulo(Producto producto) {
		return getArticulo(producto.getId());
	}

	/**
	 * Retorna el Articulo segun su Id
	 */
	public static final ArticuloLocal getArticulo(Integer value) {
		return (value == null) ? getArticulo(Globals.ARTICULO_DEFAULT) : getArticulo(value.intValue());
	}

	/**
	 * Retorna el Articulo segun su Id
	 */
	public static final ArticuloLocal getArticulo(int value) {
		try {
			ArticuloLocalHome articuloHome = (ArticuloLocalHome) DBUtil.getHome("Articulo");
			ArticuloLocal articulo = articuloHome.findByPrimaryKey(new Integer(value));
			return articulo;

		} catch (Exception e) {
			TmkLogger.debug("Retorno Default por no encontrar " + value);
			return (Globals.ARTICULO_DEFAULT == value) ? null : getArticulo(Globals.ARTICULO_DEFAULT);
		}
	}

   

	private static final String XML_FILE = "\\contenido\\site.xml";
	private static final String XSD_FILE = "site.xsd";

	/** Graba el archivo de contenido */
	public static final boolean saveFile() {
		try {
			FileWriter fileWriter = new FileWriter(Globals.DIRECTORIO_APLICACION  + XML_FILE);
			try {
				Marshaller marshaller = new Marshaller(fileWriter);
				marshaller.setEncoding("ISO-8859-1");
				marshaller.setNoNamespaceSchemaLocation(XSD_FILE);
				marshaller.marshal(site);
				return true;

			} finally {
				fileWriter.close();
			}

		} catch (Exception e) {
			MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR,
			        Globals.NOMBRE_DEL_SITIO + " - Generacion de Contenido",
			        "Fallo al tratar de grabar el archivo de configuracion.");
			return false;
		}
	}

	public static Contenido getInstance() {
		if (instance == null) {
			instance = new Contenido();
		}
		return instance;
	}

	public static XMLLoader getXmlLoader() {
		return xmlLoader;
	}

	public void reloadContent() {
		// Fuerza a recargar el archivo
		xmlLoader.reload();
	}

	/** Instancia del contenido */
	private static Contenido instance = new Contenido();

	private static XMLLoader xmlLoader;

	// Guarda la referencia al generador de imagenes
	private static ImageServer imageServer = new ImageServer();

	/** Es estatica */
	private Contenido() {
		// Constructor del demonio
		super(Daemon.AHORA, Daemon.SEIS_HORAS);

		// Se asegura de inicializar el procesador de imagenes
		ImageServer.inicializar();

		// Modulo de LOG aun lo cargado
		TmkLogger.info("Inicializando Contenido...");

		try {
			// queda funcionando como hilo
			xmlLoader = new XMLLoader(Globals.DIRECTORIO_APLICACION + XML_FILE, this);

			// Modulo de LOG aun lo cargado
			TmkLogger.info("Contenido inicializado.");

			// ahora permite cargar datos de la aplicacion
			Globals.MODO_ACTUAL = ModoType.INICIALIZACION;

		} catch (Exception e) {
			// Modulo de LOG aun lo cargado
			TmkLogger.info("No se pudo inicializar el servicio de XML. Error " + e.getMessage());
			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_REPORTE_DE_CONTENIDO,
					Globals.NOMBRE_DEL_SITIO + " - Carga de Contenido",
					"Fallo al tratar de cargar el XML de Contenido.");
		}

	}

	public void onLoaded(FileReader fileReader) throws Exception {

		// Carga el objeto de configuracion
		site = com.tmk.kernel.site.Site.unmarshal(fileReader);

		// Para llevar el conteo de las paginas
		if (hitsPorPagina.length != site.getPaginas().getPaginaCount()) {
			hitsPorPagina = new int[site.getPaginas().getPaginaCount()];
		}

		synchronized (Globals.SECCIONES) {
			for (int i = 0; i < site.getPaginas().getPaginaCount(); i++) {
				Globals.habilitarSeccion(site.getPaginas().getPagina(i).getId(), true);
			}
		}

		Convert.PESO_FORMAT = new DecimalFormat(site.getConfiguracion().getFormatos().getMonedaPeso());
		Convert.DOLLAR_FORMAT = new DecimalFormat(site.getConfiguracion().getFormatos().getMonedaDollar());
		Convert.EURO_FORMAT = new DecimalFormat(site.getConfiguracion().getFormatos().getMonedaEuro());
		Convert.PERCENT_FORMAT = new DecimalFormat(site.getConfiguracion().getFormatos().getPorcentaje());
		Convert.SHORT_DATE_FORMAT = new SimpleDateFormat(site.getConfiguracion().getFormatos().getFechaCorto());
		Convert.LONG_DATE_FORMAT = new SimpleDateFormat(site.getConfiguracion().getFormatos().getFechaLargo());
		Convert.PUBLICATION_DATE_FORMAT = new SimpleDateFormat(site.getConfiguracion().getFormatos().getFechaPublicacion());

		Globals.TEXTO_PARA_BUSCADORES = Convert.toString(site.getPaginas().getTextoParaBuscadores());

		Globals.VIGENCIA_DEL_CARRITO_EN_DIAS = site.getConfiguracion().getVigenciaDelCarritoEnDias();

		Globals.DIAS_CONSIDERADOS_NOVEDAD = site.getConfiguracion().getDiasConsideradosNovedad();
		Globals.DIAS_IGNORADOS_NOVEDAD = site.getConfiguracion().getDiasIgnoradosNovedad();

		Globals.SOLAPAS_EN_MULTILINEA = site.getConfiguracion().getSolapasEnMultilinea();

		Globals.CUPON_REFERIDO = site.getCupones().getReferido();

		Globals.CUPON_REFERENTE = site.getCupones().getReferente();

		Globals.CUPON_REGISTRO = site.getCupones().getRegistro().getId();

		Globals.MAIL_ADMINISTRADOR = site.getConfiguracion().getAdministrador().getEmail();
		Globals.MAIL_CALL_CENTER = site.getConfiguracion().getCallCenter().getEmail();
		Globals.MAIL_ALIANZAS = site.getConfiguracion().getAlianzas().getEmail();
		Globals.MAIL_OFERTA_DE_TRABAJO = site.getConfiguracion().getOfertaDeTrabajo().getEmail();
		Globals.MAIL_REPORTE_DE_CONTENIDO = site.getConfiguracion().getReporteDeContenido().getEmail();
		Globals.MAIL_REPORTE_DE_PEDIDOS_ESPECIALES = site.getConfiguracion().getReporteDePedidosEspeciales().getEmail();
		Globals.MAIL_REPORTE_DE_ESTADISTICA_ORDENES = site.getConfiguracion().getReporteDeOrdenes().getEmail();
		Globals.MAIL_REPORTE_DE_ESTADO_DE_ORDEN = site.getConfiguracion().getReporteDeEstadoDeOrden().getEmail();
		Globals.MAIL_REPORTE_DE_VISITAS = site.getConfiguracion().getReporteDeVisitas().getEmail();
		Globals.MAIL_REPORTE_DE_SOCIOS = site.getConfiguracion().getReporteDeSocios().getEmail();
		Globals.MAIL_REPORTE_DE_CLIENTES_INSTITUCIONALES = site.getConfiguracion().getReporteDeClientesInstitucionales().getEmail();
        Globals.MAIL_TARJETAS_VERIFICADAS = site.getConfiguracion().getTarjetasVerificadas().getEmail();
        Globals.MAIL_ALERTA_SOC_DUP = site.getConfiguracion().getAlertaRegistracionConDocDuplicado().getEmail();

		Globals.HORARIO_CALL_CENTER = site.getConfiguracion().getCallCenter().getHorario();
		Globals.TELEFONO_CALL_CENTER = site.getConfiguracion().getCallCenter().getTelefono();
		Globals.TELEFONO_EXTERIOR_CALL_CENTER = site.getConfiguracion().getCallCenter().getTelefonoExterior();
		Globals.FAX_CALL_CENTER = site.getConfiguracion().getCallCenter().getFAX();

		Globals.MEJORAR_TEXTOS = false; // lo desactiva temporalmente para evitar uso de los arrays en el cambio
		Convert.minisculizar = site.getConfiguracion().getCorrecciones().getMinusculizar().getTexto();
		Convert.mayusculizar = site.getConfiguracion().getCorrecciones().getMayusculizar().getTexto();
		Convert.puntuacion = site.getConfiguracion().getCorrecciones().getPuntuacion().getReemplazo();
		Convert.articulacion = site.getConfiguracion().getCorrecciones().getArticulacion().getReemplazo();
		Globals.MEJORAR_TEXTOS = site.getConfiguracion().getCorrecciones().getMejorarTextos();

		// Determina si activar o no la generacion de tapas
		ImageServer.permitirGenerarTapasProtegidas(site.getConfiguracion().getGenerarTapasProtegidas(), site.getConfiguracion().getVigenciaTapasProtegidas());

		// Manda un mail con la configuracion
		if (instance != null) {

			// Si debe o no generar las tapas
			ImageServer.cargarIconos();

			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_REPORTE_DE_CONTENIDO,
					Globals.NOMBRE_DEL_SITIO + " - Carga de Contenido",
					"Contenido aplicado.",
					"/mailing/contenido.jsp");
		}
	}

	protected void ejecutarTarea() throws Exception {
		// Limpia el cache de ordenes como medida de seguridad para tener en caso de problemas
		OrdenService.borrarCacheDeOrdenes();
		// Simplemente borra los items de la lista
		//REDISEÑO REEMPLAZADO
		//masVendidos.clear();
		// Forzar a cargar los mas vendidos para las secciones más comunes
		////REDISEÑO REEMPLAZADO
		/*for (int i = 0; i < site.getPaginas().getPaginaCount(); i++) {
			int id = site.getPaginas().getPagina(i).getId();
			if (id > Globals.SECCION_HOME) {
				getMasVendidos(new Integer(site.getPaginas().getPagina(i).getId()), null, null);
			}
		}*/
	}
			
	protected String getMensaje() {
		return "Clear del cache de contenido";
	}

	protected boolean pausada() {
		return false;
	}

}
