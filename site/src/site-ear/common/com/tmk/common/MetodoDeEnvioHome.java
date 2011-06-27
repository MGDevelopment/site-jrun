package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface MetodoDeEnvioHome extends EJBHome {

	public MetodoDeEnvio create(Integer ID_METODO_ENVIO, String DESCRIPCION, String URL, String HABILITADO) throws RemoteException, CreateException;

	public MetodoDeEnvio findByPrimaryKey(Integer pk) throws RemoteException, FinderException;
}


