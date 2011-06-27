package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class TasaFK extends HashMap {

	//	 Singleton
	private static final TasaFK instance = new TasaFK();	// Llama al constructor

	public static TasaFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private TasaFK () {
		super(1);
		this.put("tasa", new String[][] {new String[]{"id_impuesto", "id_impuesto"}});
	}

}
