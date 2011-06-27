package com.tmk.soa.dao.interfaces;

import java.util.Collection;
import com.tmk.bus.socio.SocioDomicilios;
import  com.tmk.bus.socio.SociosIntegracion;
import com.tmk.bus.socio.Socios2;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.SocioPK;

public interface Socios2DAO {

	public void create
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
	        
	        ) throws DuplicateException,Exception;
	
	/**
	 * Obtiene un socio dado su pk
	 * @param pk
	 * @return
	 */
	public Socios2 findByPK(SocioPK pk) throws AplicationException;
		
	/**
	 * Devuelve el e_mail1 y login de un socio dato por su PK
	 * @param SocioPK pk
	 * @return String login desencriptado
	 */
	public String getLogin(SocioPK pk);
	
	/**
	 * Obtiene los domicilio de un socio dado su pk
	 */
	public Collection getDomiciliosByPkSocio(SocioPK socioPk)throws AplicationException;
	
	/**
	 * Obtiene solo los domicilios de envio tipo_domicilio like 'EN%'
	 */
	public Collection findByTipoEnvio(SocioPK socioPk)throws AplicationException;;
	
	/**
	 * Obtiene solo los domicilios de envio tipo_domicilio like 'TF%'
	 */
	public Collection findByTipoFacturacion(SocioPK socioPk)throws AplicationException;

	/**
	 * Obtiene un SocioDomicilios en base a la pk del socios y el tipo de domiciios
	 * @param socioPk
	 * @param tipoDomicilio
	 * @return
	 * @throws AplicationException
	 */
	public SocioDomicilios findByPKYTipoDomicilio(SocioPK socioPk,String tipoDomicilio) throws AplicationException;

	public Socios2 findSocioByLoginPassword(String login, String password) throws AplicationException;
	
	public Socios2 findSocioByLogin(String LOGIN)throws AplicationException;	

	/**
	 * metodo trasladados de la interfaz SocioLocalHome
	 * @param SEXO
	 * @param TIPO_DOC
	 * @param NRO_DOC
	 * @param NACIONALIDAD
	 * @return
	 * @throws AplicationException
	 */
	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws AplicationException;

	public Collection findRepetidosDelSitio(String SEXO, String TIPO_DOC, Long NRO_DOC, Integer NACIONALIDAD) throws AplicationException;
	
	public Socios2 findByPrimaryKey(SocioPK pk) throws DBOInexistenteException,Exception;
	
	/**
	 * Usado para obtener el socios integracion con popego.
	 */
	public SociosIntegracion findSocioIntegracion(SocioPK socioPK, String dominio) throws Exception;
}
