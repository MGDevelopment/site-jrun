package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface AutorLocalHome extends EJBLocalHome {

	public AutorLocal create(Integer ID_AUTOR, String DESCRIPCION) throws CreateException;

	public AutorLocal findByPrimaryKey(Integer pk) throws FinderException;
}


