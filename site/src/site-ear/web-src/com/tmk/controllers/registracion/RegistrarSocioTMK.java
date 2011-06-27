package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
//import com.tmk.util.ShortCuts;
import com.tmk.xml.Resultado;


public class RegistrarSocioTMK extends HttpServlet {
	private static int cantidadDeSociosNuevos;
	private static int cantidadDeSociosNuevosGoogle;
	private static int cantidadDeSociosNuevosYahoo;
    private static StringBuffer palabrasClave = new StringBuffer();

	public static int getCantidadDeSociosNuevos() {
		return cantidadDeSociosNuevos;
	}

	public static int getCantidadDeSociosNuevosGoogle() {
		return cantidadDeSociosNuevosGoogle;
	}

	public static int getCantidadDeSociosNuevosYahoo() {
		return cantidadDeSociosNuevosYahoo;
	}

	public static String getPalabrasClave() {
		return palabrasClave.toString();
	}

	 @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=ISO-8859-1");
		 request.setCharacterEncoding("UTF8");

		 Resultado resultado = null;
		 String nombres = Convert.toString( request.getParameter("nombres") , null);
		 String apellidos = Convert.toString( request.getParameter("apellidos") , null);
		 String email = Convert.toString( request.getParameter("email") , null);
		 String password = Convert.toString( request.getParameter("password") , null);
		 String rePassword = Convert.toString( request.getParameter("rePassword"),  null);


		 PrintWriter out = response.getWriter();
		 XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		 xstream.alias("Resultado", Resultado.class);

