/**
 * $Log: ReporteReferido.java,v $
 * Revision 1.3  2008/05/30 16:03:22  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.2  2005/10/14 16:05:27  omsartori
 * - Correccion en grabacion de orden de referente
 *
 * Revision 1.1  2005/09/06 13:29:35  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 */
package com.tmk.referido;

import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;

import javax.naming.NamingException;
import java.util.Vector;
import java.util.Iterator;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class ReporteReferido {

/* mail de referente + cantidad de referidos del dia anterior por dia*/
	public static final Vector referidosXDia() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT login, count(codigo_referido) referidos" +
				" FROM referido r inner join socios2 s " +
				" ON r.id_socio_referente = s.id_socio " +
				" AND r.id_sucursal_referente = s.id_sucursal" +
				" WHERE trunc(r.fecha) = trunc(sysdate)-1 " +
				" GROUP BY login" +
				" ORDER BY referidos desc"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(2);
						fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("login"))));
						fila.add(new Integer (resultSet.getInt("referidos")));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}


	/* Nombre Apellido mail y fecha de referencia de los referidos no registrados */
	public static final Vector referidosNoRegistrados() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT apellido_referido, nombre_referido, email_referido, fecha" +
				" FROM referido " +
				" WHERE estado =  1" +
				" ORDER BY fecha desc"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(4);
						fila.add(Convert.toString(resultSet.getTimestamp("fecha")));
						fila.add(resultSet.getString("email_referido"));
						fila.add(Convert.nombrePropio(resultSet.getString("apellido_referido")));
						fila.add(Convert.nombrePropio(resultSet.getString("nombre_referido")));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}


	/* Referidos registrados sin compras o con compras sin aprobacion */
	public static final Vector referidosRegistrados() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT s.nombres, s.apellidos, s.login, s.f_alta, o.fecha" +
				" FROM referido r" +
				" INNER JOIN socios2 s" +
				" ON r.id_socio_referido = s.id_socio" +
				" AND r.id_sucursal_referido = s.id_sucursal" +
				" LEFT JOIN orden o" +
				" ON r.id_orden_referido = o.id_orden" +
				" WHERE  r.estado = 2 or r.estado =3" +
				" ORDER BY o.fecha desc, s.f_alta desc"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(5);
						fila.add(Convert.toString(resultSet.getTimestamp("fecha")));
						fila.add(Convert.toString(resultSet.getTimestamp("f_alta")));
						fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("login"))));
						fila.add(Convert.nombrePropio(resultSet.getString("apellidos")));
						fila.add(Convert.nombrePropio(resultSet.getString("nombres")));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}


	/* Referidos con compra aprobada + monto de compra */
	public static final Vector referidosCompraAprobada() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT o.fecha, s.login, s.apellidos, s.nombres, o.total" +
				" FROM referido r" +
				" INNER JOIN orden o" +
				" ON r.id_orden_referido = o.id_orden" +
				" INNER JOIN socios2 s" +
				" ON s.id_socio = o.id_socio" +
				" AND s.id_sucursal = o.id_sucursal_socio" +
				" WHERE r.estado = 4"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(5);
						fila.add(Convert.toString(resultSet.getTimestamp("fecha")));
						fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("login"))));
						fila.add(Convert.nombrePropio(resultSet.getString("apellidos")));
						fila.add(Convert.nombrePropio(resultSet.getString("nombres")));
						fila.add(resultSet.getString("total"));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

/* Referidos con compra aprobada + monto de compra */
	public static final Vector referenteBeneficio() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT r.id_socio_referente, r.id_sucursal_referente," +
					" s.login loginReferente, s.nombres, s.apellidos," +
					" email_referido, s2.login loginReferido, r.estado" +
				" FROM referido r" +
				" INNER JOIN socios2 s" +
				" ON r.id_socio_referente = s.id_socio" +
				" AND id_sucursal_referente = s.id_sucursal" +
				" LEFT JOIN socios2 s2" +
				" ON r.id_socio_referido = s2.id_socio" +
				" AND r.id_sucursal_referido = s2.id_sucursal" +
				" ORDER by r.id_socio_referente, r.id_sucursal_referente, r.estado desc"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						int idSocRs = resultSet.getInt("id_socio_referente");
						int idSucRs = resultSet.getInt("id_sucursal_referente");

						Vector fila = new Vector(5);
						fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("loginReferente"))));
						fila.add(Convert.nombrePropio(resultSet.getString("apellidos")));
						fila.add(Convert.nombrePropio(resultSet.getString("nombres")));
						fila.add(getBeneficioReferente(new Integer (idSocRs), new Integer (idSucRs)));
						if (resultSet.getBytes("loginReferido") != null) {
							fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("loginReferido"))));
						} else {
							fila.add(resultSet.getString("email_referido"));
						}
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

   /* Compras de los referentes por mes*/
	public static final Vector referenteCompras() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				"SELECT s.nombres, s.apellidos, s.login, o.total, o.fecha, s.id_socio, s.id_sucursal" +
				" FROM referente_orden ro" +
			    " INNER JOIN orden o" +
				" ON ro.id_orden_referente = o.id_orden" +
				" INNER JOIN socios2 s" +
				" ON o.id_socio = s.id_socio" +
				" AND o.id_sucursal_socio = s.id_sucursal" +
				" ORDER BY s.id_socio, s.id_sucursal"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					int idSocRs = 0;
					int idSucRs = 0;
					while (resultSet.next()) {
						Vector fila = new Vector(5);
						if (idSocRs != resultSet.getInt("id_socio") || idSucRs != resultSet.getInt("id_sucursal")) {
							fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("login"))));
							fila.add(Convert.nombrePropio(resultSet.getString("apellidos")));
							fila.add(Convert.nombrePropio(resultSet.getString("nombres")));
							idSocRs = resultSet.getInt("id_socio");
							idSucRs = resultSet.getInt("id_sucursal");
						} else {
							fila.add("");
							fila.add("");
							fila.add("");
						}
						fila.add(resultSet.getTimestamp("fecha"));
						fila.add(resultSet.getString("total"));

						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}



	private static String getBeneficioReferente(Integer idSocio, Integer idSucursal) {
		String beneficio = "";
		if (!Globals.referidoHabilitado()) {
			return beneficio;
		}
		if (idSocio == null || idSucursal == null) {
			return beneficio;
		}

		try {
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			Iterator referidos = referidoLH.findBySocioReferenteEstado (idSocio, idSucursal, "4").iterator();
			ReferidoLocal referido = (ReferidoLocal) referidos.next();
			 if (referido.getFECHA_VENC_REFERENTE().after(new Date())) {

				beneficio =  referido.getBENEF_REFERENTE();


			 }
		} catch(Exception e) {

		}
		return beneficio;
	}




}




