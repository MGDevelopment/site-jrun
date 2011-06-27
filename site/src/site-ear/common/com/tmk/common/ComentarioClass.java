package com.tmk.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;


import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

public class ComentarioClass {
	private int idArticulo;
	private int idComentario;
	private String texto;
	private int evaluacion;
	private Timestamp fecha;
	private String estado;
	private int idSucursalSocio;
	private int idSocio;
	private String nickName;
	private String tituloArticulo;
	private String emailSocio;
	private int idSeccion;
	private String userPopego;

	public ComentarioClass(int idArticulo, int idComentario, String texto, int evaluacion, Timestamp fecha,
		String estado, int idSucursalSocio, int idSocio, String nickName, String tituloArticulo){
		this.idArticulo = idArticulo;
		this.idComentario = idComentario;
		this.texto = texto;
		this.evaluacion = evaluacion;
		this.fecha = fecha;
		this.estado = estado;
		this.idSucursalSocio = idSucursalSocio;
		this.idSocio = idSocio;
		this.nickName = nickName;
		this.tituloArticulo = tituloArticulo;

	}
	public ComentarioClass(int idComentario, int idArticulo) {

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					if (idComentario != 0) {
						qry.append(" SELECT ca.ID_COMENTARIO, ca.ID_ARTICULO, ca.comentario,");
						qry.append(" ca.evaluacion, ca.fecha, ca.estado, ca.id_sucursal_socio, ");
						qry.append(" ca.id_socio, nvl(ca.nickname, s.nombres || ' ' || s.apellidos) nickname, a.titulo");
						qry.append(" FROM COMENTARIO_ARTICULOS ca, socios2 s, articulos a ");
						qry.append(" WHERE ");
						qry.append(" 	ca.id_socio = s.id_socio");
						qry.append(" 	and ca.id_sucursal_socio = s.id_sucursal");
						qry.append(" 	and ca.id_articulo = a.id_articulo");
						qry.append("  	and ca.id_comentario = ").append(idComentario);
						qry.append("  	and ca.id_articulo = ").append(idArticulo);
					} else {
						qry.append(" SELECT a.id_articulo, a.titulo, a.categoria_seccion");
						qry.append(" FROM articulos a ");
						qry.append(" WHERE ");
						qry.append("  	a.id_articulo = ").append(idArticulo);
					}
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						if (rs.next()) {
							if (idComentario != 0) {
								this.idArticulo = rs.getInt("id_articulo");
								this.idComentario = rs.getInt("id_comentario");
								this.texto = rs.getString("comentario");
								this.evaluacion = rs.getInt("evaluacion");
								this.fecha = rs.getTimestamp("fecha");
								this.estado = rs.getString("estado");
								this.idSucursalSocio = rs.getInt("id_sucursal_socio");
								this.idSocio = rs.getInt("id_socio");
								this.nickName = rs.getString("nickname");
								this.tituloArticulo = rs.getString("titulo");
								//this.idSeccion = rs.getInt("categoria_seccion");
							} else {
								this.idArticulo = rs.getInt("id_articulo");
								this.idComentario = idComentario;
								this.texto = "";
								this.evaluacion = 0;
								this.fecha = new Timestamp(new Date().getTime());
								this.estado = "N";
								this.idSucursalSocio = 0;
								this.idSocio = 0;
								this.nickName = "";
								this.tituloArticulo = rs.getString("titulo");
								this.idSeccion = rs.getInt("categoria_seccion");
							}
						}
					} catch (Exception e) {
						TmkLogger.error("ComentarioClass: ComentarioClass(recorrido de rs), " + idComentario + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ComentarioClass: ComentarioClass(ejecucion de qry), " + idComentario + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ComentarioClass: ComentarioClass(creacion de statement), " + idComentario + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ComentarioClass: ComentarioClass(conexion), " + idComentario + e.toString());
		}
	}

