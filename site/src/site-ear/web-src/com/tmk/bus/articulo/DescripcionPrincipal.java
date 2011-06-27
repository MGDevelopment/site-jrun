package com.tmk.bus.articulo;

import com.tmk.bus.fk.DescripcionPrincipalFK;
import com.tmk.dbo.DBO;

public class DescripcionPrincipal extends DBO {
	private static final DescripcionPrincipalFK cls_fk = DescripcionPrincipalFK.getInstance();

	private Integer id_articulo;
	private String tipo;
	private String tipo_texto;
	private Integer parte;
	private String idioma;
	private String texto;

	public DescripcionPrincipal() {
		
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

		//pk.append(" and ");
		//pk.append(getAlias()).append(".tipo_texto = '").append(tipo_texto).append("'");
		return pk.toString();
	}

	public static String getTabla() {
		return "ARTICULOS_TEXTOS";
	}

	public static String getAlias() {
		return "SINOP";
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
		//filtro.append(getAlias()).append(".tipo(+) = '").append("01").append("'");
		filtro.append("(");
		filtro.append(getAlias()).append(".tipo= ").append("'01'");
		filtro.append(" OR ");
		filtro.append(getAlias()).append(".tipo= ").append("'02'");//los diccionarios tien este si no no los trae
		filtro.append(" OR ");
		filtro.append(getAlias()).append(".tipo= ").append("'04'");//INDICE DE CONTENIDO
		filtro.append(" OR ");
		filtro.append(getAlias()).append(".tipo= ").append("'17'");//SOLAPA
		filtro.append(" OR ");
		filtro.append(getAlias()).append(".tipo= ").append("'18'");//CONTRATAPA
		filtro.append(" OR ");
		filtro.append(getAlias()).append(".tipo is null");
		filtro.append(")");
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
