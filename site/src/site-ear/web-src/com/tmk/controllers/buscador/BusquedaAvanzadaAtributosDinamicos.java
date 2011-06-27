/**
 * $ Log $
 */


package com.tmk.controllers.buscador;

import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
//import com.tmk.kernel.Globals;
//import com.tmk.controllers.comentario.ComentarioHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Vector;


public class BusquedaAvanzadaAtributosDinamicos extends HttpServlet {
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer paramSeccion = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SECCION), new Integer (0));
		Integer paramGrupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), new Integer (0));
		Integer paramFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), new Integer (0));

		try {
				TmkLogger.debug ("Busqueda Avanzada: cargando atributos dinámicos...");
				Vector result = DBUtil.atributosPorFamilia(paramSeccion, paramGrupo, paramFamilia);

				TmkLogger.debug ("Busqueda Avanzada: armando link de buscador...");
				session.setAttribute("BusquedaAvanzada.atributos", result);
                StringBuffer varRetorno = new StringBuffer();
				varRetorno.append("?");
                varRetorno.append(BuscadorHelper.CATEGORIA_SECCION);
				varRetorno.append("=");
				varRetorno.append(paramSeccion);
				varRetorno.append("&");
				varRetorno.append(BuscadorHelper.CATEGORIA_GRUPO);
				varRetorno.append("=");
				varRetorno.append(paramGrupo);
				varRetorno.append("&");
				varRetorno.append(BuscadorHelper.CATEGORIA_FAMILIA);
				varRetorno.append("=");
				varRetorno.append(paramFamilia);
				response.sendRedirect(BuscadorHelper.PAGINA_RETORNO + varRetorno.toString());

		} catch (Exception e) {

			TmkLogger.error(" Error en busqueda avanzada, atributos dinámicos , catagoria: " + paramSeccion + " grupo: " + paramGrupo + " familia:" + paramFamilia);
			StringBuffer varRetorno = new StringBuffer();
			varRetorno.append("?");
			varRetorno.append(BuscadorHelper.CATEGORIA_SECCION);
			varRetorno.append("=");
			varRetorno.append(paramSeccion);
			varRetorno.append("&");
			varRetorno.append(BuscadorHelper.CATEGORIA_GRUPO);
			varRetorno.append("=");
			varRetorno.append(paramGrupo);
			response.sendRedirect(BuscadorHelper.PAGINA_RETORNO + varRetorno.toString());

		}


    }
}


