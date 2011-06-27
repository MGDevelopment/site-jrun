package com.tmk.src.socio;

import java.io.Serializable;

public class CarritoCompraPK implements Serializable {

	public Integer ID_SUCURSAL_SOCIO;
	public Integer ID_SOCIO;
	public Integer ID_ARTICULO;

	public CarritoCompraPK() {
	}

	public CarritoCompraPK(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO) {
		this.ID_SUCURSAL_SOCIO = ID_SUCURSAL_SOCIO;
		this.ID_SOCIO = ID_SOCIO;
		this.ID_ARTICULO = ID_ARTICULO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL_SOCIO);
		hash.append(this.ID_SOCIO);
		hash.append(this.ID_ARTICULO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof CarritoCompraPK) {
			CarritoCompraPK carritoCompraPK = (CarritoCompraPK) o;

			return (
			        this.ID_SUCURSAL_SOCIO.equals(carritoCompraPK.ID_SUCURSAL_SOCIO) &&
			        this.ID_SOCIO.equals(carritoCompraPK.ID_SOCIO) &&
			        this.ID_ARTICULO.equals(carritoCompraPK.ID_ARTICULO)
			        );
		}

		return false;
	}
}
