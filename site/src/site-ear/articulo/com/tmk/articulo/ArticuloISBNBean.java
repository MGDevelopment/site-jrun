package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ArticuloISBNBean implements EntityBean {

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

	public ArticuloISBNPK ejbCreate(Integer ID_ARTICULO, String ISBN, String TIPO_CODIGO) throws CreateException {
		setID_ARTICULO(ID_ARTICULO);
		setISBN(ISBN);
		setTIPO_CODIGO(TIPO_CODIGO);
		return null;
	}

	public void ejbPostCreate(Integer ID_ARTICULO, String ISBN, String TIPO_CODIGO) {
	}

	// cmp field methods
	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract String getISBN();

	public abstract void setISBN(String ISBN);

	public abstract String getTIPO_CODIGO();

	public abstract void setTIPO_CODIGO(String TIPO_CODIGO);

}


