package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface NotaRegaloLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public String getNOTA_REGALO();

	public void setNOTA_REGALO(String NOTA_REGALO);

	public Long getITEM();

	public void setITEM(Long ITEM);

}


