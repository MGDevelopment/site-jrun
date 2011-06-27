package com.tmk.bus.articulo;

import com.tmk.bus.fk.IndiceDeContenidoFK;
import com.tmk.dbo.DBO;

public class IndiceDeContenido extends DBO {
	private static final IndiceDeContenidoFK cls_fk = IndiceDeContenidoFK.getInstance();

	private Integer id_articulo;
	private String tipo;
	private String tipo_texto;
	private Integer parte;
	private String idioma;
	private String texto;

	public IndiceDeContenido() {

	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".tipo = '").append(tipo).append("'");
		pk.append(" and ");
		pk.append(getAlias()).append(".parte = ").append(parte);
		pk.append(" and ");
		pk.append(getAlias()).append(".idioma = '").append(idioma).append("'");
		return pk.toString();
	}

	public static String getTabla() {

		return "ARTICULOS_TEXTOS";
	}

	public static String getAlias() {
		return "IND";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	/*campos*/
	public Integer getIdArticulo() {
		return this.id_articulo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Integer getParte() {
		return this.parte;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public String getTexto() {
		return this.texto;
	}

	public String getTipoTexto() {
		return this.tipo_texto;
	}

	public static String getFiltro() {
		final StringBuffer filtro = new StringBuffer("");
		filtro.append(getAlias()).append(".tipo(+) = '").append("04").append("'");
		filtro.append(" and ");
		filtro.append(getAlias()).append(".idioma(+) = '").append("ES").append("'");
		//filtro.append(" and ");
		//filtro.append(getAlias()).append(".tipo_texto(+) = '").append("01").append("'");
		return filtro.toString();
	}

	public static String getOrden() {
		StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".parte");
		return orden.toString();
	}

	public boolean tieneDBO() {

		return false;
	}

}
