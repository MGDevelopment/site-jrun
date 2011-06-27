package com.tmk.controllers.listas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;

public class EliminarArticuloDeLista  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		//socio
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");		
		if(socioPk != null) {
			Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
			Integer idLista = Convert.toNumber(request.getParameter("idLista"), 0);
			//creo el articulo para la lista
			//ListasTmkArticulos articuloDeLista = new ListasTmkArticulos(idLista,idArticulo);
			try {
				ServiceLocator.getListasTmkServices().borrarArticuloEnLista(idLista, idArticulo);
			}catch(Exception e) {
				TmkLogger.error("No se puedo eliminar el articulo id="+idArticulo+"dela lista id="+idLista);
			}
			finally {
				response.sendRedirect(request.getHeader("referer"));
			}
		}else{
			request.getSession().setAttribute("Registracion.feedback","Su sesion ha finalizado.");
			response.sendRedirect("/miCuneta");
		}
	}	
}
