package com.tmk.soa.servicios.implementation;

import com.tmk.bus.socio.SocioTMK;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.SociosTMKService;
import com.tmk.src.socio.SocioPK;

public class SociosTmkServiceImpl implements SociosTMKService {
	
	public void create (Integer idSocio,Integer idSucursal,String login,byte[] password,String nombres,String apellidos) throws DuplicateException, AplicationException {
		try {
			DAOFactory.getSocioTMK2DAO().create(idSocio, idSucursal, login, password, nombres, apellidos);
		} catch (DuplicateException e) {
			//TmkLogger.error(e.getMessage());
		} catch (Exception e) {
			throw new AplicationException(e);
		}
	}
	public SocioTMK findSocioTmkByLogin(String login)
			throws DBOInexistenteException, Exception {
		try {
			return DAOFactory.getSocioTMK2DAO().findSocioTmkByLogin(login);
		}catch (DBOInexistenteException di) {
			//TmkLogger.debug(di.getMessage());
			throw di;
		}catch(Exception ae){
			throw ae;
		}
	}
	public SocioTMK findSocioTmkByLoginPassword(String login, String password)
			throws DBOInexistenteException, Exception {
		try {
			return DAOFactory.getSocioTMK2DAO().findSocioTmkByLoginPassword(login, password);
		}catch(DBOInexistenteException di) {
			//TmkLogger.debug(di.getMessage());
			throw di;
		}catch(Exception ae) {
			//TmkLogger.debug(ae.getMessage());
			throw ae;
		}
	}
	
	public SocioTMK findSocioTMKByPK(SocioPK pk)
			throws DBOInexistenteException, Exception {
		try {
			return DAOFactory.getSocioTMK2DAO().findSocioTMKByPK(pk);
		}catch (DBOInexistenteException di) {
			//TmkLogger.debug(di.getMessage());
			throw di;
		}catch (Exception ae) {
			TmkLogger.debug("No existe el socio en la tabla SOCIO_TMK (pk ="+pk.ID_SOCIO +"-"+pk.ID_SUCURSAL+")");
			throw ae;
		}
	}
	
	public void update(SocioTMK socio) throws DBOInexistenteException,AplicationException {			
		try {
			DAOFactory.getDboDAO().update(socio);
		} catch (Exception e) {
			throw new AplicationException(e.getMessage());
		}				
	}
	
}
