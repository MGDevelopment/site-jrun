package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class AlianzaSeccionFK extends HashMap {
	//Singleton
	private static final AlianzaSeccionFK instance = new AlianzaSeccionFK();	// Llama al constructor

	public static AlianzaSeccionFK getInstance() {
		return instance;
	}
	
	private AlianzaSeccionFK() {
		super(1);
		this.put("alianza_seccion", new String[][] {
				new String[]{"id_alianza", "id_alianza"},
				new String[]{"id_seccion", "id_seccion"},
			}
		);
	}
}
