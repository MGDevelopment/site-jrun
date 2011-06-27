package com.tmk.bus.orden;

import com.tmk.bus.fk.EstadoItemOrdenFK;
import com.tmk.dbo.DBO;

public class EstadoItemOrden extends DBO {
	private static final EstadoItemOrdenFK cls_fk = EstadoItemOrdenFK.getInstance();
	private String estado;
	private String descripcion;
				
	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "ESTADO_ITEM_ORDEN";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "EIO";
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

	
}
