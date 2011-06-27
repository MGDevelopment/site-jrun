package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.Claves;

public class EliminarArticuloDeCatalogo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), (Integer)null);
		Integer idGrupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO), (Integer)null);
		Integer idFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA), (Integer)null);
		Integer idSubFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SUB_FAMILIA), (Integer)null);
		Integer idArticulo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_ARTICULO), (Integer)null);
		
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");

		try {
			Claves clave = ArticuloManager.getClaveEnRecorridoCatalogo(idSeccion, idGrupo, idFamilia, idSubFamilia);
			if (clave != null) {
				for (int i=0; i<clave.getProducto().length; i++) {
					if (clave.getProducto()[i].getId() == idArticulo.intValue()) {
						clave.removeProducto(i);
					}
				}
				out.print("<success><msg>Se ha eliminado con exito del catálogo: " + idSeccion + " " + idGrupo + " " + idFamilia + " el articulo: " + idArticulo + "</msg></success>");
			} else {
				out.print("<error><msg>No se encontró el articulo: " + idArticulo + " en el catálogo: " + idSeccion + " " + idGrupo + " " + idFamilia + "</msg></error>");
			}
			
		} catch (Exception e) {
			out.print("<error><msg>Se produjo un error contacte al administrador</msg></error>");
			TmkLogger.debug(this.getClass().toString() + "] " + e.toString() + MainHelper.getMessage(e));
		}
		out.close();
	}	
}
