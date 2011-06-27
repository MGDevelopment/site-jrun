package com.tmk.controllers.comentario;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
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
public class GetComentarioHome extends HttpServlet   {
	
	@SuppressWarnings("unchecked")	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion"),(Integer)null);
		Integer cantidad= Convert.toNumber(request.getParameter("cantidad"),4);
		List<Integer> ids ;			 
		if(idSeccion == null) {
			ids = (LinkedList)ServiceLocator.getComentarioService().getIdsDeComentario(cantidad);
		}else {			
			HashMap<String, Object> pk = new HashMap<String, Object>(1);
			pk.put("idSeccion",idSeccion);
			ids = (List<Integer>)ServiceLocator.getComentarioService().getIdsDeComentario(pk,cantidad);
		}
		if(ids.size() > 0) {
			Collection  comentarios = ServiceLocator.getComentarioService().getComentariosByIds(ids);
			
			Iterator<ComentarioArticulos> itComentarios = comentarios.iterator(); 
			Vector<Hashtable<String, Object>> vecArticulos = new Vector<Hashtable<String,Object>>(5);
			
			while(itComentarios.hasNext()) {
				Hashtable<String, Object> hashArticulos = new Hashtable<String, Object>(7,2);
				
				//obtengo el socio que hizo el ultimo comentario sobre el articulo mas comenatado.			
				ComentarioArticulos com = itComentarios.next();
				Articulo articulo = com.getArticulo();
				
				hashArticulos.put("comentador", com.getNickname()!=null ? com.getNickname() : com.getSocio().getNombres());
				//si tiene mas de  150 caracteres lo corto
				hashArticulos.put("comentario", com.getComentario().length() > 150 ? com.getComentario().substring(0, 100)+"..." : com.getComentario());
				//comentarios para un articulo articulo				
				Vector<Hashtable<String, Object>> vecEstrellas = ServiceLocator.getComentarioService().getEstrellasByCalificacion(com.getEvaluacion(), ConstantesService.getInstance().getEstrellas(ConstantesService.ESTRELLAS_CHICAS));
				hashArticulos.put("calificacionXArticulo", vecEstrellas);
				//hashArticulos.put("titulo",Convert.capitalizar(articulo.getTitulo(),true));
				hashArticulos.put("titulo",Convert.corregir(articulo.getTitulo(), true));
				hashArticulos.put("urlImagen",articulo.getImagen());
				hashArticulos.put("altImagen",articulo.getCls_altImagen());
				String seccion = Globals.seccion(articulo.getCategoria_seccion()).replaceAll("juguetes","pasatiempos");
				hashArticulos.put("class","tapa"+ Convert.capitalizar(seccion,false));
				hashArticulos.put("enSeccion", seccion);
				hashArticulos.put("urlDetalle",articulo.getUrlDetalle());
				//hashArticulos.put("urlLinkASeccion",Globals.seccion(articulo.getCategoria_seccion()).concat("#coment"));
				hashArticulos.put("llevaLineaDivisora",vecArticulos.size() < 3 ? "true": "");
				
				//String idCometnario  = vecArticulos.size()+1+"";
				//hashArticulos.put("index",idCometnario.length()>=2?idCometnario:"0"+idCometnario);
				vecArticulos.add(hashArticulos);
			}		
			//levanto la template de los comentarios
			Template tmpListaArticulo = (Template)ServiceLocator.getTemplateService().getTemplate("tmpComentarioHome");			
			tmpListaArticulo.setParam("articulos", vecArticulos);
			tmpListaArticulo.printTo(response.getWriter());
			
			//XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			//xstream.alias("Resultado", TreeSet.class);					
			//DBO[] listaAux =(DBO[])comentarios.toArray(new DBO[comentarios.size()]);		
			//response.getWriter().print(xstream.toXML(listaAux).replaceAll("com.tmk.dbo.DBO-array", "Resultado"));		//response.getWriter().print(xstream.toXML(listaAux).replaceAll("com.tmk.dbo.DBO-array", "Resultado"));
		}else {
			response.getWriter().print("");
		}
	}

}

