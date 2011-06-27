package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface DisponibilidadLocalHome extends EJBLocalHome {

	public DisponibilidadLocal create(Integer ID_DISPONIBILIDAD, String DESCRIPCION, String PEDIDO_ESPECIAL) throws CreateException;

	public DisponibilidadLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findAll() throws FinderException;
}


