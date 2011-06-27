/**
 * $Log: LoginIntranet.java,v $
 * Revision 1.3  2007/04/26 18:32:51  omsartori
 * no message
 *
 * Revision 1.2  2003/11/10 13:46:01  JMembrives
 * cambio de cnstantes
 *
 * Revision 1.1  2003/10/28 00:21:59  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/23 14:52:06  SLizardo
 * no message
 *
 * Revision 1.2  2003/10/23 14:25:30  JMembrives
 * no message
 *
 * Revision 1.1  2003/10/14 06:08:23  GPistoia
 * -Login extranet
 * -Control de seguridad en paginas de extranet
 *
 */
package com.tmk.controllers.intranet.admin;

import com.tmk.controllers.intranet.usuario.UsuarioHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class LoginIntranet extends HttpServlet {

	public static String USUARIO_EXTRANET = "USUARIO_EXTRANET";
	//public static String LOGIN = "LOGIN";
	//public static String PASSWORD = "PASSWORD";

	public static String PAGINA_PRINCIPAL = "/236-TMK";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String login = request.getParameter(UsuarioHelper.LOGIN);
		String password = request.getParameter(UsuarioHelper.PASSWORD);
		UsuarioDAO usuarioDAO = UsuarioDAO.login(login, password);
		if (usuarioDAO == null) {
			response.sendRedirect(UsuarioHelper.PAGINA_LOGIN_INTRANET);
		} else {
			session.setAttribute(USUARIO_EXTRANET, usuarioDAO);
			response.sendRedirect(UsuarioHelper.PAGINA_INICIO_INTRANET);
		}
	}

}
