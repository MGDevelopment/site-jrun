package com.tmk.bus.comentario;

import java.util.HashMap;

@SuppressWarnings("serial")
public final class ComentarioArticuloFK extends HashMap {
	// Singleton
	private static final ComentarioArticuloFK instance = new ComentarioArticuloFK();	// Llama al constructor

	public static ComentarioArticuloFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ComentarioArticuloFK () {
		super(1);
		this.put("comentarioArticulo", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}

}
