package com.tmk.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutorBiografia;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.kernel.Convert;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;

public class GetBiografiaByIdArticulo extends Action {
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");		
		PrintWriter out = response.getWriter();
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		
		Articulo articulo = ServiceLocator.getArticuloService().getBiografiaByIdArticulo(idArticulo);
		//BIOGGRAFIAS
		StringBuffer biografias = new StringBuffer("");		
		for(int i=0;i<articulo.getAutor().length;i++) {
			String biografiaArchivo = ArticuloManager.getBiografiaArchivo(
					articulo.getId_articulo(), articulo.getAutor()[i].getId_autor(), Contenido.getServletContext());
			//si tiene biografia de archivo
			if(biografiaArchivo != null && biografiaArchivo.length() > 0){
				biografias.append(Convert.nombrePropio(
						articulo.getAutor()[i].getAutor().getNombre(articulo.getCategoria_seccion())));
				biografias.append("<BR>");
				biografias.append(biografiaArchivo);
				continue;
			}else{					
				//si tiene en base
				ArticuloAutorBiografia[] biografia = articulo.getAutor()[i].getBiografia(); 
				if(biografia!=null){
					biografias.append(articulo.getAutor()[i].getAutor().getNombre(articulo.getCategoria_seccion()));
					biografias.append("<br>");
					for(int c=0;c < biografia.length;c++){
						biografias.append(biografia[i].getTexto());
					}
				}
			}
		}
		out.println(biografias.toString());
		//FIN BIOGRAFIAS		

		return null;
	}
}
