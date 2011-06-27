package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface RolLocalHome extends EJBLocalHome {

	public RolLocal create(String ROL, String COMENTARIO, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws CreateException;

	public RolLocal findByPrimaryKey(String pk) throws FinderException;
}


