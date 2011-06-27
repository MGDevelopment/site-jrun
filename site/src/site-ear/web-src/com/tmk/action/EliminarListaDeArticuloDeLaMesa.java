package com.tmk.action;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.kernel.Convert;
import com.tmk.soa.bo.ArticuloRecomendadoTematika;
import com.tmk.soa.persistencia.ConnectionProvider;

/**
 * 
 * 	@author oclopez
 *	Con el idArticulo, obtiene una Collection invocando a ArticuloService.getArticulosRelacionados(idArticulo);
 *	
 */
public class EliminarListaDeArticuloDeLaMesa extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		//chequeo sesion
		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);
		if(usuarioDAO == null) {
			mapping.findForward("frwHomeIntranet");
		}
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		//idArticulo que viene del detalle
		Integer idArticulo = null;
		String posicion = null;
		String agrupacion = "";
		String filtros = "";
		boolean eliminar = false;
		String  forward = "frwAgregado";
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		Connection conn = null;
		try {
			for(int i=0;i<cantidad;i++) {
				eliminar = (request.getParameter("eliminar"+i)!=null && request.getParameter("eliminar"+i).equals("true"));
				if(eliminar) {
					idArticulo = Convert.toNumber(request.getParameter("idArticulo"+i),0);
					posicion = request.getParameter("posicion"+i);
					agrupacion = request.getParameter("agrupacion"+i);
					filtros = request.getParameter("filtro"+i);
					ArticuloRecomendadoTematika artMesa = new ArticuloRecomendadoTematika();
					artMesa.setId_articulo(idArticulo);
					artMesa.setEn_filtro(filtros);
					artMesa.setAgrupacion(agrupacion);
					artMesa.setPosicion(new Integer(posicion));
		
					conn = ConnectionProvider.getConection();
					conn.setAutoCommit(false);
					artMesa.delete(conn);
					conn.commit();								
				}
			}
		}catch (Exception e) {
			conn.rollback();			
		}			
		finally{
			conn.close();
			agrupacion = null;
			filtros = null;
			usuarioDAO = null;
		}
		
		return mapping.findForward(forward);
	}
	
}
