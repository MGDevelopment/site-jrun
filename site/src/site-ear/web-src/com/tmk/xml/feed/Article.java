package com.tmk.xml.feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Article {
	private String id;
	private Date updated;
	private List links = new ArrayList();
	private List categories = new ArrayList();
	private Title ppg_title;
	private Hashtable author = new Hashtable();
	private List autores = new ArrayList();
	private String ppg_isbn;
	private String ppg_publisher;
	private String ppg_language;
	private Hashtable sinopsis = new Hashtable();
	private String ppg_description;
	private Double ppg_rating;

	public Article() {

	}

	public void setId (String id) {
		this.id = id;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public void addLink(Link link) {
		this.links.add(link);
	}

	public void addCategory(Category category) {
		this.categories.add(category);
	}

	public void setPpg_title(Title title) {
		this.ppg_title = title;
	}

	public void addAuthor(Integer idAutor, String author) {
		if (!this.author.containsKey(idAutor)) {
			this.author.put(idAutor, author);
			this.autores.clear();
			Enumeration en = this.author.keys();

			while (en.hasMoreElements()) {
				//this.autores.add(new Author((String)this.author.get(en.nextElement())));
				this.autores.add((String)this.author.get(en.nextElement()));
			}
		}
	}

	public void setPpg_isbn(String isbn) {
		this.ppg_isbn = isbn;
	}

	public void setPpg_publisher(String publisher) {
		this.ppg_publisher = publisher;
	}

	public void setPpg_language(String language) {
		this.ppg_language = language;
	}

	public void setPpg_description(String description) {
		this.ppg_description = description;
	}

	public void setSinopsis(Integer parte, String descripcion) {
		if (!this.sinopsis.containsKey(parte)) {
			this.sinopsis.put(parte, descripcion);
			this.ppg_description = "";
			for (int i=0; i<this.sinopsis.size(); i++) {
				this.ppg_description = this.ppg_description +
					this.sinopsis.get(new Integer(i+1));
			}
		}
	}

	public void setPpg_rating(Double rating) {
		this.ppg_rating = rating;
	}


}
