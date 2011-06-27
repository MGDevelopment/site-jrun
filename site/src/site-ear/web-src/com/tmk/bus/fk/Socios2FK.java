package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public final class Socios2FK extends HashMap {
	// Singleton
	private static final Socios2FK instance = new Socios2FK();	// Llama al constructor

	public static Socios2FK getInstance() {
		return instance;
	}
	/*el primer  campo es el nombre del dbo que quiero "joinear" y el segundo argumento 
	 * el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private Socios2FK () {
		super(2);
		this.put("socio", new String[][] {new String[]{"id_socio", "id_socio"},new String[]{"id_sucursal_socio", "id_sucursal"}});
		this.put("socioTMK", new String[][] {new String[]{"id_socio", "id_socio"},new String[]{"id_sucursal_socio", "id_sucursal"}});
	}

}
