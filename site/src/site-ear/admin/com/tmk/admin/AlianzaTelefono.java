/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaTelefono.java,v $
 * Revision 1.3  2005/09/22 18:38:00  omsartori
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
 * Revision 1.1  2003/10/11 17:53:53  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:35  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:45  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:54  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:46:59  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface AlianzaTelefono extends EJBObject {

	public Integer getID_ALIANZA() throws RemoteException;

	public void setID_ALIANZA(Integer ID_ALIANZA) throws RemoteException;

	public String getTIPO_TELEFONO() throws RemoteException;

	public void setTIPO_TELEFONO(String TIPO_TELEFONO) throws RemoteException;

	public String getCOD_AREA() throws RemoteException;

	public void setCOD_AREA(String COD_AREA) throws RemoteException;

	public String getNRO_TEL() throws RemoteException;

	public void setNRO_TEL(String NRO_TEL) throws RemoteException;

	public String getEXT_INT() throws RemoteException;

	public void setEXT_INT(String EXT_INT) throws RemoteException;
}