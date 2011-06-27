/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaDomicilio.java,v $
 * Revision 1.3  2005/09/22 18:37:57  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:34  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:44  SLizardo
 * no message
 *
 * Revision 1.6  2003/10/03 16:28:36  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/01 15:33:39  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:40  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:50  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 16:03:38  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface AlianzaDomicilio extends EJBObject {

	public Integer getID_ALIANZA() throws RemoteException;

	public void setID_ALIANZA(Integer ID_ALIANZA) throws RemoteException;

	public String getTIPO_DOMICILIO() throws RemoteException;

	public void setTIPO_DOMICILIO(String TIPO_DOMICILIO) throws RemoteException;

	public String getCALLE() throws RemoteException;

	public void setCALLE(String CALLE) throws RemoteException;

	public Integer getNUMERO() throws RemoteException;

	public void setNUMERO(Integer NUMERO) throws RemoteException;

	public String getEDIFICIO() throws RemoteException;

	public void setEDIFICIO(String EDIFICIO) throws RemoteException;

	public Integer getPISO() throws RemoteException;

	public void setPISO(Integer PISO) throws RemoteException;

	public String getDEPTO() throws RemoteException;

	public void setDEPTO(String DEPTO) throws RemoteException;

	public String getCP() throws RemoteException;

	public void setCP(String CP) throws RemoteException;

	public Integer getID_LOCALIDAD() throws RemoteException;

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD) throws RemoteException;

	public Integer getID_PROVINCIA() throws RemoteException;

	public void setID_PROVINCIA(Integer ID_PROVINCIA) throws RemoteException;

	public Integer getID_PAIS() throws RemoteException;

	public void setID_PAIS(Integer ID_PAIS) throws RemoteException;
}
