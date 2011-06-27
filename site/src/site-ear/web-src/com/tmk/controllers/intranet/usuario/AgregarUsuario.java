/**
 * Created by IntelliJ IDEA.
 * User: JMembrives
 * Date: Oct 31, 2003
 * Time: 12:42:56 PM
 * To change this template use Options | File Templates.
 */
package com.tmk.controllers.intranet.usuario;

import com.tmk.admin.UsuarioLocalHome;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.naming.NamingException;
import javax.ejb.CreateException;
import java.io.IOException;
import java.sql.SQLException;
import com.tmk.controllers.intranet.usuario.UsuarioHelper;


public class AgregarUsuario extends HttpServlet
{
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
        String nombre = request.getParameter(UsuarioHelper.NOMBRE);
        String apellido = request.getParameter(UsuarioHelper.APELLIDO);
		String login = request.getParameter(UsuarioHelper.LOGIN);
		String password = request.getParameter(UsuarioHelper.PASSWORD);
		/*UsuarioDAO usuarioDAO = UsuarioDAO.login(login, password);
		if (usuarioDAO == null) {
			response.sendRedirect(PAGINA_PRINCIPAL);
		} else {
			//session.setAttribute(USUARIO_EXTRANET, usuarioDAO);
			response.sendRedirect("/intranet/inicio.jsp");
		}*/

			UsuarioLocalHome usuario = (UsuarioLocalHome)DBUtil.getHome("Usuario");
		//	usuario.create(ID_USUARIO, login, password, nombre, apellido);
            System.out.println("el usuario fue dado de alta");
            System.out.println( "Nombre: " + nombre + "   Apellido: "+  apellido + "   Login: "+ login + "   Password: " + password );
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}

		response.sendRedirect(UsuarioHelper.PAGINA_PRINCIPAL_USUARIO);
	}
}
