/**
 * $Log: TerminalManager.java,v $
 * Revision 1.11  2005/09/22 18:38:10  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.10  2003/12/22 22:26:55  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.9  2003/12/04 17:19:17  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/10/12 22:11:28  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.7  2003/10/09 19:29:58  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.6  2003/10/03 16:29:07  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/18 18:56:21  GPistoia
 * -Oculte los radio buttons de ir a papel de regalo.
 * -Iteracion en GPay
 *
 * Revision 1.4  2003/08/15 15:59:22  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.3  2003/08/14 14:40:00  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.2  2003/08/06 21:28:24  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.1  2003/08/02 16:58:18  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/30 15:18:03  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 */
package com.tmk.kernel.gpay;

import com.tmk.kernel.TmkLogger;

import java.util.Vector;

public class TerminalManager {

	// constantes de conexion
	private String host;
	private int port;
	private String comercio;
	private String mensaje;
	private int tiempoEsperaMaxima;
	private int cantidadTerminales;

	// Listado de terminales disponibles
	private static Vector terminales;

	public TerminalManager(String host,
	                       int port,
	                       String comercio,
	                       String mensaje,
	                       String baseNombreTerminal,
	                       int tiempoEsperaMaxima,
	                       int cantidadTerminales) {

		super();
		// configuracion
		this.host = host;
		this.port = port;
		this.comercio = comercio;
		this.mensaje = mensaje;
		this.tiempoEsperaMaxima = tiempoEsperaMaxima;
		this.cantidadTerminales = cantidadTerminales;
		// Construye las terminales
		terminales = new Vector();
		for (int numeroTerminal = 1; numeroTerminal <= cantidadTerminales; numeroTerminal++) {
			// Nombre esperado para la terminal
			String nombreTerminal = new StringBuffer(baseNombreTerminal).append(numeroTerminal).toString();
			// La agrega como disponible
			terminales.add(nombreTerminal);
			TmkLogger.info("Terminal disponible: " + nombreTerminal);
		}
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getComercio() {
		return comercio;
	}

	public String getMensaje() {
		return mensaje;
	}

	/*package*/
	String obtenerTerminal(int numeroOrden) throws GPayException {

		double esperaPromedioEnSegundos = 0.5; /* segundos que duerme si no encuentra una terminal */

		double reintentos = tiempoEsperaMaxima / esperaPromedioEnSegundos;

		for (int iteracion = 0; iteracion < reintentos; iteracion++) {
			try {
				// intenta tomar una terminal
				TmkLogger.info("Pide una terminal...");
				String terminal = (String) terminales.remove(0);
				TmkLogger.info("Terminal asignada: " + terminal);
				return terminal;

			} catch (Exception e) {

				if (iteracion == 0) TmkLogger.info("Esperando terminal para orden " + numeroOrden + "...");

				try {
					// si no hay terminales espera. El sleep no debe recibir 0
					Thread.sleep(Math.round(Math.abs(esperaPromedioEnSegundos * 1000) + 1));

				} catch (InterruptedException ie) {
					// SIMPLEMENTE ABORTA
					throw new GPayException("Shutdown: Se cerró la aplicación mientras intentaba obtener una terminal disponible en " + this);
				}
			}
		}

		// luego de reintentar no logro nada
		throw new GPayException("Sin Terminales: No se pudo obtener una terminal disponible en " + this);
	}

	/*package*/
	void liberarTerminal(String terminal) {
		// queda formalmente liberada
		terminales.add(terminal);
		TmkLogger.info("Terminal liberada: " + terminal);
	}

	public String toString() {
		return "TerminalManager sobre " + host + ":" + port +
		        ", comercio '" + comercio +
		        "', mensaje de terminal '" + mensaje +
		        "', tiempo de espera máxima '" + tiempoEsperaMaxima +
		        "', " + cantidadTerminales + " terminales.";
	}

}
