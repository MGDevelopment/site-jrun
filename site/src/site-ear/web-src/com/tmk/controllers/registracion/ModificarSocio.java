package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
//import javax.ejb.FinderException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.bus.socio.Socios2DTO;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
//import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.PaisDAO;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.socio.BufferSocioLocal;
//import com.tmk.socio.BufferSocioLocalHome;
//import com.tmk.socio.BufferSocioPK;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.src.socio.SocioPK;
//import com.tmk.util.ByteArrayWarpper;
import com.tmk.util.ShortCuts;
import com.tmk.xml.Resultado;

public class ModificarSocio extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=ISO-8859-1");
		 request.setCharacterEncoding("UTF8");
		/*obligatorios*/
		 String nombres = Convert.toString(request.getParameter("nombres"), null);
		 String apellidos = Convert.toString(request.getParameter("apellidos"), null);
		 String email = Convert.toString(request.getParameter("email"), null);
		 String password = Convert.toString(request.getParameter("password"), null);
		 String rePassword = Convert.toString(request.getParameter("rePassword"), null);
		 /*obligatorios*/

		 //requeridos si es socio
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
		 //
		 boolean datosPersonales = Convert.toBoolean(request.getParameter("datosPersonales"), true);

		 SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		 boolean esSocioTMK = Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false);

		 Resultado resultado = null;
		 PrintWriter out = response.getWriter();
		 XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		 xstream.alias("Resultado", Resultado.class);
		 if (socioPK != null) {
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
			 } else {
				 //busco el email entre los sociosCadena
				 Socios2 socio = ServiceLocator.getSocioService().findSocioByLogin(email);
				 if (socio != null) {
					 if (!socio.getId_socio().equals(socioPK.ID_SOCIO) ||
							 !socio.getId_sucursal().equals(socioPK.ID_SUCURSAL)) {
						 //TmkLogger.debug("Lo encontro en socioCadena actual " + socioPK.ID_SOCIO + socioPK.ID_SUCURSAL + " encontrado " + socioLocal.getID_SOCIO() + socioLocal.getID_SUCURSAL());
						 TmkLogger.debug("Lo encontro en socioCadena actual " + socioPK.ID_SOCIO + socioPK.ID_SUCURSAL + " encontrado " + socio.getId_socio() + socio.getId_sucursal());
						 resultado = new Resultado (false, new String[] {"El email " + email + " se encuentra en uso. Por favor modificalo e intenta nuevamente."}, new String[]{"email"});
					 }
				 }
				 //busco el email entre los sociosTMK
				 if (resultado == null) {
			 		try {
			 			SocioTMK buscarMailAux = ServiceLocator.getSociosTMKService().findSocioTmkByLogin(email);
			 			if (!buscarMailAux.getIdSocio().equals(socioPK.ID_SOCIO) ||
			 				!buscarMailAux.getIdSucursal().equals(socioPK.ID_SUCURSAL)) {
			 				TmkLogger.debug("Lo encontro en socioTMK actual " + socioPK.ID_SOCIO + socioPK.ID_SUCURSAL + " encontrado " + buscarMailAux.getIdSocio() +  buscarMailAux.getIdSucursal());
			 				resultado = new Resultado (false, new String[] {"El email " + email + " se encuentra en uso. Por favor modificalo e intenta nuevamente."}, new String[]{"email"});
				 		}
			 		}catch (DBOInexistenteException di) {
			 			//sigo todo bien
					}catch (Exception e) {
						 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);
						 String err = "Error en ModificarSocio] en validacion de existencia de mail en socio TMK. Mail= " + email + " " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
						 MainHelper.enviarMailDeError(err);
						 TmkLogger.error(err);
					}
				 }

				 if (resultado == null) {
					 // todo bien
					 if (esSocioTMK) {
						 if (datosPersonales) {
								Date fechaNac = null;
								//modifico los datos y registro el socio definitivamente. SOCIO CADENA
								if (tipoDoc == null || nroDoc == null || nacionalidad == null || sexo == null) {
									 Vector mensaje = new Vector(5);
									 Vector campo = new Vector(5);
									 mensaje.add("Has elegido completar los datos adicionales.");
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
								} else if  (ShortCuts.esSocioRegistradoSegunUnificacion(socioPK.ID_SUCURSAL.intValue()
										 , Globals.ID_CANAL_ALTERNATIVO, nacionalidad.intValue(), sexo, tipoDoc,
										 nroDoc.longValue())) {

										StringBuffer datosSocio = new StringBuffer();
										datosSocio.append("Datos del Socio").append("\r");
										datosSocio.append("E-Mail/Login: ").append(email).append("\r");
										datosSocio.append("Nombre: ").append(apellidos).append(", ").append(nombres).append("\r");
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
										        email,
										        Globals.NOMBRE_DEL_SITIO + " Problemas en registración",
										        "Este documento \"" + tipoDoc + " " +
												nroDoc + "\" ya ha sido utilizado anteriormente por otro usuario, si ud. es el poseedor de " +
												"este documento, contáctese a \"" + Globals.MAIL_CALL_CENTER + "\"." +
												"Si ya se ha registrado con este número de documento en " + Globals.NOMBRE_DEL_SITIO + " y no recuerda su clave, ingrese a \"" +
												Globals.PAGINA_SITIO + "/miCuenta/?seccionMiCuenta=5\", utilice la misma dirección de mail con la que se registró, y le será remitida su clave nuevamente.",
										        "/mailing/documentoDuplicado.jsp?LOGIN=" + email + "&NRO_DOC=" + nroDoc + "&TIPO_DOC=" + tipoDoc);


										resultado = new Resultado(false, new String [] {
												"El documento \"" + tipoDoc + " " +	nroDoc + "\" ya ha sido registrado en " + Globals.NOMBRE_DEL_SITIO + "." +
												"<br>Si ya estás registrado con este número de documento en " + Globals.NOMBRE_DEL_SITIO + " y no recuerdas tu clave," +
												" ingresa a <a href=\"" + Globals.PAGINA_SITIO + "/miCuenta/?seccionMiCuenta=5\">recuperar clave</a>, utiliza la misma " +
												"dirección de correo con la que te registraste, y te será remitida tu clave." +
												"<br> Caso contrario, si sos el poseedor del documento pero no estas registrado en " + Globals.NOMBRE_DEL_SITIO + ", " +
												"contactanos en <a href=\"mailto:"+ Globals.MAIL_CALL_CENTER + "\">" + Globals.MAIL_CALL_CENTER + "</a>."

										}, new String[] {"tipoDoc", "nroDoc", "nacionalidad", "sexo"});
										/*evalua socio duplicado a nivel cadena (TIPO y NRO DOC, NACIONALIDAD, SEXO)*/
								 } else if (fechaNacDD != null && fechaNacMM != null && fechaNacAAAA != null){

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


								if (resultado == null) {
									 //si todavia no hay resultado es todo correcto
									 //comienzo la registracion del socioCadena
									try {
										ServiceLocator.getSocioService().create(
												 socioPK.ID_SUCURSAL,
												 socioPK.ID_SOCIO,
												 new Integer(Globals.ID_CANAL_ALTERNATIVO),
												 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
											     Globals.TIPO_PERSONA_FISICA,
											     CryptUtil.encriptar(email.toUpperCase().getBytes()),
											     nombres.toUpperCase(),
											     apellidos.toUpperCase(),
											     CryptUtil.encriptar(password.getBytes()),
												 tipoDoc,
											     nroDoc,
												 nacionalidad,
												 (fechaNac != null)? new Timestamp(fechaNac.getTime()): (Timestamp)null,
												 sexo,
												 estadoCivil,
												 hijos,
												 profesion,
												 email.toUpperCase(),
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
											     CryptUtil.encriptar(email.toUpperCase().getBytes()),
											     nombres.toUpperCase(),
											     apellidos.toUpperCase(),
											     CryptUtil.encriptar(password.getBytes()),
												 tipoDoc,
											     nroDoc,
												 nacionalidad,
												 (fechaNac != null)? new Timestamp(fechaNac.getTime()): (Timestamp)null,
												 sexo,
												 estadoCivil,
												 hijos,
												 profesion,
										         "N",
										         email.toUpperCase(),
										         (String)null,
												 (String)null,
												 (String)null,
												 (String)null,
												 (String)null,
												 (String)null);
										 
											//solo intento asociar si es que el parametro username de la jsp no es null
											 if (IntegracionHelper.pendienteDeIntegracion(request)) {

													 if (IntegracionHelper.esIdentificadorEnUso(request)) {
														 resultado = new Resultado (false, new String[] {"El usuario esta asociado a otro socio."}, null);
													 } else {
														 IntegracionHelper.IntegrarSocio(request);
													 }
											 }

											 request.getSession().removeAttribute("socioTMK");
											 //MSG OK
											 resultado = new Resultado(true, new String[]{"Se han modificado con exito los datos de tu cuenta"}, null);
											 //Actualizo la session
											 cambiosEnSession(request, nombres, apellidos, email);
											 ShortCuts.findListaBySocio(socioPK);
											 //borro el socio tmk
											 try {
												 SocioTMK socioTMK = new SocioTMK(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL);
												 ServiceLocator.getDboService().delete(socioTMK);
											 }catch (Exception e) {
												 String err = "Error en RegistrarSocioCadena] No existe el socioTMK " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL ;
												 MainHelper.enviarMailDeError(err);
												 TmkLogger.error(err);
											}
											 /*FIN registracion del socio cadena*/

									} catch (Exception e) {
										 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);
										 String err = "Error en ModificarSocio] Creacion de socio cadena" + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
										 MainHelper.enviarMailDeError(err);
										 TmkLogger.error(err);
									} finally {
										IntegracionHelper.eliminarSession(request);
									}
								}
							} else {
								try {
									//Modifico los datos. Sigue siendo SOCIOTMK
									try {
										SocioTMK socioTMK = new SocioTMK(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL);
										socioTMK.setNombres(nombres.toUpperCase());
										socioTMK.setApellidos(apellidos.toUpperCase());
										socioTMK.setLogin(email.toUpperCase());
										socioTMK.setPassword(CryptUtil.encriptar(password.getBytes()));
										ServiceLocator.getDboService().update(socioTMK);
										//Actualizo la session
										cambiosEnSession(request, nombres, apellidos, email);
										//MESAJE OK
										resultado = new Resultado(true, new String[]{"Los datos de tu cuenta han sido modificados con exito."}, null);
									}catch(DBOInexistenteException di) {
										 resultado = new Resultado (false, new String[]{"Se ha producido un error,No existe el socio."}, null);
										 String err = "Error en ModificarSocio] no existe el socioTMK " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL;
										 MainHelper.enviarMailDeError(err);
										 TmkLogger.error(err);
									}
								} catch (Exception e) {
									 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);
									 String err = "Error en ModificarSocio] Modificacion de socio TMK " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
									 MainHelper.enviarMailDeError(err);
									 TmkLogger.error(err);
								}
							}
					 } else {
//							es socio cadena solo hay que modificar los datos
						 Date fechaNac = null;
						 if (fechaNacDD != null && fechaNacMM != null && fechaNacAAAA != null){
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
								 resultado = new Resultado (false, new String[] {"La \"fecha de nacimiento\" ingresada no es correcta. Por favor modificala he intenta nuevamente"}, new String[] {"fechaNacDD", "fechaNacMM", "fechaNacAAAA"} );
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

						 if(resultado == null){
							 //si todavia no hay resultado es todo correcto
							 //comienzo con la modificacion del socio2
							 try {
								 //Socios2DTO aux = new Socios2DTO(socio.getId_sucursal(),socio.getId_socio());
								 Socios2DTO aux = new Socios2DTO(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO);
								 aux.setNombres(nombres.toUpperCase());
								 aux.setApellidos(apellidos.toUpperCase());
								 aux.setE_mail1(email.toUpperCase());
								 aux.setLogin(CryptUtil.encriptar(email.toUpperCase().getBytes()));
								 aux.setPassword(CryptUtil.encriptar(password.getBytes()));
								 if (fechaNac != null) {
									 aux.setFecha_nacimiento(new Timestamp(fechaNac.getTime()));
								 }
								 aux.setHijos(hijos);
								 aux.setId_profesion(profesion);
								 aux.setEstado_civil(estadoCivil);
								 //actualizo
								 ServiceLocator.getDboService().update(aux);								 								 
								 //SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
								 
								 /*socioLocal = socioLocalHome.findByPrimaryKey(socioPK);
								 socioLocal.setNOMBRES(nombres.toUpperCase());
								 socioLocal.setAPELLIDOS(apellidos.toUpperCase());
								 socioLocal.setE_MAIL1(email.toUpperCase());
								 socioLocal.setLOGIN(CryptUtil.encriptar(email.toUpperCase().getBytes()));
								 socioLocal.setPASSWORD(CryptUtil.encriptar(password.getBytes()));
								 if (fechaNac != null) {
									 socioLocal.setFECHA_NACIMIENTO(new Timestamp(fechaNac.getTime()));
								 }
								 socioLocal.setHIJOS(hijos);
								 socioLocal.setID_PROFESION(profesion);
								 socioLocal.setESTADO_CIVIL(estadoCivil);
								 */
								 //BufferSocioLocalHome bufferSocioLocalHome = (BufferSocioLocalHome) DBUtil.getHome("BufferSocio");
								 try {									 
									 //BufferSocioLocal bufferSocioLocal = bufferSocioLocalHome.findByPrimaryKey(new BufferSocioPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
									 BufferSocios bufferSocio = new BufferSocios(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
									 bufferSocio.setNombres(nombres.toUpperCase());
									 bufferSocio.setApellidos(apellidos.toUpperCase());
									 bufferSocio.setE_mail1(email.toUpperCase());
									 bufferSocio.setLogin(CryptUtil.encriptar(email.toUpperCase().getBytes()));
									 bufferSocio.setPassword(CryptUtil.encriptar(password.getBytes()));
									 if (fechaNac != null) {
										 bufferSocio.setFecha_nacimiento(new Timestamp(fechaNac.getTime()));
									 }
									 bufferSocio.setHijos(hijos);
									 bufferSocio.setId_profesion(profesion);
									 bufferSocio.setEstado_civil(estadoCivil);
									 //uso el service locator para evitar el error de null
									 bufferSocio.setAuxflag2(ServiceLocator.getSocioService().findByPrimaryKey(socioPK).getAuxflag2());
									 ServiceLocator.getDboService().update(bufferSocio);

								 //} catch (FinderException e) {
								 } catch (DBOInexistenteException ae) {
									 BufferSocios bufferSocio = new BufferSocios(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
									 bufferSocio.setId_caal(new Integer(Globals.ID_CANAL_ALTERNATIVO));
									 bufferSocio.setId_tipo_contribuyente(new Integer(Globals.ID_TIPO_CONTRIBUYENTE));
									 bufferSocio.setTipo_persona(Globals.TIPO_PERSONA_FISICA);
									 bufferSocio.setLogin(CryptUtil.encriptar(email.toUpperCase().getBytes()));
									 bufferSocio.setNombres(nombres.toUpperCase());
									 bufferSocio.setApellidos(apellidos.toUpperCase());
									 bufferSocio.setPassword(CryptUtil.encriptar(password.getBytes()));
									 bufferSocio.setTipo_doc(tipoDoc);
									 bufferSocio.setNro_doc(nroDoc);
									 bufferSocio.setNacionalidad(nacionalidad);
									 bufferSocio.setFecha_nacimiento((fechaNac != null)? new Timestamp(fechaNac.getTime()): (Timestamp)null);
									 bufferSocio.setSexo(sexo);
									 bufferSocio.setEstado_civil(estadoCivil);
									 bufferSocio.setHijos(hijos);
									 bufferSocio.setId_profesion(profesion);
									 bufferSocio.setProcesado("N");
									 bufferSocio.setE_mail1(email.toUpperCase());
									 bufferSocio.setAuxflag2(socio.getAuxflag2());
									 
									 //inserto en buffersocio
									 ServiceLocator.getDboService().insert(bufferSocio);																	
								 }

								 if (IntegracionHelper.pendienteDeIntegracion(request)) {
									 if (IntegracionHelper.esIdentificadorEnUso(request)) {
										 resultado = new Resultado (false, new String[] {"El usuario esta asociado a otro socio."}, null);
									 } else {
										 IntegracionHelper.IntegrarSocio(request);
									 }
								 }
								 //request.getSession().removeAttribute("socioTMK");
								 //Actualizo la session
								 cambiosEnSession(request, nombres, apellidos, email);
								 resultado = new Resultado(true, new String [] {"Los datos de tu cuenta han sido modificados con exito!!!"}, null);
							 } catch (Exception e) {
								 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento para intentarlo nuevamente."}, null);
								 String err = "Error en ModificarSocio] Modificacion de socio cadena " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
								 MainHelper.enviarMailDeError(err);
								 TmkLogger.error(err);
							 } finally {
								 IntegracionHelper.eliminarSession(request);
							 }
						 }
					 }
				 }
			}
		 } else {
			 request.getSession().setAttribute("Registracion.feedback", "Tu sesion ha concluido, por favor realiza tu login nuevamente.");
			 resultado = new Resultado(false, null, null);
			 resultado.setTargetRedirect("/miCuenta");
		 }
		 out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
	private void cambiosEnSession(HttpServletRequest request, String nombres, String apellidos, String email ) {
		request.getSession().setAttribute("Registracion.nombreCompleto", Convert.nombreCompleto(nombres.toUpperCase(), apellidos.toUpperCase()));
		request.getSession().setAttribute("Registracion.nombre", Convert.capitalizarOriginal(nombres.toUpperCase(), true).toString());
		request.getSession().setAttribute("Registracion.login", email.toUpperCase());

	}

}
