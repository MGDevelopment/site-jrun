/**
 * @author Lizardo Santiago
 *
 * $Log: ProvinciaPK.java,v $
 * Revision 1.4  2003/10/03 16:28:59  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/09 20:35:26  SLizardo
 * no message
 *
 *
 */
package com.tmk.common;

import java.io.Serializable;

public class ProvinciaPK implements Serializable {

	public Integer ID_PAIS;
	public Integer ID_PROVINCIA;

	public ProvinciaPK() {
	}

	public ProvinciaPK(Integer ID_PAIS, Integer ID_PROVINCIA) {
		this.ID_PAIS = ID_PAIS;
		this.ID_PROVINCIA = ID_PROVINCIA;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_PAIS);
		hash.append(this.ID_PROVINCIA);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof ProvinciaPK) {
			ProvinciaPK provinciaPK = (ProvinciaPK) o;

			return (
			        this.ID_PAIS.equals(provinciaPK.ID_PAIS) &&
			        this.ID_PROVINCIA.equals(provinciaPK.ID_PROVINCIA)
			        );
		}

		return false;
	}
}
