package com.tmk.soa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.Globals;

public class ActualizarCambioFiltro extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idSeccion = Integer.parseInt(req.getParameter("idSeccion"));		
		try {
			Globals.getPaginacionesXFiltro()[idSeccion-1]++;
		}catch (ArrayIndexOutOfBoundsException e) {
			Globals.getPaginacionesXFiltro()[1]++;
		}
		resp.getWriter().print("{\"success\":true}");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
