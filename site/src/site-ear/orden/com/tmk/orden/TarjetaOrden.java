package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface TarjetaOrden extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public String getID_MEDIO_COBRO() throws RemoteException;

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) throws RemoteException;

	public byte[] getNRO_TARJETA() throws RemoteException;

	public void setNRO_TARJETA(byte[] NRO_TARJETA) throws RemoteException;

	public String getNOMBRE_CLIENTE() throws RemoteException;

	public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) throws RemoteException;

	public Integer getCODIGO_RESPUESTA() throws RemoteException;

	public void setCODIGO_RESPUESTA(Integer CODIGO_RESPUESTA) throws RemoteException;

	public Integer getCODIGO_AUTORIZACION() throws RemoteException;

	public void setCODIGO_AUTORIZACION(Integer CODIGO_AUTORIZACION) throws RemoteException;

	public String getMENSAJE_GPAY() throws RemoteException;

	public void setMENSAJE_GPAY(String MENSAJE_GPAY) throws RemoteException;

	public String getTIPO_DOC() throws RemoteException;

	public void setTIPO_DOC(String TIPO_DOC) throws RemoteException;

	public Long getNRO_DOC() throws RemoteException;

	public void setNRO_DOC(Long NRO_DOC) throws RemoteException;

	public String getDIRECCION_RESUMEN() throws RemoteException;

	public void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN) throws RemoteException;

	public byte[] getP1() throws RemoteException;

	public void setP1(byte[] P1) throws RemoteException;

	public byte[] getP2() throws RemoteException;

	public void setP2(byte[] P2) throws RemoteException;

	public byte[] getP3() throws RemoteException;

	public void setP3(byte[] P3) throws RemoteException;

}


