package com.tmk.controllers.listas;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.kernel.Convert;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.Resultado;

public class SetArticuloEnLista  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		//socio
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");		
		if(socioPk != null) {
			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());			
			Vector<Object> respuestas = new Vector<Object>();
			int fallaron = 0;
			Integer cantidad = Convert.toNumber(request.getParameter("cantidadDeListas"), 0);
			//articulo
			Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
			for(int i = 0;i < cantidad;i++) {
				//id de la lista
				Integer idLista = Convert.toNumber(request.getParameter("lista"+i), 0);
				//creo el articulo para la lista
				ListasTmkArticulos articuloDeLista = new ListasTmkArticulos(idLista);
				articuloDeLista.setId_articulo(idArticulo);				
				try {
					ServiceLocator.getListasTmkServices().grabarArticulosEnLista(idLista, articuloDeLista);
				} catch (Exception e) {
					fallaron++;
				}
			}
			respuestas.add("Se agregaron "+(cantidad-fallaron)+" articulo/s");
			if(fallaron > 0) {
				respuestas.add("No se agregaron "+(fallaron)+" articulo/s");
			}			
			Resultado res = new Resultado(true,null,null);
			res.setRespuesta(respuestas);
			xstream.alias("resultado", Resultado.class);					
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));			
		}		
	}	
}
