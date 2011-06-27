package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

import javax.ejb.FinderException;

public interface OrdenPorCuentaHome extends EJBHome
{
	public OrdenPorCuenta create(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_SUCURSAL_CUENTA, Integer ID_CUENTA, String NRO_TARJETA) throws RemoteException,  CreateException;
	public OrdenPorCuenta findByPrimaryKey(Integer pk) throws RemoteException,  FinderException; 
}


