/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaHome.java,v $
 * Revision 1.7  2006/02/09 16:15:32  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.6  2006/01/31 15:51:24  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.5  2004/02/11 19:32:42  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.4  2003/12/04 17:18:36  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/11/11 14:31:34  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.2  2003/10/14 08:31:21  SLizardo
 * no message
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface AlianzaHome extends EJBHome {

	public Alianza create(Integer ID_ALIANZA, String RAZON_SOCIAL, String URL, String TIPO_NEGOCIO, String CUIT, String USUARIO, String CLAVE, Integer ID_TIPO_CONTRIBUYENTE, String NOMBRE_CONTACTO, String APELLIDO_CONTACTO, String CARGO_CONTACTO, String NOMBRE_PAGO_COMISION, String APELLIDO_PAGO_COMISION, String E_MAIL_1, String E_MAIL_2, String TIPO_COMISION, Double PORC_COMISION_PARTICULAR) throws RemoteException, CreateException;

	public Alianza findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Alianza findByUsuarioClave(String USUARIO, String CLAVE) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

    /*socio-alianza*/
    //public Alianza findBySocio(Integer ID_SOCIO) throws RemoteException, FinderException;
    /*socio-alianza*/
}