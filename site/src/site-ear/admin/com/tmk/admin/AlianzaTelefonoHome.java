/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaTelefonoHome.java,v $
 * Revision 1.3  2005/09/22 18:38:01  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:39  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:54  SLizardo
 * no message
 *
 * Revision 1.6  2003/10/03 16:28:39  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/08/25 18:22:46  SLizardo
 * no message
 *
 * Revision 1.4  2003/08/15 15:58:55  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.3  2003/07/25 19:58:22  SLizardo
 * no message
 *
 * Revision 1.2  2003/07/25 15:45:02  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface AlianzaTelefonoHome extends EJBHome {

	public AlianzaTelefono create(Integer ID_ALIANZA, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT) throws RemoteException, CreateException;

	public AlianzaTelefono findByPrimaryKey(AlianzaTelefonoPK pk) throws RemoteException, FinderException;

	public Collection findByAlianza(Integer ID_ALIANZA) throws RemoteException, FinderException;
}
