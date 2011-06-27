package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class BufferTarjetasPorCuentaBean implements EntityBean
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

	public String ejbCreate(String NRO_TARJETA, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, Integer ID_CUSO, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String NRO_FORMULARIO)throws CreateException {
		setNRO_TARJETA(NRO_TARJETA);
		setID_CUENTA(ID_CUENTA);
		setID_SUCURSAL_CUENTA(ID_SUCURSAL_CUENTA);
		setID_CUSO(ID_CUSO);
		setFECHA_TRANSMISION(FECHA_TRANSMISION);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setNRO_FORMULARIO(NRO_FORMULARIO);
		return null;
	}

	public void ejbPostCreate(String NRO_TARJETA, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, Integer ID_CUSO, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String NRO_FORMULARIO) {
	}

	// cmp field methods
	public abstract String getNRO_TARJETA();
	public abstract void setNRO_TARJETA(String NRO_TARJETA);

	public abstract Integer getID_CUENTA();
	public abstract void setID_CUENTA(Integer ID_CUENTA);

	public abstract Integer getID_SUCURSAL_CUENTA();
	public abstract void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA);

	public abstract Integer getID_CUSO();
	public abstract void setID_CUSO(Integer ID_CUSO);

	public abstract java.sql.Timestamp getFECHA_TRANSMISION();
	public abstract void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract String getNRO_FORMULARIO();
	public abstract void setNRO_FORMULARIO(String NRO_FORMULARIO);

}


