/**
 * $Log: VencimientoPuntos.java,v $
 * Revision 1.1  2004/08/03 15:46:59  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.1  2004/05/04 18:11:08  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.Convert;

import java.util.Date;

public class VencimientoPuntos {

	public Date fecha;
	public int puntos;

	public VencimientoPuntos() {
	}

	public VencimientoPuntos(Date fecha, int puntos) {
		super();
		this.fecha = fecha;
		this.puntos = puntos;
	}

	public String toString() {
		return "El dia " + Convert.toString(fecha) + " vencen " + Convert.toString(puntos) + " puntos. ";
	}
}
