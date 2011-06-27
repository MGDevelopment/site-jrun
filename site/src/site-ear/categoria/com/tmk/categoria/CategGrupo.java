/**
 * @author Lizardo Santiago
 *
 * $Log: CategGrupo.java,v $
 * Revision 1.6  2003/12/04 17:18:53  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/29 15:09:03  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface CategGrupo extends EJBObject {

	public Integer getCATEGORIA_SECCION() throws RemoteException;

	public void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION) throws RemoteException;

	public Integer getCATEGORIA_GRUPO() throws RemoteException;

	public void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;
}
