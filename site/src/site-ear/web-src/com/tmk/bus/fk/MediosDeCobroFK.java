package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class MediosDeCobroFK extends HashMap {
	//Singleton
	private static final MediosDeCobroFK instance = new MediosDeCobroFK();	// Llama al constructor

	public static MediosDeCobroFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private MediosDeCobroFK() {
		super(1);
		this.put("mediosDeCobro", new String[][] {new String[]{"id_medio_cobro", "id_medio_cobro"}});
	}
}
