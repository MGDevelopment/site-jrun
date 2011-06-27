package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class DominioSiteFK extends HashMap {
	//Singleton
	private static final DominioSiteFK instance = new DominioSiteFK();	// Llama al constructor

	public static DominioSiteFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private DominioSiteFK() {
		super(1);
		this.put("dominio_site", new String[][] {
				new String[]{"id_dominio", "id_dominio"}
			}
		);
	}
}
