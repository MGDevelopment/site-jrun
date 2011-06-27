package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class EstadoOrdenFK extends HashMap {
	//Singleton
	private static final EstadoOrdenFK instance = new EstadoOrdenFK();	// Llama al constructor

	public static EstadoOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private EstadoOrdenFK() {
		super(1);
		this.put("estado", new String[][] {new String[]{"estado", "estado"}});
	}
}
