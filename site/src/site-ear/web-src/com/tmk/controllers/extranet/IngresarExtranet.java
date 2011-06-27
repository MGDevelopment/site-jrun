/**
 * @author Lizardo Santiago
 *
 * $Log: IngresarExtranet.java,v $
 * Revision 1.4  2008/04/09 20:20:18  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.3  2003/11/03 20:57:55  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.2  2003/10/23 14:52:05  SLizardo
 * no message
 *
 * Revision 1.1  2003/10/14 08:31:28  SLizardo
 * no message
 *    
 */
package com.tmk.controllers.extranet;

import com.tmk.admin.AlianzaLocalHome;
import com.tmk.admin.AlianzaLocal;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import java.io.IOException;

public final class IngresarExtranet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		String USUARIO = request.getParameter("USUARIO");
		String CLAVE = request.getParameter("CLAVE");

		try
		{
			AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
			AlianzaLocal alianza = alianzaHome.findByUsuarioClave(USUARIO, CLAVE);

			session.setAttribute("Extranet.ID_ALIANZA", alianza.getID_ALIANZA());
			String redirect = (String)session.getAttribute("Extranet.redirect");
			if (redirect != null) {
				session.setAttribute("Extranet.redirect", null);
				response.sendRedirect(redirect);
			} else {
				response.sendRedirect("/extranet/main.jsp");
			}	
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch (FinderException fe)
		{
			session.setAttribute("Extranet.feedback", "Usuario o Clave Incorrectos.");

			response.sendRedirect("/extranet/index.jsp");
		}
	}
}
