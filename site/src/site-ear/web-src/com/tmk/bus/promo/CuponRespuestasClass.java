package com.tmk.bus.promo;

public class CuponRespuestasClass {
	private Integer id_orden;
	private Integer cantidad_cupones;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	
	public void setIDOrden (Integer idOrden) {
		this.id_orden = idOrden;
	}
	
	public void setCantidadCupones (Integer cantidadCupones) {
		this.cantidad_cupones = cantidadCupones;
	}
	
	public void setRespuesta1 (String respuesta1) {
		this.respuesta1 = respuesta1;
	}
	
	public void setRespuesta2 (String respuesta2) {
		this.respuesta2 = respuesta2;
	}
	
	public void setRespuesta3 (String respuesta3) {
		this.respuesta3 = respuesta3;
	}
	
	public Integer getIDOrden() {
		return this.id_orden;
	}
	
	public Integer getCantidadCupones() {
		return this.cantidad_cupones;
	}
	
	public String getRepuesta1() {
		return this.respuesta1;
	}
	
	public String getRepuesta2() {
		return this.respuesta2;
	}
	
	public String getRepuesta3() {
		return this.respuesta3;
	}
}
