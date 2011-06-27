package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface ItemOrdenImpuestoHome extends EJBHome {

	public ItemOrdenImpuesto create(Integer ID_ORDEN, Integer ID_ARTICULO, Double TASA_GRAL, Double VALOR_TASA_GRAL, Double TASA_PERCEP_VIDEO, Double VALOR_PERCEP_VIDEO, Long ITEM) throws RemoteException, CreateException;

	public ItemOrdenImpuesto findByPrimaryKey(ItemOrdenImpuestoPK pk) throws RemoteException, FinderException;
}


