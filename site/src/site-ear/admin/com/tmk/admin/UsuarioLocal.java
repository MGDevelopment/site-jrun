package com.tmk.admin;

import javax.ejb.EJBLocalObject;

public interface UsuarioLocal extends EJBLocalObject {

	public Integer getID_USUARIO();

	public void setID_USUARIO(Integer ID_USUARIO);

	public byte[] getLOGIN();

	public void setLOGIN(byte[] LOGIN);

	public byte[] getPASSWORD();

	public void setPASSWORD(byte[] PASSWORD);

	public String getNOMBRES();

	public void setNOMBRES(String NOMBRES);

	public String getAPELLIDOS();

	public void setAPELLIDOS(String APELLIDOS);

	public Integer getESTADO();

	public void setESTADO(Integer ESTADO);

	public java.sql.Timestamp getFECHA_ALTA();

	public void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA);

	public String getUSUARIO_ALTA();

	public void setUSUARIO_ALTA(String USUARIO_ALTA);

	public java.sql.Timestamp getFECHA_MODIF();

	public void setFECHA_MODIF(java.sql.Timestamp FECHA_MODIF);

	public String getUSUARIO_MODIF();

	public void setUSUARIO_MODIF(String USUARIO_MODIF);

}


