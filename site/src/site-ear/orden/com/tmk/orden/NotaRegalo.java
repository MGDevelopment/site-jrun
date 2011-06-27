package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface NotaRegalo extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public String getNOTA_REGALO() throws RemoteException;

	public void setNOTA_REGALO(String NOTA_REGALO) throws RemoteException;

	public Long getITEM() throws RemoteException;

	public void setITEM(Long ITEM) throws RemoteException;


}


