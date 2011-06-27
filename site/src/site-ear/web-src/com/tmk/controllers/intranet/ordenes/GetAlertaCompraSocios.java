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

@SuppressWarnings("serial")
public class GetAlertaCompraSocios extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		String valor  = request.getParameter("valor");

		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		PrintWriter out = response.getWriter();

		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		Resultado resultado = null;

		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);

		if(usuarioDAO != null ){
			//como se que hay sesion defino alias, por que tenga o no socios los voy a necesitar
			xstream.alias("socios", Vector.class);
			//y tambien registro el converter para el login y capitalizacion de palabras
			xstream.registerConverter(new DesencriptarByteArrayConverter());
			xstream.registerConverter(new CapitalizarDescripcionConverter());

			try {
				Connection conn = DBUtil.buildConnection();
				try{
					Vector vecSocios = new Vector();

					/*consultar todos*/
					if(null == opcion && null == valor){
						vecSocios = AlertaCompraSocios.getALL(conn,new String[]{});
					}
					/*consultar con parametros*/
					else{
						String[] param = new String[]{"upper (" +opcion+ ") like '" +valor.toUpperCase()+ "%'"};
						vecSocios = AlertaCompraSocios.getALL(conn,param);
					}
					if(vecSocios.size() > 0){
						//no hace falta el parametro mensaje por que no lo voy a utilizar en el js
						resultado = new Resultado(true,null,null);
						resultado.setRespuesta(vecSocios);
					}else{
						resultado = new Resultado(false,new String[]{"No hay Resultados"},null);
						resultado.setFallaSistema(false);
					}
				}
				catch (SQLException e) {
					throw e;
				}
				finally{
						conn.close();
				}
			}
			catch (Exception e) {
				TmkLogger.error(e.toString() + MainHelper.getMessage(e));
				resultado = new Resultado(false,new String[]{"Error interno, contacte al administrador"},null);
				resultado.setFallaSistema(true);
			}
		}
		else{
			resultado = new Resultado (false, null, null);
			resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
}

