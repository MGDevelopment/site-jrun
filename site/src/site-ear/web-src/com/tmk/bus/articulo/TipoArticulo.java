package com.tmk.bus.articulo;

import com.tmk.bus.fk.TipoArticuloFK;
import com.tmk.dbo.DBO;

public class TipoArticulo extends DBO {
	private static final TipoArticuloFK cls_fk = TipoArticuloFK.getInstance();

	private String id_tipo_articulo;
	private String descripcion;

	public static String getFiltro() {
		
		return null;
	}

	public static String getOrden() {
		
		return null;
	}

	public String getPK() {
		
		return null;
	}

	public static String getTabla() {
		
		return "tipos_articulos";
	}

	public static String getAlias() {
		return "tar";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public boolean tieneDBO() {
		
		return false;
	}

	public static TipoArticuloFK getCls_fk() {
		return cls_fk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getId_tipo_articulo() {
		return id_tipo_articulo;
	}


}
