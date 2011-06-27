package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface TipoDeArticuloHome extends EJBHome {

	public TipoDeArticulo create(String ID_TIPO_ARTICULO, String DESCRIPCION, String CUENTA_MASCARA) throws RemoteException, CreateException;

	public TipoDeArticulo findByPrimaryKey(String pk) throws RemoteException, FinderException;
}


