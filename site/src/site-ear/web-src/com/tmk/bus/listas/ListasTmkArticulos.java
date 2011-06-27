package com.tmk.bus.listas;

import java.sql.Timestamp;

import com.tmk.bus.fk.ListasTmkArticulosFK;
import com.tmk.dbo.DBO;

/**
 * @author oClopez
 *
 */
public class ListasTmkArticulos extends DBO {
	public static final ListasTmkArticulosFK  cls_fk = ListasTmkArticulosFK.getInstance();
	private Integer id_lista;
	private	Integer id_articulo;
	private	String comentario;
	private	Timestamp f_agregado;
		
	public ListasTmkArticulos(){

	}
	/*constructor */
	public ListasTmkArticulos(Integer idLista) {
		this.id_lista = idLista;		
	}

	public ListasTmkArticulos(Integer idLista,Integer idArticulo){
		this.id_lista = idLista;
		this.id_articulo = idArticulo;
	}
	
	public static String getOrden() {
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_lista = ").append(id_lista);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}
	
	/**
	 * Metodos estaticos
	 */
	public static String getAlias() {
		return "LISTMKART";
	}

	public static String getTabla(){
		return "LISTAS_TMK_ARTICULOS";
	}

	public static String getFiltro() {
		return null;
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_lista",getAlias()+"__id_articulo"};
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
	public Integer getId_articulo() {
		return id_articulo;
	}
	public Timestamp getF_agregado() {
		return f_agregado;
	}
	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}
	public void setF_agregado(Timestamp f_agregado) {
		this.f_agregado = f_agregado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
