package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Proveedor extends EJBObject {

	public Integer getID_PROVEEDOR() throws RemoteException;

	public void setID_PROVEEDOR(Integer ID_PROVEEDOR) throws RemoteException;

	public String getNOMBRE() throws RemoteException;

	public void setNOMBRE(String NOMBRE) throws RemoteException;

	public String getRAZON_SOCIAL() throws RemoteException;

	public void setRAZON_SOCIAL(String RAZON_SOCIAL) throws RemoteException;

}


