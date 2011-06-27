/**
 * @author Lizardo Santiago
 *
 * $Log: DireccionOrdenPK.java,v $
 * Revision 1.4  2003/10/03 16:29:47  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/11 15:21:37  SLizardo
 * no message
 *
 *
 */
package com.tmk.orden;

import java.io.Serializable;

public class DireccionOrdenPK implements Serializable {

	public Integer ID_ORDEN;
	public Integer ID_SUCURSAL_SOCIO;
	public Integer ID_SOCIO;
	public String TIPO_DOMICILIO;

	public DireccionOrdenPK() {
	}

	public DireccionOrdenPK(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO) {
		this.ID_ORDEN = ID_ORDEN;
		this.ID_SUCURSAL_SOCIO = ID_SUCURSAL_SOCIO;
		this.ID_SOCIO = ID_SOCIO;
		this.TIPO_DOMICILIO = TIPO_DOMICILIO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ORDEN);
		hash.append(this.ID_SUCURSAL_SOCIO);
		hash.append(this.ID_SOCIO);
		hash.append(this.TIPO_DOMICILIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof DireccionOrdenPK) {
			DireccionOrdenPK direccionPK = (DireccionOrdenPK) o;

			return (
			        this.ID_ORDEN.equals(direccionPK.ID_ORDEN) &&
			        this.ID_SUCURSAL_SOCIO.equals(direccionPK.ID_SUCURSAL_SOCIO) &&
			        this.ID_SOCIO.equals(direccionPK.ID_SOCIO) &&
			        this.TIPO_DOMICILIO.equals(direccionPK.TIPO_DOMICILIO)
			        );
		}

		return false;
	}
}
