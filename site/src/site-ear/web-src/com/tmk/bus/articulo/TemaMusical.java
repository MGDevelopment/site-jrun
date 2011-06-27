package com.tmk.bus.articulo;

import com.tmk.bus.fk.TemaMusicalFK;
import com.tmk.dbo.DBO;

public class TemaMusical extends DBO {

	private static final TemaMusicalFK cls_fk = TemaMusicalFK.getInstance();

	private Integer id_articulo;
	private Integer nro_tema;
	private String nombre;
	private String usr_alta;
	
	public TemaMusical() {
		
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".nro_tema = '").append(nro_tema).append("'");
		return pk.toString();
		
	}

	public static String getTabla() {
		
		return "ARTICULOS_TEMAS_MUSICALES";
	}

	public static String getAlias() {
		return "TMUS";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	/*campos*/
	public Integer getIdArticulo() {
		return this.id_articulo;
	}

	public Integer getNroTema() {
		return this.nro_tema;
	}

	public String getNombre() {
		return this.nombre;
	}

	public static String getFiltro() {
		return null;
	}

	public static String getOrden() {
		StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".nro_tema");
		return orden.toString();
	}

	public boolean tieneDBO() {		
		return false;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_articulo",getAlias()+"__nro_tema"};
	}

	public Integer getNro_tema() {
		return nro_tema;
	}

	public void setNro_tema(Integer nro_tema) {
		this.nro_tema = nro_tema;
	}

	public String getUsr_alta() {
		return usr_alta;
	}

	public void setUsr_alta(String usr_alta) {
		this.usr_alta = usr_alta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	
}
