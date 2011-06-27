package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.xml.Resultado;

public class AdministrarIntegracion extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
	 	XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
	 	xstream.alias("Resultado", Resultado.class);
		Resultado resultado = null;		
		try {
			if (IntegracionHelper.pendienteDeIntegracion(request)) {
				if (IntegracionHelper.esIdentificadorEnUso(request)) {
					resultado = new Resultado (false, new String[] {"El usuario esta asociado a otro socio."}, null);
				} else {
					IntegracionHelper.IntegrarSocio(request);
					resultado = new Resultado (true, new String[] {"Se ha integrado correctamente tu usuario de popego."}, null);
					resultado.setTargetRedirect(request.getHeader("referer"));
				}
			}		
		}catch(Exception e) {
			resultado = new Resultado (false, new String[] {"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);			
		}finally {
			IntegracionHelper.eliminarSession(request);
			out.println(xstream.toXML(resultado).replaceAll("\n", ""));
		}
	}
}
