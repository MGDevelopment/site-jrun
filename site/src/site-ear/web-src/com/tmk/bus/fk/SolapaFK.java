package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class SolapaFK extends HashMap {
//	 Singleton
	private static final SolapaFK instance = new SolapaFK();	// Llama al constructor

	public static SolapaFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private SolapaFK () {
		super(1);
		this.put("solapa", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}
}
