package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface ArticuloAutoresLocal extends EJBLocalObject {

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public Integer getID_AUTOR();

	public void setID_AUTOR(Integer ID_AUTOR);

	public Integer getORDEN();

	public void setORDEN(Integer ORDEN);

	public String getROLE();

	public void setROLE(String ROLE);

}


