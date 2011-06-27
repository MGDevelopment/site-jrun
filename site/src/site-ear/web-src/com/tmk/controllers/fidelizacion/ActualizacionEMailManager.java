package com.tmk.controllers.fidelizacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import javax.naming.NamingException;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.socio.SocioPK;


public class ActualizacionEMailManager {
	//estados 
	public static final String ESTADO_INICIAL = "1";
	public static final String ESTADO_FINAL = "2";
	public static final String ESTADO_FINAL_SIN_PUNTOS = "3";
	
	//campos 
	public static final String CAMPO_TIPO_DOC = "tipoDoc";
	public static final String CAMPO_NRO_DOC = "nroDoc";
	public static final String CAMPO_ID_PAIS = "idPais";
	public static final String CAMPO_SEXO = "sexo";
	public static final String CAMPO_EMAIL = "eMail";
	public static final String CAMPO_PASSWORD = "password";
	public static final String CAMPO_CONPASSWORD = "conPassword";
	public static final String CAMPO_CODIGO = "codigo";
	public static final String CAMPO_TIPO_TELEFONO = "tipoTelefono";
	public static final String CAMPO_COD_AREA = "codArea";
	public static final String CAMPO_NRO_TEL = "nroTelefono";
	public static final String CAMPO_EXT_INT = "interno";
	public static final String CAMPO_TIPO_DOMICILIO = "tipoDomicilio";
	public static final String CAMPO_CALLE = "calle";
	public static final String CAMPO_NUMERO = "numero";
	public static final String CAMPO_EDIFICIO = "edificio";
	public static final String CAMPO_PISO = "piso";
	public static final String CAMPO_DEPTO = "depto";
	public static final String CAMPO_CP = "cp";
	public static final String CAMPO_ID_LOCALIDAD_DIR = "idLocalidadDir";
	public static final String CAMPO_STR_LOCALIDAD_DIR = "strLocalidadDir";
	public static final String CAMPO_ID_PROVINCIA_DIR = "idProvinciaDir";
	public static final String CAMPO_STR_PROVINCIA_DIR = "strProvinciaDir";
	public static final String CAMPO_ID_PAIS_DIR = "idPaisDir";
	
	 
	//urls
	public static final String PAGINA_CARGA = "/fidelizacion/panel/actualizacionEMail.jsp";
	public static final String CONTROLADOR_INICIO = "/IniciarActDeEmail";
	public static final String CONTROLADOR_FIN = "/FinalizarActDeEmail";
	public static final String PAGINA_MSG_INICIO = "/fidelizacion/panel/msgActEMailInicio.jsp";
	public static final String PAGINA_MSG_FIN = "/fidelizacion/panel/msgActEMailFin.jsp";
	public static final String PAGINA_MSG_ERROR = "/fidelizacion/panel/msgActEMailError.jsp";
	public static final String CUERPO_EMAIL = "/mailing/actualizacionEMail.jsp";
	public static final String CUERPO_EMAIL_SEGUNDA = "/mailing/actualizacionEMailSegunda.jsp";
	
	//msg
	public static String SESSION_MSG_ERROR = "ACT_EMAIL_MSG_ERROR";
	
