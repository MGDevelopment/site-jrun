/**
 * $Log: Daemon.java,v $
 * Revision 1.32  2009/02/02 11:50:07  msartori
 * - Cambios Rediseño
 *
 * Revision 1.31  2004/09/23 18:44:44  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.30  2004/07/08 20:18:52  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.29  2004/06/30 18:23:01  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.28  2004/06/15 20:56:12  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.27  2004/05/04 18:09:33  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.26  2004/03/25 18:18:49  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.25  2004/03/04 18:51:41  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.24  2004/02/27 13:44:18  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.23  2003/12/11 20:52:05  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.22  2003/12/04 17:19:09  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.21  2003/11/26 15:36:56  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.20  2003/11/07 15:32:57  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.19  2003/10/13 21:43:28  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.18  2003/10/12 22:11:22  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.17  2003/10/07 14:52:15  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.16  2003/10/03 16:29:03  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.15  2003/09/29 17:20:07  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.14  2003/09/23 13:55:11  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.13  2003/09/05 19:56:24  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.12  2003/08/29 17:54:20  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.11  2003/08/27 18:43:49  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.10  2003/08/22 14:03:55  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.9  2003/08/21 21:29:46  SLizardo
 * no message
 *
 * Revision 1.8  2003/08/19 19:27:13  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.7  2003/08/14 14:40:00  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.6  2003/08/12 16:25:25  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.5  2003/08/06 21:28:20  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.4  2003/08/04 22:17:50  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.3  2003/08/02 16:58:05  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/28 19:21:27  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.1  2003/07/26 19:06:06  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

abstract public class Daemon extends Thread {

	public static final int UNA_VEZ = 0;
	public static final int AHORA = 0;

	public static final int UN_SEGUNDO = 1;
	public static final int DOS_SEGUNDOS = 2;
	public static final int CINCO_SEGUNDOS = 5;
	public static final int DIEZ_SEGUNDOS = 10;
	public static final int VEINTE_SEGUNDOS = 20;
	public static final int TREINTA_SEGUNDOS = 30;
	public static final int CUARENTA_SEGUNDOS = 40;
	public static final int CINCUENTA_SEGUNDOS = 50;

	public static final int UN_MINUTO = 60;
	public static final int DOS_MINUTOS = UN_MINUTO * 2;
	public static final int CINCO_MINUTOS = UN_MINUTO * 5;
	public static final int DIEZ_MINUTOS = UN_MINUTO * 10;
	public static final int TREINTA_MINUTOS = UN_MINUTO * 30;
	public static final int CUARENTA_MINUTOS = UN_MINUTO * 40;
	public static final int CINCUENTA_MINUTOS = UN_MINUTO * 50;

	public static final int UNA_HORA = UN_MINUTO * 60;
	public static final int DOS_HORAS = UNA_HORA * 2;
	public static final int TRES_HORAS = UNA_HORA * 3;
	public static final int SEIS_HORAS = UNA_HORA * 6;
	public static final int UN_DIA = UNA_HORA * 24;

	/**
	 * Tiempo que espera antes de arrancar
	 */
	protected int esperaAnterior;

	/**
	 * Espera entre ejecuciones
	 */
	protected int esperaCiclo;

	/**
	 * Es un demonio, asi que el flag va en true
	 */
	public Daemon(int esperaAnterior, int esperaCiclo, int priority) {
		super();
		setDaemon(true);
		setPriority(priority);
		this.esperaAnterior = esperaAnterior;
		this.esperaCiclo = esperaCiclo;
		start();
	}

	/**
	 * Es un demonio, asi que el flag va en true
	 */
	public Daemon(int esperaAnterior, int esperaCiclo) {
		this(esperaAnterior, esperaCiclo, Thread.MIN_PRIORITY);
	}

	/**
	 * Metodo que ejecuta despues de un tiempo
	 */
	abstract protected void ejecutarTarea() throws Exception;

	/**
	 * Devuelve el mensaje (mostrado en caso de error o exito)
	 */
	abstract protected String getMensaje();

	/**
	 * Congela la tarea si es necesario
	 */
	abstract protected boolean pausada();

	/**
	 * Ejecuta la tarea
	 */
	final public void run() {

		// si ocurre un error puede reintentar
		boolean error;

		// Tiempo inicial de espera
		int espera = esperaAnterior;

		do {

			try {
				/* Espera porque quizas esta en modo backup o algo similar */
				do {
					sleep(Math.max(espera * 1000, 10));  // Evita el cero que es infinito!!!
					espera = CINCO_SEGUNDOS;
				} while (pausada());

				// ejecuta la tarea
				ejecutarTarea();

				String message = getMensaje();
				if (message != null) TmkLogger.info(message);

				error = false;
				espera = esperaCiclo;

			} catch (InterruptedException e) {
				TmkLogger.debug("Bajando demonio " + getClass().getName() + "...");
				break;

			} catch (Exception e) {
				error = true;
				espera = UN_MINUTO;
				TmkLogger.error("Demonio " + getClass().getName() + ". Exception: " + e.getMessage() + e.toString());
				e.printStackTrace();
			}

		} while ((espera != UNA_VEZ) || error);

	}

}
