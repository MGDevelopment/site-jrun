package com.tmk.soa.dao.interfaces;

import java.util.Collection;

import com.tmk.soa.dao.DaoGenerico;
import com.tmk.soa.exceptions.DBOInexistenteException;

public interface ListasTmkDAO extends DaoGenerico{ 

	/**
	 * Obtiene todas las listas de un socio, dado su pk
	 * @param pk=pk del socio que se desea obtener las listas.
	 * @return Coleccion de listas para un socio
	 * @throws DBOInexistenteException
	 * @throws Exception
	 */
	//public Collection<?> findBySocio(Object pk) throws DBOInexistenteException,Exception;
	
	public Collection<?> findBySocio(Object pk,boolean socioTMK) throws DBOInexistenteException,Exception;
	
	public Object findByPk(Object pk,boolean esSocioTMK) throws DBOInexistenteException,Exception;
}
