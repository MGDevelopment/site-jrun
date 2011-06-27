/**
 * @author Lizardo Santiago
 *
 * $Log: SalirExtranet.java,v $
 * Revision 1.2  2003/10/23 21:09:50  SLizardo
 * no message
 *
 * Revision 1.1  2003/10/14 08:31:29  SLizardo
 * no message
 *    
 */
package com.tmk.controllers.extranet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public final class SalirExtranet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		session.removeAttribute("Extranet.ID_ALIANZA");

		response.sendRedirect("/extranet/index.jsp");
	}
}
