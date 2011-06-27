package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface TipoDeArticuloLocalHome extends EJBLocalHome {

	public TipoDeArticuloLocal create(String ID_TIPO_ARTICULO, String DESCRIPCION, String CUENTA_MASCARA) throws CreateException;

	public TipoDeArticuloLocal findByPrimaryKey(String pk) throws FinderException;
}


