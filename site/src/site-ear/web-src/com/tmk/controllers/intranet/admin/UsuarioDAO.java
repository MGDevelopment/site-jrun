/**
 * $Log: UsuarioDAO.java,v $
 * Revision 1.2  2003/12/04 17:21:26  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/28 00:22:00  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.1  2003/10/14 06:08:23  GPistoia
 * -Login extranet
 * -Control de seguridad en paginas de extranet
 *
 */
package com.tmk.controllers.intranet.admin;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.DBUtil;
import com.tmk.admin.*;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

	// Identificacion del usuario
	private Integer id;
	private String nombres;
	private String apellidos;

	public static UsuarioDAO login(String login, String password) {
		Integer idUsuario = getIdUsuario(login, password);
		return (idUsuario == null) ? null : new UsuarioDAO(idUsuario);
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	private UsuarioDAO(Integer id) {
		super();
		UsuarioLocal usuarioLocal = load(id);
		this.id = usuarioLocal.getID_USUARIO();
		this.nombres = usuarioLocal.getNOMBRES();
		this.apellidos = usuarioLocal.getAPELLIDOS();
	}

	private UsuarioLocal load(Integer id) {
        try {
	        UsuarioLocalHome usuarioLocalHome = (UsuarioLocalHome)DBUtil.getHome("Usuario");
	        return usuarioLocalHome.findByPrimaryKey(id);
        } catch (Exception e) {
	        TmkLogger.error("Fallo al tratar de cargar el usuario de extranet " + id);
	        return null;
        }
	}

	/**
	 * Determina si tiene acceso a esa funcion
	 */
	public String tieneAcceso(String funcion, char modo, String pagina, String nombre) {
		return tieneAcceso(funcion, modo, pagina, nombre);
	}

	/**
	 * Determina si tiene acceso a esa funcion
	 */
	public String tieneAlgunAcceso(String funcion, String pagina, String nombre) {
		return (tieneAlgunAcceso(funcion)) ? ("<a href=\"" + pagina + "\">" + nombre + "</a>") : nombre;
	}

	/**
	 * Determina si tiene acceso a esa funcion
	 */
	public boolean tieneAcceso(String funcion, char modo) {
		return usuarioTieneAcceso(id, funcion + "_" + modo);
	}

	/**
	 * Determina si tiene acceso a esa funcion
	 */
	public boolean tieneAlgunAcceso(String funcion) {
		return usuarioTieneAcceso(id, funcion);
	}

	/**
	 * Determina si tiene acceso a esa funcion
	 */
	public boolean tieneAlgunAcceso(String funcion1, String funcion2) {
		return tieneAlgunAcceso(funcion1) || tieneAlgunAcceso(funcion2);
	}

	/**
	 * Si el usuario de extranet tiene acceso
	 */
	public static final boolean usuarioTieneAcceso(Integer idUsuario, String funcion) {
		try {
			Connection connection = DBUtil.buildConnection();
			try {
				String sql =
					"select f.* " +
					"  from FUNCION_X_ROL_APLICACION f, USUARIO_X_ROL_APLICACION r, USUARIO_APLICACION u" +
					"  where u.ID_USUARIO = " + idUsuario.intValue() +
					"  and r.ID_USUARIO = u.ID_USUARIO " +
					"  and f.ROL = r.ROL" +
					"  and f.FUNCION LIKE '" + funcion + "%'" +
			        "  and f.ESTADO = 1" +
					"  and r.ESTADO = 1" +
					"  and u.ESTADO = 1";
				CallableStatement statement = connection.prepareCall(sql);
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						return resultSet.next();

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar la informacion para Usuario " + idUsuario + " Funcion " + funcion);
			return false;
		}
	}

	/**
	 * Si el usuario de extranet tiene acceso
	 */
	public static final Integer getIdUsuario(String login, String password) {
		try {
			Connection connection = DBUtil.buildConnection();
			try {
				CallableStatement statement = connection.prepareCall(
				        "select ID_USUARIO from USUARIO_APLICACION where NOMBRES = UPPER(?) and APELLIDOS = UPPER(?)");
/*				        "select ID_USUARIO from USUARIO_APLICACION where LOGIN = ? and PASSWORD = ?");
				try {
					byte[] param1 = (login == null) ? null : login.getBytes();
					byte[] param2 = (password == null) ? null : password.getBytes();

					int index = 0;
					statement.setBytes(++index, CryptUtil.encriptar(param1));
					statement.setBytes(++index, CryptUtil.encriptar(param2));*/

				try {
					int index = 0;
					statement.setString(++index, login);
					statement.setString(++index, password);
					ResultSet resultSet = statement.executeQuery();
					try {
						return (resultSet.next()) ? new Integer(resultSet.getInt("ID_USUARIO")) : null;

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar la informacion para Usuario " + login);
			return null;
		}
	}
}
