/**
 * @author Lizardo Santiago
 *
 * $Log: SocioTelefonoPK.java,v $
 * Revision 1.4  2003/12/04 17:21:16  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/09/09 15:52:55  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import java.io.Serializable;

public class SocioTelefonoPK implements Serializable {

	public Integer ID_SUCURSAL;
	public Integer ID_SOCIO;
	public String TIPO_TELEFONO;

	public SocioTelefonoPK() {
	}

	public SocioTelefonoPK(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO) {
		this.ID_SUCURSAL = ID_SUCURSAL;
		this.ID_SOCIO = ID_SOCIO;
		this.TIPO_TELEFONO = TIPO_TELEFONO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL);
		hash.append(this.ID_SOCIO);
		hash.append(TIPO_TELEFONO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof SocioTelefonoPK) {
			SocioTelefonoPK telefonoPK = (SocioTelefonoPK) o;

			return (
			        this.ID_SUCURSAL.equals(telefonoPK.ID_SUCURSAL) &&
			        this.ID_SOCIO.equals(telefonoPK.ID_SOCIO) &&
			        this.TIPO_TELEFONO.equals(telefonoPK.TIPO_TELEFONO)
			        );
		}

		return false;
	}
}
