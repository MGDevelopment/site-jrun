package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ItemOrdenImpuestoBean implements EntityBean {

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

	public ItemOrdenImpuestoPK ejbCreate(Integer ID_ORDEN, Integer ID_ARTICULO, Double TASA_GRAL, Double VALOR_TASA_GRAL, Double TASA_PERCEP_VIDEO, Double VALOR_PERCEP_VIDEO, Long ITEM) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_ARTICULO(ID_ARTICULO);
		setTASA_GRAL(TASA_GRAL);
		setVALOR_TASA_GRAL(VALOR_TASA_GRAL);
		setTASA_PERCEP_VIDEO(TASA_PERCEP_VIDEO);
		setVALOR_PERCEP_VIDEO(VALOR_PERCEP_VIDEO);
		setITEM(ITEM);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, Integer ID_ARTICULO, Double TASA_GRAL, Double VALOR_TASA_GRAL, Double TASA_PERCEP_VIDEO, Double VALOR_PERCEP_VIDEO, Long ITEM) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract Double getTASA_GRAL();

	public abstract void setTASA_GRAL(Double TASA_GRAL);

	public abstract Double getVALOR_TASA_GRAL();

	public abstract void setVALOR_TASA_GRAL(Double VALOR_TASA_GRAL);

	public abstract Double getTASA_PERCEP_VIDEO();

	public abstract void setTASA_PERCEP_VIDEO(Double TASA_PERCEP_VIDEO);

	public abstract Double getVALOR_PERCEP_VIDEO();

	public abstract void setVALOR_PERCEP_VIDEO(Double VALOR_PERCEP_VIDEO);

	public abstract Long getITEM();

	public abstract void setITEM(Long ITEM);

}


