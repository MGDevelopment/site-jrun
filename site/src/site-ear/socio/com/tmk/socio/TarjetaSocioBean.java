/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocioBean.java,v $
 * Revision 1.6  2003/12/04 17:21:17  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/10/09 19:30:13  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.4  2003/09/09 15:17:09  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class TarjetaSocioBean implements EntityBean {

	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public TarjetaSocioPK ejbCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ITEM, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_TITULAR, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN) throws CreateException {
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setID_ITEM(ID_ITEM);
		setID_MEDIO_COBRO(ID_MEDIO_COBRO);
		setNRO_TARJETA(NRO_TARJETA);
		setNOMBRE_TITULAR(NOMBRE_TITULAR);
		setTIPO_DOC(TIPO_DOC);
		setNRO_DOC(NRO_DOC);
		setDIRECCION_RESUMEN(DIRECCION_RESUMEN);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ITEM, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_TITULAR, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN) throws CreateException {
	}

	public abstract Integer getID_SUCURSAL_SOCIO();

	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_ITEM();

	public abstract void setID_ITEM(Integer ID_ITEM);

	public abstract String getID_MEDIO_COBRO();

	public abstract void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public abstract byte[] getNRO_TARJETA();

	public abstract void setNRO_TARJETA(byte[] NRO_TARJETA);

	public abstract String getNOMBRE_TITULAR();

	public abstract void setNOMBRE_TITULAR(String NOMBRE_TITULAR);

	public abstract String getTIPO_DOC();

	public abstract void setTIPO_DOC(String TIPO_DOC);

	public abstract Long getNRO_DOC();

	public abstract void setNRO_DOC(Long NRO_DOC);

	public abstract String getDIRECCION_RESUMEN();

	public abstract void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN);
}
