package com.tmk.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.kernel.Convert;
import com.tmk.setup.Contenido;

public class GetPrimerCapitulo extends Action {
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");		
		PrintWriter out = response.getWriter();
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		
		if(ArticuloManager.tienePrimerCapitulo(idArticulo, Contenido.getServletContext())){
			out.print(ArticuloManager.getPrimerCapitulo(idArticulo, Contenido.getServletContext()));
		}
		return null;
	}
}
