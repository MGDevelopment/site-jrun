package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class OrdenFK extends HashMap {
	private static final OrdenFK instance = new OrdenFK();	// Llama al constructor

	public static OrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private OrdenFK() {
		super(1);
		this.put("orden", new String[][] {new String[]{"id_orden", "id_orden"}});
	}
}
