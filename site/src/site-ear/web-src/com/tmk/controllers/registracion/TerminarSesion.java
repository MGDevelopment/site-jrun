/**
 * @author Lizardo Santiago
 *
 * $Log: TerminarSesion.java,v $
 * Revision 1.16  2009/03/20 19:02:47  oClopez
 * cambio viernes
 *
 * Revision 1.15  2008/04/09 20:20:26  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.14  2006/11/27 12:27:14  oLSuarez
 * Rediseño de las páginas de sección miCuenta
 * Rediseño de las páginas carrito.jsp y papelDeRegalo.jsp
 *
 * Revision 1.13  2006/11/08 15:41:08  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.12  2005/10/04 19:59:58  omsartori
 * - correccion reporte beneficios referente
 * - Seguimiento empro, visitas por canal
 *
 * Revision 1.11  2004/05/04 18:11:10  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.10  2003/12/22 22:28:01  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.9  2003/10/10 17:21:22  NRodriguez
 * - Mensaje de conexion
 *
 * Revision 1.8  2003/09/08 13:54:47  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.7  2003/08/29 20:39:32  SLizardo
 * no message
 *
 * Revision 1.6  2003/08/26 16:19:35  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.5  2003/08/25 20:46:13  SLizardo
 * Optimize Imports
 *
 * Revision 1.4  2003/08/09 22:16:02  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/08 19:13:55  GPistoia
 * -Cambios para SocioDAO
 *
 */
package com.tmk.controllers.registracion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmk.controllers.MainHelper;

import java.io.IOException;
import java.util.Enumeration;

public class TerminarSesion extends HttpServlet {

	private static int cantidadSesionesCerradas;

	public static int getCantidadSesionesCerradas() {
		return cantidadSesionesCerradas;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.removeAttribute("Registracion.socioPK");
		session.removeAttribute("Registracion.nombreCompleto");
		session.removeAttribute("Registracion.nombre");
		session.removeAttribute("Registracion.login");
		session.removeAttribute("PuntajeFidelizacion");
		session.removeAttribute("socioTMK");
		session.removeAttribute("ordenDAO");
		session.removeAttribute(MainHelper.URL_REDIRECT);
		//elimino las validaciones del proceso de compras
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String param = e.nextElement();
			if(param.startsWith("procesoDeCompraNuevo")){
				session.removeAttribute(param);
			}
		}
		//fin bloque
		cantidadSesionesCerradas++;
		response.sendRedirect("/miCuenta");
	}
}
