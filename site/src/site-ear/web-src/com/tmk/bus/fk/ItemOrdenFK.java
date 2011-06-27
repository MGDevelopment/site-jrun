package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ItemOrdenFK extends HashMap {
	//Singleton
	private static final ItemOrdenFK instance = new ItemOrdenFK();	// Llama al constructor

	public static ItemOrdenFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ItemOrdenFK() {
		super(1);
		this.put("item_orden", new String[][] {
					{"id_orden", "id_orden"}}
				);
	}
}
