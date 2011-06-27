/**
 * $Log: EliminarEvento.java,v $
 * Revision 1.5  2007/04/26 18:32:52  omsartori
 * no message
 *
 * Revision 1.4  2003/12/04 17:21:27  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/11/13 15:41:15  NRodriguez
 * - administracion de eventos via site.xml
 *
 * Revision 1.2  2003/11/03 20:57:51  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.1  2003/10/28 00:22:06  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/08 20:52:07  SLizardo
 * Rol "admin" a Evento.
 *
 * Revision 1.2  2003/10/03 16:30:25  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/09/16 23:08:18  SLizardo
 * Administracion de Eventos
 *
 */
package com.tmk.controllers.intranet.evento;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public final class EliminarEvento extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			int idEvento = Convert.toNumber(request.getParameter("ID_EVENTO"), 0);

			Contenido.getSite().getEventos().removeEvento(idEvento);

			// graba el archivo por si se olvida el usuario
			Contenido.saveFile();

		} catch (Exception e) {
			TmkLogger.error("No se pudo eliminar el evento " + e.getMessage());
		}

		response.sendRedirect("/236-TMK/eventos/index.jsp");
	}

}
