/**
 * $Log: ImageServer.java,v $
 * Revision 1.20  2007/09/03 13:42:24  msartori
 * no message
 *
 * Revision 1.19  2006/08/02 15:20:39  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.18  2005/09/22 18:38:54  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.17  2005/08/03 16:09:00  omsartori
 * - eMPro: Ranking, links a busqueda por atributo principal y por editorial/proveedor
 *                Resultado de busqueda, texto de busqueda explicito
 * - eMPro: Seguimiento google. Reporte de visita, login y registro
 * - Mejoras: Ejb de articulo reducido en ranking, acoplamiento eliminado,
 *                 se reemplazaron los archivos de detalle de cada seccion por uno unico
 *
 * Revision 1.16  2005/07/18 13:53:09  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.15  2005/04/26 17:32:12  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.14  2005/01/18 19:46:13  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.13  2005/01/11 15:14:02  oGPistoia
 * - Buscador de Novedades
 *
 * Revision 1.12  2005/01/04 15:30:47  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.11  2004/10/22 15:55:41  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.10  2004/10/13 17:51:49  oGPistoia
 * - Listado de promociones que vencen
 * - Reemplazo de las tapas que no pueden cargarse
 * - Salida de eXtra a produccion
 *
 * Revision 1.9  2004/10/05 21:29:47  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.8  2004/09/10 15:13:26  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.7  2004/07/12 19:52:06  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.6  2004/07/08 20:19:07  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.5  2004/07/05 15:44:18  oGPistoia
 * - Release 1.80 (y cambios menores)
 *
 * Revision 1.4  2004/06/30 18:23:43  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.3  2004/06/15 20:57:36  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.2  2004/06/09 18:50:26  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.1  2004/05/14 19:19:14  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 */
package com.tmk.setup;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Daemon;
import com.tmk.kernel.site.Pagina;
import com.tmk.kernel.site.Site;
import com.tmk.kernel.site.types.PosicionesType;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.articulo.ArticuloClass;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.Date;
import java.util.Vector;


public final class ImageServer extends Daemon {

	private static final String DIR_TAPAS = "/tapas";
	private static final String DIR_TAPAS_CHICAS  = DIR_TAPAS + "/chicas/";
	private static final String DIR_TAPAS_GRANDES = DIR_TAPAS + "/grandes/";
	private static final String DIR_TAPAS_PROTEGIDAS = DIR_TAPAS + "/sitio/";

	private static final String DIR_ADICIONALES  = DIR_TAPAS + "/adicionales/";
	private static final String ARTICULO_SIN_TAPA         = "sinImagen";
	private static final String ARTICULO_SIN_TAPA_NOVEDAD = "sinImagenNovedad";
	private static final String EXTENSION_IMAGEN = "jpg";
	private static final String EXTENSION_TAPAS = "jpg";

	private static int DESCUENTO_MINIMO = 0;
	private static int DESCUENTO_MAXIMO = 100;

	private static int TAMAÑO_CHICO  = 0;
	private static int TAMAÑO_GRANDE = 1;

	private static boolean generarTapasProtegidas;

	private static int vigenciaDeTapaEnDias = 60; // Cuanto tiempo la imagen es válida

	private static Date fechaDeTolerancia = new Date(0);  // Todas vigentes

	private static InformacionDeImagen marcas[][];

	private static InformacionDeImagen novedades[][];

	private static InformacionDeImagen descuentos[][][];

	private static int cantidadDeTapasPedidas;
	private static int cantidadDeTapasYaGeneradas;
	private static int cantidadDeTapasGeneradas;
	private static int cantidadDeTapasNoDisponibles;
	private static int cantidadDeTapasFalladas;
	private static int cantidadDeTapasEliminadas;
	private static int cantidadDeTapasValidas;

	private static Vector tapasFalladas = new Vector();

	public static int getCantidadDeTapasPedidas() {
		return cantidadDeTapasPedidas;
	}

