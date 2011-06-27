package com.tmk.referido;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface ReferenteOrdenLocalHome extends EJBLocalHome
{
	public ReferenteOrdenLocal create(Long CODIGO, Integer ID_ORDEN_REFERENTE) throws  CreateException;
	public ReferenteOrdenLocal findByPrimaryKey(com.tmk.referido.ReferenteOrdenPK pk) throws  FinderException;
	public Collection findByReferido (Long CODIGO) throws FinderException;
	public ReferenteOrdenLocal findByOrdenReferente (Integer idOrden) throws FinderException;
}


