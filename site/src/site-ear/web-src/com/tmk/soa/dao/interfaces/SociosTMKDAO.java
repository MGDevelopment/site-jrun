package com.tmk.soa.dao.interfaces;

import com.tmk.bus.socio.SocioTMK;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.SocioPK;

public interface SociosTMKDAO {

	public void create(Integer idSocio, Integer idSucursal, String login,
			byte[] password, String nombres, String apellidos)
			throws DuplicateException, Exception;

	/**
	 * Obtiene un socio dado su pk en la tabla SOCIOS_TMK
	 * 
	 * @param pk
	 * @return
	 */
	public SocioTMK findSocioTMKByPK(SocioPK pk)
			throws DBOInexistenteException, Exception;

	/**
	 * Creado para remplazar el bloque de acceso a db en el servlet
	 * ModificarSocio.java
	 * 
	 * @param login
	 * @return SocioTMK
	 * @throws AplicationException
	 */
	public SocioTMK findSocioTmkByLogin(String login)
			throws DBOInexistenteException, Exception;

	/**
	 * Creado para remplazar el bloque de acceso a db en el servlet
	 * IniciarSesion.java
	 * 
	 * @param login
	 * @param password
	 * @return SocioTMK
	 * @throws AplicationException
	 */
	public SocioTMK findSocioTmkByLoginPassword(String login, String password)
			throws DBOInexistenteException, Exception;
}
