package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface PagoOrden extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public String getID_MEDIO_COBRO() throws RemoteException;

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) throws RemoteException;

	public Double getIMPORTE() throws RemoteException;

	public void setIMPORTE(Double IMPORTE) throws RemoteException;

	public void setCUOTAS(Integer CUOTAS) throws RemoteException;

	public Integer getCUOTAS() throws RemoteException;

	public void setCOEFICIENTE(Double COEFICIENTE) throws RemoteException;

	public Double getCOEFICIENTE() throws RemoteException;

	public void setMONEDA(Integer MONEDA) throws RemoteException;

	public Integer getMONEDA() throws RemoteException;

	public void setCAMBIO(Double CAMBIO) throws RemoteException;

	public Double getCAMBIO() throws RemoteException;

}


