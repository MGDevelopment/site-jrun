package com.tmk.soa.servicios.interfaces;

import java.util.Date;

/**
 * Administra todo lo relacionado a cheques virtuales y consultas en 
 * @author oCLopez
 *
 */
public interface CuponService {
	 	
	/**
	 * Consulta la tabla "cheques_obsequios" y obtiene la fecha del valor de cupon 
	 * @param cupon
	 * @return
	 * @throws Exception
	 */
	public Date getFecha(String cupon) throws Exception;
	
	/**
	 * Determina en la tabla "categorias" si valor de parametro es un cupon 
	 * @param cupon
	 * @return
	 */
	public boolean esCupon (String cupon) throws Exception;
}