		 if (nombres == null || apellidos == null || email == null || password == null || rePassword == null) {
			 Vector mensaje = new Vector(5);
			 Vector campo = new Vector(5);
			 if (nombres == null) {
				 mensaje.add("El campo \"nombres\" es requerido.");
				 campo.add("nombres");
		 	 }
		 	 if (apellidos == null) {
		 		 mensaje.add("El campo \"apellidos\" es requerido.");
		 		 campo.add("apellidos");
		 	 }
		 	 if (email == null) {
		 		 mensaje.add("El campo \"email\" es requerido.");
		 		 campo.add("email");
		 	 }
		 	 if (password == null) {
		 		 mensaje.add("El campo \"clave de acceso\" es requerido.");
		 		 campo.add("password");
		 	 }
		 	 if (rePassword == null) {
		 		 mensaje.add("El campo \"reingresar clave de acceso\" es requerido.");
		 		 campo.add("rePassword");
			 }
		 	 if (campo.size()<2) {
		 		mensaje.add("Por favor completalo he intenta nuevamente.");
		 	 } else {
		 		 mensaje.add("Por favor completalos he intenta nuevamente.");
		 	 }
		 	 resultado = new Resultado (false,(String[]) mensaje.toArray(new String[mensaje.size()]), (String[])campo.toArray(new String[campo.size()]));
		 } else if (!MainHelper.esEMail(email)) {
			 resultado = new Resultado (false, new String[] {"El email ingresado no corresponde al formato valido. Por favor modificalo e intenta nuevamente"}, new String[] {"email"});
		 } else if (!password.equals(rePassword)) {
			 resultado = new Resultado (false, new String[] {"La contraseña no coincide con su confirmación. Por favor modificalo e intenta nuevamente."}, new String[] {"password"});
		 //} else if (ShortCuts.findSocioByLogin(email.toUpperCase()) != null) {
		 } else if (ServiceLocator.getSocioService().findSocioByLogin(email.toUpperCase())!=null) {			 
			 resultado = new Resultado (false, new String[] {"El email " + email + " se encuentra en uso. Por favor modificalo e intenta nuevamente."}, new String[]{"email"});
		 } else {	
			 SocioTMK  socioTMK = new SocioTMK(); 		
			 try  {
				try{
		 			//si no es null encontro el socio, lo que quiere decir q el login ya esta en uso
					socioTMK = ServiceLocator.getSociosTMKService().findSocioTmkByLogin(email);
					resultado = new Resultado (false, new String[] {" El email " + email + " se encuentra en uso. Por favor modificalo e intenta nuevamente."}, new String[]{"email"});
		 		}catch(DBOInexistenteException di){		 		
		 			//sigo porque no encontro al socio
					socioTMK = new SocioTMK(DBUtil.getSequenceValue("ID_SOCIO_SEQ"), new Integer(Globals.ID_SUCURSAL_TEMATIKA));
					socioTMK.setNombres(nombres.toUpperCase());
					socioTMK.setApellidos(apellidos.toUpperCase());
					socioTMK.setLogin(email.toUpperCase());
					socioTMK.setPassword(CryptUtil.encriptar(password.getBytes()));

					ServiceLocator.getDboService().insert(socioTMK);
					
					cantidadDeSociosNuevos++;
					HttpSession session = request.getSession();
					/*quito las sessions de registracion o inicio de session*/
					session.removeAttribute("Registracion.socioPK");
			        session.removeAttribute("Registracion.nombreCompleto");
			        session.removeAttribute("Registracion.nombre");
				    session.removeAttribute("Registracion.login");
			        session.removeAttribute("PuntajeFidelizacion");
			        session.removeAttribute("socioTMK");
			        /*quito las sessions de registracion o inicio de session*/
	
	
					session.setAttribute("Registracion.socioPK", new SocioPK(socioTMK.getIdSucursal(), socioTMK.getIdSocio()));
		            session.setAttribute("Registracion.nombreCompleto", Convert.nombreCompleto(socioTMK.getNombres(), socioTMK.getApellidos()));
		            session.setAttribute("Registracion.nombre", Convert.capitalizarOriginal(socioTMK.getNombres(), true).toString());
			        session.setAttribute("Registracion.login", socioTMK.getLogin());
			        session.setAttribute("socioTMK", new Boolean(true));
	
					resultado = new Resultado (true, null, null);
					//SEPARAR ESTO POR SI FALLAN INDIVIDUALMENTE
					try { //cualquier proceso q falle en este try no evita una registracion  satisfactoria						
						 /*trackeo google*/	
				        if (session.getAttribute(EstadisticaVisitas.REFERER_GOOGLE)!= null && ((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_GOOGLE)).booleanValue()) {
							cantidadDeSociosNuevosGoogle++;
							IniciarSesionORI.nuevaRegistracionGoogle();
							palabrasClave.append(session.getAttribute(EstadisticaVisitas.PALABRAS_CLAVE)).append("<br>");
						}
	
						if (session.getAttribute(EstadisticaVisitas.REFERER_YAHOO)!= null && ((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_YAHOO)).booleanValue()) {
							cantidadDeSociosNuevosYahoo++;
							IniciarSesionORI.nuevaRegistracionYahoo();
							palabrasClave.append(session.getAttribute(EstadisticaVisitas.PALABRAS_CLAVE)).append("<br>");
						}
				        /*trackeo google*/
	
						/*registro la alianza por la que provino el socio*/
						Integer idAlianza = (Integer) session.getAttribute(EstadisticaVisitas.ID_ALIANZA_SITIO);
						Integer idSeccion = ((Integer) session.getAttribute(EstadisticaVisitas.ID_SECCION_SITIO) == null)? new Integer(1):(Integer) session.getAttribute(EstadisticaVisitas.ID_SECCION_SITIO);	
						if (idAlianza != null) {
							try {
								Connection conn = DBUtil.buildConnection();
								try { 								
									registrarAlianza(conn, socioTMK.getIdSocio(), socioTMK.getIdSucursal(), idAlianza, idSeccion);								
								}finally{
									conn.close();
								}
							} catch (Exception e2) {
								String err = "Error en RegistrarSocioTMK] " + socioTMK.getIdSocio() + " " + socioTMK.getIdSucursal() + " alianza: " + idAlianza + " " + idSeccion + " " + e2.toString() + " " + MainHelper.getMessage(e2);
								MainHelper.enviarMailDeError(err);
								TmkLogger.error(err);
							}
						}
						/*registro la alianza por la que provino el socio*/
	
						/*mail bienvenida*/
						MailUtil.sendMail(
						        Globals.MAIL_CALL_CENTER,
						        email,
						        "Bienvenido a " + Globals.NOMBRE_DEL_SITIO,
						        "Usted ha sido registrado en " + Globals.NOMBRE_DEL_SITIO + ". Muchas gracias por elegirnos.",
						        "/mailing/bienvenidoTematika.jsp?CAMPO_SUCURSAL=" + socioTMK.getIdSucursal() + "&CAMPO_SOCIO=" + socioTMK.getIdSocio());
						/*mail bienvenida*/
	
						/*chequeo referido*/
						if (Globals.referidoHabilitado() && ReferidoManager.esReferido(request)) {
							 resultado.setAux(new String[] {"true"});
						 } else {
							 resultado.setAux(new String[] {"false"});
						 }
						/*chequeo referido*/
	
					} catch (Exception e2) {
						String err = "Error en RegistrarSocioTMK] " + socioTMK.getIdSocio() + " " + socioTMK.getIdSucursal() + e2.toString() + " " + MainHelper.getMessage(e2);
						MainHelper.enviarMailDeError(err);
						TmkLogger.error(err);
					}
		 		}
			 	//para la obtencion de secuence del socio
				}catch(Exception e2){
					resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarde unos momentos he intentelo nuevamente"}, null);
					String err = "Error en RegistrarSocioTMK] "  + e2.toString() + " " + MainHelper.getMessage(e2);
					MainHelper.enviarMailDeError(err);
					TmkLogger.error(err);
				}			
		 }

		 out.print(xstream.toXML(resultado).replaceAll("\n", ""));

	 }

	 private void registrarAlianza (Connection conn, Integer idSocio, Integer idSucursal, Integer idAlianza, Integer idSeccion)  throws SQLException, NamingException {

			String qry;

			qry = "insert into alianza_socios (id_socio, id_sucursal, id_alianza, id_seccion) " +
			      " values (" +
			      "'" + idSocio + "'" +
			      ",'" + idSucursal + "'" +
			      ",'" + idAlianza + "'" +
			      ",'" + idSeccion + "'" +
	              ")";


				PreparedStatement statement = conn.prepareStatement(qry);
				try {
	            	statement.execute();
				} finally {
					statement.close();
				}

		}
}