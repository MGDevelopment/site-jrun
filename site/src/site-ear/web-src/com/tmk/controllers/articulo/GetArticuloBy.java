package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.DescripcionPrincipal;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.Resultado;
import com.tmk.xml.converter.CapitalizarDescripcionConverter;

 public class GetArticuloBy extends javax.servlet.http.HttpServlet{
	 private String id_articulo;
	 private String isbn;
	 CamposABuscarDBO camposABuscar;
	 CamposLeftJoinDBO camposLeftJoin;
	 public void init() throws ServletException {
		super.init();
		camposABuscar = new CamposABuscarDBO();
		camposLeftJoin = new CamposLeftJoinDBO();
		setDefinirRelaciones(camposABuscar,camposLeftJoin);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*obtencion de parametros*/
		id_articulo= request.getParameter("id_articulo");
		isbn= request.getParameter("isbn");

		/*xstream, request , resultado*/
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");
		PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Articulos", Vector.class);
		xstream.alias("articulo", Articulo.class);
		xstream.omitField(Articulo.class, "camposABuscar");
		xstream.omitField(DescripcionPrincipal.class, "camposABuscar");
		xstream.omitField(DBO.class, "camposABuscar");
		xstream.omitField(DBO.class, "seteado");
		Resultado resultado = null;
		try {
			xstream.alias("Resultado", Resultado.class);
			UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);

			if(usuarioDAO != null){
				if("".equals(id_articulo) && "".equals(isbn)){
					resultado = new Resultado(false,new String[]{"Ingresá al menos una opcion de busquda"},new String[]{"id_articulo","isbn"});
					resultado.setFallaSistema(false);
					out.print(xstream.toXML(resultado).replaceAll("\n", ""));
					return ;
				}
				/*registro de converters*/
				xstream.alias("articulos", Articulo.class);
				xstream.registerConverter(new CapitalizarDescripcionConverter());

				Connection conn = DBUtil.buildConnection();
				try{
					Vector vecArticulos = new Vector();
					Articulo articulo=null;

					if(!"".equals(id_articulo) && null != id_articulo){
						articulo = new Articulo(new Integer(id_articulo));
					}else{
						if(!"".equals(isbn) && null != isbn)
							articulo = new Articulo(new Integer(isbn));
					}
					try{
						/*la nueva version del dbo necesita estos objetos*/
						DBO.select(articulo, conn, camposABuscar, camposLeftJoin);
						vecArticulos.add(articulo);
						resultado = new Resultado(true,null,null);
						resultado.setRespuesta(vecArticulos);
					}catch (Exception e) {
						resultado = new Resultado(false,new String[]{"No se encontraron resultados"},null);
						resultado.setFallaSistema(false);
						throw e;
					}
				}
				catch (Exception e) {
					if(resultado == null){
						resultado = new Resultado(false,new String[]{"Ingrese los numeros sin ningun simbolo "},new String[]{"CampoNoEntero"});
						resultado.setFallaSistema(false);
					}
						throw e;
				}
				finally{
					conn.close();
				}
			}
			else{
				resultado = new Resultado (false, null, null);
				resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
			}

		}
		catch (Exception e1) {
			TmkLogger.error(e1.toString() + MainHelper.getMessage(e1));
			if(resultado == null){
				resultado = new Resultado(false,new String[]{"Error interno, contacte al administrador"},null);
				resultado.setFallaSistema(true);
			}
		}

		Pattern pt= Pattern.compile("(\\{)(\\\"[^\\\"]+\\\")([^:}]*)(\\})");
		Matcher mt= pt.matcher(xstream.toXML(resultado));
		String correctJsonStr= mt.replaceAll("$2");
		out.print(correctJsonStr.replaceAll("\n", "").replaceAll("\r", ""));
	}

	private void setDefinirRelaciones(CamposABuscarDBO camposABuscar, CamposLeftJoinDBO camposLeftJoin) {
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias()+ ".id_articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias()+ ".titulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias()+ ".descripcion");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias()+ ".descripcionPrincipal");
		camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias()+ ".texto");
		camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias()+ ".parte");

		/*left join*/
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+ ".descripcionPrincipal");
	}
}

