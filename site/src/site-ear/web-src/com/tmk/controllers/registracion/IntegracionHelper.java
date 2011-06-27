package com.tmk.controllers.registracion;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.tmk.bus.socio.SociosIntegracion;
import com.tmk.kernel.DBUtil;
import com.tmk.src.socio.SocioPK;

public final class IntegracionHelper {
	public static final String USERNAME = "username";
	public static final String DOMINIO = "dominio";

	public static boolean esIdentificadorEnUso(HttpServletRequest request) throws Exception{
		Connection conn = DBUtil.buildConnection();
		SociosIntegracion socioIntegracion = new SociosIntegracion();
		try {
			socioIntegracion.select(conn, new String[] {" identificador = '" + request.getSession().getAttribute(USERNAME) + "'",
														" dominio = '" + request.getSession().getAttribute(DOMINIO) + "'",
														" (id_socio <> " + ((SocioPK)request.getSession().getAttribute("Registracion.socioPK")).ID_SOCIO +
														" or id_sucursal <> " + ((SocioPK)request.getSession().getAttribute("Registracion.socioPK")).ID_SUCURSAL + ")"});
			//ESTA EN USO
			return true;
		} catch (Exception e) {
			//ESTA LIBRE
			return false;
		} finally {
			conn.close();
		}
	}

	public static void eliminarSession(HttpServletRequest request){;//,String username,String dominio){
		request.getSession().removeAttribute(USERNAME);
		request.getSession().removeAttribute(DOMINIO);

	}

	//lanza excepcion si no pude integrar el socio
	public static void IntegrarSocio(HttpServletRequest request) throws Exception {
		Connection conn = DBUtil.buildConnection();
		SociosIntegracion socioIntegracion = new SociosIntegracion();
		try {
			socioIntegracion.setId_socio(((SocioPK)request.getSession().getAttribute("Registracion.socioPK")).ID_SOCIO);
			socioIntegracion.setId_sucursal(((SocioPK)request.getSession().getAttribute("Registracion.socioPK")).ID_SUCURSAL);
			socioIntegracion.setIdentificador(request.getSession().getAttribute(USERNAME).toString());
			socioIntegracion.setDominio(request.getSession().getAttribute(DOMINIO).toString());
			try {
				socioIntegracion.update(conn);
			} catch (Exception e) {
				socioIntegracion.insert(conn);
			}
		} finally {
			conn.close();
		}
	}

	public static boolean pendienteDeIntegracion(HttpServletRequest request) {
		return (request.getSession().getAttribute(USERNAME) != null);
	}
}

