package com.tmk.service.buscador;

public class Filtro {
	private String id;
	private String nombre;
	private String select;
	private String from;
	private String where;
	private String groupBy;
	private String selectIntermedio;
	private String selectInterno;
	private String orderBy;
	//private String prefijo;
	
	/**
	 * @param id
	 * @param nombre
	 * @param select
	 * @param from
	 * @param where
	 * @param groupBy
	 * @param selectIntermedio
	 * @param selectInterno
	 * @param orderBy
	 */
	public Filtro(String id, String nombre, String select, String from, String where, String groupBy, 
			String selectIntermedio, String selectInterno, String orderBy) {
		this.select = select;
		this.from = from;
		this.where = where;
		this.groupBy = groupBy;
		this.selectIntermedio = selectIntermedio; 
		this.selectInterno = selectInterno;
		this.nombre = nombre;
		this.orderBy = orderBy;
		//this.prefijo = prefijo;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSelect() {
		return select;
	}

	public String getFrom() {
		return from;
	}

	public String getWhere() {
		return where;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public String getSelectIntermedio() {
		return selectIntermedio;
	}
	
	public String getSelectInterno() {
		return selectInterno;
	}

	public String getOrderBy() {
		return orderBy;
	}
/*	
	public String getPrefijo() {
		return prefijo;
	}
	*/
	public String getId() {
		return this.id;
	}

}
