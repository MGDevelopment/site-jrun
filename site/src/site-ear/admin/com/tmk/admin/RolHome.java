package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface RolHome extends EJBHome {

	public Rol create(String ROL, String COMENTARIO, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws RemoteException, CreateException;

	public Rol findByPrimaryKey(String pk) throws RemoteException, FinderException;
}


