package com.tmk.articulo;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface ArticuloReducidoLocalHome extends EJBLocalHome
{
	public ArticuloReducidoLocal create() throws  CreateException;
	public ArticuloReducidoLocal findByPrimaryKey(Integer pk) throws FinderException;

}


