package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.orden.OrdenService;
import com.tmk.xml.Resultado;
import com.tmk.xml.converter.TimestampConverter;
import com.tmk.xml.orden.OrdenWrapper;

public class GetOrdenByEstadoMedioARCASH extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		String idEstado = request.getParameter("idEstado");
		String idMedioCobro = request.getParameter("idMedioCobro");
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		PrintWriter out = response.getWriter();
		
		if (idEstado == null || idMedioCobro == null) {
			TmkLogger.error("GetOrdenByEstadoMedio] faltan datos de estado o medio de orden. Estado= " + idEstado + " idMedioCobro = " + idMedioCobro);
			Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
			out.print(xstream.toXML(resultado).replaceAll("\n", ""));
		} else {
			try {
				OrdenWrapper ordenes[] = OrdenService.findOrdenByEstadoMedio (idEstado, idMedioCobro);
				//calculo de si ya esta vencida la orden
				for (int i=0; i<ordenes.length; i++) {
					Timestamp fechaOrden = Convert.toTimestampFromDDMMYYYY(ordenes[i].getFecha().replaceAll("//", ""));
					Calendar cal = Calendar.getInstance();
					cal.setTime(fechaOrden);
					cal.add(Calendar.DATE, 15);					
					if (cal.before(Calendar.getInstance())) {
						ordenes[i].setEstado(OrdenService.ESTADO_VENCIDA);
					} else {
						ordenes[i].setEstado(OrdenService.ESTADO_SIN_INFORMACION);
					}
				}
				try {
					xstream.setMode(XStream.NO_REFERENCES);
					String retorno = xstream.toXML(ordenes);
					retorno = retorno.replaceAll("com.tmk.xml.orden.OrdenWrapper-array", "ordenes");
					out.print(retorno.replaceAll("\n", ""));
				} catch (Exception e) {
					String error = "GetOrdenByEstadoMedio] En paso de ordenes a jSON " + e.toString() + " " + MainHelper.getMessage(e); 
					TmkLogger.error(error);
					MainHelper.enviarMailDeError(error);
					Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
					xstream.alias("Resultado", Resultado.class);
					out.print(xstream.toXML(resultado).replaceAll("\n", ""));
				}
			} catch (Exception e) {
				String error = "GetOrdenByEstadoMedio] Error en consulta de ordenes" + e.toString() + " " + MainHelper.getMessage(e); 
				TmkLogger.error(error);
				MainHelper.enviarMailDeError(error);
				Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
				xstream.alias("Resultado", Resultado.class);
				out.print(xstream.toXML(resultado).replaceAll("\n", ""));
			}
		}
		
		 
		
	}
}
