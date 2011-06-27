package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ContraTapaFK extends HashMap {
//	 Singleton
	private static final ContraTapaFK instance = new ContraTapaFK();	// Llama al constructor

	public static ContraTapaFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ContraTapaFK () {
		super(1);
		this.put("contraTapa", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}
}
