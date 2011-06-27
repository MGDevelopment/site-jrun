/**
 * @author Lizardo Santiago
 *
 * $Log: CategFamiliaPK.java,v $
 * Revision 1.6  2003/12/04 17:18:53  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/29 15:09:03  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import java.io.Serializable;

public class CategFamiliaPK implements Serializable {

	public Integer CATEGORIA_SECCION;
	public Integer CATEGORIA_GRUPO;
	public Integer CATEGORIA_FAMILIA;

	public CategFamiliaPK() {
	}

	public CategFamiliaPK(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA) {
		this.CATEGORIA_SECCION = CATEGORIA_SECCION;
		this.CATEGORIA_GRUPO = CATEGORIA_GRUPO;
		this.CATEGORIA_FAMILIA = CATEGORIA_FAMILIA;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.CATEGORIA_SECCION);
		hash.append(this.CATEGORIA_GRUPO);
		hash.append(this.CATEGORIA_FAMILIA);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof CategSubFamiliaPK) {
			CategSubFamiliaPK familiaPK = (CategSubFamiliaPK) o;

			return (
			        this.CATEGORIA_SECCION.equals(familiaPK.CATEGORIA_SECCION) &&
			        this.CATEGORIA_GRUPO.equals(familiaPK.CATEGORIA_GRUPO) &&
			        this.CATEGORIA_FAMILIA.equals(familiaPK.CATEGORIA_FAMILIA)
			        );
		}

		return false;
	}
}
