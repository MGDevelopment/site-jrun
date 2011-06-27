/**
 * $Log: AgregarEvento.java,v $
 * Revision 1.7  2007/04/26 18:32:52  omsartori
 * no message
 *
 * Revision 1.6  2003/12/04 17:21:26  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/11/13 18:40:37  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.controllers.intranet.evento;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.kernel.site.Evento;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public final class AgregarEvento extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// crea el evento nuevo
			Evento evento = new Evento();
			evento.setActivo(true);
			evento.setFecha(new Date());
			evento.setDescripcion("Nuevo evento");
			evento.setSucursal(Globals.ID_SUCURSAL_TEMATIKA);

			// agrega el evento
			Contenido.getSite().getEventos().addEvento(evento);

			response.sendRedirect("/236-TMK/eventos/modificarEvento.jsp?ID_EVENTO=" + (Contenido.getSite().getEventos().getEventoCount() - 1));

		} catch (Exception e) {
			TmkLogger.error("No se pudo generar el evento " + e.getMessage());
			response.sendRedirect("/236-TMK/eventos/index.jsp");
		}
	}
}
