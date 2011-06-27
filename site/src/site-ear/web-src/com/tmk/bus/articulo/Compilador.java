package com.tmk.bus.articulo;

import com.tmk.bus.fk.CompiladorFK;
import com.tmk.dbo.DBO;

public class Compilador extends DBO {

	private static final CompiladorFK cls_fk =  CompiladorFK.getInstance();

	private Integer id_autor;
	private String descripcion;

	public Compilador() {
	}

	public static String getAlias() {
		return "co";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		return null;
	}

	public static String getOrden() {
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_autor = ").append(id_autor);
		return pk.toString();
	}

	/*gets sets*/
	public static String getTabla() {
		return "AUTORES";
	}

	public String getDescripcion() {
		return descripcion;
	}


	public Integer getId_autor() {
		return id_autor;
	}

	public boolean tieneDBO() {
		return false;
	}


}
