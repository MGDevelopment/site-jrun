package com.tmk.soa.servicios.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.interfaces.CuponService;

public class CuponServiceImpl implements CuponService {

	public boolean esCupon(String cupon) throws Exception{
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer(" SELECT id_categoria FROM categorias WHERE descripcion = ? ");
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				try {
					ps.setString(1, cupon.toUpperCase());
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							return true;
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
		} catch (Exception e) {
			TmkLogger.error("Error en validacion de cheque " + e.toString() + MainHelper.getMessage(e));
		}	
		return false;
	}

	public Date getFecha(String cupon) throws Exception {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer(" SELECT nro, fecha FROM cheques_obsequios WHERE nro = ? ");
				qry.append(" and estado = 'EMITIDO' AND VALOR_AUX_5 = 'VIRTUAL' AND nro not in (SELECT nro FROM cheques_obsequios ");
				qry.append(" WHERE nro = ? AND (estado = 'RECIBIDO' or estado = 'ANULADO')) ");
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				try {
					ps.setString(1, cupon.substring(0, 12));
					ps.setString(2, cupon.substring(0, 12));
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							return rs.getDate("fecha");						
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
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
