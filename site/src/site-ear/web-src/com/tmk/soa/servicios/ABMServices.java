package com.tmk.soa.servicios;

/**
 * Define los metodos basicos para ABM sobre las tablas
 * @author oCLopez
 *
 */
public interface ABMServices {

	public  void insert(Object obj) throws Exception;
	
	public  void update(Object obj) throws Exception;
	
	public  void delete(Object obj) throws Exception;
}
