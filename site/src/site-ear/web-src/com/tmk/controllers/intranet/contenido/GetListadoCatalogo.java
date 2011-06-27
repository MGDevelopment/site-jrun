package com.tmk.controllers.intranet.contenido;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.kernel.DBUtil;
import com.tmk.xml.Resultado;

 public class GetListadoCatalogo extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 public GetListadoCatalogo() {
		 /*nos aseguramos que el servet se cree*/
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*recepcion de parametros*/
		String parametro = request.getParameter("opcion");
		System.out.println("parametros de jsp"+parametro);
		/*seteo de cabecera de response*/
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		/*declaraciond de las variables necesarias*/
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		Resultado resultado = null;
		PrintWriter out = response.getWriter();

		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);

		if(usuarioDAO!=null){
			try {
				Connection conn =DBUtil.buildConnection();
				Vector listaCatalogo = new Vector();



			} catch (Exception e) {
				//manejo de error.
			}

		}
		else{
			resultado = new Resultado (false, null, null);
			resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
}