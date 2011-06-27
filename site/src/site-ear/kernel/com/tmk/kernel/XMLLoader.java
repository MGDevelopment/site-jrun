/**
 * $Log: XMLLoader.java,v $
 * Revision 1.11  2004/04/06 22:21:28  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.10  2004/02/27 13:44:21  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.9  2003/12/04 17:19:16  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/11/13 20:11:41  GPistoia
 * -Cambio de direccion para generacion de mail por temas de firewall
 * -Extensibilidad en detalles de articulos para agregar html del usuario
 * -Mejora en pantalla de estado de ordenes
 * -Sincronizacion de estadisticas
 *
 * Revision 1.7  2003/10/07 14:52:21  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.6  2003/08/19 19:27:14  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.5  2003/08/14 14:39:58  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.4  2003/08/09 18:22:02  GPistoia
 * -Autores en el articulo
 *
 * Revision 1.3  2003/08/06 21:28:24  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.2  2003/08/02 16:58:16  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/21 15:07:31  GPistoia
 * -Articulo
 * -Common y conversion
 * -Funciones para consulta
 *
 */
package com.tmk.kernel;

import java.io.File;
import java.io.FileReader;
import java.util.Date;

public class XMLLoader extends Thread {

	// Notify when a new file was found
	public interface Listener {

		public void onLoaded(FileReader fileReader) throws Exception;

	}

	protected Date lastLoaded = null;
	protected String fileName = null;
	protected Listener listener;

	public XMLLoader(String fileName, Listener listener) {
		super();
		this.fileName = fileName;
		this.listener = listener;
		setDaemon(true);
		start();
		loadFile();
	}

	public Listener getListener() {
		return listener;
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	public void reload() {
		lastLoaded = null;
	}

	public Date getXMLFileDate() {
		return lastLoaded;
	}

	public void run() {
		try {
			while (true) {
				// duerme un momento antes de verificar de nuevo
				sleep(/*segundo(s)*/ 2 * 1000);
				// carga
				loadFile();
			}
		} catch (InterruptedException e) {
			// termina la iteracion
		}
	}

	protected synchronized void loadFile() {
		File xmlFile = new File(fileName);
		try {
			Date modified = new Date(xmlFile.lastModified());
			boolean mustReLoad = (lastLoaded == null) || (modified.after(lastLoaded));
			if (mustReLoad && (listener != null)) {
				lastLoaded = modified;
				FileReader fileReader = new FileReader(xmlFile);
				try {
					listener.onLoaded(fileReader);
					TmkLogger.info("Archivo cargado " + xmlFile.getAbsolutePath());
				} finally {
					fileReader.close();
				}
			}

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el archivo " + xmlFile.getAbsolutePath() + ". Exception: " + e.getMessage());
		}
	}

}
