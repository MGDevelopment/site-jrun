/**
 * @author Lizardo Santiago
 *
 * $Log: ListaDeseosPK.java,v $
 * Revision 1.2  2003/12/04 17:20:15  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/03 21:50:32  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.src.listadeseos;

import java.io.Serializable;

public class ListaDeseosPK implements Serializable {

	public Integer ID_SUCURSAL_SOCIO;
	public Integer ID_SOCIO;

	public ListaDeseosPK() {
	}

	public ListaDeseosPK(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO) {
		this.ID_SUCURSAL_SOCIO = ID_SUCURSAL_SOCIO;
		this.ID_SOCIO = ID_SOCIO;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL_SOCIO);
		hash.append(this.ID_SOCIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}

	public boolean equals(Object o) {
		if (o instanceof ListaDeseosPK) {
			ListaDeseosPK listaPK = (ListaDeseosPK) o;

			return (
			        this.ID_SUCURSAL_SOCIO.equals(listaPK.ID_SUCURSAL_SOCIO) &&
			        this.ID_SOCIO.equals(listaPK.ID_SOCIO)
			        );
		}

		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer pk = new StringBuffer();
		pk.append(this.ID_SUCURSAL_SOCIO).append(" ");
		pk.append(this.ID_SOCIO);
		return pk.toString();
	}
}
