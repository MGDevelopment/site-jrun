package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class BufferSocioTelefonoBean implements EntityBean {

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

	public BufferSocioTelefonoPK ejbCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, String OPERACION, java.sql.Timestamp F_ALTA, String USR_ALTA, java.sql.Timestamp F_MODI, String USR_MODI, String PROCESADO) throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOCIO(ID_SOCIO);
		setTIPO_TELEFONO(TIPO_TELEFONO);
		setCOD_AREA(COD_AREA);
		setNRO_TEL(NRO_TEL);
		setEXT_INT(EXT_INT);
		setCOMENTARIOS(COMENTARIOS);
		setOPERACION(OPERACION);
		setF_ALTA(F_ALTA);
		setUSR_ALTA(USR_ALTA);
		setF_MODI(F_MODI);
		setUSR_MODI(USR_MODI);
		setPROCESADO(PROCESADO);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, String OPERACION, java.sql.Timestamp F_ALTA, String USR_ALTA, java.sql.Timestamp F_MODI, String USR_MODI, String PROCESADO) {
	}

	// cmp field methods
	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract String getTIPO_TELEFONO();

	public abstract void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public abstract String getCOD_AREA();

	public abstract void setCOD_AREA(String COD_AREA);

	public abstract String getNRO_TEL();

	public abstract void setNRO_TEL(String NRO_TEL);

	public abstract String getEXT_INT();

	public abstract void setEXT_INT(String EXT_INT);

	public abstract String getCOMENTARIOS();

	public abstract void setCOMENTARIOS(String COMENTARIOS);

	public abstract String getOPERACION();

	public abstract void setOPERACION(String OPERACION);

	public abstract java.sql.Timestamp getF_ALTA();

	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_ALTA();

	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_MODI();

	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract String getUSR_MODI();

	public abstract void setUSR_MODI(String USR_MODI);

	public abstract String getPROCESADO();

	public abstract void setPROCESADO(String PROCESADO);
}
