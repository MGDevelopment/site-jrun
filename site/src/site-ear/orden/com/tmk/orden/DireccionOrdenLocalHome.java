package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface DireccionOrdenLocalHome extends EJBLocalHome {

	public DireccionOrdenLocal create(Integer ID_ORDEN, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO) throws CreateException;

	public DireccionOrdenLocal findByPrimaryKey(DireccionOrdenPK pk) throws FinderException;

	public Collection findByOrden(java.lang.Integer idOrden) throws FinderException;

}


