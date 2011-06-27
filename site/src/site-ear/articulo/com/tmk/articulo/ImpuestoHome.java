package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface ImpuestoHome extends EJBHome {

	public Impuesto create(String ID_IMPUESTO, String DESCRIPCION, String CUENTA_MASCARA, String ANULADO) throws RemoteException, CreateException;

	public Impuesto findByPrimaryKey(Integer pk) throws RemoteException, FinderException;
}


