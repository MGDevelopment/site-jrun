package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface ArticuloTexto extends EJBObject {

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public String getTIPO() throws RemoteException;

	public void setTIPO(String TIPO) throws RemoteException;

	public Integer getPARTE() throws RemoteException;

	public void setPARTE(Integer PARTE) throws RemoteException;

	public String getTIPO_TEXTO() throws RemoteException;

	public void setTIPO_TEXTO(String TIPO_TEXTO) throws RemoteException;

	public String getTEXTO() throws RemoteException;

	public void setTEXTO(String TEXTO) throws RemoteException;

	public Integer getID_AUTOR() throws RemoteException;

	public void setID_AUTOR(Integer ID_AUTOR) throws RemoteException;

	public String getROLE() throws RemoteException;

	public void setROLE(String ROLE) throws RemoteException;

	public String getIDIOMA() throws RemoteException;

	public void setIDIOMA(String IDIOMA) throws RemoteException;

}


