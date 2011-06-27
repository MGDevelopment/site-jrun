/**
 * @author Lizardo Santiago
 *
 * $Log: AgregarAlianza.java,v $
 * Revision 1.12  2007/04/26 18:32:49  omsartori
 * no message
 *
 * Revision 1.11  2006/02/09 16:15:36  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.10  2006/01/31 15:51:35  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.9  2004/02/11 19:34:35  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.8  2003/12/12 21:51:22  GPistoia
 * -Correccion en paginas de extranet
 * -Liberacion de memoria en el revitalizer e inicializa el contador
 *
 * Revision 1.7  2003/11/11 14:31:41  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.6  2003/11/03 20:57:23  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.5  2003/10/27 22:02:10  NRodriguez
 * Correccion de la intranet/extranet
 *
 * Revision 1.3  2003/10/14 08:31:20  SLizardo
 * no message
 *
 */
package com.tmk.controllers.extranet.alianza;

import com.tmk.admin.AlianzaLocalHome;
import com.tmk.admin.AlianzaTelefonoLocalHome;
import com.tmk.kernel.*;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public final class AgregarAlianza extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Integer ID_ALIANZA = DBUtil.getSequenceValue("ALIANZA_SEQ");
			String RAZON_SOCIAL = request.getParameter("RAZON_SOCIAL");
			String URL = request.getParameter("URL");
			String TIPO_NEGOCIO = request.getParameter("TIPO_NEGOCIO");
			String CUIT = request.getParameter("CUIT");
			String USUARIO = request.getParameter("USUARIO");
			String CLAVE = request.getParameter("CLAVE");
			Integer ID_TIPO_CONTRIBUYENTE = Integer.valueOf(request.getParameter("ID_TIPO_CONTRIBUYENTE"));
			String NOMBRE_CONTACTO = request.getParameter("NOMBRE_CONTACTO");
			String APELLIDO_CONTACTO = request.getParameter("APELLIDO_CONTACTO");
			String CARGO_CONTACTO = request.getParameter("CARGO_CONTACTO");
			String NOMBRE_PAGO_COMISION = request.getParameter("NOMBRE_PAGO_COMISION");
			String APELLIDO_PAGO_COMISION = request.getParameter("APELLIDO_PAGO_COMISION");
			String E_MAIL_1 = request.getParameter("E_MAIL_1");
			String E_MAIL_2 = request.getParameter(" E_MAIL_2");
			String TIPO_COMISION = request.getParameter("TIPO_COMISION");
            Double PORC_COMISION_PARTICULAR = Double.valueOf(request.getParameter("PORC_COMISION_PARTICULAR"));

            /*socio-alianza*/
            //Integer ID_SOCIO = Convert.toNumber(request.getParameter("ID_SOCIO"),new Integer(null));

            /*if (ID_SOCIO==null) {
                response.sendRedirect("/afiliados/index.jsp");
                return;
            }*/
            /*socio-alianza*/

			AlianzaLocalHome alianzaHome = (AlianzaLocalHome) DBUtil.getHome("Alianza");
			alianzaHome.create(
			        ID_ALIANZA, RAZON_SOCIAL, URL,
			        TIPO_NEGOCIO, CUIT, USUARIO, CLAVE,
			        ID_TIPO_CONTRIBUYENTE, NOMBRE_CONTACTO,
			        APELLIDO_CONTACTO, CARGO_CONTACTO,
			        NOMBRE_PAGO_COMISION,
			        APELLIDO_PAGO_COMISION,
			        E_MAIL_1,
			        E_MAIL_2,
			        TIPO_COMISION,
                    PORC_COMISION_PARTICULAR

			);

			MailUtil.sendMail(
			        Globals.MAIL_MAILER,
			        Globals.MAIL_ADMINISTRADOR,
			        "Nueva Alianza",
			        "Nombre: " + RAZON_SOCIAL + ", ID: " + ID_ALIANZA,
			        "/mailing/detalleAfiliadoAlianza.jsp?ID_ALIANZA=" + ID_ALIANZA);

            AlianzaTelefonoLocalHome telefonoHome = (AlianzaTelefonoLocalHome)DBUtil.getHome("AlianzaTelefono");

			String TIPO_TELEFONO = "PART";
			String COD_AREA = request.getParameter("COD_AREA");
			String NRO_TEL = request.getParameter("NRO_TEL");
			String EXT_INT = request.getParameter("EXT_INT");

			telefonoHome.create(ID_ALIANZA, TIPO_TELEFONO, COD_AREA, NRO_TEL, EXT_INT);

		}
		catch(SQLException se)
		{
			TmkLogger.error(se.getMessage());
		}
		catch(NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch(CreateException ce)
		{
			TmkLogger.error(ce.getMessage());
		}

		response.sendRedirect("/236-TMK/alianzas/index.jsp");
	}
}
