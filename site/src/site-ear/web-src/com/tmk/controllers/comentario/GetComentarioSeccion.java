package com.tmk.controllers.comentario;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.soa.servicios.ConstantesService;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;

/***
 * Levanta la tempalte de modulo extra, y setea losd datos correspondientes.
 * 
 * @author oclopez
 *
 */
public class GetComentarioSeccion extends HttpServlet  {
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		Integer cantidad= Convert.toNumber(request.getParameter("cantidad"),1);
		Integer idSeccion= Convert.toNumber(request.getParameter("idSeccion"),1);
		
		HashMap<String, Object> pk = new HashMap<String, Object>(4);
		pk.put("idSeccion",idSeccion);
		pk.put("idGrupo",Convert.toNumber(request.getParameter("idGrupo"),(Integer)null));
		pk.put("idFamilia",Convert.toNumber(request.getParameter("idFamilia"),(Integer)null));
		pk.put("idSubFamilia",Convert.toNumber(request.getParameter("idSubFamilia"),(Integer)null));			

 		List<Integer> ids  = (List<Integer>)ServiceLocator.getComentarioService().getIdsDeComentario(pk,cantidad);
		if(ids.size() > 0) {
			Collection  comentarios = ServiceLocator.getComentarioService().getComentariosByIds(ids);		
			Iterator<ComentarioArticulos> itComentarios = comentarios.iterator(); 
			
			Template tmpListaArticulo = (Template)ServiceLocator.getTemplateService().getTemplate("tmpComentarioSeccionBloque");
			Vector vecArticulos = null;
			int i = 0;
			while((vecArticulos = getVectorDeComentario(itComentarios)).size() == 3 ){
				tmpListaArticulo.setParam("articulosFila"+i, vecArticulos);
				i++;
			}
			tmpListaArticulo.setParam("articulosFila"+i, vecArticulos);
			tmpListaArticulo.printTo(response.getWriter());			
		}else {
			response.getWriter().print("");
		}	
	}
	/**
	 * Setea cada fila de comentario en las secciones, a firencia de la home que sola hay una fila de cometarios
	 * @param itComentarios
	 * @return
	 */
	private Vector getVectorDeComentario(Iterator<ComentarioArticulos> itComentarios) {
		Hashtable<String, Object> hashArticulos = null;
		Vector<Hashtable<String, Object>> vecArticulos = new Vector<Hashtable<String,Object>>(3);
		//levanto la template de los comentarios
		
		while(itComentarios.hasNext() && vecArticulos.size() < 3) {
			hashArticulos = new Hashtable<String, Object>(10,0.9f);
			
			//obtengo el socio que hizo el ultimo comentario sobre el articulo mas comenatado.			
			ComentarioArticulos com = itComentarios.next();
			Articulo articulo = com.getArticulo();
						
			double calificacion =com.getEvaluacion();
			
			Vector vecEstrellas = ServiceLocator.getComentarioService().getEstrellasByCalificacion(calificacion,ConstantesService.getInstance().getEstrellas(ConstantesService.ESTRELLAS_CHICAS));
			hashArticulos.put("idArticulo", articulo.getId_articulo());
			hashArticulos.put("comentador", com.getNickname()!=null ? com.getNickname() : com.getSocio().getNombres());
			//si tiene mas de  150 caracteres lo corto
			hashArticulos.put("comentario", com.getComentario().length() > 100 ? com.getComentario().substring(0, 100)+"..." : com.getComentario());			
			hashArticulos.put("calificacionXArticulo", vecEstrellas);
			//hashArticulos.put("titulo",Convert.capitalizar(articulo.getTitulo(),true));
			hashArticulos.put("titulo",Convert.corregir(articulo.getTitulo(), true));
			hashArticulos.put("urlImagen",articulo.getImagen());
			hashArticulos.put("altImagen",articulo.getCls_altImagen());
			String seccion = Globals.seccion(articulo.getCategoria_seccion()).replaceAll("juguetes","pasatiempos");
			hashArticulos.put("class","tapa"+ Convert.capitalizar(seccion,false));
			hashArticulos.put("urlDetalle",articulo.getUrlDetalle());
			hashArticulos.put("llevaLineaDivisora",vecArticulos.size() < 2 ? "true": "");
			hashArticulos.put("enSeccion", seccion);
			vecArticulos.add(hashArticulos);
		}
		return vecArticulos;
	}
}

