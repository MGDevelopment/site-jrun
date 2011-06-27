package com.tmk.bus.articulo;
import com.tmk.bus.fk.ArticuloAutorFK;
import com.tmk.dbo.DBO;

public class ArticuloAutor extends DBO {
	private static final ArticuloAutorFK cls_fk = ArticuloAutorFK.getInstance();
	private Integer id_articulo;
	private Integer id_autor;
	private String role;
	private Autor autor;
	private ArticuloAutorBiografia[] biografia;

	public ArticuloAutor() {
	}

	public static String getAlias() {
		return "ArtAu";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		/*final StringBuffer filtro = new StringBuffer("");
		filtro.append("(");
		filtro.append(getAlias()).append(".role = 'A01'");
		filtro.append(" OR ").append(getAlias()).append(".role = 'D02'");
		filtro.append(" OR ").append(getAlias()).append(".role = 'E01'");
		filtro.append(" OR ").append(getAlias()).append(".role = 'B01'");
		filtro.append(" OR ").append(getAlias()).append(".role is null");
		filtro.append(")");
		return filtro.toString();*/
		return null;
	}
	public static String getOrden() {
		StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".id_autor");
		return orden.toString();
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

	public Autor getAutor() {
		return autor;
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

	public ArticuloAutorBiografia[] getBiografia() {
		return biografia;
	}

	public boolean tieneDBO() {
		return true;
	}

}
