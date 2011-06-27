/**
 * @author Lizardo Santiago
 *
 * $Log: SocioPK.java,v $
 * Revision 1.7  2006/06/22 18:31:34  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.6  2003/12/04 17:21:14  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/09 15:52:53  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import java.io.Serializable;

public class SocioPK implements Serializable {

	public Integer ID_SUCURSAL;
	public Integer ID_SOCIO;

	public SocioPK() {
	}

	public SocioPK(Integer ID_SUCURSAL, Integer ID_SOCIO) {
		this.ID_SUCURSAL = ID_SUCURSAL;
		this.ID_SOCIO = ID_SOCIO;
	}

	public boolean equals(Object o) {
		if (o instanceof SocioPK) {
			SocioPK socioPK = (SocioPK) o;

			return (
			        this.ID_SUCURSAL.equals(socioPK.ID_SUCURSAL) &&
			        this.ID_SOCIO.equals(socioPK.ID_SOCIO)
			        );
		}

		return false;
	}

	public int hashCode() {
		StringBuffer hash = new StringBuffer();
		hash.append(this.ID_SUCURSAL);
		hash.append(this.ID_SOCIO);

		int hashCode = hash.toString().hashCode();

		return hashCode;
	}
	
	public String toString() {
		return ID_SUCURSAL + " " + ID_SOCIO;
	}
}
