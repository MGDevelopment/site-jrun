/**
 * $Log: GrabarCambiosContenido.java,v $
 * Revision 1.3  2007/10/18 20:07:01  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.2  2007/04/26 18:32:51  omsartori
 * no message
 *
 * Revision 1.1  2003/10/28 00:22:05  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.1  2003/10/07 16:29:16  GPistoia
 * -Correccion en contenido
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class GrabarCambiosContenido extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		if (Contenido.saveFile()) {
			out.print("<success><msg>Se grabó con éxito el contenido</msg></success>");
		} else {
			out.print("<error><msg>Se produjo un error al grabar el contenido. Contacte al administrador</msg></error>");
		}
		out.close();
	}

}
