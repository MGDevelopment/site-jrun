package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ListaDeseosFK extends HashMap {
	private static final ListaDeseosFK instance = new ListaDeseosFK();	

	public static ListaDeseosFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private ListaDeseosFK () {
		super(1);
		//fk para cuando un SocioDomicilios  esta dentro de un Socios2
		/*this.put("socioDomicilios", new String[][] {//padre			hijo
										new String[]{"id_socio", "id_socio"},
										new String[]{"id_sucursal", "id_sucursal"}
									}
		);*/
		//esta es paran cuando un SociosDomicilio esta dentro de un DireccionOrden
		this.put("domiciliosDeseo", new String[][] {//padre			hijo
				new String[]{"id_socio", "id_socio"},
				new String[]{"id_sucursal_socio", "id_sucursal"},
				new String[]{"tipo_domicilio", "tipo_domicilio"}
			}
		);
	}
}
