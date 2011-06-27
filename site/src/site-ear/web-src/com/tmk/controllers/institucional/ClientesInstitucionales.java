/**
 * $Log: ClientesInstitucionales.java,v $
 * Revision 1.5  2009/03/11 14:46:44  msartori
 * no message
 *
 * Revision 1.4  2005/03/30 12:52:12  omsartori
 * - Clientes institucionales: nuevo formato para mail de resguardo, controlador evita mails vacios, cantidad de caracteres restringida en campo comentario
 * - Medio de cobro Rio Net Banking: Agregado en compra y en listado de la intranet.
 * - Cupones: anulacion de espacios en blanco y cambio de leyenda.
 * - Revitalizer: el cambio de modo a mantenimiento se efectua luego del anteultimo intento.
 *
 * Revision 1.3  2004/11/17 14:54:06  omsartori
 * - reemplazo de UTF8 por ISO-8859-1 en ClientesInsitucionales.java
 *
 * Revision 1.2  2004/11/01 16:33:19  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.1  2004/10/28 21:21:20  omsartori
 * - Formulario y envio de mail de clientes institucionales
 *
 */
package com.tmk.controllers.institucional;

import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URLEncoder;


public class ClientesInstitucionales extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer datos = new StringBuffer();

		String ciudad = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_CIUDAD));
		String codigoPostal = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL));
		String comentario = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_COMENTARIO)).replaceAll("\\n", "<br>");
		String direccion = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_DIRECCION));
		String fax = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_FAX));
		String mail = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_MAIL));
		String nombre = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_NOMBRE));
		String nombreFantasia = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_NOMBRE_FANTASIA));
		String pais = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_PAIS));
		String provincia = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_PROVINCIA));
		String razonSocial = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL));
		String tel = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_TEL));
		String telefono = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_TELEFONO));
		String url = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_URL));

		if (razonSocial == "" || direccion == "" || ciudad == "" || provincia == "" ||
		        pais == "" || codigoPostal == "" || tel == "" || nombre == "" || mail == "") {
				response.sendRedirect("/index.jsp");
				return;
		}




		datos.append(ClientesInstitucionalesHelper.CAMPO_CIUDAD + "=" + URLEncoder.encode(ciudad, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL + "=" + URLEncoder.encode(codigoPostal, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_COMENTARIO + "=" + URLEncoder.encode(comentario, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_DIRECCION + "=" + URLEncoder.encode(direccion, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_FAX + "=" + URLEncoder.encode(fax, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_MAIL + "=" + URLEncoder.encode(mail, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_NOMBRE + "=" + URLEncoder.encode(nombre, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_NOMBRE_FANTASIA + "=" + URLEncoder.encode(nombreFantasia, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_PAIS + "=" + URLEncoder.encode(pais, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_PROVINCIA + "=" + URLEncoder.encode(provincia, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL + "=" + URLEncoder.encode(razonSocial, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_TEL + "=" + URLEncoder.encode(tel, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_TELEFONO + "=" + URLEncoder.encode(telefono, "ISO-8859-1"));
		datos.append("&");
		datos.append(ClientesInstitucionalesHelper.CAMPO_URL + "=" + URLEncoder.encode(url, "ISO-8859-1"));

		//String textoPlano = datos.toString().replaceAll("&", ", ");

		String textoPlano = "Datos Institucionales "
		                + "\n" + "----- ---------------"
		                + "\n" + " Razon Social:          " + razonSocial
		                + "\n" + " Nombre de Fantasia:    " + nombreFantasia
		                + "\n" + " Direccion:             " + direccion
						+ "\n" + " Ciudad:                " + ciudad
						+ "\n" + " Provincia:             " + provincia
						+ "\n" + " Pais:                  " + pais
						+ "\n" + " Codigo Postal:         " + codigoPostal
						+ "\n" + " Tel:                   " + tel
						+ "\n" + " Fax:                   " + fax
						+ "\n" + " Url de la institucion: " + url
		                + "\n"
						+ "\n" + "Contacto "
		                + "\n" + "--------"
		                + "\n" + " Nombres y Apellido:    " + nombre
						+ "\n" + " Correo electronico:    " + mail
						+ "\n" + " Telefono:              " + telefono
						+ "\n" + " Comentarios:           " + comentario;


		TmkLogger.debug("Se envio un mail de Clientes Institucionales con " + textoPlano);

		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_CLIENTES_INSTITUCIONALES,
		        Globals.NOMBRE_DEL_SITIO + " - Clientes Institucionales",
		        textoPlano,    // para no tener que crear el mensaje dos veces
		        ClientesInstitucionalesHelper.PAGINA_MAIL + "?" + datos.toString());


		response.sendRedirect("/" + ClientesInstitucionalesHelper.PAGINA_CONFIRMACION);

	}
}