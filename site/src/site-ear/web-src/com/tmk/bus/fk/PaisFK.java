package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class PaisFK extends HashMap {
	private static final PaisFK instance = new PaisFK();	

	public static PaisFK getInstance() {
		return instance;
	}
	/**
	 * La fk funciona de la siguiente manera:
	 * Un socios tiene nacionalidad y domicilios, por lo tanto la fk varia si es para la tabla paises o 
	 * socios_domicilios. Por ello es que se definen dos atributos  una "pais" y el otro "nacionalidad"
	 * por lo tanto si la clase Pais esta como atributo dentro de un socios es la nacionalidad del socios
	 * pero si esta dentro de SociosDomicilios.java es el "pais" donde esta ubicado el domicilio. 
	 */
	@SuppressWarnings("unchecked")
	private PaisFK () {
		super(2);
		this.put("pais", new String[][] {{"id_pais", "id_pais"}});
		this.put("nacionalidad", new String[][] {{"nacionalidad", "id_pais"}});
	}
}
