package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface LocalidadHome extends EJBHome {

	public Localidad create(Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String DESCRIPCION, String HABILITADO_TEMATIKA) throws RemoteException, CreateException;

	public Localidad findByPrimaryKey(LocalidadPK pk) throws RemoteException, FinderException;

	public Collection findByPais(java.lang.Integer param1) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

}


