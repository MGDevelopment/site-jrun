/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaTelefonoPK.java,v $
 * Revision 1.2  2003/12/04 17:18:40  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:56  SLizardo
 * no message
 *
 * Revision 1.6  2003/09/11 15:21:32  SLizardo
 * no message
 *
 *
 */
package com.tmk.admin;

import java.io.Serializable;

public class AlianzaTelefonoPK implements Serializable {

	public Integer ID_ALIANZA;
	public String TIPO_TELEFONO;

	public AlianzaTelefonoPK() {
	}

	public AlianzaTelefonoPK(Integer ID_ALIANZA, String TIPO_TELEFONO) {
		this.ID_ALIANZA = ID_ALIANZA;
		this.TIPO_TELEFONO = TIPO_TELEFONO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ALIANZA);
		hash.append(this.TIPO_TELEFONO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof AlianzaTelefonoPK) {
			AlianzaTelefonoPK telefonoPK = (AlianzaTelefonoPK) o;

			return (
			        this.ID_ALIANZA.equals(telefonoPK.ID_ALIANZA) &&
			        this.TIPO_TELEFONO.equals(telefonoPK.TIPO_TELEFONO)
			        );
		}

		return false;
	}
}