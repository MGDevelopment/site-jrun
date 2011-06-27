package com.tmk.bus.articulo;
import com.tmk.bus.fk.ArticuloAutorBiografiaFK;
import com.tmk.dbo.DBO;

public class ArticuloAutorBiografia extends DBO {
	private static final ArticuloAutorBiografiaFK cls_fk = ArticuloAutorBiografiaFK.getInstance();
	private Integer id_articulo;
	private Integer id_autor;
	private String texto;
	private String role;
	private Integer parte;

	public ArticuloAutorBiografia() {
	}

	public static String getAlias() {
		return "AutBio";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		return null;
	}

	public static String getOrden() {
		StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".parte");
		return orden.toString();
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_autor = ").append(id_autor);
		pk.append(" and ");
		pk.append(getAlias()).append(".parte = ").append(parte);
		pk.append(" and ");
		pk.append(getAlias()).append(".role = ").append(role);
		return pk.toString();
	}

	public static String getTabla() {
		return "articulos_autores_biografia";
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Integer getId_autor() {
		return id_autor;
	}

	public String getTexto() {
		return texto;
	}

	public Integer getParte() {
		return parte;
	}

	public String getRole() {
		return role;
	}

	public boolean tieneDBO() {
		return false;
	}




}
