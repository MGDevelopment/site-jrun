package com.tmk.soa.servicios.interfaces;

import javax.servlet.http.HttpServletRequest;

import com.tmk.service.buscador.BusquedaGenerica;
import com.tmk.soa.bo.BuscadorBO;

public interface BuscadorService {

	static String[]suprimir = {"LA", "DE", "DEL", "CON", "LO", "LOS", "EL", "EN", "ANTE", "POR", "ESTE", "ESTA",
			"ESTOS", "Y", "A", "BAJO", "CONTRA", "DESDE", "DURANTE", "ENTRE", "HACIA", "HASTA", "MEDIANTE",
			"PARA", "SEGUN", "SIN", "SOBRE", "TRAS", ",", ";", "O", "UN", "LAS", "I", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	/**
	 * Obtiene un buscador generico para bucador avanzado.
	 * @param request
	 * @return
	 */
	public BusquedaGenerica getBuscadorAvanzado(HttpServletRequest request,BuscadorBO buscadorBo);
	
	
	public BusquedaGenerica getBuscador(HttpServletRequest request,BuscadorBO buscadorBo);
	
	
	public BuscadorBO getBuscadorBO (HttpServletRequest request);
	
}
