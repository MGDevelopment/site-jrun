package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class AutorBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_AUTOR, String DESCRIPCION) throws CreateException {
		setID_AUTOR(ID_AUTOR);
		setDESCRIPCION(DESCRIPCION);
		return null;
	}

	public void ejbPostCreate(Integer ID_AUTOR, String DESCRIPCION) {
	}

	// cmp field methods
	public abstract Integer getID_AUTOR();

	public abstract void setID_AUTOR(Integer ID_AUTOR);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

}


