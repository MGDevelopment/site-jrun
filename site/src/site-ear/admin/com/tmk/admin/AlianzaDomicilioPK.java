/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaDomicilioPK.java,v $
 * Revision 1.2  2003/12/04 17:18:36  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:47  SLizardo
 * no message
 *
 * Revision 1.4  2003/09/09 20:35:22  SLizardo
 * no message
 *
 *
 */
package com.tmk.admin;

import java.io.Serializable;

public class AlianzaDomicilioPK implements Serializable {

	public Integer ID_ALIANZA;
	public String TIPO_DOMICILIO;

	public AlianzaDomicilioPK() {
	}

	public AlianzaDomicilioPK(Integer ID_ALIANZA, String TIPO_DOMICILIO) {
		this.ID_ALIANZA = ID_ALIANZA;
		this.TIPO_DOMICILIO = TIPO_DOMICILIO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ALIANZA);
		hash.append(this.TIPO_DOMICILIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof AlianzaDomicilioPK) {
			AlianzaDomicilioPK domicilioPK = (AlianzaDomicilioPK) o;

			return (
			        this.ID_ALIANZA.equals(domicilioPK.ID_ALIANZA) &&
			        this.TIPO_DOMICILIO.equals(domicilioPK.TIPO_DOMICILIO)
			        );
		}

		return false;
	}
}
