package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Vector;

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
import com.tmk.xml.dm.ipn.consulta.Id;
import com.tmk.xml.dm.ipn.respuesta.Detalle;
import com.tmk.xml.dm.ipn.respuesta.Operacion;
import com.tmk.xml.dm.ipn.respuesta.Reporte;
import com.tmk.xml.orden.OrdenWrapper;

public class ConsultarOrdenDMADM extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		String idEstado = request.getParameter("idEstado");
		String idMedioCobro = request.getParameter("idMedioCobro");
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
						Vector aux = new Vector();
						for (int i=0; i<ordenes.length; i++) {
							aux.add(new Id(ordenes[i].getIdOrden().toString()));
						}
						Reporte reporte = OrdenService.consultarOrdenConDMaDM((Id[])aux.toArray(new Id[aux.size()])); 
						if (reporte != null) {
							if (reporte.esReporteCorrecto()) {
								Detalle detalle = reporte.getDetalle();
								for (int i=0; i<ordenes.length; i++) {
									Timestamp fechaOrden = Convert.toTimestampFromDDMMYYYY(ordenes[i].getFecha().replaceAll("//", ""));
									Calendar cal = Calendar.getInstance();
									cal.setTime(fechaOrden);
									cal.add(Calendar.DATE, 15);
									try {
										Operacion operacion = detalle.getOperacion(ordenes[i].getIdOrden().toString());
										
										if (operacion.getEstado().equals(Operacion.ESTADO_ACREDITADO)) {
											ordenes[i].setEstado(OrdenService.ESTADO_APROBADO);
											if (!operacion.getMonto().equals(ordenes[i].getTotal())) {
												ordenes[i].setEstado(OrdenService.ESTADO_CARGO_DIFERENTE + " " + operacion.getMonto());
											}
										} else if (operacion.getEstado().equals(Operacion.ESTADO_PENDIENTE_DE_PAGO)) {
											ordenes[i].setEstado(OrdenService.ESTADO_PENDIENTE_DE_PAGO);
										} else if (operacion.getEstado().equals(Operacion.ESTADO_CANCELADO)) {
											ordenes[i].setEstado(OrdenService.ESTADO_CANCELADA);
										}
									} catch (Exception e) {
										//TmkLogger.warn("Consulta de Orden-DM a DM]" + e.toString() + MainHelper.getMessage(e));
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
									String error = "Consulta de Orden-DM a DM] En paso de reporte a jSON " + e.toString() + " " + MainHelper.getMessage(e); 
									TmkLogger.error(error);
									MainHelper.enviarMailDeError(error);
									Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
									xstream.alias("Resultado", Resultado.class);
									out.print(xstream.toXML(resultado).replaceAll("\n", ""));
								}
							} else {
								if (reporte.getEstadoReporte().equals(Reporte.ESTADO_SIN_OPERACIONES)) {
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
										String error = "Consulta de Orden-DM a DM] En paso de reporte a jSON " + e.toString() + " " + MainHelper.getMessage(e); 
										TmkLogger.error(error);
										MainHelper.enviarMailDeError(error);
										Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
										xstream.alias("Resultado", Resultado.class);
										out.print(xstream.toXML(resultado).replaceAll("\n", ""));
									}
								} else {
									String error = "Consulta de Orden-DM a DM] No es consulta correcta, estado " + reporte.getEstadoReporte(); 
									TmkLogger.error(error);
									MainHelper.enviarMailDeError(error);
									Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
									xstream.alias("Resultado", Resultado.class);
									out.print(xstream.toXML(resultado).replaceAll("\n", ""));
								}
							}
						} else {
							String error = "Consulta de Orden-DM a DM] Reporte DM nulo"; 
							TmkLogger.error(error);
							MainHelper.enviarMailDeError(error);
							Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
							xstream.alias("Resultado", Resultado.class);
							out.print(xstream.toXML(resultado).replaceAll("\n", ""));
						}
				} catch (Exception e) {
					String error = "Consulta de Orden-DM a DM] Error consultado reporte a DM " + e.toString() + " " + MainHelper.getMessage(e); 
					TmkLogger.error(error);
					MainHelper.enviarMailDeError(error);
					Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
					xstream.alias("Resultado", Resultado.class);
					out.print(xstream.toXML(resultado).replaceAll("\n", ""));	
				}
			} catch (Exception e) {
				String error = "Consulta de Orden-DM a DM] Error en consulta de ordenes" + e.toString() + " " + MainHelper.getMessage(e); 
				TmkLogger.error(error);
				MainHelper.enviarMailDeError(error);
				Resultado resultado = new Resultado(false, new String[] {"Se ha producido un error contacte al administrador "}, null);
				xstream.alias("Resultado", Resultado.class);
				out.print(xstream.toXML(resultado).replaceAll("\n", ""));
			}
		}
	}

}
