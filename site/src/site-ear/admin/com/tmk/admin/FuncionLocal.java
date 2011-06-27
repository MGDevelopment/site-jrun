package com.tmk.admin;

import javax.ejb.EJBLocalObject;

public interface FuncionLocal extends EJBLocalObject {

	public String getFUNCION();

	public void setFUNCION(String FUNCION);

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


