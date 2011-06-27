package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface PuntosPorSucursalLocal extends EJBLocalObject
{
	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public java.sql.Timestamp getMES() ;
	public void setMES(java.sql.Timestamp MES) ;

	public Integer getPUNTOS() ;
	public void setPUNTOS(Integer PUNTOS) ;

	public Long getFECHA_MODIFICACION() ;
	public void setFECHA_MODIFICACION(Long FECHA_MODIFICACION) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

	public Double getSALDO_X_APLICAR() ;
	public void setSALDO_X_APLICAR(Double SALDO_X_APLICAR) ;

	public Integer getSIGNO_SALDO() ;
	public void setSIGNO_SALDO(Integer SIGNO_SALDO) ;

	public Integer getID_SUCURSAL_CUENTA() ;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) ;

}


