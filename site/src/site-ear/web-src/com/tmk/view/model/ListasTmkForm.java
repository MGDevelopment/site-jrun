package com.tmk.view.model;

public class ListasTmkForm  {
	/*datos personales*/
	private Integer id_lista;
	private String titulo;
	private String descripcion;
	private String publica;
	private String categoria_seccion;
	
	public ListasTmkForm() {
		
	}

	public ListasTmkForm(String titulo, String descripcion, String publica) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.publica = publica;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getPublica() {
		return publica;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPublica(String publica) {
		this.publica = publica;
	}

	public String getCategoria_seccion() {
		return categoria_seccion;
	}

	public void setCategoria_seccion(String categoria_seccion) {
		this.categoria_seccion = categoria_seccion;
	}

	public Integer getId_lista() {
		return id_lista;
	}

	public void setId_lista(Integer id_lista) {
		this.id_lista = id_lista;
	}
	

}
