/**
 * @author Lizardo Santiago
 *
 * $Log: AgregarTarjeta.java,v $
 * Revision 1.8  2009/04/08 15:48:01  oClopez
 * modificaciones sobre feed back
 *
 * Revision 1.7  2009/03/04 12:55:05  oClopez
 *  micuenta, proceso de compra, popego
 *
 * Revision 1.6  2003/11/03 20:57:19  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.5  2003/10/09 19:30:15  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.4  2003/10/03 16:30:30  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/09/29 17:21:05  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.2  2003/09/09 17:49:48  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.1  2003/09/08 14:49:42  SLizardo
 * Agregar Tarjeta Socio
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Seguridad;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.socio.SocioPK;
import com.tmk.socio.TarjetaSocioLocalHome;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public final class AgregarTarjeta extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession();
			SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

			Integer ID_SUCURSAL_SOCIO = socioPK.ID_SUCURSAL;
			Integer ID_SOCIO = socioPK.ID_SOCIO;
			Integer ID_ITEM = DBUtil.getNuevoItemTarjetaSocio(ID_SUCURSAL_SOCIO, ID_SOCIO);
			String ID_MEDIO_COBRO = request.getParameter("ID_MEDIO_COBRO");
			String NRO_TARJETA = request.getParameter("NRO_TARJETA");
			String NOMBRE_TITULAR = request.getParameter("NOMBRE_TITULAR");
			String TIPO_DOC = request.getParameter("TIPO_DOC");
			Long NRO_DOC = Long.valueOf(request.getParameter("NRO_DOC"));
			String DIRECCION_RESUMEN = request.getParameter("DIRECCION_RESUMEN");

			TarjetaSocioLocalHome tarjetaHome = (TarjetaSocioLocalHome)DBUtil.getHome("TarjetaSocio");
			tarjetaHome.create(
			        ID_SUCURSAL_SOCIO,
			        ID_SOCIO,
			        ID_ITEM,
			        ID_MEDIO_COBRO,
			        Seguridad.numeroTarjetaAGrabar(Seguridad.encriptarTarjeta(NRO_TARJETA)), // las tarjetas van encriptadas
			        NOMBRE_TITULAR,
			        TIPO_DOC,
			        NRO_DOC,
			        DIRECCION_RESUMEN
			);
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch (SQLException se)
		{
			TmkLogger.error(se.getMessage());
		}
		catch (CreateException ce)
		{
			TmkLogger.error(ce.getMessage());
		}

		if(request.getParameter("_DISPACHER") == null)
			response.sendRedirect("/miCuenta/tarjetas.jsp");
		else
			response.sendRedirect("/miCuenta/?seccionMiCuenta=12&opcionMenuTarjetas=0");
	}
}
