/**
 * @author Lizardo Santiago
 *
 * $Log: AgregarAfiliado.java,v $
 * Revision 1.23  2008/04/09 20:20:15  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.22  2007/01/17 20:47:23  oLSuarez
 * - Rediseño de afiliados
 *
 * - Rediseño de ranking
 *
 * - Creacion de los metodos: getArticulosParaTopExtend y getArticulosParaTopDeLibrosExtend
 *
 * Revision 1.21  2006/02/09 16:15:35  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.20  2006/01/31 15:51:34  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.19  2004/09/07 16:15:35  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.18  2004/08/09 13:41:48  omsartori
 * - Comentario para articulos desde la web
 * - Aprobación de comentarios desde la intranet
 * - Ancla para extensiones en detalle de articulo
 *
 * Revision 1.17  2004/05/04 18:10:59  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.16  2004/04/12 20:19:12  oGPistoia
 * - Cambios en la registracion
 * - Mejoras para las alianzas
 *
 * Revision 1.15  2004/03/25 18:19:49  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.14  2004/01/06 15:29:49  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.13  2003/12/12 21:51:21  GPistoia
 * -Correccion en paginas de extranet
 * -Liberacion de memoria en el revitalizer e inicializa el contador
 *
 * Revision 1.12  2003/12/04 17:21:21  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.11  2003/11/26 15:38:11  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.10  2003/11/11 16:06:56  JMembrives
 * correccion en mensaje de mail
 *
 * Revision 1.9  2003/11/11 14:31:40  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.8  2003/10/29 18:11:48  SLizardo
 * Codigo de area / Numero de Telefono
 *
 */
package com.tmk.controllers.alianza;

