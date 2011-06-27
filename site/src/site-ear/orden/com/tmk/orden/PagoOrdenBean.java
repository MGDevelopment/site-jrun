package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class PagoOrdenBean implements EntityBean {

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

	public PagoOrdenPK ejbCreate(Integer ID_ORDEN, String ID_MEDIO_COBRO, Double IMPORTE, Integer CUOTAS, Double COEFICIENTE, Integer MONEDA, Double CAMBIO) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_MEDIO_COBRO(ID_MEDIO_COBRO);
		setIMPORTE(IMPORTE);
		setCUOTAS(CUOTAS);
		setCOEFICIENTE(COEFICIENTE);
		setMONEDA(MONEDA);
		setCAMBIO(CAMBIO);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, String ID_MEDIO_COBRO, Double IMPORTE, Integer CUOTAS, Double COEFICIENTE, Integer MONEDA, Double CAMBIO) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract String getID_MEDIO_COBRO();

	public abstract void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public abstract Double getIMPORTE();

	public abstract void setIMPORTE(Double IMPORTE);

	public abstract void setCUOTAS(Integer CUOTAS);

	public abstract Integer getCUOTAS();

	public abstract void setCOEFICIENTE(Double COEFICIENTE);

	public abstract Double getCOEFICIENTE();

	public abstract void setMONEDA(Integer MONEDA);

	public abstract Integer getMONEDA();

	public abstract void setCAMBIO(Double CAMBIO);

	public abstract Double getCAMBIO();

}


