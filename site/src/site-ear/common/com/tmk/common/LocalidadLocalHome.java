package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface LocalidadLocalHome extends EJBLocalHome {

	public LocalidadLocal create(Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String DESCRIPCION, String HABILITADO_TEMATIKA) throws CreateException;

	public LocalidadLocal findByPrimaryKey(LocalidadPK pk) throws FinderException;

	public Collection findByPais(java.lang.Integer param1) throws FinderException;

	public Collection findAll() throws FinderException;

}


