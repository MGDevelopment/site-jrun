package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface BufferTarjetasPorCuentaLocal extends EJBLocalObject
{
	public String getNRO_TARJETA() ;
	public void setNRO_TARJETA(String NRO_TARJETA) ;

	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public Integer getID_SUCURSAL_CUENTA() ;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) ;

	public Integer getID_CUSO() ;
	public void setID_CUSO(Integer ID_CUSO) ;

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

	public String getNRO_FORMULARIO() ;
	public void setNRO_FORMULARIO(String NRO_FORMULARIO) ;

}


