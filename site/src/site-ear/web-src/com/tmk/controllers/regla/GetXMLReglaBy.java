package com.tmk.controllers.regla;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.bus.regla.ReglaClass;
import com.tmk.bus.regla.ReglaManager;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.converter.TimestampConverter;
/*RETORNA UN XML de ESTADO_ARTICULOS(REGLA)
  RECIBE ID_ARTICULO
 */
public class GetXMLReglaBy extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idArticulo = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ARTICULO), null);
		
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		ReglaClass regla = null; 
		try {
			if (idArticulo != null) {
				regla = ReglaManager.getReglaByArticulo(Convert.toNumber(idArticulo, 0));
				if (regla != null) {
					XStream xstream = new XStream(new DomDriver()); 
				    xstream.alias("regla", ReglaClass.class);
				    xstream.registerConverter(new TimestampConverter());
					out.print(xstream.toXML(regla));
				} else {
					out.print("<error><msg>No se encontró regla para el articulo: " + idArticulo);
					out.print("</msg></error>");
				}
			} else {
				out.print("<error><msg>No se indicó artículo</msg></error>");
			}
		} catch (Exception e) {
			TmkLogger.error("GetXMLReglaBy(" + idArticulo + ") " + e.toString() + MainHelper.getMessage(e));
			MainHelper.enviarMailDeError("GetXMLReglaBy(" + idArticulo + ") " + e.toString() + MainHelper.getMessage(e));
		}
		out.close();
	}
	
	

}
