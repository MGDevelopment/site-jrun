package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class MedioDeCobroBean implements EntityBean {

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

	public String ejbCreate(String ID_MEDIO_COBRO, String DESCRIPCION, String TIPO, String HABILITADO_TEMATIKA) throws CreateException {
		setID_MEDIO_COBRO(ID_MEDIO_COBRO);
		setDESCRIPCION(DESCRIPCION);
		setTIPO(TIPO);
		setHABILITADO_TEMATIKA(HABILITADO_TEMATIKA);
		return null;
	}

	public void ejbPostCreate(String ID_MEDIO_COBRO, String DESCRIPCION, String TIPO, String HABILITADO_TEMATIKA) {
	}

	// cmp field methods
	public abstract String getID_MEDIO_COBRO();

	public abstract void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getTIPO();

	public abstract void setTIPO(String TIPO);

	public abstract String getHABILITADO_TEMATIKA();

	public abstract void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

}


