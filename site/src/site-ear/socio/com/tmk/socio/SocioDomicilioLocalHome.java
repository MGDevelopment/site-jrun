/**
 * @author Lizardo Santiago
 *
 * $Log: SocioDomicilioLocalHome.java,v $
 * Revision 1.8  2004/09/07 16:15:31  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.7  2003/12/04 17:21:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.6  2003/11/19 18:55:45  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.5  2003/09/09 15:52:51  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface SocioDomicilioLocalHome extends EJBLocalHome {

	public SocioDomicilioLocal create(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String DESCRIPCION_PROVINCIA_INEX, String DESCRIPCION_LOCALIDAD_INEX) throws CreateException;

	public SocioDomicilioLocal findByPrimaryKey(SocioDomicilioPK pk) throws FinderException;

	public Collection findBySocio(Integer ID_SUCURSAL, Integer ID_SOCIO) throws FinderException;

	public Collection findByTipoEnvio(Integer ID_SUCURSAL, Integer ID_SOCIO) throws FinderException;

	public Collection findByTipoFacturacion(Integer ID_SUCURSAL, Integer ID_SOCIO) throws FinderException;


}


