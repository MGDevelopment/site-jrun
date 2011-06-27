package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferCuenta extends EJBObject
{
	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public java.sql.Timestamp getFECHA_APERTURA() throws RemoteException;
	public void setFECHA_APERTURA(java.sql.Timestamp FECHA_APERTURA) throws RemoteException;

	public String getESTADO() throws RemoteException;
	public void setESTADO(String ESTADO) throws RemoteException;

	public java.sql.Timestamp getESTADO_FECHA() throws RemoteException;
	public void setESTADO_FECHA(java.sql.Timestamp ESTADO_FECHA) throws RemoteException;

	public String getESTADO_USR() throws RemoteException;
	public void setESTADO_USR(String ESTADO_USR) throws RemoteException;

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

}


