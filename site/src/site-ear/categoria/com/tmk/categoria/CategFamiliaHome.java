/**
 * @author Lizardo Santiago
 *
 * $Log: CategFamiliaHome.java,v $
 * Revision 1.8  2003/12/04 17:18:52  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/10/03 16:28:45  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/29 15:09:01  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface CategFamiliaHome extends EJBHome {

	public CategFamilia create(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, String DESCRIPCION) throws RemoteException, CreateException;

	public CategFamilia findByPrimaryKey(CategFamiliaPK pk) throws RemoteException, FinderException;

	public Collection findByCategoria(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO) throws RemoteException, FinderException;
}
