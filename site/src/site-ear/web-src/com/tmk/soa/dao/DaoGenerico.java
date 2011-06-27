package com.tmk.soa.dao;

import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

/**
 * Define desde su implementacion 15/07/2010, los metodos basicos
 * insert,update,delte y findByPk. 
 * @author oCLopez
 *
 */
public interface DaoGenerico {

	public void insert(Object obj) throws DuplicateException, Exception;
	
	public void update(Object obj) throws DBOInexistenteException,Exception;
	
	public void delete(Object obj) throws Exception;
	
	public Object findByPk(Object pk) throws DBOInexistenteException,Exception;
}
