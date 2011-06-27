package com.tmk.xml.rss;

import java.sql.Timestamp;
import java.util.Date;

import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.Categoria;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.service.categoria.CategoriaService;

public class Item {
	private String title;
	private String link;
	private Date pubDate;
	private String category;
	private String guid;
	private String description;
	private String author;
	private String publisher;
	//para poder armar la url
	//private Categoria categoria;

	public Item (String title, String link, Date pubDate, String category,
			String guid, String description, String author, String publisher) {
		this.title = title;
		this.link = link;
		this.pubDate = pubDate;
		this.category = category;
		this.guid = guid;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
	}

	public Item (ArticuloClass articulo) {
		this.title = Convert.corregir(articulo.getTitulo(), true);
		this.link = "http://" + Globals.DOMINIO_SITIO + CategoriaService.getURL(articulo.getCategoria()) + ArticuloManager.getURL(articulo);
		this.pubDate = articulo.getFechaAlta();
		this.category = Convert.capitalizar(articulo.getGrupo(), false);
		this.guid = this.link;
		this.description = articulo.getSinopsis();
		if ("".equals(this.description)) {
			this.description = null;
		} else {
			this.description.replaceAll("<sinopsis>", "<sinopsis><![CDATA[");
			this.description.replaceAll("</sinopsis>", "]]></sinopsis>");
		}
		this.author = articulo.getStringDeAutores(" / ");
		if ("".equals(this.author)) {
			this.author = null;
		} else {
			this.author = "nodisponible@tematika.com " + "(" + this.author + ")";
		}
		this.publisher = Convert.capitalizar(articulo.getEditorial(), false);
		//this.categoria = articulo.getCategoria();
	}


	public Item () {
		//nada item vacio
	}

	public void setAlianzaTag (ArticuloClass articulo) {
		this.link = "http://" + Globals.DOMINIO_SITIO + CategoriaService.getURL(articulo.getCategoria()) + ArticuloManager.getURLAlianzaTag(articulo);
		this.guid = this.link;
	}
}
