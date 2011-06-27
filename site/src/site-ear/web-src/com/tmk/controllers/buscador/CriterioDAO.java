/**
 * $Log: CriterioDAO.java,v $
 * Revision 1.3  2007/07/11 15:00:52  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.2  2005/09/15 19:19:28  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2004/02/11 19:34:31  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.controllers.buscador;

public class CriterioDAO {

	private Integer clave;
	private String descripcion;
	private String columna;
	private boolean ascendente;
	private boolean mejorarTitulo;
    private String addSelect;
	private String addFrom;
	private String addWhere;
	private String addFromJoin;

	public CriterioDAO(Integer clave, String descripcion, String columna, boolean ascendente, boolean mejorarTitulo) {
		this.clave = clave;
		this.descripcion= descripcion;
		this.columna = columna;
		this.ascendente = ascendente;
		this.mejorarTitulo = mejorarTitulo;
	}

	public CriterioDAO(Integer clave, String descripcion, String columna, boolean ascendente, boolean mejorarTitulo, String addSelect, String addFrom, String addWhere, String addFromJoin) {
		this (clave, descripcion, columna, ascendente, mejorarTitulo);
		this.addSelect = addSelect;
		this.addFrom = addFrom;
		this.addWhere = addWhere;
		this.addFromJoin = addFromJoin;
		
	}

	public CriterioDAO(Integer clave) {
		for (int i=0; i<BuscadorHelper.criterios.length; i++) {
			if (BuscadorHelper.criterios[i].clave.equals(clave)) {
				this.clave = BuscadorHelper.criterios[i].clave;
				this.descripcion = BuscadorHelper.criterios[i].descripcion;
                this.columna = BuscadorHelper.criterios[i].columna;
				this.ascendente = BuscadorHelper.criterios[i].ascendente;
				this.mejorarTitulo = BuscadorHelper.criterios[i].mejorarTitulo;
				this.addSelect = BuscadorHelper.criterios[i].addSelect;
				this.addFrom = BuscadorHelper.criterios[i].addFrom;
				this.addWhere = BuscadorHelper.criterios[i].addWhere;
				this.addFromJoin = BuscadorHelper.criterios[i].addFromJoin;
			}

		}
	}


	public Integer getClave() {
		return clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getColumna() {
		return columna;
	}

	public boolean getAscendente() {
		return ascendente;
	}

	public boolean mejorarTitulo() {
		return mejorarTitulo;
	}

	public String getTextoQuery() {
		return " order by " + columna + (ascendente ? " asc " : " desc ");
	}

	public String getAddSelect(){
		return (addSelect == null)? "": addSelect;
	}

	public String getAddFrom(){
		return (addFrom == null)? "": addFrom;
	}

	public String getAddFromJoin(){
		return (addFromJoin == null)? "": addFromJoin;
	}
	
	public String getAddWhere(){
		return (addWhere == null)? "": addWhere;
	}

	public boolean equals(Object object) {
		return (object instanceof CriterioDAO) && (clave.equals(((CriterioDAO)object).getClave()));
	}

	public String toString() {
		return new StringBuffer("Criterio: ").append(descripcion).toString();
	}
}
