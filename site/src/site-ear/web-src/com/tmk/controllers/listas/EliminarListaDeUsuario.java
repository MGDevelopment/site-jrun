package com.tmk.controllers.listas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;

public class EliminarListaDeUsuario extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		//pk del socio logueado
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		
		//es es nula la pk?
		if(socioPk != null) {
			Integer idLista = Convert.toNumber(request.getParameter("idLista"), 0);
			try {
				ServiceLocator.getListasTmkServices().delete(new ListasTmk(idLista));
			}catch(Exception e) {
				TmkLogger.error("No se puedo eliminar la lista idLista="+idLista);
			}
			finally {
				//devuelvo al usuario desde donde vino
				response.sendRedirect(request.getHeader("referer"));
			}
		}else{
			request.getSession().setAttribute("Registracion.feedback","Su sesion ha finalizado.");
			response.sendRedirect("/miCuenta");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
