package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public final class ArticuloAutorFK extends HashMap {
	// Singleton
	private static final ArticuloAutorFK instance = new ArticuloAutorFK();	// Llama al constructor

	public static ArticuloAutorFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ArticuloAutorFK () {
		super(1);
		this.put("articuloAutor", new String[][] {new String[]{"id_articulo", "id_articulo"}});
		
	}



}
