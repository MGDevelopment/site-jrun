package com.tmk.bus.orden;

import com.tmk.bus.fk.AlianzaSeccionFK;
import com.tmk.dbo.DBO;

public class AlianzaSeccion extends DBO {
	private static final AlianzaSeccionFK cls_fk = AlianzaSeccionFK.getInstance();
	
	private Integer id_seccion;
	private Integer id_alianza;
	private String seccion_nombre;
		
	public AlianzaSeccion() {	}
	
	public AlianzaSeccion(Integer idSeccion,Integer idAlianza) {
		this.id_alianza = idAlianza;
		this.id_seccion = idSeccion;
	}

	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_seccion = ").append(id_seccion);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_alianza = ").append(id_alianza);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "ALIANZA_SECCION";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "ALSEC";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_seccion",getAlias()+"__id_alianza",};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}	
	//FIN ESTATICOS

	public Integer getId_seccion() {
		return id_seccion;
	}

	public Integer getId_alianza() {
		return id_alianza;
	}

	public String getSeccion_nombre() {
		return seccion_nombre;
	}

	public void setId_seccion(Integer id_seccion) {
		this.id_seccion = id_seccion;
	}

	public void setId_alianza(Integer id_alianza) {
		this.id_alianza = id_alianza;
	}

	public void setSeccion_nombre(String seccion_nombre) {
		this.seccion_nombre = seccion_nombre;
	}
	
}
