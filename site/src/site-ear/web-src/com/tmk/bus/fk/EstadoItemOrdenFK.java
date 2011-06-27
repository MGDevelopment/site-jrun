package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class EstadoItemOrdenFK extends HashMap {
	//Singleton
	private static final EstadoItemOrdenFK instance = new EstadoItemOrdenFK();	// Llama al constructor

	public static EstadoItemOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private EstadoItemOrdenFK() {
		super(1);
		this.put("estado_item_orden", new String[][] {new String[]{"estado", "estado"}});
	}
}
