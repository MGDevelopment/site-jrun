/**
 * @author Lizardo Santiago
 *
 * $Log: CategSubFamiliaPK.java,v $
 * Revision 1.6  2003/12/04 17:18:59  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/29 15:09:11  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import java.io.Serializable;

public class CategSubFamiliaPK implements Serializable {

	public Integer CATEGORIA_SECCION;
	public Integer CATEGORIA_GRUPO;
	public Integer CATEGORIA_FAMILIA;
	public Integer CATEGORIA_SUBFAMILIA;

	public CategSubFamiliaPK() {
	}

	public CategSubFamiliaPK(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, Integer CATEGORIA_SUBFAMILIA) {
		this.CATEGORIA_SECCION = CATEGORIA_SECCION;
		this.CATEGORIA_GRUPO = CATEGORIA_GRUPO;
		this.CATEGORIA_FAMILIA = CATEGORIA_FAMILIA;
		this.CATEGORIA_SUBFAMILIA = CATEGORIA_SUBFAMILIA;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.CATEGORIA_SECCION);
		hash.append(this.CATEGORIA_GRUPO);
		hash.append(this.CATEGORIA_FAMILIA);
		hash.append(this.CATEGORIA_SUBFAMILIA);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof CategSubFamiliaPK) {
			CategSubFamiliaPK subFamiliaPK = (CategSubFamiliaPK) o;

			return (
			        this.CATEGORIA_SECCION.equals(subFamiliaPK.CATEGORIA_SECCION) &&
			        this.CATEGORIA_GRUPO.equals(subFamiliaPK.CATEGORIA_GRUPO) &&
			        this.CATEGORIA_FAMILIA.equals(subFamiliaPK.CATEGORIA_FAMILIA) &&
			        this.CATEGORIA_SUBFAMILIA.equals(subFamiliaPK.CATEGORIA_SUBFAMILIA)
			        );
		}

		return false;
	}
}
