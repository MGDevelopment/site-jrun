/**
 * @author Lizardo Santiago
 *
 * $Log: EventoBean.java,v $
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

import javax.ejb.*;
import java.sql.Timestamp;

public abstract class EventoBean implements EntityBean {

	private EntityContext entityContext;

	public void setEntityContext(EntityContext entityContext) throws EJBException {
		this.entityContext = entityContext;
	}

	public void unsetEntityContext() throws EJBException {
		this.entityContext = null;
	}

	public void ejbRemove() throws RemoveException, EJBException {
	}

	public void ejbActivate() throws EJBException {
	}

	public void ejbPassivate() throws EJBException {
	}

	public void ejbLoad() throws EJBException {
	}

	public void ejbStore() throws EJBException {
	}

	public Integer ejbCreate(Integer ID_EVENTO, Timestamp FECHA_INICIO, String DESCRIPCION, Integer ID_SUCURSAL, Integer ACTIVO) throws CreateException {
		setID_EVENTO(ID_EVENTO);
		setFECHA_INICIO(FECHA_INICIO);
		setDESCRIPCION(DESCRIPCION);
		setID_SUCURSAL(ID_SUCURSAL);
		setACTIVO(ACTIVO);

		return null;
	}

	public void ejbPostCreate(Integer ID_EVENTO, Timestamp FECHA_INICIO, String DESCRIPCION, Integer ID_SUCURSAL, Integer ACTIVO) throws CreateException {
	}

	public abstract Integer getID_EVENTO();

	public abstract void setID_EVENTO(Integer ID_EVENTO);

	public abstract Timestamp getFECHA_INICIO();

	public abstract void setFECHA_INICIO(Timestamp FECHA_INICIO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getACTIVO();

	public abstract void setACTIVO(Integer ACTIVO);
}
