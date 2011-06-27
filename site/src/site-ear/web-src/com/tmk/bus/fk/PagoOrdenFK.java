package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class PagoOrdenFK extends HashMap {
	private static final PagoOrdenFK instance = new PagoOrdenFK();	// Llama al constructor

	public static PagoOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private PagoOrdenFK() {
		super(1);
		this.put("pago_orden", new String[][] {
					new String[]{"id_orden", "id_orden"}
				}
		);
		/*this.put("mediosDeCobro", new String[][] {
				new String[]{"id_medio_corbo", "id_medio_corbo"}
			}
		);*/
	}
}
