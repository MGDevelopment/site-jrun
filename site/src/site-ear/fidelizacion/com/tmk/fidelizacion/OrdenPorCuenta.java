package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface OrdenPorCuenta extends EJBObject
{
	public Integer getID_ORDEN() throws RemoteException;
	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;
	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_SUCURSAL_CUENTA() throws RemoteException;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) throws RemoteException;

	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public String getNRO_TARJETA() throws RemoteException;
	public void setNRO_TARJETA(String NRO_TARJETA) throws RemoteException;

}


