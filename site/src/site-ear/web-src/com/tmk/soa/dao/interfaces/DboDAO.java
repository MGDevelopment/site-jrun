package com.tmk.soa.dao.interfaces;

//import java.util.HashSet;
import com.tmk.dbo.DBO;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

public interface DboDAO {

	//public void insert(Object dbo,HashSet<String>objetosAGrabar) throws AplicationException;
	
	/**
	 * Utiliza el insert(comun) de DBO pero para no separar capas agrega aca el metodo
	 * @param dbo
	 * @throws AplicationException
	 */
	public void insert(DBO dbo) throws DuplicateException, Exception;
	
	/**
	 * Utiliza el update de DBO pero para no separar capas agrega aca el metodo
	 * @param lista
	 * @return boolean (true=updateo;false=no updateo; o AplicationException por error
	 * @throws AplicationException
	 */
	public void update(DBO lista) throws DBOInexistenteException,Exception;
	
	/**
	 * Utiliza el update de DBO pero para no separar capas agrega aca el metodo
	 * @param lista
	 * @return void
	 * @throws Exception
	 */
	public void delete(DBO lista) throws Exception;
	
}
