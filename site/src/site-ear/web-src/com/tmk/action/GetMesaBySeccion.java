package com.tmk.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;
/***
 * Levanta la tempalte que contiene los links que van pra seo de google.
 * 
 * @author oclopez
 *
 */
public class GetMesaBySeccion extends Action {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion"),(Integer)null);
		Integer idGrupo = Convert.toNumber(request.getParameter("idGrupo"),(Integer)null);
		Integer idFamilia = Convert.toNumber(request.getParameter("idFamilia"),(Integer)null);
		Integer idSubfamilia = Convert.toNumber(request.getParameter("idSubfamilia"),(Integer)null);
		// http://localhost:8101/contenidosEstaticos/articulos/mesa/listaCatM_MV_sec4__pag1.html?param=0.9449020897716287&_=1273242904080
		StringBuffer archivo = new StringBuffer("listaCatM_MV_sec");
		archivo.append(idSeccion);
		if(idGrupo!=null){
			archivo.append("_").append(idGrupo);
			if(idFamilia!=null){
				archivo.append("_").append(idFamilia);
				if(idSubfamilia!=null){
					archivo.append("_").append(idSubfamilia);
				}
			}
		}
		archivo.append("__pag1.html");
				
		String path = Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_CONTENIDOS_ESTATICOS+ "/articulos/mesa/"+archivo.toString());
		String line = null;
		StringBuffer str = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = null;
			str = new StringBuffer("");
			while((line=br.readLine()) != null) {
				str.append(line);
			}
			str = new StringBuffer(str.toString().replaceAll("\\{", "{respuesta:{"));
			str = new StringBuffer(str.toString().replaceAll("\\}", "}}"));			
			br.close();
		}catch(Exception e) {
			return null;
		}
		String [] lista = str.toString().split("\\[");
		lista =  lista[1].split("\\]");
		StringTokenizer strt = new StringTokenizer(lista[0],",");
		List<Integer> ids =  new ArrayList<Integer>();
		while(strt.hasMoreElements()) {
			String i = (String)strt.nextElement();
			if(i.trim().equals("0")) {
				break;
			}
			ids.add(new Integer(i.trim()));
		}
		if(ids.size() > 0) {
			Collection<Articulo> bos = ServiceLocator.getArticuloService().getListaArticulosParaSEO(ids);
			if(bos!=null && bos.size() > 0) {
				Template tmpSEO = (Template )ServiceLocator.getTemplateService().getTemplate("tmpLinksMesa");
				Vector vecDetalles = new Vector(bos.size());//guarda todos los detalles
				Hashtable hasDetalles = null;		
				Vector vecAutores = null;		
				Iterator<Articulo> itArticulo = bos.iterator();
				while(itArticulo.hasNext()){
					hasDetalles = new Hashtable(bos.size());
					Articulo articulo = itArticulo.next();  
					articulo.setUrlDetalle();
					//hasDetalles.put("urlDetalle", articulo.getUrlDetalle());
					hasDetalles.put("titulo", Convert.corregir(articulo.getTitulo(), true));
					hasDetalles.put("idArticulo", articulo.getId_articulo());
								
					// agrego el/los autores
					if (articulo.getArticuloAutor() != null) {
						vecAutores = new Vector(articulo.getArticuloAutor().length);
						articulo.setUrlBusquedaAutor();// seteo la url como en GetArticuloByIDnvl1
						for (int j = 0; j < articulo.getArticuloAutor().length; j++) {
							Hashtable hashAutores = new Hashtable();
			
							hashAutores.put("autor", Convert.nombrePropio(articulo
									.getArticuloAutor()[j].getAutor().getNombre(articulo.getCategoria_seccion()), false));
							hashAutores.put("urlAutor", articulo.getArticuloAutor()[j]
									.getAutor().getCls_urlBusqueda());
			
							vecAutores.add(hashAutores);
						}
						hasDetalles.put("autores", vecAutores);
						hasDetalles.put("tieneAutor",vecAutores.size() > 0 ? "true" : "");
					}	
					hasDetalles.put("dominio", Globals.DOMINIO_SITIO);
					vecDetalles.add(hasDetalles);
				}		
				tmpSEO.setParam("links", vecDetalles);
				tmpSEO.setParam("dominio", Globals.DOMINIO_SITIO);
				response.getWriter().println(tmpSEO.output());
			}
		}
		return null;
	}
}
