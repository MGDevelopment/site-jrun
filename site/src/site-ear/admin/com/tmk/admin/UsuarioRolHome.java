package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface UsuarioRolHome extends EJBHome {

	public UsuarioRol create(String ROL, Integer ID_USUARIO, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws RemoteException, CreateException;

	public UsuarioRol findByPrimaryKey(UsuarioRolPK pk) throws RemoteException, FinderException;
}


