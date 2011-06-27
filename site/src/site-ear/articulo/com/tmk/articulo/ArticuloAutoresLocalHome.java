package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface ArticuloAutoresLocalHome extends EJBLocalHome {

	public ArticuloAutoresLocal create(Integer ID_ARTICULO, Integer ID_AUTOR, Integer ORDEN, String ROLE) throws CreateException;

	public ArticuloAutoresLocal findByPrimaryKey(ArticuloAutoresPK pk) throws FinderException;

	public Collection findAutores(Integer INTEGER, String ROLE) throws FinderException;

}


