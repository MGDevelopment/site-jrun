package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface AutorLocal extends EJBLocalObject {

	public Integer getID_AUTOR();

	public void setID_AUTOR(Integer ID_AUTOR);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

}


