package com.tmk.soa.servicios.interfaces;

import java.util.Hashtable;
import java.util.Vector;

import com.tmk.bus.articulo.Articulo;

public interface DetalleService {
	
	/**
	 * Devuele la template que representa el detalle de un articulo
	*/ 
	public String getTemplate(Articulo articulo,String path) throws Exception;
	 
	/**
	 * Retorna un vector con los autores, para setear en una tempalte o hash.
	 * metodo utilizado para usarse ne las templates donde haya que poner los autores
	 * con los link de busqueda por cada uno.
	 * @param boolean indica si tiene autor
	 * @param Object representa el articulo
	 */
	public Vector<Hashtable<String, Object>> getAutores(Object autores);
}
