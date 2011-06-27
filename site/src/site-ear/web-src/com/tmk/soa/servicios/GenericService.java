package com.tmk.soa.servicios;
/**
 * Define el metodo basico para buscar por pk en cualquier dao.
 */ 
public interface GenericService {

	/**
	 * Define el metodo basico para buscar por pk en cualquier dao.
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public Object findByPk(Object pk) throws Exception;
	
}
