package com.tmk.soa.bo;

public class BuscadorBO {

	private String criterioDeOrden; 
	private Integer resultadosPorPagina;
	private boolean pedidoEspecial;
	private Integer idGrupo;
	private Integer idfamilia;
	private Integer idSubfamilia;
	private Integer paginaActual;
	private Integer idSeccionPropia;
	private String optSeleccionada;
	private String texto;
	private String claveDeBusqueda;
	private Integer idSeccion;
	public BuscadorBO() {
		// TODO Auto-generated constructor stub
	}

	public String getCriterioDeOrden() {
		return criterioDeOrden;
	}

	public Integer getResultadosPorPagina() {
		return resultadosPorPagina;
	}

	public boolean isPedidoEspecial() {
		return pedidoEspecial;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public Integer getIdFamilia() {
		return idfamilia;
	}

	public Integer getIdSubFamilia() {
		return idSubfamilia;
	}

	public Integer getPaginaActual() {
		return paginaActual;
	}

	public void setCriterioDeOrden(String criterioDeOrden) {
		this.criterioDeOrden = criterioDeOrden;
	}

	public void setResultadosPorPagina(Integer resultadosPorPagina) {
		this.resultadosPorPagina = resultadosPorPagina;
	}

	public void setPedidoEspecial(boolean pedidoEspecial) {
		this.pedidoEspecial = pedidoEspecial;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public void setIdFamilia(Integer idfamilia) {
		this.idfamilia = idfamilia;
	}

	public void setIdSubFamilia(Integer idSubfamilia) {
		this.idSubfamilia = idSubfamilia;
	}

	public void setPaginaActual(Integer paginaActual) {
		this.paginaActual = paginaActual;
	}

	public Integer getIdSeccionPropia() {
		return idSeccionPropia;
	}

	public String getOptSeleccionada() {
		return optSeleccionada;
	}

	public String getTexto() {
		return texto;
	}

	public String getClaveDeBusqueda() {
		return claveDeBusqueda;
	}

	public void setIdSeccionPropia(Integer idSeccionPropia) {
		this.idSeccionPropia = idSeccionPropia;
	}

	public void setOptSeleccionada(String optSeleccionada) {
		this.optSeleccionada = optSeleccionada;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setClaveDeBusqueda(String claveDeBusqueda) {
		this.claveDeBusqueda = claveDeBusqueda;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	
}
