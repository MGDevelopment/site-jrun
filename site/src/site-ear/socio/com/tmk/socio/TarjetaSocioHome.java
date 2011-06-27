/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocioHome.java,v $
 * Revision 1.5  2003/12/04 17:21:17  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/10/09 19:30:13  GPistoia
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
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface TarjetaSocioHome extends EJBHome {

	public TarjetaSocio create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ITEM, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_TITULAR, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN) throws RemoteException, CreateException;

	public TarjetaSocio findByPrimaryKey(TarjetaSocioPK pk) throws RemoteException, FinderException;

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO) throws RemoteException, FinderException;
}
