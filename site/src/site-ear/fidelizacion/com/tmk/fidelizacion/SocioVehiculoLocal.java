package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface SocioVehiculoLocal extends EJBLocalObject
{
	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public Integer getID_SOVH() ;
	public void setID_SOVH(Integer ID_SOVH) ;

	public String getID_MARCA() ;
	public void setID_MARCA(String ID_MARCA) ;

	public String getID_MODELO() ;
	public void setID_MODELO(String ID_MODELO) ;

	public Integer getANIO_MODELO() ;
	public void setANIO_MODELO(Integer ANIO_MODELO) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

}


