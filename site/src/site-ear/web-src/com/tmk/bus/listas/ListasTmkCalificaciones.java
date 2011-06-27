package com.tmk.bus.listas;

import java.sql.Timestamp;

import com.tmk.bus.fk.ListasTmkCalificacionesFK;
import com.tmk.dbo.DBO;

/**
 * @author oClopez
 *
 */
public class ListasTmkCalificaciones extends DBO {
	public static final ListasTmkCalificacionesFK  cls_fk = ListasTmkCalificacionesFK.getInstance();
	private Integer id_lista;
	private Integer calificacion;
	private Integer id_sucursal_socio_calif;
	private Integer id_socio_calif;
	private	Integer id_calificacion;	
	private	Timestamp f_calificacion;
		
	public ListasTmkCalificaciones(){

	}
	/*constructor */
	public ListasTmkCalificaciones(Integer idLista,Integer idComentario) {
		this.id_lista = idLista;
		this.id_calificacion = idComentario;
	}

	public static String getOrden() {
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_lista = ").append(id_lista);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_calificacion = ").append(id_calificacion);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}
	
	/**
	 * Metodos estaticos
	 */
	public static String getAlias() {
		return "LISTMKCAL";
	}

	public static String getTabla(){
		return "LISTAS_TMK_CALIFICACION";
	}

	public static String getFiltro() {
		return null;
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_lista",getAlias()+"__id_calificacion"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	public Integer getId_lista() {
		return id_lista;
	}	
	public void setId_lista(Integer id_lista) {
		this.id_lista = id_lista;
	}
	public Integer getId_calificacion() {
		return id_calificacion;
	}
	public Timestamp getF_calificacion() {
		return f_calificacion;
	}
	public void setId_calificacion(Integer id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public void setF_calificacion(Timestamp f_calificacion) {
		this.f_calificacion = f_calificacion;
	}
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	public Integer getId_sucursal_socio_calif() {
		return id_sucursal_socio_calif;
	}
	public Integer getId_socio_calif() {
		return id_socio_calif;
	}
	public void setId_sucursal_socio_calif(Integer id_sucursal_socio_calif) {
		this.id_sucursal_socio_calif = id_sucursal_socio_calif;
	}
	public void setId_socio_calif(Integer id_socio_calif) {
		this.id_socio_calif = id_socio_calif;
	}
	
	
}
