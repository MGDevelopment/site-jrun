package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface AutorHome extends EJBHome {

	public Autor create(Integer ID_AUTOR, String DESCRIPCION) throws RemoteException, CreateException;

	public Autor findByPrimaryKey(Integer pk) throws RemoteException, FinderException;
}


