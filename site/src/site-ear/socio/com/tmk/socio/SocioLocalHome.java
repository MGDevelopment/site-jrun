/**
 * @author Lizardo Santiago
 *
 * $Log: SocioLocalHome.java,v $
 * Revision 1.16  2008/07/07 18:59:45  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.15  2006/08/14 13:29:22  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.14  2005/02/17 12:14:20  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.13  2004/11/01 16:33:16  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.12  2004/06/09 18:50:18  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.11  2004/05/14 19:19:09  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.10  2003/12/04 17:21:14  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/10/07 17:25:46  SLizardo
 * E_MAIL_1 => E_MAIL1
 *
 * Revision 1.8  2003/10/07 16:19:30  SLizardo
 * E_MAIL_1 para Socios
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface SocioLocalHome extends EJBLocalHome {

	public SocioLocal create
	        (
	        Integer ID_SUCURSAL,
	        Integer ID_SOCIO,
	        Integer ID_CAAL,
	        Integer ID_TIPO_CONTRIBUYENTE,
	        String TIPO_PERSONA,
	        byte[] LOGIN,
	        String NOMBRES,
	        String APELLIDOS,
	        byte[] PASSWORD,
	        String TIPO_DOC,
	        Long NRO_DOC,
	        Integer NACIONALIDAD,
	        java.sql.Timestamp FECHA_NACIMIENTO,
	        String SEXO,
	        String ESTADO_CIVIL,
	        Integer HIJOS,
	        Integer ID_PROFESION,
	        String E_MAIL1,
	        String INFO_EXTRA,
	        String INFO_TERCEROS,
	        String INTERNET_CASA,
	        String PC_CASA,
	        String AUXFLAG2
	        
	        ) throws CreateException;

	public SocioLocal findByPrimaryKey(SocioPK pk) throws FinderException;

	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws FinderException;

	public Collection findRepetidosDelSitio(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws FinderException;
	
	
}
