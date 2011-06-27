package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface CarritoCompraHome extends EJBHome {

	public CarritoCompra create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, java.util.Date FECHA) throws RemoteException, CreateException;

	public CarritoCompra findByPrimaryKey(CarritoCompraPK pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

	public Collection findByUser(java.lang.Integer param1, java.lang.Integer param2) throws RemoteException, FinderException;

}


