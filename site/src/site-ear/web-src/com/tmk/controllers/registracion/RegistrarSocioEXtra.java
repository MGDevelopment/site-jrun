/*
 * Log$
 *
 * */
package com.tmk.controllers.registracion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
//import java.util.Iterator;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.fidelizacion.ActividadLaboralDAO;
import com.tmk.fidelizacion.BufferCuentaLocal;
import com.tmk.fidelizacion.BufferCuentaLocalHome;
import com.tmk.fidelizacion.BufferCuentasPorSocioLocal;
import com.tmk.fidelizacion.BufferCuentasPorSocioLocalHome;
import com.tmk.fidelizacion.BufferFormularioLocal;
import com.tmk.fidelizacion.BufferFormularioLocalHome;
import com.tmk.fidelizacion.BufferTarjetaLocal;
import com.tmk.fidelizacion.BufferTarjetaLocalHome;
import com.tmk.fidelizacion.BufferTarjetasPorCuentaLocal;
import com.tmk.fidelizacion.BufferTarjetasPorCuentaLocalHome;
//import com.tmk.fidelizacion.CtaCtaPuntosLocal;
//import com.tmk.fidelizacion.CtaCtaPuntosLocalHome;
import com.tmk.fidelizacion.EmpresaSimilarDAO;
import com.tmk.fidelizacion.EstudioDAO;
//import com.tmk.fidelizacion.FidelizacionHelper;
import com.tmk.fidelizacion.MarcaDeCombustibleDAO;
import com.tmk.fidelizacion.MarcaDeVehiculoDAO;
import com.tmk.fidelizacion.ModeloDeVehiculoDAO;
import com.tmk.fidelizacion.OcupacionDAO;
import com.tmk.fidelizacion.ReglasDePuntosDAO;
import com.tmk.fidelizacion.SistemaTVDAO;
import com.tmk.fidelizacion.SocioRefCodesLocalHome;
import com.tmk.fidelizacion.SocioTarjetasLocal;
import com.tmk.fidelizacion.SocioTarjetasLocalHome;
import com.tmk.fidelizacion.SocioVehiculoLocal;
import com.tmk.fidelizacion.SocioVehiculoLocalHome;
import com.tmk.fidelizacion.TarjetaDePuntajeDAO;
import com.tmk.fidelizacion.TelefonoCelularDAO;
import com.tmk.fidelizacion.TipoDeCombustibleDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.IdiomaDAO;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.MedioDeCobroDAO;
import com.tmk.kernel.PaisDAO;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ExtraService;
import com.tmk.soa.servicios.interfaces.Socio2Service;
//import com.tmk.socio.BufferSocioLocalHome;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.ShortCuts;
import com.tmk.xml.Resultado;

public class RegistrarSocioEXtra extends HttpServlet {
	private static int cantidadDeFidelizaciones;
	private static int cantidadDeDatosComplementarios;
	private static int cantidadDeFidelizacionesFalladas;

	public static int cantidadDeFidelizaciones() {
		return cantidadDeFidelizaciones;
	}

	public static int cantidadDeDatosComplementarios() {
		return cantidadDeDatosComplementarios;
	}

