package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface ArticuloAutores extends EJBObject {

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public Integer getID_AUTOR() throws RemoteException;

	public void setID_AUTOR(Integer ID_AUTOR) throws RemoteException;

	public Integer getORDEN() throws RemoteException;

	public void setORDEN(Integer ORDEN) throws RemoteException;

	public String getROLE() throws RemoteException;

	public void setROLE(String ROLE) throws RemoteException;

}


