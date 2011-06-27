package com.tmk.socio;

import javax.ejb.EJBLocalObject;

public interface BufferSocioTelefonoLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public String getTIPO_TELEFONO();

	public void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public String getCOD_AREA();

	public void setCOD_AREA(String COD_AREA);

	public String getNRO_TEL();

	public void setNRO_TEL(String NRO_TEL);

	public String getEXT_INT();

	public void setEXT_INT(String EXT_INT);

	public String getCOMENTARIOS();

	public void setCOMENTARIOS(String COMENTARIOS);

	public String getOPERACION();

	public void setOPERACION(String OPERACION);

	public java.sql.Timestamp getF_ALTA();

	public void setF_ALTA(java.sql.Timestamp F_ALTA);

	public String getUSR_ALTA();

	public void setUSR_ALTA(String USR_ALTA);

	public java.sql.Timestamp getF_MODI();

	public void setF_MODI(java.sql.Timestamp F_MODI);

	public String getUSR_MODI();

	public void setUSR_MODI(String USR_MODI);

	public String getPROCESADO();

	public void setPROCESADO(String PROCESADO);
}
