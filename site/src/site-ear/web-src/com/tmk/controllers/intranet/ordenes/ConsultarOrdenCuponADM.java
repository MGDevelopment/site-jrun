package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.tmk.xml.dm.cupon.Collection;
import com.tmk.xml.dm.cupon.Report;
import com.tmk.xml.orden.OrdenWrapper;

public class ConsultarOrdenCuponADM extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		String idEstado = request.getParameter("idEstado");
		String idMedioCobro = request.getParameter("idMedioCobro");
		String rangoDesde=request.getParameter("rangoDesde");
		String rangoHasta=request.getParameter("rangoHasta");
		try {
			SimpleDateFormat sdfDesde1=new SimpleDateFormat("dd/MM/yyyy");
			Date dateFrom=sdfDesde1.parse(rangoDesde);
			SimpleDateFormat sdfDesde2=new SimpleDateFormat("yyyyMMdd");
			rangoDesde=sdfDesde2.format(dateFrom);			
			SimpleDateFormat sdfHasta1=new SimpleDateFormat("dd/MM/yyyy");
			Date dateTo=sdfHasta1.parse(rangoHasta);
			SimpleDateFormat sdfHasta2=new SimpleDateFormat("yyyyMMdd");
			rangoHasta=sdfHasta2.format(dateTo);			
		} catch (ParseException e1) {
			rangoDesde=null;
			rangoHasta=null;
		}
		
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver()); 
		PrintWriter out = response.getWriter();
		
		if (idEstado == null || idMedioCobro == null) {
			TmkLogger.error("Consulta de Orden-Cupon a DM] faltan datos de estado o medio de orden. Estado= " + idEstado + " idMedioCobro = " + idMedioCobro);
			Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
			out.print(xstream.toXML(resultado).replaceAll("\n", ""));
		} else {
			try {
				OrdenWrapper ordenes[] = OrdenService.findOrdenByEstadoMedio (idEstado, idMedioCobro);
				try {
						Report report = OrdenService.getReportOrdenesConCupon(rangoDesde, rangoHasta);
						if (report != null) {
							if (report.esConsultaCorrecta()) {
								for (int i=0; i<ordenes.length; i++) {
									Timestamp fechaOrden = Convert.toTimestampFromDDMMYYYY(ordenes[i].getFecha().replaceAll("//", ""));
									Calendar cal = Calendar.getInstance();
									cal.setTime(fechaOrden);
									
									cal.add(Calendar.DATE, 15);
									if (report.tieneResultados()) {
										try {
											Collection collection = report.getCollection(ordenes[i].getCodigoCupon().substring(4, ordenes[i].getCodigoCupon().length()-1));
											if (collection.getTrxPayment().equals(ordenes[i].getTotal())) {
												ordenes[i].setEstado(OrdenService.ESTADO_APROBADO);
											} else {
												ordenes[i].setEstado(OrdenService.ESTADO_CARGO_DIFERENTE + " " + collection.getTrxPayment());
											}
										} catch (Exception e) {
											//TmkLogger.warn("Consulta de Orden-Cupon a DM]" + e.toString() + MainHelper.getMessage(e));
											if (cal.before(Calendar.getInstance())) {
												ordenes[i].setEstado(OrdenService.ESTADO_VENCIDA);
											} else {
												ordenes[i].setEstado(OrdenService.ESTADO_SIN_INFORMACION);
											}
										}
									} else {
										if (cal.before(Calendar.getInstance())) {
											ordenes[i].setEstado(OrdenService.ESTADO_VENCIDA);
										} else {
											ordenes[i].setEstado(OrdenService.ESTADO_SIN_INFORMACION);
										}
										
									}
								}
								try {
									xstream.setMode(XStream.NO_REFERENCES);
									String retorno = xstream.toXML(ordenes);
									retorno = retorno.replaceAll("com.tmk.xml.orden.OrdenWrapper-array", "ordenes");
									out.print(retorno.replaceAll("\n", ""));
								} catch (Exception e) {
									String error = "Consulta de Orden-Cupon a DM] En paso de reporte a jSON " + e.toString() + " " + MainHelper.getMessage(e); 
									TmkLogger.error(error);
									MainHelper.enviarMailDeError(error);
									Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
									xstream.alias("Resultado", Resultado.class);
									out.print(xstream.toXML(resultado).replaceAll("\n", ""));
								}
							} else {
								String error = "Consulta de Orden-Cupon a DM] No es consulta correcta, estado " + report.getState(); 
								TmkLogger.error(error);
								MainHelper.enviarMailDeError(error);
								Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
								xstream.alias("Resultado", Resultado.class);
								out.print(xstream.toXML(resultado).replaceAll("\n", ""));
							}
						} else {
							String error = "Consulta de Orden-Cupon a DM] Reporte DM nulo"; 
							TmkLogger.error(error);
							MainHelper.enviarMailDeError(error);
							Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
							xstream.alias("Resultado", Resultado.class);
							out.print(xstream.toXML(resultado).replaceAll("\n", ""));
						}
				} catch (Exception e) {
					String error = "Consulta de Orden-Cupon a DM] Error consultado reporte a DM " + e.toString() + " " + MainHelper.getMessage(e); 
					TmkLogger.error(error);
					MainHelper.enviarMailDeError(error);
					Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
					xstream.alias("Resultado", Resultado.class);
					out.print(xstream.toXML(resultado).replaceAll("\n", ""));	
				}
			} catch (Exception e) {
				String error = "Consulta de Orden-Cupon a DM] Error en consulta de ordenes" + e.toString() + " " + MainHelper.getMessage(e); 
				TmkLogger.error(error);
				MainHelper.enviarMailDeError(error);
				Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
				xstream.alias("Resultado", Resultado.class);
				out.print(xstream.toXML(resultado).replaceAll("\n", ""));
			}
		}
		
		 
		
	}
}
	

