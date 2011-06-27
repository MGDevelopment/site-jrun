package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
//import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.Resultado;
import com.tmk.xml.converter.CapitalizarDescripcionConverter;
import com.tmk.xml.converter.DesencriptarByteArrayConverter;
import com.tmk.xml.converter.DesencriptarByteArrayWrapperConverter;


/**
 *
 * @author oClopez
 * recive la peticion de altaAlertaCompraSocio.jsp
 * consulta todos los socios de la tabla socios2 para usarlo en el alta de AlertaCompraSocios
 *
 */
public class GetSocios2 extends HttpServlet {
	private final int CANTIDAD_MAXIMA = 30;
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String orden = request.getParameter("ordenadoPor");

		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF8");

		PrintWriter out = response.getWriter();

		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		xstream.omitField(Socios2.class, "f_alta");
		xstream.registerLocalConverter(Socios2.class, "login", new DesencriptarByteArrayWrapperConverter());
		xstream.aliasAttribute(Socios2.class, "login", "cls_loginDesencriptado");
		Resultado resultado = null;

		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);
		Vector<Socios2> vecSocios;
		Collection<Socios2> socios;
		
		if(usuarioDAO!=null){
			//como se que hay sesion defino alias, por que tenga o no socios los voy a necesitar
			xstream.alias("socios", Vector.class);
			xstream.alias("socio", Socios2.class);
			//y tambien registro el converter para el login y capitalizacion de palabras
			xstream.registerConverter(new DesencriptarByteArrayConverter());
			xstream.registerConverter(new CapitalizarDescripcionConverter());
			
			CamposABuscarDBO camposABuscarDBO  = new CamposABuscarDBO();
			setCamposAbuscar(camposABuscarDBO);
			
			Condicion condicionNombre;
			Condicion condicionApellido;
			Condicion condicionLogin;
			
			WhereDBO where = new WhereDBO();
			where.setCantidadABuscar(CANTIDAD_MAXIMA);
			condicionLogin = new Condicion(Socios2.getAlias()+".login",Comparador.IS_NOT_NULL,"");
			OrderBYDBO orderBy = new OrderBYDBO();
			orderBy.agregarCampoAOrden(Socios2.getAlias()+"."+orden);
			vecSocios = new Vector<Socios2>();			
			
			try {
				Connection conn =DBUtil.buildConnection();
				try {					
					if(nombre.trim().length() > 0) {
						if(apellido.trim().length() > 0) {
						 	condicionNombre = new Condicion(Socios2.getAlias()+".nombres",Comparador.LIKE,"'"+nombre.toUpperCase()+"%'");
						 	condicionApellido = new Condicion(Socios2.getAlias()+".apellidos",Comparador.LIKE,"'"+apellido.toUpperCase()+"%'");						 	
						 	where.add(condicionNombre);
						 	where.add(Operador.AND,condicionApellido);
						 	where.add(Operador.AND,condicionLogin);
						} else {
							condicionNombre = new Condicion(Socios2.getAlias()+".nombres",Comparador.LIKE,"'"+nombre.toUpperCase()+"%'");
							where.add(condicionNombre);
							where.add(Operador.AND, condicionLogin);
						}						
					} else {
						if(apellido.trim().length() > 0) {
							condicionApellido = new Condicion(Socios2.getAlias()+".apellidos",Comparador.LIKE,"'"+nombre.toUpperCase()+"%'");
							where.add(condicionApellido);
						 	where.add(Operador.AND,condicionLogin);
						} else {
							out.print("{\"Resultado\":{\"valor\":false,\"mensaje\":[\"Ingrese datos para buscar\"],\"fallaSistema\": false}}");
							return;
						}
					}

					/*consulto contra la tabla SOCIOS2 si na hay socio lanza exception*/
					socios =  (TreeSet)DBO.select2(Socios2.class,conn,camposABuscarDBO,null,where,orderBy,new ComparadorPorDefecto());

					//argergo al vector todos los socios en el collection socios
					vecSocios.addAll(socios);
					resultado = new Resultado(true, new String []{"Se muestran los primeros 30 resultados"} ,null);
					resultado.setRespuesta(vecSocios);
				}
				catch (SQLException e) {
					TmkLogger.error(e.toString() + MainHelper.getMessage(e));
					resultado = new Resultado(false,new String[]{"Inconveniente interno, reintentar..."},null);
					resultado.setFallaSistema(false);
				}
				catch (Exception e) {
					resultado = new Resultado(false,new String[]{"No hay Resultados"},null);
					resultado.setFallaSistema(false);
				}
				finally {
					conn.close();
				}
			}
			catch (Exception e) {
				TmkLogger.error(e.toString() + MainHelper.getMessage(e));
				resultado = new Resultado(false,new String[]{"Error interno, contacte al administrador"},null);
				resultado.setFallaSistema(true);
			}
		}
		else {
			resultado = new Resultado (false, null, null);
			resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
	
	private void setCamposAbuscar(CamposABuscarDBO camposABuscarDBO) {
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".nombres");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".apellidos");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".login");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".e_mail1");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".id_sucursal");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".id_socio");
		camposABuscarDBO.agregarCampoABusqueda(Socios2.getAlias()+".f_alta");				
	}	
}






