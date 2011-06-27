package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class NotaRegaloFK extends HashMap {
	//Singleton
	private static final NotaRegaloFK instance = new NotaRegaloFK();	// Llama al constructor

	public static NotaRegaloFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private NotaRegaloFK() {
		super(1);
		this.put("nota_regalo", new String[][] {
					{"id_orden", "id_orden"},
					{"id_articulo", "id_articulo"},
					{"item", "item"}
				}
		);
	}
}
