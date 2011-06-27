package com.tmk.bus.socio;

import com.tmk.bus.fk.LocalidadFK;
import com.tmk.dbo.DBO;

/**
 * @author oclopez
 */
public class Localidad extends DBO {
	private static final LocalidadFK cls_fk = LocalidadFK.getInstance();
	private Integer id_pais;
	private Integer id_provincia;
	private Integer id_localidad;
	private String descripcion;
	private String gem_pais_codigo;
	private String gem_prov_codigo;
	private String gem_cui_codigo;
	private String habilitado_tematika;
	
	public Localidad() {	}
	public Localidad(Integer idPais,Integer idProvincia,Integer idLocalidad) {
		this.id_pais = idPais;
		this.id_provincia = idProvincia;
		this.id_localidad = idLocalidad;
	}
	
	
	
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public Integer getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}
	public Integer getId_localidad() {
		return id_localidad;
	}
	public void setId_localidad(Integer id_localidad) {
		this.id_localidad = id_localidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPK() {		
		StringBuffer pk = new StringBuffer();
		pk.append(getAlias()).append(".id_pais = ").append(id_pais);
		pk.append(" AND ");
		pk.append(getAlias()).append(".id_provincia = ").append(id_provincia);
		pk.append(" AND ");
		pk.append(getAlias()).append(".id_localidad = ").append(id_localidad);
		return pk.toString();
	}
	
	public boolean tieneDBO() {		
		return false;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "LOCALIDADES";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "LOC";
	}

	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_pais",getAlias()+"__id_provincia","id_localidad"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	public String getGem_pais_codigo() {
		return gem_pais_codigo;
	}
	public void setGemPaisCodigo(String gemPaisCodigo) {
		this.gem_pais_codigo = gemPaisCodigo;
	}
	public String getGemProvCodigo() {
		return gem_prov_codigo;
	}
	public void setGemProvCodigo(String gemProvCodigo) {
		this.gem_prov_codigo = gemProvCodigo;
	}
	public String getGemCuiCodigo() {
		return gem_cui_codigo;
	}
	public void setGemCuiCodigo(String gemCuiCodigo) {
		this.gem_cui_codigo = gemCuiCodigo;
	}
	public String getHabilitado_tematika() {
		return habilitado_tematika;
	}
	public void setHabilitado_tematika(String habilitado_tematika) {
		this.habilitado_tematika = habilitado_tematika;
	}

	
}
