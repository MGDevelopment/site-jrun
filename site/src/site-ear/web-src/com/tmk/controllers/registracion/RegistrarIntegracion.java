package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
//import com.tmk.kernel.DBUtil;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.Resultado;


public class RegistrarIntegracion extends javax.servlet.http.HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
		IOException {
			response.setContentType("text/html;charset=ISO-8859-1");
			response.setHeader("cache-Control","no-cache");
			request.setCharacterEncoding("UTF-8");
			
			SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
			Resultado resultado = null;
			PrintWriter out = response.getWriter();
			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.alias("Resultado", Resultado.class);

			if (socioPK != null) {
				try {
					request.getSession().setAttribute(IntegracionHelper.USERNAME, request.getParameter(IntegracionHelper.USERNAME));
					request.getSession().setAttribute(IntegracionHelper.DOMINIO, request.getParameter(IntegracionHelper.DOMINIO));
					if (IntegracionHelper.esIdentificadorEnUso(request)) {
						resultado = new Resultado(true, new String[] { "AsociadoAOtroUsuario" }, null);
						IntegracionHelper.eliminarSession(request);
					} else {
						resultado = new Resultado(true, new String[] { "Libre" }, null);
					}
				} catch (Exception e) {
					resultado = new Resultado(false, new String[] {"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);
					resultado.setFallaSistema(true);
					IntegracionHelper.eliminarSession(request);
				}
			} else {
				resultado = new Resultado(false, null, null);
				resultado.setTargetRedirect("/miCuenta");
				request.getSession().setAttribute("Registracion.feedback", "Tu sesion ha concluido, por favor realiza tu login nuevamente.");
			}
			out.write(xstream.toXML(resultado).replaceAll("\n", ""));
	}

}