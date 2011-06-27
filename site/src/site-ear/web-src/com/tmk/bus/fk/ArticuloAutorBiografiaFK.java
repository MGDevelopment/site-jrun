package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ArticuloAutorBiografiaFK extends HashMap{
	// Singleton
	private static final ArticuloAutorBiografiaFK instance = new ArticuloAutorBiografiaFK();	// Llama al constructor

	public static ArticuloAutorBiografiaFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ArticuloAutorBiografiaFK () {
		super(1);
		this.put("biografia", new String[][] {new String[]{"id_articulo", "id_articulo"},
				new String[]{"id_autor", "id_autor"}, new String[]{"role", "role"}});
	}

}
