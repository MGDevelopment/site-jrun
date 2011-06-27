package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class BufferTarjetaBean implements EntityBean
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

	public String ejbCreate(String NRO_TARJETA, String ESTADO, java.sql.Timestamp ESTADO_FECHA, String ESTADO_USR, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI)throws CreateException {
		setNRO_TARJETA(NRO_TARJETA);
		setESTADO(ESTADO);
		setESTADO_FECHA(ESTADO_FECHA);
		setESTADO_USR(ESTADO_USR);
		setFECHA_TRANSMISION(FECHA_TRANSMISION);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		return null;
	}

	public void ejbPostCreate(String NRO_TARJETA, String ESTADO, java.sql.Timestamp ESTADO_FECHA, String ESTADO_USR, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) {
	}

	// cmp field methods
	public abstract String getNRO_TARJETA();
	public abstract void setNRO_TARJETA(String NRO_TARJETA);

	public abstract String getESTADO();
	public abstract void setESTADO(String ESTADO);

	public abstract java.sql.Timestamp getESTADO_FECHA();
	public abstract void setESTADO_FECHA(java.sql.Timestamp ESTADO_FECHA);

	public abstract String getESTADO_USR();
	public abstract void setESTADO_USR(String ESTADO_USR);

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

}


