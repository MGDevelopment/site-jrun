/**
 * Created by IntelliJ IDEA.
 * User: oDZurita
 * Date: Dec 27, 2005
 * Time: 11:06:05 AM
 * To change this template use Options | File Templates.
 */
package com.tmk.controllers.intranet.generacion;

import com.tmk.kernel.Convert;
//import com.tmk.kernel.Globals;
import com.tmk.generacion.ContenidosEstaticos;
import com.tmk.controllers.buscador.BuscadorHelper;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;


public final class GenerarFamiliasEstaticas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Integer seccion = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SECCION), (Integer)null);
	    String grupo []= request.getParameter(BuscadorHelper.CATEGORIA_GRUPO).split(";");
	    String familia[]= request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA).split(";");

        String filtro = "?f" + BuscadorHelper.CATEGORIA_SECCION + "=" + Convert.toString(request.getParameter("f" + BuscadorHelper.CATEGORIA_SECCION), "") +
						"&f" + BuscadorHelper.CATEGORIA_GRUPO + "=" + Convert.toString(request.getParameter("f" + BuscadorHelper.CATEGORIA_GRUPO), "") +
						"&f" + BuscadorHelper.CATEGORIA_FAMILIA + "=" + Convert.toString(request.getParameter("f" + BuscadorHelper.CATEGORIA_FAMILIA), "") +
						"&senal=" + Convert.toString(request.getParameter("senal"), "");

        HttpSession session = request.getSession();

        if(seccion == null || seccion.intValue() == -1){
			response.sendRedirect("/236-TMK/generacion/generacionRecorridoDeFamilias.jsp");
			return;
		}



        int catSeccion = seccion.intValue();

        try{
        	boolean retorno = false;
        	boolean huboError = false;

        	for (int i=0;i<grupo.length;i++) {

        		retorno = ContenidosEstaticos.generarFamiliaEstatica(catSeccion, grupo[i] ,familia[i]);
        		huboError = (huboError || !retorno);
        	}

        	if (huboError) {
        		 session.setAttribute("generacionRecorridoFamiliaError", "No se pudo generar el recorrido de la familia SECCION:" + catSeccion );
            } else {
            	 session.setAttribute("generacionRecorridoFamiliaOK", "Se generaron exitosamente los recorridos elegidos de la SECCION:" + catSeccion );
            }

        } catch(Exception e){
            session.setAttribute("generacionRecorridoFamiliaError", "No se pudo generar el recorrido de la familia SECCION:" + catSeccion );
        }
	    response.sendRedirect("/236-TMK/generacion/generacionRecorridoDeFamilias.jsp" + filtro);
	    return;

    }
}
