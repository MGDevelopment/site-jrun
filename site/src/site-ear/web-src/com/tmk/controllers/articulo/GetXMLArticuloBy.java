package com.tmk.controllers.articulo;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.converter.CategoriaPKConverter;
import com.tmk.xml.converter.TimestampConverter;
/*RETORNA UN XML DE ARTICULO */
/*RECIBE ID ARTICULO o ISBN o Categoria*/
public class GetXMLArticuloBy extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idArticulo = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ARTICULO), null);
		String isbn = Convert.toString(request.getParameter(MainHelper.FIELD_ISBN), null);
		Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), (Integer)null);
		Integer idGrupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO), (Integer)null);
		Integer idFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA), (Integer)null);
		Integer idSubFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SUB_FAMILIA), (Integer)null);
		
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		try {
			ArticuloClass articulos[] = null;
			if (idArticulo != null) {
				articulos = ArticuloManager.getArticulosByIds(idArticulo);
			} else if (isbn != null) {
				articulos = ArticuloManager.getArticulosByISBN(isbn);
			} else if (idSeccion != null) {
				articulos = ArticuloManager.getArticulosByIds(
								ArticuloManager.getArticulosEnCatalogo(
											idSeccion, idGrupo, idFamilia, idSubFamilia));
			} else {
				out.print("<error><msg>No se indicó artículo o categoria</msg></error>");
				return;
			}
			
			if (articulos != null && articulos.length>0) {
				for (int i=0; i<articulos.length; i++) {
					articulos[i].setTitulo(Convert.corregir(articulos[i].getTitulo(), true));
				}
				XStream xstream = new XStream(new DomDriver()); 
			    xstream.alias("articulo", ArticuloClass.class);
			    xstream.registerConverter(new TimestampConverter());
			    xstream.registerConverter(new CategoriaPKConverter());
			    out.print(xstream.toXML(articulos).replaceAll("articulo-array", "articulos"));
				return;
			} else {
				out.print("<error><msg>No se encontró artículo: ");
				if (idArticulo != null) {
					out.print("id de Articulo = " + idArticulo);
				} else if (isbn != null) {	
					out.print("ISBN = " + isbn);
				} else if (idSeccion != null) {
					out.print("en Categoria = " + idSeccion + " " + idGrupo + " " + idFamilia + " " + idSubFamilia);
				}
					
				out.print("</msg></error>");
				return;
			}
		} catch (Exception e) {
			out.print("<error><msg>Se produjo un error contacte al administrador</msg></error>");
			TmkLogger.error(this.getClass().toString() + "] " + e.toString() + MainHelper.getMessage(e));
		}
		out.close();
	}
		
	
	
}