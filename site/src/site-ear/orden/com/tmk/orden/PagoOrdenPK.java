/**
 * @author Lizardo Santiago
 *
 * $Log: PagoOrdenPK.java,v $
 * Revision 1.4  2003/10/03 16:29:50  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/11 15:21:46  SLizardo
 * no message
 *
 *
 */
package com.tmk.orden;

import java.io.Serializable;

public class PagoOrdenPK implements Serializable {

	public Integer ID_ORDEN;
	public String ID_MEDIO_COBRO;

	public PagoOrdenPK() {
	}

	public PagoOrdenPK(Integer ID_ORDEN, String ID_MEDIO_COBRO) {
		this.ID_ORDEN = ID_ORDEN;
		this.ID_MEDIO_COBRO = ID_MEDIO_COBRO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ORDEN);
		hash.append(this.ID_MEDIO_COBRO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof PagoOrdenPK) {
			PagoOrdenPK ordenPK = (PagoOrdenPK) o;

			return (
			        this.ID_ORDEN.equals(ordenPK.ID_ORDEN) &&
			        this.ID_MEDIO_COBRO.equals(ordenPK.ID_MEDIO_COBRO)
			        );
		}

		return false;
	}
}
