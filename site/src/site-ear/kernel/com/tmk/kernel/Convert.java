/**
 * $Log: Convert.java,v $
 * Revision 1.86  2009/01/15 12:35:21  msartori
 * no message
 *
 * Revision 1.85  2008/12/12 14:53:17  oClopez
 * no message
 *
 * Revision 1.84  2008/09/02 19:42:16  msartori
 * - DBO select soportando campos hijos DBO y campos hijos array de DBO
 *
 * Revision 1.83  2008/08/06 14:15:36  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.82  2008/01/24 20:28:04  msartori
 * no message
 *
 * Revision 1.81  2007/12/18 20:10:29  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.80  2007/10/18 20:05:14  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.79  2007/09/03 13:41:21  msartori
 * no message
 *
 * Revision 1.78  2007/07/25 20:07:16  omsartori
 * - Nuevo diseño de fidelizacion
 * - Actualizacion de Datos
 *      - Encripcion de codigos
 *
 * Revision 1.77  2007/07/11 14:58:12  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.76  2007/03/07 17:49:17  olsuarez
 * Correccion del catalogo de productos extra! para que
 * habilitara el link al detalle, solo a los productos disponibles en el sitio.
 *
 * Revision 1.75  2007/03/06 20:08:30  omsartori
 * no message
 *
 * Revision 1.74  2007/03/05 13:49:23  olsuarez
 * Modificaciones recorrido flias estaticos
 * Paginas de recorridos
 *
 * Revision 1.73  2007/01/19 12:40:19  oLSuarez
 * Rediseño de referido y correcciones
 *
 * Revision 1.72  2006/12/19 14:36:58  omsartori
 * - Rediseño: ajustes de estilo y estructura en las homes y paginas impactadas
 *
 * Revision 1.71  2006/12/13 17:15:07  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.70  2006/09/14 18:24:37  omsartori
 * Promociones II
 *
 * Revision 1.69  2006/08/02 15:20:28  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.68  2006/04/17 14:37:46  omsartori
 * * Corrección Busqueda "Recorra nuestras categorias apuntada a familia cuando corresponde grupo.
 * * Cambio de texto de promociones en carrito de compras.
 * * Leyenda de cuotas en la seleccion de medios de cobros.
 * * Alarma de indice que dan error al formatease.
 * * Doc EmPro 11-anexo y 12.
 * * recorrido por familia estatico.
 * * rediseño de extra.
 *
 * Revision 1.67  2006/04/04 15:10:18  omsartori
 * - recordar la palabra de busqueda siempre
 * - correccion de resaltado busqueda avanzada
 * - cambio de textos informativos de resultado de busqueda
 * - nueva pagina de notas de prensa sin pop up y con tags de EMKT
 *
 * Revision 1.66  2006/03/30 14:42:39  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.65  2006/03/22 15:00:54  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 *
 * Revision 1.64  2005/09/22 18:38:07  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.63  2005/06/15 14:19:12  omsartori
 * - Clase de alerta de intrusiones
 *
 * Revision 1.62  2005/05/17 14:38:37  omsartori
 * - Posicionamiento tags en pags desde el home, tags por producto, nueva pagina de biografia
 * - Referido, interface de carga modificada a tres referidos independientes, guarda nombre ap y mail
 *
 * Revision 1.61  2004/11/17 16:01:39  oGPistoia
 * - Nueva funcion para convertir de String a N numeros de articulo
 *
 * Revision 1.60  2004/11/16 21:19:18  oGPistoia
 * - Mejora para mostrar los datos de los artículos
 * - Cambios en las notas de prensa.
 *
 * Revision 1.59  2004/11/10 23:06:02  oGPistoia
 * - Generalizacion de los atributos para mejorar la presentacion y soportar Dromo
 *
 * Revision 1.58  2004/10/05 21:27:56  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.57  2004/09/23 18:44:43  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.56  2004/09/10 15:12:52  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.55  2004/09/07 16:14:33  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.54  2004/07/12 19:52:01  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.53  2004/07/08 20:18:51  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.52  2004/06/30 18:23:00  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.51  2004/06/15 20:56:11  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.50  2004/06/09 18:49:41  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.49  2004/05/14 19:16:45  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.48  2004/05/04 18:09:32  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.47  2004/04/06 22:21:26  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.46  2004/03/25 18:18:48  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.45  2004/03/04 18:51:40  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.44  2004/02/16 20:22:53  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.43  2004/02/11 19:32:50  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.42  2004/02/03 03:09:40  NRodriguez
 * - nueva extranet
 *
 * Revision 1.41  2004/01/06 15:28:30  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.40  2003/12/22 22:26:52  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.39  2003/12/04 17:19:08  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.38  2003/11/26 15:36:54  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.37  2003/11/19 18:55:25  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.36  2003/11/11 14:57:17  GPistoia
 * -Correccion en contenido sobre papeles de regalo
 *
 * Revision 1.35  2003/11/07 21:54:44  GPistoia
 * -Borre EJBs que no se usaban por los DAOs
 * -Mejoras en los queries de DBUtil, ahora son preparedStatements
 * -Mejora en arbol de categoria, filtro S/D y elimine arboles de 1 item
 * -Mostrar importe de los papeles
 *
 * Revision 1.34  2003/11/07 15:32:56  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.33  2003/10/29 19:57:20  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.32  2003/10/28 01:39:23  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.31  2003/10/21 22:05:33  GPistoia
 * -Arreglo de Formato
 * -Arreglo de recomendar solo disponibles
 * -Arreglo de recorrido por temas de solo disponibles.
 * -Arreglo solo 5 autores recomendados.
 *
 * Revision 1.30  2003/10/17 12:10:37  GPistoia
 * -Saque [mus]
 * -Revise promociones.
 *
 * Revision 1.29  2003/10/12 22:11:22  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.28  2003/10/09 19:29:56  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.27  2003/10/03 16:29:02  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.26  2003/09/29 17:20:06  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.25  2003/09/25 19:17:11  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.24  2003/09/24 21:21:43  JMembrives
 * modificacion de detalle Articulo
 *
 * Revision 1.23  2003/09/17 19:32:04  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.22  2003/09/17 15:13:36  GPistoia
 * -Incidente de link en promociones.
 * -Importe minimo de 0.01 para cualquier producto.
 *
 * Revision 1.21  2003/09/16 18:58:48  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.20  2003/09/11 18:08:41  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.19  2003/09/04 21:39:26  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.18  2003/09/01 13:54:50  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.17  2003/08/29 17:54:20  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.16  2003/08/27 18:43:49  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.15  2003/08/22 14:03:54  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.14  2003/08/21 17:48:25  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.13  2003/08/19 19:27:12  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.12  2003/08/15 15:59:20  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.11  2003/08/12 16:25:24  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.10  2003/08/11 14:26:39  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.9  2003/08/09 18:22:01  GPistoia
 * -Autores en el articulo
 *
 * Revision 1.8  2003/08/08 20:13:41  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.7  2003/08/06 21:28:19  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.6  2003/08/04 22:17:50  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.5  2003/07/30 15:17:59  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.4  2003/07/28 19:21:26  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.3  2003/07/26 19:06:05  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 * Revision 1.2  2003/07/22 19:48:58  GPistoia
 * -Disco V para migracion de paginas
 *
 * Revision 1.1  2003/07/21 15:07:30  GPistoia
 * -Articulo
 * -Common y conversion
 * -Funciones para consulta
 *
 */
