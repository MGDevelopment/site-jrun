package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class IndiceDeContenidoFK  extends HashMap {
//	 Singleton
	private static final IndiceDeContenidoFK instance = new IndiceDeContenidoFK();	// Llama al constructor

	public static IndiceDeContenidoFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private IndiceDeContenidoFK () {
		super(1);
		this.put("indiceDeContenido", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}
}
