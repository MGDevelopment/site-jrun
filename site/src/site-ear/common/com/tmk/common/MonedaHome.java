package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface MonedaHome extends EJBHome {

	public Moneda create(String ID_MONEDA, String DESCRIPCION) throws RemoteException, CreateException;

	public Moneda findByPrimaryKey(String pk) throws RemoteException, FinderException;

	public Collection findAll();
}


