/**
 * @author Lizardo Santiago
 *
 * $Log: SucursalHome.java,v $
 * Revision 1.7  2003/10/03 16:29:00  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/16 23:08:23  SLizardo
 * Administracion de Eventos
 *
 *
 */
package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;

public interface SucursalHome extends EJBHome {

	public Sucursal create(Integer ID_SUCURSAL, String DESCRIPCION, Date FECHA_APERTURA, String DIRECCION, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL) throws RemoteException, CreateException;

	public Sucursal findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;
}
