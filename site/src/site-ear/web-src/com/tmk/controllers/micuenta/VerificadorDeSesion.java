package com.tmk.controllers.micuenta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.xml.Resultado;

public class VerificadorDeSesion extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODA LA LOGICA PARA CHEQUEAR SI ESTA O NO LOGUEADO
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");		
		
		boolean estaLogueado = request.getSession().getAttribute("Registracion.socioPK")!=null;		
		Resultado res =  new Resultado(estaLogueado,null,null);
		if(!estaLogueado) {
			request.setAttribute("Registracion.feedback","Su sesion ha cadudado");
			res.setTargetRedirect("/miCuenta");
		}
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		response.getWriter().print(xstream.toXML(res));
	}
}
