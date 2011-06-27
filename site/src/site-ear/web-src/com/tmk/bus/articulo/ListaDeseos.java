package com.tmk.bus.articulo;

import com.tmk.bus.fk.ListaDeseosFK;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.dbo.DBO;
import com.tmk.src.listadeseos.ListaDeseosPK;

public class ListaDeseos extends DBO {

	private static final ListaDeseosFK cls_fk = ListaDeseosFK.getInstance();
	
	private Integer id_sucursal_socio;
	private Integer id_socio;
	private String tipo_domicilio;
	private String nombres;
	private String apellidos;
	private Integer cumpl_dia;
	private Integer cumpl_mes;
	private String palabras_claves;
	private Integer publica;
	
	//DBO
	private SocioDomicilios domicilioDeseo;
	
	public ListaDeseos() {
		
	}
	
	public ListaDeseos(ListaDeseosPK pk) {
		this.id_socio = pk.ID_SOCIO;
		this.id_sucursal_socio = pk.ID_SUCURSAL_SOCIO;		
	}
	
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal_socio = ").append(id_sucursal_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		return pk.toString();
	}	

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_sucursal_socio",
							getAlias()+"__id_socio"};
	}
	
	public static String getAlias() {
		return "LIDE";
	}
	
	public static String getTabla() {
		return "LISTA_DESEOS";
	}

	public boolean tieneDBO() {
		return true;
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	
	public static String getOrden() {
		return null;
	}

	public static String getFiltro() {
		return null;
	}
	
	public Integer getId_sucursal_socio() {
		return id_sucursal_socio;
	}

	public Integer getId_socio() {
		return id_socio;
	}

	public String getTipo_domicilio() {
		return tipo_domicilio;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Integer getCumpl_dia() {
		return cumpl_dia;
	}

	public Integer getCumpl_mes() {
		return cumpl_mes;
	}

	public String getPalabras_claves() {
		return palabras_claves;
	}

	public Integer getPublica() {
		return publica;
	}

	public void setId_sucursal_socio(Integer id_sucursal_socio) {
		this.id_sucursal_socio = id_sucursal_socio;
	}

	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public void setTipo_domicilio(String tipo_domicilio) {
		this.tipo_domicilio = tipo_domicilio;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCumpl_dia(Integer cumpl_dia) {
		this.cumpl_dia = cumpl_dia;
	}

	public void setCumple_mes(Integer cumpl_mes) {
		this.cumpl_mes = cumpl_mes;
	}

	public void setPalabras_claves(String palabras_claves) {
		this.palabras_claves = palabras_claves;
	}

	public void setPublica(Integer publica) {
		this.publica = publica;
	}

	public SocioDomicilios getDomicilioDeseo() {
		return domicilioDeseo;
	}

	public void setDomicilioDeseo(SocioDomicilios domicilioDeseo) {
		this.domicilioDeseo = domicilioDeseo;
	}	
	
	
	
}
