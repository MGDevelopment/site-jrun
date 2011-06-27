package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface UsuarioRolLocalHome extends EJBLocalHome {

	public UsuarioRolLocal create(String ROL, Integer ID_USUARIO, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws CreateException;

	public UsuarioRolLocal findByPrimaryKey(UsuarioRolPK pk) throws FinderException;
}


