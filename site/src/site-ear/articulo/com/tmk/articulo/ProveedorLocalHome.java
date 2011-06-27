package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ProveedorLocalHome extends EJBLocalHome {

	public ProveedorLocal create(Integer ID_PROVEEDOR, String NOMBRE, String RAZON_SOCIAL) throws CreateException;

	public ProveedorLocal findByPrimaryKey(Integer pk) throws FinderException;

}