	public static int getCantidadDeTapasYaGeneradas() {
		return cantidadDeTapasYaGeneradas;
	}

	public static int getCantidadDeTapasGeneradas() {
		return cantidadDeTapasGeneradas;
	}

	public static int getCantidadDeTapasNoDisponibles() {
		return cantidadDeTapasNoDisponibles;
	}

	public static int getCantidadDeTapasFalladas() {
		return cantidadDeTapasFalladas;
	}

	public static int getCantidadDeTapasEliminadas() {
		return cantidadDeTapasEliminadas;
	}

	public static int getCantidadDeTapasValidas() {
		return cantidadDeTapasValidas;
	}

	public static Vector getTapasFalladas() {
		return tapasFalladas;
	}

	public static void setFechaDeTolerancia(Date fechaDeTolerancia) {
		ImageServer.fechaDeTolerancia = fechaDeTolerancia;
	}

	public static void permitirGenerarTapasProtegidas(boolean generarTapasProtegidas, int vigenciaDeTapasProtegidasEnDias) {
		ImageServer.generarTapasProtegidas = generarTapasProtegidas;
		ImageServer.vigenciaDeTapaEnDias = Math.max(vigenciaDeTapasProtegidasEnDias, 5); // No dejo que se configure en menos de esto por el peso del proceso
	}

	public ImageServer() {
		// Demora un poco la corrida de este proceso para evitar la sobrecarga del server al inicio
		super(Daemon.TREINTA_MINUTOS, Daemon.UN_DIA);
		//super(Daemon.UN_MINUTO, Daemon.UN_DIA);
	}

	public static final String nombreArticuloSinImagen(boolean esNovedad) {
		return new StringBuffer(DIR_ADICIONALES).append(esNovedad ? ARTICULO_SIN_TAPA_NOVEDAD : ARTICULO_SIN_TAPA).append(".").append(EXTENSION_IMAGEN).toString();
	}

	public static final String nombreArticuloSinImagen(boolean esNovedad, int seccion) {
		return new StringBuffer(DIR_ADICIONALES).append(esNovedad ? ARTICULO_SIN_TAPA_NOVEDAD : ARTICULO_SIN_TAPA).append("_").append(seccion).append(".").append(EXTENSION_IMAGEN).toString();
	}

	/**
	 * Dice si tiene tapa sin pedir generarla
	 */
	public static final boolean tieneTapa(int idArticulo, boolean tapaChica) {
		String pathDeTapaOriginal = pathDeTapaOriginal(idArticulo, tapaChica);
		File archivoTapaOriginal = obtenerArchivo(pathDeTapaOriginal);
		return ((archivoTapaOriginal != null) && (archivoTapaOriginal.exists()));
	}

