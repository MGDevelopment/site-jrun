package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferFormulario extends EJBObject
{
	public String getNRO_FORMULARIO() throws RemoteException;
	public void setNRO_FORMULARIO(String NRO_FORMULARIO) throws RemoteException;

	public java.sql.Timestamp getFECHA() throws RemoteException;
	public void setFECHA(java.sql.Timestamp FECHA) throws RemoteException;

	public String getDATOS_ADICIONALES() throws RemoteException;
	public void setDATOS_ADICIONALES(String DATOS_ADICIONALES) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public java.sql.Timestamp getFECHA_TRANSMISION() throws RemoteException;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) throws RemoteException;

	public Integer getDPER_CODIGO() throws RemoteException;
	public void setDPER_CODIGO(Integer DPER_CODIGO) throws RemoteException;

}


