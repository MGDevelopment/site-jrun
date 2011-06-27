package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface SocioRefCodes extends EJBObject
{
	public Integer getID_SOCIO() throws RemoteException;
	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public String getDOMAIN() throws RemoteException;
	public void setDOMAIN(String DOMAIN) throws RemoteException;

	public String getLOW_VALUE() throws RemoteException;
	public void setLOW_VALUE(String LOW_VALUE) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public String getCARACTER() throws RemoteException;
	public void setCARACTER(String CARACTER) throws RemoteException;

	public Double getNUMERO() throws RemoteException;
	public void setNUMERO(Double NUMERO) throws RemoteException;

	public java.sql.Timestamp getFECHA() throws RemoteException;
	public void setFECHA(java.sql.Timestamp FECHA) throws RemoteException;

}


