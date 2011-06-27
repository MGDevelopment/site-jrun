package com.tmk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;
/***
 * Levanta la tempalte de modulo extra, y setea losd datos correspondientes.
 * 
 * @author oclopez
 *
 */
public class GetModuloExtraAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		/*PARAMETROS */
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		try {
			Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),(Integer)null);
			double  precio = Double.parseDouble(request.getParameter("precio"));
			boolean estaDisponible = request.getParameter("estaDisponible").equals("true");
			int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),1);
			
			Template tmplModuloExtra = (Template)ServiceLocator.getTemplateService().getTemplate("tmpModuloExtra");
			tmplModuloExtra.setParam("precioFinal",Contenido.precioToString(precio));
			tmplModuloExtra.setParam("precioFinalDolar", Contenido.precioDollarToString(precio));
			tmplModuloExtra.setParam("precioFinalEuro", Contenido.precioEuroToString(precio));

			tmplModuloExtra.setParam("idArticulo", ""+idArticulo);
			tmplModuloExtra.setParam("puntosExtra", DBUtil.getPuntos(precio));
			tmplModuloExtra.setParam("estaDisponible", estaDisponible?"true":"");
			if(idSeccion == 3) {
				tmplModuloExtra.setParam("enSeccion", "Pasatiempos");
			}else {
				tmplModuloExtra.setParam("enSeccion", Convert.capitalizar(Globals.seccion(idSeccion),false));
			}
			Template tmplMensajesModuloExtra = (Template)ServiceLocator.getTemplateService().getTemplate("tmpMensajesModuloExtra");
			tmplModuloExtra.setParam("mensajesModuloExtra", tmplMensajesModuloExtra.output());
			response.getWriter().print(tmplModuloExtra.output());
		}catch (Exception e) {
			TmkLogger.error("GetModuloExtraAction]" + e);			
		}
		return super.execute(mapping, form, request, response);
	}
}
