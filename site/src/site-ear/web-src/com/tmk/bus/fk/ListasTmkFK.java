package com.tmk.bus.fk;

import java.util.HashMap;
@SuppressWarnings("serial")
public final class ListasTmkFK extends HashMap {
	private static final ListasTmkFK instance = new ListasTmkFK();

	public static ListasTmkFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ListasTmkFK () {
		super(1);
		this.put("listaTmk", new String[][] {
				{"id_lista", "id_lista"}
			}
		);
	}

}
