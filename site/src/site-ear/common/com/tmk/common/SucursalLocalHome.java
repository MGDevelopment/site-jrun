/**
 * @author Lizardo Santiago
 *
 * $Log: SucursalLocalHome.java,v $
 * Revision 1.7  2003/10/03 16:29:00  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/16 23:08:27  SLizardo
 * Administracion de Eventos
 *
 *
 */
package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;
import java.util.Date;

public interface SucursalLocalHome extends EJBLocalHome {

	public SucursalLocal create(Integer ID_SUCURSAL, String DESCRIPCION, Date FECHA_APERTURA, String DIRECCION, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL) throws CreateException;

	public SucursalLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findAll() throws FinderException;
}
