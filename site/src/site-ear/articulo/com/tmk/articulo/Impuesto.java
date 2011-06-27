package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Impuesto extends EJBObject {

	public String getID_IMPUESTO() throws RemoteException;

	public void setID_IMPUESTO(String ID_IMPUESTO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getCUENTA_MASCARA() throws RemoteException;

	public void setCUENTA_MASCARA(String CUENTA_MASCARA) throws RemoteException;

	public String getANULADO() throws RemoteException;

	public void setANULADO(String ANULADO) throws RemoteException;

}


