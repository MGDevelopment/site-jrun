package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class FormatoFK extends HashMap {
//	 Singleton
	private static final FormatoFK instance = new FormatoFK();	// Llama al constructor

	public static FormatoFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private FormatoFK () {
		super(1);
		this.put("formato", new String[][] {new String[]{"auxvarchar03", "rv_low_value"}});
	}
}
