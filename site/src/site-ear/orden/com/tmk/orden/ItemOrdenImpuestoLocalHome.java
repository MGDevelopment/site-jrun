package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ItemOrdenImpuestoLocalHome extends EJBLocalHome {

	public ItemOrdenImpuestoLocal create(Integer ID_ORDEN, Integer ID_ARTICULO, Double TASA_GRAL, Double VALOR_TASA_GRAL, Double TASA_PERCEP_VIDEO, Double VALOR_PERCEP_VIDEO, Long ITEM) throws CreateException;

	public ItemOrdenImpuestoLocal findByPrimaryKey(ItemOrdenImpuestoPK pk) throws FinderException;
}


