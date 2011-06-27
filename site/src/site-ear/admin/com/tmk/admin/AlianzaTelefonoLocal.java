/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaTelefonoLocal.java,v $
 * Revision 1.3  2005/09/22 18:38:01  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:40  GPistoia
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
 * Revision 1.5  2003/09/01 15:33:34  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:46  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:55  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:40:51  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBLocalObject;

public interface AlianzaTelefonoLocal extends EJBLocalObject {

	public Integer getID_ALIANZA();

	public void setID_ALIANZA(Integer ID_ALIANZA);

	public String getTIPO_TELEFONO();

	public void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public String getCOD_AREA();

	public void setCOD_AREA(String COD_AREA);

	public String getNRO_TEL();

	public void setNRO_TEL(String NRO_TEL);

	public String getEXT_INT();

	public void setEXT_INT(String EXT_INT);
}


