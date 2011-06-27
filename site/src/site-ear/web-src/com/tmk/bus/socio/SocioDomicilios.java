package com.tmk.bus.socio;

import java.sql.Connection;

import com.tmk.bus.fk.SocioDomiciliosFK;
import com.tmk.dbo.DBO;

/**
 * @author oClopez
 */
public class SocioDomicilios extends DBO {
	private static final SocioDomiciliosFK cls_fk = SocioDomiciliosFK.getInstance();
	private Integer id_sucursal;
	private Integer id_socio;	
	private String tipo_domicilio;
	private String calle;
	private Integer numero;
	private String edificio;
	private Integer piso;
	private String depto;
	private String cp;//codigo posta
	private String descripcion_provincia_inex;
	private String descripcion_localidad_inex;
	
	
	//DBO
	private Pais pais;	
	private Provincia provincia;
	private Localidad localidad;
	/**
	 * @see permite obtener por pk.
	 * @param id_sucursal
	 * @param id_socio
	 * @param tipo_sucursal
	 */
	public SocioDomicilios(Integer id_sucursal,Integer id_socio,String tipo_domicilio) {
		this.id_socio = id_socio;
		this.id_sucursal = id_sucursal;
		this.tipo_domicilio = tipo_domicilio;
	}
	
	//necesario para reflection
	public SocioDomicilios() {	}
	
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal = ").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".tipo_domicilio = ").append(tipo_domicilio);
		return pk.toString();
	}

	/*sobreescribo los metodos para no hacer nada y no afectar la db por equivocacion*/
	public void insert(Connection conn) throws Exception {}
	public void update(Connection conn) throws Exception {}
	public void delete(Connection conn) throws Exception {}
	
	//GET´S
	public String getTipo_domicilio() {
		return tipo_domicilio;
	}
	public String getCalle() {
		return calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public String getEdificio() {
		return edificio;
	}
	public Integer getPiso() {
		return piso;
	}
	public String getDepto() {
		return depto;
	}
	public String getCp() {
		return cp;
	}	
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public Integer getId_socio() {
		return id_socio;
	}
	public Pais getPais() {
		return pais;
	}
	public String getDescripcion_provincia_inex() {
		return descripcion_provincia_inex;
	}
	public String getDescripcion_localidad_inex() {
		return descripcion_localidad_inex;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	//GET'S	
	
	

	public void setTipo_domicilio(String tipo_domicilio) {
		this.tipo_domicilio = tipo_domicilio;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public void setDescripcion_provincia_inex(String descripcion_provincia_inex) {
		this.descripcion_provincia_inex = descripcion_provincia_inex;
	}

	public void setDescripcion_localidad_inex(String descripcion_localidad_inex) {
		this.descripcion_localidad_inex = descripcion_localidad_inex;
	}	
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "SOCIOS_DOMICILIOS";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "SOCDOM";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_socio",getAlias()+"__id_sucursal",getAlias()+"__tipo_domicilio"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	public boolean tieneDBO() {
		return true;
	}	
	
	//metodo utiles de la clase vieja DomicilioDAO
	/**
	 * Dtermina si es domicilio es de envio que tipo_domicilio empiece con "EN"
	 */
	public boolean esEnvio() {
		return esEnvio(this.tipo_domicilio);
	}
	public static boolean esEnvio(String tipoDomcilio) {
		return (tipoDomcilio == null) || (tipoDomcilio.indexOf("EN") >= 0);
	}
	/**
	 * Dtermina si es domicilio es de facturacion que tipo_domicilio empiece con "TF"
	 */
	public boolean esFacturacion() {
		return esFacturacion(tipo_domicilio);
	}
	public static boolean esFacturacion(String tipo) {
		return (tipo == null) || (tipo.indexOf("TF") >= 0);
	}
}
