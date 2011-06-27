package com.tmk.bus.comentario;

import java.util.HashMap;

public final class CopyOfComentarioArticuloFK extends HashMap {
	// Singleton
	private static final CopyOfComentarioArticuloFK instance = new CopyOfComentarioArticuloFK();	// Llama al constructor

	public static CopyOfComentarioArticuloFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	private CopyOfComentarioArticuloFK () {
		super(1);
		this.put("comentarioArticulo", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}

}