	/**
	 * Genera el nombre de la tapa real
	 */
	public static final String obtenerNombreDeTapa(int idArticulo,
	                                               boolean tapaChica, int seccion, int porcDescuentoNegativo,
	                                               String byDefault, boolean esNovedad) {

		cantidadDeTapasPedidas++;

		// En realidad en comercial esta alrevés
		int porcDescuento = - porcDescuentoNegativo;

		// El porcentaje de descuento tiene que ser válido
		if ((porcDescuento < DESCUENTO_MINIMO) || (porcDescuento > DESCUENTO_MAXIMO)) {
			TmkLogger.error("El articulo " + idArticulo + " tiene un porcentaje inválido " + porcDescuento + "%.");
			cantidadDeTapasNoDisponibles++;
			return byDefault;
		}

		// La fecha e iconos deben estar cargados
		if ((fechaDeTolerancia == null) || (marcas == null) || (novedades == null) || (descuentos == null)) {
			TmkLogger.error("No se ha ejecutado el proceso de carga de iconos para generar las tapas nuevas.");
			cantidadDeTapasNoDisponibles++;
			return byDefault;
		}

		String pathDeTapaProtegida = pathDeTapaProtegida(nombreDeTapaProtegida(idArticulo, tapaChica, porcDescuento));
		File archivoProtegido = obtenerArchivo(pathDeTapaProtegida);
		// Si tiene archivo protegido valido, lo devuelve
		if ((generarTapasProtegidas) && (archivoProtegido != null) && (archivoProtegido.exists()) && (!haExpirado(archivoProtegido))) {

			if (archivoProtegido.length() == 0) {
				return pathDeTapaOriginal(idArticulo, tapaChica);

			} else {
				cantidadDeTapasYaGeneradas++;
				return pathDeTapaProtegida;
			}

		} else {

			String pathDeTapaOriginal = pathDeTapaOriginal(idArticulo, tapaChica);
			File archivoTapaOriginal = obtenerArchivo(pathDeTapaOriginal);
			if ((archivoTapaOriginal != null) && (archivoTapaOriginal.exists())) {

				// La seccion tiene que ser alguna de las que tiene registradas
				if ((seccion < 0) || (seccion > Globals.SECCIONES.length - 1)) {

					// Si la seccion es la 99 sale directamente (papeles de regalo)
					if (seccion == 99) {
						return pathDeTapaOriginal;

					} else {
						TmkLogger.error("La seccion " + seccion+ " está fuera de rango");
						cantidadDeTapasNoDisponibles++;
						return pathDeTapaOriginal;
					}

				}

				InformacionDeImagen marca = marcas[tapaChica ? TAMAÑO_CHICO : TAMAÑO_GRANDE][seccion];
				InformacionDeImagen novedad = novedades[tapaChica ? TAMAÑO_CHICO : TAMAÑO_GRANDE][seccion];
				InformacionDeImagen descuento = descuentos[porcDescuento][tapaChica ? TAMAÑO_CHICO : TAMAÑO_GRANDE][seccion];

				InformacionDeImagen icono = (esNovedad && (novedad != null)) ? novedad : marca;

				if ((generarTapasProtegidas) && ((icono != null) || (descuento != null))) {

					String nombreFinal = generarImagen(pathDeTapaOriginal, archivoTapaOriginal, pathDeTapaProtegida, archivoProtegido, icono, descuento);

					return (nombreFinal == null) ? nombreArticuloSinImagen(esNovedad, seccion) : nombreFinal;

				} else {

					return pathDeTapaOriginal;

				}

			} else {

				cantidadDeTapasNoDisponibles++;
				return byDefault;

			}
		}
	}

	/**
	 * Carga los logos correspondientes
	 */
	public static void inicializar() {

		// cantidad de secciones
		int secciones = Globals.SECCIONES.length;

		marcas = new InformacionDeImagen[TAMAÑO_GRANDE - TAMAÑO_CHICO + 1][secciones];

		novedades = new InformacionDeImagen[TAMAÑO_GRANDE - TAMAÑO_CHICO + 1][secciones];

		descuentos = new InformacionDeImagen[DESCUENTO_MAXIMO - DESCUENTO_MINIMO + 1][TAMAÑO_GRANDE - TAMAÑO_CHICO + 1][secciones];
	}

