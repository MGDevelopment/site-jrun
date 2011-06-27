/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocioLocalHome.java,v $
 * Revision 1.5  2003/12/04 17:21:18  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/10/09 19:30:14  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.3  2003/09/09 15:17:10  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface TarjetaSocioLocalHome extends EJBLocalHome {

	public TarjetaSocioLocal create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ITEM, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_TITULAR, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN) throws CreateException;

	public TarjetaSocioLocal findByPrimaryKey(TarjetaSocioPK pk) throws FinderException;

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO) throws FinderException;
}
