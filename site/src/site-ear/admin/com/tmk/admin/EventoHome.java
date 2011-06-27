/**
 * @author Lizardo Santiago
 *
 * $Log: EventoHome.java,v $
 * Revision 1.4  2003/12/04 17:18:41  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/10/29 16:16:30  SLizardo
 * Eventos publicos / privados
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Collection;

public interface EventoHome extends EJBHome {

	public Evento create(Integer ID_EVENTO, Timestamp FECHA_INICIO, String DESCRIPCION, Integer ID_SUCURSAL, Integer ACTIVO) throws RemoteException, CreateException;

	public Evento findByPrimaryKey(Integer ID_EVENTO) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

	public Collection findActivos() throws RemoteException, FinderException;
}
