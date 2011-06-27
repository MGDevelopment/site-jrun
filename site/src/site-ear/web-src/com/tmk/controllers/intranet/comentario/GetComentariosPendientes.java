package com.tmk.controllers.intranet.comentario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.comentario.ComentarioHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

public class GetComentariosPendientes extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=ISO-8859-1");
		resp.setHeader("cache-Control","no-cache");
		req.setCharacterEncoding("UTF8");		
		PrintWriter out = resp.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("comentario",ComentarioArticulos.class);
		xstream.omitField(DBO.class, "seteado");
		xstream.omitField(Socios2.class, "login");
		xstream.registerConverter(new CollectionConverter(xstream.getMapper()){
			public boolean canConvert(Class type) {
				return type == TreeSet.class;
			}
		});
		
	try {
		Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".fecha");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
				/*campos socios*/
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
											
				Condicion condicionEstado = new Condicion(ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'"+ComentarioHelper.PENDIENTE+"'");	
				
				WhereDBO where = new WhereDBO();		
				where.add(condicionEstado);			
											
				Collection<DBO>  com = (TreeSet<DBO>)DBO.select2(ComentarioArticulos.class,conn,camposABuscar,null,where,null,new ComparadorPorDefecto());
				out.print(xstream.toXML(com).replaceAll("\n","").replace("tree-set", "comentarios"));				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
