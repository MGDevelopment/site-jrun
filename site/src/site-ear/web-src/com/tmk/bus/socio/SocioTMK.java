package com.tmk.bus.socio;

import java.sql.Timestamp;

import com.tmk.bus.fk.Socios2FK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.CryptUtil;

public class SocioTMK extends DBO {
	private static final Socios2FK cls_fk = Socios2FK.getInstance();
	/*Datos miembro*/
	private Integer id_socio;
	private Integer id_sucursal;
	private String nombres;
	private String apellidos;
	private byte [] password;
	private String login;
	//solo para consulta;
	private Timestamp f_alta;
	private Timestamp f_modi;
	/*Datos miembro*/

	/*Constructores*/
	public SocioTMK (Integer idSocio, Integer idSucursal)  {
		this.id_socio = idSocio;
		this.id_sucursal = idSucursal;
	}

	public SocioTMK () {
	}
	/*Constructores*/

	/*SET*/
	public void setIdSocio(Integer idSocio) {
		this.id_socio = idSocio;
	}

	public void setIdSucursal (Integer idSucursal) {
		this.id_sucursal = idSucursal;
	}

	public void setNombres (String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos (String apellidos) {
		this.apellidos = apellidos;
	}

	public void setPassword (byte [] password) {
		this.password = password;
	}

	public void setLogin (String login) {
		this.login = login;
	}
	/*SET*/

	/*GET*/
	public Integer getIdSocio() {
		return this.id_socio;
	}

	public Integer getIdSucursal() {
		return this.id_sucursal;
	}

	public String getNombres () {
		return this.nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public byte [] getPassword() {
		return this.password;
	}

	public String getLogin () {
		return this.login;
	}

	public Timestamp getFAlta() {
		return this.f_alta;
	}

	public Timestamp getFModi() {
		return this.f_modi;
	}

	/*GET*/

	/*Metodos heredados*/
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal = ").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		return pk.toString();
	}

	public static String getTabla() {
		return "socios_tmk";
	}
	/*Metodos heredados*/

	/*Metodos propios*/
	public String getPasswordDesencriptado() throws Exception {
		byte [] passwordDesencriptado = CryptUtil.desEncriptar(password);
		if (passwordDesencriptado != null) {
			return new String(passwordDesencriptado);
		} else {
			throw new Exception("No se pudo desencriptar el password del socio " + id_sucursal + "-" + id_socio + " password " + password);
		}
	}

	/*Metodos propios*/

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "SOCTMK";
	}

	public static String getOrden() {
		return null;
	}

	public boolean tieneDBO() {
		return false;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_socio",getAlias()+"__id_sucursal"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
}
