package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ItemOrdenImpuestoFK extends HashMap {
	//Singleton
	private static final ItemOrdenImpuestoFK instance = new ItemOrdenImpuestoFK();	// Llama al constructor

	public static ItemOrdenImpuestoFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ItemOrdenImpuestoFK() {
		super(1);
		this.put("item_orden_impuesto", new String[][] {
					{"id_orden", "id_orden"},
					{"id_articulo", "id_articulo"}
				}
			);
	}
}
