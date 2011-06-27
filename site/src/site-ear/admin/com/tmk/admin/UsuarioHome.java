package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface UsuarioHome extends EJBHome {

	public Usuario create(Integer ID_USUARIO, byte[] LOGIN, byte[] PASSWORD, String NOMBRES, String APELLIDOS, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws RemoteException, CreateException;

	public Usuario findByPrimaryKey(Integer pk) throws RemoteException, FinderException;
}