	/**
	 * Carga los logos correspondientes
	 */
	public static void cargarIconos() {

		// La fecha de tolerancia de los archivos la configura aqui
		fechaDeTolerancia = new Date();
		fechaDeTolerancia.setDate(fechaDeTolerancia.getDate() - vigenciaDeTapaEnDias);
		TmkLogger.info("ImageServer: Fecha de Tolerancia de Tapas hasta el " + Convert.toStringLargo(fechaDeTolerancia));

		TmkLogger.debug("Cargando iconos para marcas...");
		for (int seccion = 0; seccion < Globals.SECCIONES.length; seccion++) {
			Pagina pagina = solapaSeccion(seccion);
			for (int tamaño = TAMAÑO_CHICO; tamaño <= TAMAÑO_GRANDE; tamaño++) {
				PosicionesType posicion = PosicionesType.ARRIBACENTRADO;
				posicion = ((tamaño == TAMAÑO_CHICO) && (pagina != null) && pagina.getPosicionMarcaChica() != null) ? pagina.getPosicionMarcaChica() : posicion;
				posicion = ((tamaño == TAMAÑO_GRANDE) && (pagina != null) && (pagina.getPosicionMarcaGrande() != null)) ? pagina.getPosicionMarcaGrande() : posicion;
				int porcentaje = (pagina == null || !pagina.hasPorcentajeAlphaMarca()) ? 100 : pagina.getPorcentajeAlphaMarca();
				// Carga el archivo si lo tiene
				String nombreDeMarca = pathDeImagenesEspeciales("marca" + (tamaño == TAMAÑO_CHICO ? "_chica_" : "_grande_") + seccion + ".gif");
				File archivoMarca = obtenerArchivo(nombreDeMarca);
				// Crea la imagen con toda la informacion
				marcas[tamaño][seccion] = ((archivoMarca == null) || (!archivoMarca.exists())) ? null : new InformacionDeImagen(archivoMarca, posicion, porcentaje);
				// La informacion de la novedad casi la misma que la marca
				String nombreDeNovedad = pathDeImagenesEspeciales("novedad" + (tamaño == TAMAÑO_CHICO ? "_chica_" : "_grande_") + seccion + ".gif");
				File archivoNovedad = obtenerArchivo(nombreDeNovedad);
				novedades[tamaño][seccion] = ((archivoNovedad == null) || (!archivoNovedad.exists())) ? null : new InformacionDeImagen(archivoNovedad, posicion, 100); 
				// El icono de novedad al maximo de visibilidad 
			}
		}

		TmkLogger.debug("Cargando iconos para descuentos...");
		for (int seccion = 0; seccion < Globals.SECCIONES.length; seccion++) {
			Pagina pagina = solapaSeccion(seccion);
			for (int tamaño = TAMAÑO_CHICO; tamaño <= TAMAÑO_GRANDE; tamaño++) {
				PosicionesType posicion = PosicionesType.ABAJOCENTRADO;
				posicion = ((tamaño == TAMAÑO_CHICO) && (pagina != null) && pagina.getPosicionDescuentoChico() != null) ? pagina.getPosicionDescuentoChico() : posicion;
				posicion = ((tamaño == TAMAÑO_GRANDE) && (pagina != null) && (pagina.getPosicionDescuentoGrande() != null)) ? pagina.getPosicionDescuentoGrande() : posicion;
				int porcentaje = (pagina == null || !pagina.hasPorcentajeAlphaDescuento()) ? 100 : pagina.getPorcentajeAlphaDescuento();
				for (int descuento = DESCUENTO_MINIMO; descuento <= DESCUENTO_MAXIMO; descuento++) {
					// Carga el archivo si lo tiene
					String nombreDescuento = pathDeImagenesEspeciales("descuento_" + descuento + "%" + (tamaño == TAMAÑO_CHICO ? "_chica_" : "_grande_") + seccion + ".gif");
					File archivo = obtenerArchivo(nombreDescuento);
					// Crea la imagen con toda la informacion
					descuentos[descuento][tamaño][seccion] = ((archivo == null) || (!archivo.exists())) ? null : new InformacionDeImagen(archivo, posicion, porcentaje);
				}
			}
		}
	}

	/**
	 * Obtiene la solapa del contenido que se especifica
	 */
	private static final Pagina solapaSeccion(int seccion) {
		Site site = Contenido.getSite();
		for (int i = 0; (site != null) && (i < site.getPaginas().getPaginaCount()); i++) {
			Pagina pagina = site.getPaginas().getPagina(i);
			if (pagina.getId() == seccion) {
				return pagina;
			}
		}
		return null;
	}

