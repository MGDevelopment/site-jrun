package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface DireccionOrdenLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public Integer getID_SUCURSAL_SOCIO();

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public String getTIPO_DOMICILIO();

	public void setTIPO_DOMICILIO(String TIPO_DOMICILIO);

}


