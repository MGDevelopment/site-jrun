package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class TipoDeArticuloBean implements EntityBean {

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

	public String ejbCreate(String ID_TIPO_ARTICULO, String DESCRIPCION, String CUENTA_MASCARA) throws CreateException {
		setID_TIPO_ARTICULO(ID_TIPO_ARTICULO);
		setDESCRIPCION(DESCRIPCION);
		setCUENTA_MASCARA(CUENTA_MASCARA);
		return null;
	}

	public void ejbPostCreate(String ID_TIPO_ARTICULO, String DESCRIPCION, String CUENTA_MASCARA) {
	}

	// cmp field methods
	public abstract String getID_TIPO_ARTICULO();

	public abstract void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getCUENTA_MASCARA();

	public abstract void setCUENTA_MASCARA(String CUENTA_MASCARA);

}


