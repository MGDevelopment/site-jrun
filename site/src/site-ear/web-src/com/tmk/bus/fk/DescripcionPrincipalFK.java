package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DescripcionPrincipalFK  extends HashMap {
//	 Singleton
	private static final DescripcionPrincipalFK instance = new DescripcionPrincipalFK();	// Llama al constructor

	public static DescripcionPrincipalFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private DescripcionPrincipalFK () {
		super(1);
		this.put("descripcionPrincipal", new String[][] {new String[]{"id_articulo", "id_articulo"}});
	}
}
