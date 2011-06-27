package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface ArticuloISBN extends EJBObject {

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public String getISBN() throws RemoteException;

	public void setISBN(String ISBN) throws RemoteException;

	public String getTIPO_CODIGO() throws RemoteException;

	public void setTIPO_CODIGO(String TIPO_CODIGO) throws RemoteException;

}


