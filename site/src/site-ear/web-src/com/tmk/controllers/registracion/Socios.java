/**
 * @author Lizardo Santiago
 *
 * $Log: Socios.java,v $
 * Revision 1.16  2008/07/07 19:00:08  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.15  2008/04/09 20:20:25  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.14  2006/10/12 14:59:12  omsartori
 * no message
 *
 * Revision 1.13  2004/07/08 20:19:06  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.12  2004/06/09 18:50:24  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.11  2004/05/14 19:19:13  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.10  2004/04/12 20:19:15  oGPistoia
 * - Cambios en la registracion
 * - Mejoras para las alianzas
 *
 * Revision 1.9  2003/12/22 22:28:00  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.8  2003/10/09 20:48:45  SLizardo
 * Cierre de Incidentes
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.DboService;
import com.tmk.src.socio.BufferSocioPK;
import com.tmk.src.socio.SocioPK;
//import com.tmk.socio.*;
import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.Socios2;
import com.tmk.bus.socio.Socios2DTO;
import com.tmk.kernel.*;
//import javax.ejb.CreateException;
//import javax.ejb.FinderException;
//import javax.ejb.ObjectNotFoundException;
import javax.naming.NamingException;

public final class Socios
{
	//public static SocioLocal crearSocio(Integer ID_SUCURSAL, Integer ID_SOCIO, Integer ID_CAAL, Integer ID_TIPO_CONTRIBUYENTE, String TIPO_PERSONA_FISICA, String LOGIN, String NOMBRES, String APELLIDOS, String PASSWORD, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD, java.sql.Timestamp FECHA_NACIMIENTO, String SEXO, String ESTADO_CIVIL, Integer HIJOS, Integer ID_PROFESION)
	public static void crearSocio(Integer ID_SUCURSAL, Integer ID_SOCIO, Integer ID_CAAL, Integer ID_TIPO_CONTRIBUYENTE, String TIPO_PERSONA_FISICA, String LOGIN, String NOMBRES, String APELLIDOS, String PASSWORD, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD, java.sql.Timestamp FECHA_NACIMIENTO, String SEXO, String ESTADO_CIVIL, Integer HIJOS, Integer ID_PROFESION)
		//throws NamingException, CreateException
		throws DuplicateException, Exception
	{
		//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");		
		//BufferSocioLocalHome bufferHome = (BufferSocioLocalHome)DBUtil.getHome("BufferSocio");

		byte[] LOGIN_ENC = CryptUtil.encriptar(LOGIN.getBytes());
		byte[] PASSWORD_ENC = CryptUtil.encriptar(PASSWORD.getBytes());

		TmkLogger.debug("Crea socio " + Convert.nombreCompleto(NOMBRES, APELLIDOS) + " Secuencia: " + ID_SOCIO);		
		ServiceLocator.getSocioService().create(
				ID_SUCURSAL,
				ID_SOCIO,
				ID_CAAL,
				ID_TIPO_CONTRIBUYENTE,
				TIPO_PERSONA_FISICA,
				LOGIN_ENC,
				NOMBRES,
				APELLIDOS,
				PASSWORD_ENC,
				TIPO_DOC,
				NRO_DOC,
				NACIONALIDAD,
				FECHA_NACIMIENTO,
				SEXO,
				ESTADO_CIVIL,
				HIJOS,
				ID_PROFESION,
		        LOGIN,
		        null,
		        null,
		        null,
		        null, 
		        null
		);
		
		/*SocioLocal socio = socioHome.create(
				ID_SUCURSAL,
				ID_SOCIO,
				ID_CAAL,
				ID_TIPO_CONTRIBUYENTE,
				TIPO_PERSONA_FISICA,
				LOGIN_ENC,
				NOMBRES,
				APELLIDOS,
				PASSWORD_ENC,
				TIPO_DOC,
				NRO_DOC,
				NACIONALIDAD,
				FECHA_NACIMIENTO,
				SEXO,
				ESTADO_CIVIL,
				HIJOS,
				ID_PROFESION,
		        LOGIN,
		        null,
		        null,
		        null,
		        null, 
		        null
		);*/

		TmkLogger.debug("Crea buffer socio " + Convert.nombreCompleto(NOMBRES, APELLIDOS) + " Secuencia: " + ID_SOCIO);
		
		ServiceLocator.getBufferSocioService().create(
				ID_SUCURSAL,
				ID_SOCIO,
				ID_CAAL,
				ID_TIPO_CONTRIBUYENTE,
				TIPO_PERSONA_FISICA,
				LOGIN_ENC,
				NOMBRES,
				APELLIDOS,
				PASSWORD_ENC,
				TIPO_DOC,
				NRO_DOC,
				NACIONALIDAD,
				FECHA_NACIMIENTO,
				SEXO,
				ESTADO_CIVIL,
				HIJOS,
				ID_PROFESION,
		        "N",
		        LOGIN,
				null,
				null,
				null,
				null,
				null,
				null
		);
		
		/*bufferHome.create(
				ID_SUCURSAL,
				ID_SOCIO,
				ID_CAAL,
				ID_TIPO_CONTRIBUYENTE,
				TIPO_PERSONA_FISICA,
				LOGIN_ENC,
				NOMBRES,
				APELLIDOS,
				PASSWORD_ENC,
				TIPO_DOC,
				NRO_DOC,
				NACIONALIDAD,
				FECHA_NACIMIENTO,
				SEXO,
				ESTADO_CIVIL,
				HIJOS,
				ID_PROFESION,
		        "N",
		        LOGIN,
				null,
				null,
				null,
				null,
				null,
				null
		);*/

		//return socio;
	}

	private static String retornarSoN(Boolean valor) {
		return (valor == null) ? null : (valor.booleanValue() ? "S" : "N");
	}

	/**
	 * Actualiza la informacion de la tabla socios2, y la de buffer_socios
	 * @param socioPK
	 * @param INFO_EXTRA
	 * @param INFO_TERCEROS
	 * @param PC_CASA
	 * @param INTERNET_CASA
	 * @throws NamingException
	 * @throws FinderException
	 */
	public static void actualizarSocio(com.tmk.src.socio.SocioPK socioPK,
	                                   Boolean INFO_EXTRA, Boolean INFO_TERCEROS, Boolean PC_CASA, Boolean INTERNET_CASA)
	        //throws NamingException, FinderException {
		throws DBOInexistenteException, Exception {
		
		//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
		//SocioLocal socio = socioHome.findByPrimaryKey(socioPK);
		//socio.setINFO_EXTRA(retornarSoN(INFO_EXTRA));
		//socio.setINFO_TERCEROS(retornarSoN(INFO_TERCEROS));
		//socio.setPC_CASA(retornarSoN(PC_CASA));
		//socio.setINTERNET_CASA(retornarSoN(INTERNET_CASA));
		
		DboService servicio = ServiceLocator.getDboService();
		
		Socios2DTO socio =  new Socios2DTO(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO); 
		socio.setInfo_extra(retornarSoN(INFO_EXTRA));
		socio.setInfo_terceros(retornarSoN(INFO_TERCEROS));
		socio.setPc_casa(retornarSoN(PC_CASA));
		socio.setInternet_casa(retornarSoN(INTERNET_CASA));
		servicio.update(socio);
		try {
			/*BufferSocioLocalHome bufferHome = (BufferSocioLocalHome)DBUtil.getHome("BufferSocio");
			BufferSocioPK bufferPK = new BufferSocioPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
			BufferSocioLocal buffer = bufferHome.findByPrimaryKey(bufferPK);
			
			buffer.setINFO_EXTRA(retornarSoN(INFO_EXTRA));
			buffer.setINFO_TERCEROS(retornarSoN(INFO_TERCEROS));
			buffer.setPC_CASA(retornarSoN(PC_CASA));
			buffer.setINTERNET_CASA(retornarSoN(INTERNET_CASA));*/
			
			BufferSocios buffer = new BufferSocios(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO);
			buffer.setInfo_extra(retornarSoN(INFO_EXTRA));
			buffer.setInfo_terceros(retornarSoN(INFO_TERCEROS));
			buffer.setPc_casa(retornarSoN(PC_CASA));
			buffer.setInternet_casa(retornarSoN(INTERNET_CASA));
			servicio.update(buffer);
			
		} catch (Exception e) {
			//no hace nada, si no encuentra el socio es debido a que los socios de sucursal no tienen
			//buffer en tmk
		}		
	}
		

	public static void actualizarSocio(Integer ID_SUCURSAL, Integer ID_SOCIO, String LOGIN,
	                                   String NOMBRES, String APELLIDOS, String PASSWORD,
	                                   String TIPO_DOC, Long NRO_DOC,
	                                   Integer NACIONALIDAD,
	                                   java.sql.Timestamp FECHA_NACIMIENTO,
	                                   String SEXO, String ESTADO_CIVIL, Integer HIJOS, Integer ID_PROFESION,
	                                   String INFO_EXTRA, String INFO_TERCEROS, String INTERNET_CASA, String PC_CASA)
		//throws NamingException, FinderException
		throws DBOInexistenteException, Exception
	{
		//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
		SocioPK socioPK = new SocioPK(ID_SUCURSAL, ID_SOCIO);
		//SocioLocal socio = socioHome.findByPrimaryKey(socioPK);
		Socios2 socio1 = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);

		byte[] LOGIN_ENC = CryptUtil.encriptar(LOGIN.getBytes());
		byte[] PASSWORD_ENC = CryptUtil.encriptar(PASSWORD.getBytes());

		Socios2DTO socio = new Socios2DTO(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO);
		socio.setLogin(LOGIN_ENC);
		socio.setNombres(NOMBRES);
		socio.setApellidos(APELLIDOS);
		socio.setPassword(PASSWORD_ENC);
		socio.setTipo_doc(TIPO_DOC);
		socio.setNro_doc(NRO_DOC);
		socio.setNacionalidad(NACIONALIDAD);
		socio.setFecha_nacimiento(FECHA_NACIMIENTO);
		socio.setSexo(SEXO);
		socio.setEstado_civil(ESTADO_CIVIL);
		socio.setHijos(HIJOS);
		socio.setId_profesion(ID_PROFESION);
		socio.setE_mail1(LOGIN);
		socio.setInfo_extra(INFO_EXTRA);
		socio.setInfo_terceros(INFO_TERCEROS);
		socio.setInternet_casa(INTERNET_CASA);
		socio.setPc_casa(PC_CASA);
		ServiceLocator.getDboService().update(socio);
		/*socio.setLOGIN(LOGIN_ENC);
		socio.setNOMBRES(NOMBRES);
		socio.setAPELLIDOS(APELLIDOS);
		socio.setPASSWORD(PASSWORD_ENC);
		socio.setTIPO_DOC(TIPO_DOC);
		socio.setNRO_DOC(NRO_DOC);
		socio.setNACIONALIDAD(NACIONALIDAD);
		socio.setFECHA_NACIMIENTO(FECHA_NACIMIENTO);
		socio.setSEXO(SEXO);
		socio.setESTADO_CIVIL(ESTADO_CIVIL);
		socio.setHIJOS(HIJOS);
		socio.setID_PROFESION(ID_PROFESION);
		socio.setE_MAIL1(LOGIN);
		socio.setINFO_EXTRA(INFO_EXTRA);
		socio.setINFO_TERCEROS(INFO_TERCEROS);
		socio.setINTERNET_CASA(INTERNET_CASA);
		socio.setPC_CASA(PC_CASA);*/
		
		//BufferSocioLocalHome bufferHome = (BufferSocioLocalHome)DBUtil.getHome("BufferSocio");
		BufferSocioPK bufferPK = new BufferSocioPK(ID_SUCURSAL, ID_SOCIO);
		try
		{
			//BufferSocioLocal buffer = bufferHome.findByPrimaryKey(bufferPK);
			BufferSocios buffer = new BufferSocios(bufferPK);

			buffer.setLogin(LOGIN_ENC);
			buffer.setNombres(NOMBRES);
			buffer.setApellidos(APELLIDOS);
			buffer.setPassword(PASSWORD_ENC);
			buffer.setTipo_doc(TIPO_DOC);
			buffer.setNro_doc(NRO_DOC);
			buffer.setNacionalidad(NACIONALIDAD);
			buffer.setFecha_nacimiento(FECHA_NACIMIENTO);
			buffer.setSexo(SEXO);
			buffer.setEstado_civil(ESTADO_CIVIL);
			buffer.setHijos(HIJOS);
			buffer.setId_profesion(ID_PROFESION);
			buffer.setProcesado("N");
			buffer.setE_mail1(LOGIN);
			buffer.setInfo_extra(INFO_EXTRA);
			buffer.setInfo_terceros(INFO_TERCEROS);
			buffer.setInternet_casa(INTERNET_CASA);
			buffer.setPc_casa(PC_CASA);
			buffer.setProcesado_ecl(null);
			ServiceLocator.getDboService().update(buffer);
			/*buffer.setLOGIN(LOGIN_ENC);
			buffer.setNOMBRES(NOMBRES);
			buffer.setAPELLIDOS(APELLIDOS);
			buffer.setPASSWORD(PASSWORD_ENC);
			buffer.setTIPO_DOC(TIPO_DOC);
			buffer.setNRO_DOC(NRO_DOC);
			buffer.setNACIONALIDAD(NACIONALIDAD);
			buffer.setFECHA_NACIMIENTO(FECHA_NACIMIENTO);
			buffer.setSEXO(SEXO);
			buffer.setESTADO_CIVIL(ESTADO_CIVIL);
			buffer.setHIJOS(HIJOS);
			buffer.setID_PROFESION(ID_PROFESION);
			buffer.setPROCESADO("N");
			buffer.setE_MAIL1(LOGIN);
			buffer.setINFO_EXTRA(INFO_EXTRA);
			buffer.setINFO_TERCEROS(INFO_TERCEROS);
			buffer.setINTERNET_CASA(INTERNET_CASA);
			buffer.setPC_CASA(PC_CASA);
			buffer.setPROCESADO_ECL(null);*/
		}
		//catch (ObjectNotFoundException onf)
		catch (DBOInexistenteException onf)
		{
			try
			{
				ServiceLocator.getBufferSocioService().create(
						ID_SUCURSAL,
						ID_SOCIO,
						new Integer(Globals.ID_CANAL_ALTERNATIVO),
						new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
						Globals.TIPO_PERSONA_FISICA,
						LOGIN_ENC,
						NOMBRES,
						APELLIDOS,
						PASSWORD_ENC,
						TIPO_DOC,
						NRO_DOC,
						NACIONALIDAD,
						FECHA_NACIMIENTO,
						SEXO,
						ESTADO_CIVIL,
						HIJOS,
						ID_PROFESION,
						"N",
					    LOGIN,
					    INFO_EXTRA,
					    INFO_TERCEROS,
					    INTERNET_CASA,
					    PC_CASA,
					    null,
					    socio1.getAuxflag2());
				
				/*bufferHome.create(
					ID_SUCURSAL,
					ID_SOCIO,
					new Integer(Globals.ID_CANAL_ALTERNATIVO),
					new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
					Globals.TIPO_PERSONA_FISICA,
					LOGIN_ENC,
					NOMBRES,
					APELLIDOS,
					PASSWORD_ENC,
					TIPO_DOC,
					NRO_DOC,
					NACIONALIDAD,
					FECHA_NACIMIENTO,
					SEXO,
					ESTADO_CIVIL,
					HIJOS,
					ID_PROFESION,
					"N",
				    LOGIN,
				    INFO_EXTRA,
				    INFO_TERCEROS,
				    INTERNET_CASA,
				    PC_CASA,
				    null,
				    socio.getAUXFLAG2()
				);*/
			}
			//catch (CreateException ce)
			catch (Exception ce)
			{
				TmkLogger.error(ce.getMessage());
			}
		}
	}
}
