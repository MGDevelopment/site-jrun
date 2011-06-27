package com.tmk.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.bo.ArticuloRecomendadoTematika;
import com.tmk.soa.persistencia.ConnectionProvider;

/**
 * 
 * 	@author oclopez
 *	Con el idArticulo, obtiene una Collection invocando a ArticuloService.getArticulosRelacionados(idArticulo);
 *	
 */
public class EliminarArticuloDeLaMesa extends Action {

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
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		String agrupacion = request.getParameter("agrupacion");
		String filtros = request.getParameter("filtros");
		String  forward = "frwAgregado";
	
		//existe el articulo?
		if(!existeArticulo(idArticulo)){
			StringBuffer msg =  new StringBuffer("<p align=\"center\" style=\"color:red\">");
			msg.append("El articulo que desea quitar no esta en la lista");
			msg.append("</p>");
			request.setAttribute("msgErrorDelete", msg.toString());
			return mapping.findForward(forward);
		}
		
		ArticuloRecomendadoTematika artMesa = new ArticuloRecomendadoTematika();
		artMesa.setId_articulo(idArticulo);
		artMesa.setEn_filtro(filtros);
		artMesa.setAgrupacion(agrupacion);		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConection();
			conn.setAutoCommit(false);
			artMesa.delete(conn);
			conn.commit();
			StringBuffer msg =  new StringBuffer("<p align=\"center\" style=\"color:green\">");
			msg.append("Articulo ").append(idArticulo).append(" ELIMINADO " );
			msg.append(" a la agrupacion ").append(agrupacion).append(" y  filtro ").append(filtros);
			msg.append("</p>");
			request.setAttribute("msgErrorDelete", msg.toString());
		}catch (Exception e) {
			conn.rollback();
			StringBuffer msg =  new StringBuffer("<p align=\"center\" style=\"color:red\">");
			msg.append(" El Articulo ").append(idArticulo).append(" NO SE PUEDO ELIMINAR de ");
			msg.append(agrupacion).append(" y filtro ").append(filtros);
			msg.append("</p>");
			request.setAttribute("msgErrorDelete", msg.toString());
			TmkLogger.error("Eliminando articulo recomendado " + e);
		}
		finally {
			conn.close();
			agrupacion = null;
			artMesa = null;
			filtros = null;
			usuarioDAO = null;
		}
		return mapping.findForward(forward);
		/*ArticuloRecomendado articulo = new ArticuloRecomendado(idArticulo.intValue(),posicion.intValue(),true);
		ArticulosRecomendadosWrapper artReco = new ArticulosRecomendadosWrapper();
		artReco.addArticuloRecomendado(articulo, enLista);
		
		articulo = new ArticuloRecomendado(2,2,true);		
		artReco.addArticuloRecomendado(articulo, "musica");
		
		articulo = new ArticuloRecomendado(5,1,true);		
		artReco.addArticuloRecomendado(articulo, "peliculas");
		
		articulo = new ArticuloRecomendado(4,1,true);		
		artReco.addArticuloRecomendado(articulo, "libros");
		//XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
		    public HierarchicalStreamWriter createWriter(Writer writer) {
		        return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
		    }
		});
		//xstream.addImplicitCollection(ArticulosRecomendadosWrapper.class, "articulosRecomendados");
		String res = xstream.toXML(artReco).replaceAll("\n", "");
		response.getWriter().print(res);*/
		//return super.execute(mapping, form, request, response);
	}
	
	private Integer getSeccionDeArticulo(Integer idArticulo) throws Exception {
		Connection conn = null;
		Statement stm = null;
		Integer res = -1;
		try{
			conn = ConnectionProvider.getConection();
			stm = conn.createStatement();			
			ResultSet rst = stm.executeQuery("Select categoria_Seccion from articulos where id_articulo = "+idArticulo);
			if(rst.next()) {
				res =  rst.getInt("categoria_seccion");
			}
		}catch (Exception e) {
			throw e;
		}finally{
			stm.close();
			conn.close();
		}
		return res;
	}
	private boolean existeArticulo(Integer idArticulo) throws Exception {
		Connection conn = null;
		Statement stm = null;
		boolean existe = false;
		try{
			conn = ConnectionProvider.getConection();
			stm = conn.createStatement();			
			ResultSet rst = stm.executeQuery("Select id_articulo from articulos_mesa_recomendados where id_articulo = "+idArticulo);
			if(rst.next()) {
				existe = true;
			}		
		}catch (Exception e) {
			throw e;
		}finally{
			stm.close();
			conn.close();
		}
		return existe;
	}
}
