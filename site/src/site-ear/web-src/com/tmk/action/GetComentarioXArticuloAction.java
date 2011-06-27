package com.tmk.action;

import java.util.Hashtable;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ConstantesService;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;

public class GetComentarioXArticuloAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		//PARAMETROS 
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		Integer cantidad = Convert.toNumber(request.getParameter("cantidad"),4);
		try {
			Articulo articulo = ServiceLocator.getArticuloService().getComentariosXArticulo(idArticulo);
			//dentro de este articulo estan todos los cometarios
			if(articulo==null) {
				//al js detalleArticulo.js, cuando devuelva vacio va a ocultar el div de comentarios
				response.getWriter().print("");
				return super.execute(mapping, form, request, response);
			}		

			//comentarios
			//vector para usuarios popego
			Vector<Hashtable<String, Object>> vecUsuario= new Vector<Hashtable<String,Object>>(cantidad<articulo.getComentarioArticulo().length?cantidad:articulo.getComentarioArticulo().length);
			Vector<Hashtable<String, Object>> vecComentarios = new Vector<Hashtable<String,Object>>(cantidad<articulo.getComentarioArticulo().length?cantidad:articulo.getComentarioArticulo().length);
			
			for(int i = 0;articulo.getComentarioArticulo() != null && i < articulo.getComentarioArticulo().length && i < cantidad ;i++){
				Hashtable<String, Object> hashComentarios = new Hashtable<String, Object>(6,1);
				String comentador = articulo.getComentarioArticulo()[i].getNickname();
				if(comentador == null){
					comentador = articulo.getComentarioArticulo()[i].getSocio().getNombres();
				}
				hashComentarios.put("comentador", comentador);
				String userPopego = "";
				if(articulo.getComentarioArticulo()[i].getSocio().getSocioIntegracion() != null){
					userPopego = articulo.getComentarioArticulo()[i].getSocio().getSocioIntegracion().getIdentificador();
				}
				//hashComentarios.put("tienePopego",!userPopego.equals(""));
				//hashComentarios.put("userPopego", userPopego);
				//agrego a los hash popegos
				Hashtable<String, Object> hashUsuario = new Hashtable<String, Object>(5,1);
				if(!userPopego.equals("")) {
					hashComentarios.put("tienePopego",userPopego);
					hashComentarios.put("userPopego", userPopego);
					hashUsuario.put("tienePopego", userPopego);
					hashUsuario.put("userPopego", userPopego);		
				}else{
					hashComentarios.put("tienePopego","");
					hashUsuario.put("tienePopego", userPopego);
				}
				//hashUsuario.put("tienePopego", !userPopego.equals(""));
				//hashUsuario.put("userPopego", userPopego);					
				hashUsuario.put("nickName", comentador);
				hashUsuario.put("id", (i+1));
				vecUsuario.add(hashUsuario);
				//fin
				hashComentarios.put("id", (i+1));
				hashComentarios.put("textoDijo", articulo.getComentarioArticulo()[i].getComentario());
				hashComentarios.put("fechaComentario", Convert.toStringFromDDMMYYYY(articulo.getComentarioArticulo()[i].getF_alta()));
				//estrellas por cada comentario				
				Vector vecEvaluacionXUsuario = ServiceLocator.getComentarioService().getEstrellasByCalificacion(articulo.getComentarioArticulo()[i].getEvaluacion(),ConstantesService.getInstance().getEstrellas("estrellasChicas"));
				hashComentarios.put("calificacionXUsuario", vecEvaluacionXUsuario);
				vecComentarios.add(hashComentarios);
			}
			//levanto la template de los comentarios
			Template tmpListaArticulo = (Template)ServiceLocator.getTemplateService().getTemplate("tmplComentarioXArticulo");
			tmpListaArticulo.setParam("tieneComentarios",vecComentarios.size() > 0);
			if(articulo.getComentarioArticulo()!=null) {
				tmpListaArticulo.setParam("mostrarMasComentarios",articulo.getComentarioArticulo().length > 4 && (cantidad ==4) );
				tmpListaArticulo.setParam("comentarioEvaluacionRestantes",articulo.getComentarioArticulo().length - 4);
				tmpListaArticulo.setParam("cantidad",articulo.getComentarioArticulo().length);
			}else{
				tmpListaArticulo.setParam("mostrarMasComentarios","false");
			}
			tmpListaArticulo.setParam("comentarios",vecComentarios);
			tmpListaArticulo.setParam("usuariosPopego",vecUsuario);
			//idArticulo y idSeccion necesarios para el BOTON AGREGAR COMENTARIOS				
			tmpListaArticulo.setParam("idArticulo",idArticulo);
			response.getWriter().print(tmpListaArticulo.output());
		} catch (Exception e) {			
			TmkLogger.error("GetComentarioXArticuloAction->" + e.getMessage());
		}		
	
	return super.execute(mapping, form, request, response);
	}
}
