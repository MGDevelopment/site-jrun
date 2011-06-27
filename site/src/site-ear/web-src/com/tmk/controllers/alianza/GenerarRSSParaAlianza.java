package com.tmk.controllers.alianza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.Contenido;

public class GenerarRSSParaAlianza extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		try {
			Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), (Integer) null);
			Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");

			if (idAlianza == null) {
				idAlianza = Convert.toNumber(request.getParameter("idAlianza"), (Integer) null);
			}

	        if (idAlianza != null) {
	        	Categoria cat = CategoriaService.getCategoriaEspecifica(new CategoriaPK(new Integer[]{idSeccion}));
		        File file = new File(Contenido.getServletContext().getRealPath("\\rss\\novedadesAlianza" + cat.getDescripcion() + ".xml"));
		        if (file.exists()) {
		        	StringBuffer streamRSS = new StringBuffer("");
		        	BufferedReader ins = new BufferedReader (new FileReader(file));
		        	while (ins.ready()) {
		        		streamRSS.append(ins.readLine());
		        	}
		        	response.setContentType("text/xml");
		        	PrintWriter out = response.getWriter();
		        	out.write(streamRSS.toString().replaceAll("\\{ALIANZA\\}", "--" + idAlianza + "--1"));

		        } else {
		        	session.setAttribute("Extranet.feedback", "En este momento no se encuentran disponibles los feeds vuelva a intentarlo más tarde por favor.");
		        	response.sendRedirect("/main.jsp");

		        }
	        } else {
	        	session.setAttribute("Extranet.feedback", "Ingrese su usuario y clave para acceder al contenido RSS de Novedades de Tematika.com");
	        	response.sendRedirect("/index.jsp");

	        }
		} catch (Exception e) {
			session.setAttribute("Extranet.feedback", "Se ha producido un error por favor, vuelva a intentarlo mas tarde");
			MainHelper.enviarMailDeError("Alianza descarga de RSS " + e.toString() + MainHelper.getMessage(e));
			response.sendRedirect("/index.jsp");
		}
	}
}
