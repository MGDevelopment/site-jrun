/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccionHome.java,v $
 * Revision 1.4  2005/09/22 18:37:59  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.3  2003/12/04 17:18:37  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/10/16 19:22:25  JMembrives
 * no message
 *
 * Revision 1.1  2003/10/11 17:53:51  SLizardo
 * no message
 *
 * Revision 1.7  2003/10/03 16:28:38  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/08/25 18:22:44  SLizardo
 * no message
 *
 * Revision 1.5  2003/08/15 15:58:53  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.4  2003/07/25 19:58:22  SLizardo
 * no message
 *
 * Revision 1.3  2003/07/25 15:54:28  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface AlianzaSeccionHome extends EJBHome {

	public AlianzaSeccion create(Integer ID_SECCION, Integer ID_ALIANZA, String SECCION_NOMBRE) throws RemoteException, CreateException;

	public AlianzaSeccion findByPrimaryKey(AlianzaSeccionPK pk) throws RemoteException, FinderException;

	public Collection findByAlianza(Integer ID_ALIANZA) throws RemoteException, FinderException;

	public Collection findVigentes(Integer ID_ALIANZA) throws RemoteException, FinderException;
}


