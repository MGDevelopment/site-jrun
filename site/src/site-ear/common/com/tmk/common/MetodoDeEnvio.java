package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MetodoDeEnvio extends EJBObject {

	public Integer getID_METODO_ENVIO() throws RemoteException;

	public void setID_METODO_ENVIO(Integer ID_METODO_ENVIO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getURL() throws RemoteException;

	public void setURL(String URL) throws RemoteException;

	public String getHABILITADO() throws RemoteException;

	public void setHABILITADO(String HABILITADO) throws RemoteException;

}


