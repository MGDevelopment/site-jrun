/**
 * $Log: DuplicarItemListaProductos.java,v $
 * Revision 1.1  2003/10/28 00:22:03  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/07 15:29:30  NRodriguez
 * - Administracion de contenido - Ranking
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
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.ListaProductosType;
import com.tmk.kernel.site.ListaProductosTypeItem;
import com.tmk.kernel.site.Producto;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DuplicarItemListaProductos extends HttpServlet {

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

				TmkLogger.debug("Duplicando papel de regalo a continuacion del " + indice);
				listaProductosType = Contenido.getSite().getPapelesDeRegalo();
            	break;

			case ContenidoHelper.RECOMENDADO:
				TmkLogger.debug("Duplicando recomendado a continuacion del " + indice);
				listaProductosType = Contenido.getSite().getListaDeDeseos();
            	break;


			case ContenidoHelper.RANKING:
				TmkLogger.debug("Duplicando articulo " + indice + " del ranking de " + seccion + " del grupo " + tipo);
				listaProductosType = Contenido.getSite().getRanking().getRankingSeccion(seccion).getRankingGrupo(tipo);
				break;

			default:
				return;
		}

		ListaProductosTypeItem actual = listaProductosType.getListaProductosTypeItem(indice);
		ListaProductosTypeItem nuevo = new ListaProductosTypeItem();

		Producto producto = new Producto();

		producto.setId(actual.getProducto().getId());
		producto.setTexto(actual.getProducto().getTexto());
		producto.setHint(actual.getProducto().getHint());
		producto.setIcono(actual.getProducto().getIcono());

		nuevo.setProducto(producto);

		listaProductosType.addListaProductosTypeItem(indice + 1, nuevo);

		response.sendRedirect(request.getHeader("REFERER"));
	}
}