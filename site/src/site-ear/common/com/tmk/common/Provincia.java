package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Provincia extends EJBObject {

	public Integer getID_PAIS() throws RemoteException;

	public void setID_PAIS(Integer ID_PAIS) throws RemoteException;

	public Integer getID_PROVINCIA() throws RemoteException;

	public void setID_PROVINCIA(Integer ID_PROVINCIA) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getHABILITADO_TEMATIKA() throws RemoteException;

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA) throws RemoteException;

}


