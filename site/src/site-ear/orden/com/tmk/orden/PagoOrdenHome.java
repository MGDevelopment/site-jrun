package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface PagoOrdenHome extends EJBHome {

	public PagoOrden create(Integer ID_ORDEN, String ID_MEDIO_COBRO, Double IMPORTE, Integer CUOTAS, Double COEFICIENTE, Integer MONEDA, Double CAMBIO) throws RemoteException, CreateException;

	public PagoOrden findByPrimaryKey(PagoOrdenPK pk) throws RemoteException, FinderException;
}


