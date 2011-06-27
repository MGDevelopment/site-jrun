package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class TipoArticuloFK extends HashMap {
//	 Singleton
	private static final TipoArticuloFK instance = new TipoArticuloFK();	// Llama al constructor

	public static TipoArticuloFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private TipoArticuloFK() {
		super(1);
		this.put("tipoArticulo", new String[][] {new String[]{"id_tipo_articulo", "id_tipo_articulo"}});
	}
}
