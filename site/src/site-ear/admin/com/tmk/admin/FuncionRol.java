package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface FuncionRol extends EJBObject {

	public String getROL() throws RemoteException;

	public void setROL(String ROL) throws RemoteException;

	public String getFUNCION() throws RemoteException;

	public void setFUNCION(String FUNCION) throws RemoteException;

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