	/**
	 * Crea un archivo existente en el disco desde el nombre corto
	 */
	private static final File obtenerArchivo(String nombreParcial) {
		try {
			if (com.tmk.setup.Contenido.getServletContext() == null) return null;
			String nombreCompleto = com.tmk.setup.Contenido.getServletContext().getRealPath(nombreParcial);
			return new File(nombreCompleto);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Responde si el archivo es anterior a la fecha que se supone es de eliminacion
	 */
	private static final boolean haExpirado(File archivo) {
		// Cuando java bloquea algunos archivos les deja tamaño cero
		return fechaDeTolerancia.after(new Date(archivo.lastModified()));

	}

	/**
	 * El Directorio donde estan las marcas y otros iconos especiales
	 */
	private static final String pathDeImagenesEspeciales(String nombreDeImagen) {
		return new StringBuffer(DIR_ADICIONALES).append('/').append(nombreDeImagen).toString();
	}

	/**
	 * Nombre esperado de la tapa original si es chica o grande
	 */
	private static final String nombreDeTapaOriginal(int idArticulo, boolean tapaChica) {
		// 116233.jpg
		return new StringBuffer((tapaChica) ? "" : "l").append(idArticulo).append("." + EXTENSION_TAPAS).toString();

	}

	/**
	 * Path para agregar en la pagina
	 */
	private static final String pathDeTapaOriginal(int idArticulo, boolean tapaChica) {
		// \tapas\chicas\116233.jpg
		StringBuffer result = new StringBuffer((tapaChica) ? DIR_TAPAS_CHICAS : DIR_TAPAS_GRANDES);
		result.append(nombreDeTapaOriginal(idArticulo, tapaChica));
		return result.toString();
	}

	/**
	 * Nombre esperado de la tapa protegida si es chica o grande
	 */
	private static final String nombreDeTapaProtegida(int idArticulo, boolean tapaChica, int porcDescuento) {
		// Nobre de la tapa a usar como archivo
		return new StringBuffer().append(idArticulo).append((tapaChica) ? "c" : "g").append(porcDescuento).append("." + EXTENSION_TAPAS).toString();

	}

	/**
	 * Devuelve el numero de articulo para regenerar la tapa
	 */
	private static final int idDeArticulo(String nombreDeArchivo) {
		try{
			int letraC = nombreDeArchivo.indexOf('c');
			if (letraC >= 0) {			
				return Integer.parseInt(nombreDeArchivo.substring(0, letraC));			
			}
			int letraG = nombreDeArchivo.indexOf('g');
			if (letraG >= 0) {
				return Integer.parseInt(nombreDeArchivo.substring(0, letraG));			
			}
		}catch(NumberFormatException nfe){
			int indexJpg = nombreDeArchivo.indexOf(".jpg");
			return Integer.parseInt(nombreDeArchivo.substring(0, indexJpg));
		}
		return 0; // No lo encuentra asi que no hará nada
		
	}

	/**
	 * Path para agregar en la pagina para la tapa protegida
	 */
	private static final String pathDeTapaProtegida(String nombreDeTapaProtegida) {
		// Nobre de la tapa a usar como archivo
		StringBuffer result = new StringBuffer(DIR_TAPAS_PROTEGIDAS);
		result.append(nombreDeTapaProtegida);
		return result.toString();
	}

	/**
	 * Genera la imagen en la posicion final
	 */
	private static final void dibujarImagen(int anchoOriginal, int altoOriginal, Graphics2D graphics, InformacionDeImagen logo) {

		int logoAncho = logo.icono.getWidth();
		int logoAlto = logo.icono.getHeight();

		int minX = 0;
		int minY = 0;

		int medioX = (anchoOriginal - logoAncho) / 2;
		int medioY = (altoOriginal  - logoAlto) / 2;

		int maxX = anchoOriginal - logoAncho;
		int maxY = altoOriginal  - logoAlto;

		graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, logo.porcentaje));

		switch (logo.posicion.getType()) {
			case PosicionesType.ARRIBAIZQUIERDA_TYPE: {
				graphics.drawImage(logo.icono, minX, minY, null);
				break;
			}
			case PosicionesType.ARRIBACENTRADO_TYPE : {
				graphics.drawImage(logo.icono, medioX, minY, null);
				break;
			}
			case PosicionesType.ARRIBADERECHA_TYPE : {
				graphics.drawImage(logo.icono, maxX, minY, null);
				break;
			}
			case PosicionesType.MEDIOIZQUIERDA_TYPE : {
				graphics.drawImage(logo.icono, minX, medioY, null);
				break;
			}
			case PosicionesType.MEDIOCENTRADO_TYPE : {
				graphics.drawImage(logo.icono, medioX, medioY, null);
				break;
			}
			case PosicionesType.MEDIODERECHA_TYPE : {
				graphics.drawImage(logo.icono, maxX, medioY, null);
				break;
			}
			case PosicionesType.ABAJOIZQUIERDA_TYPE : {
				graphics.drawImage(logo.icono, minX, maxY, null);
				break;
			}
			case PosicionesType.ABAJOCENTRADO_TYPE : {
				graphics.drawImage(logo.icono, medioX, maxY, null);
				break;
			}
			case PosicionesType.ABAJODERECHA_TYPE : {
				graphics.drawImage(logo.icono, maxX, maxY, null);
				break;
			}
			default : {
				TmkLogger.error("Falta un item de la enumeracion de posicion de imagenes");
				break;
			}
		}
	}

