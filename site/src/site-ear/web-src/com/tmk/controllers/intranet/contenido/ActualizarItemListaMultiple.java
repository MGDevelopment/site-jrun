/**
 * $Log: ActualizarItemListaMultiple.java,v $
 * Revision 1.1  2003/10/28 00:22:00  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/07 15:29:32  NRodriguez
 * - Administracion de contenido - Ranking
 *
 * Revision 1.2  2003/10/03 16:30:22  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/10/02 17:39:39  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 * Revision 1.3  2003/09/30 20:17:09  GPistoia
 * -Cambios en site.xml para mejorar la configurabilidad.
 *
 * Revision 1.2  2003/09/29 16:42:10  NRodriguez
 * - Administrador de contenido version 2
 *
 * Revision 1.1  2003/09/26 23:27:20  NRodriguez
 * - Administrador de contenido, primera version. Solo productos
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.Link;
import com.tmk.kernel.site.Producto;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActualizarItemListaMultiple extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Globals.ARTICULO_DEFAULT;
		String pagina = null;

		int componente = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_COMPONENTE), ContenidoHelper.PRODUCTO);

		int seccion = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_SECCION), Globals.SECCION_HOME);
		int tipo = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_TIPO), 0);
		int indice = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_INDICE), 0);

		if (componente == ContenidoHelper.PRODUCTO) {
			id = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_ID), Globals.ARTICULO_DEFAULT);
		}

		if (componente == ContenidoHelper.LINK) {
			pagina = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_ID));
		}

		String texto = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_TEXTO));
		String hint = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_HINT));
        String icono = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_ICONO));

		if ("".equals(icono.trim())) {
			icono = null;
		}

		TmkLogger.debug("componente: " + componente);
		TmkLogger.debug("seccion : " + seccion);
		TmkLogger.debug("tipo : " + tipo);
		TmkLogger.debug("indice : " + indice);

		switch (componente) {
			case ContenidoHelper.PRODUCTO:
				Producto producto = new Producto();
				producto.setId(id);
				producto.setTexto(texto);
				producto.setHint(hint);
				producto.setIcono(icono);

				TmkLogger.debug("Id: " + producto.getId());
				TmkLogger.debug("texto: " + producto.getTexto());
				TmkLogger.debug("hint: " + producto.getHint());
				TmkLogger.debug("texto: " + producto.getTexto());

				switch (tipo) {
					case ContenidoHelper.HOME:
						TmkLogger.debug("Actualizando HOME");
						Contenido.getPagina(seccion).getHome().setProducto(producto);
						Contenido.getPagina(seccion).getHome().setLink(null);
						break;

					case ContenidoHelper.PRIMER_LISTA:
						TmkLogger.debug("Actualizando producto " + indice + " de Primer Lista");
						Contenido.getPagina(seccion).getPrimerLista().getListaMultipleTypeItem(indice).setProducto(producto);
						Contenido.getPagina(seccion).getPrimerLista().getListaMultipleTypeItem(indice).setLink(null);
						break;

					case ContenidoHelper.SEGUNDA_LISTA:
						TmkLogger.debug("Actualizando producto " + indice + " de Segunda Lista");
						Contenido.getPagina(seccion).getSegundaLista().getListaMultipleTypeItem(indice).setProducto(producto);
						Contenido.getPagina(seccion).getSegundaLista().getListaMultipleTypeItem(indice).setLink(null);
						break;
				}
            	break;

			case ContenidoHelper.LINK:
				Link link = new Link();
				link.setPagina(pagina);
				link.setTexto(texto);
				link.setHint(hint);
				link.setIcono(icono);

				TmkLogger.debug("Id: " + link.getPagina());
				TmkLogger.debug("texto: " + link.getTexto());
				TmkLogger.debug("hint: " + link.getHint());
				TmkLogger.debug("texto: " + link.getTexto());

				switch (tipo) {
					case ContenidoHelper.HOME:
						TmkLogger.debug("Actualizando HOME");
						Contenido.getPagina(seccion).getHome().setLink(link);
						Contenido.getPagina(seccion).getHome().setProducto(null);
						break;

					case ContenidoHelper.PRIMER_LISTA:
						TmkLogger.debug("Actualizando link " + indice + " de Primer Lista");
						Contenido.getPagina(seccion).getPrimerLista().getListaMultipleTypeItem(indice).setLink(link);
						Contenido.getPagina(seccion).getPrimerLista().getListaMultipleTypeItem(indice).setProducto(null);
						break;

					case ContenidoHelper.SEGUNDA_LISTA:
						TmkLogger.debug("Actualizando link " + indice + " de Segunda Lista");
						Contenido.getPagina(seccion).getSegundaLista().getListaMultipleTypeItem(indice).setLink(link);
						Contenido.getPagina(seccion).getSegundaLista().getListaMultipleTypeItem(indice).setProducto(null);
				}

				break;

			default:
				return;
	    }

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
