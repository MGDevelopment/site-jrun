package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Usuario extends EJBObject {

	public Integer getID_USUARIO() throws RemoteException;

	public void setID_USUARIO(Integer ID_USUARIO) throws RemoteException;

	public byte[] getLOGIN() throws RemoteException;

	public void setLOGIN(byte[] LOGIN) throws RemoteException;

	public byte[] getPASSWORD() throws RemoteException;

	public void setPASSWORD(byte[] PASSWORD) throws RemoteException;

	public String getNOMBRES() throws RemoteException;

	public void setNOMBRES(String NOMBRES) throws RemoteException;

	public String getAPELLIDOS() throws RemoteException;

	public void setAPELLIDOS(String APELLIDOS) throws RemoteException;

	public Integer getESTADO() throws RemoteException;

	public void setESTADO(Integer ESTADO) throws RemoteException;

	public java.sql.Timestamp getFECHA_ALTA() throws RemoteException;

	public void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA) throws RemoteException;

	public String getUSUARIO_ALTA() throws RemoteException;

	public void setUSUARIO_ALTA(String USUARIO_ALTA) throws RemoteException;

	public java.sql.Timestamp getFECHA_MODIF() throws RemoteException;

	public void setFECHA_MODIF(java.sql.Timestamp FECHA_MODIF) throws RemoteException;

	public String getUSUARIO_MODIF() throws RemoteException;

	public void setUSUARIO_MODIF(String USUARIO_MODIF) throws RemoteException;

}


