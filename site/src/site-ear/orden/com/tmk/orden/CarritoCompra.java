package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface CarritoCompra extends EJBObject {

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public Integer getCANTIDAD() throws RemoteException;

	public void setCANTIDAD(Integer CANTIDAD) throws RemoteException;

	public abstract java.util.Date getFECHA() throws RemoteException;

	public abstract void setFECHA(java.util.Date FECHA) throws RemoteException;

}


