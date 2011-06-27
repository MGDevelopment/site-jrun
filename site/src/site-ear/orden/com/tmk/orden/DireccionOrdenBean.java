package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class DireccionOrdenBean implements EntityBean {

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

	public DireccionOrdenPK ejbCreate(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setTIPO_DOMICILIO(TIPO_DOMICILIO);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract Integer getID_SUCURSAL_SOCIO();

	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract String getTIPO_DOMICILIO();

	public abstract void setTIPO_DOMICILIO(String TIPO_DOMICILIO);

}


