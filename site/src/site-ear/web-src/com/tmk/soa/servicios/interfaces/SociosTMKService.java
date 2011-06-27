package com.tmk.soa.servicios.interfaces;

import com.tmk.bus.socio.SocioTMK;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.SocioPK;

public interface SociosTMKService {

	public void update(SocioTMK socio) throws DBOInexistenteException, AplicationException;
	
	public void create(Integer idSocio, Integer idSucursal,String login,
			byte[] password, String nombres, String apellidos)
			throws DuplicateException, AplicationException;

	/**
	 * Busca un socio dao su pK en la tabla SOCIOS_TMK
	 * 
	 * @param pk
	 * @return SocioTMK
	 * @throws DBOInexistenteException
	 * @throws Exception
	 * 
	 */
	public SocioTMK findSocioTMKByPK(SocioPK pk)
			throws DBOInexistenteException, Exception;

	public SocioTMK findSocioTmkByLogin(String login)
			throws DBOInexistenteException, Exception;

	public SocioTMK findSocioTmkByLoginPassword(String login, String password)
			throws DBOInexistenteException, Exception;

}
