package com.tmk.bus.socio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.kernel.CryptUtil;


public class AlertaCompraSocios extends DBO {
	private Integer id_sucursal;
	private Integer id_socio;
	private String cls_nombres;
	private String cls_apellidos;
	private byte[] cls_login;

	/**
	 * @param string id_sucursal
	 * @param string id_socio
	 */
	public AlertaCompraSocios(Integer id_socio, Integer id_sucursal) {
		this.id_sucursal=id_sucursal;
		this.id_socio=id_socio;
	}

	/*SET*/
	public void setIdSocio(Integer idSocio) {
		this.id_socio = idSocio;
	}

	public void setIdSucursal (Integer idSucursal) {
		this.id_sucursal = idSucursal;
	}

	public void setNombres (String nombres) {
		this.cls_nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.cls_apellidos = apellidos;
	}

	public void setLogin(byte[] login) {
		this.cls_login = login;
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
		return this.cls_nombres;
	}

	public String getApellidos() {
		return this.cls_apellidos;
	}

	public byte [] getLogin() {
		return this.cls_login;
	}
	/*GET*/

	/**
	 @param string id_sucursal
	 @param string id_socio
	 @return clave primaia de la tabla
	 */
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal = ").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		return pk.toString();
	}

	/**
	 * @return nombre de la tabla
	 */
	public static String getTabla(){
		return "ALERTA_COMPRA_SOCIOS";
	}


	//Lo sobrescribo porque no se utiliza
	public void update(Connection conn) throws Exception {
		
	}

	/*Metodos propios*/
	public String getLoginDesencriptado() throws Exception {
		byte [] passwordDesencriptado = CryptUtil.desEncriptar(cls_login);
		if (passwordDesencriptado != null) {
			return new String(passwordDesencriptado);
		} else {
			throw new Exception("No se pudo desencriptar el login del socio " + id_sucursal + "-" + id_socio + " login " + cls_login);
		}
	}

	public static Vector getALL(Connection conn, String[] param) throws Exception {
		Vector<AlertaCompraSocios> aux = new Vector<AlertaCompraSocios>();
		try {
			StringBuffer qry = new StringBuffer("");
			qry.append(" SELECT ");
			qry.append(" 	s.nombres,");
			qry.append(" 	s.apellidos,");
			qry.append(" 	s.login,");
			qry.append(" 	s.id_socio,");
			qry.append(" 	s.id_sucursal");
			qry.append(" FROM");
			qry.append(" 	socios2 s,");
			qry.append(" 	alerta_compra_socios acs");
			qry.append(" WHERE");
			qry.append(" 	s.id_socio = acs.id_socio ");
			qry.append("  	and  s.id_sucursal = acs.id_sucursal");
			qry.append(" 	and  s.login is not null");
			if (param != null) {
				for (int i=0; i<param.length; i++) {
					qry.append(" and ").append(param[i]);
				}
			}
			qry.append(" ORDER BY s.apellidos, s.nombres");

			Statement st = conn.createStatement();
			try {
				ResultSet rs = st.executeQuery(qry.toString());
				try {
					while (rs.next()) {
						AlertaCompraSocios acsDBO = new AlertaCompraSocios(
								new Integer(rs.getInt("id_socio")), new Integer(rs.getInt("id_sucursal")));
						acsDBO.setApellidos(rs.getString("apellidos"));
						acsDBO.setNombres(rs.getString("nombres"));
						acsDBO.setLogin(rs.getBytes("login"));
						aux.add(acsDBO);
					}
				} finally {
					rs.close();
				}
			} finally {
				st.close();
			}
		} catch (Exception e) {
			throw new Exception ("AlertaCompraSocios]" + " " + e.toString() + MainHelper.getMessage(e));
		}
		return aux;
	}

	
	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "ACS";
	}
	/*Metodos propios*/

	public static String getOrden() {
		return null;
	}

	public boolean tieneDBO() {

		return false;
	}


}
