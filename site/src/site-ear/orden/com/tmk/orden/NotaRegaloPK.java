/**
 * @author Lizardo Santiago
 *
 * $Log: NotaRegaloPK.java,v $
 * Revision 1.5  2005/11/04 12:55:37  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.4  2003/10/03 16:29:48  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/11 15:21:44  SLizardo
 * no message
 *
 *
 */
package com.tmk.orden;

import java.io.Serializable;

public class NotaRegaloPK implements Serializable {

	public Integer ID_ORDEN;
	public Integer ID_ARTICULO;
	public Long ITEM;

	public NotaRegaloPK() {
	}

	public NotaRegaloPK(Integer ID_ORDEN, Integer ID_ARTICULO, Long ITEM) {
		this.ID_ORDEN = ID_ORDEN;
		this.ID_ARTICULO = ID_ARTICULO;
		this.ITEM = ITEM;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_ORDEN);
		hash.append(this.ID_ARTICULO);
		hash.append(this.ITEM);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof NotaRegaloPK) {
			NotaRegaloPK notaPK = (NotaRegaloPK) o;

			return (
			        this.ID_ORDEN.equals(notaPK.ID_ORDEN) &&
			        this.ID_ARTICULO.equals(notaPK.ID_ARTICULO) &&
			        this.ITEM.equals(notaPK.ITEM)
			        );
		}

		return false;
	}
}


