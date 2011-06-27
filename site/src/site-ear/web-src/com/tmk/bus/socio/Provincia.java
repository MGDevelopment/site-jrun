package com.tmk.bus.socio;

import com.tmk.bus.fk.ProvinciaFK;
import com.tmk.dbo.DBO;

/**
 * @author oclopez
 */
public class Provincia extends DBO {
	private static final ProvinciaFK cls_fk = ProvinciaFK.getInstance();
	private Integer id_pais;
	private Integer id_provincia;
	private String descripcion;
	private Localidad[] localidad;
	
	
	public Provincia() {	}
	public Provincia(Integer idPais,Integer idProvincia) {
		this.id_pais = idPais;
		this.id_provincia = idProvincia;
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
	public void setLocalidad(Localidad[] localidad) {
		this.localidad = localidad;
	}	
	
	public String getPK() {		
		StringBuffer pk = new StringBuffer();
		pk.append(getAlias()).append(".id_pais = ").append(id_pais);
		pk.append(" AND ");
		pk.append(getAlias()).append(".id_provincia = ").append(id_provincia);
		return pk.toString();
	}
	public boolean tieneDBO() {		
		return false;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "PROVINCIAS";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "PROV";
	}

	public static String getOrden() {
		return null;
	}
	
	public Localidad[] getLocalidad() {
		return localidad;
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_pais",getAlias()+"__id_provincia"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
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

}
