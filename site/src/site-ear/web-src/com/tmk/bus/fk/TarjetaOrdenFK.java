package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class TarjetaOrdenFK extends HashMap {
	//Singleton
	private static final TarjetaOrdenFK instance = new TarjetaOrdenFK();	// Llama al constructor

	public static TarjetaOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private TarjetaOrdenFK() {
		super(1);
		this.put("tarjeta_orden", new String[][] {
					{"id_orden", "id_orden"},
					{"id_medio_cobro", "id_medio_cobro"},
				}
		);
	}
}
