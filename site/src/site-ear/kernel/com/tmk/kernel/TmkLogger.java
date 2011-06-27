/**
 * $Log: TmkLogger.java,v $
 * Revision 1.15  2005/09/22 18:38:10  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.14  2004/08/03 15:47:03  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.13  2004/07/12 19:52:03  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.12  2004/07/08 20:18:54  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.11  2004/02/27 13:44:20  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.10  2003/10/07 14:52:21  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.9  2003/10/03 16:29:06  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.8  2003/09/29 17:20:09  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.7  2003/09/16 19:30:58  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.6  2003/09/11 18:08:47  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.5  2003/09/09 13:28:32  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.4  2003/09/05 19:56:31  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.3  2003/08/26 16:18:56  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.2  2003/08/15 15:59:22  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.1  2003/08/14 14:39:58  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 */
package com.tmk.kernel;

import com.tmk.kernel.server.types.LogType;
import org.apache.log4j.Logger;

import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class TmkLogger extends Daemon {

	/** Nivel de log actualmente activado */
	private LogType LOG = LogType.ALTO;

	/** Nombre del objeto logueador */
	private Logger logger = Logger.getLogger(Globals.NOMBRE_DEL_SITIO);

	/** Cola de mensajes a imprimir */
	private Vector messageList = new Vector(50, 50);

	/** Instancia actual */
	private final static TmkLogger instance = new TmkLogger();

	/** Cambia el nivel de log */
	public final static void setNivelDeLog(LogType logType) {
		instance.LOG = logType;
		info("Nivel de Log: " + instance.LOG.toString());
	}

	public final static void debug(Object o) {
		instance.messageList.add(new DebugMessageHolder(o.toString()));
	}

	public final static void warn(Object o) {
		instance.messageList.add(new WarnMessageHolder(o.toString()));
	}

	public final static void info(Object o) {
		instance.messageList.add(new InfoMessageHolder(o.toString()));
	}

	public final static void error(Object o) {
		instance.messageList.add(new ErrorMessageHolder(o.toString()));
		// Fuerza a grabar el log ahora
		instance.ejecutarTarea();
	}

	////// DESCUBRI QUE EL LOGGER CONSUME MUCHISIMO TIEMPO DE CPU, ASI QUE LO QUE VOY A HACER ES ARMAR UN HILO EN PARALELO
	protected TmkLogger() {
		super(Daemon.UN_SEGUNDO, Daemon.CINCO_SEGUNDOS);
	}

	/**
	 * Metodo que ejecuta despues de un tiempo
	 */
	synchronized protected void ejecutarTarea() {
        while (!messageList.isEmpty()) {
	        MessageHolder messageHolder = (MessageHolder) messageList.remove(0);
	        messageHolder.loguear();
        }
	}

	/**
	 * Devuelve el mensaje (mostrado en caso de error o exito)
	 */
	protected String getMensaje() {
        return null; // Muestra ningun mensaje
	}

	/**
	 * Congela la tarea si es necesario
	 */
	protected boolean pausada() {
        return false;
	}

	/** Estructura para guardar los mensajes */
	static abstract class MessageHolder {
		static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd MMM HH:mm:ss:SSS) ");
		String message;
		MessageHolder(String message) {
			this.message = FORMAT.format(new Date()) + message;
		}
		abstract void loguear();
	}

	// En caso de debug
	static class DebugMessageHolder extends MessageHolder {
		DebugMessageHolder(String message) {
			super(message);
		}
		void loguear() {
			if (instance.LOG.getType() == LogType.ALTO_TYPE) {
				instance.logger.debug(message);
			}
		}
	}

	// En caso de debug
	static class WarnMessageHolder extends MessageHolder {
		WarnMessageHolder(String message) {
			super(message);
		}
		void loguear() {
			if ((instance.LOG.getType() == LogType.ALTO_TYPE) || (instance.LOG.getType() == LogType.MEDIO_TYPE)) {
				instance.logger.warn(message);
			}
		}
	}

	// En caso de debug
	static class InfoMessageHolder extends MessageHolder {
		InfoMessageHolder(String message) {
			super(message);
		}
		void loguear() {
			if (instance.LOG.getType() != LogType.NINGUNO_TYPE) {
				instance.logger.info(message);
			}
		}
	}

	// En caso de debug
	static class ErrorMessageHolder extends MessageHolder {
		ErrorMessageHolder(String message) {
			super(message);
		}
		void loguear() {
			if (instance.LOG.getType() != LogType.NINGUNO_TYPE) {
				instance.logger.error(message);
			}
		}
	}

}

