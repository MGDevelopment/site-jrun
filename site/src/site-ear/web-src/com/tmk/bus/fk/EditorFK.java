package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class EditorFK extends HashMap {
//	 Singleton
	private static final EditorFK instance = new EditorFK();	// Llama al constructor

	public static EditorFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private EditorFK () {
		super(1);
		this.put("editor", new String[][] {new String[]{"id_editor", "id_editor"}});
	}
}
