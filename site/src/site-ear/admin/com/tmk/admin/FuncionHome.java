package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface FuncionHome extends EJBHome {

	public Funcion create(String FUNCION, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws RemoteException, CreateException;

	public Funcion findByPrimaryKey(String pk) throws RemoteException, FinderException;
}


