package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface NotaRegaloHome extends EJBHome {

	public NotaRegalo create(Integer ID_ORDEN, Integer ID_ARTICULO, String NOTA_REGALO, Long ITEM) throws RemoteException, CreateException;

	public NotaRegalo findByPrimaryKey(NotaRegaloPK pk) throws RemoteException, FinderException;

	public Collection findAllByOrden(java.lang.Integer param1) throws RemoteException, FinderException;

}


