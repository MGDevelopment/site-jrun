package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class BufferFormularioBean implements EntityBean
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

	public String ejbCreate(String NRO_FORMULARIO, java.sql.Timestamp FECHA, String DATOS_ADICIONALES, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA_TRANSMISION, Integer DPER_CODIGO)throws CreateException {
		setNRO_FORMULARIO(NRO_FORMULARIO);
		setFECHA(FECHA);
		setDATOS_ADICIONALES(DATOS_ADICIONALES);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setFECHA_TRANSMISION(FECHA_TRANSMISION);
		setDPER_CODIGO(DPER_CODIGO);
		return null;
	}

	public void ejbPostCreate(String NRO_FORMULARIO, java.sql.Timestamp FECHA, String DATOS_ADICIONALES, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA_TRANSMISION, Integer DPER_CODIGO) {
	}

	// cmp field methods
	public abstract String getNRO_FORMULARIO();
	public abstract void setNRO_FORMULARIO(String NRO_FORMULARIO);

	public abstract java.sql.Timestamp getFECHA();
	public abstract void setFECHA(java.sql.Timestamp FECHA);

	public abstract String getDATOS_ADICIONALES();
	public abstract void setDATOS_ADICIONALES(String DATOS_ADICIONALES);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract java.sql.Timestamp getFECHA_TRANSMISION();
	public abstract void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION);

	public abstract Integer getDPER_CODIGO();
	public abstract void setDPER_CODIGO(Integer DPER_CODIGO);

}


