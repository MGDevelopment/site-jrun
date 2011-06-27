/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccionPK.java,v $
 * Revision 1.2  2003/12/04 17:18:38  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:52  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/09 20:35:23  SLizardo
 * no message
 *
 *
 */
package com.tmk.admin;

import java.io.Serializable;

public class AlianzaSeccionPK implements Serializable {

	public Integer ID_ALIANZA;
	public Integer ID_SECCION;

	public AlianzaSeccionPK() {
	}

	public AlianzaSeccionPK(Integer ID_ALIANZA, Integer ID_SECCION) {
		this.ID_ALIANZA = ID_ALIANZA;
		this.ID_SECCION = ID_SECCION;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ALIANZA);
		hash.append(this.ID_SECCION);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof AlianzaSeccionPK) {
			AlianzaSeccionPK seccionPK = (AlianzaSeccionPK) o;

			return (
			        this.ID_ALIANZA.equals(seccionPK.ID_ALIANZA) &&
			        this.ID_SECCION.equals(seccionPK.ID_SECCION)
			        );
		}

		return false;
	}
}