package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface PuntosPorSucursal extends EJBObject
{
	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public java.sql.Timestamp getMES() throws RemoteException;
	public void setMES(java.sql.Timestamp MES) throws RemoteException;

	public Integer getPUNTOS() throws RemoteException;
	public void setPUNTOS(Integer PUNTOS) throws RemoteException;

	public Long getFECHA_MODIFICACION() throws RemoteException;
	public void setFECHA_MODIFICACION(Long FECHA_MODIFICACION) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public Double getSALDO_X_APLICAR() throws RemoteException;
	public void setSALDO_X_APLICAR(Double SALDO_X_APLICAR) throws RemoteException;

	public Integer getSIGNO_SALDO() throws RemoteException;
	public void setSIGNO_SALDO(Integer SIGNO_SALDO) throws RemoteException;

	public Integer getID_SUCURSAL_CUENTA() throws RemoteException;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) throws RemoteException;

}


