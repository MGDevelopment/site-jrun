package com.tmk.service.buscador;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;

public class SetearBusqueda extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tipoBusqueda = request.getParameter("tipoBusqueda");
		tipoBusqueda = (tipoBusqueda.equals("Todo el Sitio")) ? "En Tematika.com"
				: tipoBusqueda;
		String texto = request.getParameter("texto");
		int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),
				Globals.SECCION_HOME);
		if (idSeccion > Globals.SECCION_PELICULA) {
			idSeccion = Globals.SECCION_HOME;
		}
		Vector datBusqueda = BuscadorHelper.getOpcionBusqueda()[idSeccion];
		StringBuffer urlBusqueda = new StringBuffer();

		for (int i = 0; i < datBusqueda.size(); i++) {
			if (((Hashtable) datBusqueda.get(i)).get("txtOpt").equals(
					tipoBusqueda)) {
				urlBusqueda.append(((Hashtable) datBusqueda.get(i))
						.get("urlBus"));
				break;
			}
		}
		// fix mg20121129 - begin
		urlBusqueda.append("&txtencoded=").append(texto);
		
		if (texto.contains("\\")) {
			texto = "";
		}
		// fix mg20121129 - end
		
		urlBusqueda.append("&texto=").append(texto).append("&optSeleccionada=")
				.append(tipoBusqueda);
		urlBusqueda.append("&idSeccionPropia=").append(
				request.getParameter("idSeccionPropia"));
		urlBusqueda.append("&seccionDeBusqueda=").append(
				request.getParameter("seccionDeBusqueda"));
		if (request.getParameter("mantenerIds") != null)
			urlBusqueda.append("&mantenerIds=").append(
					request.getParameter("mantenerIds"));
		String url = urlBusqueda.toString().replaceAll("productos.jsp",
				"productos_nue.jsp");
		response.sendRedirect(url);
		// response.sendRedirect(urlBusqueda.toString());
	}
}
