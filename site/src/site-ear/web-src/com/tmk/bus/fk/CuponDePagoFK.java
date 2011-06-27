package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class CuponDePagoFK extends HashMap {
	//Singleton
	private static final CuponDePagoFK instance = new CuponDePagoFK();	// Llama al constructor

	public static CuponDePagoFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private CuponDePagoFK() {
		super(1);
		this.put("cupon_pago", new String[][] {
				new String[]{"id_orden", "id_orden"}}
		);
	}
}
