package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface PagoOrdenLocalHome extends EJBLocalHome {

	public PagoOrdenLocal create(Integer ID_ORDEN, String ID_MEDIO_COBRO, Double IMPORTE, Integer CUOTAS, Double COEFICIENTE, Integer MONEDA, Double CAMBIO) throws CreateException;

	public PagoOrdenLocal findByPrimaryKey(PagoOrdenPK pk) throws FinderException;

	//public PagoOrdenLocal findByIdOrden(java.lang.Integer param1) throws FinderException;

	public Collection findByIdOrden(java.lang.Integer param1) throws FinderException;

}




