package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class LocalidadBean implements EntityBean {

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

	public LocalidadPK ejbCreate(Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String DESCRIPCION, String HABILITADO_TEMATIKA) throws CreateException {
		setID_PAIS(ID_PAIS);
		setID_PROVINCIA(ID_PROVINCIA);
		setID_LOCALIDAD(ID_LOCALIDAD);
		setDESCRIPCION(DESCRIPCION);
		setHABILITADO_TEMATIKA(HABILITADO_TEMATIKA);
		return null;
	}

	public void ejbPostCreate(Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String DESCRIPCION, String HABILITADO_TEMATIKA) {
	}

	// cmp field methods
	public abstract Integer getID_PAIS();

	public abstract void setID_PAIS(Integer ID_PAIS);

	public abstract Integer getID_PROVINCIA();

	public abstract void setID_PROVINCIA(Integer ID_PROVINCIA);

	public abstract Integer getID_LOCALIDAD();

	public abstract void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract String getHABILITADO_TEMATIKA();

	public abstract void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

}


