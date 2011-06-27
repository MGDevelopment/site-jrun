package com.tmk.bus.listas;

import java.sql.Timestamp;

import com.tmk.bus.fk.ListasTmkFK;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;

/**
 * @author oClopez
 *
 */
public class ListasTmk extends DBO {
	public static final ListasTmkFK  cls_fk = ListasTmkFK.getInstance();
	private Integer id_lista;
	private	String titulo;
	private	String descripcion;
	private	Integer categoria_seccion;	
	private	Timestamp f_creacion;
	private	Timestamp f_modificacion;
	private String estado;
	private String publico;
	//el id socio y sucursal no se usan para hacer select, estan para cuando 
	//se hace el insert.
	private Integer id_socio;
	private Integer id_sucursal_socio;
	private Socios2 socio;
	private SocioTMK socioTMK;
	private ListasTmkArticulos[]  listaTmkArticulos;
	private ListasTmkCalificaciones[] listasTmkCalificaciones;
	
	public ListasTmk(){

	}
	/*constructor */
	public ListasTmk(Integer idLista) {
		this.id_lista = idLista;		
	}

	public static String getOrden() {
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_lista = ").append(id_lista);		
		return pk.toString();
	}

	public boolean tieneDBO() {
		return true;
	}
	
	/**
	 * Metodos estaticos
	 */
	public static String getAlias() {
		return "LISTMK";
	}

	public static String getTabla(){
		return "LISTAS_TMK";
	}

	public static String getFiltro() {
		return null;
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_lista"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	public Integer getId_lista() {
		return id_lista;
	}
	public String getTitulo() {
		return titulo;
	}
	public Integer getCategoria_seccion() {
		return categoria_seccion;
	}
	public Timestamp getF_creacion() {
		return f_creacion;
	}
	public String getEstado() {
		return estado;
	}
	public String getPublico() {
		return publico;
	}
	public DBO getSocio() {
		if(this.socio != null) {
			return socio;
		}else {
			if(socioTMK!=null) {
				return socioTMK;
			}else{
				return null;
			}
		}
	}
	public void setId_lista(Integer id_lista) {
		this.id_lista = id_lista;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setCategoria_seccion(Integer categoria_seccion) {
		this.categoria_seccion = categoria_seccion;
	}
	public void setF_creacion(Timestamp f_creacion) {
		this.f_creacion = f_creacion;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	public void setSocio(Socios2 socio) {
		this.socio = socio;
	}
	public ListasTmkArticulos[] getListaTmkArticulos() {
		return listaTmkArticulos;
	}
	public void setListaTmkArticulos(ListasTmkArticulos[] listaTmkArticulos) {
		this.listaTmkArticulos = listaTmkArticulos;
	}
	public ListasTmkCalificaciones[] getListasTmkCalificaciones() {
		return listasTmkCalificaciones;
	}
	public void setListasTmkCalificaciones(
			ListasTmkCalificaciones[] listasTmkCalificaciones) {
		this.listasTmkCalificaciones = listasTmkCalificaciones;
	}
	public Timestamp getF_modificacion() {
		return f_modificacion;
	}
	public void setF_modificacion(Timestamp f_modificacion) {
		this.f_modificacion = f_modificacion;
	}
	public Integer getId_socio() {
		return id_socio;
	}
	public Integer getId_sucursal_socio() {
		return id_sucursal_socio;
	}
	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}
	public void setId_sucursal_socio(Integer id_sucursal_socio) {
		this.id_sucursal_socio = id_sucursal_socio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}
