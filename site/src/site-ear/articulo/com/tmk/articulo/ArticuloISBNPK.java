/**
 * @author Lizardo Santiago
 *
 * $Log: ArticuloISBNPK.java,v $
 * Revision 1.4  2003/10/03 16:28:43  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/11 15:21:33  SLizardo
 * no message
 *
 *
 */
package com.tmk.articulo;

import java.io.Serializable;

public class ArticuloISBNPK implements Serializable {

	public Integer ID_ARTICULO;
	public String ISBN;

	public ArticuloISBNPK() {
	}

	public ArticuloISBNPK(Integer ID_ARTICULO, String ISBN) {
		this.ID_ARTICULO = ID_ARTICULO;
		this.ISBN = ISBN;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ARTICULO);
		hash.append(this.ISBN);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof ArticuloISBNPK) {
			ArticuloISBNPK isbnPK = (ArticuloISBNPK) o;

			return (
			        this.ID_ARTICULO.equals(isbnPK.ID_ARTICULO) &&
			        this.ISBN.equals(isbnPK.ISBN)
			        );
		}

		return false;
	}
}
