package com.tmk.controllers.listas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.kernel.Convert;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ListasTmkServices;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.Resultado;

public class ActualizarComentarioArticuloEnLista  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		//socio
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		
		Resultado res = null;
		if(socioPk != null) {
			String comentario = request.getParameter(ListasTmkServices.COMENTARIO);
			Integer idLista = Convert.toNumber(request.getParameter(ListasTmkServices.ID_LISTA),0);
			Integer idArticulo = Convert.toNumber(request.getParameter(ListasTmkServices.ID_ARTICULO),0);
			
			ListasTmkArticulos aux = new ListasTmkArticulos(idLista,idArticulo);
			aux.setComentario(comentario);
			try {
				//ServiceLocator.getListasTmkServices().update(aux);
				ServiceLocator.getDboService().update(aux);
				res = new Resultado(true,null,null);
			} catch (Exception e) {
				res = new Resultado(false,new String[]{"No se puedo actualizar el comentario"},null);				
			}
		}else {
			//no esta logueado
			request.getSession().setAttribute("Registracion.feedback","Su sesion ha finalizado.");
			res = new Resultado(false,new String[]{"Su sesión he finalizado"},null);
			res.setTargetRedirect("/miCuenta");			
		}
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("resultado", Resultado.class);
		response.getWriter().println(xstream.toXML(res).replaceAll("\n", ""));
	}	
}
