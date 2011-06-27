/*Log$
 *
 */
package com.tmk.controllers.fidelizacion;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
//import java.net.URLEncoder;

import com.tmk.controllers.MainHelper;
import com.tmk.controllers.fidelizacion.ActualizacionEMailManager;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
//import com.tmk.seguridad.EncripcionURL;

public class IniciarActDeEmail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "Por favor complete todos los datos requeridos para realizar la actualización");
		response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipoDoc =  request.getParameter(ActualizacionEMailManager.CAMPO_TIPO_DOC);
		String nroDoc = request.getParameter(ActualizacionEMailManager.CAMPO_NRO_DOC);
		int idPais = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_ID_PAIS), 0);
		String sexo = request.getParameter(ActualizacionEMailManager.CAMPO_SEXO);
		String eMail = request.getParameter(ActualizacionEMailManager.CAMPO_EMAIL);
		String password = request.getParameter(ActualizacionEMailManager.CAMPO_PASSWORD);
		String tipoDomicilio = request.getParameter(ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO);
		String calle = request.getParameter(ActualizacionEMailManager.CAMPO_CALLE);
		int numero = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_NUMERO), 0);
		String edificio = request.getParameter(ActualizacionEMailManager.CAMPO_EDIFICIO);
		int piso = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_PISO), 0);
		String depto = request.getParameter(ActualizacionEMailManager.CAMPO_DEPTO);
		String CP = request.getParameter(ActualizacionEMailManager.CAMPO_CP);
		int idPaisDir = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_ID_PAIS_DIR), 0);
		int idProvincia = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR), 0);
		String strProvincia = request.getParameter(ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR);
		int idLocalidad = Convert.toNumber(request.getParameter(ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR), 0);
		String strLocalidad = request.getParameter(ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR);
		String tipoTelefono = request.getParameter(ActualizacionEMailManager.CAMPO_TIPO_TELEFONO);
		String codArea = request.getParameter(ActualizacionEMailManager.CAMPO_COD_AREA);
		String nroTel = request.getParameter(ActualizacionEMailManager.CAMPO_NRO_TEL);
		String interno = request.getParameter(ActualizacionEMailManager.CAMPO_EXT_INT);

		//String conPassword = request.getParameter("conPassword");
		String cabeceraMsg = "IniciarActDeEmail.doPost(" + tipoDoc + ", " + nroDoc + ", " +
				idPais + ", " + sexo + ", " + eMail + ", " + password + ", " + tipoDomicilio + ", " +
				calle + ", " + numero + ", " + edificio + ", " + piso + ", " + depto + ", " +
				CP + ", " + idPaisDir + ", " + idProvincia + ", " + strProvincia + ", " + idLocalidad + ", " +
				tipoTelefono + ", " + codArea + ", " + nroTel + ", " + interno + ")";

		if (tipoDoc != null && nroDoc != null && idPais != 0 && sexo != null
				&& eMail != null && password != null &&
				(tipoDomicilio.equals("") ||
				(!tipoDomicilio.equals("") && calle != null &&
				((idProvincia == 99999 && strProvincia != null) || idProvincia != 99999)
				&& ((idLocalidad == 99999 && strLocalidad != null) || idLocalidad != 99999)
				)) &&
				(tipoTelefono.equals("") ||
				(!tipoTelefono.equals("") && codArea != null & nroTel != null)
				)) {
			nroDoc = nroDoc.replaceAll("\\W", "").replaceAll("\\p{Punct}","");
			if (!ActualizacionEMailManager.mailEnUso(eMail)) {
				String nombres = ActualizacionEMailManager.getNombreSocioFidelizado(tipoDoc, nroDoc, idPais, sexo);
				//el socio existe y esta fidelizado
				if (nombres != null) {
					try {
						long codigo = ActualizacionEMailManager.getCodigo();
						try {
							if (tipoDomicilio.equals("")) {
								idPaisDir = 0;
								idProvincia = 0;
								idLocalidad = 0;
							}
							ActualizacionEMailManager.setInicioActualizacionEmail(codigo, tipoDoc,
									nroDoc, idPais, sexo, eMail.toUpperCase(), password, tipoDomicilio, calle,
									numero, edificio, piso, depto, CP, idLocalidad, idProvincia,
									idPaisDir, strProvincia, strLocalidad, tipoTelefono, codArea,
									nroTel, interno);

							StringBuffer bodyTXT = new StringBuffer(Convert.nombrePropio(nombres,false)).append(Globals.ENTER);
							bodyTXT.append("Acabas de iniciar el proceso de actualización de datos en Tematika.com.").append(Globals.ENTER);							
							bodyTXT.append("Por favor ingresa a este link \"").append(Globals.PAGINA_SITIO).append(ActualizacionEMailManager.CONTROLADOR_FIN).append("?codigo=").append(codigo);
							bodyTXT.append("\" para completar el proceso");
							String cuerpoMail;
							if (ActualizacionEMailManager.actualizadoPreviamente(tipoDoc, new Long(nroDoc).longValue(), idPais, sexo)) {
								cuerpoMail = ActualizacionEMailManager.CUERPO_EMAIL_SEGUNDA;
								bodyTXT.append(".");
							} else {
								cuerpoMail = ActualizacionEMailManager.CUERPO_EMAIL;
								bodyTXT.append(" y adquirir tus puntos eXtra.");
							}

							MailUtil.sendMail(Globals.MAIL_CALL_CENTER,
									eMail, "Actualización de datos - " + Globals.NOMBRE_DEL_SITIO,
									bodyTXT.toString(), cuerpoMail + "?codigo=" + codigo);
									TmkLogger.debug("CODIGO] " + codigo);
							response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_INICIO);
							return;
						} catch (Exception e) {
							TmkLogger.error(cabeceraMsg + "]" + " error en seteo de datos para envio de mail " + e.toString());
							MainHelper.enviarMailDeError(cabeceraMsg + "]" + " error en seteo de datos para envio de mail " + e.toString());
							response.sendRedirect(Globals.PAGINA_ERROR);
							return;
						}
					} catch (Exception e) {
						TmkLogger.error(cabeceraMsg + "]" + " error obteniendo codigo");
						MainHelper.enviarMailDeError(cabeceraMsg + "]" + " error en seteo de datos para envio de mail " + e.toString());
						response.sendRedirect(Globals.PAGINA_ERROR);
						return;
					}
				} else {
					//datos no corresponden a socio fidelizado
					TmkLogger.info(cabeceraMsg + "]" + " Los datos no corresponden a un socio fidelizado");
					request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "Los datos ingresados no corresponden a un socio fidelizado.");
					response.sendRedirect(ActualizacionEMailManager.PAGINA_CARGA);
					return;
				}
			} else {
//				el mail esta en uso
				TmkLogger.info(cabeceraMsg + "]" + " La nueva direccion de mail esta en uso");
				request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "La nueva direccion de mail esta en uso.");
				response.sendRedirect(ActualizacionEMailManager.PAGINA_CARGA);
				return;
			}
		} else {
			//los datos no estan completos
			request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "Por favor complete todos los datos requeridos para realizar la actualización");
			response.sendRedirect(ActualizacionEMailManager.PAGINA_CARGA);
			return;
		}
	}
}