package com.tmk.controllers.fidelizacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.fidelizacion.MarcaDeVehiculoDAO;
import com.tmk.fidelizacion.ModeloDeVehiculoDAO;
import com.tmk.kernel.Convert;


public class GetModelosVehiculos extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter(); 
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver()); 
		ModeloDeVehiculoDAO modelo[] = null;
		String marcaVehiculo = Convert.toString(request.getParameter("marcaVehiculo"), null);
		if (marcaVehiculo != null) {
			MarcaDeVehiculoDAO marca = MarcaDeVehiculoDAO.get(marcaVehiculo); 
			modelo = marca.getModelos();
			
		} 
		out.print(xstream.toXML(modelo).replaceAll("com.tmk.fidelizacion.ModeloDeVehiculoDAO-array", "modelo"));
	}
}
