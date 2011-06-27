package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class PaisBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_PAIS, String DESCRIPCION, String HABILITADO_TEMATIKA) throws CreateException {
		setID_PAIS(ID_PAIS);
		setDESCRIPCION(DESCRIPCION);
		setHABILITADO_TEMATIKA(HABILITADO_TEMATIKA);
		return null;
	}

	public void ejbPostCreate(Integer ID_PAIS, String DESCRIPCION, String HABILITADO_TEMATIKA) {
	}

	// cmp field methods
	public abstract Integer getID_PAIS();

	public abstract void setID_PAIS(Integer ID_PAIS);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getHABILITADO_TEMATIKA();

	public abstract void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

}


