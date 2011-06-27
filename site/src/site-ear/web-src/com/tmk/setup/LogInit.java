/**
 * @author Lizardo Santiago
 *
 * $Log: LogInit.java,v $
 * Revision 1.3  2003/10/13 04:09:14  SLizardo
 * no message
 *
 */
package com.tmk.setup;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public final class LogInit extends HttpServlet
{
	public void init(ServletConfig servletConfig) throws ServletException
	{
		String prefix = servletConfig.getServletContext().getRealPath("/");
		String file = servletConfig.getInitParameter("log4j-init-file");

		if(file != null)
		{
			PropertyConfigurator.configure(prefix+file);
		}
	}
}
