package com.tmk.bus.socio;

import java.sql.Connection;
import java.sql.Timestamp;

import com.tmk.bus.fk.Socios2FK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.CryptUtil;
import com.tmk.util.ByteArrayWarpper;

/**
 * @author oClopez
 *
 */
public class Socios2 extends DBO {
	/*defno los campos para obtener la pk*/
	private static final Socios2FK cls_fk = Socios2FK.getInstance();
	private String nombres;
	private String apellidos;
	private Integer id_caal;
	private Integer id_tipo_contribuyente;
	private String tipo_persona;
	private ByteArrayWarpper login;
	private ByteArrayWarpper password;
	private String e_mail1;
	private Integer id_sucursal;
	private Integer id_socio;
	private String sexo;
	private Integer hijos;
	private Integer id_profesion;
	private String  estado_civil;
	private String tipo_doc;
	private Long nro_doc;
	private Timestamp fecha_nacimiento;
	private String auxflag2;//necesario para el update de los datos dentro de mi cuenta
	private Timestamp f_alta;	
	private String cls_loginDesencriptado;	
	private SocioDomicilios[] socioDomicilios;
	private SocioIntegracion socioIntegracion;
	private Pais nacionalidad;
	
	/*creo un constructor con parametro para que cuando lo instancie a la clase obtener el pk*/
	/**
	 * @see permite obtener el pk
	 * @param id_sucursal
	 * @param id_socio
	 */
	public Socios2(Integer id_sucursal,Integer id_socio) {
		this.id_socio = id_socio;
		this.id_sucursal = id_sucursal;
	}

	public Socios2() {

	}	

	public Long getNro_doc() {
		return nro_doc;
	}
	
	public void setNro_doc(Long nro_doc) {
		this.nro_doc = nro_doc;
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
		return "SOCIOS2";
	}

	/*sobreescribo los metodos para no hacer nada y no afectar la db por equivocacion*/
	public void insert(Connection conn) throws Exception {}
	public void update(Connection conn) throws Exception {}
	public void delete(Connection conn) throws Exception {}

	public String getlogin() throws Exception {
		byte [] passwordDesencriptado = CryptUtil.desEncriptar(login.getArray());
		if (passwordDesencriptado != null) {
			return new String(passwordDesencriptado);
		} else {
			throw new Exception("No se pudo desencriptar el password del socio " + nombres + "-" + apellidos + " password " + new String(login.getArray()));
		}
	}
	public String getpassword() throws Exception {
		byte [] passwordDesencriptado = CryptUtil.desEncriptar(password.getArray());
		if (passwordDesencriptado != null) {
			return new String(passwordDesencriptado);
		} else {
			throw new Exception("No se pudo desencriptar el password del socio " + nombres + "-" + apellidos + " password " + new String(password.getArray()));
		}
	}

	/*SET´S*/
	public void setLogin	(ByteArrayWarpper login) { this.login = login; }
	public void setPassword	(ByteArrayWarpper password) { this.password= password; }
	public void setNombres	(String nombres) { this.nombres = nombres; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	/*GET´S*/
	public String getApellidos() { return apellidos;}
	public byte[] getLogin() { return login.getArray(); }
	public byte[] getPassword() { return password.getArray(); }
	public String getNombres() { return nombres; }
	public Timestamp getFAlta() {
		return this.f_alta;
	}
	
	public static String getFiltro() {

		return null;
	}

	public static String getAlias() {
		return "SOCIOS";
	}

	public static String getOrden() {
		/*StringBuffer orden = new StringBuffer("");
		orden.append(getAlias()).append(".nombres");
		return orden.toString();*/
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
	public void setLoginDesencriptado(byte[] cls_loginDesencriptado) {
		this.cls_loginDesencriptado = new String(cls_loginDesencriptado);
	}
	public SocioIntegracion getSocioIntegracion() {
		return socioIntegracion;
	}
	public void setSocioIntegracion(SocioIntegracion socioIntegracion) {
		this.socioIntegracion = socioIntegracion;
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
	public Timestamp getF_alta() {
		return f_alta;
	}
	public void setF_alta(Timestamp f_alta) {
		this.f_alta = f_alta;
	}
	public String getCls_loginDesencriptado() {
		return cls_loginDesencriptado;
	}
	public void setCls_loginDesencriptado(String cls_loginDesencriptado) {
		this.cls_loginDesencriptado = cls_loginDesencriptado;
	}
	public SocioDomicilios[] getSocioDomicilios() {
		return socioDomicilios;
	}
	public void setSocioDomicilios(SocioDomicilios[] socioDomicilios) {
		this.socioDomicilios = socioDomicilios;
	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	public Integer getId_caal() {
		return id_caal;
	}

	public void setId_caal(Integer id_caal) {
		this.id_caal = id_caal;
	}

	public Integer getId_tipo_contribuyente() {
		return id_tipo_contribuyente;
	}

	public String getTipo_persona() {
		return tipo_persona;
	}

	public void setId_tipo_contribuyente(Integer id_tipo_contribuyente) {
		this.id_tipo_contribuyente = id_tipo_contribuyente;
	}

	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}	

	
	
}
