/**
 * @author Lizardo Santiago
 *
 * $Log: CategFamiliaLocalHome.java,v $
 * Revision 1.8  2003/12/04 17:18:53  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/10/03 16:28:46  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/29 15:09:01  SLizardo
 * Optimizacion.
 *
 */
package com.tmk.categoria;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface CategFamiliaLocalHome extends EJBLocalHome {

	public CategFamiliaLocal create(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, String DESCRIPCION) throws CreateException;

	public CategFamiliaLocal findByPrimaryKey(CategFamiliaPK pk) throws FinderException;

	public Collection findByCategoria(Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO) throws FinderException;
}
