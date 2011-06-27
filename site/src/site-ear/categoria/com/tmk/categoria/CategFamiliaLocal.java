/**
 * @author Lizardo Santiago
 *
 * $Log: CategFamiliaLocal.java,v $
 * Revision 1.6  2003/12/04 17:18:53  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/09/29 15:09:01  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import javax.ejb.EJBLocalObject;

public interface CategFamiliaLocal extends EJBLocalObject {

	public Integer getCATEGORIA_SECCION();

	public void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION);

	public Integer getCATEGORIA_GRUPO();

	public void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO);

	public Integer getCATEGORIA_FAMILIA();

	public void setCATEGORIA_FAMILIA(Integer CATEGORIA_FAMILIA);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);
}
