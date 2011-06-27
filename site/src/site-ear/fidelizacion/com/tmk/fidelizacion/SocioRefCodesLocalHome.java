package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SocioRefCodesLocalHome extends EJBLocalHome
{
	public SocioRefCodesLocal create(Integer ID_SOCIO, Integer ID_SUCURSAL, String DOMAIN, String LOW_VALUE, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String CARACTER, Double NUMERO, java.sql.Timestamp FECHA) throws  CreateException;
	public SocioRefCodesLocal findByPrimaryKey(SocioRefCodesPK pk) throws  FinderException; 
}


