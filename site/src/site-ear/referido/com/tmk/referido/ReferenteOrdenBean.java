package com.tmk.referido;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class ReferenteOrdenBean implements EntityBean
{
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

	public com.tmk.referido.ReferenteOrdenPK ejbCreate(Long CODIGO, Integer ID_ORDEN_REFERENTE)throws CreateException {
		setCODIGO(CODIGO);
		setID_ORDEN_REFERENTE(ID_ORDEN_REFERENTE);
		return null;
	}

	public void ejbPostCreate(Long CODIGO, Integer ID_ORDEN_REFERENTE) {
	}

	// cmp field methods
	public abstract Long getCODIGO();
	public abstract void setCODIGO(Long CODIGO);

	public abstract Integer getID_ORDEN_REFERENTE();
	public abstract void setID_ORDEN_REFERENTE(Integer ID_ORDEN_REFERENTE);


}


