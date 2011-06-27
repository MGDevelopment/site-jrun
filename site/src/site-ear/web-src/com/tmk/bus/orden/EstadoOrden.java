package com.tmk.bus.orden;

import com.tmk.bus.fk.EstadoOrdenFK;
import com.tmk.dbo.DBO;

public class EstadoOrden extends DBO {
	private static final EstadoOrdenFK cls_fk = EstadoOrdenFK.getInstance();
	private String estado;
	private String descripcion;
	private String descripcion_extendida;
		
	public EstadoOrden() {
	
	}
	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "ESTADO_ORDEN";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "EO";
	}

	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__estado"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".estado = ").append(estado);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion_extendida() {
		return descripcion_extendida;
	}

	public void setDescripcion_extendida(String descripcion_extendida) {
		this.descripcion_extendida = descripcion_extendida;
	}


	
}
