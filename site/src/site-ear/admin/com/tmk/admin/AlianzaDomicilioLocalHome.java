/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaDomicilioLocalHome.java,v $
 * Revision 1.3  2005/09/22 18:37:58  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:35  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:47  SLizardo
 * no message
 *
 * Revision 1.6  2003/10/03 16:28:37  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/08/25 18:22:41  SLizardo
 * no message
 *
 * Revision 1.4  2003/08/15 15:58:51  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.3  2003/07/25 19:58:21  SLizardo
 * no message
 *
 * Revision 1.2  2003/07/25 16:02:26  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface AlianzaDomicilioLocalHome extends EJBLocalHome {

	public AlianzaDomicilioLocal create(Integer ID_ALIANZA, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS) throws CreateException;

	public AlianzaDomicilioLocal findByPrimaryKey(AlianzaDomicilioPK pk) throws FinderException;

	public Collection findByAlianza(Integer ID_ALIANZA) throws FinderException;
}


