package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.generacion.ContenidosEstaticos;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;

public class EliminarArticuloGenerado extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArticulo = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ARTICULO), null);
		String idSeccion = Convert.toString(request.getParameter(MainHelper.FIELD_ID_SECCION), null);
		boolean incluido = Convert.toBoolean(request.getParameter(MainHelper.PARAM_INCLUIDO), false);
		String respuesta = "";
		String errorMsg = "<error><msg>Se produjo un error al intentar borrar el articulo generado. Contacte al administrador.</msg></error>";
		String successMsg = "<success><msg>Se ha borrado con exito el articulo generado: ID de Articulo " + idArticulo + "</msg></success>";
		StringBuffer cabecera = new StringBuffer();
		cabecera.append(this.getClass().getName()).append("(idArticulo=").append(idArticulo).append(", idSeccion=").append(idSeccion).append(")]");


		try {
			boolean retorno = ContenidosEstaticos.borrarDetalle(Convert.toNumber(idArticulo, 0)
					, Convert.toNumber(idSeccion, 0));

			if (retorno) {
				respuesta = successMsg;
			} else {
				if (incluido) {
					throw new ServletException();
				} else {
					respuesta = errorMsg;
				}
			}

		} catch (Exception e) {
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


