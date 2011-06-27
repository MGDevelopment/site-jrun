/**
 * Created by IntelliJ IDEA.
 * User: oDZurita
 * Date: Dec 23, 2005
 * Time: 12:06:51 PM
 * To change this template use Options | File Templates.
 */
package com.tmk.controllers.intranet.generacion;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.generacion.articulo.GeneradorDeArticulo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public final class GenerarDetallesDeArticulosEstaticos extends HttpServlet {

	//private final static String saveDirectory = "/contenidosEstaticos/detalleArticulo";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	boolean huboError = false;
	boolean retorno = false;

        Integer idArticuloEstatico = Convert.toNumber(request.getParameter("idArticuloEstatico"), (Integer)null);
        Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion"), (Integer)null);
		String filtro = "?idArticulo=" + Convert.toString(request.getParameter("idArticulo"), "") +
						"&titulo=" + Convert.toString(request.getParameter("titulo"), "") +
						"&ISBN=" + Convert.toString(request.getParameter("ISBN"), "") +
                        "&idArticuloEstatico=" + idArticuloEstatico.intValue() +
						"&senal=" + Convert.toString(request.getParameter("senal"), "");

        if(idArticuloEstatico==null || idSeccion==null){
			response.sendRedirect("/236-TMK/generacion/generacionDetallesArticulos.jsp");
			return;
		}

	   // String directorioDeContenidosEstaticos = Globals.GENERACION_DIRECTORIO;

        HttpSession session = request.getSession();



        try{
       		retorno = GeneradorDeArticulo.generarDetalle(idArticuloEstatico.intValue(), idSeccion.intValue());

       		huboError = (huboError || !retorno);

       		if (huboError) {
				session.setAttribute("generacionDetalleError", "No se pudo generar el detalle del artículo ID:" + idArticuloEstatico.intValue() + ".");
			} else {
				session.setAttribute("generacionDetalleOK", "Se generó exitosamente el detalle  del artículo ID:" + idArticuloEstatico.intValue() + ".");
			}

        } catch(Exception e){
            TmkLogger.error("No se pudo estatizar completamente el detalle  del artículo ID:" + idArticuloEstatico.intValue() + ". " + e.toString());
            session.setAttribute("generacionDetalleError", "No se pudo generar el detalle  del artículo ID:" + idArticuloEstatico.intValue() + ".");
        }

	    response.sendRedirect("/236-TMK/generacion/generacionDetallesArticulos.jsp" + filtro);
	    return;

    }

}
