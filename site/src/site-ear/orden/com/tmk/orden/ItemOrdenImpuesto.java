package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface ItemOrdenImpuesto extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public Double getTASA_GRAL() throws RemoteException;

	public void setTASA_GRAL(Double TASA_GRAL) throws RemoteException;

	public Double getVALOR_TASA_GRAL() throws RemoteException;

	public void setVALOR_TASA_GRAL(Double VALOR_TASA_GRAL) throws RemoteException;

	public Double getTASA_PERCEP_VIDEO() throws RemoteException;

	public void setTASA_PERCEP_VIDEO(Double TASA_PERCEP_VIDEO) throws RemoteException;

	public Double getVALOR_PERCEP_VIDEO() throws RemoteException;

	public void setVALOR_PERCEP_VIDEO(Double VALOR_PERCEP_VIDEO) throws RemoteException;

	public Long getITEM() throws RemoteException;

	public void setITEM(Long ITEM) throws RemoteException;

}


