package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface ProveedorHome extends EJBHome {

	public Proveedor create(Integer ID_PROVEEDOR, String NOMBRE, String RAZON_SOCIAL) throws RemoteException, CreateException;

	public Proveedor findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

}


