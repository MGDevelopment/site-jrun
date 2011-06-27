/**
 * @author Lizardo Santiago
 *
 * $Log: SocioDomicilioPK.java,v $
 * Revision 1.4  2003/12/04 17:21:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/09/09 15:52:52  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import java.io.Serializable;

public class SocioDomicilioPK implements Serializable {

	public Integer ID_SUCURSAL;
	public Integer ID_SOCIO;
	public String TIPO_DOMICILIO;

	public SocioDomicilioPK() {
	}

	public SocioDomicilioPK(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO) {
		this.ID_SUCURSAL = ID_SUCURSAL;
		this.ID_SOCIO = ID_SOCIO;
		this.TIPO_DOMICILIO = TIPO_DOMICILIO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL);
		hash.append(this.ID_SOCIO);
		hash.append(this.TIPO_DOMICILIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof SocioDomicilioPK) {
			SocioDomicilioPK domicilioPK = (SocioDomicilioPK) o;

			return (
			        this.ID_SUCURSAL.equals(domicilioPK.ID_SUCURSAL) &&
			        this.ID_SOCIO.equals(domicilioPK.ID_SOCIO) &&
			        this.TIPO_DOMICILIO.equals(domicilioPK.TIPO_DOMICILIO)
			        );
		}

		return false;
	}
}
