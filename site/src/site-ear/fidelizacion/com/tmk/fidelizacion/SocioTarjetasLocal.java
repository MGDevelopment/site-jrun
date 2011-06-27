package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface SocioTarjetasLocal extends EJBLocalObject
{
	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

	public String getID_USR_ALTA() ;
	public void setID_USR_ALTA(String ID_USR_ALTA) ;

	public String getID_USR_MODI() ;
	public void setID_USR_MODI(String ID_USR_MODI) ;

	public String getID_MEDIO_COBRO() ;
	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

}


