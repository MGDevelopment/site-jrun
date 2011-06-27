/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccion.java,v $
 * Revision 1.3  2005/09/22 18:37:59  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:37  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:49  SLizardo
 * no message
 *
 * Revision 1.6  2003/09/01 20:06:24  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:36  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:43  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:53  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:55:57  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.Date;

public interface AlianzaSeccion extends EJBObject {

	public Integer getID_SECCION() throws RemoteException;

	public void setID_SECCION(Integer ID_SECCION) throws RemoteException;

	public Integer getID_ALIANZA() throws RemoteException;

	public void setID_ALIANZA(Integer ID_ALIANZA) throws RemoteException;

	public String getSECCION_NOMBRE() throws RemoteException;

	public void setSECCION_NOMBRE(String SECCION_NOMBRE) throws RemoteException;

	public Date getFECHA_BAJA() throws RemoteException;

	public void setFECHA_BAJA(Date FECHA_BAJA) throws RemoteException;
}