	/**
	 * Genera la imagen, la graba y retorna el nombre del archivo (en original si fallo)
	 */
	private static final String generarImagen(String nombreOriginal, File imagenOriginal,
	                                      String nombreDestino, File imagenDestino,
	                                      InformacionDeImagen icono, InformacionDeImagen descuento) {
		try {
			// Si el archivo existe lo borra
			imagenDestino.delete();

			BufferedImage imagenTapa = ImageIO.read(imagenOriginal);

			int anchoOriginal = imagenTapa.getWidth();
			int altoOriginal = imagenTapa.getHeight();

			Graphics2D graphics2D = imagenTapa.createGraphics();
			try {

				if (icono != null) dibujarImagen(anchoOriginal, altoOriginal, graphics2D, icono);
				if (descuento != null) dibujarImagen(anchoOriginal, altoOriginal, graphics2D, descuento);

				ImageOutputStream stream = ImageIO.createImageOutputStream(imagenDestino);
				try {
					// Copie y corregi este codigo del original
					ImageIO.write(imagenTapa, EXTENSION_TAPAS, stream);
					imagenTapa.flush();

					// Continua mi proceso
					cantidadDeTapasGeneradas++;
					cantidadDeTapasValidas++;

					return nombreDestino;

				} finally {
					stream.close();
				}

			} finally {
				graphics2D.dispose();
			}

		} catch (Exception e) {
			TmkLogger.debug("Fallo al generar tapa " + nombreDestino);
			//e.printStackTrace();

			// agrega a la lista de tapas fallidas
			if (!tapasFalladas.contains(nombreOriginal)) {
				tapasFalladas.add(nombreOriginal);
				cantidadDeTapasFalladas++;
			}

			return null;
		}
	}
//ORIGINAL
	public void ejecutarTarea() throws Exception {

		// Fuerza a recargar los iconos y otros procesos
		ImageServer.cargarIconos();

		TmkLogger.debug("Comienza la regeneracion de las tapas anteriores al " + Convert.toStringLargo(fechaDeTolerancia));

		// Borra los archivos que son obsoletos
		cantidadDeTapasValidas = 0;
		cantidadDeTapasEliminadas = 0;

		int tempContador = 0;

		File directorioDeTapasGeneradas = obtenerArchivo(DIR_TAPAS_PROTEGIDAS);
		File archivosGenerados[] = directorioDeTapasGeneradas.listFiles();
		for (int i = 0; i < archivosGenerados.length; i++) {

			File archivoActual = archivosGenerados[i];
			if (archivoActual.isFile()) {

				if (haExpirado(archivoActual)) {

					// Articulo con tapa a regenerar
					int idArticulo = idDeArticulo(archivoActual.getName());

					// Se borra la tapa obsoleta
					if (idArticulo != 0) {
						archivoActual.delete();
						cantidadDeTapasEliminadas++;
	
						// Ahora trata de regenerar la tapa para evitar congestionar al server mas adelante
						ArticuloClass articulo = ArticuloManager.getArticuloParaImagen(idArticulo);
						obtenerNombreDeTapa(idArticulo, true, articulo.getIdSeccion(), new Double(articulo.getPorcentajeDescuento()).intValue(), "", articulo.esNovedad());
						obtenerNombreDeTapa(idArticulo, false, articulo.getIdSeccion(), new Double(articulo.getPorcentajeDescuento()).intValue(), "", articulo.esNovedad());
						
	
						sleep(30 * 1000);  // espera unos segundos para que no congestione el server
					}		
				} else {
					tempContador++;
				}
			}
		}

		cantidadDeTapasValidas += tempContador;
	}

