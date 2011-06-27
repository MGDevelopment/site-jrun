package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ArticuloAutoresBean implements EntityBean {

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

	public ArticuloAutoresPK ejbCreate(Integer ID_ARTICULO, Integer ID_AUTOR, Integer ORDEN, String ROLE) throws CreateException {
		setID_ARTICULO(ID_ARTICULO);
		setID_AUTOR(ID_AUTOR);
		setORDEN(ORDEN);
		setROLE(ROLE);
		return null;
	}

	public void ejbPostCreate(Integer ID_ARTICULO, Integer ID_AUTOR, Integer ORDEN, String ROLE) {
	}

	// cmp field methods
	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract Integer getID_AUTOR();

	public abstract void setID_AUTOR(Integer ID_AUTOR);

	public abstract Integer getORDEN();

	public abstract void setORDEN(Integer ORDEN);

	public abstract String getROLE();

	public abstract void setROLE(String ROLE);

}