package com.tmk.kernel;

import com.tmk.kernel.site.Reemplazo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;

public final class Convert {

	// pueden ser cambiados por la configuracion global
	public static DecimalFormat PESO_FORMAT = new DecimalFormat("#0.0");
	public static DecimalFormat DOLLAR_FORMAT = new DecimalFormat("#0.0");
	public static DecimalFormat EURO_FORMAT = new DecimalFormat("#0.0");
	public static DecimalFormat PERCENT_FORMAT = new DecimalFormat("#0.0");

	public static SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	public static SimpleDateFormat LONG_DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	public static SimpleDateFormat ES_DATE_FORMAT = new SimpleDateFormat("dd 'de' MMMM");
	public static SimpleDateFormat PUBLICATION_DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	public static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH'hs' mm'm'");

	public static DecimalFormat INTEGER_FORMAT = new DecimalFormat("#,##0");
	public static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.0");

	public static DecimalFormat GRAMOS_FORMAT = new DecimalFormat("#0.0 'grs'");
	public static DecimalFormat MM_FORMAT = new DecimalFormat("#0.0 'mm'");
	public static DecimalFormat MIN_FORMAT = new DecimalFormat("#0 'min'");

	// Textos usados en la correccion de titulos
	public static String[] minisculizar = {};
	public static String[] mayusculizar = {};
	public static Reemplazo[] puntuacion = {};
	public static Reemplazo[] articulacion = {};

	// Formato especifico de fecha
	public static final SimpleDateFormat DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Convierte en plural
	 */
	public static final String plural(String texto) {
		if (texto == null) return "";
		if ((texto.endsWith("a")) || (texto.endsWith("e")) || (texto.endsWith("i")) ||
		        (texto.endsWith("o")) || (texto.endsWith("u")))
			return texto + "s";
		if (texto.endsWith("sis")) return texto;
		if (texto.equalsIgnoreCase("cd")) return texto + "s";
		if (texto.endsWith("em")) return texto + "s";
		return texto + "es";
	}

	/**
	 * Convierte en plural
	 */
	public static final String plural(int numero, String texto) {
		if (texto == null) return "";
		return ((numero == 1) || (numero == -1)) ? texto : plural(texto);

	}

	/**
	 * Convierte en plural (casos especiales)
	 */
	public static final String plural(int numero, String singular, String plural) {
		return ((numero == 1) || (numero == -1)) ? singular : plural;

	}

	/**
	 * Convierte en plural
	 */
	public static final String pluralCompleto(int numero, String texto) {
		return new StringBuffer(toString(numero)).append(" ").append(plural(numero, texto)).toString();
	}

	/**
	 * Convierte en plural (casos especiales)
	 */
	public static final String pluralCompleto(int numero, String singular, String plural) {
		return new StringBuffer(toString(numero)).append(" ").append(plural(numero, singular, plural)).toString();
	}

	/**
	 * Devuelve Sr o Sra segun corresponda
	 */
	public static final String etiqueta(String sexo) {
		if ("M".equalsIgnoreCase(sexo)) return "Sr. ";
		if ("F".equalsIgnoreCase(sexo)) return "Sra. ";
		return "Sr./Sra. ";
	}

	/**
	 * El estandar de nombre y apellido
	 */
	public static final String nombreCompleto(String nombre, String apellido) {
		StringBuffer result = capitalizarOriginal(nombre, true);
		if (apellido != null) {
			result.append(" ");
			result.append(apellido.toUpperCase());
		}
		return result.toString();
	}

	/** Evita caracteres especiales para las paginas */
	public static final String encodeHTML(String valor) {
		return (valor == null) ? "" : valor.replaceAll("'", "%27").replaceAll("\"", "%22");
	}

