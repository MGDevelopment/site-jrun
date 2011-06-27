/**
 * $Log: EliminarItemListaProductos.java,v $
 * Revision 1.1  2003/10/28 00:22:04  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/07 15:29:30  NRodriguez
 * - Administracion de contenido - Ranking
 *
 * Revision 1.2  2003/10/03 16:30:23  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/10/02 17:39:35  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.ListaProductosType;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarItemListaProductos extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seccion = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_SECCION), 0);
		int tipo = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_TIPO), 0);
		int indice = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_INDICE), 0);
		int componente = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_COMPONENTE), ContenidoHelper.PRODUCTO);

		ListaProductosType listaProductosType = null;

		switch (componente) {
			case ContenidoHelper.PAPEL_REGALO:

				TmkLogger.debug("Eliminando papel de regalo " + indice);
				listaProductosType = Contenido.getSite().getPapelesDeRegalo();
				break;

			case ContenidoHelper.RECOMENDADO:
				TmkLogger.debug("Eliminando recomendado " + indice);
				listaProductosType = Contenido.getSite().getListaDeDeseos();
				break;

			case ContenidoHelper.RANKING:
				TmkLogger.debug("Eliminando articulo " + indice + " del ranking de " + seccion + " del grupo " + tipo);
				listaProductosType = Contenido.getSite().getRanking().getRankingSeccion(seccion).getRankingGrupo(tipo);
				break;

			default:
				return;
		}

		listaProductosType.removeListaProductosTypeItem(indice);

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
