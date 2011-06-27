/**
 * @author Lizardo Santiago
 *
 * $Log: SocioHome.java,v $
 * Revision 1.15  2008/07/07 18:59:44  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.14  2004/12/27 15:42:34  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
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
 * Revision 1.11  2004/05/14 19:19:08  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.10  2003/12/04 17:21:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/10/07 17:25:41  SLizardo
 * E_MAIL_1 => E_MAIL1
 *
 * Revision 1.8  2003/10/07 16:19:30  SLizardo
 * E_MAIL_1 para Socios
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface SocioHome extends EJBHome {

	public Socio create
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
	        ) throws RemoteException, CreateException;

	public Socio findByPrimaryKey(SocioPK pk) throws RemoteException, FinderException;

	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws RemoteException, FinderException;

}
