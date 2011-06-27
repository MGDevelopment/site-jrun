package com.tmk.bus.socio;

import java.sql.Timestamp;
import com.tmk.bus.fk.Socios2FK;
import com.tmk.src.socio.BufferSocioPK;
import com.tmk.dbo.DBO;


/**
 * @author oClopez
 *
 */
public class BufferSocios extends DBO {
	/*defno los campos para obtener la pk*/
	private static final Socios2FK cls_fk = Socios2FK.getInstance();
	private Integer id_sucursal;
	private Integer id_socio;
	private Integer id_caal;
	private Integer id_tipo_contribuyente;
	private String tipo_persona;
	private byte[] login;
	private String nombres;
	private String apellidos;	
	private byte[] password;
	private String tipo_doc;
	private Long nro_doc;
	private Integer nacionalidad;
	private Timestamp fecha_nacimiento;
	private String sexo;
	private String  estado_civil;
	private Integer hijos;
	private Integer id_profesion;
	private String procesado;
	private String e_mail1;
	private String info_extra;
	private String info_terceros;
	private String internet_casa;
	private String pc_casa;
	private String procesado_ecl;
	private String auxflag2;//necesario aprael update de los datos dentro de mi cuenta	private Timestamp f_alta;			
	
	
	/*creo un constructor con parametro para que cuando lo instancie a la clase obtener el pk*/
	/**
	 * @see permite obtener el pk
	 * @param id_sucursal
	 * @param id_socio
	 */
	
	public BufferSocios (Integer id_sucursal,Integer id_socio) {
		this.id_socio = id_socio;
		this.id_sucursal = id_sucursal;
	}
	public BufferSocios(BufferSocioPK bufferSocioPk) {
		this.id_socio = bufferSocioPk.ID_SOCIO;
		this.id_sucursal = bufferSocioPk.ID_SUCURSAL;
	}

	public BufferSocios() {

	}	

	public Long getNro_doc() {
		return nro_doc;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal = ").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		return pk.toString();
	}

	public static String getTabla() {
		return "BUFFER_SOCIOS";
	}

	/*SET´S*/
	public void setNombres	(String nombres) { this.nombres = nombres; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	/*GET´S*/
	public String getApellidos() { return apellidos;}	
	public String getNombres() { return nombres; }
	
	public static String getFiltro() {

		return null;
	}

	public static String getAlias() {
		return "BUSO";
	}

	public static String getOrden() {
		return null;
	}
	public boolean tieneDBO() {
		return true;
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_socio",getAlias()+"__id_sucursal"};
	}	
	public String getE_mail1() {
		return e_mail1;
	}
	public void setE_mail1(String e_mail1) {
		this.e_mail1 = e_mail1;
	}
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public Integer getId_socio() {
		return id_socio;
	}
	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}
		
	public Timestamp getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Timestamp fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getHijos() {
		return hijos;
	}

	public Integer getId_profesion() {
		return id_profesion;
	}

	public void setHijos(Integer hijos) {
		this.hijos = hijos;
	}

	public void setId_profesion(Integer id_profesion) {
		this.id_profesion = id_profesion;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getAuxflag2() {
		return auxflag2;
	}

	public void setAuxflag2(String auxflag2) {
		this.auxflag2 = auxflag2;
	}

	public byte[] getLogin() {
		return login;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setLogin(byte[] login) {
		this.login = login;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public Integer getId_caal() {
		return id_caal;
	}

	public Integer getId_tipo_contribuyente() {
		return id_tipo_contribuyente;
	}

	public String getTipo_persona() {
		return tipo_persona;
	}

	public Integer getNacionalidad() {
		return nacionalidad;
	}

	public String getProcesado() {
		return procesado;
	}

	public String getInfo_extra() {
		return info_extra;
	}

	public String getInfo_terceros() {
		return info_terceros;
	}

	public String getInternet_casa() {
		return internet_casa;
	}

	public String getPc_casa() {
		return pc_casa;
	}

	public String getProcesado_ecl() {
		return procesado_ecl;
	}

	public void setId_caal(Integer id_caal) {
		this.id_caal = id_caal;
	}

	public void setId_tipo_contribuyente(Integer id_tipo_contribuyente) {
		this.id_tipo_contribuyente = id_tipo_contribuyente;
	}

	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public void setNro_doc(Long nro_doc) {
		this.nro_doc = nro_doc;
	}

	public void setNacionalidad(Integer nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}

	public void setInfo_extra(String info_extra) {
		this.info_extra = info_extra;
	}

	public void setInfo_terceros(String info_terceros) {
		this.info_terceros = info_terceros;
	}

	public void setInternet_casa(String internet_casa) {
		this.internet_casa = internet_casa;
	}

	public void setPc_casa(String pc_casa) {
		this.pc_casa = pc_casa;
	}

	public void setProcesado_ecl(String procesado_ecl) {
		this.procesado_ecl = procesado_ecl;
	}
		
	
}
