package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ArticuloCompiladorFK extends HashMap {
	// Singleton
	private static final ArticuloCompiladorFK instance = new ArticuloCompiladorFK();	// Llama al constructor

	public static ArticuloCompiladorFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ArticuloCompiladorFK () {
		super(1);
		this.put("articuloCompilador", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}

}
