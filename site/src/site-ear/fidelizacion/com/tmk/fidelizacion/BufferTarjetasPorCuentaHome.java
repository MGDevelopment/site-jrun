package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.util.Collection;
import javax.ejb.FinderException;

public interface BufferTarjetasPorCuentaHome extends EJBHome
{
	public BufferTarjetasPorCuenta create(String NRO_TARJETA, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, Integer ID_CUSO, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String NRO_FORMULARIO) throws RemoteException,  CreateException;
	public BufferTarjetasPorCuenta findByPrimaryKey(String pk) throws RemoteException,  FinderException; 
}


