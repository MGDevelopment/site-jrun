package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class PedidoEspecialBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, java.util.Date FECHA, String TELEFONO, String HORARIO, String COMENTARIO, Integer ID_DISPONIBILIDAD, Integer ID_PEDIDO, Integer ID_CONSULTA, Integer ID_OPINION) throws CreateException {
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setID_ARTICULO(ID_ARTICULO);
		setFECHA(FECHA);
		setTELEFONO(TELEFONO);
		setHORARIO(HORARIO);
		setCOMENTARIO(COMENTARIO);
		setID_DISPONIBILIDAD(ID_DISPONIBILIDAD);
		setID_PEDIDO(ID_PEDIDO);
		setID_CONSULTA(ID_CONSULTA);
		setID_OPINION(ID_OPINION);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, java.util.Date FECHA, String TELEFONO, String HORARIO, String COMENTARIO, Integer ID_DISPONIBILIDAD, Integer ID_PEDIDO, Integer ID_CONSULTA, Integer ID_OPINION) {
	}

	// cmp field methods
	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SUCURSAL_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SOCIO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract Integer getID_ARTICULO();

	public abstract void setFECHA(java.util.Date FECHA);

	public abstract java.util.Date getFECHA();

	public abstract void setTELEFONO(String TELEFONO);

	public abstract String getTELEFONO();

	public abstract void setHORARIO(String HORARIO);

	public abstract String getHORARIO();

	public abstract void setCOMENTARIO(String COMENTARIO);

	public abstract String getCOMENTARIO();

	public abstract void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public abstract Integer getID_DISPONIBILIDAD();

	public abstract void setID_PEDIDO(Integer ID_PEDIDO);

	public abstract Integer getID_PEDIDO();

	public abstract void setID_CONSULTA(Integer ID_CONSULTA);

	public abstract Integer getID_CONSULTA();

	public abstract void setID_OPINION(Integer ID_OPINION);

	public abstract Integer getID_OPINION();

}


