package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface FuncionRolHome extends EJBHome {

	public FuncionRol create(String ROL, String FUNCION, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws RemoteException, CreateException;

	public FuncionRol findByPrimaryKey(FuncionRolPK pk) throws RemoteException, FinderException;
}


