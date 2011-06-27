package com.tmk.xml.orden;

import com.tmk.kernel.MedioDeCobroDAO;

public class OrdenWrapper {
	private Integer id_orden;
	private MedioDeCobroDAO medioDeCobro;
	private String fecha;
	private String total;
	private String codigoCupon;
	private String estado;
	
	public OrdenWrapper() {
		
	}
	
	public void setIdOrden(Integer idOrden) {
		this.id_orden = idOrden;
	}
	
	public void setMedioDeCobro(MedioDeCobroDAO medioDeCobro) {
		this.medioDeCobro = medioDeCobro;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Integer getIdOrden() {
		return this.id_orden;
	}
	
	public MedioDeCobroDAO getMedioDeCobro() {
		return this.medioDeCobro;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public String getTotal() {
		return this.total;
	}
	
	public String getCodigoCupon() {
		return this.codigoCupon;
	}
	
	public String getEstado() {
		return this.estado;
	}
}

