package com.tmk.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.kernel.Convert;
import com.tmk.setup.Contenido;
import com.tmk.soa.bo.ArticuloRecomendadoTematika;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.util.HTML.Template;

/**
 * 
 * 	@author oclopez
 *	Con el idArticulo, obtiene una Collection invocando a ArticuloService.getArticulosRelacionados(idArticulo);
 *	
 */
public class GetArticulosRecomendadosMesa extends Action {

	@SuppressWarnings("unchecked")
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
		Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"),0);
		String agrupacion = request.getParameter("agrupacion");
		String filtros = request.getParameter("filtro");
		Integer idSeccion = Integer.parseInt(request.getParameter("idSeccion"));
		
		Iterator<ArticuloRecomendadoTematika> itArticulos = this.getArticulosMesaRecomendados(idArticulo,agrupacion,filtros,idSeccion).iterator();
		Vector<Hashtable<String, String>> vecDetalles = new Vector<Hashtable<String, String>>();//guarda todos los detalles
		Hashtable<String,String> hasDetalles = null;
		Hashtable path = new Hashtable();//para el parth de la template			
		path.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
						+ "/templates/tmpArticulosRecomendadosMesa.htm"));

		Template tmpArticulos = new Template(path); 
		int indice = 0;
		while(itArticulos.hasNext()){
			ArticuloRecomendadoTematika aux = itArticulos.next();
			hasDetalles = new Hashtable<String, String>();
			hasDetalles.put("idArticulo",""+aux.getId_articulo());
			hasDetalles.put("titulo",""+aux.getCls_titulo());
			hasDetalles.put("posicion",""+aux.getPosicion());
			hasDetalles.put("posicionIndice",""+indice);
			hasDetalles.put("filtro",""+indice);
			hasDetalles.put("agrupacion",""+indice);
			hasDetalles.put("agrupacion",agrupacion);
			hasDetalles.put("filtro",filtros);
			vecDetalles.add(hasDetalles);
			indice++;
		}
		
		tmpArticulos.setParam("mostrarEliminar", vecDetalles.size()>0?"true":"");
		tmpArticulos.setParam("articulos", vecDetalles);
		tmpArticulos.setParam("cantidad", vecDetalles.size());
		response.getWriter().print(tmpArticulos.output());
		return null;
	}
		
	private Collection<ArticuloRecomendadoTematika> getArticulosMesaRecomendados(Integer idArticulo,String agrupacion,String filtro,Integer idSeccion) throws Exception {
		Collection<ArticuloRecomendadoTematika> articulos = new ArrayList<ArticuloRecomendadoTematika>(); 
		Connection conn = null;
		Statement stm = null;
		try{
			conn = ConnectionProvider.getConection();
			stm = conn.createStatement();
			StringBuffer qry = new StringBuffer(" Select artr.id_articulo,art.titulo titulo, artr.agrupacion,artr.en_filtro,artr.posicion,artr.categoria_seccion " );
			qry.append(" FROM ");
			qry.append(" articulos_mesa_recomendados artr,articulos art ");
			qry.append(" where ");
			qry.append( " art.id_articulo = artr.id_articulo "); 
			qry.append(" and ");
			qry.append( " artr.agrupacion = '").append(agrupacion).append("'");;
			qry.append(" and ");
			qry.append( " artr.en_filtro = '").append(filtro).append("'");
			qry.append(" and ");
			qry.append( " artr.categoria_seccion = ").append(idSeccion);
			qry.append(" ORDER BY artr.posicion ");
			
			ResultSet rst = stm.executeQuery(qry.toString());
			ArticuloRecomendadoTematika aux = null;
			while(rst.next()) {
				aux = new ArticuloRecomendadoTematika();
				aux.setId_articulo(rst.getInt("id_articulo"));
				aux.setAgrupacion(rst.getString("agrupacion"));
				aux.setEn_filtro(rst.getString("en_filtro"));
				aux.setCls_titulo(rst.getString("titulo"));
				aux.setPosicion(rst.getInt("posicion"));
				aux.setCategoria_seccion(rst.getInt("categoria_seccion"));
				articulos.add(aux);
			}		
		}catch (Exception e) {
			throw e;
		}finally{
			stm.close();
			conn.close();
		}
		return articulos;
	}
}
