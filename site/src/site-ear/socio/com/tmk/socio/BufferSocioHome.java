/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioHome.java,v $
 * Revision 1.12  2008/07/07 18:59:43  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.11  2006/10/12 14:59:09  omsartori
 * no message
 *
 * Revision 1.10  2004/06/09 18:50:15  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.9  2004/05/14 19:19:06  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.8  2003/12/04 17:21:08  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/10/09 20:48:47  SLizardo
 * Cierre de Incidentes
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface BufferSocioHome extends EJBHome {

	public BufferSocio create(
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
	        String PROCESADO,
	        String E_MAIL_1,
	        String INFO_EXTRA,
	        String INFO_TERCEROS,
	        String INTERNET_CASA,
	        String PC_CASA,
	        String PROCESADO_ECL,
	        String AUXFLAG2
	        ) throws RemoteException, CreateException;

	public BufferSocio findByPrimaryKey(BufferSocioPK pk) throws RemoteException, FinderException;
}


