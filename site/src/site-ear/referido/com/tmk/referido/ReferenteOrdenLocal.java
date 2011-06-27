package com.tmk.referido;

import javax.ejb.EJBLocalObject;

public interface ReferenteOrdenLocal extends EJBLocalObject
{
	public Long getCODIGO() ;
	public void setCODIGO(Long CODIGO) ;

	public Integer getID_ORDEN_REFERENTE() ;
	public void setID_ORDEN_REFERENTE(Integer ID_ORDEN_REFERENTE) ;

}


