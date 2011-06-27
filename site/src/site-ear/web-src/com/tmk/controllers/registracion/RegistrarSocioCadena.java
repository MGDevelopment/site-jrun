package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
//import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.PaisDAO;
import com.tmk.kernel.TmkLogger;
//import com.tmk.socio.BufferSocioLocalHome;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.ShortCuts;
import com.tmk.xml.Resultado;

public class RegistrarSocioCadena extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=ISO-8859-1");
		 request.setCharacterEncoding("UTF8");

		//requeridos
		 String tipoDoc = Convert.toString(request.getParameter("tipoDoc"), null);
		 Long nroDoc = Convert.toNumber(request.getParameter("nroDoc"), (Long)null);
		 Integer nacionalidad = Convert.toNumber(request.getParameter("nacionalidad"), (Integer)null);
		 String sexo = Convert.toString(request.getParameter("sexo"), null);
		 //opcionales
		 Integer fechaNacDD = Convert.toNumber(request.getParameter("fechaNacDD"), (Integer)null);
		 Integer fechaNacMM = Convert.toNumber(request.getParameter("fechaNacMM"), (Integer)null);
		 Integer fechaNacAAAA = Convert.toNumber(request.getParameter("fechaNacAAAA"), (Integer)null);
		 String estadoCivil = Convert.toString(request.getParameter("estadoCivil"), null);
		 Integer hijos = Convert.toNumber(request.getParameter("hijos"), (Integer)null);
		 Integer profesion = Convert.toNumber(request.getParameter("profesion"), (Integer)null);
		
		 Date fechaNac = null;

		 Resultado resultado = null;
		 PrintWriter out = response.getWriter();
		 XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		 xstream.alias("Resultado", Resultado.class);

		 if (tipoDoc == null || nroDoc == null || nacionalidad == null || sexo == null) {
			 Vector mensaje = new Vector(5);
			 Vector campo = new Vector(5);
			 if (tipoDoc == null) {
				 mensaje.add("El campo \"documento de identidad (tipo)\" es requerido.");
				 campo.add("tipoDoc");
		 	 }
			 if (nroDoc == null) {
				 mensaje.add("El campo \"documento de identidad (numero)\" es requerido.");
				 campo.add("nroDoc");
			 }
			 if (nacionalidad == null) {
				 mensaje.add("El campo \"nacionalidad\" es requerido.");
				 campo.add("nacionalidad");
			 }
			 if (sexo == null) {
				 mensaje.add("El campo \"sexo\" es requerido.");
				 campo.add("sexo");
			 }
		 	 if (campo.size()<2) {
		 		mensaje.add("Por favor completalo he intenta nuevamente.");
		 	 } else {
		 		 mensaje.add("Por favor completalos he intenta nuevamente.");
		 	 }
		 	 resultado = new Resultado (false,(String[]) mensaje.toArray(new String[mensaje.size()]), (String[])campo.toArray(new String[campo.size()]));
		 }else if (fechaNacDD != null && fechaNacMM != null && fechaNacAAAA != null){
			 try {
				 fechaNac = MainHelper.convertirEnFecha(fechaNacDD + "/" +
						 					 fechaNacMM + "/" +
						 					 fechaNacAAAA,
						 					 "dd/MM/yyyy");
				//el socio no puede naces mañana
				 if(fechaNac.after(new Date(System.currentTimeMillis()))) {
					 throw new Exception();
				 }
				 //no puede tener mas de 150 años
				 Calendar cal = Calendar.getInstance();
				 if((cal.getTime().getYear()+1900) - (fechaNac.getYear()+1900) >= 150) {
					 throw new Exception();
				 }
			 } catch (Exception e) {
				 resultado = new Resultado (false, new String[] {"La \"fecha de nacimiento\" ingresada no es correcta. Por favor modificala he intenta nuevamente"}, new String[] {"fechaNacDD"} );
			 }

		 } else if (fechaNacDD != null || fechaNacMM != null || fechaNacAAAA != null) {
			 Vector mensaje = new Vector(3);
			 Vector campo = new Vector(3);
			 if (fechaNacDD == null) {
				 mensaje.add("El campo \"fecha de nacimiento (dia)\" está incompleto.");
				 campo.add("fechaNacDD");
			 }
			 if (fechaNacMM == null) {
				 mensaje.add("El campo \"fecha de nacimiento (mes)\" está incompleto.");
				 campo.add("fechaNacMM");
			 }
			 if (fechaNacAAAA == null) {
				 mensaje.add("El campo \"fecha de nacimiento (año)\" está incompleto.");
				 campo.add("fechaNacAAAA");
			 }
			 if (campo.size()<2) {
		 		mensaje.add("Por favor completalo he intenta nuevamente.");
		 	 } else {
		 		 mensaje.add("Por favor completalos he intenta nuevamente.");
		 	 }
			 if (campo.size()>=1) {
				 resultado = new Resultado (false,(String[]) mensaje.toArray(new String[mensaje.size()]), (String[])campo.toArray(new String[campo.size()]));
			 }

		 }

		 // si resultado todavia es nulo quiere decir que los datos son correctos
		 // asi que procedo a crear el socio de la cadena
		 if (resultado == null) {
			 HttpSession session  = request.getSession();
			 SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
			 try {
				 try {
					 //socioTMK.select(conn);
					 SocioTMK socioTMK = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPK);
					 /*evalua socio duplicado a nivel cadena (TIPO y NRO DOC, NACIONALIDAD, SEXO)*/
					 if (ShortCuts.esSocioRegistradoSegunUnificacion(socioPK.ID_SUCURSAL.intValue()
							 , Globals.ID_CANAL_ALTERNATIVO, nacionalidad.intValue(), sexo, tipoDoc,
							 nroDoc.longValue())) {

							StringBuffer datosSocio = new StringBuffer();
							datosSocio.append("Datos del Socio").append("\r");
							datosSocio.append("E-Mail/Login: ").append(socioTMK.getLogin()).append("\r");
							datosSocio.append("Nombre: ").append(socioTMK.getApellidos()).append(", ").append(socioTMK.getNombres()).append("\r");
							datosSocio.append("Documento: ").append(tipoDoc).append("-").append(nroDoc).append("\r");
							PaisDAO pais = PaisDAO.getPais(nacionalidad);
							datosSocio.append("Nacionalidad: ").append(pais.getNombre()).append("\r");
							datosSocio.append("Sexo: ").append(sexo).append("\r");


							MailUtil.sendMail(Globals.MAIL_MAILER,
											Globals.MAIL_ALERTA_SOC_DUP,
											Globals.NOMBRE_DEL_SITIO + " Socio no registrado por documento duplicado",
											datosSocio.toString());

							MailUtil.sendMail(
							        Globals.MAIL_CALL_CENTER,
							        socioTMK.getLogin(),
							        Globals.NOMBRE_DEL_SITIO + " Problemas en registración",
							        "Este documento \"" + tipoDoc + " " +
									nroDoc + "\" ya ha sido utilizado anteriormente por otro usuario, si ud. es el poseedor de " +
									"este documento, contáctese a \"" + Globals.MAIL_CALL_CENTER + "\"." +
									"Si ya se ha registrado con este número de documento en " + Globals.NOMBRE_DEL_SITIO + " y no recuerda su clave, ingrese a \"" +
									Globals.PAGINA_SITIO + "/miCuenta/?seccionMiCuenta=5\", utilice la misma dirección de mail con la que se registró, y le será remitida su clave nuevamente.",
							        "/mailing/documentoDuplicado.jsp?LOGIN=" + socioTMK.getLogin() + "&NRO_DOC=" + nroDoc + "&TIPO_DOC=" + tipoDoc);


							resultado = new Resultado(false, new String [] {
									"El documento \"" + tipoDoc + " " +	nroDoc + "\" ya ha sido registrado en " + Globals.NOMBRE_DEL_SITIO + "." +
									"<br>Si ya estás registrado con este número de documento en " + Globals.NOMBRE_DEL_SITIO + " y no recuerdas tu clave," +
									" ingresa a <a href=\"" + Globals.PAGINA_SITIO + "/miCuenta/?seccionMiCuenta=5\">recuperar clave</a>, utiliza la misma " +
									"dirección de correo con la que te registraste, y te será remitida tu clave." +
									"<br> Caso contrario, si sos el poseedor del documento pero no estas registrado en " + Globals.NOMBRE_DEL_SITIO + ", " +
									"contactanos en <a href=\"mailto:"+ Globals.MAIL_CALL_CENTER + "\">" + Globals.MAIL_CALL_CENTER + "</a>."

							}, new String[] {"tipoDoc", "nroDoc", "nacionalidad", "sexo"});
							/*evalua socio duplicado a nivel cadena (TIPO y NRO DOC, NACIONALIDAD, SEXO)*/
					 } else {
						 /*Todo ok, comienza la registracion del socio*/					 
						 ServiceLocator.getSocioService().create(
								 socioPK.ID_SUCURSAL,
								 socioPK.ID_SOCIO,
								 new Integer(Globals.ID_CANAL_ALTERNATIVO),
								 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
							     Globals.TIPO_PERSONA_FISICA,
							     CryptUtil.encriptar(socioTMK.getLogin().getBytes()),
							     socioTMK.getNombres(),
							     socioTMK.getApellidos(),
							     socioTMK.getPassword(),
								 tipoDoc,
							     nroDoc,
								 nacionalidad,
								 (fechaNac != null)? new Timestamp(fechaNac.getTime()): (Timestamp)null,
								 sexo,
								 estadoCivil,
								 hijos,
								 profesion,
								 socioTMK.getLogin(),
								 (String)null,
								 (String)null,
								 (String)null,
								 (String)null,
								 (String)null);
						 
						 ServiceLocator.getBufferSocioService().create(
								 socioPK.ID_SUCURSAL,
								 socioPK.ID_SOCIO,
								 new Integer(Globals.ID_CANAL_ALTERNATIVO),
								 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
							     Globals.TIPO_PERSONA_FISICA,
							     CryptUtil.encriptar(socioTMK.getLogin().getBytes()),
							     socioTMK.getNombres(),
							     socioTMK.getApellidos(),
							     socioTMK.getPassword(),
								 tipoDoc,
							     nroDoc,
								 nacionalidad,
								 (fechaNac != null)? new Timestamp(fechaNac.getTime()): (Timestamp)null,
								 sexo,
								 estadoCivil,
								 hijos,
								 profesion,
						         "N",
						         socioTMK.getLogin(),
						         (String)null,
								 (String)null,
								 (String)null,
								 (String)null,
								 (String)null,
								 (String)null);						

						 session.removeAttribute("socioTMK");

						 resultado = new Resultado(true, null, null);
						 //bloque agregada para el rediseño de mi cuenta
						 if(request.getAttribute(MainHelper.URL_REDIRECT)!=null) {
							 resultado.setTargetRedirect((String)request.getAttribute("urlRedirect"));
							 request.removeAttribute(MainHelper.URL_REDIRECT);
						 }else{
							 if(request.getSession().getAttribute(MainHelper.URL_REDIRECT)!=null) {
								 resultado.setTargetRedirect((String)request.getSession().getAttribute(MainHelper.URL_REDIRECT));
								 request.getSession().removeAttribute(MainHelper.URL_REDIRECT);
							 }else{
								 resultado.setTargetRedirect("/");
							 }
						 }
						 
						 ShortCuts.findListaBySocio(socioPK);
						 /*chequeo referido*/
						 if (Globals.referidoHabilitado()) {
							 ReferidoManager.setReferido(request);
						 }
						 /*chequeo referido*/

						 //borro el socio tmk
						 try {
							 socioTMK = new SocioTMK(socioPK.ID_SOCIO,socioPK.ID_SUCURSAL);
							 //socioTMK.delete(conn);
							 ServiceLocator.getDboService().delete(socioTMK);
						 } catch (Exception e) {
							 // si por algun motivo no logro borrar el socio, esto no afecta
							 // al proceso de registracion de socioCadena
							 String err = "Error en RegistrarSocioCadena] No se pudo borrar el socioTMK " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
							 MainHelper.enviarMailDeError(err);
							 TmkLogger.error(err);
						 }
						 /*Todo ok, comienza la registracion del socio*/
					 }
				 } finally {
					 //conn.close();
					 //TmkLogger.debug("cierro conexion");
				 }
			 } catch (Exception e) {
				 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarde unos momentos he intentelo nuevamente"}, null);
				 String err = "Error en RegistrarSocioCadena] " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
				 MainHelper.enviarMailDeError(err);
				 TmkLogger.error(err);
			 }
		 }
		 out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
}
/* TmkLogger.debug(" " + tipoDoc);
TmkLogger.debug(" " + nroDoc);
TmkLogger.debug(" " + nacionalidad);
TmkLogger.debug(" " + sexo);
TmkLogger.debug(" " + fechaNacDD);
TmkLogger.debug(" " + fechaNacMM);
TmkLogger.debug(" " + fechaNacAAAA);
TmkLogger.debug(" " + estadoCivil);
TmkLogger.debug(" " + hijos);
TmkLogger.debug(" " + profesion);*/