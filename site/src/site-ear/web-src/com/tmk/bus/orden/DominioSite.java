package com.tmk.bus.orden;

import java.sql.Timestamp;

import com.tmk.bus.fk.DominioSiteFK;
import com.tmk.dbo.DBO;

public class DominioSite extends DBO {
	private static final DominioSiteFK cls_fk = DominioSiteFK.getInstance(); 
		
	private Integer id_dominio;
	private String domiinio;
	private Timestamp f_alta;
	private Timestamp f_modi;
	
	public DominioSite() {		
	}
	
	public DominioSite(Integer id_dominio) {
		this.id_dominio = id_dominio;
	}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_dominio = ").append(id_dominio);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "DOMINIO_SITE";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "DOMSITE";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	//FIN ESTATICOS

	public Integer getId_dominio() {
		return id_dominio;
	}

	public String getDomiinio() {
		return domiinio;
	}

	public Timestamp getF_alta() {
		return f_alta;
	}

	public Timestamp getF_modi() {
		return f_modi;
	}

	public void setId_dominio(Integer id_dominio) {
		this.id_dominio = id_dominio;
	}

	public void setDomiinio(String domiinio) {
		this.domiinio = domiinio;
	}

	public void setF_alta(Timestamp f_alta) {
		this.f_alta = f_alta;
	}

	public void setF_modi(Timestamp f_modi) {
		this.f_modi = f_modi;
	}
	
	
}
