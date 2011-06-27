package com.tmk.bus.regla;

import java.sql.Timestamp;



public class ReglaClass {
	
	private Integer secuencia;
	private Integer id_articulo;
	private Integer id_disponibilidad;
	private String estado;
	private String descripcion;
	private Timestamp fecha_desde;
	private Timestamp fecha_hasta;
	
	//constructores
	public ReglaClass(Integer idArticulo) {
		this.id_articulo = idArticulo;
	}
	
	
	
	//seters
	public void setIdArticulo(Integer idArticulo) {
		this.id_articulo = idArticulo;
	}
	
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	
	public void setIdDisponibilidad(Integer idDisponibilidad) {
		this.id_disponibilidad = idDisponibilidad;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setDesde(Timestamp desde) {
		this.fecha_desde = desde;
	}

	public void setHasta(Timestamp hasta) {
		this.fecha_hasta = hasta;
	}
	
	
	//geters
	
	public Integer getIdArticulo() {
		return this.id_articulo;
	}
	
	public Integer getSecuencia() {
		return this.secuencia;
	}
	
	public Integer getIdDisponibilidad() {
		return this.id_disponibilidad;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Timestamp getDesde() {
		return this.fecha_desde;
	}

	public Timestamp getHasta() {
		return this.fecha_hasta;
	}
	
	
}