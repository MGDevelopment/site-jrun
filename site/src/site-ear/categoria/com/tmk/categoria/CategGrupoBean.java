/**
 * @author Lizardo Santiago
 *
 * $Log: CategGrupoBean.java,v $
 * Revision 1.7  2003/12/04 17:18:54  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.6  2003/10/03 16:28:46  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/29 15:09:04  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class CategGrupoBean implements EntityBean {

	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public CategGrupoPK ejbCreate(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, String DESCRIPCION) throws CreateException {
		setCATEGORIA_SECCION(CATEGORIA_SECCION);
		setCATEGORIA_GRUPO(CATEGORIA_GRUPO);
		setDESCRIPCION(DESCRIPCION);
		return null;
	}

	public void ejbPostCreate(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, String DESCRIPCION) {
	}

	public abstract Integer getCATEGORIA_SECCION();

	public abstract void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION);

	public abstract Integer getCATEGORIA_GRUPO();

	public abstract void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);
}
