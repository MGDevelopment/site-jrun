package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface ArticuloISBNLocal extends EJBLocalObject {

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public String getISBN();

	public void setISBN(String ISBN);

	public String getTIPO_CODIGO();

	public void setTIPO_CODIGO(String TIPO_CODIGO);

}


