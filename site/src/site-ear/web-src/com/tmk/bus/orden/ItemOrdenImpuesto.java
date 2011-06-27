package com.tmk.bus.orden;

import com.tmk.bus.fk.ItemOrdenImpuestoFK;
import com.tmk.dbo.DBO;

public class ItemOrdenImpuesto extends DBO {

	private final static ItemOrdenImpuestoFK cls_fk = ItemOrdenImpuestoFK.getInstance();  
	
	private Integer id_orden;
	private Integer id_articulo;
	private Double  tasa_gral;
	private Double tasa_percep_video;
	private Double valor_percep_video;
	private Integer item;	
	
	public ItemOrdenImpuesto() {}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".item = ").append(item);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "ITEM_ORDEN_IMPUESTO";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "IOI";
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

	public Integer getId_orden() {
		return id_orden;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Double getTasa_gral() {
		return tasa_gral;
	}

	public Double getTasa_percep_video() {
		return tasa_percep_video;
	}

	public Double getValor_percep_video() {
		return valor_percep_video;
	}

	public Integer getItem() {
		return item;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public void setTasa_gral(Double tasa_gral) {
		this.tasa_gral = tasa_gral;
	}

	public void setTasa_percep_video(Double tasa_percep_video) {
		this.tasa_percep_video = tasa_percep_video;
	}

	public void setValor_percep_video(Double valor_percep_video) {
		this.valor_percep_video = valor_percep_video;
	}

	public void setItem(Integer item) {
		this.item = item;
	}
	
}
