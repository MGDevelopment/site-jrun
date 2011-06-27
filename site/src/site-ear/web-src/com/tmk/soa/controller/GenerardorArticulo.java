package com.tmk.soa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.generacion.articulo.GeneradorDeArticulo;
import com.tmk.kernel.Convert;
import com.tmk.soa.servicios.ServiceLocator;

public class GenerardorArticulo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
		Integer idSeccion = null;
		try {
			idSeccion = ServiceLocator.getArticuloService().getDatosPrincipal(idArticulo).getCategoria_seccion();
		} catch (Exception e) {
			request.getSession().setAttribute("generacionDetalleError", "Se produjo un error al intentar generar el articulo. Contacte al administrador: ID de Articulo " + idArticulo );
			return;
		}
		if(idArticulo != null && idArticulo > 0){
			GeneradorDeArticulo.generarDetalleRediseno(idArticulo,idSeccion);
			//response.getWriter().print("{resultado:\"true\",\"idArticulo\":"+idArticulo+"}");
			request.getSession().setAttribute("generacionDetalleOK", "Se ha generado con exito el articulo: ID de Articulo " + idArticulo );
		}else{
			//response.getWriter().print("{resultado:\"false\",\"idArticulo\":"+idArticulo+"}");
			request.getSession().setAttribute("generacionDetalleError", "Se produjo un error al intentar generar el articulo. Contacte al administrador: ID de Articulo " + idArticulo );
		}	
		response.sendRedirect("/236-TMK/generacion/generacionDetallesArticulosNuevo.jsp");
		return ;
		
	}

}


