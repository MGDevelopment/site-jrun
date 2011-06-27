package com.tmk.bus.socio;

import java.sql.Timestamp;

import com.tmk.bus.fk.SociosIntegracionFK;
import com.tmk.dbo.DBO;

public class SocioIntegracion extends DBO {
	private static final SociosIntegracionFK cls_fk = SociosIntegracionFK.getInstance();
	private Integer id_socio;
	private Integer id_sucursal;
	private  String identificador;
	private  String dominio;
	private  Timestamp f_alta;
	private  String ursAlta;
	private  Timestamp f_modi;
	private  String usr_modi;	
	
	public SocioIntegracion() {
		//vacio para reflection
	}
	
	/*constructor */
	public SocioIntegracion(Integer id_socio, Integer id_sucursal,String identificador,String dominio )
	{
		this.id_socio = id_socio;
		this.id_sucursal = id_sucursal;
		this.identificador = identificador;
		this.dominio = dominio;
	}
		
	@Override
	public boolean tieneDBO() {
		return false;
	}

	@Override
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_sucursal=").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".dominio='").append(dominio).append("' ");
		return pk.toString();
	}

	public Integer getid_socio() {
		return id_socio;
	}

	public void setid_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public Integer getid_sucursal() {
		return id_sucursal;
	}

	public void setid_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Timestamp getf_alta() {
		return f_alta;
	}

	public void setf_alta(Timestamp aalta) {
		f_alta = aalta;
	}

	public String getUrsAlta() {
		return ursAlta;
	}

	public void setUrsAlta(String ursAlta) {
		this.ursAlta = ursAlta;
	}

	public Timestamp getf_modi() {
		return f_modi;
	}

	public void setf_modi(Timestamp modi) {
		f_modi = modi;
	}

	public String getusr_modi() {
		return usr_modi;
	}

	public void setusr_modi(String usr_modi) {
		this.usr_modi = usr_modi;
	}

	public static String getAlias() {
		return "SI";
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_socio",getAlias()+"__id_sucursal"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	
	public static String getTabla()
	{
		return "socios_integracion";
	}
	
	public static String getFiltro() {
		return null;
	}
	
	public static String getOrden() {
		return null;
	}

}
