package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ProvinciaFK extends HashMap {
	private static final ProvinciaFK instance = new ProvinciaFK();	

	public static ProvinciaFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ProvinciaFK () {
		super(1);
		this.put("provincia", 
				new String[][] { //padre	//hijo
					{"id_pais", "id_pais"},
					{"id_provincia", "id_provincia"}
				});
		/*this.put("provincia", 
				new String[][] { //padre	//hijo
					{"id_pais", "id_pais"}
				});*/
	}
}
