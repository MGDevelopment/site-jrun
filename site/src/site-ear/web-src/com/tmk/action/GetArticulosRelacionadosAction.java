package com.tmk.action;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.service.comentario.ComentarioService;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ConstantesService;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.util.HTML.Template;
/**
 * 
 * 	@author oclopez
 *	Con el idArticulo, obtiene una Collection invocando a ArticuloService.getArticulosRelacionados(idArticulo);
 *	
 */
public class GetArticulosRelacionadosAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
	
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		//idArticulo que viene del detalle
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		ArticuloService servicio = ServiceLocator.getArticuloService();		
		Collection colAcrticulo = servicio.getArticulosRelacionados(idArticulo);		
		
		//si no hay articulos
		if(colAcrticulo == null){
			response.getWriter().print("");
		}else {
			//si hay, itero y cargo la template, y todo la logica se desarrolla aca por que
			//le corresponde a la presentacion
			Template tmpObrasRelacionadas = (Template)ServiceLocator.getTemplateService().getTemplate("tmpObrasRelacionadas");
			Iterator itArticulo = colAcrticulo.iterator();
			Vector<Hashtable<String, Object>> vecObras = new Vector<Hashtable<String,Object>>();
			Hashtable<String, Object> hasObras = null;

			while(itArticulo.hasNext()) {
				Articulo articulo = (Articulo)itArticulo.next();
				hasObras = new Hashtable<String, Object>();
				hasObras.put("titulo", Convert.corregir(articulo.getTitulo(), true));
				hasObras.put("precio",Contenido.precioToString(articulo.getPrecio()).replaceAll(" $&nbsp;", "").replaceAll(".-", ""));
				hasObras.put("urlImagen",articulo.getImagen());
				articulo.setUrlDetalle();
				hasObras.put("urlDetalle",articulo.getUrlDetalle());
				
				//comentario x articulo
				double calificacion = 0;// PUEDE SER DE 0 a 5
				// determino la evaluacion
				if (articulo.getComentarioArticulo() != null) {
					calificacion = Convert.redondearAMedio(ComentarioService
										.getCalificacion(articulo.getComentarioArticulo()));					
				}
				/*if (calificacion > 0) {
					hashCalifiacion = new Hashtable<String, String>();
					for (int j = 0; j < (int) calificacion; j++) {
						// son estrellas llenas
						hashCalifiacion.put("estrellaClass", "calificacionStar");
						vecCalificacion.add(hashCalifiacion);
					}
					double estrellasVacias = (calificacion > 0) ? 5 - calificacion : 0;// cuantas estrellas vacias y si hay media o no
					if ((calificacion - (int) calificacion) == 0.5) {
						// si hay media estrella
						hashCalifiacion = new Hashtable<String, String>();
						hashCalifiacion.put("estrellaClass", "calificacionStarMed");
						vecCalificacion.add(hashCalifiacion);
					}
					for (int c = 0; c < (int) estrellasVacias; c++) {
						// estrellas vacias
						hashCalifiacion = new Hashtable<String, String>();
						hashCalifiacion.put("estrellaClass", "calificacionStarDes");
						vecCalificacion.add(hashCalifiacion);
					}			
				}*/
				Vector vecCalificacion = ServiceLocator.getComentarioService().getEstrellasByCalificacion(calificacion,ConstantesService.getInstance().getEstrellas("estrellasChicas"));
				
				hasObras.put("esCalificado", vecCalificacion.size() > 0);
				hasObras.put("calificacionXArticulo",vecCalificacion);
				hasObras.put("idArticulo",""+articulo.getId_articulo());
				vecObras.add(hasObras);
			}
			tmpObrasRelacionadas.setParam("obrasRelacioandas", vecObras);
			response.getWriter().print(tmpObrasRelacionadas.output());
		}	
		return super.execute(mapping, form, request, response);
	}
}
