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
import com.tmk.xml.converter.CapitalizarDescripcionConverter;
import com.tmk.xml.converter.DesencriptarByteArrayConverter;

public class DelAlertaCompraSocios extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//estos son los parametro para dar de baja*/
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

		if(usuarioDAO != null){
			/*por seguridad verificamos que lleguen los parametros*/
			if (null == id_socio || null == id_sucursal){
				resultado =  new Resultado(true,new String[]{"SeleccionVacia"},null);
				resultado.setFallaSistema(false);
			} else {
				try {
					Connection conn = DBUtil.buildConnection();
					try {
						AlertaCompraSocios socios = new AlertaCompraSocios(new Integer(id_socio),new Integer(id_sucursal));
						socios.delete(conn);
						/*defino el alias para AlertaCompraSocios*/
						xstream.alias("socios", Vector.class);
						/*registro el converter para el login*/
						xstream.registerConverter(new DesencriptarByteArrayConverter());
						xstream.registerConverter(new CapitalizarDescripcionConverter());
						resultado =  new Resultado(true,new String[]{"Baja Exitosa"},null);
					} catch (SQLException e) {
						resultado =  new Resultado(false,new String[]{"No se pudo dar de baja, intente nuevamente"},null);
						resultado.setFallaSistema(false);
					}
					catch (Exception e) {
						throw e;
					} finally {
						conn.close();
					}
				} catch (Exception e) {
					TmkLogger.error(e.toString() + MainHelper.getMessage(e));
					resultado = new Resultado(false,new String[]{"Error interno, contacte al administrador"},null);
					resultado.setFallaSistema(true);
				}
			}
		}else{
			resultado = new Resultado (false, null, null);
			resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));

	}
}
