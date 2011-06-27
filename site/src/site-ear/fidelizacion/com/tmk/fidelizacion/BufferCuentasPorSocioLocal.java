package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface BufferCuentasPorSocioLocal extends EJBLocalObject
{
	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public Integer getID_CUSO() ;
	public void setID_CUSO(Integer ID_CUSO) ;

	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

	public Integer getID_SUCURSAL_SOCIO() ;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) ;

	public Integer getDPER_CODIGO() ;
	public void setDPER_CODIGO(Integer DPER_CODIGO) ;

	public Integer getCOMPONENTE() ;
	public void setCOMPONENTE(Integer COMPONENTE) ;

	public java.sql.Timestamp getFECHA_TRANSMISION() ;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) ;

	public String getCANJE_HABILITADO() ;
	public void setCANJE_HABILITADO(String CANJE_HABILITADO) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

}


