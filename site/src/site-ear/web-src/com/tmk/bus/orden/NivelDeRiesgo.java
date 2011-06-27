package com.tmk.bus.orden;

import com.tmk.bus.fk.NivelDeRiesgoFK;
import com.tmk.dbo.DBO;

public class NivelDeRiesgo extends DBO {
	private static final NivelDeRiesgoFK cls_fk = NivelDeRiesgoFK.getInstance();
	private Integer nivel_riesgo;
	private String descripcion;

	public NivelDeRiesgo(Integer nivelDeRiesgo) {
		this.nivel_riesgo = nivelDeRiesgo;
	}
	
	public NivelDeRiesgo() {}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer();
		pk.append(getAlias()+".nivel_riesgo = ").append(nivel_riesgo);
		return pk.toString();
	}
	
	public boolean tieneDBO() {
		return false;
	}

	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "NIVEL_DE_RIESGO";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "NIV_RIE";
	}
	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__nivel_riesgo"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}	
	
	//gets/sets
	public Integer getNivel_riesgo() {
		return nivel_riesgo;
	}
	public void setNivel_riesgo(Integer nivel_riesgo) {
		this.nivel_riesgo = nivel_riesgo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
