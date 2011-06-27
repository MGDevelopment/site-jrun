package com.tmk.xml.dm.ipn;

public class Operacion {
	private Integer tipo;
	private String id;
	
	public Integer getTipo() {
		return this.tipo;
	}
	
	public String getId() {
		return this.id;
	}
	
	public boolean esNotificacionDeCambioDeEstado() {
		return new Integer (1).equals(this.tipo);
	}
}
