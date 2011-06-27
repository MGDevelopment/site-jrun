package com.tmk.service.buscador;

import java.util.HashMap;

public class ItemFiltro {
	private String descripcion;
	private Integer cantidad;
	private HashMap<String, String> parametros = new HashMap<String, String>();

	public ItemFiltro(String descripcion, Integer cantidad) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void addParam(String clave, String valor) {
		this.parametros.put(clave, valor);
	}
	
	public HashMap<String, String> getParam() {
		return parametros;
	}
}
