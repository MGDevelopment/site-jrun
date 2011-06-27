/**
 * $Log: ConsultaDePuntos.java,v $
 * Revision 1.9  2009/03/20 18:24:11  msartori
 * - Meta Tags 
 * - Detalle y paginas derivadas 
 * - Buscador 
 *
 * Revision 1.8  2007/12/18 20:11:52  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.7  2007/07/25 20:07:46  omsartori
 * - Nuevo diseño de fidelizacion
 * - Actualizacion de Datos
 *      - Encripcion de codigos
 *
 * Revision 1.6  2006/01/13 15:45:52  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.5  2005/09/29 12:45:27  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.4  2004/11/01 16:33:18  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.3  2004/09/23 18:45:08  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.2  2004/09/10 15:13:20  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.1  2004/05/04 18:11:06  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 */
package com.tmk.controllers.fidelizacion;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.src.fidelizacion.FidelizacionHelper;
import com.tmk.src.fidelizacion.PuntosNoDisponiblesException;
import com.tmk.src.fidelizacion.PuntajeWrapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class ConsultaDePuntos extends HttpServlet {

	public static String CONSULTA_POR           = "CONSULTA_POR";
	public static int    CONSULTA_POR_DOCUMENTO = 0;
	public static int    CONSULTA_POR_TARJETA   = 1;

	public static String CAMPO_NRO_TARJETA = "NRO_TARJETA";

	public static String CAMPO_TIPO_DE_DOCUMENTO = "TIPO_DOCUMENTO";
	public static String CAMPO_NRO_DE_DOCUMENTO = "NRO_DOCUMENTO";
	public static String CAMPO_NACIONALIDAD = "NACIONALIDAD";
	public static String CAMPO_SEXO = "SEXO";

	public static String CONSULTA_PUNTOS_WRAPPER = "CONSULTA_PUNTOS_WRAPPER";
	public static String MENSAJE_USUARIO = "MENSAJE_USUARIO";

	public static String MOSTRAR_DETALLE = "MOSTRAR_DETALLE";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Borra los atributos de la session por si fallo recien
		session.removeAttribute(ConsultaDePuntos.CONSULTA_PUNTOS_WRAPPER);
		session.removeAttribute(ConsultaDePuntos.MENSAJE_USUARIO);

		try {
			boolean porTarjeta = new Integer(CONSULTA_POR_TARJETA).equals(Convert.toNumber(request.getParameter(CONSULTA_POR), (Integer)null));
			//Agregado para estadistica de puntos
			PuntajeWrapper puntos;
			//Agregado para estadistica de puntos
			if (porTarjeta) {
				String numeroTarjeta = Convert.toString(request.getParameter(CAMPO_NRO_TARJETA), null);
				puntos = FidelizacionHelper.consultarPuntos(numeroTarjeta);
				session.setAttribute(CONSULTA_PUNTOS_WRAPPER, puntos);
			} else {
				String sexo = Convert.toString(request.getParameter(CAMPO_SEXO), 'M');
				String tipoDocumento = Convert.toString(request.getParameter(CAMPO_TIPO_DE_DOCUMENTO), Globals.TIPO_DOCUMENTO_DNI.getId());
				Long numeroDocumento = Convert.toNumber(request.getParameter(CAMPO_NRO_DE_DOCUMENTO).replaceAll("\\W", "").replaceAll("\\p{Punct}",""), (Long)null);
				Integer nacionalidad = Convert.toNumber(request.getParameter(CAMPO_NACIONALIDAD), new Integer(Globals.ARGENTINA.getId()));
				puntos = FidelizacionHelper.consultarPuntos(sexo, tipoDocumento, numeroDocumento, nacionalidad);
				session.setAttribute(CONSULTA_PUNTOS_WRAPPER, puntos);
			}


			// Salta a la pagina de resultado si funcionó
			response.sendRedirect("/fidelizacion/panel/responsePuntos.jsp");
			return;

		} catch (PuntosNoDisponiblesException e) {
			// Pone el mensaje de la excepcion
			session.setAttribute(MENSAJE_USUARIO, e.getMessage());
			// redirige a la pagina de respuesta
			response.sendRedirect("/fidelizacion/panel/responsePuntos.jsp");
			return;
		} catch (Exception e) {
			// Pone el mensaje de la excepcion
			session.setAttribute(MENSAJE_USUARIO, "En este momento no es posible consultar sus puntos.");
			// redirige a la pagina de respuesta
			response.sendRedirect("/fidelizacion/panel/responsePuntos.jsp");
			return;
		}
	}
}