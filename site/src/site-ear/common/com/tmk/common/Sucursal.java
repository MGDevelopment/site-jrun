/**
 * @author Lizardo Santiago
 *
 * $Log: Sucursal.java,v $
 * Revision 1.6  2003/10/03 16:28:59  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/16 23:08:22  SLizardo
 * Administracion de Eventos
 *
 *
 */
package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.Date;

public interface Sucursal extends EJBObject {

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public Date getFECHA_APERTURA() throws RemoteException;

	public void setFECHA_APERTURA(Date FECHA_APERTURA) throws RemoteException;

	public String getDIRECCION() throws RemoteException;

	public void setDIRECCION(String DIRECCION) throws RemoteException;

	public Integer getID_PAIS() throws RemoteException;

	public void setID_PAIS(Integer ID_PAIS) throws RemoteException;

	public Integer getID_PROVINCIA() throws RemoteException;

	public void setID_PROVINCIA(Integer ID_PROVINCIA) throws RemoteException;

	public Integer getID_LOCALIDAD() throws RemoteException;

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD) throws RemoteException;

	public String getCODIGO_POSTAL() throws RemoteException;

	public void setCODIGO_POSTAL(String CODIGO_POSTAL) throws RemoteException;

	public String getTELEFONO() throws RemoteException;

	public void setTELEFONO(String TELEFONO) throws RemoteException;

	public String getFAX() throws RemoteException;

	public void setFAX(String FAX) throws RemoteException;

	public String getEMAIL() throws RemoteException;

	public void setEMAIL(String EMAIL) throws RemoteException;
}
