package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface DireccionOrdenHome extends EJBHome {

	public DireccionOrden create(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO) throws RemoteException, CreateException;

	public DireccionOrden findByPrimaryKey(DireccionOrdenPK pk) throws RemoteException, FinderException;
}


