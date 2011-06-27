package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ProvinciaHome extends EJBHome {

	public Provincia create(Integer ID_PAIS, Integer ID_PROVINCIA, String DESCRIPCION, String HABILITADO_TEMATIKA) throws RemoteException, CreateException;

	public Provincia findByPrimaryKey(ProvinciaPK pk) throws RemoteException, FinderException;

	public Collection findByPais(Integer param1) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

}


