package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

import javax.ejb.FinderException;

public interface SocioTarjetasHome extends EJBHome
{
	public SocioTarjetas create(String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String ID_USR_ALTA, String ID_USR_MODI, String ID_MEDIO_COBRO, Integer ID_SUCURSAL, Integer ID_SOCIO) throws RemoteException,  CreateException;
	public SocioTarjetas findByPrimaryKey(SocioTarjetasPK pk) throws RemoteException,  FinderException; 
}


