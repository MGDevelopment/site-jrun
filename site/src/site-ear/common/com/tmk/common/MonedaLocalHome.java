package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface MonedaLocalHome extends EJBLocalHome {

	public MonedaLocal create(String ID_MONEDA, String DESCRIPCION) throws CreateException;

	public MonedaLocal findByPrimaryKey(String pk) throws FinderException;

	public Collection findAll();
}


