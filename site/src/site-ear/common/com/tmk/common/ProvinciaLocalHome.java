package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface ProvinciaLocalHome extends EJBLocalHome {

	public ProvinciaLocal create(Integer ID_PAIS, Integer ID_PROVINCIA, String DESCRIPCION, String HABILITADO_TEMATIKA) throws CreateException;

	public ProvinciaLocal findByPrimaryKey(ProvinciaPK pk) throws FinderException;

	public Collection findByPais(Integer param1) throws FinderException;

	public Collection findAll() throws FinderException;

}


