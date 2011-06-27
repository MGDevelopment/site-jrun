package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface DisponibilidadHome extends EJBHome {

	public Disponibilidad create(Integer ID_DISPONIBILIDAD, String DESCRIPCION, String PEDIDO_ESPECIAL) throws RemoteException, CreateException;

	public Disponibilidad findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;
}


