package com.tmk.bus.articulo;
import com.tmk.bus.fk.ArticuloCompiladorFK;
import com.tmk.dbo.DBO;

public class ArticuloCompilador extends DBO {
	private static final ArticuloCompiladorFK cls_fk = ArticuloCompiladorFK.getInstance();
	private Integer id_articulo;
	private Integer id_autor;
	private String role;
	private Compilador compilador;

	public ArticuloCompilador() {
	}

	public static String getAlias() {
		return "ArtCo";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		final StringBuffer filtro = new StringBuffer("");
		filtro.append(getAlias()).append(".role(+) = 'C01'");
		return filtro.toString();
	}
	public static String getOrden() {
		return null;
	}
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_autor = ").append(id_autor);
		return pk.toString();
	}
	public static String getTabla() {
		return "articulos_autores";
	}

	public Compilador getAutor() {
		return compilador;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Integer getId_autor() {
		return id_autor;
	}

	public String getRole() {
		return role;
	}

	public boolean tieneDBO() {
		return true;
	}

}
