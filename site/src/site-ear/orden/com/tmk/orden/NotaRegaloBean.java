package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class NotaRegaloBean implements EntityBean {

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

	public NotaRegaloPK ejbCreate(Integer ID_ORDEN, Integer ID_ARTICULO, String NOTA_REGALO, Long ITEM) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_ARTICULO(ID_ARTICULO);
		setNOTA_REGALO(NOTA_REGALO);
		setITEM(ITEM);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, Integer ID_ARTICULO, String NOTA_REGALO, Long ITEM) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract String getNOTA_REGALO();

	public abstract void setNOTA_REGALO(String NOTA_REGALO);

	public abstract Long getITEM();

	public abstract void setITEM(Long ITEM);

}


