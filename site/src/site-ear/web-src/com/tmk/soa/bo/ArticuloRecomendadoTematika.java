package com.tmk.soa.bo;

import com.tmk.bus.fk.ArticuloMesaRecomendadoFK;
import com.tmk.dbo.DBO;

public class ArticuloRecomendadoTematika extends DBO {
	private static final ArticuloMesaRecomendadoFK cls_fk = ArticuloMesaRecomendadoFK.getInstance();
	private Integer id_articulo;
	private String agrupacion ;
	private String en_filtro;
	private String cls_titulo;
	private Integer se_muestra;
	private Integer posicion;
	private Integer categoria_seccion;
	
	public ArticuloRecomendadoTematika() {
		
	}
		
	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "articulos_mesa_recomendados";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "AMR";
	}

	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_articulo"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}	
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".agrupacion = '").append(agrupacion).append("'");
		pk.append(" and ");
		pk.append(getAlias()).append(".en_filtro = '").append(en_filtro).append("'");		
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}
	
	public String getAgrupacion() {
		return agrupacion;
	}

	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}

	public static ArticuloMesaRecomendadoFK getCls_fk() {
		return cls_fk;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getEn_filtro() {
		return en_filtro;
	}

	public void setEn_filtro(String en_filtro) {
		this.en_filtro = en_filtro;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Integer getSe_muestra() {
		return se_muestra;
	}

	public void setSe_muestra(Integer se_muestra) {
		this.se_muestra = se_muestra;
	}

	public Integer getCategoria_seccion() {
		return categoria_seccion;
	}

	public void setCategoria_seccion(Integer categoria_seccion) {
		this.categoria_seccion = categoria_seccion;
	}

	public String getCls_titulo() {
		return cls_titulo;
	}

	public void setCls_titulo(String cls_titulo) {
		this.cls_titulo = cls_titulo;
	}

	
}
