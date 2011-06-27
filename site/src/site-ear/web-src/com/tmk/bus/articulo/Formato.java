package com.tmk.bus.articulo;

import com.tmk.bus.fk.FormatoFK;
import com.tmk.dbo.DBO;

public class Formato extends DBO {
	private static final FormatoFK cls_fk = FormatoFK.getInstance();
	String rv_meaning;

	public static String getFiltro() {
		final StringBuffer filtro = new StringBuffer("");
		filtro.append(getAlias()).append(".rv_domain(+) = '").append("ONIX:ProductForm").append("'");
		return filtro.toString();
	}

	public static String getOrden() {

		return null;
	}

	public String getPK() {
		return null;
	}

	public static String getTabla() {
		return "cg_ref_codes";
	}

	public static String getAlias() {
		return "fo";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public boolean tieneDBO() {
		return false;
	}

	public String getRv_meaning() {
		return rv_meaning;
	}

	public void setRv_meaning(String rv_meaning) {
		this.rv_meaning = rv_meaning;
	}



}
