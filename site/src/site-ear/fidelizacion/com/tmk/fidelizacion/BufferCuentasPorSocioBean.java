package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class BufferCuentasPorSocioBean implements EntityBean
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

	public BufferCuentasPorSocioPK ejbCreate(Integer ID_CUENTA, Integer ID_SUCURSAL, Integer ID_CUSO, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer DPER_CODIGO, Integer COMPONENTE, java.sql.Timestamp FECHA_TRANSMISION, String CANJE_HABILITADO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI)throws CreateException {
		setID_CUENTA(ID_CUENTA);
		setID_SUCURSAL(ID_SUCURSAL);
		setID_CUSO(ID_CUSO);
		setID_SOCIO(ID_SOCIO);
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setDPER_CODIGO(DPER_CODIGO);
		setCOMPONENTE(COMPONENTE);
		setFECHA_TRANSMISION(FECHA_TRANSMISION);
		setCANJE_HABILITADO(CANJE_HABILITADO);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		return null;
	}

	public void ejbPostCreate(Integer ID_CUENTA, Integer ID_SUCURSAL, Integer ID_CUSO, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer DPER_CODIGO, Integer COMPONENTE, java.sql.Timestamp FECHA_TRANSMISION, String CANJE_HABILITADO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) {
	}

	// cmp field methods
	public abstract Integer getID_CUENTA();
	public abstract void setID_CUENTA(Integer ID_CUENTA);

	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_CUSO();
	public abstract void setID_CUSO(Integer ID_CUSO);

	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SUCURSAL_SOCIO();
	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getDPER_CODIGO();
	public abstract void setDPER_CODIGO(Integer DPER_CODIGO);

	public abstract Integer getCOMPONENTE();
	public abstract void setCOMPONENTE(Integer COMPONENTE);

	public abstract java.sql.Timestamp getFECHA_TRANSMISION();
	public abstract void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION);

	public abstract String getCANJE_HABILITADO();
	public abstract void setCANJE_HABILITADO(String CANJE_HABILITADO);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

}