	public static int cantidadDeFidelizacionesFalladas() {
		return cantidadDeFidelizacionesFalladas;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=ISO-8859-1");
		 request.setCharacterEncoding("UTF8");

		SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
		boolean esSocioTMK = Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false);
		PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		Resultado resultado = null;
		if (socioPK != null) {
			 boolean aceptoEXtra = Convert.toBoolean(request.getParameter("aceptoEXtra"), false);
			 boolean estaFidelizado = (request.getSession().getAttribute(MainHelper.SESSION_PUNTAJE_FIDELIZACION) != null);

			 if (aceptoEXtra && !estaFidelizado) {

				 if (esSocioTMK) {
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
					 //registro el socio definitivamente.
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
					  } else if (ShortCuts.esSocioRegistradoSegunUnificacion(socioPK.ID_SUCURSAL.intValue()
												 , Globals.ID_CANAL_ALTERNATIVO, nacionalidad.intValue(), sexo, tipoDoc,
												 nroDoc.longValue())) {
							String nombres =  (String)request.getSession().getAttribute("Registracion.nombreCompleto");
							String email =  (String)request.getSession().getAttribute("Registracion.login");
							StringBuffer datosSocio = new StringBuffer();
							datosSocio.append("Datos del Socio").append("\r");
							datosSocio.append("E-Mail/Login: ").append(email).append("\r");
							datosSocio.append("Nombre: ").append(nombres).append("\r");
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
									"contactanos en <a href=\"mailto:"+ Globals.MAIL_CALL_CENTER + "\">" + Globals.MAIL_CALL_CENTER + "</a>."}
									, new String[] {"tipoDoc", "nroDoc", "nacionalidad", "sexo"});
									/*evalua socio duplicado a nivel cadena (TIPO y NRO DOC, NACIONALIDAD, SEXO)*/
					  } else if (fechaNacDD != null && fechaNacMM != null && fechaNacAAAA != null){
						   try {
							   fechaNac = MainHelper.convertirEnFecha(fechaNacDD + "/" +
									 					 fechaNacMM + "/" +
									 					 fechaNacAAAA,
									 					 "dd/MM/yyyy");
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
							 Connection conn = DBUtil.buildConnection();
							 try {
								 
								 Socio2Service servicio = ServiceLocator.getSocioService();
								//SocioTMK socioTMK = new SocioTMK(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL);
								 SocioTMK socioTMK = ServiceLocator.getSociosTMKService().findSocioTMKByPK(new com.tmk.src.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO)); 

								//socioTMK.select(conn);								
								
								//SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");								
								servicio.create(
										 socioPK.ID_SUCURSAL,
										 socioPK.ID_SOCIO,
										 new Integer(Globals.ID_CANAL_ALTERNATIVO),
										 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
									     Globals.TIPO_PERSONA_FISICA,
									     CryptUtil.encriptar(socioTMK.getLogin().toUpperCase().getBytes()),
									     socioTMK.getNombres().toUpperCase(),
									     socioTMK.getApellidos().toUpperCase(),
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
										 (String)null
								);

								/*socioLocalHome.create(
										 socioPK.ID_SUCURSAL,
										 socioPK.ID_SOCIO,
										 new Integer(Globals.ID_CANAL_ALTERNATIVO),
										 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
									     Globals.TIPO_PERSONA_FISICA,
									     CryptUtil.encriptar(socioTMK.getLogin().toUpperCase().getBytes()),
									     socioTMK.getNombres().toUpperCase(),
									     socioTMK.getApellidos().toUpperCase(),
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
										 (String)null);*/

								 //BufferSocioLocalHome bufferSocioHomeLocal = (BufferSocioLocalHome)DBUtil.getHome("BufferSocio");								 
								 ServiceLocator.getBufferSocioService().create(
										 socioPK.ID_SUCURSAL,
										 socioPK.ID_SOCIO,
										 new Integer(Globals.ID_CANAL_ALTERNATIVO),
										 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
									     Globals.TIPO_PERSONA_FISICA,
									     CryptUtil.encriptar(socioTMK.getLogin().toUpperCase().getBytes()),
									     socioTMK.getNombres().toUpperCase(),
									     socioTMK.getApellidos().toUpperCase(),
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
										 (String)null
								 );
								 
								 /*bufferSocioHomeLocal.create(
										 socioPK.ID_SUCURSAL,
										 socioPK.ID_SOCIO,
										 new Integer(Globals.ID_CANAL_ALTERNATIVO),
										 new Integer(Globals.ID_TIPO_CONTRIBUYENTE),
									     Globals.TIPO_PERSONA_FISICA,
									     CryptUtil.encriptar(socioTMK.getLogin().toUpperCase().getBytes()),
									     socioTMK.getNombres().toUpperCase(),
									     socioTMK.getApellidos().toUpperCase(),
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
										 (String)null);*/

								 request.getSession().removeAttribute("socioTMK");
								 ShortCuts.findListaBySocio(new com.tmk.src.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
								 //borro el socio tmk
								 try {
									 socioTMK.delete(conn);
								 } catch (Exception e) {
									 // si por algun motivo no logro borrar el socioTMK, esto no afecta
									 // al proceso de registracion de socioCadena
									 String err = "Error en RegistrarSocioEXtra] No se pudo borrar el socioTMK " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
									 MainHelper.enviarMailDeError(err);
									 TmkLogger.error(err);
								 }
								 /*FIN registracion del socio cadena*/

							 } catch (Exception e) {
								 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento he intentalo nuevamente"}, null);
								 String err = "Error en RegistrarSocioEXtra] Creacion de socio cadena" + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
								 MainHelper.enviarMailDeError(err);
								 TmkLogger.error(err);
							 } finally {
								 conn.close();
							 }
						 } catch (Exception e) {
							 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento he intentalo nuevamente"}, null);
							 String err = "RegistrarSocioEXtra] Abriendo conexion" + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
							 MainHelper.enviarMailDeError(err);
							 TmkLogger.error(err);
						 }
					}
				 }

				 if (resultado == null) {
				 // todo ok lo adhiero a eXtra!!!
					 /*FIDELIZACION*/
					 try {
						 //Levanta los EJB para tenerlos listos
						 BufferTarjetaLocalHome bufferTarjetaLocalHome = (BufferTarjetaLocalHome) DBUtil.getHome("BufferTarjeta");
						 BufferCuentaLocalHome bufferCuentaLocalHome = (BufferCuentaLocalHome) DBUtil.getHome("BufferCuenta");
						 BufferFormularioLocalHome bufferFormularioLocalHome = (BufferFormularioLocalHome) DBUtil.getHome("BufferFormulario");
						 BufferCuentasPorSocioLocalHome bufferCuentasPorSocioLocalHome = (BufferCuentasPorSocioLocalHome) DBUtil.getHome("BufferCuentasPorSocio");
						 BufferTarjetasPorCuentaLocalHome bufferTarjetasPorCuentaLocalHome = (BufferTarjetasPorCuentaLocalHome) DBUtil.getHome("BufferTarjetasPorCuenta");
						 //CtaCtaPuntosLocalHome ctaCtaPuntosLocalHome = (CtaCtaPuntosLocalHome) DBUtil.getHome("CtaCtaPuntos");
						 //SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
						 SocioRefCodesLocalHome socioRefCodesLocalHome = (SocioRefCodesLocalHome) DBUtil.getHome("SocioRefCodes");
						 SocioVehiculoLocalHome socioVehiculoLocalHome = (SocioVehiculoLocalHome) DBUtil.getHome("SocioVehiculo");
						 SocioTarjetasLocalHome socioTarjetasLocalHome = (SocioTarjetasLocalHome) DBUtil.getHome("SocioTarjetas");

						 Boolean infoEXtra = Convert.toBoolean(request.getParameter("infoEXtra"), null);
						 Boolean infoTerceros = infoEXtra; //  EN MARKETING DECIDIERON UNIFICAR LOS FLAGS

						 TmkLogger.debug("Desea informacion extra: " + Convert.toString(infoEXtra));

						 Boolean idPCHogar = Convert.toBoolean(request.getParameter("idPCHogar"), null);
						 Boolean idInternetHogar = Convert.toBoolean(request.getParameter("idInternetHogar"), null);
						 // Socio actual
						 Socios2 socioLogueado = ShortCuts.findSocioById(socioPK);
						 TmkLogger.debug("Fidelizacion] Socio logueado: Sucursal " + socioPK.ID_SUCURSAL + " Socio " + socioPK.ID_SOCIO);

						 // Busca el socio por DNI y fideliza al primero porque si se unifica el proceso aun no lo contempla
						 Socios2 socioAFidelizar = socioLogueado;
						 
						 SocioPK socioAFidelizarPK = new SocioPK(socioAFidelizar.getId_sucursal(), socioAFidelizar.getId_socio());
						 TmkLogger.debug("Fidelizacion] Socio logueado: Sucursal " + socioAFidelizarPK.ID_SUCURSAL + " Socio " + socioAFidelizarPK.ID_SOCIO);

						 // Algunos valores de configuracion
						 String USR_ALTA           = "SITE";
						 Integer ID_SUCURSAL_FIDELIZACION = new Integer(Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
						 Integer TITULAR           = new Integer(0);
						 String CANJE_HABILITADO   = "SI";

						 //String sequenceNumeroDeFormulario = DBUtil.getSequenceLong("NUMERO_FORMULARIO_EXTRA_SEQ").toString();
						 //String numeroDeFormulario = sequenceNumeroDeFormulario + DBUtil.getDBFunction("DVC", sequenceNumeroDeFormulario);
						 
						 ExtraService servicio = ServiceLocator.getExtraService(); 
						 
						 String numeroDeFormulario = servicio.getNumeroDeFormulario();
						 TmkLogger.debug("Fidelizacion] Numero de Formulario: " + numeroDeFormulario);

						 //String sequenceNumeroDeTarjeta = DBUtil.getSequenceLong("NUMERO_TARJETA_EXTRA_SEQ").toString();
						 //String numeroDeTarjeta    = sequenceNumeroDeTarjeta + DBUtil.getDBFunction("DVC", sequenceNumeroDeTarjeta);
						 
						 String numeroDeTarjeta    = servicio.getNumeroDeTarjeta();
						 TmkLogger.debug("Fidelizacion] Numero de Tarjeta: " + numeroDeTarjeta);

						 //Integer numeroDeCuenta    = DBUtil.getSequenceValue("FDN_ID_CUENTA_SEQ");
						 Integer numeroDeCuenta    = servicio.getNumeroDeCuenta();
						 Integer numeroCUSO        = new Integer(1);
						 Integer dperCodigo        = null;

						 // Graba la fecha y hora actual
						 Timestamp ahora = new Timestamp(new Date().getTime());

						 // Actualiza los campos del socio
						 Socios.actualizarSocio(socioAFidelizarPK, infoEXtra, infoTerceros, idPCHogar, idInternetHogar);
						 TmkLogger.debug("Fidelizacion] Datos adicionales del socio actualizados...");

						 boolean datosComplementarios = Convert.toBoolean(request.getParameter("datosComplementarios"), false);
						 // Crea el formulario de registracion
						 BufferFormularioLocal bufferFormularioLocal =
						 		bufferFormularioLocalHome.create(
				 				numeroDeFormulario, ahora, (datosComplementarios) ? "SI" :"NO",
								USR_ALTA, ahora,
								null, null,
								null, dperCodigo);
	 					 TmkLogger.debug("Fidelizacion] Formulario " + bufferFormularioLocal.getNRO_FORMULARIO() + ", fecha " + Convert.toStringLargo(bufferFormularioLocal.getF_ALTA()) + "...");

	 					 // Crea la cuenta de fidelizacion
							BufferCuentaLocal bufferCuentaLocal =
									bufferCuentaLocalHome.create(
											numeroDeCuenta, ID_SUCURSAL_FIDELIZACION, ahora,
											Globals.FIDELIZACION_CUENTA_HABILITADA, ahora, null, null,
											USR_ALTA, ahora, null, null);
							TmkLogger.debug("Fidelizacion] Numero de cuenta " + bufferCuentaLocal.getID_CUENTA() + " para " + bufferCuentaLocal.getID_SUCURSAL());

							// Asigna una tarjeta a la cuenta
							BufferTarjetaLocal bufferTarjetaLocal =
									bufferTarjetaLocalHome.create(
											numeroDeTarjeta, Globals.FIDELIZACION_TARJETA_HABILITADA, ahora,
											USR_ALTA, null, USR_ALTA, ahora, null, null);
							TmkLogger.debug("Fidelizacion] Numero de tarjeta " + bufferTarjetaLocal.getNRO_TARJETA() + ", habilitada: " + Convert.toString(bufferTarjetaLocal.getESTADO()));

							// Asocia la tarjeta a la cuenta
							BufferTarjetasPorCuentaLocal bufferTarjetasPorCuentaLocal =
									bufferTarjetasPorCuentaLocalHome.create(
											numeroDeTarjeta, numeroDeCuenta, ID_SUCURSAL_FIDELIZACION, numeroCUSO,
											null, USR_ALTA, ahora, null, null, numeroDeFormulario);
							TmkLogger.debug("Fidelizacion] Asociacion con tarjeta " + bufferTarjetasPorCuentaLocal.getNRO_TARJETA() + ", cuenta " + bufferTarjetasPorCuentaLocal.getID_CUENTA() + ", cuso " + bufferTarjetasPorCuentaLocal.getID_CUSO() + ", formulario " + bufferTarjetasPorCuentaLocal.getNRO_FORMULARIO());

							// Asocia la cuenta al socio
							BufferCuentasPorSocioLocal bufferCuentasPorSocioLocal =
									bufferCuentasPorSocioLocalHome.create(
											numeroDeCuenta, ID_SUCURSAL_FIDELIZACION, numeroCUSO,
											socioAFidelizarPK.ID_SOCIO, socioAFidelizarPK.ID_SUCURSAL, dperCodigo, TITULAR,
											null, CANJE_HABILITADO, USR_ALTA, ahora, null, null);
							TmkLogger.debug("Fidelizacion] Asociacion con cuenta " + bufferCuentasPorSocioLocal.getID_CUENTA() + ", socio " + bufferCuentasPorSocioLocal.getID_SOCIO() + ", sucursal " + bufferCuentasPorSocioLocal.getID_SUCURSAL());

							// Le va a agregar puntos por fidelizarse						
							agregarPuntos(socioAFidelizarPK, numeroDeCuenta, numeroDeTarjeta, Globals.REGLA_FDN_POR_ADHESION, USR_ALTA, ahora);

							if (datosComplementarios) {

								TmkLogger.debug("Fidelizacion] Carga datos complementarios");

								// Le va a agregar puntos por fidelizarse con datos complementarios
								agregarPuntos(socioAFidelizarPK, numeroDeCuenta, numeroDeTarjeta, Globals.REGLA_FDN_POR_DATOS_COMPLEMENTARIOS, USR_ALTA, ahora);

								// Toma los parametros para insertar el formulario
								EstudioDAO estudioDAO = EstudioDAO.get(request.getParameter("idEstudio"));
								OcupacionDAO ocupacionDAO = OcupacionDAO.get(request.getParameter("idOcupacion"));
								IdiomaDAO idiomaDAO = IdiomaDAO.buscaIdioma(request.getParameter("idIdioma"));
								ActividadLaboralDAO actividadLaboralDAO = ActividadLaboralDAO.get(request.getParameter("idRamo"));
								SistemaTVDAO sistemaTVDAO = SistemaTVDAO.get(request.getParameter("idSistemasTV"));
								MedioDeCobroDAO tarjetasDAO = MedioDeCobroDAO.buscaMedioDeCobro(request.getParameter("idTarjetas"));

								EmpresaSimilarDAO empresaSimilarDAO = EmpresaSimilarDAO.get(request.getParameter("idCompra"));
								TarjetaDePuntajeDAO tarjetaDePuntajeDAO = TarjetaDePuntajeDAO.get(request.getParameter("idTarjetaPuntaje"));
								TelefonoCelularDAO telefonoCelularDAO = TelefonoCelularDAO.get(request.getParameter("idCelular"));
								Boolean tieneVehiculo = Convert.toBoolean(request.getParameter("tieneVehiculo"), new Boolean(false));
								String marcaVehiculo = Convert.toString(request.getParameter("marcaVehiculo"), null);
								String modeloVehiculo = Convert.toString(request.getParameter("modeloVehiculo"), null);
								Integer añoVehiculo = Convert.toNumber(request.getParameter("anoVehiculo"), (Integer)null);
								MarcaDeCombustibleDAO marcaDeCombustibleDAO = MarcaDeCombustibleDAO.get(request.getParameter("idMarcaCombustible"));
								TipoDeCombustibleDAO tipoDeCombustibleDAO = TipoDeCombustibleDAO.get(request.getParameter("idTipoCombustible"));

								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, estudioDAO.getDomain(), estudioDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, ocupacionDAO.getDomain(), ocupacionDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, idiomaDAO.getDomain(), idiomaDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, actividadLaboralDAO.getDomain(), actividadLaboralDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, sistemaTVDAO.getDomain(), sistemaTVDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, empresaSimilarDAO.getDomain(), empresaSimilarDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, tarjetaDePuntajeDAO.getDomain(), tarjetaDePuntajeDAO.getId(), USR_ALTA, ahora);
								agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, telefonoCelularDAO.getDomain(), telefonoCelularDAO.getId(), USR_ALTA, ahora);

								if (tieneVehiculo.booleanValue()) {
									boolean vehiculoOK = false;
									for (int i = 0; i < Globals.MARCAS_DE_VEHICULOS.length; i++) {
										MarcaDeVehiculoDAO marca = Globals.MARCAS_DE_VEHICULOS[i];
									    if (marca.getId().equals(marcaVehiculo)) {
											ModeloDeVehiculoDAO modelos[] = marca.getModelos();
										    for (int j = 0; j< modelos.length; j++) {
											    if (modelos[j].getId().equals(modeloVehiculo)) {
												    vehiculoOK = true;
											    }
										    }
									    }
									}
									if (vehiculoOK) {
										SocioVehiculoLocal socioVehiculoLocal =
												socioVehiculoLocalHome.create(
														socioAFidelizarPK.ID_SOCIO, socioAFidelizarPK.ID_SUCURSAL, new Integer(1),
														marcaVehiculo, modeloVehiculo, añoVehiculo, USR_ALTA, ahora, null, null);
										agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, marcaDeCombustibleDAO.getDomain(), marcaDeCombustibleDAO.getId(), USR_ALTA, ahora);
										agregarDatos(socioRefCodesLocalHome, socioAFidelizarPK, tipoDeCombustibleDAO.getDomain(), tipoDeCombustibleDAO.getId(), USR_ALTA, ahora);
										TmkLogger.debug("Fidelizacion] Vehiculo marca " + socioVehiculoLocal.getID_MARCA() + ", modelo " + socioVehiculoLocal.getID_MODELO() + " año " + socioVehiculoLocal.getANIO_MODELO());
									} else {
										TmkLogger.debug("Fidelizacion] no se pudo grabar el vehiculo:" +  marcaVehiculo + " " + modeloVehiculo);
									}
								}

								SocioTarjetasLocal socioTarjetasLocal =
										socioTarjetasLocalHome.create(USR_ALTA, ahora, null, null, null, null, tarjetasDAO.getId(), socioAFidelizarPK.ID_SUCURSAL, socioAFidelizarPK.ID_SOCIO);
								TmkLogger.debug("Fidelizacion] Tarjetas " + socioTarjetasLocal.getID_MEDIO_COBRO());

								cantidadDeDatosComplementarios++;
							}

							// Termino la fidelizacion exitosamente
							cantidadDeFidelizaciones++;

							// Ahora que esta registrado carga los puntos
							com.tmk.src.fidelizacion.FidelizacionHelper.cargarPuntajeEnSession(request.getSession(), socioAFidelizar);
							resultado = new Resultado (true, new String[] {"Felicitaciones ya te encuentras adherido al programa eXtra.",""+request.getSession().getAttribute("PuntajeFidelizacion")+" puntos"}, null );
						 } catch (Exception e) {
							 resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarda un momento he intentalo nuevamente"}, null);
							 String err = "RegistrarSocioEXtra] Error en fidelizacion " + socioPK.ID_SOCIO + " " + socioPK.ID_SUCURSAL + " " + e.toString() + " " + MainHelper.getMessage(e);
							 MainHelper.enviarMailDeError(err);
							 TmkLogger.error(err);
							 cantidadDeFidelizacionesFalladas++;
						 }
					}
				 	/*FIDELIZACION*/
			} else {
				if (estaFidelizado) {
					//ya estaba fidelizado
					request.getSession().setAttribute("Registracion.feedback", "Ya te encuentras adherido al programa eXtra.");
					resultado = new Resultado (false, new String[] {"Ya te encuentras adherido al programa eXtra."}, null );
				} else {
					//no acepto eXtra
					resultado = new Resultado (false, new String[] {"No has aceptado adherirte al programa eXtra, por favor acepta para continuar. "}, new String[] {"aceptoEXtra"} );
				}
			}
			out.print(xstream.toXML(resultado).replaceAll("\n", ""));
		} else {
			//no esta logueado
			request.getSession().setAttribute("Registracion.feedback", "TU SESION HA CONCLUIDO POR FAVOR REALICE SU LOGIN NUEVAMENTE.");
			resultado = new Resultado (false, new String[] {"TU SESION HA CONCLUIDO POR FAVOR REALICE SU LOGIN NUEVAMENTE."}, null );
			resultado.setTargetRedirect("/miCuenta");
			out.print(xstream.toXML(resultado).replaceAll("\n", ""));
		}
	}

	//ANTES Lanzaba la excepcion throws CreateException y no dejaba fidelizar
	//Es probable que los datos esten cargados de antes por lo que voy a dejar de lanzar
	//la excepcion y controlar
	private void agregarDatos(SocioRefCodesLocalHome socioRefCodesLocalHome,
	        SocioPK socioPK, String domain, String id,
	        String usrAlta, Timestamp ahora) throws CreateException  {
		try {
			socioRefCodesLocalHome.create(
			socioPK.ID_SOCIO, socioPK.ID_SUCURSAL,
			domain, id, usrAlta, ahora, null, null, null, null, null);
			TmkLogger.debug("Fidelizacion] Referencia " + domain + " valor " + id);
		} catch (javax.ejb.DuplicateKeyException de) {
			//no graba el dato porque ya existe
		}
	}

	private void agregarPuntos(
            SocioPK socioPK, Integer numeroDeCuenta, String numeroDeTarjeta,
            ReglasDePuntosDAO regla,
            String usrAlta, Timestamp ahora)  throws SQLException, NamingException {
		Connection conn = DBUtil.buildConnection();
		try {
			StringBuffer qry = new StringBuffer();
			qry.append(" INSERT INTO FDN_CTA_CTE_PUNTOS");
			qry.append(" (ID_SUCURSAL, ID_CCPT,");
			qry.append("  ID_SOCIO, ID_SUCURSAL_SOCIO,");
			qry.append("  ID_CUENTA, ID_SUCURSAL_CUENTA,");
			qry.append("  NRO_TARJETA, ID_CONCEPTO,");
			qry.append("  ID_REGLA,");
			qry.append("  PUNTOS, ");
			qry.append("  USR_ALTA, ");
			qry.append("  FECHA,");
			qry.append("   SIGNO_SALDO, IMPORTE_ADICIONAL)");
			qry.append(" VALUES (");
			qry.append(" ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			
			ps.setInt(1, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
			ps.setInt(2, DBUtil.getSequenceValue("FDN_ID_CCPT_SEQ").intValue());
			ps.setInt(3, socioPK.ID_SOCIO);
			ps.setInt(4, socioPK.ID_SUCURSAL);
			ps.setInt(5, numeroDeCuenta);
			ps.setInt(6, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
			ps.setString(7, numeroDeTarjeta);
			ps.setInt(8, Globals.FDN_CONCEPTO_EVENTO);
			ps.setInt(9, regla.getIdRegla());
			ps.setInt(10, regla.getPuntos());
			ps.setString(11, "SITE");
			ps.setTimestamp(12, new Timestamp(new Date().getTime()));
			//ps.setInt(13, regla.getPuntos());
			ps.setInt(13, 1);
			ps.setNull(14, Types.NUMERIC);
			
			try {
				ps.execute();
			} finally {
				ps.close();
			}
		} finally {
			conn.close();
		}
	}
/**	
	private void agregarPuntos(CtaCtaPuntosLocalHome ctaCtaPuntosLocalHome, Integer sucursalTmk,
            SocioPK socioPK, Integer numeroDeCuenta, String numeroDeTarjeta,
            ReglasDePuntosDAO regla,
            String usrAlta, Timestamp ahora) throws SQLException, NamingException, CreateException {

			// Si no tiene regla no hace nada
			if ((regla == null) || (regla.getPuntos() == 0)) {
				TmkLogger.debug("Fidelizacion] No existe la regla o no tiene puntos");
			} else {
				Integer ccpt = DBUtil.getSequenceValue("FDN_ID_CCPT_SEQ");
				CtaCtaPuntosLocal ctaCtaPuntosLocal =
				ctaCtaPuntosLocalHome.create(
						sucursalTmk, ccpt, null, null, null, null, null, null, null, null, null, null,
						socioPK.ID_SOCIO, socioPK.ID_SUCURSAL, numeroDeCuenta, sucursalTmk, numeroDeTarjeta,
						new Integer(Globals.FDN_CONCEPTO_EVENTO), regla.getIdRegla(),
						null, null, null, new Integer(regla.getPuntos()), null,
						null, null, null, usrAlta, ahora, null, null, ahora,
						// Segun JJC no van datos en estas columnas
						// NO, son not null, asi que se inserta con el valor tal como estan en comercial
						new Integer(regla.getPuntos()), new Integer(1));
			TmkLogger.debug("Fidelizacion] La regla (" + regla.getId() + " - " + regla.getNombre() + ") le otorga " + regla.getPuntos() + " puntos");
			}
	}
	*/
}
