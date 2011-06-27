/**
 * $Log: IniciarCompraRediseno.java,v $
 * Revision 1.1  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.7  2003/10/03 16:30:19  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/18 18:56:28  GPistoia
 * -Oculte los radio buttons de ir a papel de regalo.
 * -Iteracion en GPay
 *
 * Revision 1.5  2003/08/27 18:44:02  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.4  2003/08/25 20:46:27  SLizardo
 * Optimize Imports
 *
 * Revision 1.3  2003/08/12 16:26:10  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.2  2003/08/04 22:17:58  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:32  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import com.tmk.kernel.Convert;
import com.tmk.orden.OrdenDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IniciarCompraRediseno extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");

		if (ordenDAO != null) {
			ordenDAO.setPedirPapelesYNotas(
			        Convert.toBoolean(
			                request.getParameter(CompraHelper.FLAG_PAPEL),
			                ordenDAO.getPedirPapelesYNotas()));
		}

		CompraHelper.proximoEstado(request, response, ordenDAO);

	}

}