	// no cambiar
	private static final long INCREMENTO = 100010001;
	
//	 genera un codigo unico para cada actualizacion
    public static long getCodigo() throws Exception {
		StringBuffer codigo = new StringBuffer("");

		long seq = DBUtil.getSequenceValue("ACTUALIZACION_MAIL_EXTRA_SEQ").longValue();
		TmkLogger.info("ACTUALIZACION_MAIL_EXTRA, getCodigo] Sequence " + seq);

		seq += INCREMENTO;
		codigo.append(seq);

		int sum = 0;

		for (int i = 0; i < codigo.length(); i++) {
			sum = sum + Integer.parseInt(codigo.substring(i, i + 1));
		}
		char clave [] = (sum > 9)? new String ("" + sum).toCharArray(): new String ("0" + sum).toCharArray();
		codigo.insert(4,clave[0]);
		codigo.insert(6,clave[1]);

		TmkLogger.info("ACTUALIZACION_MAIL_EXTRA, getCodigo] codigo: " + codigo.toString());

	    long retorno = Long.valueOf(codigo.toString()).longValue();
		if (retorno ==0) {
            throw new NullPointerException();
		}
	    return retorno;
    }
    
//  valida el codigo 
	public static boolean esCodigoValido (String codigo) {
		try {
			String clave = codigo.substring(4, 5) + codigo.substring(6, 7);
			int sum = 0;

			for (int i = 0; i < codigo.length(); i++) {
				sum = (i!=4 && i!=6)? sum + Integer.parseInt(codigo.substring(i, i + 1)): sum;
			}
			return (Integer.parseInt(clave) == sum);
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static String getNombreSocioFidelizado(String tipoDoc, String nroDoc, int idPais, String sexo) {
		String cabeceraMsg = "ActualizacionEMailManager.getNombreSocioFidelizado(" + tipoDoc + ", " + nroDoc + ", " + idPais + ", " + sexo + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT nombres, apellidos ");
				qry.append(" FROM socios2 s, buffer_fdn_cuentas_x_socios bfc");
				qry.append(" WHERE ");
				qry.append(" s.id_socio = bfc.id_socio");
				qry.append(" AND s.id_sucursal = bfc.id_sucursal_socio");
				qry.append(" AND s.tipo_doc = ?");
				qry.append(" AND s.nro_doc = ?");
				qry.append(" AND s.nacionalidad = ?");
				qry.append(" AND s.sexo = ?");
				qry.append(" UNION ");
				qry.append(" SELECT  nombres, apellidos ");
				qry.append(" FROM socios2 s, fdn_cuentas_x_socios bfc");
				qry.append(" WHERE ");
				qry.append(" s.id_socio = bfc.id_socio");
				qry.append(" AND s.id_sucursal = bfc.id_sucursal_socio");
				qry.append(" AND s.tipo_doc = ?");
				qry.append(" AND s.nro_doc = ?");
				qry.append(" AND s.nacionalidad = ?");
				qry.append(" AND s.sexo = ?");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setString(1, tipoDoc);
				ps.setString(2, nroDoc);
				ps.setInt(3, idPais);
				ps.setString(4, sexo);
				ps.setString(5, tipoDoc);
				ps.setString(6, nroDoc);
				ps.setInt(7, idPais);
				ps.setString(8, sexo);
				
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							if (rs.getString("nombres") != null && rs.getString("apellidos") != null) {
								//existe
								
								
								return rs.getString("nombres") + " " + rs.getString("apellidos");
							} else {
								
								return null;
							}	
						}
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en recorrido de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return null;
	}

	public static boolean setInicioActualizacionEmail(long codigo, String tipoDoc, String nroDoc, 
			int idPais, String sexo, String eMail, String password, String tipoDomicilio,
			String calle, int numero, String edificio, int piso, String depto, String cp,
			int idLocalidad, int idProvincia, int idPaisDir, String strProvincia, 
			String strLocalidad, String tipoTelefono, String codArea, String nroTel, 
			String interno) throws Exception {
		boolean retorno = false;
		String cabeceraMsg = "ActualizacionEMailManager.setInicioActualizacionEmail(" + codigo + ", " + tipoDoc 
		+ ", " + nroDoc + ", " + idPais + ", " + sexo + ", " + eMail + "," + password + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" INSERT INTO actualizacion_mail_extra ( ");
				qry.append(" codigo_actualizacion, tipo_doc, nro_doc, nacionalidad,");
				qry.append(" sexo, login, password, estado, tipo_domicilio, calle, numero,");
				qry.append(" edificio, piso, depto, cp, id_localidad, id_provincia, id_pais,");
				qry.append(" descripcion_provincia_inex, descripcion_localidad_inex,");
				qry.append(" tipo_telefono, cod_area, nro_tel, ext_int)");
				qry.append(" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
				qry.append(" , ?, ?, ?, ?, ?, ?, ?, ?)" );
				byte[] eMailEnc = CryptUtil.encriptar(eMail.getBytes());
				byte[] passwordEnc = CryptUtil.encriptar(password.getBytes());
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setLong(1, codigo);
				ps.setString(2, tipoDoc);
				ps.setString(3, nroDoc);
				ps.setInt(4, idPais);
				ps.setString(5, sexo);
				ps.setBytes(6, eMailEnc);
				ps.setBytes(7, passwordEnc);
				ps.setString(8, ESTADO_INICIAL);
				ps.setString(9, tipoDomicilio);
				ps.setString(10, calle);
				
				if (numero == 0) {
					ps.setNull(11, Types.INTEGER);
				} else {
					ps.setInt(11, numero);	
				}
				//TmkLogger.debug("numero " + numero);
				
				ps.setString(12, edificio);
				
				if (piso == 0) {
					ps.setNull(13, Types.INTEGER);
				} else {
					ps.setInt(13, piso);	
				}
				
				//TmkLogger.debug("piso " + piso);
				
				ps.setString(14, depto);
				ps.setString(15, cp);
				
				if (idLocalidad == 0) {
					ps.setNull(16, Types.INTEGER);
				} else {
					ps.setInt(16, idLocalidad);	
				}
				
				//TmkLogger.debug("localidad " + idLocalidad);
				
				if (idProvincia == 0) {
					ps.setNull(17, Types.INTEGER);
				} else {
					ps.setInt(17, idProvincia);	
				}
				
				//TmkLogger.debug("provincia " + idProvincia);
				
				if (idPaisDir == 0) {
					ps.setNull(18, Types.INTEGER);
				} else {
					ps.setInt(18, idPaisDir);	
				}
				
				//TmkLogger.debug("pais " + idPais);
				
				ps.setString(19, strProvincia);
				ps.setString(20, strLocalidad);
				ps.setString(21, tipoTelefono);
				ps.setString(22, codArea);
				ps.setString(23, nroTel);
				ps.setString(24, interno);
				
				try {
					retorno = ps.execute();
				} catch (java.sql.SQLException e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
					throw new Exception(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (java.sql.SQLException e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
				throw new Exception(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (java.sql.SQLException e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
			throw new Exception(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
	}

	
	public static boolean actualizadoPreviamente (String tipoDoc, long nroDoc, int idPais, String sexo) {
		String cabeceraMsg = "ActualizacionEMailManager.actualizadoPreviamente(" + tipoDoc + ", " +
						nroDoc + ", " + idPais + ", " + sexo + ")";
		boolean retorno = true;
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT codigo_actualizacion ");
				qry.append(" FROM actualizacion_mail_extra");
				qry.append(" WHERE ");
				qry.append(" tipo_doc = ?");
				qry.append(" AND nro_doc = ?");
				qry.append(" AND nacionalidad = ?");
				qry.append(" AND sexo = ?");
				qry.append(" AND estado = ?");
				qry.append(" AND f_modi > sysdate-180");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setString(1, tipoDoc);
				ps.setLong(2, nroDoc);
				ps.setInt(3, idPais);
				ps.setString(4, sexo);
				ps.setString(5, ESTADO_FINAL);
				
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = true;
						} else {
							retorno = false;
						}
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de RS " + qry.toString() + " " + e.toString());
						
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
					
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
				
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
			
		}
		
		return retorno;
	}
	
	public static String[] getDatosAActualizar(String codigo) {
		String retorno[] = null;
		String cabeceraMsg = "ActualizacionEMailManager.getDatosAActualizar(" + codigo + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT ame.login, ame.password, ame.tipo_doc, ame.nro_doc, ");
				qry.append(" ame.nacionalidad, ame.sexo, ame.tipo_telefono, ame.cod_area, ");
				qry.append(" ame.nro_tel, ame.ext_int, ame.tipo_domicilio, ame.calle,"); 
				qry.append(" ame.numero, ame.edificio, ame.piso, ame.depto, ame.cp,");
				qry.append(" ame.id_localidad, ame.id_provincia, ame.id_pais,");
				qry.append(" ame.descripcion_provincia_inex, ame.descripcion_localidad_inex  ");
				qry.append(" FROM actualizacion_mail_extra ame");
				qry.append(" WHERE ");
				qry.append(" codigo_actualizacion = ? ");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setString(1, codigo);
				
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = new String[24];
							retorno[0] = new String(CryptUtil.desEncriptar(rs.getBytes("login")));
							retorno[1] = new String(CryptUtil.desEncriptar(rs.getBytes("password")));
							retorno[2] = rs.getString("tipo_doc");
							retorno[3] = rs.getString("nro_doc");
							retorno[4] = rs.getString("nacionalidad");
							retorno[5] = rs.getString("sexo");
							retorno[6] = rs.getString("tipo_telefono");
							retorno[7] = rs.getString("cod_area");
							retorno[8] = rs.getString("nro_tel");
							retorno[9] = rs.getString("ext_int");
							retorno[10] = rs.getString("tipo_domicilio");
							retorno[11] = rs.getString("calle");
							retorno[12] = rs.getString("numero");
							retorno[13] = rs.getString("edificio");
							retorno[14] = rs.getString("piso");
							retorno[15] = rs.getString("depto");
							retorno[16] = rs.getString("cp");
							retorno[17] = rs.getString("id_localidad");
							retorno[18] = rs.getString("id_provincia");
							retorno[19] = rs.getString("id_pais");
							retorno[20] = rs.getString("descripcion_localidad_inex");
							retorno[21] = rs.getString("descripcion_provincia_inex");
							SocioPK socioPK = getSocioFidelizado(rs.getString("tipo_doc"), rs.getLong("nro_doc"), rs.getInt("nacionalidad"), rs.getString("sexo"));
							retorno[22] = socioPK.ID_SUCURSAL.toString();
							retorno[23] = socioPK.ID_SOCIO.toString();
						} 
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		
		return retorno;
	}
	
	public static boolean actualizarDatos(Connection conn, String eMail, String password, 
			String tipoDoc, long nroDoc, int idPais, String sexo) throws Exception{
		boolean retorno = false;
		retorno = updateSocio(conn, eMail, password, 
				tipoDoc, nroDoc, idPais, sexo);
		TmkLogger.debug(" UPDATE DE SOCIOS " + retorno);
		if (retorno) {
			if (socioExisteEnBuffer(tipoDoc, nroDoc, idPais, sexo)) {
				boolean ret = updateBufferSocios(conn, eMail, password, tipoDoc, nroDoc, idPais, sexo);
				TmkLogger.debug("UPDATE de BUFFER " + ret);
				if (!ret) { 
					ret = InsertBufferSociosBySocios(conn, eMail, password, 
							tipoDoc, nroDoc, idPais, sexo);
					TmkLogger.debug("INSERT de BUFFER " + ret);
				} 
				retorno = retorno & ret;  
				
			} else {
				retorno = retorno && InsertBufferSociosBySocios(conn, eMail, password, 
						tipoDoc, nroDoc, idPais, sexo);
				TmkLogger.info("INSERT de BUFFER " + retorno);
			}
		}
		return retorno;
	}
	
	public static boolean updateSocio(Connection conn, String eMail, String password, 
			String tipoDoc, long nroDoc, int idPais, String sexo) throws Exception{
		 
		boolean retorno = false;
		SocioPK socioPK = getSocioFidelizado(tipoDoc,nroDoc, idPais, sexo);
		if (socioPK != null) {
			StringBuffer qry = new StringBuffer();
			qry.append(" UPDATE SOCIOS2");
			qry.append(" SET login = ?");
			qry.append(" ,password = ?");
			qry.append(" ,e_mail1 = ?");
			qry.append(" WHERE ");
			qry.append(" id_socio = ?");
			qry.append(" AND id_sucursal = ?");
			
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			
			try {
				byte[] eMailEnc = CryptUtil.encriptar(eMail.getBytes());
				byte[] passwordEnc = CryptUtil.encriptar(password.getBytes());
				ps.setBytes(1, eMailEnc);
				ps.setBytes(2, passwordEnc);
				ps.setString(3, eMail);
				ps.setInt(4, socioPK.ID_SOCIO.intValue());
				ps.setInt(5, socioPK.ID_SUCURSAL.intValue());
				ps.execute();
				if (ps.getUpdateCount()>0) {
					retorno = true;
				}
			} finally {
				ps.close();
			}
		}
		return retorno;
	}
	

	
	public static boolean socioExisteEnBuffer(String tipoDoc, long nroDoc, int idPais, String sexo) throws Exception {
		boolean retorno = false;
		SocioPK socioPK = getSocioFidelizado(tipoDoc, nroDoc, idPais, sexo);
		if (socioPK != null) {
			Connection conn = DBUtil.buildConnection();
			StringBuffer qry = new StringBuffer("");
			qry.append("SELECT id_socio, id_sucursal FROM buffer_socios");
			qry.append(" WHERE id_socio = ?");
			qry.append(" AND id_sucursal = ?");
			
			try {
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				
				try {
					ps.setInt(1, socioPK.ID_SOCIO.intValue());
					ps.setInt(2, socioPK.ID_SUCURSAL.intValue());
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = true;
						} else {
							retorno = false;
						}
					} finally {
						rs.close();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		}	
		return retorno;
	}
	
	
	public static boolean updateBufferSocios(Connection conn, String eMail, String password, 
		String tipoDoc, long nroDoc, int idPais, String sexo) throws Exception{
		boolean retorno = false;
		SocioPK socioPK = getSocioFidelizado(tipoDoc, nroDoc, idPais, sexo);
		if (socioPK != null) {
			StringBuffer qry = new StringBuffer();
			qry.append(" UPDATE BUFFER_SOCIOS");
			qry.append(" SET login = ?");
			qry.append(" ,password = ?");
			qry.append(" ,e_mail1 = ?");
			qry.append(" ,procesado_ecl = ?");
			qry.append(" ,auxflag2 =(SELECT auxflag2 FROM SOCIOS2 WHERE id_sucursal = ? AND  id_socio = ? )");
			qry.append(" WHERE ");
			qry.append(" id_sucursal = ?");
			qry.append(" and id_socio = ?");
			
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			
			try {
				byte[] eMailEnc = CryptUtil.encriptar(eMail.getBytes());
				byte[] passwordEnc = CryptUtil.encriptar(password.getBytes());
				ps.setBytes(1, eMailEnc);
				ps.setBytes(2, passwordEnc);
				ps.setString(3, eMail);
				ps.setNull(4, Types.VARCHAR);
				ps.setInt(5, socioPK.ID_SUCURSAL.intValue());
				ps.setInt(6, socioPK.ID_SOCIO.intValue());
				ps.setInt(7, socioPK.ID_SUCURSAL.intValue());
				ps.setInt(8, socioPK.ID_SOCIO.intValue());
				ps.execute();
				if (ps.getUpdateCount()>0) {
					retorno = true;
				}
			} finally {
				ps.close();
			}
		}			
		return retorno;
	}
	
	public static boolean InsertBufferSociosBySocios(Connection conn, String eMail, String password, 
			String tipoDoc, long nroDoc, int idPais, String sexo) throws Exception {
		
		boolean retorno = false;
		SocioPK socioPK = getSocioFidelizado(tipoDoc, nroDoc, idPais, sexo);
		if (socioPK != null) {
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT ID_SUCURSAL, ID_SOCIO, ID_CAAL, ID_TIPO_CONTRIBUYENTE , ");
				qry.append(" 	 TIPO_PERSONA, SEXO, NOMBRES, APELLIDOS, ");
				qry.append(" 	 TIPO_DOC, NRO_DOC, NACIONALIDAD, ");
				qry.append(" 	FECHA_NACIMIENTO, ESTADO_CIVIL, HIJOS, ID_PROFESION, PASSWORD,");
				qry.append(" 	LOGIN, E_MAIL1, INFO_EXTRA, ");
				qry.append(" 	INFO_TERCEROS, INTERNET_CASA, PC_CASA, AUXFLAG2,");
				
				//agregados 06/04/2010 
				qry.append(" NRO_ING_BRUTOS, NRO_INSC_IVA, INSC_GAN, RAZON_SOCIAL, CUIT, ID_CATEGORIA, ");
				qry.append(" E_MAIL2, USA_TC, HABEAS_DATA, COMPRA_TEL,COMPRA_INTERNET, COMENTARIOS, IDIOMA1, IDIOMA2,");
				qry.append(" CLIENTE_CODIGO, FECHA_INHAB, MOTIVO_INHAB, NOMBRE_FANTASÍA,IB_CODIGO, INICIO_REL_COMERCIAL,");
				qry.append(" RETIENE_GAN, RETIENE_IVA, RETIENE_IB, ORDEN_CH, RES_EX_GAN, RES_EX_IVA, ID_VENDEDOR, TIPO_CONT_IB,");
				qry.append(" CATEGORIA_VALOR, ID_PROVINCIA_IIBB, ID_PAIS_IIBB, DPER_CODIGO, ");
				qry.append(" CODIGO_RIF, AUXNUMBER1, AUXNUMBER2, AUXNUMBER3, AUXVARCHAR1, AUXVARCHAR2, AUXVARCHAR3, AUXFLAG1, AUXFLAG3 ");
				//fin bloque
				
				qry.append(" FROM socios2 ");
				qry.append(" WHERE ");
				qry.append(" 	id_socio = ?");
				qry.append(" AND id_sucursal = ?");
								
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				ps.setInt(1, socioPK.ID_SOCIO.intValue());
				ps.setInt(2, socioPK.ID_SUCURSAL.intValue());
				try {
					ResultSet rs = ps.executeQuery();
					//TmkLogger.debug("EJECUTE SELECT");
					try {
						if (rs.next()) {
							StringBuffer qryInsert = new StringBuffer();
							qryInsert.append("INSERT INTO buffer_socios (ID_SUCURSAL, ID_SOCIO, ID_CAAL, ID_TIPO_CONTRIBUYENTE , ");
							qryInsert.append(" 	 TIPO_PERSONA, SEXO, NOMBRES, APELLIDOS, ");
							qryInsert.append(" 	 TIPO_DOC, NRO_DOC, NACIONALIDAD, ");
							qryInsert.append(" 	FECHA_NACIMIENTO, ESTADO_CIVIL, HIJOS, ID_PROFESION, PASSWORD,");
							qryInsert.append(" 	LOGIN, E_MAIL1, INFO_EXTRA, ");
							qryInsert.append(" 	INFO_TERCEROS, INTERNET_CASA, PC_CASA, AUXFLAG2, ");
							
							//se agregan estos campos para resolver el problema de perdida de datos en la buffer_socios (por que no se estaban levantando) 
							qryInsert.append(" NRO_ING_BRUTOS, NRO_INSC_IVA, INSC_GAN, RAZON_SOCIAL, CUIT, ID_CATEGORIA, ");
							qryInsert.append(" E_MAIL2, USA_TC, HABEAS_DATA, COMPRA_TEL,COMPRA_INTERNET, ");
							qryInsert.append(" COMENTARIOS, IDIOMA1, IDIOMA2, ");
							qryInsert.append(" CLIENTE_CODIGO, FECHA_INHAB, MOTIVO_INHAB, NOMBRE_FANTASÍA,IB_CODIGO, INICIO_REL_COMERCIAL, ");
							
							qryInsert.append(" RETIENE_GAN, RETIENE_IVA, RETIENE_IB, ORDEN_CH, RES_EX_GAN, RES_EX_IVA, ID_VENDEDOR, TIPO_CONT_IB, ");
							qryInsert.append(" CATEGORIA_VALOR, ID_PROVINCIA_IIBB, ID_PAIS_IIBB, DPER_CODIGO, ");
							qryInsert.append(" CODIGO_RIF, AUXNUMBER1, AUXNUMBER2, AUXNUMBER3, AUXVARCHAR1, AUXVARCHAR2, AUXVARCHAR3, AUXFLAG1, AUXFLAG3) ");
							//fin bloque
																				
							qryInsert.append(" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
							qryInsert.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
							qryInsert.append(" ?, ?, ?, ");

							//agregue estos '?'
							qryInsert.append("?, ?, ?, ?, ?, ?, ");
							qryInsert.append("?, ?, ?, ?, ?, ");
							qryInsert.append("?, ?, ?, ");
							qryInsert.append("?, ?, ?, ?, ?, ?, ");
							
							qryInsert.append("?, ?, ?, ?, ?, ?, ?, ?, ");
							qryInsert.append("?, ?, ?, ?, ");							
							qryInsert.append("?, ?, ?, ?, ?, ?, ?, ?, ? )");
							//fin bloque							
							
							PreparedStatement psInsert = conn.prepareStatement(qryInsert.toString());
							try {
								
								psInsert.setInt(1, rs.getInt("ID_SUCURSAL"));
								psInsert.setInt(2, rs.getInt("ID_SOCIO"));
								psInsert.setInt(3, rs.getInt("ID_CAAL"));
								psInsert.setInt(4, rs.getInt("ID_TIPO_CONTRIBUYENTE"));
								psInsert.setString(5, rs.getString("TIPO_PERSONA"));
								psInsert.setString(6, sexo);
								
								if (rs.getString("nombres") != null) {
									psInsert.setString(7, rs.getString("nombres"));
								} else {
									psInsert.setNull(7, Types.VARCHAR);
								}
								
								if (rs.getString("apellidos") != null) {
									psInsert.setString(8, rs.getString("apellidos"));
								} else {
									psInsert.setNull(8, Types.VARCHAR);
								}
								
								psInsert.setString(9, tipoDoc);
								psInsert.setLong(10, nroDoc);
							 	psInsert.setInt(11, idPais);
								
								if (rs.getTimestamp("FECHA_NACIMIENTO") != null) {
									psInsert.setTimestamp(12, rs.getTimestamp("FECHA_NACIMIENTO"));
								} else {
									psInsert.setNull(12, Types.DATE);
								}
									
								if (rs.getString("ESTADO_CIVIL") != null) {
									psInsert.setString(13, rs.getString("ESTADO_CIVIL"));
								} else {
									psInsert.setNull(13, Types.VARCHAR);
								}
								
								if (rs.getInt("HIJOS") != 0) {
									psInsert.setInt(14, rs.getInt("HIJOS"));
								} else {
									psInsert.setNull(14, Types.NUMERIC);
								}
								
								if (rs.getInt("ID_PROFESION") != 0) {
									psInsert.setInt(15, rs.getInt("ID_PROFESION"));
								} else {
									psInsert.setNull(15, Types.NUMERIC);
								}
								
								byte[] passwordEnc = CryptUtil.encriptar(password.getBytes());
								psInsert.setBytes(16, passwordEnc);
								
								byte[] eMailEnc = CryptUtil.encriptar(eMail.getBytes());
								psInsert.setBytes(17, eMailEnc);
								
								psInsert.setString(18, eMail);
							
								if (rs.getString("INFO_EXTRA") != null) {
									psInsert.setString(19, rs.getString("INFO_EXTRA"));
								} else {
									psInsert.setNull(19, Types.VARCHAR);
								}
								
								if (rs.getString("INFO_TERCEROS") != null) {
									psInsert.setString(20, rs.getString("INFO_TERCEROS"));
								} else {
									psInsert.setNull(20, Types.VARCHAR);
								}
								
								if (rs.getString("INTERNET_CASA") != null) {
									psInsert.setString(21, rs.getString("INTERNET_CASA"));
								} else {
									psInsert.setNull(21, Types.VARCHAR);
								}
								
								if (rs.getString("PC_CASA") != null) {
									psInsert.setString(22, rs.getString("PC_CASA"));
								} else {
									psInsert.setNull(22, Types.VARCHAR);
								}
								
								if (rs.getString("AUXFLAG2") != null) {
									psInsert.setString(23, rs.getString("AUXFLAG2"));
								} else {
									psInsert.setNull(23, Types.VARCHAR);
								}
								
								//BLOQUE AGREGADO								
								int i = 24;								
								if (rs.getString("NRO_ING_BRUTOS") != null) {
									psInsert.setString(i++, rs.getString("NRO_ING_BRUTOS"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("NRO_INSC_IVA") != null) {
									psInsert.setString(i++, rs.getString("NRO_INSC_IVA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("INSC_GAN") != null) {
									psInsert.setString(i++, rs.getString("INSC_GAN"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("RAZON_SOCIAL") != null) {
									psInsert.setString(i++, rs.getString("RAZON_SOCIAL"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("CUIT") != null) {
									psInsert.setString(i++, rs.getString("CUIT"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("ID_CATEGORIA") != null) {
									psInsert.setString(i++, rs.getString("ID_CATEGORIA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("E_MAIL2") != null) {
									psInsert.setString(i++, rs.getString("E_MAIL2"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("USA_TC") != null) {
									psInsert.setString(i++, rs.getString("USA_TC"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}														
								if (rs.getString("HABEAS_DATA") != null) {
									psInsert.setString(i++, rs.getString("HABEAS_DATA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("COMPRA_TEL") != null) {
									psInsert.setString(i++, rs.getString("COMPRA_TEL"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("COMPRA_INTERNET") != null) {
									psInsert.setString(i++, rs.getString("COMPRA_INTERNET"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}															
								if (rs.getString("COMENTARIOS") != null) {
									psInsert.setString(i++, rs.getString("COMENTARIOS"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("IDIOMA1") != null) {
									psInsert.setString(i++, rs.getString("IDIOMA1"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("IDIOMA2") != null) {
									psInsert.setString(i++, rs.getString("IDIOMA2"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
																
								if (rs.getInt("CLIENTE_CODIGO") != 0) {
									psInsert.setInt(i++, rs.getInt("CLIENTE_CODIGO"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getTimestamp("FECHA_INHAB") != null) {
									psInsert.setTimestamp(i++, rs.getTimestamp("FECHA_INHAB"));
								} else {
									psInsert.setNull(i++, Types.DATE);
								}
								if (rs.getString("MOTIVO_INHAB") != null) {
									psInsert.setString(i++, rs.getString("MOTIVO_INHAB"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("NOMBRE_FANTASÍA") != null) {
									psInsert.setString(i++, rs.getString("NOMBRE_FANTASÍA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getInt("IB_CODIGO") != 0) {
									psInsert.setInt(i++, rs.getInt("IB_CODIGO"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getTimestamp("INICIO_REL_COMERCIAL") != null) {
									psInsert.setTimestamp(i++, rs.getTimestamp("INICIO_REL_COMERCIAL"));
								} else {
									psInsert.setNull(i++, Types.DATE);
								}
								
								if (rs.getString("RETIENE_GAN") != null) {
									psInsert.setString(i++, rs.getString("RETIENE_GAN"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("RETIENE_IVA") != null) {
									psInsert.setString(i++, rs.getString("RETIENE_IVA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("RETIENE_IB") != null) {
									psInsert.setString(i++, rs.getString("RETIENE_IB"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("ORDEN_CH") != null) {
									psInsert.setString(i++, rs.getString("ORDEN_CH"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("RES_EX_GAN") != null) {
									psInsert.setString(i++, rs.getString("RES_EX_GAN"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}								
								if (rs.getString("RES_EX_IVA") != null) {
									psInsert.setString(i++, rs.getString("RES_EX_IVA"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getInt("ID_VENDEDOR") != 0) {
									psInsert.setInt(i++, rs.getInt("ID_VENDEDOR"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getString("TIPO_CONT_IB") != null) {
									psInsert.setString(i++, rs.getString("TIPO_CONT_IB"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
																
								if (rs.getString("CATEGORIA_VALOR") != null) {
									psInsert.setString(i++, rs.getString("CATEGORIA_VALOR"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getInt("ID_PROVINCIA_IIBB") != 0) {
									psInsert.setInt(i++, rs.getInt("ID_PROVINCIA_IIBB"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}								
								
								if (rs.getInt("ID_PAIS_IIBB") != 0) {
									psInsert.setInt(i++, rs.getInt("ID_PAIS_IIBB"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getInt("DPER_CODIGO") != 0) {
									psInsert.setInt(i++, rs.getInt("DPER_CODIGO"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								
								if (rs.getString("CODIGO_RIF") != null) {
									psInsert.setString(i++, rs.getString("CODIGO_RIF"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getInt("AUXNUMBER1") != 0) {
									psInsert.setInt(i++, rs.getInt("AUXNUMBER1"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getInt("AUXNUMBER2") != 0) {
									psInsert.setInt(i++, rs.getInt("AUXNUMBER2"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getInt("AUXNUMBER3") != 0) {
									psInsert.setInt(i++, rs.getInt("AUXNUMBER3"));
								} else {
									psInsert.setNull(i++, Types.NUMERIC);
								}
								if (rs.getString("AUXVARCHAR1") != null) {
									psInsert.setString(i++, rs.getString("AUXVARCHAR1"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("AUXVARCHAR2") != null) {
									psInsert.setString(i++, rs.getString("AUXVARCHAR2"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("AUXVARCHAR3") != null) {
									psInsert.setString(i++, rs.getString("AUXVARCHAR3"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("AUXFLAG1") != null) {
									psInsert.setString(i++, rs.getString("AUXFLAG1"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								if (rs.getString("AUXFLAG3") != null) {
									psInsert.setString(i++, rs.getString("AUXFLAG3"));
								} else {
									psInsert.setNull(i++, Types.VARCHAR);
								}
								//fin bloque
								
								psInsert.execute();
								if (psInsert.getUpdateCount() > 0) {
									retorno = true;
								}
							} finally {
								psInsert.close();
							}
						}
					} finally {
						rs.close();
					}
				} finally {
					ps.close();
				} 
			} catch (Exception e) {
				TmkLogger.error("ERROR - InsertBufferSociosBySocios] nroDoc = " + nroDoc + " " + e.toString());
			}
		}
		return retorno;
	}
	
	
	public static boolean agregarDomicilio(Connection con, int idSucursal, int idSocio, String tipoDomicilio,
						String calle, int numero, String edificio, int piso, String depto,
						String cp, int idLocalidad, int idProvincia, int idPais,
						String strLocalidad, String strProvincia) throws Exception{
		boolean retorno = false;
		String cabeceraMsg = "ActualizacionEMailManager.agregarDomicilio(" + idSucursal + ", " + idSocio + ", " 
					+ tipoDomicilio + ", " + calle + ", " + numero + ", " + edificio + ", " + piso
					+ ", " + depto + ", " + cp + ", " + idLocalidad + ", " + idProvincia + ", " + idPais + ", "
					+ strProvincia + ", " + strLocalidad + ")";
		try {
			tipoDomicilio = DBUtil.buildAddress(new Integer(idSucursal), new Integer(idSocio), tipoDomicilio);
			//TmkLogger.debug("DOMICILIO" + tipoDomicilio);
			try {
				//Connection con = DBUtil.buildConnection();
				//con.setAutoCommit(false);
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" INSERT INTO socios_domicilios ");
					qry.append(" (id_sucursal, id_socio, tipo_domicilio, calle, numero,");
					qry.append(" edificio, piso, depto, cp, id_localidad, id_provincia,");
					qry.append(" id_pais, descripcion_provincia_inex, descripcion_localidad_inex) ");
					qry.append(" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
					
					
					PreparedStatement ps = con.prepareStatement(qry.toString());
					ps.setInt(1, idSucursal);
					ps.setInt(2, idSocio);
					ps.setString(3, tipoDomicilio);
					ps.setString(4, calle);
					
					if (numero == 0) {
						ps.setNull(5, Types.INTEGER);
					} else {
						ps.setInt(5, numero);						
					}
					
					ps.setString(6, edificio);
					
					if (piso == 0) {
						ps.setNull(7, Types.INTEGER);						
					} else {
						ps.setInt(7, piso);
					}
					
					ps.setString(8, depto);
					ps.setString(9, cp);
					
					ps.setInt(10, idLocalidad);						
					
					ps.setInt(11, idProvincia);
					
					ps.setInt(12, idPais);
						
					ps.setString(13, strLocalidad);
					ps.setString(14, strProvincia);
					
					try {
						ps.execute();
						if (ps.getUpdateCount()>0) {
							retorno = true;
						} else {
							retorno =false;
						}
					} catch (java.sql.SQLException e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
						throw new Exception(e);
					} finally {
						ps.close();
					}
					
				} catch (java.sql.SQLException e) {
					TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
					throw new Exception(e);
				} 
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" INSERT INTO buffer_socios_domicilios ");
					qry.append(" (id_sucursal, id_socio, tipo_domicilio, calle, numero,");
					qry.append(" edificio, piso, depto, cp, id_localidad, id_provincia,");
					qry.append(" id_pais) ");
					qry.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
					
					
					PreparedStatement ps = con.prepareStatement(qry.toString());
					ps.setInt(1, idSucursal);
					ps.setInt(2, idSocio);
					ps.setString(3, tipoDomicilio);
					ps.setString(4, calle);
					
					if (numero == 0) {
						ps.setNull(5, Types.INTEGER);
					} else {
						ps.setInt(5, numero);						
					}
					
					ps.setString(6, edificio);
					
					if (piso == 0) {
						ps.setNull(7, Types.INTEGER);						
					} else {
						ps.setInt(7, piso);
					}
					
					ps.setString(8, depto);
					ps.setString(9, cp);
					
					ps.setInt(10, idLocalidad);						
					
					ps.setInt(11, idProvincia);
					
					ps.setInt(12, idPais);
				
					try {
						ps.execute();
						if (ps.getUpdateCount()>0) {
							retorno = (retorno && true);
						} else {
							retorno =false;
						}
					} catch (java.sql.SQLException e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
						throw new Exception(e);
					} finally {
						ps.close();
					}
					
				} catch (Exception e) {
					
				}
				finally {
					//con.close();
				}
			} catch (java.sql.SQLException e) {
				TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
				throw new Exception(e);
			} catch (NamingException e) {
				TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
				throw new Exception(e);
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en obtencion de tipo de domicilio " + e.toString());
			throw new Exception(e);
		}
		return retorno;
	}
	
	////
	
	public static boolean agregarTelefono(Connection con, int idSucursal, int idSocio, String tipoTelefono,
			String codArea, String nroTel, String interno) throws Exception{
		boolean retorno = false;
		String cabeceraMsg = "ActualizacionEMailManager.agregarTelefono(" + idSucursal + ", " + idSocio + ", " 
				+ codArea + ", " + nroTel + ", " + interno + ")";
		try {
			tipoTelefono = DBUtil.buildPhone(new Integer(idSucursal), new Integer(idSocio), tipoTelefono);
			
			try {
				//Connection con = DBUtil.buildConnection();
				
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" INSERT INTO socios_telefonos ");
					qry.append(" (id_sucursal, id_socio, tipo_telefono, cod_area, nro_tel,");
					qry.append(" ext_int)");
					qry.append(" values (?, ?, ?, ?, ?, ?) ");
					
					PreparedStatement ps = con.prepareStatement(qry.toString());
					ps.setInt(1, idSucursal);
					ps.setInt(2, idSocio);
					ps.setString(3, tipoTelefono);
					ps.setString(4, codArea);
					ps.setString(5, nroTel);
					ps.setString(6, interno);
					
					try {
						ps.execute();
						if (ps.getUpdateCount()>0) {
							retorno = true;
						} else {
							retorno = false;
						}
					} catch (java.sql.SQLException e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
						throw new Exception(e);
					} finally {
						ps.close();
					}
					
				} catch (java.sql.SQLException e) {
					TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
					throw new Exception(e);
				} 
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" INSERT INTO buffer_socios_telefonos ");
					qry.append(" (id_sucursal, id_socio, tipo_telefono, cod_area, nro_tel,");
					qry.append(" ext_int)");
					qry.append(" values (?, ?, ?, ?, ?, ?) ");
					
					PreparedStatement ps = con.prepareStatement(qry.toString());
					ps.setInt(1, idSucursal);
					ps.setInt(2, idSocio);
					ps.setString(3, tipoTelefono);
					ps.setString(4, codArea);
					ps.setString(5, nroTel);
					ps.setString(6, interno);
				
					try {
						ps.execute();
						if (ps.getUpdateCount()>0) {
							retorno = (retorno && true);
						} else {
							retorno = false;
						}
						
					} catch (java.sql.SQLException e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
						throw new Exception(e);
					} finally {
						ps.close();
					}
					
				} catch (Exception e) {
					
				}
				finally {
//					con.close();
				}
			} catch (java.sql.SQLException e) {
				TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
				throw new Exception(e);
			} catch (NamingException e) {
				TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
				throw new Exception(e);
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en obtencion de tipo de telefono " + e.toString());
			throw new Exception(e);
		}
		return retorno;
	}
	
	
	
	public static String[] getDatosParaPuntos(String tipoDoc, long nroDoc, int idPais, String sexo) {
		String [] retorno = null;
		String cabeceraMsg = "ActualizacionEMailManager.getDatosParaPuntos(" + tipoDoc + ", " +
		nroDoc + ", " + idPais + ", " + sexo + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT * FROM (");
				qry.append("  SELECT 1 orden, s.id_socio, s.id_sucursal, fc.id_cuenta, fc.id_sucursal");
				qry.append("  id_sucursal_cuenta, ta.nro_tarjeta, fc.id_cuso, fc.componente");
				qry.append("  FROM socios2 s,");
				qry.append("  buffer_fdn_cuentas_x_socios fc,");
				qry.append("  buffer_fdn_tarjetas_x_cuentas tc,");
				qry.append("  buffer_fdn_tarjetas ta");
				qry.append("  WHERE ");
				qry.append("  s.id_socio = fc.id_socio");
				qry.append("  AND s.id_sucursal = fc.id_sucursal_socio");
				qry.append("  AND fc.id_cuenta = tc.id_cuenta");
				qry.append("  AND fc.id_sucursal = tc.id_sucursal_cuenta");
				qry.append("  AND fc.id_cuso = tc.id_cuso");
				qry.append("  AND tc.nro_tarjeta = ta.nro_tarjeta");
				qry.append("  AND s.tipo_doc = ?");
				qry.append("  AND s.nro_doc = ?");
				qry.append("  AND s.nacionalidad = ?");
				qry.append("  AND s.sexo = ?");
				qry.append("  AND ta.estado = 'HA'");
				qry.append("  UNION");
				qry.append("  SELECT 2 orden, s.id_socio, s.id_sucursal, fc.id_cuenta, fc.id_sucursal");
				qry.append("  id_sucursal_cuenta, ta.nro_tarjeta, fc.id_cuso, fc.componente");
				qry.append("  FROM socios2 s,");
				qry.append("  fdn_cuentas_x_socios fc,");
				qry.append("  fdn_tarjetas_x_cuentas tc,");
				qry.append("  fdn_tarjetas ta");
				qry.append("  WHERE ");
				qry.append("  s.id_socio = fc.id_socio");
				qry.append("  AND s.id_sucursal = fc.id_sucursal_socio");
				qry.append("  AND fc.id_cuenta = tc.id_cuenta");
				qry.append("  AND fc.id_sucursal = tc.id_sucursal_cuenta");
				qry.append("  AND fc.id_cuso = tc.id_cuso");
				qry.append("  AND tc.nro_tarjeta = ta.nro_tarjeta");
				qry.append("  AND s.tipo_doc = ? ");
				qry.append("  AND s.nro_doc = ?");
				qry.append("  AND s.nacionalidad = ?");
				qry.append("  AND s.sexo = ?");
				qry.append("  AND ta.estado = 'HA'");
				qry.append("  ORDER BY 1");
				qry.append("  ) WHERE componente < 80 ORDER BY componente");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setString(1, tipoDoc);
				ps.setLong(2, nroDoc);
				ps.setInt(3, idPais);
				ps.setString(4, sexo);
				ps.setString(5, tipoDoc);
				ps.setLong(6, nroDoc);
				ps.setInt(7, idPais);
				ps.setString(8, sexo);
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = new String [5];
							retorno[0] = rs.getString("id_sucursal");
							retorno[1] = rs.getString("id_socio");
							retorno[2] = rs.getString("id_sucursal_cuenta");
							retorno[3] = rs.getString("id_cuenta");
							retorno[4] = rs.getString("nro_tarjeta");
						//	TmkLogger.debug(rs.getString("id_sucursal") + "---" + rs.getString("id_socio") + "---" + rs.getString("id_sucursal_cuenta") + "---" + rs.getString("id_cuenta") + "---" + rs.getString("nro_tarjeta"));
						} 
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
	}
	
	
	public static boolean otorgarPuntos(Connection con, int idSucursal, int idSocio, int idSucursalCuenta, int idCuenta, String nroTarjeta) {
		boolean retorno = false;
		String cabeceraMsg = "ActualizacionEMailManager.otorgarPuntos(" + idSucursal + ", " +
		 + idSocio + ", " + idSucursalCuenta + ", " + idCuenta + ", " + nroTarjeta + ")";
		
		try {
			//Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" INSERT INTO FDN_CTA_CTE_PUNTOS");
				qry.append(" (ID_SUCURSAL, ID_CCPT,");
				qry.append("  ID_SOCIO, ID_SUCURSAL_SOCIO,");
				qry.append("  ID_CUENTA, ID_SUCURSAL_CUENTA,");
				qry.append("  NRO_TARJETA, ID_CONCEPTO,");
				qry.append("  ID_REGLA,");
				qry.append("  PUNTOS, ");
				qry.append("  USR_ALTA, ");
				//qry.append("  F_ALTA,");
				qry.append("  FECHA,");
				qry.append("  SALDO_X_APLICAR, SIGNO_SALDO)");
				qry.append(" VALUES (");
				qry.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				
				ps.setInt(1, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
				ps.setInt(2, DBUtil.getSequenceValue("FDN_ID_CCPT_SEQ").intValue());
				ps.setInt(3, idSocio);
				ps.setInt(4, idSucursal);
				ps.setInt(5, idCuenta);
				ps.setInt(6, idSucursalCuenta);
				ps.setString(7, nroTarjeta);
				ps.setInt(8, Globals.FDN_CONCEPTO_EVENTO);
				ps.setInt(9, Globals.REGLA_FDN_POR_ACTUALIZACION.getId());
				ps.setInt(10, Globals.REGLA_FDN_POR_ACTUALIZACION.getPuntos());
				ps.setString(11, "SITE");
				//ps.setTimestamp(12, new Timestamp(new Date().getTime()));
				ps.setTimestamp(12, new Timestamp(new Date().getTime()));
				ps.setInt(13, Globals.REGLA_FDN_POR_ACTUALIZACION.getPuntos());
				ps.setInt(14, 1);
				
				try {
					ps.execute();
					if (ps.getUpdateCount()>0) {
						retorno = true;
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				//con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
		
	}
	
	public static boolean cerrarActualizacion (long codigo, String estado) {
		boolean retorno = false;
		String cabeceraMsg = "ActualizacionEMailManager.cerrarActualizacion(" + codigo + "," + estado + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" UPDATE actualizacion_mail_extra");
				qry.append(" SET estado = ?");
				qry.append(" WHERE codigo_actualizacion = ?");
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setString(1, estado);
				ps.setLong(2, codigo);
				
				try {
					ps.execute();
					if (ps.getUpdateCount()>0) {
						retorno = true;
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
	}
	
	public static boolean mailEnUso(String eMail) {
		boolean retorno = true;
		String cabeceraMsg = "ActualizacionEMailManager.mailEnUso(" + eMail + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append("  SELECT id_socio");
				qry.append("  FROM socios2");
				qry.append("  WHERE ");
				qry.append("  login = ? OR login = ? OR login =? OR e_mail1 = ?");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setBytes(1, CryptUtil.encriptar(eMail.getBytes()));
				ps.setBytes(2, CryptUtil.encriptar(eMail.toLowerCase().getBytes()));
				ps.setBytes(3, CryptUtil.encriptar(eMail.toUpperCase().getBytes()));
				ps.setString(4, eMail);
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = true;
						} else {
							retorno = false;
						}
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
		
	}
	
	
	public static boolean esActualizacionCerrada (long codigo) {
		boolean retorno = true;
		String cabeceraMsg = "ActualizacionEMailManager.esActualizacionCerrada(" + codigo + ")";
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append("  SELECT estado");
				qry.append("  FROM actualizacion_mail_extra");
				qry.append("  WHERE ");
				qry.append("  codigo_actualizacion = ?");
				
				PreparedStatement ps = con.prepareStatement(qry.toString());
				ps.setLong(1, codigo);
				
				try {
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							if (rs.getString("estado").equals(ESTADO_FINAL) || 
									rs.getString("estado").equals(ESTADO_FINAL_SIN_PUNTOS)) {
								retorno = true;
							} else {
								retorno = false;
							}
						} 
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en Ejecucion de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return retorno;
	}
	///Nuevo para evitar el doble login
	public static SocioPK getSocioFidelizado(String tipoDoc, long nroDoc, int idPais, String sexo) {
		
		String cabeceraMsg = "ActualizacionEMailManager.getSocioFidelizado(" + tipoDoc + ", " + nroDoc + ", " + idPais + ", " + sexo + ")";
		SocioPK socioPK = null;
		try {
			Connection con = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT s.id_socio, s.id_sucursal, login ");
				qry.append(" FROM socios2 s, buffer_fdn_cuentas_x_socios bfc");
				qry.append(" WHERE ");
				qry.append(" s.id_socio = bfc.id_socio");
				qry.append(" AND s.id_sucursal = bfc.id_sucursal_socio");
				qry.append(" AND s.tipo_doc = ?");
				qry.append(" AND s.nro_doc = ?");
				qry.append(" AND s.nacionalidad = ?");
				qry.append(" AND s.sexo = ?");
				qry.append(" UNION ");
				qry.append(" SELECT s.id_socio, s.id_sucursal, login ");
				qry.append(" FROM socios2 s, fdn_cuentas_x_socios bfc");
				qry.append(" WHERE ");
				qry.append(" s.id_socio = bfc.id_socio");
				qry.append(" AND s.id_sucursal = bfc.id_sucursal_socio");
				qry.append(" AND s.tipo_doc = ?");
				qry.append(" AND s.nro_doc = ?");
				qry.append(" AND s.nacionalidad = ?");
				qry.append(" AND s.sexo = ?");
				
				PreparedStatement ps = con.prepareStatement(qry.toString(),  
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ps.setString(1, tipoDoc);
				ps.setLong(2, nroDoc);
				ps.setInt(3, idPais);
				ps.setString(4, sexo);
				ps.setString(5, tipoDoc);
				ps.setLong(6, nroDoc);
				ps.setInt(7, idPais);
				ps.setString(8, sexo);
				try {
					ResultSet rs = ps.executeQuery();
					try {
						boolean tieneLogin = false;
						//si encuentro mas de uno con los mismos datos cambio el que tenga login
						while (rs.next()) {
							tieneLogin = (rs.getBytes("login") != null);
							if (socioPK == null && (rs.isLast() || tieneLogin)) {
								socioPK = new SocioPK(new Integer(rs.getInt("id_sucursal")), new Integer(rs.getInt("id_socio")));
							}
						} 
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "] error en recorrido de RS " + qry.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error(cabeceraMsg + "] error en Ejecucion de ST " + qry.toString() + " " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "] error en seteo de ST " + e.toString());
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.error(cabeceraMsg + "] error en conexión " + e.toString());
		}
		return socioPK;
	}

}