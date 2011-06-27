package com.tmk.controllers.regla;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.bus.regla.ReglaManager;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

public class EliminarRegla extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection conn = (Connection)request.getAttribute("conn");
		String secuencia = Convert.toString(request.getParameter(MainHelper.FIELD_SECUENCIA), null);
		boolean incluido = Convert.toBoolean(request.getParameter(MainHelper.PARAM_INCLUIDO), false);
		StringBuffer cabecera = new StringBuffer();
		cabecera.append(this.getClass().getName()).append("(secuencia=").append(secuencia).append(", incluido=").append(incluido).append(")]");
		String respuesta = "";
		String errorMsg = "<error><msg>Se produjo un error al intentar eliminar la regla (secuencia " + secuencia + "). Contacte al administrador.</msg></error>";
		String successMsg = "<success><msg>Se ha eliminado con exito la regla (secuencia " + secuencia + ").</msg></success>";
		
		try {
			if (conn == null) {
				conn = DBUtil.buildConnection();
			}
			try {
				if (!incluido) {
					conn.setAutoCommit(false);
				}	
				ReglaManager.deleteReglaBySecuencia(Convert.toNumber(secuencia, 0), conn);
				if (!incluido) {
					conn.commit();
				}
				respuesta = successMsg; 
			} catch (Exception e) {
				TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
				if (incluido) {
					throw new ServletException();
				} else {
					respuesta = errorMsg;
					conn.rollback();
				}
			} finally {
				if (!incluido) {
					conn.close();
				}	
			}
		} catch(Exception e) {
			TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
			if (incluido) {
				throw new ServletException();
			} else {
				respuesta = errorMsg;
			}
		}
		if (!incluido) {
			response.setContentType("text/xml");
			PrintWriter out = response.getWriter(); 
			out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			out.print(respuesta);
			out.close();
		}
	}	
}
