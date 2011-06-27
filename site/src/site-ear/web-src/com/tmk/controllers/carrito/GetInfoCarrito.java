package com.tmk.controllers.carrito;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.tmk.kernel.Convert;
import com.tmk.orden.OrdenDAO;

public class GetInfoCarrito extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		StringBuffer JSONCarrito = new StringBuffer("");

		if (ordenDAO != null) {
			JSONCarrito.append("{\"Carrito\": {\"cantidad\":").append(ordenDAO.getCantidadArticulosEnTotal());
			JSONCarrito.append(", \"total\":").append(ordenDAO.totalSitioCompleto()).append("}}");
		} else {
			JSONCarrito.append("{\"Carrito\": {\"cantidad\":0");
			JSONCarrito.append(", \"total\":0}}");
		}
		out.print(JSONCarrito.toString());
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
