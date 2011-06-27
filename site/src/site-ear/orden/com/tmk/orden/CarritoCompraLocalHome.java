package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface CarritoCompraLocalHome extends EJBLocalHome {

	public CarritoCompraLocal create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, java.util.Date FECHA) throws CreateException;

	public CarritoCompraLocal findByPrimaryKey(CarritoCompraPK pk) throws FinderException;

	public Collection findAll() throws FinderException;

	public Collection findByUser(java.lang.Integer param1, java.lang.Integer param2) throws FinderException;

}


