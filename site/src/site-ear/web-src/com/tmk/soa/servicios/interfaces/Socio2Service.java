package com.tmk.soa.servicios.interfaces;

import com.tmk.bus.socio.Socios2;
import com.tmk.bus.socio.SociosIntegracion;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.SocioPK;
import java.util.Collection; 

public interface Socio2Service {
	
	/**
	 * Devuelve el e_mail1 y login de un socio dato por su PK
	 * @param SocioPK pk
	 * @return String pk
	 */
	public String getLogin(SocioPK pk);
	
	/**
	 * Busca un socio dao su pl en la tabla SOCIOS2
	 * @param pk
	 * @return
	 */
	public Socios2 findByPK(SocioPK pk);
			
	/**
	 * Metodo Trasladado de ShortsCut
	 * @param LOGIN
	 * @param PASSWORD
	 * @return
	 * @throws AplicationException
	 */
	public Socios2 findSocioByLoginPassword(String LOGIN, String PASSWORD);
	
	/**
	 * Metodo Trasladado de ShortsCut
	 * @param LOGIN
	 * @return Socios2
	 * @throws AplicationException
	 */
	public Socios2 findSocioByLogin(String LOGIN);

	/**
	 * trasladado desde SocioLocalHome
	 * @param socioPK
	 * @return
	 */
	public Socios2 findByPrimaryKey(SocioPK socioPK) throws DBOInexistenteException,Exception;
		
	/**
	 * Trasladado del SocioLocalHome
	 * @param SEXO
	 * @param TIPO_DOC
	 * @param NRO_DOC
	 * @param NACIONALIDAD
	 * @return
	 * @throws DBOInexistenteException
	 * @throws Exception
	 */
	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws DBOInexistenteException,Exception;

	/**
	 * Trasladado del SocioLocalHome
	 * @param SEXO
	 * @param TIPO_DOC
	 * @param NRO_DOC
	 * @param NACIONALIDAD
	 * @return
	 */
	public Collection findRepetidosDelSitio(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) ;
	
	/**
	 * Trasladado del SocioLocalHome, crea un socios en la tabla SOCIOS2
	 * @param ID_SUCURSAL
	 * @param ID_SOCIO
	 * @param ID_CAAL
	 * @param ID_TIPO_CONTRIBUYENTE
	 * @param TIPO_PERSONA
	 * @param LOGIN
	 * @param NOMBRES
	 * @param APELLIDOS
	 * @param PASSWORD
	 * @param TIPO_DOC
	 * @param NRO_DOC
	 * @param NACIONALIDAD
	 * @param FECHA_NACIMIENTO
	 * @param SEXO
	 * @param ESTADO_CIVIL
	 * @param HIJOS
	 * @param ID_PROFESION
	 * @param E_MAIL1
	 * @param INFO_EXTRA
	 * @param INFO_TERCEROS
	 * @param INTERNET_CASA
	 * @param PC_CASA
	 * @param AUXFLAG2
	 * @throws DuplicateException
	 * @throws Exception
	 */
	public void create(Integer ID_SUCURSAL, Integer ID_SOCIO, Integer ID_CAAL,
			Integer ID_TIPO_CONTRIBUYENTE, String TIPO_PERSONA, byte[] LOGIN,
			String NOMBRES, String APELLIDOS, byte[] PASSWORD, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD,
			java.sql.Timestamp FECHA_NACIMIENTO, String SEXO,
			String ESTADO_CIVIL, Integer HIJOS, Integer ID_PROFESION,
			String E_MAIL1, String INFO_EXTRA, String INFO_TERCEROS,
			String INTERNET_CASA, String PC_CASA, String AUXFLAG2

	) throws DuplicateException, Exception;

	public SociosIntegracion getSocioIntegracion(SocioPK socioPk,String dominio);
}