    /**
     * Le deja solo los caracteres y espacios, sin signos ni numeros
     */
	public static final StringBuffer sinDigitosNiSignos(String original) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < original.length(); i++) {
			char letter = original.charAt(i);
			result.append(((' ' == letter) || Character.isLetter(letter)) ? letter : ' ');
		}
	    return result;
	}

	/**
	 * Elimina del texto las palabras muy cortas
	 */
	public static final String soloPalabrasLargas(StringBuffer original, int cantidadDeLetrasMinima) {
		StringBuffer result = new StringBuffer();
		final String space = " ";
		do {
			int index = (original.indexOf(space));
			int end = (index < 0) ? original.length() : index + 1;
			if (end > cantidadDeLetrasMinima + 1) result.append(original.substring(0, end)).append(' ');
			original.delete(0, end);
		} while (original.length() > 0);
		return result.toString().trim();
	}

	/**
	 * Genera un texto de sugerencia con la búsqueda a realizar
	 */
	public static final String sugerirNuevaBusqueda(String original, int cantidadDeLetrasMinima) {
		return soloPalabrasLargas(sinDigitosNiSignos(original), cantidadDeLetrasMinima);
	}

	/**
	 * Arregla el string para poder enviarlo a las paginas
	 */
	public static final String toJavaScript(String texto, boolean allWords) {
		return capitalizar(texto, allWords).replace('\'', ' ').replace('\\', ' ');
	}

	/**
	 * Capitaliza el texto. Se puede elegir si solo el comienzo de la frase o todas las palabras.
	 */
	public static final String capitalizar(String texto, boolean allWords, String defaultValue) {
		return capitalizar((texto == null) ? defaultValue : texto, allWords);
	}

	/**
	 * Capitaliza el texto, solo en la primera palabra, o en todas
	 */
	public static String capitalizar(String original, boolean todasLasPalabras)  {
		return capitalizarOriginal(original, todasLasPalabras).toString().trim();
	}

	/**
	 * Capitaliza el texto, solo en la primera palabra, o en todas
	 */
	public static StringBuffer capitalizarOriginal(String original, boolean todasLasPalabras)  {
		if (original == null) {
			return new StringBuffer();
		} else {
			StringBuffer result = new StringBuffer();
			String nombreUP = original.toUpperCase();
			String nombreLO = original.toLowerCase();
			boolean mayuscula = true;
			boolean pasaAMayuscula = false;
			for (int i = 0; i < original.length(); i++) {
				char caracter = (mayuscula) ? nombreUP.charAt(i) : nombreLO.charAt(i);
				result.append(caracter);
				boolean esEspacio = (Character.isSpaceChar(caracter));
				pasaAMayuscula = (pasaAMayuscula && esEspacio) || !(Character.isLetterOrDigit(caracter) || esEspacio);
				mayuscula = (pasaAMayuscula) || (todasLasPalabras && esEspacio);
			}
			return result;
		}
	}

	/**
	 * Procesa el nombre de un autor, dado vuelta si tiene espacios o coma
	 */
	public static String nombrePropio(String original)  {
		return nombrePropio(original, true);
	}
	/**
	 * Procesa el nombre de un autor, dado vuelta si tiene espacios o coma
	 */
	public static String nombrePropio(String original, boolean sinComaAsumirEspacio)  {
		if (original == null) return "";
		if (!Globals.MEJORAR_TEXTOS) return original;
		String result = original.toUpperCase().replaceFirst("\\[MUS]", "").trim();   // Malditos autores viejos tienen este texto loco
		if ((original.indexOf('-') < 0)) {
			int corte = result.indexOf(',');
			if (sinComaAsumirEspacio) {
				corte = (corte >= 0) ? corte : result.lastIndexOf(' ');
			}
			if (corte >= 0) {
				result = new StringBuffer(result.substring(corte + 1)).append(" ").append(result.substring(0, corte)).toString();
			}
		}
		return capitalizar(result, true);
	}
	
	// fix mg20130306: corregirCasosEspeciales()
	// fix mg20130311: correcciones casos "..."
	public static final String corregirCasosEspeciales(String original) {
		return original.replaceAll("¡", "").replaceAll("!", "").replace("...", " ...");
	}
	
	/**
	 * Capitaliza el texto. Se puede elegir si solo el comienzo de la frase o todas las palabras.
	 */
	public static final String corregir(String original, boolean todasLasPalabras) {
		return corregir(original, todasLasPalabras, true);
	}

	/**
	 * Capitaliza el texto. Se puede elegir si solo el comienzo de la frase o todas las palabras.
	 */
	// mg20130227: elimine la logica de reemplazo de los caracteres space + , o space + ; o space + .
	// mg20130617: logica de reemplazo para Sr., Sra., Mr., Mrs., Ms.
	public static final String corregir(String original, boolean todasLasPalabras, boolean cambiarArticulos) {
		if (original == null) return "";
		// Variable resultado
		String result = original.trim().toUpperCase()
				.replaceAll("SR.", "@1").replaceAll("SRA.", "@2").replaceAll("MR.", "@3").replaceAll("MRS.", "@4").replaceAll("MS.", "@5")
				.replaceAll(" \\. ", "@6")
				.replaceFirst("\\.", " .").replaceFirst(",", " , ").replaceFirst(";", " ; ").replaceFirst("-", " - ").replaceFirst("/", " / ").replaceAll("  ", " ");
		if (Globals.MEJORAR_TEXTOS) {
			// Prepara para aplicar los cambios
			result = capitalizarOriginal((cambiarArticulos) ? mejorarTextos(result) : result, todasLasPalabras).append(' ').toString();
			// minisculizacion de palabras comunes
			for (int item = 0; item < minisculizar.length; item++) {
				result = minisculizar(result, minisculizar[item]);
			}
			// mayusculizacion de palabras especiales
			for (int item = 0; item < mayusculizar.length; item++) {
				result = mayusculizar(result, mayusculizar[item]);
			}
			// reemplaza una palabra por otra
			for (int item = 0; item < puntuacion.length; item++) {
				result = reemplaza(result, puntuacion[item].getOrigen(), puntuacion[item].getDestino());
			}
		}
		return result
				.replaceAll("@1", "Sr.").replaceAll("@2", "Sra.").replaceAll("@3", "Mr.").replaceAll("@4", "Mrs.").replaceAll("@5.", "Ms.")
				.replaceFirst(" \\...", "...").replaceFirst(" \\.", ".").replaceFirst(" ,", ",").replaceFirst(" ;", ";")
				.replaceAll("@6", " . ").trim();
	}


	private static final String reemplaza(String original, String viejo, String nuevo) {
		return (original.indexOf(viejo) >= 0) ? original.replaceAll(viejo, nuevo) : original;
	}

	private static final String mayusculizar(String original, String viejo) {
		int posicion = original.indexOf(viejo);
		return (posicion >= 0) ? original.replaceAll(viejo, viejo.toUpperCase()) : original;
	}


	private static final String minisculizar(String original, String viejo) {
		int posicion = original.indexOf(viejo);
		return (posicion >= 0) // Encontro el caracter
		        ? (((posicion > 0) && ("./:-¡!¿?{}()[]".indexOf(original.charAt(posicion-1)) >= 0)) // NO esta detras de un caracter de fin de linea
		            ? original
					: original.replaceAll(viejo, viejo.toLowerCase()))
		        : original;
	}


	private static final String mejorarTextos(String texto) {
		// elimina caracteres no deseados
		StringBuffer buffer = new StringBuffer(texto).append(" ");
		// busca un punto o guion o el ultimo caracter
		int punto = buffer.indexOf(".");
		punto = (punto >= 0) ? punto : buffer.indexOf("-");
		punto = (punto >= 0) ? punto : buffer.indexOf(" Y ");
		punto = (punto >= 0) ? punto : buffer.length();
		// reemplaza una palabra por otra
		for (int item = 0; item < articulacion.length; item++) {
			if (moverHaciaAdelante(buffer, punto, articulacion[item].getOrigen(), articulacion[item].getDestino())) return buffer.toString();
		}
		return texto;
	}

	/**
	 * Quita la ultima palabra y la pasa hacia adelante
	 */
	private static final boolean moverHaciaAdelante(StringBuffer buffer, int punto, String buscar, String reemplazo) {
		int indice = (buffer.indexOf(buscar, punto - buscar.length() - 1));
		boolean reemplazar = (indice >= 0);
		if (reemplazar) buffer.replace(indice, indice + buscar.length(), "").insert(0, reemplazo);
		return reemplazar;
	}

	/**
	 * Calcula la tasa en base a dos valores
	 */
	public static final double aplicarPorcentaje(double valor, double tasa) {
		return valor * (1 + tasa / 100.00);
	}

	/**
	 * Porcentaje de un valor
	 */
	public static final double porcentajeResultante(double valor, double tasa) {
		return valor * tasa / 100.00;
	}

	/**
	 * Calcula el porcentaje extra entre los dos numeros
	 */
	public static final double sinPorcentajeAplicado(double valor, double tasa) {
		return valor / (1 + (tasa / 100.00));
	}

	/**
	 * Calcula el valor al cual se le aplico el porcentaje
	 */
	public static final double porcentajeAplicado(double valor, double total) {
		return ((total - valor) / valor) * 100.00;
	}

	/**
	 * Redondea el double a la cantidad de decimales necesarios
	 */
	public static final double round(double value) {
		return Math.round(value * 100.00) / 100.00;
	}

	/**
	 * Muestra el valor decimal
	 */
	public static final String toGramos(double value) {
		return GRAMOS_FORMAT.format(value);
	}

	/**
	 * Muestra el valor decimal
	 */
	public static final String toMM(double value) {
		return MM_FORMAT.format(value);
	}

	public static final String toMIN(double value) {
		return MIN_FORMAT.format(value);
	}

	/**
	 * Se asegura de que el string no sea nulo
	 */
	public static final String toString(Object value, String defaultValue) {
		return ((value == null) || ("".equals(value.toString().trim()))) ? defaultValue : value.toString();
	}

	/**
	 * Se asegura de que el string no sea nulo
	 */
	public static final String toString(String value) {
		return (value == null) ? "" : value.trim();
	}

	/**
	 * Se asegura que el string no sea nulo y tenga hasta 'n' caracteres
	 */
	public static final String toString(String value, int size) {
		StringBuffer result = new StringBuffer();
		if (value != null) result.append(value.trim());
		if (result.length() > size) {
			String POSFIX = "...";
			result.delete(size - POSFIX.length(), result.length()).append(POSFIX);
		}
		//while (result.length() < size) result.append(' ');
		return result.toString();
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(boolean value) {
		return (value) ? "Si" : "No";
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(Boolean value) {
		return (value == null) ? "No especificado" : toString(value.booleanValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(int value) {
		return INTEGER_FORMAT.format(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(int value) {
		return (value == 0) ? "" : String.valueOf(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(Integer value) {
		return toStringSinFormato(value.intValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(Integer value) {
		return (value == null) ? "" : toString(value.intValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(long value) {
		return INTEGER_FORMAT.format(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(long value) {
		return (value == 0) ? "" : String.valueOf(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(Long value) {
		return toStringSinFormato(value.longValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(Long value) {
		return (value == null) ? "" : toString(value.longValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(double value) {
		return DECIMAL_FORMAT.format(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(double value) {
		return (value == 0.0) ? "" : String.valueOf(value);
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toStringSinFormato(Double value) {
		return toStringSinFormato(value.doubleValue());
	}

	/**
	 * Devuelve el numero como string
	 */
	public static final String toString(Double value) {
		return (value == null) ? "" : toString(value.doubleValue());
	}

	/**
	 * Devuelve la fecha como string
	 */
	public static final String toString(Date value) {
		return (value == null) ? "No disponible" : SHORT_DATE_FORMAT.format(value);
	}

	/**
	 * Devuelve la fecha como string en mes y año
	 */
	public static final String toStringPublicacion(Date value) {
		return (value == null) ? "No especificada" : capitalizar(PUBLICATION_DATE_FORMAT.format(value), false);
	}

	/**
	 * Devuelve la fecha como string
	 */
	public static final String toStringLargo(Date value) {
		return (value == null) ? "No especificada" : LONG_DATE_FORMAT.format(value);
	}

	/**
	 * Devuelve la fecha como string en formato españo xx de xxxxx de xxxx
	 */
	public static final String toEsStringLargo(Date value) {
		return (value == null) ? "No especificada" : ES_DATE_FORMAT.format(value);
	}

	/**
	 * Devuelve la fecha como string
	 */
	public static final String toStringHora(Date value) {
		return (value == null) ? "No especificada" : TIME_FORMAT.format(value);
	}

	/**
	 * Convierte de String a fecha
	 */
	@SuppressWarnings("deprecation")
	public static final Date toDate(String value, Date defaultValue) {
		try {
			return (value == null) ? defaultValue : new Date(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * De una fecha texto la pasa a fecha real
	 */
	public static final java.sql.Timestamp toTimestampFromDDMMYYYY(String value) {
		try {
			return (value == null) ? null : new java.sql.Timestamp(DD_MM_YYYY.parse(value.trim()).getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Formatea la fecha como dd/mm/yyyy
	 */
	public static final String toStringFromDDMMYYYY(java.sql.Timestamp value) {
		return (value == null) ? "" : DD_MM_YYYY.format(value);
	}

	/**
	 * Convierte de String a fecha
	 */
	public static final java.sql.Timestamp toTimestamp(String value, java.sql.Timestamp defaultValue) {
		try {
			return (value == null) ? defaultValue : new java.sql.Timestamp(new Date(value).getTime());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en numero
	 */
	public static final int toNumber(String value, int defaultValue) {
		try {
			return (value == null) ? defaultValue : Integer.parseInt(value.trim().replaceAll("\\.", ""));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en numero
	 */
	public static final Integer toNumber(String value, Integer defaultValue) {
		try {
			return (value == null) ? defaultValue : new Integer(value.trim().replaceAll("\\.", ""));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Devuelve el valor o un default
	 */
	public static final int toNumber(Integer value, int defaultValue) {
		return (value == null) ? defaultValue : value.intValue();
	}

	/**
	 * Convierte el string en numero
	 */
	public static final long toNumber(String value, long defaultValue) {
		try {
			return (value == null) ? defaultValue : Long.parseLong(value.trim().replaceAll("\\.", ""));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en numero
	 */
	public static final Long toNumber(String value, Long defaultValue) {
		try {
			return (value == null) ? defaultValue : new Long(value.trim().replaceAll("\\.", ""));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Devuelve el valor o un default
	 */
	public static final long toNumber(Long value, long defaultValue) {
		return (value == null) ? defaultValue : value.longValue();
	}

	/**
	 * Convierte el string en numero
	 */
	public static final double toNumber(String value, double defaultValue) {
		try {
			return (value == null) ? defaultValue : Double.parseDouble(value.trim());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en numero
	 */
	public static final Double toNumber(String value, Double defaultValue) {
		try {
			return (value == null) ? defaultValue : new Double(value.trim());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en boolean
	 */
	public static final boolean toBoolean(Object value, boolean defaultValue) {
		try {
			return (value == null) ? defaultValue : toBoolean(value.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Devuelve el valor o un default
	 */
	public static final double toNumber(Double value, double defaultValue) {
		return (value == null) ? defaultValue : value.doubleValue();
	}

	/**
	 * Devuelve el valor o un default
	 */
	public static final Double toNumber(Double value, Double defaultValue) {
		return (value == null) ? defaultValue : value;
	}

	/**
	 * Convierte el string en boolean
	 */
	public static final boolean toBoolean(String value, boolean defaultValue) {
		try {
			return (value == null) ? defaultValue : toBoolean(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en boolean
	 */
	public static final Boolean toBoolean(String value, Boolean defaultValue) {
		try {
			return (value == null) ? defaultValue : new Boolean(toBoolean(value));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Convierte el string en boolean
	 */
	public static final boolean toBoolean(String value) throws Exception {
		return ("true".equalsIgnoreCase(value.trim())) ||
		        ("yes".equalsIgnoreCase(value.trim())) ||
		        ("si".equalsIgnoreCase(value.trim())) ||
		        ("sí".equalsIgnoreCase(value.trim())) ||
		        ("s".equalsIgnoreCase(value.trim())) ||
		        ("on".equalsIgnoreCase(value.trim())) ||
		        ("1".equalsIgnoreCase(value.trim()));
	}

	/**
	 * Retorna un vector con los números de articulo que vienen en un string separados con coma, punto y coma, etc.
	 */
	public static int[] toNumbers(String value) {
		try {
			// Corta el string en N strings
			String allStrings[] = value.split("[,;.:|/]");

			// vector de enteros con el resultado
			Vector integers = new Vector();

			// Saca los números desde los N strings. Si no es un número lo ignora
			for (int i = 0; i < allStrings.length; i++) {
				Number temp = toNumber(allStrings[i], (Integer)null);
				// No lo agrega si es nulo, pero si agrego duplicados por si lo necesitan más adelante
				if (temp != null) {
					integers.add(temp);
				}
			}

			// Crea un array para los N enteros
			int result[] = new int[integers.size()];

			// Agrega los elementos al array
			for (int i = 0; i < integers.size(); i++) {
				result[i] = ((Number)integers.get(i)).intValue();
			}

			// Retorna los N elementos
			return result;

		} catch (Exception e) {
			// Retorna un array sin elementos
			return new int[0];
		}
	}

    /**
    * Color a String HTML
    */
    public final static String toStringHTML (Color color) {
        StringBuffer buf = new StringBuffer();
        return buf.append(convertirHexa2Char(color.getRed())).append(convertirHexa2Char(color.getGreen())).append(convertirHexa2Char(color.getBlue())).toString();
    }

    public final static String convertirHexa2Char (int color) {
        StringBuffer buf = new StringBuffer(Integer.toHexString(color));
        return buf.insert(0, (buf.length() == 1)? "0": "").toString();
    }
    /**
	 * Turns funky characters into HTML entity equivalents<p>
	 * e.g. <tt>"bread" & "butter"</tt> => <tt>&amp;quot;bread&amp;quot; &amp;amp; &amp;quot;butter&amp;quot;</tt>.
	 * Update: supports nearly all HTML entities, including funky accents. See the source code for more detail.
	 **/
	public static final String htmlEscape(String s1) {
		if (s1 == null) return "";
		StringBuffer buf = new StringBuffer();
		int i;
		for (i = 0; i < s1.length(); ++i) {
			char ch = s1.charAt(i);
			String entity = (String) i2e.get(new Integer((int) ch));
			if (entity == null) {
				if (((int) ch) > 128) {
					buf.append("&#" + ((int) ch) + ";");
				} else {
					buf.append(ch);
				}
			} else {
				buf.append("&" + entity + ";");
			}
		}
		return buf.toString();
	}

	/**
	 * Given a string containing entity escapes, returns a string
	 * containing the actual Unicode characters corresponding to the
	 * escapes.
	 *
	 * Note: nasty bug fixed by Helge Tesgaard (and, in parallel, by
	 * Alex, but Helge deserves major props for emailing me the fix).
	 * 15-Feb-2002 Another bug fixed by Sean Brown <sean@boohai.com>
	 **/
	public static final String htmlUnescape(String s1) {
		StringBuffer buf = new StringBuffer();
		int i;
		for (i = 0; i < s1.length(); ++i) {
			char ch = s1.charAt(i);
			if (ch == '&') {
				int semi = s1.indexOf(';', i + 1);
				if (semi == -1) {
					buf.append(ch);
					continue;
				}
				String entity = s1.substring(i + 1, semi);
				Integer iso;
				if (entity.charAt(0) == '#') {
					iso = new Integer(entity.substring(1));
				} else {
					iso = (Integer) e2i.get(entity);
				}
				if (iso == null) {
					buf.append("&" + entity + ";");
				} else {
					buf.append((char) (iso.intValue()));
				}
				i = semi;
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	private static final Map e2i = new HashMap();
	private static final Map i2e = new HashMap();

	/**
	 * Clase estatica
	 */
	private Convert() {
		// see http://hotwired.lycos.com/webmonkey/reference/special_characters/
		Object[][] entities = {
			// {"#39", new Integer(39)},       // ' - apostrophe
			{"quot", new Integer(34)}, // " - double-quote
			{"amp", new Integer(38)}, // & - ampersand
			{"lt", new Integer(60)}, // < - less-than
			{"gt", new Integer(62)}, // > - greater-than
			{"nbsp", new Integer(160)}, // non-breaking space
			{"copy", new Integer(169)}, // © - copyright
			{"reg", new Integer(174)}, // ® - registered trademark
			{"Agrave", new Integer(192)}, // À - uppercase A, grave accent
			{"Aacute", new Integer(193)}, // Á - uppercase A, acute accent
			{"Acirc", new Integer(194)}, // Â - uppercase A, circumflex accent
			{"Atilde", new Integer(195)}, // Ã - uppercase A, tilde
			{"Auml", new Integer(196)}, // Ä - uppercase A, umlaut
			{"Aring", new Integer(197)}, // Å - uppercase A, ring
			{"AElig", new Integer(198)}, // Æ - uppercase AE
			{"Ccedil", new Integer(199)}, // Ç - uppercase C, cedilla
			{"Egrave", new Integer(200)}, // È - uppercase E, grave accent
			{"Eacute", new Integer(201)}, // É - uppercase E, acute accent
			{"Ecirc", new Integer(202)}, // Ê - uppercase E, circumflex accent
			{"Euml", new Integer(203)}, // Ë - uppercase E, umlaut
			{"Igrave", new Integer(204)}, // Ì - uppercase I, grave accent
			{"Iacute", new Integer(205)}, // Í - uppercase I, acute accent
			{"Icirc", new Integer(206)}, // Î - uppercase I, circumflex accent
			{"Iuml", new Integer(207)}, // Ï - uppercase I, umlaut
			{"ETH", new Integer(208)}, // Ð - uppercase Eth, Icelandic
			{"Ntilde", new Integer(209)}, // Ñ - uppercase N, tilde
			{"Ograve", new Integer(210)}, // Ò - uppercase O, grave accent
			{"Oacute", new Integer(211)}, // Ó - uppercase O, acute accent
			{"Ocirc", new Integer(212)}, // Ô - uppercase O, circumflex accent
			{"Otilde", new Integer(213)}, // Õ - uppercase O, tilde
			{"Ouml", new Integer(214)}, // Ö - uppercase O, umlaut
			{"Oslash", new Integer(216)}, // Ø - uppercase O, slash
			{"Ugrave", new Integer(217)}, // Ù - uppercase U, grave accent
			{"Uacute", new Integer(218)}, // Ú - uppercase U, acute accent
			{"Ucirc", new Integer(219)}, // Û - uppercase U, circumflex accent
			{"Uuml", new Integer(220)}, // Ü - uppercase U, umlaut
			{"Yacute", new Integer(221)}, // Ý - uppercase Y, acute accent
			{"THORN", new Integer(222)}, // Þ - uppercase THORN, Icelandic
			{"szlig", new Integer(223)}, // ß - lowercase sharps, German
			{"agrave", new Integer(224)}, // à - lowercase a, grave accent
			{"aacute", new Integer(225)}, // á - lowercase a, acute accent
			{"acirc", new Integer(226)}, // â - lowercase a, circumflex accent
			{"atilde", new Integer(227)}, // ã - lowercase a, tilde
			{"auml", new Integer(228)}, // ä - lowercase a, umlaut
			{"aring", new Integer(229)}, // å - lowercase a, ring
			{"aelig", new Integer(230)}, // æ - lowercase ae
			{"ccedil", new Integer(231)}, // ç - lowercase c, cedilla
			{"egrave", new Integer(232)}, // è - lowercase e, grave accent
			{"eacute", new Integer(233)}, // é - lowercase e, acute accent
			{"ecirc", new Integer(234)}, // ê - lowercase e, circumflex accent
			{"euml", new Integer(235)}, // ë - lowercase e, umlaut
			{"igrave", new Integer(236)}, // ì - lowercase i, grave accent
			{"iacute", new Integer(237)}, // í - lowercase i, acute accent
			{"icirc", new Integer(238)}, // î - lowercase i, circumflex accent
			{"iuml", new Integer(239)}, // ï - lowercase i, umlaut
			{"igrave", new Integer(236)}, // ì - lowercase i, grave accent
			{"iacute", new Integer(237)}, // í - lowercase i, acute accent
			{"icirc", new Integer(238)}, // î - lowercase i, circumflex accent
			{"iuml", new Integer(239)}, // ï - lowercase i, umlaut
			{"eth", new Integer(240)}, // ð - lowercase eth, Icelandic
			{"ntilde", new Integer(241)}, // ñ - lowercase n, tilde
			{"ograve", new Integer(242)}, // ò - lowercase o, grave accent
			{"oacute", new Integer(243)}, // ó - lowercase o, acute accent
			{"ocirc", new Integer(244)}, // ô - lowercase o, circumflex accent
			{"otilde", new Integer(245)}, // õ - lowercase o, tilde
			{"ouml", new Integer(246)}, // ö - lowercase o, umlaut
			{"oslash", new Integer(248)}, // ø - lowercase o, slash
			{"ugrave", new Integer(249)}, // ù - lowercase u, grave accent
			{"uacute", new Integer(250)}, // ú - lowercase u, acute accent
			{"ucirc", new Integer(251)}, // û - lowercase u, circumflex accent
			{"uuml", new Integer(252)}, // ü - lowercase u, umlaut
			{"yacute", new Integer(253)}, // ý - lowercase y, acute accent
			{"thorn", new Integer(254)}, // þ - lowercase thorn, Icelandic
			{"yuml", new Integer(255)}, // ÿ - lowercase y, umlaut
			{"euro", new Integer(8364)}, // Euro symbol
		};
		for (int i = 0; i < entities.length; ++i) {
			e2i.put(entities[i][0], entities[i][1]);
			i2e.put(entities[i][1], entities[i][0]);
		}

	}
/*Retorna True si los dos parametros son iguales*/
    public static final boolean equals(Object value1, Object value2) {
        return (value1 == null && value2 == null) ||
                ((value1 != null && value2 != null && value1.equals(value2)));
    }


    public static String VectorAString(Vector vector, String separador) {
	    String retorno ="";

		separador = (separador==null)? "/" : separador;

	    if (vector != null && vector.size() > 1) {
			for (int i=0; i<vector.size(); i++) {
				retorno =  retorno + Convert.nombrePropio(vector.get(i).toString()) + " / ";
			}
			if (retorno.length()>3) {
				retorno = retorno.substring(0, retorno.length()-3);
			}
        }
	    return retorno;
    }

	public static final Pattern [] palabraClaveAPatron (String palabraClave) {
		if (palabraClave == null) {
			return null;
		}
		String [] suprimir = {"LA ", "La ", "la ", "DE ", "De ", "de ", "DEL ", "Del ", "del ", "CON ", "Con ", "con "};
		//depuracion: quito las palabras de suprimir
		Pattern as = Pattern.compile("[âãáàäa]", Pattern.CASE_INSENSITIVE);
		Pattern es = Pattern.compile("[éèêëe]", Pattern.CASE_INSENSITIVE);
		Pattern is = Pattern.compile("[íìîïi]", Pattern.CASE_INSENSITIVE);
		Pattern os = Pattern.compile("[óòôõöo]", Pattern.CASE_INSENSITIVE);
		Pattern us = Pattern.compile("[úùûüu]", Pattern.CASE_INSENSITIVE);
		Pattern cs = Pattern.compile("[çc]", Pattern.CASE_INSENSITIVE);
		palabraClave = palabraClave + " ";
		String aux [] = palabraClave.split(" ");

		for (int i=0; i<suprimir.length; i++) {
			for (int j=0; j<aux.length; j++) {
				//palabraClave = palabraClave.replaceAll(suprimir[i], "");
				if (aux[j].equals(suprimir[i])) {
					aux[j] = "";
				}
			}
		}

		//depuracion

		//creo el patron en base a las palabras claves
		Pattern patrones [] = new Pattern[aux.length];

		for (int i=0; i<aux.length; i++) {
			String txtPatron = "";
			if (aux[i].length() > 1) {
				for (int j=0; j<aux[i].length(); j++) {
					boolean sinPatron = true;
					if (as.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=as.pattern();
						sinPatron=false;
					}
					if (es.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=es.pattern();
						sinPatron=false;
					}
					if (is.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=is.pattern();
						sinPatron=false;
					}
					if (os.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=os.pattern();
						sinPatron=false;
					}
					if (us.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=us.pattern();
						sinPatron=false;
					}
					if (cs.matcher(aux[i].substring(j,j+1)).matches()) {
						txtPatron +=cs.pattern();
						sinPatron=false;
					}
					if (sinPatron) {
						txtPatron += aux[i].substring(j,j+1);
					}
				}
				//patrones[i] = Pattern.compile("[^a-z]" + txtPatron + "[^a-z]", Pattern.CASE_INSENSITIVE);
				patrones[i] = Pattern.compile(txtPatron, Pattern.CASE_INSENSITIVE);
			}
		}
		//creo el patron en base a las palabras claves
		return patrones;
	}


	public static final String resaltado(Pattern[] patrones, String txt, int caracteres,
			String resaltado, String resaltadoCierre) {
		if (txt == null) {
			return "";
		}
		if (patrones == null) {
			return txt;
		}

		//String resaltado = "<b style=\"color:083C73\">";
		txt = " " + txt + " "; // por si la ultima palabra es una palabra clave
		try {
			Pattern patronPuntosYEspacios = Pattern.compile("[\\p{Punct}\\p{Space}]");
			String txtResultado = txt;

			//resaltado
			int primerCaracter = 999999;

			boolean encontreAlgo = false;
			String txtResultado2 = txtResultado;
			for (int i=0; i<patrones.length; i++) {
				if (patrones[i] != null) {
					String textoParaBusqueda ="";

					for (int j=0; j<txtResultado.length(); j++) {
						textoParaBusqueda = txtResultado.substring(j, txtResultado.length());

						Matcher matcher = patrones[i].matcher(textoParaBusqueda);
						if (matcher.lookingAt()) {
							encontreAlgo = true;
							int inicio = matcher.start() + j;
							primerCaracter = Math.min(primerCaracter, inicio);
							int fin = matcher.end() + j;
							if (patronPuntosYEspacios.matcher(txtResultado.substring(fin-1, fin)).matches()) {
								fin--;
							}
							String palabraEncontrada = txtResultado.substring(inicio, fin);
							txtResultado2 = txtResultado.substring(0, inicio) + resaltado + palabraEncontrada + resaltadoCierre + txtResultado.substring(fin, txtResultado.length());
							txtResultado = txtResultado2;

							j = j + resaltado.length() + resaltadoCierre.length();
						}
					}
					txtResultado = txtResultado2;
				}
			}
		//reslatado

		//substraccion segun cantidad de caracteres
		String txtResultadoRecortado="";
		if (caracteres > 0 && encontreAlgo) {
			/*txtResultadoRecortado = txtResultado.substring(Math.max(0, primerCaracter-caracteres), primerCaracter) +
			        txtResultado.substring(primerCaracter, primerCaracter + Math.min(txtResultado.length()-primerCaracter, caracteres + primerCaracter));*/
				int com;
				if (primerCaracter > caracteres/2) {
					com = primerCaracter - caracteres/2;
				} else {
					com = 0;
				}

				int fin =  Math.min(txtResultado.length(), primerCaracter + caracteres);

				txtResultadoRecortado = txtResultado.substring(com, primerCaracter) +
	            txtResultado.substring(primerCaracter, fin);

			if (com > 0) {
				txtResultadoRecortado = "..." + txtResultadoRecortado;
			}
			if (txtResultado.length() > fin) {
		        txtResultadoRecortado = txtResultadoRecortado + "...";
			}
		} else {
			txtResultadoRecortado = txtResultado;
		}
        //substraccion segun cantidad de caracteres
		int ultimoAbre = 0;
		int ultimoCierra = 0;
		ultimoAbre = txtResultadoRecortado.lastIndexOf("<");
		ultimoCierra = txtResultadoRecortado.lastIndexOf(">");

		while (ultimoAbre > ultimoCierra) {
			txtResultadoRecortado = txtResultadoRecortado.substring(0, ultimoAbre-1);
			ultimoAbre = txtResultadoRecortado.lastIndexOf("<");
			ultimoCierra = txtResultadoRecortado.lastIndexOf(">");
		}

		int primerAbre = 0;
		int primerCierra = 0;
		primerAbre = txtResultadoRecortado.indexOf("<");
		primerCierra = txtResultadoRecortado.indexOf(">");

		while ((primerAbre ==-1 && primerCierra != -1)  || (primerCierra < primerAbre) ) {
			txtResultadoRecortado = txtResultadoRecortado.substring(primerCierra+1, txtResultadoRecortado.length());
			primerAbre = txtResultadoRecortado.indexOf("<");
			primerCierra = txtResultadoRecortado.indexOf(">");
		}

		return txtResultadoRecortado;
		} catch (Exception e) {
			TmkLogger.error("Resaltado de Busqueda] " + e.toString() + " Texto->" + txt);
			return txt;
		}
	}

	public static String sinTildes(String texto) {
		texto = texto.replaceAll("[ÁÀÂÃÄ]", "A");
		texto = texto.replaceAll("[ÉÈÊË]", "E");
		texto = texto.replaceAll("[ÍÌÎÏ]", "I");
		texto = texto.replaceAll("[ÓÒÔÕÖ]", "O");
		texto = texto.replaceAll("[ÚÙÛÜ]", "U");
		texto = texto.replaceAll("[áàâãä]", "a");
		texto = texto.replaceAll("[éèêë]", "e");
		texto = texto.replaceAll("[íìîï]", "i");
		texto = texto.replaceAll("[óòôõö]", "o");
		texto = texto.replaceAll("[úùûü]", "u");
		return texto;
	}

	public static String sinTildesNiEnie(String texto) {
		texto = sinTildes(texto);
		texto = texto.replaceAll("Ñ", "N");
		texto = texto.replaceAll("ñ", "n");
		return texto;
	}

	// fix mg20130221: modificacion para el soloLetrasYNrosCategoria
	public static String soloLetrasYNrosCategoria(String cadena) {
		StringBuffer retorno = new StringBuffer("");
		int c = 0;
		for (int i = 0; i < cadena.length(); i++) {
			c = (int)cadena.charAt(i);
			if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				retorno.append(cadena.charAt(i));
			}
			if (c == 44 || c == 45 || c == 46 || c == 32) {
				retorno.append("_");
			}			
		}
		return retorno.toString();
	}
	
	// fix mg20130221: control por nuevos caracteres y combinacion de anulacion de secuencia
	public static String soloLetrasYNros(String cadena) {
		StringBuffer retorno = new StringBuffer("");
		int c = 0;
		int cAnt = 0;
		for (int i = 0; i < cadena.length(); i++) {
			c = (int)cadena.charAt(i);
			if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				retorno.append(cadena.charAt(i));
			}
			
			if (c == 180 || c == 32 || c == 46 || c == 44 || c == 45) {
				retorno.append("_");
			}
			// combinacion space? o .? anula hasta encontrar un caracter <> _
			if ((cAnt == 32 || cAnt == 46) && c == 63) {
				try {
					while(true) {
						if (retorno != null && !"".equals(retorno) && retorno.charAt(retorno.length()-1) == '_')
							retorno.deleteCharAt(retorno.length()-1);
						else
							break;
					}
				} catch (Exception e) {
					//e.printStackTrace()
				}
			}
			cAnt = c;
		}
		return retorno.toString();
	}

	public static double redondearAMedio(double dbl) {
		double retorno;
		//Double objDbl = new Double(dbl);
		//int ent = objDbl.intValue();		
		int ent = (int)dbl;		
		double decimal = dbl - ent;

		if (decimal > 0.75) {
			retorno = ent +1;
		} else {
			if (decimal < 0.25) {
				retorno = ent;
			} else {
				retorno = ent + 0.5;
			}
		}
		return retorno;
	}

	public static int redondearEnteroSuperior(double dbl) {
		int ent = (int)dbl;		
		return (dbl - ent>0)?ent+1:ent;
	}

	
	
	public static byte[] hexStringToByteArray(String hexStr) {
		int tam = hexStr.length();
		byte[] bytes = new byte[tam / 2];
		for (int i = 0; i < tam; i += 2){
			try {
				bytes[i / 2] = (byte)Integer.parseInt(hexStr.substring(i, i+2), 16);
			} catch (Exception e) {
				return null;
			}
		}
		return bytes;

	}

	public static String toFixedJSON(String json) {
		Pattern pt= Pattern.compile("(\\{)(\\\"[^\\\"]+\\\")([^:}]*)(\\})");
		Matcher mt= pt.matcher(json);
		String correctJsonStr= mt.replaceAll("$2");
		return correctJsonStr.replaceAll("\n", "").replaceAll("\r", "");
	}
}
