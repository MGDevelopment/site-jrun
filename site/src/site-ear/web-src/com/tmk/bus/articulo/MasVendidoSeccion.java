package com.tmk.bus.articulo;

import com.tmk.bus.fk.MasVendidoSeccionFK;
import com.tmk.dbo.DBO;

public class MasVendidoSeccion extends DBO {
	private static final MasVendidoSeccionFK cls_fk = MasVendidoSeccionFK.getInstance();
	private Integer categoria_seccion;
	private Integer id_articulo;
	private Integer orden;

	public MasVendidoSeccion() {

	}

	public static String getOrden() {
		
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".categoria_seccion = '").append(categoria_seccion).append("'");
		return pk.toString();
	}

	public static String getTabla() {
		return "MAS_VENDIDOS_SECCION";
	}

	public boolean tieneDBO() {

		return false;
	}


	public static String getAlias() {
		return "MVS";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		return null;
	}

	public Integer getCategoria_seccion() {
		return categoria_seccion;
	}

	public void setCategoria_seccion(Integer categoria_seccion) {
		this.categoria_seccion = categoria_seccion;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	public Integer getMasVendidoOrden() {
		return this.orden;
	}
	
}
