package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.mensaje.MensajeService;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.xml.feed.Link;
import com.tmk.xml.mensaje.Mensajes;

 public class GetUrlArticulo extends javax.servlet.http.HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*obtencion de parametros*/
		String id_articulo= request.getParameter("id_articulo");
		String id_elemento= request.getParameter("id_elemento");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("link", Link.class);
		Link link= new Link(id_elemento, "", "#");
		try {
			if(!"".equals(id_articulo) && null != id_articulo){
				Integer idArticulo=Integer.valueOf(id_articulo);
				Articulo articulo = DAOFactory.getArticuloDAO().getArticuloById(idArticulo);
				link= new Link(id_elemento, "", articulo.getUrlDetalle());
			}
		}catch (Exception e) {
			TmkLogger.error(e);
		} catch (AplicationException e) {
			TmkLogger.error(e);
		}
		out.print(Convert.toFixedJSON(xstream.toXML(link)));
	}
	
}

