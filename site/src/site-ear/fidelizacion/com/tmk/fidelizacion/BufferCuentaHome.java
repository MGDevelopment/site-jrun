package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.util.Collection;
import javax.ejb.FinderException;

public interface BufferCuentaHome extends EJBHome
{
	public BufferCuenta create(Integer ID_CUENTA, Integer ID_SUCURSAL, java.sql.Timestamp FECHA_APERTURA, String ESTADO, java.sql.Timestamp ESTADO_FECHA, String ESTADO_USR, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws RemoteException,  CreateException;
	public BufferCuenta findByPrimaryKey(BufferCuentaPK pk) throws RemoteException,  FinderException; 
}


