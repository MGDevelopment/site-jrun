package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferCuentasPorSocio extends EJBObject
{
	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_CUSO() throws RemoteException;
	public void setID_CUSO(Integer ID_CUSO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;
	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getDPER_CODIGO() throws RemoteException;
	public void setDPER_CODIGO(Integer DPER_CODIGO) throws RemoteException;

	public Integer getCOMPONENTE() throws RemoteException;
	public void setCOMPONENTE(Integer COMPONENTE) throws RemoteException;

	public java.sql.Timestamp getFECHA_TRANSMISION() throws RemoteException;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) throws RemoteException;

	public String getCANJE_HABILITADO() throws RemoteException;
	public void setCANJE_HABILITADO(String CANJE_HABILITADO) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

}


