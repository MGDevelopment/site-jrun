package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class MonedaBean implements EntityBean {

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

	public String ejbCreate(String ID_MONEDA, String DESCRIPCION) throws CreateException {
		setID_MONEDA(ID_MONEDA);
		setDESCRIPCION(DESCRIPCION);
		return null;
	}

	public void ejbPostCreate(String ID_MONEDA, String DESCRIPCION) {
	}

	// cmp field methods
	public abstract String getID_MONEDA();

	public abstract void setID_MONEDA(String ID_MONEDA);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

}


