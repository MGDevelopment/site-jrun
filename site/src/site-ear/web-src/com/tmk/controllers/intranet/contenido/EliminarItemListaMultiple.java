/**
 * $Log: EliminarItemListaMultiple.java,v $
 * Revision 1.1  2003/10/28 00:22:04  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.2  2003/10/03 16:30:23  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/10/02 17:39:36  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarItemListaMultiple extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seccion = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_SECCION), Globals.SECCION_HOME);
		int tipo = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_TIPO), 0);
		int indice = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_INDICE), 0);

		switch (tipo) {
			case ContenidoHelper.PRIMER_LISTA:
				TmkLogger.debug("Eliminando componente " + indice + " de Primer Lista");
				Contenido.getPagina(seccion).getPrimerLista().removeListaMultipleTypeItem(indice);
				break;

			case ContenidoHelper.SEGUNDA_LISTA:
				TmkLogger.debug("Eliminando componente " + indice + " de Segunda Lista");
				Contenido.getPagina(seccion).getSegundaLista().removeListaMultipleTypeItem(indice);
		}

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
