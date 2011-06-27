package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferSocioTelefono extends EJBObject {

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public String getTIPO_TELEFONO() throws RemoteException;

	public void setTIPO_TELEFONO(String TIPO_TELEFONO) throws RemoteException;

	public String getCOD_AREA() throws RemoteException;

	public void setCOD_AREA(String COD_AREA) throws RemoteException;

	public String getNRO_TEL() throws RemoteException;

	public void setNRO_TEL(String NRO_TEL) throws RemoteException;

	public String getEXT_INT() throws RemoteException;

	public void setEXT_INT(String EXT_INT) throws RemoteException;

	public String getCOMENTARIOS() throws RemoteException;

	public void setCOMENTARIOS(String COMENTARIOS) throws RemoteException;

	public String getOPERACION() throws RemoteException;

	public void setOPERACION(String OPERACION) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;

	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;

	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;

	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;

	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public String getPROCESADO() throws RemoteException;

	public void setPROCESADO(String PROCESADO) throws RemoteException;
}
