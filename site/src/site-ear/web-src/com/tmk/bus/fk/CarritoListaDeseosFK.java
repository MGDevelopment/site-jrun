package com.tmk.bus.fk;
import java.util.HashMap;


@SuppressWarnings("serial")
public class CarritoListaDeseosFK extends HashMap{
//	 Singleton
	private static final CarritoListaDeseosFK instance = new CarritoListaDeseosFK();	// Llama al constructor

	public static CarritoListaDeseosFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private CarritoListaDeseosFK () {
		super(1);
		this.put("listaDeseos", 
					new String[][] {
						{"id_sucursal_socio", "id_sucursal_socio"},
						{"id_socio", "id_socio"}
		});
	}
}
