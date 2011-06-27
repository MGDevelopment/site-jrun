package com.tmk.action;

//import java.util.Hashtable;
//import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.service.comentario.ComentarioService;
import com.tmk.soa.servicios.ConstantesService;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.util.HTML.Template;

public class GetEvaluacionXArticuloAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		
		//PARAMETROS 	
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		ArticuloService servicio = ServiceLocator.getArticuloService();
		Articulo articulo = servicio.getComentariosXArticulo(idArticulo);
		
		Template tmpEvaluacion = (Template)ServiceLocator.getTemplateService().getTemplate("tmpEvaluacion");
		
		if(articulo != null) {
			double calificacion = 0;// PUEDE SER DE 0 a 5
			//Estrellas llenas,vacias y media estrella	
			if (articulo.getComentarioArticulo() != null) {
				calificacion = Convert.redondearAMedio(ComentarioService
						.getCalificacion(articulo.getComentarioArticulo()));
				//Seteo de la cantidad de comentarios
				tmpEvaluacion.setParam("comentarioEvaluacion", ""+articulo.getComentarioArticulo().length);
				//si hay mas de un comentario muestra "comentario", si no "comentario" 
				tmpEvaluacion.setParam("textoComentario", ((articulo.getComentarioArticulo().length > 1) ? "comentarios" : "comentario"));
				//comentarios x usuario					
				tmpEvaluacion.setParam("tieneComentarios",articulo.getComentarioArticulo().length > 0);
				tmpEvaluacion.setParam("comentarioEvaluacionRestantes",articulo.getComentarioArticulo().length - 4);
				//si tiene mas de 4 comentarios muetro el link para pedir los demas, si nolo oculto
				tmpEvaluacion.setParam("mostrarMasComentarios" ,articulo.getComentarioArticulo().length > 4);
				//tmpEvaluacion.setParam("comentarios",new Vector());
				
				tmpEvaluacion.setParam("esCalificado", "true");
				tmpEvaluacion.setParam("calificaciones", ServiceLocator.getComentarioService().getEstrellasByCalificacion(calificacion, ConstantesService.getInstance().getEstrellas("estrellasGrandes")));
				tmpEvaluacion.setParam("tieneEvaluacion", articulo != null && articulo.getComentarioArticulo() != null);
			}
		}else {						
			tmpEvaluacion.setParam("tieneComentarios","false");
			tmpEvaluacion.setParam("comentarioEvaluacionRestantes",0);
			//si tiene mas de 4 comentarios muetro el link para pedir los demas, si nolo oculto
			tmpEvaluacion.setParam("mostrarMasComentarios" ,"false");
			//tmpEvaluacion.setParam("comentarios",new Vector());
		}
		
		/*tmpEvaluacion.setParam("tieneEvaluacion", articulo != null && articulo.getComentarioArticulo() != null);
		if (calificacion > 0) {
			tmpEvaluacion.setParam("esCalificado", "true");
			//cargo las estrellas, llenas media y vacias.
			tmpEvaluacion.setParam("calificaciones", ServiceLocator.getComentarioService().getEstrellasByCalificacion(calificacion, ConstantesService.getInstance().getEstrellas("estrellasGrandes")));
		}*/
	tmpEvaluacion.setParam("idArticulo",idArticulo);
	response.getWriter().print(tmpEvaluacion.output());
	return null;
	}
}

