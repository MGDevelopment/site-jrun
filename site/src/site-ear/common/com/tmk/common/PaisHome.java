package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface PaisHome extends EJBHome {

	public Pais create(Integer ID_PAIS, String DESCRIPCION, String HABILITADO_TEMATIKA) throws RemoteException, CreateException;

	public Pais findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;
}


