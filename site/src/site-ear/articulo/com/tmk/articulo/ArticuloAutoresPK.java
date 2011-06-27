/**
 * @author Lizardo Santiago
 *
 * $Log: ArticuloAutoresPK.java,v $
 * Revision 1.4  2003/10/03 16:28:42  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/11 15:21:32  SLizardo
 * no message
 *
 *
 */
package com.tmk.articulo;

import java.io.Serializable;

public class ArticuloAutoresPK implements Serializable {

	public Integer ID_ARTICULO;
	public Integer ID_AUTOR;
	public String ROLE;

	public ArticuloAutoresPK() {
	}

	public ArticuloAutoresPK(Integer ID_ARTICULO, Integer ID_AUTOR, String ROLE) {
		this.ID_ARTICULO = ID_ARTICULO;
		this.ID_AUTOR = ID_AUTOR;
		this.ROLE = ROLE;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ARTICULO);
		hash.append(this.ID_AUTOR);
		hash.append(this.ROLE);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof ArticuloAutoresPK) {
			ArticuloAutoresPK autorPK = (ArticuloAutoresPK) o;

			return (
			        this.ID_ARTICULO.equals(autorPK.ID_ARTICULO) &&
			        this.ID_AUTOR.equals(autorPK.ID_AUTOR) &&
			        this.ROLE.equals(autorPK.ROLE)
			        );
		}

		return false;
	}
}
