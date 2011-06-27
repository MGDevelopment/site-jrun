/**
 * @author Lizardo Santiago
 *
 * $Log: EventoLocal.java,v $
 * Revision 1.4  2003/12/04 17:18:41  GPistoia
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

import javax.ejb.EJBLocalObject;
import java.sql.Timestamp;

public interface EventoLocal extends EJBLocalObject {

	public Integer getID_EVENTO();

	public void setID_EVENTO(Integer ID_EVENTO);

	public Timestamp getFECHA_INICIO();

	public void setFECHA_INICIO(Timestamp FECHA_INICIO);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public Integer getACTIVO();

	public void setACTIVO(Integer ACTIVO);
}
