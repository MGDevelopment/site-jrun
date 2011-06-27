package com.tmk.bus.fk;

import java.util.HashMap;
@SuppressWarnings("serial")
public final class ListasTmkArticulosFK extends HashMap {
	private static final ListasTmkArticulosFK instance = new ListasTmkArticulosFK();

	public static ListasTmkArticulosFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ListasTmkArticulosFK () {
		super(1);
		this.put("listaTmkArticulos", new String[][] {
				{"id_lista", "id_lista"}
			}
		);
	}

}
