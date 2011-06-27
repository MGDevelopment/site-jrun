package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface FuncionRolLocalHome extends EJBLocalHome {

	public FuncionRolLocal create(String ROL, String FUNCION, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws CreateException;

	public FuncionRolLocal findByPrimaryKey(FuncionRolPK pk) throws FinderException;
}


