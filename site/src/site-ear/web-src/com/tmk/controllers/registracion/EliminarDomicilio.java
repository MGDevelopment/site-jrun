/**
 * @author Lizardo Santiago
 *
 * $Log: EliminarDomicilio.java,v $
 * Revision 1.5  2003/11/03 20:57:19  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.4  2003/10/03 16:30:31  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/08/29 17:55:17  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.2  2003/08/25 20:46:11  SLizardo
 * Optimize Imports
 *
 * Revision 1.1  2003/07/31 14:36:28  SLizardo
 * ABM de Domicilios
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.socio.SocioDomicilioLocal;
import com.tmk.socio.SocioDomicilioLocalHome;
import com.tmk.socio.SocioDomicilioPK;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarDomicilio extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Integer ID_SUCURSAL = Integer.valueOf(request.getParameter("ID_SUCURSAL"));
			Integer ID_SOCIO = Integer.valueOf(request.getParameter("ID_SOCIO"));
			String TIPO_DOMICILIO = request.getParameter("TIPO_DOMICILIO");

			SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome)DBUtil.getHome("SocioDomicilio");
			SocioDomicilioPK pk = new SocioDomicilioPK(ID_SUCURSAL, ID_SOCIO, TIPO_DOMICILIO);
			SocioDomicilioLocal domicilio = domicilioHome.findByPrimaryKey(pk);
			domicilio.remove();
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

		String _DISPATCHER = request.getParameter("_DISPATCHER");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(_DISPATCHER);
		requestDispatcher.forward(request, response);
	}
}