	public void setIdArticulo (int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public void setIdComentario (int idComentario) {
		this.idComentario = idComentario;
	}

	public void setTexto (String texto) {
		this.texto = texto;
	}

	public void setEvaluacion (int evaluacion) {
		this.evaluacion = evaluacion;
	}

	public void setFecha (Timestamp fecha) {
		this.fecha = fecha;
	}

	public void setEstado (String estado) {
		this.estado = estado;
	}

	public void setIdSucursalSocio (int idSucursalSocio) {
		this.idSucursalSocio = idSucursalSocio;
	}

	public void setIdSocio (int idSocio) {
		this.idSocio = idSocio;
	}

	public void setNickName (String nickName) {
		this.nickName = nickName;
	}

	public void setTituloArticulo (String tituloArticulo) {
		this.tituloArticulo = tituloArticulo;
	}

	public void setEmailSocio(String emailSocio) {
		this.emailSocio = emailSocio;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public String getEstado () {
		return estado;
	}

	public int getIdSucursalSocio() {
		return idSucursalSocio;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public String getNickName() {
		return nickName;
	}

	public String getTituloArticulo () {
		return tituloArticulo;
	}

	public String getEmailSocio() {
		return emailSocio;
	}

	public int getIdSeccion () {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion= idSeccion;
	}

	public void setUserPopego(String userPopego){
		this.userPopego = userPopego;
	}

	public String getUserPopego(){
		return this.userPopego;
	}

	public static ComentarioClass[] getComentariosPorArticulo(int idArticulo, int cantidad) {
		Vector aux = new Vector();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append( "SELECT * FROM (");
					qry.append(" SELECT ca.ID_COMENTARIO, ca.ID_ARTICULO, ca.comentario,");
					qry.append(" ca.evaluacion, ca.fecha, ca.estado, ca.id_sucursal_socio, ");
					qry.append(" ca.id_socio, nvl(ca.nickname, s.nombres || ' ' || s.apellidos) nickname, a.titulo, a.categoria_seccion, si.identificador");
					qry.append(" FROM COMENTARIO_ARTICULOS ca, socios2 s, articulos a, socios_integracion si ");
					qry.append(" WHERE ");
					qry.append(" 	ca.id_socio = s.id_socio");
					qry.append(" 	and ca.id_articulo = a.id_articulo");
					qry.append(" 	and ca.id_sucursal_socio = s.id_sucursal");
					qry.append(" 	and ca.ID_ARTICULO= ").append(idArticulo);
					qry.append(" 	and (ca.ESTADO = 'A' OR (ca.ESTADO = 'N' AND");
					qry.append("  	ca.FECHA > SYSDATE - (1 / 24 * 1)))");
					qry.append("  	and ca.id_socio = si.id_socio(+)");
					qry.append("  	and ca.id_sucursal_socio = si.id_sucursal(+)");
					qry.append("  	and si.dominio(+) = 'popego.com'");
					qry.append("  ORDER BY ca.FECHA desc");
					qry.append(" )");
					if (cantidad >0) {
						qry.append(" WHERE rownum <=").append(cantidad);
					}
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							ComentarioClass comentario = new ComentarioClass( rs.getInt("id_articulo"),
									rs.getInt("id_comentario"), rs.getString("comentario"), rs.getInt("evaluacion"),
									rs.getTimestamp("fecha"), rs.getString("estado"),
									rs.getInt("id_sucursal_socio"), rs.getInt("id_socio"), rs.getString("nickname"),
									rs.getString("titulo"));
							comentario.setUserPopego(rs.getString("identificador"));
							aux.add(comentario);
						}
					} catch (Exception e) {
						TmkLogger.error("ComentarioClass: getComentariosPorArticulo(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ComentarioClass: getComentariosPorArticulo(ejecucion de qry), " + idArticulo + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ComentarioClass: getComentariosPorArticulo(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ComentarioClass: getComentariosPorArticulo(conexion), " + idArticulo + e.toString());
		}
		return (ComentarioClass [])aux.toArray(new ComentarioClass[aux.size()]);
	}

	public boolean agregar() {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" INSERT INTO comentario_articulos");
				qry.append(" (id_articulo, id_comentario, comentario, evaluacion, fecha, estado,");
				qry.append("  id_sucursal_socio, id_socio, nickname)");
				qry.append(" values(?,?,?,?,?,?,?,?,?)");

				PreparedStatement st = conn.prepareStatement(qry.toString());
				try {
					st.setInt(1, this.idArticulo);
					st.setInt(2, this.idComentario);
					st.setString(3, this.texto);
					st.setInt(4, this.evaluacion);
					st.setTimestamp(5, this.fecha);
					st.setString(6, new String (this.estado));
					st.setInt(7, this.idSucursalSocio);
					st.setInt(8, this.idSocio);
					st.setString(9, this.nickName);
					st.execute();
				} catch (Exception e) {
					TmkLogger.error("ComentarioClass: agregar(ejecucion de st), idArticulo:" + idArticulo + " idComentario:" + idComentario + " " + e.toString());
					return false;
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ComentarioClass: agregar(creacion de statement), idArticulo:" + idArticulo + " idComentario:" + idComentario + " " + e.toString());
				return false;
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ComentarioClass: agregar(conexion), idArticulo:" + idArticulo + " idComentario:" + idComentario + " " + e.toString());
			return false;
		}
		return true;
	}

	public void modificar(Connection conn) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" UPDATE comentario_articulos");
		qry.append(" SET comentario = ?, evaluacion = ?, fecha = ?, estado = ? ");
		qry.append(" WHERE id_articulo = ? and id_comentario = ?");
		
		PreparedStatement st = conn.prepareStatement(qry.toString());
		try {
			st.setString(1, this.texto);
			st.setInt(2, this.evaluacion);
			st.setTimestamp(3, this.fecha);
			st.setString(4, new String(this.estado));
			st.setInt(5, this.idArticulo);
			st.setInt(6, this.idComentario);
			st.execute();
		} finally {
			st.close();
		}
	}

