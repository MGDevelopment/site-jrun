package com.tmk.common;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface PedidoEspecial extends EJBObject {

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public Integer getID_ARTICULO() throws RemoteException;

	public void setFECHA(java.util.Date FECHA) throws RemoteException;

	public java.util.Date getFECHA() throws RemoteException;

	public void setTELEFONO(String TELEFONO) throws RemoteException;

	public String getTELEFONO() throws RemoteException;

	public void setHORARIO(String HORARIO) throws RemoteException;

	public String getHORARIO() throws RemoteException;

	public void setCOMENTARIO(String COMENTARIO) throws RemoteException;

	public String getCOMENTARIO() throws RemoteException;

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD) throws RemoteException;

	public Integer getID_DISPONIBILIDAD() throws RemoteException;

	public void setID_PEDIDO(Integer ID_PEDIDO) throws RemoteException;

	public Integer getID_PEDIDO() throws RemoteException;

	public void setID_CONSULTA(Integer ID_CONSULTA) throws RemoteException;

	public Integer getID_CONSULTA() throws RemoteException;

	public void setID_OPINION(Integer ID_OPINION) throws RemoteException;

	public Integer getID_OPINION() throws RemoteException;

}
