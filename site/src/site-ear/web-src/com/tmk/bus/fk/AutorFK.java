package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class AutorFK extends HashMap {
//	 Singleton
	private static final AutorFK instance = new AutorFK();	// Llama al constructor

	public static AutorFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private AutorFK () {
		super(1);
		this.put("autor", new String[][] {new String[]{"id_autor", "id_autor"}});
	}

}
