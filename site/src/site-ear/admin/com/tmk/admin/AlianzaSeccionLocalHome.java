/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccionLocalHome.java,v $
 * Revision 1.4  2005/09/22 18:38:00  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.3  2003/12/04 17:18:38  GPistoia
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
 * Revision 1.1  2003/10/11 17:53:52  SLizardo
 * no message
 *
 * Revision 1.8  2003/10/03 16:28:38  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.7  2003/09/01 15:33:35  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.6  2003/08/25 18:22:44  SLizardo
 * no message
 *
 * Revision 1.5  2003/08/15 15:58:54  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.4  2003/07/25 19:58:22  SLizardo
 * no message
 *
 * Revision 1.3  2003/07/25 15:52:06  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface AlianzaSeccionLocalHome extends EJBLocalHome {

	public AlianzaSeccionLocal create(Integer ID_SECCION, Integer ID_ALIANZA, String SECCION_NOMBRE) throws CreateException;

	public AlianzaSeccionLocal findByPrimaryKey(AlianzaSeccionPK pk) throws FinderException;

	public Collection findByAlianza(Integer ID_ALIANZA) throws FinderException;

	public Collection findVigentes(Integer ID_ALIANZA) throws FinderException;
}


