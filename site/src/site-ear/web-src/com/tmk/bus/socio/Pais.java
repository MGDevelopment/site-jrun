package com.tmk.bus.socio;

import com.tmk.bus.fk.PaisFK;
import com.tmk.dbo.DBO;

/**
 * @author oclopez
 */
public class Pais extends DBO {
	private static final PaisFK cls_fk = PaisFK.getInstance();
	private Integer id_pais;
	private String descripcion;
	private String gem_pais_codigo;
	private String gem_prov_codigo;
	private String gem_max_cui_codigo;
	private String habilitado_tematika;
	private Provincia[] provincia;
	
	public Pais() {	}
	public Pais(Integer idPais) {
		this.id_pais = idPais;
	}
	
	public Integer getIdPais() {
		return id_pais;
	}
	public void setIdPais(Integer idPais) {
		this.id_pais = idPais;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHabilitado_tematika() {
		return habilitado_tematika;
	}
	public void setHabilitado_tematika(String habilitado_tematika) {
		this.habilitado_tematika = habilitado_tematika;
	}
	
	public String getPK() {		
		StringBuffer pk = new StringBuffer();
		pk.append(getAlias()).append(".id_pais = ").append(id_pais);
		return pk.toString();
	}
	
	public boolean tieneDBO() {		
		return true;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "PAISES";
	}

	public static String getFiltro() {
		StringBuffer filtro = new StringBuffer();
		filtro.append(getAlias()).append(".habilitado_tematika(+)").append("='S'");
		return filtro.toString();
	}

	public static String getAlias() {
		return "PA";
	}

	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_pais"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}	
	public Provincia[] getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia[] provincia) {
		this.provincia = provincia;
	}
	public String getGemPaisCodigo() {
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
	public String getGemMaxCuiCodigo() {
		return gem_max_cui_codigo;
	}
	public void setGemMaxCuiCodigo(String gemMaxCuiCodigo) {
		this.gem_max_cui_codigo = gemMaxCuiCodigo;
	}
	
	

}
