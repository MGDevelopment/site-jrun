package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ImpuestoBean implements EntityBean {

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

	public String ejbCreate(String ID_IMPUESTO, String DESCRIPCION, String CUENTA_MASCARA, String ANULADO) throws CreateException {
		setID_IMPUESTO(ID_IMPUESTO);
		setDESCRIPCION(DESCRIPCION);
		setCUENTA_MASCARA(CUENTA_MASCARA);
		setANULADO(ANULADO);
		return null;
	}

	public void ejbPostCreate(String ID_IMPUESTO, String DESCRIPCION, String CUENTA_MASCARA, String ANULADO) {
	}

	// cmp field methods
	public abstract String getID_IMPUESTO();

	public abstract void setID_IMPUESTO(String ID_IMPUESTO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getCUENTA_MASCARA();

	public abstract void setCUENTA_MASCARA(String CUENTA_MASCARA);

	public abstract String getANULADO();

	public abstract void setANULADO(String ANULADO);

}


