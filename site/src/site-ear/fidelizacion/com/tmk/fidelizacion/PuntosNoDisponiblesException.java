/**
 * $Log: PuntosNoDisponiblesException.java,v $
 * Revision 1.1  2004/09/10 15:12:50  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 */
package com.tmk.fidelizacion;

public class PuntosNoDisponiblesException extends Exception {

	public PuntosNoDisponiblesException(String mensaje) {
		super(mensaje);
	}

}
