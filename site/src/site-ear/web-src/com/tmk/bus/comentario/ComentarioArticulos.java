package com.tmk.bus.comentario;

import java.sql.Timestamp;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;

public class ComentarioArticulos extends DBO {
	private static final ComentarioArticuloFK cls_fk = ComentarioArticuloFK.getInstance();
	private Integer id_articulo;
	private Integer id_comentario;
	private String comentario;
	private Integer evaluacion;
	private Timestamp fecha;
	private String estado;
	private Integer id_sucursal_socio;
	private Integer id_socio;
	private String nickname;
	private Timestamp f_alta;
	private Timestamp f_modi;
	private Socios2 socio;
	private Articulo articulo;
	private String cls_userPopego;
		
	public ComentarioArticulos(){
		
	}
	
	public ComentarioArticulos(Integer id_articulo,Integer id_comentario){
		this.id_articulo = id_articulo;
		this.id_comentario = id_comentario;
	}
	
	/*metodos abstractos heredados*/
	public boolean tieneDBO() {
		return true;
	}
	
	public static String getOrden() {
		StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".fecha");
		return orden.toString();
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_articulo",getAlias()+"__id_comentario"};
	}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_comentario=").append(id_comentario);		
		return pk.toString();
	}

	public static String getAlias() {
		return "COMART";
	}
	public static String getTabla() {
		return "comentario_articulos";
	}
	/*set´s y get´s*/
	public Integer getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public Integer getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Integer id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_sucursal_socio() {
		return id_sucursal_socio;
	}

	public void setId_sucursal_socio(Integer id_sucursal_socio) {
		this.id_sucursal_socio = id_sucursal_socio;
	}

	public Integer getId_socio() {
		return id_socio;
	}

	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getF_alta() {
		return f_alta;
	}

	public void setF_alta(Timestamp f_alta) {
		this.f_alta = f_alta;
	}

	public Timestamp getF_modi() {
		return f_modi;
	}

	public void setF_modi(Timestamp f_modi) {
		this.f_modi = f_modi;
	}
	
	public static String getFiltro() {
		return null;
	}

	public Socios2 getSocio() {
		return socio;
	}

	public void setSocio(Socios2 socio) {
		this.socio = socio;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public String getCls_userPopego() {
		return cls_userPopego;
	}

	public void setCls_userPopego(String cls_userPopego) {
		this.cls_userPopego = cls_userPopego;
	}
	public static String [][]getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	
}
