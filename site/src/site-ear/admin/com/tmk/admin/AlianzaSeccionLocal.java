/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccionLocal.java,v $
 * Revision 1.3  2005/09/22 18:38:00  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:38  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:51  SLizardo
 * no message
 *
 * Revision 1.6  2003/09/01 20:06:23  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:35  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:44  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:53  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:52:40  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBLocalObject;
import java.util.Date;

public interface AlianzaSeccionLocal extends EJBLocalObject {

	public Integer getID_SECCION();

	public void setID_SECCION(Integer ID_SECCION);

	public Integer getID_ALIANZA();

	public void setID_ALIANZA(Integer ID_ALIANZA);

	public String getSECCION_NOMBRE();

	public void setSECCION_NOMBRE(String SECCION_NOMBRE);

	public Date getFECHA_BAJA();

	public void setFECHA_BAJA(Date FECHA_BAJA);
}