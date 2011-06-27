/**
 * $Log: GPayException.java,v $
 * Revision 1.4  2004/01/06 15:28:32  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.3  2003/10/09 19:29:58  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.2  2003/09/29 17:20:09  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.1  2003/08/02 16:58:18  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/26 19:06:07  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel.gpay;

import com.tmk.kernel.TmkLogger;

public class GPayException extends Exception {

	protected String mensajeAMostrar;

	public GPayException(String texto) {
		super(texto);
		mensajeAMostrar = texto;
		TmkLogger.info(texto);
	}

	public void setMensajeAMostrar(String mensaje) {
		this.mensajeAMostrar = mensaje;
	}

	public String getMensajeAMostrar() {
		return mensajeAMostrar;
	}

	// Sobreescribe el anterior, porque se reusa
	public String getMessage() {
		return mensajeAMostrar;
	}
}
