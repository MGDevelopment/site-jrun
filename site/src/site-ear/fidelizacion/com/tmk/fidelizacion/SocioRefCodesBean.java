package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;


public abstract class SocioRefCodesBean implements EntityBean
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

	public SocioRefCodesPK ejbCreate(Integer ID_SOCIO, Integer ID_SUCURSAL, String DOMAIN, String LOW_VALUE, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String CARACTER, Double NUMERO, java.sql.Timestamp FECHA)throws CreateException {
		setID_SOCIO(ID_SOCIO);
		setID_SUCURSAL(ID_SUCURSAL);
		setDOMAIN(DOMAIN);
		setLOW_VALUE(LOW_VALUE);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setCARACTER(CARACTER);
		setNUMERO(NUMERO);
		setFECHA(FECHA);
		return null;
	}

	public void ejbPostCreate(Integer ID_SOCIO, Integer ID_SUCURSAL, String DOMAIN, String LOW_VALUE, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String CARACTER, Double NUMERO, java.sql.Timestamp FECHA) {
	}

	// cmp field methods
	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract String getDOMAIN();
	public abstract void setDOMAIN(String DOMAIN);

	public abstract String getLOW_VALUE();
	public abstract void setLOW_VALUE(String LOW_VALUE);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract String getCARACTER();
	public abstract void setCARACTER(String CARACTER);

	public abstract Double getNUMERO();
	public abstract void setNUMERO(Double NUMERO);

	public abstract java.sql.Timestamp getFECHA();
	public abstract void setFECHA(java.sql.Timestamp FECHA);

}


