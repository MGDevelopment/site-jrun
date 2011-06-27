/**
 * 
 */
package com.tmk.controllers.promo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.bus.promo.PromoExtraManager;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;

/**
 * @author msartori
 *
 */
public class AplicarPromoVC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(MainHelper.PAGE_HOME);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idOrden = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ORDEN));
		String respuesta1 = Convert.toString(request.getParameter(MainHelper.FIELD_RESPUESTA1), " ");
		
		String respuesta2 = Convert.toString(request.getParameter(MainHelper.FIELD_RESPUESTA2), " ");
		String respuesta3 = Convert.toString(request.getParameter(MainHelper.FIELD_RESPUESTA3), " ");
		String respuesta = "<error><msg>Error Promo</msg></error>";
		//String errorMsg = "<error><msg></msg></error>";
		String successMsg = "<success><msg>Gracias por participar de la promoción Viaje Cultural</msg></success>";
		StringBuffer cabecera = new StringBuffer();
		cabecera.append(this.getClass().getName()).append("(idOrden=").append(idOrden).append(", respuesta1=").append(respuesta1);
		cabecera.append("respuesta2=").append(respuesta2).append("respuesta3=").append(respuesta3).append(")]");
		
		try {
			if (PromoExtraManager.aplicarPormoVC(Convert.toNumber(idOrden, (Integer)null),
					respuesta1, respuesta2, respuesta3, request, response)) {
				respuesta = successMsg;
			}
		} catch (Exception e) {
			TmkLogger.error(cabecera.toString() + " " + e.toString() + MainHelper.getMessage(e));
			MainHelper.enviarMailDeError(cabecera.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
		
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		out.print(respuesta);
		out.close();
	}	
}
