/**
 * $Log: TarjetaPrepagaException.java,v $
 * Revision 1.1  2005/12/29 17:45:19  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por c�digo como por palabra.
 *    Se modific� el orden de las tarjetas en el plan de pago del detalle art�culo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepci�n del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para �rdenes que contengan art�culos de Dromo.
 *
 * * Se filtr� la localidad �ciudad aut�noma de Buenos Aires� del listado de localidades v�lidas para tmk.
 *
 * * Doc Empro 10
 *
 */
package com.tmk.orden;



public class TarjetaPrepagaException extends Exception {

	protected String mensajeAMostrar;

	public TarjetaPrepagaException(String texto) {
		super(texto);
		mensajeAMostrar = texto;
		//TmkLogger.info(texto);
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

