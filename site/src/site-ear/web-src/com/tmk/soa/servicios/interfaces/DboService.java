package com.tmk.soa.servicios.interfaces;

//import java.util.HashSet;
import com.tmk.dbo.DBO;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

public interface DboService {
	public static final Integer DUPLICATE_CODE = 1;
	/**
	 * Pertime transaccionalidad en insert masivos.
	 * @param dbo
	 * @thows 
	 */
	//public void insert(Object dbo,HashSet<String> objetosAGrabar) throws AplicationException;
	
	public void insert(DBO dbo) throws DuplicateException,Exception;
	
	/**
	 * Permite hacer update del dbo, usa el update de DBO
	 * @param DBO,HashSet<String> son los objetos que se deben grabar
	 * @throws DBOInexistenteException,Exception
	 */
	public void update(DBO dbo) throws DBOInexistenteException,Exception;	
	
	/**
	 * Permite hacer delete por pk de dbo, usa el delete de DBO
	 * @param dbo
	 * @exception Exception
	 */
	public void delete(DBO dbo) throws Exception;
	
}
