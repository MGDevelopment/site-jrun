package com.tmk.controllers.registracion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.src.socio.SocioPK;

public class EliminarSessionIntegracion extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		if(socioPk == null) {
			response.sendRedirect("/miCuenta");
			request.getSession().setAttribute("Registracion.feedback", "Tu sesion ha concluido, por favor realiza tu login nuevamente.");
		}
		IntegracionHelper.eliminarSession(request);
	}
}
