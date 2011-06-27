/**
 * $Log: ModificarEvento.java,v $
 * Revision 1.5  2007/04/26 18:32:52  omsartori
 * no message
 *
 * Revision 1.4  2003/12/11 20:53:32  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.3  2003/12/04 17:21:27  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/11/26 15:38:14  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.1  2003/11/13 15:41:14  NRodriguez
 * - administracion de eventos via site.xml
 *
 * Revision 1.3  2003/11/11 14:57:22  GPistoia
 * -Correccion en contenido sobre papeles de regalo
 *
 * Revision 1.2  2003/10/29 16:16:26  SLizardo
 * Eventos publicos / privados
 *
 */
package com.tmk.controllers.intranet.evento;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.site.Evento;
import com.tmk.kernel.site.Eventos;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public final class ModificarEvento extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idEvento = Convert.toNumber(request.getParameter("ID_EVENTO"), 0);
			String fechaInicio = Convert.toString(request.getParameter("FECHA_INICIO"), null);
			String horaInicio = Convert.toString(request.getParameter("HORA_INICIO"), null);
			String descripcion = Convert.toString(request.getParameter("DESCRIPCION"), null);
			Integer idSucursal = Convert.toNumber(request.getParameter("ID_SUCURSAL"), new Integer(Globals.ID_SUCURSAL_TEMATIKA));
			Boolean activo = Convert.toBoolean(request.getParameter("ACTIVO"), new Boolean(false));

			String[] tokFechaInicio = fechaInicio.split("-");
			String[] tokHoraInicio = horaInicio.split(":");

			Date fecha = new Date(
			        Convert.toNumber(tokFechaInicio[0], 2000) - 1900,
			        Convert.toNumber(tokFechaInicio[1], 1) - 1,
					Convert.toNumber(tokFechaInicio[2], 1),
			        Convert.toNumber(tokHoraInicio[0], 0),
			        Convert.toNumber(tokHoraInicio[1], 0));

			// Listado de eventos
			Eventos eventos = Contenido.getSite().getEventos();

			// crea el evento nuevo
			Evento evento = eventos.getEvento(idEvento);
			evento.setActivo(activo.booleanValue());
			evento.setFecha(fecha);
			evento.setDescripcion(descripcion);
			evento.setSucursal(idSucursal.intValue());

			// Saca los eventos porque no tiene ninguna propiedad publica
			Vector temp = new Vector();
			for (int i = 0; i < eventos.getEventoCount(); i++) {
				temp.add(eventos.getEvento(i));
			}
			// Los ordena
			Collections.sort(temp, new Comparator() {
				public int compare(Object o1, Object o2) { return ((Evento)o1).getFecha().before(((Evento)o2).getFecha()) ? -1 : 1; }
				public boolean equals(Object obj) { return false; }
			});
			// Los va a agregar asi que antes los borra
			eventos.removeAllEvento();
			// Los agrega
			for (int i = 0; i < temp.size(); i++) {
				eventos.addEvento((Evento)temp.get(i));
			}

			// graba el archivo por si se olvida el usuario
			Contenido.saveFile();

		} catch (Exception e) {
			TmkLogger.error("No se pudo actualizar el evento " + e.getMessage());
		}

		response.sendRedirect("/236-TMK/eventos/index.jsp");
	}

}
