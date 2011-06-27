package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.util.Collection;
import javax.ejb.FinderException;

public interface SocioVehiculoHome extends EJBHome
{
	public SocioVehiculo create(Integer ID_SOCIO, Integer ID_SUCURSAL, Integer ID_SOVH, String ID_MARCA, String ID_MODELO, Integer ANIO_MODELO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws RemoteException,  CreateException;
	public SocioVehiculo findByPrimaryKey(SocioVehiculo pk) throws RemoteException,  FinderException; 
}


