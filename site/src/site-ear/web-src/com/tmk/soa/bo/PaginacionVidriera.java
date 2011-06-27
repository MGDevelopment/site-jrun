package com.tmk.soa.bo;

import java.sql.Timestamp;

public class PaginacionVidriera {

	private Integer idSeccion;
	private Timestamp fecha;
	private Timestamp fechaModi;
	private Integer totalAcumulado;
	
	public PaginacionVidriera() {
		
	}
	
	public PaginacionVidriera(Integer idSeccion,Timestamp fecha,Timestamp fechaModi,Integer totalAcumulado) {
		this.idSeccion = idSeccion;
		this.fecha = fecha;
		this.fechaModi = fecha;
		this.totalAcumulado = totalAcumulado;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaModi() {
		return fechaModi;
	}

	public void setFechaModi(Timestamp fechaModi) {
		this.fechaModi = fechaModi;
	}

	public Integer getTotalAcumulado() {
		return totalAcumulado;
	}

	public void setTotalAcumulado(Integer totalAcumulado) {
		this.totalAcumulado = totalAcumulado;
	}
	
	
	
}
