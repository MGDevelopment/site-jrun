package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class TemaMusicalFK extends HashMap {
//	 Singleton
	private static final TemaMusicalFK instance = new TemaMusicalFK();	// Llama al constructor

	public static TemaMusicalFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private TemaMusicalFK () {
		super(1);
		this.put("temaMusical", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}
}
