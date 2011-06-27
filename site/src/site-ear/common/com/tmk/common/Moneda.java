package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Moneda extends EJBObject {

	public String getID_MONEDA() throws RemoteException;

	public void setID_MONEDA(String ID_MONEDA) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

}


