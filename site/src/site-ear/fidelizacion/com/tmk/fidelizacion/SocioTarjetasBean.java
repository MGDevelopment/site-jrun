package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;


public abstract class SocioTarjetasBean implements EntityBean
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

	public SocioTarjetasPK ejbCreate(String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String ID_USR_ALTA, String ID_USR_MODI, String ID_MEDIO_COBRO, Integer ID_SUCURSAL, Integer ID_SOCIO)throws CreateException {
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setID_USR_ALTA(ID_USR_ALTA);
		setID_USR_MODI(ID_USR_MODI);
		setID_MEDIO_COBRO(ID_MEDIO_COBRO);
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOCIO(ID_SOCIO);
		return null;
	}

	public void ejbPostCreate(String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String ID_USR_ALTA, String ID_USR_MODI, String ID_MEDIO_COBRO, Integer ID_SUCURSAL, Integer ID_SOCIO) {
	}

	// cmp field methods
	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract String getID_USR_ALTA();
	public abstract void setID_USR_ALTA(String ID_USR_ALTA);

	public abstract String getID_USR_MODI();
	public abstract void setID_USR_MODI(String ID_USR_MODI);

	public abstract String getID_MEDIO_COBRO();
	public abstract void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

}


