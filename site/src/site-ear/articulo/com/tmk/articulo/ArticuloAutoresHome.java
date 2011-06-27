package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ArticuloAutoresHome extends EJBHome {

	public ArticuloAutores create(Integer ID_ARTICULO, Integer ID_AUTOR, Integer ORDEN, String ROLE) throws RemoteException, CreateException;

	public ArticuloAutores findByPrimaryKey(ArticuloAutoresPK pk) throws RemoteException, FinderException;

	public Collection findAutores(Integer INTEGER, String ROLE) throws RemoteException, FinderException;
}


