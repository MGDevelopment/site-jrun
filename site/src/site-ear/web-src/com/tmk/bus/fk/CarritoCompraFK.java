package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class CarritoCompraFK extends HashMap<String, String[][]>{
	
	private final static CarritoCompraFK instance = new CarritoCompraFK();
	
	public static CarritoCompraFK getInstance() {
		return instance;
	}
	
	private CarritoCompraFK () {
		super(1);		
		this.put("carritoCompra", new String[][]{ 
					{"id_sucursal", "id_sucursal_socio"},
					{"id_socio", "id_socio"}}
		);
	}
}
