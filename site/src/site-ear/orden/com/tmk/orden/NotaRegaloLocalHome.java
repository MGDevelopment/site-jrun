package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface NotaRegaloLocalHome extends EJBLocalHome {

	public NotaRegaloLocal create(Integer ID_ORDEN, Integer ID_ARTICULO, String NOTA_REGALO, Long ITEM) throws CreateException;

	public NotaRegaloLocal findByPrimaryKey(NotaRegaloPK pk) throws FinderException;

	public Collection findAllByOrden(java.lang.Integer param1) throws FinderException;

}


