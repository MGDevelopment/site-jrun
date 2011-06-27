/**
 * @author Lizardo Santiago
 *
 * $Log: LocalidadPK.java,v $
 * Revision 1.4  2003/10/03 16:28:58  GPistoia
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

public class LocalidadPK implements Serializable {

	public Integer ID_PAIS;
	public Integer ID_PROVINCIA;
	public Integer ID_LOCALIDAD;

	public LocalidadPK() {
	}

	public LocalidadPK(Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD) {
		this.ID_PAIS = ID_PAIS;
		this.ID_PROVINCIA = ID_PROVINCIA;
		this.ID_LOCALIDAD = ID_LOCALIDAD;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_PAIS);
		hash.append(this.ID_PROVINCIA);
		hash.append(this.ID_LOCALIDAD);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof LocalidadPK) {
			LocalidadPK localidadPK = (LocalidadPK) o;

			return (
			        this.ID_PAIS.equals(localidadPK.ID_PAIS) &&
			        this.ID_PROVINCIA.equals(localidadPK.ID_PROVINCIA) &&
			        this.ID_LOCALIDAD.equals(localidadPK.ID_LOCALIDAD)
			        );
		}

		return false;
	}
}
