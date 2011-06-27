/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioPK.java,v $
 * Revision 1.5  2003/12/04 17:21:09  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/10/09 20:48:48  SLizardo
 * Cierre de Incidentes
 *
 */
package com.tmk.socio;

import java.io.Serializable;

public class BufferSocioPK implements Serializable {

	public Integer ID_SUCURSAL;
	public Integer ID_SOCIO;

	public BufferSocioPK() {
	}

	public BufferSocioPK(Integer ID_SUCURSAL, Integer ID_SOCIO) {
		this.ID_SUCURSAL = ID_SUCURSAL;
		this.ID_SOCIO = ID_SOCIO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL);
		hash.append(this.ID_SOCIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof BufferSocioPK) {
			BufferSocioPK bufferPK = (BufferSocioPK) o;

			return (
			        this.ID_SUCURSAL.equals(bufferPK.ID_SUCURSAL) &&
			        this.ID_SOCIO.equals(bufferPK.ID_SOCIO)
			        );
		}

		return false;
	}
}

