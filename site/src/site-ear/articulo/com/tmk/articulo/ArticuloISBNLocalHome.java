package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface ArticuloISBNLocalHome extends EJBLocalHome {

	public ArticuloISBNLocal create(Integer ID_ARTICULO, String ISBN, String TIPO_CODIGO) throws CreateException;

	public ArticuloISBNLocal findByPrimaryKey(ArticuloISBNPK pk) throws FinderException;

	public Collection findISBNs(java.lang.Integer param1);
}


