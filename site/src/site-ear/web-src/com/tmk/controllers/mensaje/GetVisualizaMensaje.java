package com.tmk.controllers.mensaje;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tmk.controllers.MainHelper;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.mensaje.MensajeService;

public class GetVisualizaMensaje extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			boolean visualizaMensaje =  MensajeService.getVisualizaMensaje(request);
			out.print("{\"respuesta\": " + visualizaMensaje + "}");
		} catch (Exception e) {
			TmkLogger.error(this.getClass().getName() + "]" + e.toString() + MainHelper.getMessage(e));
			out.print("{\"respuesta\": true}");
		}
	}
}
