package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.AlertaCompraSocios;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.Resultado;

public class AltaAlertaCompraSocios extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_socio	 	= request.getParameter("id_socio");
		String id_sucursal  = request.getParameter("id_sucursal");

		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");

		PrintWriter out = response.getWriter();

		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		Resultado resultado = null;

		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);

		//verifico la sesion si esta activa
		if(usuarioDAO!=null){
			try {
				Connection 	conn =DBUtil.buildConnection();
				try{
					Vector vecSocios = new Vector();
					AlertaCompraSocios socio = new AlertaCompraSocios(new Integer(id_socio),new Integer(id_sucursal));
					socio.insert(conn);
					resultado = new Resultado(true, new String[]{"Socio incluido en alerta de compras con exito"}, null);
					//resultado.setFallaSistema(false);
				//validacion por clave duplicada getErrorCode = 1
				} catch ( SQLException e ) {
					if(e.getErrorCode() == 1){
						resultado = new Resultado(false, new String[]{"El socio ya esta dado de alta","MostrarBoton"}, null);
						resultado.setFallaSistema(false);
					}
					else{
						throw e;
					}
				} finally{
					conn.close();
				}
			}//por error general
			catch ( Exception e ) {
					TmkLogger.error(e.toString() + MainHelper.getMessage(e));
					resultado = new Resultado(false, new String[]{"NO se pudo dar de alta, contacte al administrador"}, null);
					resultado.setFallaSistema(true);
			}
		}//si no hay sesion
		else{
				resultado = new Resultado (false, null, null);
				resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}

}

