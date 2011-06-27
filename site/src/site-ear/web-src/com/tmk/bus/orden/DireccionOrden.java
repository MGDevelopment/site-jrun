package com.tmk.bus.orden;

import com.tmk.bus.fk.DireccionOrdenFK;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.dbo.DBO;

public class DireccionOrden extends DBO {
	public final static DireccionOrdenFK cls_fk = DireccionOrdenFK.getInstance();  
	
	private	Integer id_orden;
	private	Integer id_sucursal_socio;
	private	Integer id_socio;
	private	String  tipo_domicilio;
	
	private SocioDomicilios domicilio_orden;
	private Orden orden;

	public DireccionOrden() {
		
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_sucursal_socio = ").append(id_sucursal_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".tipo_domicilio = ").append(tipo_domicilio);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return true;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "DIRECCION_ORDEN";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "DIOR";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden",getAlias()+"__id_sucursal_socio",getAlias()+"__id_socio",getAlias()+"__tipo_domicilio"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public Integer getId_orden() {
		return id_orden;
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

	public SocioDomicilios getDomicilioOrden() {
		return domicilio_orden;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
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

	public void setDomicilioOrden(SocioDomicilios domicilio) {
		this.domicilio_orden = domicilio;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public Orden getDirOrden() {
		return this.orden;
	}
	
}
