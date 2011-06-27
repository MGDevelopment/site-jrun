package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ProveedorBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_PROVEEDOR, String NOMBRE, String RAZON_SOCIAL) throws CreateException {
		setID_PROVEEDOR(ID_PROVEEDOR);
		setNOMBRE(NOMBRE);
		setRAZON_SOCIAL(RAZON_SOCIAL);
		return null;
	}

	public void ejbPostCreate(Integer ID_PROVEEDOR, String NOMBRE, String RAZON_SOCIAL) {
	}

	// cmp field methods
	public abstract Integer getID_PROVEEDOR();

	public abstract void setID_PROVEEDOR(Integer ID_PROVEEDOR);

	public abstract String getNOMBRE();

	public abstract void setNOMBRE(String NOMBRE);

	public abstract String getRAZON_SOCIAL();

	public abstract void setRAZON_SOCIAL(String RAZON_SOCIAL);

}


