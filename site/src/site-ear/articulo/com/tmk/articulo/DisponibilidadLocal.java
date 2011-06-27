package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface DisponibilidadLocal extends EJBLocalObject {

	public Integer getID_DISPONIBILIDAD();

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public void setPEDIDO_ESPECIAL(String PEDIDO_ESPECIAL);

	public String getPEDIDO_ESPECIAL();

}


