package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public final class SociosIntegracionFK extends HashMap {
	// Singleton
	private static final SociosIntegracionFK instance = new SociosIntegracionFK();	// Llama al constructor

	public static SociosIntegracionFK getInstance() {
		return instance;
	}
	/*el primer  campo es el nombre del dbo que quiero "joinear" y el segundo argumento 
	 * el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private SociosIntegracionFK () {
		super(1);
		this.put("socioIntegracion", new String[][] {new String[]{"id_socio", "id_socio"}});
	}

}
