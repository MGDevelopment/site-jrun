/**
 * @author Lizardo Santiago
 *
 * $Log: AltaInstitucional.java,v $
 * Revision 1.4  2004/02/11 19:34:35  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.3  2003/11/26 15:38:15  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.2  2003/10/23 20:46:27  JMembrives
 * cambio de destinatario
 *
 * Revision 1.1  2003/10/22 19:01:13  SLizardo
 * no message
 *
 */
package com.tmk.controllers.misc;

import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public final class AltaInstitucional extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StringBuffer body = new StringBuffer();

		MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, Globals.NOMBRE_DEL_SITIO + ": Alta Institucional", body.toString());

		response.sendRedirect("/institucional/institucionalAgregado.jsp");
	}
}
