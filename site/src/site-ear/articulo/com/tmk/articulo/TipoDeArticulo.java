package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface TipoDeArticulo extends EJBObject {

	public String getID_TIPO_ARTICULO() throws RemoteException;

	public void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getCUENTA_MASCARA() throws RemoteException;

	public void setCUENTA_MASCARA(String CUENTA_MASCARA) throws RemoteException;

}


