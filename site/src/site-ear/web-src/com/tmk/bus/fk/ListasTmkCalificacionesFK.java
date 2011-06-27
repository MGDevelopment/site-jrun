package com.tmk.bus.fk;

import java.util.HashMap;
@SuppressWarnings("serial")
public final class ListasTmkCalificacionesFK extends HashMap {
	private static final ListasTmkCalificacionesFK instance = new ListasTmkCalificacionesFK();

	public static ListasTmkCalificacionesFK getInstance() {
		return instance;
	}
	/*el primer  campo es el del dbo que quiero "joinear" y el array indica como se llaman los campos en cada tabla*/
	@SuppressWarnings("unchecked")
	private ListasTmkCalificacionesFK () {
		super(1);
		this.put("listasTmkCalificaciones", new String[][] {
				{"id_lista", "id_lista"}
			}
		);
	}

}
