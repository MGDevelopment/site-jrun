package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ArticuloTextoHome extends EJBHome {

	public ArticuloTexto create(Integer ID_ARTICULO, String TIPO, Integer PARTE, String TIPO_TEXTO, String TEXTO, Integer ID_AUTOR, String ROLE, String IDIOMA) throws RemoteException, CreateException;

	public ArticuloTexto findByPrimaryKey(ArticuloTextoPK pk) throws RemoteException, FinderException;

	public Collection findTextos(Integer ID_ARTICULO, String TIPO) throws RemoteException, FinderException;

}


