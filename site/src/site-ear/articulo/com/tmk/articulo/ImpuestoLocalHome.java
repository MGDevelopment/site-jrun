package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface ImpuestoLocalHome extends EJBLocalHome {

	public ImpuestoLocal create(String ID_IMPUESTO, String DESCRIPCION, String CUENTA_MASCARA, String ANULADO) throws CreateException;

	public ImpuestoLocal findByPrimaryKey(String pk) throws FinderException;
}


