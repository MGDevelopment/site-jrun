package com.tmk.bus.orden;

import com.tmk.bus.fk.NotaRegaloFK;
import com.tmk.dbo.DBO;

public class NotaRegalo extends DBO {

	private static final NotaRegaloFK cls_fk= NotaRegaloFK.getInstance();
	
	private Integer id_orden;
	private Integer id_articulo;
	private String nota_regalo;
	private Integer item;
	
	public NotaRegalo() {	}
	
	public NotaRegalo(Integer id_orden, Integer id_articulo, Integer item) {
		super();
		this.id_orden = id_orden;
		this.id_articulo = id_articulo;
		this.item = item;
	}

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
		return "NOTA_REGALO";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "NOTREG";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden",getAlias()+"__id_articulo",getAlias()+"__item"};
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

	public String getNota_regalo() {
		return nota_regalo;
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

	public void setNota_regalo(String nota_regalo) {
		this.nota_regalo = nota_regalo;
	}

	public void setItem(Integer item) {
		this.item = item;
	}
		
}
