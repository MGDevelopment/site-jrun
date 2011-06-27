package com.tmk.service.buscador;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.tmk.kernel.Convert;



public class FiltroValor {
	private HashMap<String, String> params = new HashMap<String, String>();
	private Integer idFiltro;
	
	public FiltroValor(HttpServletRequest request) {
		Enumeration e = request.getParameterNames();
		String nombre;
		idFiltro = Convert.toNumber(request.getParameter("FILTRO"), (Integer)null);
		String patron = "FIL" + idFiltro + "_";
		while (e.hasMoreElements()) {
			nombre = e.nextElement().toString();
			if (nombre.startsWith(patron)) {
				params.put(nombre.replaceFirst(patron, ""), request.getParameter(nombre));
			}	
		}
	}
	
	public HashMap<String, String> getParams() {
		return this.params;
	}

	public Integer getIdFiltro() {
		return idFiltro;
	}
}
