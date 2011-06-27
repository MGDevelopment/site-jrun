/**
 * $Log: DuplicarItemListaMultiple.java,v $
 * Revision 1.1  2003/10/28 00:22:02  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.2  2003/10/03 16:30:23  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/10/02 17:39:37  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.Link;
import com.tmk.kernel.site.ListaMultipleType;
import com.tmk.kernel.site.ListaMultipleTypeItem;
import com.tmk.kernel.site.Producto;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DuplicarItemListaMultiple extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seccion = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_SECCION), Globals.SECCION_HOME);
		int tipo = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_TIPO), 0);
		int indice = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_INDICE), 0);

		ListaMultipleType lista = null;

		switch (tipo) {
			case ContenidoHelper.PRIMER_LISTA:
				TmkLogger.debug("Duplicando componente a continuacion del " + indice + " de Primer Lista");
				lista = Contenido.getPagina(seccion).getPrimerLista();
				break;


			case ContenidoHelper.SEGUNDA_LISTA: {
				TmkLogger.debug("Duplicando componente a continuacion del " + indice + " de Segunda Lista");
				lista = Contenido.getPagina(seccion).getSegundaLista();
				break;
			}

			default :
				return;
		}

		ListaMultipleTypeItem actual = lista.getListaMultipleTypeItem(indice);
		ListaMultipleTypeItem nuevo = new ListaMultipleTypeItem();

		if (actual.getProducto() != null) {
			Producto producto = new Producto();

			producto.setId(actual.getProducto().getId());
        	producto.setTexto(actual.getProducto().getTexto());
			producto.setHint(actual.getProducto().getHint());
			producto.setIcono(actual.getProducto().getIcono());

			nuevo.setProducto(producto);
		} else if (actual.getLink() != null) {
			Link link = new Link();

			link.setPagina(actual.getLink().getPagina());
        	link.setTexto(actual.getLink().getTexto());
			link.setHint(actual.getLink().getHint());
			link.setIcono(actual.getLink().getIcono());

			nuevo.setLink(link);
		}

		lista.addListaMultipleTypeItem(indice + 1, nuevo);

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
