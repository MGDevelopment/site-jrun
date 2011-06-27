package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Editor extends EJBObject {

	public Integer getID_EDITOR() throws RemoteException;

	public void setID_EDITOR(Integer ID_EDITOR) throws RemoteException;

	public String getNOMBRE() throws RemoteException;

	public void setNOMBRE(String NOMBRE) throws RemoteException;

	public String getRAZON_SOCIAL() throws RemoteException;

	public void setRAZON_SOCIAL(String RAZON_SOCIAL) throws RemoteException;

	public String getDIRECCION() throws RemoteException;

	public void setDIRECCION(String DIRECCION) throws RemoteException;

	public String getCODIGO_POSTAL() throws RemoteException;

	public void setCODIGO_POSTAL(String CODIGO_POSTAL) throws RemoteException;

	public String getTELEFONO() throws RemoteException;

	public void setTELEFONO(String TELEFONO) throws RemoteException;

	public String getFAX() throws RemoteException;

	public void setFAX(String FAX) throws RemoteException;

	public String getEMAIL() throws RemoteException;

	public void setEMAIL(String EMAIL) throws RemoteException;

	public String getCUIT() throws RemoteException;

	public void setCUIT(String CUIT) throws RemoteException;

	public String getOBSERVACIONES() throws RemoteException;

	public void setOBSERVACIONES(String OBSERVACIONES) throws RemoteException;

	public Integer getID_PAIS() throws RemoteException;

	public void setID_PAIS(Integer ID_PAIS) throws RemoteException;

	public Integer getID_PROVINCIA() throws RemoteException;

	public void setID_PROVINCIA(Integer ID_PROVINCIA) throws RemoteException;

	public Integer getID_LOCALIDAD() throws RemoteException;

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD) throws RemoteException;

    public String getURL() throws RemoteException;

	public void setURL(String URL) throws RemoteException;

}