import com.tmk.admin.AlianzaLocalHome;
import com.tmk.admin.AlianzaTelefonoLocalHome;
import com.tmk.admin.AlianzaSeccionLocalHome;
import com.tmk.admin.AlianzaLocal;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.*;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public final class AgregarAfiliado extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        HttpSession session = request.getSession();

		String RAZON_SOCIAL = request.getParameter("RAZON_SOCIAL");
		String URL = request.getParameter("URL");
		String TIPO_NEGOCIO = request.getParameter("TIPO_NEGOCIO");
		String CUIT = request.getParameter("CUIT");
		String USUARIO = request.getParameter("USUARIO");
		String CLAVE = request.getParameter("CLAVE");
		Integer ID_TIPO_CONTRIBUYENTE = Convert.toNumber(request.getParameter("ID_TIPO_CONTRIBUYENTE"), new Integer(Globals.ID_TIPO_CONTRIBUYENTE));
		String NOMBRE_CONTACTO = request.getParameter("NOMBRE_CONTACTO");
		String APELLIDO_CONTACTO = request.getParameter("APELLIDO_CONTACTO");
		String CARGO_CONTACTO = request.getParameter("CARGO_CONTACTO");
		String NOMBRE_PAGO_COMISION = request.getParameter("NOMBRE_PAGO_COMISION");
		String APELLIDO_PAGO_COMISION = request.getParameter("APELLIDO_PAGO_COMISION");
		String E_MAIL_1 = request.getParameter("E_MAIL_1");
		String E_MAIL_2 = request.getParameter("E_MAIL_2");
		String TIPO_COMISION = request.getParameter("TIPO_COMISION");
        String COD_AREA = request.getParameter("COD_AREA");
        String NRO_TEL = request.getParameter("NRO_TEL");
        String EXT_INT = request.getParameter("EXT_INT");

        /*socio-alianza*/
      //  Integer ID_SOCIO = Convert.toNumber(request.getParameter("ID_SOCIO"), (Integer)null);

        /*if (ID_SOCIO==null) {
            response.sendRedirect("/afiliados/index.jsp");
            return;
        }*/
        /*socio-alianza*/

		try
		{

            try {
                AlianzaLocalHome alianzaLocalHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
			    AlianzaLocal alianza = alianzaLocalHome.findByUsuario(USUARIO);

                //vuelve al formulario porque el usuario ya existe.
                session.setAttribute("Extranet.feedback", "El nombre de usuario ya existe, por favor elija otro.");

    			String PaginaRedir = "/afiliados/afiliadoEstandar.jsp?page=/afiliados/agregarAfiliado.jsp&cambiaRight=true&" +
                        "RAZON_SOCIAL=" + RAZON_SOCIAL +
                        "&URL=" + URL +
                        "&TIPO_NEGOCIO=" + TIPO_NEGOCIO +
                        "&CUIT=" + CUIT +
                        "&USUARIO=" + USUARIO +
                        "&ID_TIPO_CONTRIBUYENTE=" + ID_TIPO_CONTRIBUYENTE +
                        "&NOMBRE_CONTACTO=" + NOMBRE_CONTACTO +
                        "&APELLIDO_CONTACTO=" + APELLIDO_CONTACTO +
                        "&CARGO_CONTACTO=" + CARGO_CONTACTO +
                        "&NOMBRE_PAGO_COMISION=" + NOMBRE_PAGO_COMISION +
                        "&APELLIDO_PAGO_COMISION=" + APELLIDO_PAGO_COMISION +
                        "&E_MAIL_1=" + E_MAIL_1 +
                        "&E_MAIL_2=" + E_MAIL_2 +
                        "&TIPO_COMISION=" + TIPO_COMISION +
                        "&COD_AREA=" + COD_AREA +
                        "&NRO_TEL=" + NRO_TEL +
                        "&EXT_INT=" + EXT_INT +
                        "&#CLAVE";

                response.sendRedirect(PaginaRedir);
                return;
            } catch (FinderException e) {
                // Continua porque el usuario no existe
            }

			Integer ID_ALIANZA = DBUtil.getSequenceValue("ALIANZA_SEQ");

			AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
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
                null
			);

			AlianzaSeccionLocalHome alianzaSeccionHome = (AlianzaSeccionLocalHome) DBUtil.getHome("AlianzaSeccion");
			// Crea una seccion default, a donde van a parar todas las visitas sin seccion
			alianzaSeccionHome.create(MainHelper.CONST_ALIANZA_SECCION_POR_DEFECTO, ID_ALIANZA, "Seccion por default");

			// Crea una seccion que luego envia por mail
			Integer ID_SECCION = DBUtil.getSequenceValue("ALIANZA_SECCION_SEQ");
			String SECCION_NOMBRE = "Generica";
			alianzaSeccionHome.create(ID_SECCION, ID_ALIANZA, SECCION_NOMBRE);

            MailUtil.sendMail(
                    Globals.MAIL_ALIANZAS,
                    E_MAIL_1,
                    "Bienvenido a " + Globals.NOMBRE_DEL_SITIO,
                    "Usted ha sido registrado en " + Globals.NOMBRE_DEL_SITIO + ". Muchas gracias por elegirnos.",
			        "/mailing/nuevoAfiliado.jsp?ID_ALIANZA=" + ID_ALIANZA + "&ID_SECCION=" + ID_SECCION);

			MailUtil.sendMail(
			        Globals.MAIL_MAILER,
			        "laguirre@ilhsa.com",
			        //Globals.MAIL_ADMINISTRADOR,
			        "Nuevo Afiliado",
			        "Nombre: " + RAZON_SOCIAL + ", ID: " + ID_ALIANZA,
			        "/mailing/detalleAfiliadoAlianza.jsp?ID_ALIANZA=" + ID_ALIANZA + "&ID_SECCION=" + ID_SECCION);

			AlianzaTelefonoLocalHome telefonoHome = (AlianzaTelefonoLocalHome)DBUtil.getHome("AlianzaTelefono");

            String TIPO_TELEFONO = "PART";

			telefonoHome.create(ID_ALIANZA, TIPO_TELEFONO, COD_AREA, NRO_TEL, EXT_INT);
		}

        catch (SQLException se)
		{
			TmkLogger.error(se.getMessage());
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch (CreateException ce)
		{
			TmkLogger.error(ce.getMessage());
		}

		response.sendRedirect("/afiliados/afiliadoEstandar.jsp?page=/afiliados/afiliadoAgregado.jsp&RAZON_SOCIAL="+RAZON_SOCIAL);
	}
}
