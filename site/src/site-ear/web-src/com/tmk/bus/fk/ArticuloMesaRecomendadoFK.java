package com.tmk.bus.fk;

import java.util.HashMap;
@SuppressWarnings("serial")
public final class ArticuloMesaRecomendadoFK extends HashMap {
	// Singleton
	private static final ArticuloMesaRecomendadoFK instance = new ArticuloMesaRecomendadoFK();	// Llama al constructor

	public static ArticuloMesaRecomendadoFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ArticuloMesaRecomendadoFK () {
		super(1);
		this.put("articuleMesaRecomendado", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}

}
