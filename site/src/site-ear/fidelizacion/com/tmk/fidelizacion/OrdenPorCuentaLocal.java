package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface OrdenPorCuentaLocal extends EJBLocalObject
{
	public Integer getID_ORDEN() ;
	public void setID_ORDEN(Integer ID_ORDEN) ;

	public Integer getID_SUCURSAL_SOCIO() ;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) ;

	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

	public Integer getID_SUCURSAL_CUENTA() ;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) ;

	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public String getNRO_TARJETA() ;
	public void setNRO_TARJETA(String NRO_TARJETA) ;

}


