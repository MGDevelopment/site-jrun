package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface DireccionOrden extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public String getTIPO_DOMICILIO() throws RemoteException;

	public void setTIPO_DOMICILIO(String TIPO_DOMICILIO) throws RemoteException;

}


