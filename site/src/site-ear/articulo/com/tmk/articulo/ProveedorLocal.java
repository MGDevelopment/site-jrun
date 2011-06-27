package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface ProveedorLocal extends EJBLocalObject {

	public Integer getID_PROVEEDOR();

	public void setID_PROVEEDOR(Integer ID_PROVEEDOR);

	public String getNOMBRE();

	public void setNOMBRE(String NOMBRE);

	public String getRAZON_SOCIAL();

	public void setRAZON_SOCIAL(String RAZON_SOCIAL);

}


