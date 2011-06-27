package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface BufferFormularioLocal extends EJBLocalObject
{
	public String getNRO_FORMULARIO() ;
	public void setNRO_FORMULARIO(String NRO_FORMULARIO) ;

	public java.sql.Timestamp getFECHA() ;
	public void setFECHA(java.sql.Timestamp FECHA) ;

	public String getDATOS_ADICIONALES() ;
	public void setDATOS_ADICIONALES(String DATOS_ADICIONALES) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

	public java.sql.Timestamp getFECHA_TRANSMISION() ;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) ;

	public Integer getDPER_CODIGO() ;
	public void setDPER_CODIGO(Integer DPER_CODIGO) ;

}


