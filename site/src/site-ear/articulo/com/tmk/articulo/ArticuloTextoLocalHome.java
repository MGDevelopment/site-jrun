package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface ArticuloTextoLocalHome extends EJBLocalHome {

	public ArticuloTextoLocal create(Integer ID_ARTICULO, String TIPO, Integer PARTE, String TIPO_TEXTO, String TEXTO, Integer ID_AUTOR, String ROLE, String IDIOMA) throws CreateException;

	public ArticuloTextoLocal findByPrimaryKey(ArticuloTextoPK pk) throws FinderException;

	public Collection findTextos(Integer ID_ARTICULO, String TIPO) throws FinderException;

}


