package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface BufferCuentaLocal extends EJBLocalObject
{
	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public java.sql.Timestamp getFECHA_APERTURA() ;
	public void setFECHA_APERTURA(java.sql.Timestamp FECHA_APERTURA) ;

	public String getESTADO() ;
	public void setESTADO(String ESTADO) ;

	public java.sql.Timestamp getESTADO_FECHA() ;
	public void setESTADO_FECHA(java.sql.Timestamp ESTADO_FECHA) ;

	public String getESTADO_USR() ;
	public void setESTADO_USR(String ESTADO_USR) ;

	public java.sql.Timestamp getFECHA_TRANSMISION() ;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

}


