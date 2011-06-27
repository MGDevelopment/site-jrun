package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Autor extends EJBObject {

	public Integer getID_AUTOR() throws RemoteException;

	public void setID_AUTOR(Integer ID_AUTOR) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

}


