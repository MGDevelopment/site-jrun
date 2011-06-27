/**
 * @author Lizardo Santiago
 *
 * $Log: Evento.java,v $
 * Revision 1.4  2003/12/04 17:18:40  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/10/29 16:16:29  SLizardo
 * Eventos publicos / privados
 *
 */
package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.sql.Timestamp;

public interface Evento extends EJBObject {

	public Integer getID_EVENTO() throws RemoteException;

	public void setID_EVENTO(Integer ID_EVENTO) throws RemoteException;

	public Timestamp getFECHA_INICIO() throws RemoteException;

	public void setFECHA_INICIO(Timestamp FECHA_INICIO) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getACTIVO() throws RemoteException;

	public void setACTIVO(Integer ACTIVO) throws RemoteException;
}
