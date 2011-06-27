package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;


public abstract class OrdenPorCuentaBean implements EntityBean
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

	public Integer ejbCreate(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_SUCURSAL_CUENTA, Integer ID_CUENTA, String NRO_TARJETA)throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setID_SUCURSAL_CUENTA(ID_SUCURSAL_CUENTA);
		setID_CUENTA(ID_CUENTA);
		setNRO_TARJETA(NRO_TARJETA);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_SUCURSAL_CUENTA, Integer ID_CUENTA, String NRO_TARJETA) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();
	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract Integer getID_SUCURSAL_SOCIO();
	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SUCURSAL_CUENTA();
	public abstract void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA);

	public abstract Integer getID_CUENTA();
	public abstract void setID_CUENTA(Integer ID_CUENTA);

	public abstract String getNRO_TARJETA();
	public abstract void setNRO_TARJETA(String NRO_TARJETA);

}


