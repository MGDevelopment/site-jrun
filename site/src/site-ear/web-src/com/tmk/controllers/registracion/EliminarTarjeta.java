/**
 * @author Lizardo Santiago
 *
 * $Log: EliminarTarjeta.java,v $
 * Revision 1.6  2009/03/04 12:55:05  oClopez
 *  micuenta, proceso de compra, popego
 *
 * Revision 1.5  2003/11/03 20:57:20  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.4  2003/10/03 16:30:31  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/09 17:49:49  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.2  2003/09/02 19:39:46  SLizardo
 * Correcion en session.getAttribute
 *
 * Revision 1.1  2003/09/02 19:31:23  SLizardo
 * no message
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.socio.SocioPK;
import com.tmk.socio.TarjetaSocioLocal;
import com.tmk.socio.TarjetaSocioLocalHome;
import com.tmk.socio.TarjetaSocioPK;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EliminarTarjeta extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

		Integer ID_ITEM = Integer.valueOf(request.getParameter("ID_ITEM"));

		try
		{
			TarjetaSocioLocalHome tarjetaHome = (TarjetaSocioLocalHome)DBUtil.getHome("TarjetaSocio");
			TarjetaSocioPK pk = new TarjetaSocioPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, ID_ITEM);
			TarjetaSocioLocal tarjeta = tarjetaHome.findByPrimaryKey(pk);
			tarjeta.remove();
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch (FinderException fe)
		{
			TmkLogger.error(fe.getMessage());
		}
		catch (RemoveException re)
		{
			TmkLogger.error(re.getMessage());
		}

		String REFERER = request.getHeader("REFERER");
		if(request.getParameter("_DISPACHER") == null)
			response.sendRedirect(REFERER);
		else
			response.sendRedirect("/miCuenta/?seccionMiCuenta=12&opcionMenuTarjetas=0");
	}
}
