package com.tmk.controllers.intranet.disponibilidad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;

public class ActualizarArticulo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArticulo = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ARTICULO), null);
		String habilitadoTematika = Convert.toString(request.getParameter(MainHelper.FIELD_HABILITADO_TEMATIKA), null);
		String idDisponibilidad = Convert.toString(request.getParameter(MainHelper.FIELD_ID_DISPONIBILIDAD), null);
		
		//Actualizar tabla de reglas
		//Actualizar articulo
		//Generar o borrar detalle
	}
	
}
