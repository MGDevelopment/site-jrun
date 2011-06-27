package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DireccionOrdenFK extends HashMap {
	//Singleton
	private static final DireccionOrdenFK instance = new DireccionOrdenFK();	// Llama al constructor

	public static DireccionOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private DireccionOrdenFK() {
		super(1);
		this.put("direccion_orden", new String[][] {
				new String[]{"id_orden", "id_orden"}/*,
				new String[]{"id_sucursal_socio", "id_sucursal_socio"},
				new String[]{"id_socio", "id_socio"}*/
				}
		);
	}
}