	public static ComentarioClass[] getComentariosPorEstado(String estado) {
		Vector aux = new Vector();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();

					qry.append(" SELECT ca.ID_COMENTARIO, ca.ID_ARTICULO, ca.comentario,");
					qry.append(" ca.evaluacion, ca.fecha, ca.estado, ca.id_sucursal_socio, ");
					qry.append(" ca.id_socio, nvl(ca.nickname, s.nombres || ' ' || s.apellidos) nickname,");
					qry.append(" a.titulo, e_mail1");
					qry.append(" FROM COMENTARIO_ARTICULOS ca, socios2 s, articulos a ");
					qry.append(" WHERE ");
					qry.append(" 	ca.id_socio = s.id_socio");
					qry.append(" 	and ca.id_articulo = a.id_articulo");
					qry.append(" 	and ca.id_sucursal_socio = s.id_sucursal");
					qry.append(" 	and ca.estado = '").append(estado).append("'");
					qry.append("  ORDER BY ca.FECHA");


					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							ComentarioClass comentario = new ComentarioClass( rs.getInt("id_articulo"),
									rs.getInt("id_comentario"), rs.getString("comentario"), rs.getInt("evaluacion"),
									rs.getTimestamp("fecha"), rs.getString("estado"),
									rs.getInt("id_sucursal_socio"), rs.getInt("id_socio"), rs.getString("nickname"),
									rs.getString("titulo"));
									comentario.setEmailSocio(rs.getString("e_mail1"));
							aux.add(comentario);
						}
					} catch (Exception e) {
						TmkLogger.error("ComentarioClass: getComentariosPorEstado(recorrido de rs), " + estado + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ComentarioClass: getComentariosPorEstado(ejecucion de qry), " + estado + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ComentarioClass: getComentariosPorEstado(creacion de statement), " + estado + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ComentarioClass: getComentariosPorEstado(conexion), " + estado + e.toString());
		}
		return (ComentarioClass [])aux.toArray(new ComentarioClass[aux.size()]);
	}


	public static double[] getCantidadDeComentariosYEvaluacion(int idArticulo) {
		double retorno[] = new double[2];
		retorno[0] = 0;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT COUNT(id_comentario) cantidad, SUM(evaluacion) evaluacion  ");
				qry.append(" FROM COMENTARIO_ARTICULOS ");
				qry.append(" WHERE estado = 'A'");
				//qry.append(" AND id_comentario>1");
				qry.append(" AND id_articulo = ? ");

				PreparedStatement ps = conn.prepareStatement(qry.toString());
				ps.setInt(1, idArticulo);
				try {
					ResultSet rs = ps.executeQuery();
					try {
						while (rs.next()) {
							retorno[0] =  rs.getDouble("cantidad");
							if (retorno[0]>0) {
								retorno[1] =  rs.getDouble("evaluacion")/retorno[0];
							}
						}
					} catch (Exception e) {
						TmkLogger.error("ComentarioClass: getCantidadDeComentariosYEvaluacion(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ComentarioClass: getCantidadDeComentariosYEvaluacion(ejecucion de qry), " + idArticulo + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ComentarioClass: getCantidadDeComentariosYEvaluacion(creacion y seteo de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ComentarioClass: getCantidadDeComentariosYEvaluacion(conexion), " + idArticulo + e.toString());
		}
		return retorno;
	}
}