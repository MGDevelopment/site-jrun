package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class CarritoCompraBean implements EntityBean {

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

	public CarritoCompraPK ejbCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, java.util.Date FECHA) throws CreateException {
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setID_ARTICULO(ID_ARTICULO);
		setCANTIDAD(CANTIDAD);
		setFECHA(FECHA);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, java.util.Date FECHA) {
	}

	// cmp field methods
	public abstract Integer getID_SUCURSAL_SOCIO();

	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract Integer getCANTIDAD();

	public abstract void setCANTIDAD(Integer CANTIDAD);

	public abstract java.util.Date getFECHA();

	public abstract void setFECHA(java.util.Date FECHA);

}


