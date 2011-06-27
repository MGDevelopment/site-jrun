package com.tmk.bus.fk;

import java.util.HashMap;
@SuppressWarnings("serial")
public final class ArticuloFK extends HashMap {
	// Singleton
	private static final ArticuloFK instance = new ArticuloFK();	// Llama al constructor

	public static ArticuloFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ArticuloFK () {
		super(1);
		this.put("articulo", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}

}
