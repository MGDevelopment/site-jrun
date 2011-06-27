package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class LocalidadFK extends HashMap {
	private static final LocalidadFK instance = new LocalidadFK();	

	public static LocalidadFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private LocalidadFK () {
		super(1);
		this.put("localidad", new String[][] {
				{"id_pais", "id_pais"},
				{"id_provincia", "id_provincia"},
				{"id_localidad", "id_localidad"}
			}
		);
	}
}