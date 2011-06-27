package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class SocioVehiculoBean implements EntityBean
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

	public SocioVehiculo ejbCreate(Integer ID_SOCIO, Integer ID_SUCURSAL, Integer ID_SOVH, String ID_MARCA, String ID_MODELO, Integer ANIO_MODELO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI)throws CreateException {
		setID_SOCIO(ID_SOCIO);
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOVH(ID_SOVH);
		setID_MARCA(ID_MARCA);
		setID_MODELO(ID_MODELO);
		setANIO_MODELO(ANIO_MODELO);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		return null;
	}

	public void ejbPostCreate(Integer ID_SOCIO, Integer ID_SUCURSAL, Integer ID_SOVH, String ID_MARCA, String ID_MODELO, Integer ANIO_MODELO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) {
	}

	// cmp field methods
	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOVH();
	public abstract void setID_SOVH(Integer ID_SOVH);

	public abstract String getID_MARCA();
	public abstract void setID_MARCA(String ID_MARCA);

	public abstract String getID_MODELO();
	public abstract void setID_MODELO(String ID_MODELO);

	public abstract Integer getANIO_MODELO();
	public abstract void setANIO_MODELO(Integer ANIO_MODELO);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

}


