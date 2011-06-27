package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferTarjetasPorCuenta extends EJBObject
{
	public String getNRO_TARJETA() throws RemoteException;
	public void setNRO_TARJETA(String NRO_TARJETA) throws RemoteException;

	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public Integer getID_SUCURSAL_CUENTA() throws RemoteException;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) throws RemoteException;

	public Integer getID_CUSO() throws RemoteException;
	public void setID_CUSO(Integer ID_CUSO) throws RemoteException;

	public java.sql.Timestamp getFECHA_TRANSMISION() throws RemoteException;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public String getNRO_FORMULARIO() throws RemoteException;
	public void setNRO_FORMULARIO(String NRO_FORMULARIO) throws RemoteException;

}


