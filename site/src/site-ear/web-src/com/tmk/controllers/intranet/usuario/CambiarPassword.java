/**
 * Created by IntelliJ IDEA.
 * User: JMembrives
 * Date: Oct 31, 2003
 * Time: 1:23:18 PM
 * To change this template use Options | File Templates.
 */
package com.tmk.controllers.intranet.usuario;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.DBUtil;
import com.tmk.admin.UsuarioLocalHome;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.naming.NamingException;
import java.io.IOException;

public class CambiarPassword extends HttpServlet{

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
        UsuarioLocalHome usuario = (UsuarioLocalHome)DBUtil.getHome("Usuario");
        System.out.println("cambio password");

        }
       	catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
    response.sendRedirect(UsuarioHelper.PAGINA_PRINCIPAL_USUARIO);
}
}
