/**
 * @author Lizardo Santiago
 *
 * $Log: CarritoListaDeseosPK.java,v $
 * Revision 1.4  2003/12/04 17:20:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/10/03 21:50:29  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.src.listadeseos;

import java.io.Serializable;

public class CarritoListaDeseosPK implements Serializable {

	public Integer ID_SUCURSAL_SOCIO;
	public Integer ID_SOCIO;
	public Integer ID_ARTICULO;

	public CarritoListaDeseosPK() {
	}

	public CarritoListaDeseosPK(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO) {
		this.ID_SUCURSAL_SOCIO = ID_SUCURSAL_SOCIO;
		this.ID_SOCIO = ID_SOCIO;
		this.ID_ARTICULO = ID_ARTICULO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL_SOCIO);
		hash.append(this.ID_SOCIO);
		hash.append(this.ID_ARTICULO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof CarritoListaDeseosPK) {
			CarritoListaDeseosPK carritoPK = (CarritoListaDeseosPK) o;

			return (
			        this.ID_SUCURSAL_SOCIO.equals(carritoPK.ID_SUCURSAL_SOCIO) &&
			        this.ID_SOCIO.equals(carritoPK.ID_SOCIO) &&
			        this.ID_ARTICULO.equals(carritoPK.ID_ARTICULO)
			        );
		}

		return false;
	}
	@Override
	public String toString() {
		StringBuffer pk = new StringBuffer();
		pk.append(this.ID_ARTICULO).append(" ");
		pk.append(this.ID_SOCIO).append(" ");
		pk.append(this.ID_SUCURSAL_SOCIO).append(" ");
		return pk.toString();
	}
}
