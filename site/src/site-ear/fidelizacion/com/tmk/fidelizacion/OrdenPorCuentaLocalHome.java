package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface OrdenPorCuentaLocalHome extends EJBLocalHome
{
	public OrdenPorCuentaLocal create(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_SUCURSAL_CUENTA, Integer ID_CUENTA, String NRO_TARJETA) throws  CreateException;
	public OrdenPorCuentaLocal findByPrimaryKey(Integer pk) throws  FinderException; 
}


