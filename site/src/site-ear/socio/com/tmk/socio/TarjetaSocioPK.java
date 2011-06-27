/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocioPK.java,v $
 * Revision 1.3  2003/12/04 17:21:18  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/09/09 15:17:11  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import java.io.Serializable;

public class TarjetaSocioPK implements Serializable {

	public Integer ID_SUCURSAL_SOCIO;
	public Integer ID_SOCIO;
	public Integer ID_ITEM;

	public TarjetaSocioPK() {
	}

	public TarjetaSocioPK(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ITEM) {
		this.ID_SUCURSAL_SOCIO = ID_SUCURSAL_SOCIO;
		this.ID_SOCIO = ID_SOCIO;
		this.ID_ITEM = ID_ITEM;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL_SOCIO);
		hash.append(this.ID_SOCIO);
		hash.append(this.ID_ITEM);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof TarjetaSocioPK) {
			TarjetaSocioPK tarjetaPK = (TarjetaSocioPK) o;

			return (
			        this.ID_SUCURSAL_SOCIO.equals(tarjetaPK.ID_SUCURSAL_SOCIO) &&
			        this.ID_SOCIO.equals(tarjetaPK.ID_SOCIO) &&
			        this.ID_ITEM.equals(tarjetaPK.ID_ITEM)
			        );
		}

		return false;
	}
}
