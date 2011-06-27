package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface MetodoDeEnvioLocalHome extends EJBLocalHome {

	public MetodoDeEnvioLocal create(Integer ID_METODO_ENVIO, String DESCRIPCION, String URL, String HABILITADO) throws CreateException;

	public MetodoDeEnvioLocal findByPrimaryKey(Integer pk) throws FinderException;
}


