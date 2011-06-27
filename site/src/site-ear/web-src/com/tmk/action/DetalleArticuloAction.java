package com.tmk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ArticuloService;

public class DetalleArticuloAction extends Action {

	public DetalleArticuloAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
		Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
		//por si viene de una busqueda elimino de la sesion el objeto de busqueda
		request.getSession().removeAttribute("resultadoBusquedaForm");
		
		if(Globals.esModoRelease()){
			request.setAttribute("idSeccion",idSeccion.toString());
			request.setAttribute("idArticulo",idArticulo.toString());
		}else {
			//modo debug
			try {
				Articulo articulo = null;
				ArticuloService servicio = ServiceLocator.getArticuloService();			
				//obtengo el articulo, sin tener en cuenta los comentarios
				articulo = servicio.getArticuloById(idArticulo);
				request.setAttribute("articulo", articulo);
				if(articulo != null) {
					request.setAttribute("idSeccion", articulo.getCategoria_seccion());
					request.setAttribute("idArticulo", articulo.getId_articulo().toString());
				} else {
					request.setAttribute("idSeccion",Globals.SECCION_GENERAL);
				}
			} catch (Throwable e) {			
				TmkLogger.error("DetalleArticuloAction]" + e.getMessage());
				return mapping.findForward("errorDetalle");
			}						
		}
		return null;
	}
		
}
