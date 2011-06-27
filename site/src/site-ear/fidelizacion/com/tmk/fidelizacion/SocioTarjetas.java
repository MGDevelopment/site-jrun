package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface SocioTarjetas extends EJBObject
{
	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public String getID_USR_ALTA() throws RemoteException;
	public void setID_USR_ALTA(String ID_USR_ALTA) throws RemoteException;

	public String getID_USR_MODI() throws RemoteException;
	public void setID_USR_MODI(String ID_USR_MODI) throws RemoteException;

	public String getID_MEDIO_COBRO() throws RemoteException;
	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;
	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

}


