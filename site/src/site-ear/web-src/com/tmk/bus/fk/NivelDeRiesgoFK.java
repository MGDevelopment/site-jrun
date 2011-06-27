package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class NivelDeRiesgoFK extends HashMap {
	//Singleton
	private static final NivelDeRiesgoFK instance = new NivelDeRiesgoFK();	// Llama al constructor

	public static NivelDeRiesgoFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private NivelDeRiesgoFK() {
		super(1);
		this.put("nivel_riesgo", new String[][] {new String[]{"nivel_riesgo", "nivel_riesgo"}});
	}
}
