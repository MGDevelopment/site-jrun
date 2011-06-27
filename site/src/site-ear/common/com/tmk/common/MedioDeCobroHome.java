package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface MedioDeCobroHome extends EJBHome {

	public MedioDeCobro create(String ID_MEDIO_COBRO, String DESCRIPCION, String TIPO, String HABILITADO_TEMATIKA) throws RemoteException, CreateException;

	public MedioDeCobro findByPrimaryKey(String pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;
}


