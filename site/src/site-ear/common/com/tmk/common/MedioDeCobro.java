package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MedioDeCobro extends EJBObject {

	public String getID_MEDIO_COBRO() throws RemoteException;

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getTIPO() throws RemoteException;

	public void setTIPO(String TIPO) throws RemoteException;

	public String getHABILITADO_TEMATIKA() throws RemoteException;

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA) throws RemoteException;

}


