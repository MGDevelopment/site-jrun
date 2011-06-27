package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface ItemOrdenImpuestoLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public Double getTASA_GRAL();

	public void setTASA_GRAL(Double TASA_GRAL);

	public Double getVALOR_TASA_GRAL();

	public void setVALOR_TASA_GRAL(Double VALOR_TASA_GRAL);

	public Double getTASA_PERCEP_VIDEO();

	public void setTASA_PERCEP_VIDEO(Double TASA_PERCEP_VIDEO);

	public Double getVALOR_PERCEP_VIDEO();

	public void setVALOR_PERCEP_VIDEO(Double VALOR_PERCEP_VIDEO);

	public Long getITEM();

	public void setITEM(Long ITEM);

}


