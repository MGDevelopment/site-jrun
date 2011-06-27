package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class MasVendidoSeccionFK extends HashMap{
//	 Singleton
	private static final MasVendidoSeccionFK instance = new MasVendidoSeccionFK();	// Llama al constructor

	public static MasVendidoSeccionFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private MasVendidoSeccionFK () {
		super(1);
		this.put("masVendidoSeccion", new String[][] {new String[]{"id_articulo", "id_articulo"},new String[]{"categoria_seccion", "categoria_seccion"}});
	}

}
