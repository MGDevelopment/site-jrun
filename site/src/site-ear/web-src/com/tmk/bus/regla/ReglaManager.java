package com.tmk.bus.regla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import com.tmk.kernel.DBUtil;
import com.tmk.controllers.MainHelper;

public final class ReglaManager {

	public static ReglaClass getReglaByArticulo(int idArticulo) throws Exception {
		ReglaClass regla = null;
		Connection conn = DBUtil.buildConnection();
		StringBuffer qry = new StringBuffer();
		qry.append("SELECT secuencia, id_disponibilidad, estado, descripcion, fecha_desde, fecha_hasta");
		qry.append(" FROM estado_articulos ");
		qry.append(" WHERE id_articulo = ").append(idArticulo);
		try {
			Statement st = conn.createStatement();
			try {
				ResultSet rs = st.executeQuery(qry.toString());
				try {
					if (rs.next()) {
						regla = new ReglaClass (new Integer(idArticulo));
						regla.setSecuencia(new Integer(rs.getInt("secuencia")));
						if (rs.getObject("id_disponibilidad") != null) {
							regla.setIdDisponibilidad(new Integer (rs.getInt("id_disponibilidad")));
						} else {
							regla.setIdDisponibilidad((Integer)(rs.getObject("id_disponibilidad")));
						}	
					
						regla.setEstado(rs.getString("estado"));
						regla.setDescripcion(rs.getString("descripcion"));
						regla.setDesde(rs.getTimestamp("fecha_desde"));
						regla.setHasta(rs.getTimestamp("fecha_hasta"));
					}
				} finally {
					rs.close();
				}
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}
		return regla;
	}
	
	public static void deleteReglaBySecuencia(int secuencia, Connection conn) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" DELETE FROM estado_articulos");
		qry.append(" WHERE secuencia = ").append(secuencia);
		Statement st = conn.createStatement();
		try {
			st.execute(qry.toString());
		} finally {
			st.close();
		}
	}
		
	public static void insertRegla(ReglaClass regla, Connection conn) throws Exception {
		PreparedStatement ps = MainHelper.getInsertToDBByObject(regla, "estado_articulos", conn);
		try {
			ps.execute();
		} finally {
			ps.close();
		}
	}
	
	public static int getSecuencia() throws Exception {
		Connection conn = DBUtil.buildConnection();
		StringBuffer qry = new StringBuffer();
		qry.append("SELECT max(secuencia) secuencia FROM estado_articulos");
		try {
			Statement st = conn.createStatement();
			try {
				ResultSet rs = st.executeQuery(qry.toString());
				try {
					if (rs.next()) {
						return rs.getInt("secuencia") + 1;
					} else {
						throw new Exception ("No se pudo obtener la secuencia de la regla.");
					}
				} finally {
					rs.close();
				}
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}
	}
}
