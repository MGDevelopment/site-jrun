package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ArticuloISBNHome extends EJBHome {

	public ArticuloISBN create(Integer ID_ARTICULO, String ISBN, String TIPO_CODIGO) throws RemoteException, CreateException;

	public ArticuloISBN findByPrimaryKey(ArticuloISBNPK pk) throws RemoteException, FinderException;

	public Collection findISBNs(java.lang.Integer param1);
}


