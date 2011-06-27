package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class DisponibilidadBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_DISPONIBILIDAD, String DESCRIPCION, String PEDIDO_ESPECIAL) throws CreateException {
		setID_DISPONIBILIDAD(ID_DISPONIBILIDAD);
		setDESCRIPCION(DESCRIPCION);
		setPEDIDO_ESPECIAL(PEDIDO_ESPECIAL);
		return null;
	}

	public void ejbPostCreate(Integer ID_DISPONIBILIDAD, String DESCRIPCION, String PEDIDO_ESPECIAL) {
	}

	// cmp field methods
	public abstract Integer getID_DISPONIBILIDAD();

	public abstract void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getPEDIDO_ESPECIAL();

	public abstract void setPEDIDO_ESPECIAL(String PEDIDO_ESPECIAL);

}


