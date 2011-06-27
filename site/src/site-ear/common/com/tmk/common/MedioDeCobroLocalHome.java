package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface MedioDeCobroLocalHome extends EJBLocalHome {

	public MedioDeCobroLocal create(String ID_MEDIO_COBRO, String DESCRIPCION, String TIPO, String HABILITADO_TEMATIKA) throws CreateException;

	public MedioDeCobroLocal findByPrimaryKey(String pk) throws FinderException;

	public Collection findAll() throws FinderException;
}


