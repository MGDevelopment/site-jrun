/**
 * @author Lizardo Santiago
 *
 * $Log: EventoLocalHome.java,v $
 * Revision 1.4  2003/12/04 17:18:42  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/10/29 16:16:31  SLizardo
 * Eventos publicos / privados
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.sql.Timestamp;
import java.util.Collection;

public interface EventoLocalHome extends EJBLocalHome {

	public EventoLocal create(Integer ID_EVENTO, Timestamp FECHA_INICIO, String DESCRIPCION, Integer ID_SUCURSAL, Integer ACTIVO) throws CreateException;

	public EventoLocal findByPrimaryKey(Integer ID_EVENTO) throws FinderException;

	public Collection findAll() throws FinderException;

	public Collection findActivos() throws FinderException;
}
