package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class MetodoDeEnvioBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_METODO_ENVIO, String DESCRIPCION, String URL, String HABILITADO) throws CreateException {
		setID_METODO_ENVIO(ID_METODO_ENVIO);
		setDESCRIPCION(DESCRIPCION);
		setURL(URL);
		setHABILITADO(HABILITADO);
		return null;
	}

	public void ejbPostCreate(Integer ID_METODO_ENVIO, String DESCRIPCION, String URL, String HABILITADO) {
	}

	// cmp field methods
	public abstract Integer getID_METODO_ENVIO();

	public abstract void setID_METODO_ENVIO(Integer ID_METODO_ENVIO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getURL();

	public abstract void setURL(String URL);

	public abstract String getHABILITADO();

	public abstract void setHABILITADO(String HABILITADO);

}


