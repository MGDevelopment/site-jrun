/**
 * @author Lizardo Santiago
 *
 * $Log: CategGrupoPK.java,v $
 * Revision 1.6  2003/12/04 17:18:55  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/29 15:09:06  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import java.io.Serializable;

public class CategGrupoPK implements Serializable {

	public Integer CATEGORIA_SECCION;
	public Integer CATEGORIA_GRUPO;

	public CategGrupoPK() {
	}

	public CategGrupoPK(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO) {
		this.CATEGORIA_SECCION = CATEGORIA_SECCION;
		this.CATEGORIA_GRUPO = CATEGORIA_GRUPO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.CATEGORIA_SECCION);
		hash.append(this.CATEGORIA_GRUPO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof CategGrupoPK) {
			CategGrupoPK grupoPK = (CategGrupoPK) o;

			return (
			        this.CATEGORIA_SECCION.equals(grupoPK.CATEGORIA_SECCION) &&
			        this.CATEGORIA_GRUPO.equals(grupoPK.CATEGORIA_GRUPO)
			        );
		}

		return false;
	}
}
