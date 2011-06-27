/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioDomicilioHome.java,v $
 * Revision 1.5  2006/10/12 14:59:09  omsartori
 * no message
 *
 * Revision 1.4  2006/02/20 12:38:24  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.3  2003/12/04 17:21:07  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/09/27 19:56:34  SLizardo
 * no message
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface BufferSocioDomicilioHome extends EJBHome {

	public BufferSocioDomicilio create(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String PROCESADO, String PROCESADO_ECL) throws RemoteException, CreateException;

	public BufferSocioDomicilio findByPrimaryKey(BufferSocioDomicilioPK pk) throws RemoteException, FinderException;
}


