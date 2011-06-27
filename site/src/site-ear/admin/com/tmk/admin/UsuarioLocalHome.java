package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface UsuarioLocalHome extends EJBLocalHome {

	public UsuarioLocal create(Integer ID_USUARIO, byte[] LOGIN, byte[] PASSWORD, String NOMBRES, String APELLIDOS, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws CreateException;

	public UsuarioLocal findByPrimaryKey(Integer pk) throws FinderException;
}


