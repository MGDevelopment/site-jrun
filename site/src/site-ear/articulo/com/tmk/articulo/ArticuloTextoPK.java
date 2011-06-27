/**
 * @author Lizardo Santiago
 *
 * $Log: ArticuloTextoPK.java,v $
 * Revision 1.4  2003/10/03 16:28:44  GPistoia
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

public class ArticuloTextoPK implements Serializable {

	public Integer ID_ARTICULO;
	public String TIPO;
	public Integer PARTE;

	public ArticuloTextoPK() {
	}

	public ArticuloTextoPK(Integer ID_ARTICULO, String TIPO, Integer PARTE) {
		this.ID_ARTICULO = ID_ARTICULO;
		this.TIPO = TIPO;
		this.PARTE = PARTE;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ARTICULO);
		hash.append(this.TIPO);
		hash.append(this.PARTE);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof ArticuloTextoPK) {
			ArticuloTextoPK textoPK = (ArticuloTextoPK) o;

			return (
			        this.ID_ARTICULO.equals(textoPK.ID_ARTICULO) &&
			        this.TIPO.equals(textoPK.TIPO) &&
			        this.PARTE.equals(textoPK.PARTE)
			        );
		}

		return false;
	}
}
