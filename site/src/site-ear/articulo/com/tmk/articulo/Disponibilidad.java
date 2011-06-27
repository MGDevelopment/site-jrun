package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Disponibilidad extends EJBObject {

	public Integer getID_DISPONIBILIDAD() throws RemoteException;

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public String getPEDIDO_ESPECIAL() throws RemoteException;

	public void setPEDIDO_ESPECIAL(String PEDIDO_ESPECIAL) throws RemoteException;

}


