package com.tmk.bus.fk;

import java.util.HashMap;

@SuppressWarnings("serial")
public class SocioDomiciliosFK extends HashMap {
	private static final SocioDomiciliosFK instance = new SocioDomiciliosFK();	

	public static SocioDomiciliosFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private SocioDomiciliosFK () {
		super(3);
		//fk para cuando un SocioDomicilios  esta dentro de un Socios2
		this.put("socioDomicilios", new String[][] {//padre			hijo
										new String[]{"id_socio", "id_socio"},
										new String[]{"id_sucursal", "id_sucursal"}
									}
		);
		//esta es paran cuando un SociosDomicilio esta dentro de un DireccionOrden
		this.put("domicilio_orden", new String[][] {//padre			hijo
				new String[]{"id_socio", "id_socio"},
				new String[]{"id_sucursal_socio", "id_sucursal"},
				new String[]{"tipo_domicilio", "tipo_domicilio"}
			}
		);
		//usado para la cuanto dentro de una lista de de deseo tengo un DomiciliosSocio
		this.put("domicilioDeseo", new String[][] {//padre			hijo
				new String[]{"id_socio", "id_socio"},
				new String[]{"id_sucursal_socio", "id_sucursal"},
				new String[]{"tipo_domicilio", "tipo_domicilio"}
			}
		);
	}
}
