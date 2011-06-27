/**
 * $Log: InteresCobradoDAO.java,v $
 * Revision 1.2  2005/11/14 13:47:51  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.1  2004/10/05 21:27:58  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 */
package com.tmk.kernel;

import javax.ejb.FinderException;
import javax.naming.NamingException;


public class InteresCobradoDAO extends ArticuloDAO {

	public InteresCobradoDAO(int idArticulo) throws NamingException, FinderException {
		super(idArticulo);
	}

	public void setPrecio(double precioConImpuesto) {
		double precioSinImpuesto = Convert.round(Convert.sinPorcentajeAplicado(precioConImpuesto, tasaImpuestoGeneral + tasaImpuestoVideo));
		precioSinImpuesto = Convert.round(Math.max(precioSinImpuesto, Globals.IMPORTE_MINIMO_AFIP));
		this.precioOriginal = precioSinImpuesto;
		this.precioPromocionSinImpuestos = precioSinImpuesto;
		// Idem a ArticuloBean solo que salen de lugares diferentes
		this.precioConImpuesto = Convert.round(precioConImpuesto);
		this.precioConDescuento = Convert.round(Convert.aplicarPorcentaje(precioConImpuesto, porcentajeDescuento));
		this.precioSitio = precioConDescuento;
	}

	public void setPrecio(double precioConImpuesto, double precioSinDescuento) {
        double precioSinImpuestoSinDescuento = Convert.round(Convert.sinPorcentajeAplicado(precioSinDescuento, tasaImpuestoGeneral + tasaImpuestoVideo));
		precioSinImpuestoSinDescuento = Convert.round(Math.max(precioSinImpuestoSinDescuento, Globals.IMPORTE_MINIMO_AFIP));
		this.precioOriginal = precioSinImpuestoSinDescuento;

		double precioSinImpuesto = Convert.round(Convert.sinPorcentajeAplicado(precioConImpuesto, tasaImpuestoGeneral + tasaImpuestoVideo));
		precioSinImpuesto = Convert.round(Math.max(precioSinImpuesto, Globals.IMPORTE_MINIMO_AFIP));
		this.precioPromocionSinImpuestos = precioSinImpuesto;
		// Idem a ArticuloBean solo que salen de lugares diferentes

		this.precioConImpuesto = Convert.round(precioSinDescuento);
		this.precioConDescuento = Convert.round(Convert.aplicarPorcentaje(precioSinDescuento, porcentajeDescuento));
		this.precioSitio =precioConImpuesto;
	}

	public String toString() {
		return titulo + " por " + precioSitio;
	}

}
