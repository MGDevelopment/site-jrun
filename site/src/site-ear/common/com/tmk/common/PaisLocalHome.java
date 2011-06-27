package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface PaisLocalHome extends EJBLocalHome {

	public PaisLocal create(Integer ID_PAIS, String DESCRIPCION, String HABILITADO_TEMATIKA) throws CreateException;

	public PaisLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findAll() throws FinderException;
}


