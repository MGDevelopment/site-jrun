package com.tmk.bus.articulo;

import com.tmk.bus.fk.DisponibilidadFK;
import com.tmk.dbo.DBO;

public class Disponibilidad extends DBO {
	private static final DisponibilidadFK cls_fk = DisponibilidadFK.getInstance();
	private Integer id_disponibilidad;
	private String descripcion;
	private String id_esquema;
	private String pedido_especial;

	public Disponibilidad() {

	}

	public String getPedido_especial() {
		return pedido_especial;
	}

	public void setPedido_especial(String pedido_especial) {
		this.pedido_especial = pedido_especial;
	}

	public Disponibilidad(Integer id_disponibilidad, String id_esquema) {
		this.id_disponibilidad = id_disponibilidad;
		this.id_esquema = id_esquema;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_disponibilidad = ").append(id_disponibilidad);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_esquema = '").append(id_esquema).append("'");
		return pk.toString();
	}

	public static String getTabla() {
		return "DISPONIBILIDADES";
	}

	public Integer getIdDisponibilidad(){
		return this.id_disponibilidad;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public String getIdEsquema(){
		return this.id_esquema;
	}

	public static String getFiltro() {
		final StringBuffer filtro = new StringBuffer("");
		filtro.append(getAlias()).append(".id_esquema(+) = '").append("PROD").append("'");
		return filtro.toString();
	}

	public static String getAlias() {
		return "DISP";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getOrden() {
		return null;
	}

	public boolean tieneDBO() {
		return false;
	}

	public boolean tieneStock() {
		return "N".equals(this.pedido_especial);
	}
}
