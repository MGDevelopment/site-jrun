/**
 * $Log: ActualizarItemListaProductos.java,v $
 * Revision 1.2  2003/11/11 14:57:21  GPistoia
 * -Correccion en contenido sobre papeles de regalo
 *
 * Revision 1.1  2003/10/28 00:22:01  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.3  2003/10/07 15:29:31  NRodriguez
 * - Administracion de contenido - Ranking
 *
 * Revision 1.2  2003/10/03 16:30:22  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/10/02 17:39:39  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.ListaProductosType;
import com.tmk.kernel.site.Producto;
import com.tmk.setup.Contenido;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActualizarItemListaProductos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seccion = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_SECCION), 0);
		int tipo = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_TIPO), 0);
		int indice = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_INDICE), 0);
		int componente = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_COMPONENTE), ContenidoHelper.PAPEL_REGALO);

		int id = Convert.toNumber(request.getParameter(ContenidoHelper.CAMPO_ID), Globals.ARTICULO_DEFAULT);
		TmkLogger.debug("ID '" + id + "'");
		String texto = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_TEXTO), null);
		TmkLogger.debug("Texto '" + texto + "'");
		String hint = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_HINT), null);
		TmkLogger.debug("Hint '" + hint + "'");
        String icono = Convert.toString(request.getParameter(ContenidoHelper.CAMPO_ICONO), null);
		TmkLogger.debug("Icono '" + icono + "'");

		ListaProductosType listaProductosType = null;

		switch (componente) {
			case ContenidoHelper.PAPEL_REGALO:
				TmkLogger.debug("Actualizando papel de regalo " + indice);
				listaProductosType = Contenido.getSite().getPapelesDeRegalo();
				break;

			case ContenidoHelper.RECOMENDADO:
				TmkLogger.debug("Actualizando recomendado " + indice);
				listaProductosType = Contenido.getSite().getListaDeDeseos();
				break;

			case ContenidoHelper.RANKING:
				TmkLogger.debug("Actualizando articulo " + indice + " del ranking de " + seccion + " del grupo " + tipo);
				listaProductosType = Contenido.getSite().getRanking().getRankingSeccion(seccion).getRankingGrupo(tipo);
				break;

			default:
				response.sendRedirect(request.getHeader("REFERER"));
				return;
		}

        Producto producto = new Producto();
		producto.setId(id);
		producto.setTexto(texto);
		producto.setHint(hint);
		producto.setIcono(icono);

		listaProductosType.getListaProductosTypeItem(indice).setProducto(producto);

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
