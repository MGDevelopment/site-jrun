package com.tmk.bus.fk;

import java.util.HashMap;


@SuppressWarnings("serial")
public class DisponibilidadFK extends HashMap {
//	 Singleton
	private static final DisponibilidadFK instance = new DisponibilidadFK();	// Llama al constructor

	public static DisponibilidadFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private DisponibilidadFK () {
		super(1);
		this.put("disponibilidad", new String[][] {new String[]{"id_disponibilidad", "id_disponibilidad"}});
	}

}
