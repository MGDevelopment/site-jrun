package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface SocioRefCodesLocal extends EJBLocalObject
{
	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public String getDOMAIN() ;
	public void setDOMAIN(String DOMAIN) ;

	public String getLOW_VALUE() ;
	public void setLOW_VALUE(String LOW_VALUE) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

	public String getCARACTER() ;
	public void setCARACTER(String CARACTER) ;

	public Double getNUMERO() ;
	public void setNUMERO(Double NUMERO) ;

	public java.sql.Timestamp getFECHA() ;
	public void setFECHA(java.sql.Timestamp FECHA) ;

}