	/*
	public void ejecutarTarea() throws Exception {

		// Fuerza a recargar los iconos y otros procesos
		ImageServer.cargarIconos();

		TmkLogger.debug("Comienza la regeneracion de las tapas anteriores al " + Convert.toStringLargo(fechaDeTolerancia));

		// Borra los archivos que son obsoletos
		cantidadDeTapasValidas = 0;
		cantidadDeTapasEliminadas = 0;

		int tempContador = 0;

		//File directorioDeTapasGeneradas = obtenerArchivo(DIR_TAPAS_PROTEGIDAS);
		File directorioDeTapasGeneradas = obtenerArchivo(DIR_TAPAS_CHICAS);
		File archivosGenerados[] = directorioDeTapasGeneradas.listFiles();
		for (int i = 0; i < archivosGenerados.length; i++) {

			File archivoActual = archivosGenerados[i];
			if (archivoActual.isFile()) {

				//if (haExpirado(archivoActual)) {

					// Articulo con tapa a regenerar
					int punto = archivoActual.getName().indexOf("j");
					
					int idArticulo = new Integer(archivoActual.getName().substring(0, punto-1)).intValue();

					// Se borra la tapa obsoleta
					if (idArticulo != 0) {
						//archivoActual.delete();
						//cantidadDeTapasEliminadas++;
	
						// Ahora trata de regenerar la tapa para evitar congestionar al server mas adelante
						try {
							
								ArticuloClass articulo = ArticuloManager.getArticuloParaImagen(idArticulo);
							
								try {	
									obtenerNombreDeTapa(idArticulo, true, articulo.getIdSeccion(), new Double(articulo.getPorcentajeDescuento()).intValue(), "", articulo.esNovedad());
								} catch (Exception e)  {
									TmkLogger.error("No se pudo generar tapa para " + idArticulo + e.getMessage() + e.toString());
								}
						} catch (Exception e) {
							TmkLogger.error("No se pudo encontrar articulo " + idArticulo + e.getMessage() + e.toString()); 
						}
						 
						//GRANDES
						//obtenerNombreDeTapa(idArticulo, false, articulo.getIdSeccion(), new Double(articulo.getPorcentajeDescuento()).intValue(), "", articulo.esNovedad());
						
	
						sleep(1000);  // espera unos segundos para que no congestione el server
					}		
			
			}
		}

		cantidadDeTapasValidas += tempContador;
	}

	*/
	protected String getMensaje() {
		return "Se regeneraron " + cantidadDeTapasEliminadas + " tapas obsoletas entre " + cantidadDeTapasValidas + " aun vigentes";
	}

	protected boolean pausada() {
		return Globals.baseDeDatosEnMantenimiento();
	}
}
