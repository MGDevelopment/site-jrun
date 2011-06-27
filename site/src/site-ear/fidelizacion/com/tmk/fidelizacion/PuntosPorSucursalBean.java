package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;


public abstract class PuntosPorSucursalBean implements EntityBean
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

	public PuntosPorSucursalPK ejbCreate(Integer ID_CUENTA, Integer ID_SUCURSAL, java.sql.Timestamp MES, Integer PUNTOS, Long FECHA_MODIFICACION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, Double SALDO_X_APLICAR, Integer SIGNO_SALDO, Integer ID_SUCURSAL_CUENTA)throws CreateException {
		setID_CUENTA(ID_CUENTA);
		setID_SUCURSAL(ID_SUCURSAL);
		setMES(MES);
		setPUNTOS(PUNTOS);
		setFECHA_MODIFICACION(FECHA_MODIFICACION);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setSALDO_X_APLICAR(SALDO_X_APLICAR);
		setSIGNO_SALDO(SIGNO_SALDO);
		setID_SUCURSAL_CUENTA(ID_SUCURSAL_CUENTA);
		return null;
	}

	public void ejbPostCreate(Integer ID_CUENTA, Integer ID_SUCURSAL, java.sql.Timestamp MES, Integer PUNTOS, Long FECHA_MODIFICACION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, Double SALDO_X_APLICAR, Integer SIGNO_SALDO, Integer ID_SUCURSAL_CUENTA) {
	}

	// cmp field methods
	public abstract Integer getID_CUENTA();
	public abstract void setID_CUENTA(Integer ID_CUENTA);

	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract java.sql.Timestamp getMES();
	public abstract void setMES(java.sql.Timestamp MES);

	public abstract Integer getPUNTOS();
	public abstract void setPUNTOS(Integer PUNTOS);

	public abstract Long getFECHA_MODIFICACION();
	public abstract void setFECHA_MODIFICACION(Long FECHA_MODIFICACION);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract Double getSALDO_X_APLICAR();
	public abstract void setSALDO_X_APLICAR(Double SALDO_X_APLICAR);

	public abstract Integer getSIGNO_SALDO();
	public abstract void setSIGNO_SALDO(Integer SIGNO_SALDO);

	public abstract Integer getID_SUCURSAL_CUENTA();
	public abstract void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA);

}


