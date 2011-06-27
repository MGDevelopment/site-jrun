package com.tmk.controllers.listas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.view.model.ListasTmkForm;

public class ModificarListaDeUsuario extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");		
		if(socioPk == null) {
			request.getSession().setAttribute("Registracion.feedback","Su sesion ha finalizado.");
			response.sendRedirect("/miCuenta");
			return;
		}else {
			try {
				ListasTmkForm modelo = (ListasTmkForm) ServiceLocator.getModeloBuilderService().getModelo(ListasTmkForm.class,request);
				//lista actual
				ListasTmk lista = ServiceLocator.getListasTmkServices().findByPk(modelo.getId_lista());
				
				//updateo los valores con los que viene del form
				lista.setPublico(modelo.getPublica());
				lista.setTitulo(modelo.getTitulo());
				lista.setDescripcion(modelo.getDescripcion());
				lista.setCategoria_seccion(Integer.parseInt(modelo.getCategoria_seccion()));
				
				ServiceLocator.getListasTmkServices().update(lista);
				response.sendRedirect(request.getHeader("referer")+"&param="+Math.random());
			} catch (Exception e) {
				TmkLogger.error("Creando lista para socio pk="+socioPk.toString());
				response.sendRedirect(request.getHeader("referer")+"&param="+Math.random());
				return ;
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
