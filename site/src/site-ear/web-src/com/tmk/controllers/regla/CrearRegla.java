package com.tmk.controllers.regla;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.regla.ReglaClass;
import com.tmk.bus.regla.ReglaManager;
import com.tmk.controllers.MainHelper;
import com.tmk.generacion.articulo.GeneradorDeArticulo;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;



public class CrearRegla extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(MainHelper.PAGE_HOME_INTRANET);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String secuencia = Convert.toString(request.getParameter(MainHelper.FIELD_SECUENCIA), null);
		String idArticulo = Convert.toString(request.getParameter(MainHelper.FIELD_ID_ARTICULO), null);
		String idDisponibilidad = Convert.toString(request.getParameter(MainHelper.FIELD_ID_DISPONIBILIDAD), null);
		String estado = Convert.toString(request.getParameter(MainHelper.FIELD_HABILITADO_TEMATIKA), null);
		String descripcion = Convert.toString(request.getParameter(MainHelper.FIELD_DESCRIPCION), null);
		String fechaDesde = Convert.toString(request.getParameter(MainHelper.FIELD_DESDE), null);
		String fechaHasta = Convert.toString(request.getParameter(MainHelper.FIELD_HASTA), null);
		String respuesta = "";
		String errorMsg = "<error><msg>Se produjo un error al intentar grabar la regla. Contacte al administrador.</msg></error>";
		String successMsg = "<success><msg>Se ha grabado con exito la nueva regla";
		StringBuffer cabecera = new StringBuffer();
		cabecera.append(this.getClass().getName()).append("(secuencia=").append(secuencia).append(", idArticulo=").append(idArticulo);
		cabecera.append(", idDisponibilidad=").append(idDisponibilidad).append(", estado=").append(estado).append(", descripcion=").append(descripcion);
		cabecera.append(", fechaDesde=").append(fechaDesde).append(", fechaHasta=").append(fechaHasta).append(")]");
		
		
		
		if (idArticulo == null || (idDisponibilidad == null && estado == null)) {
			//error datos insuficientes
			respuesta = errorMsg;
			TmkLogger.error(cabecera.append("Datos insuficientes"));
		} else {
			ReglaClass regla = new ReglaClass(Convert.toNumber(idArticulo, (Integer)null));
			regla.setIdDisponibilidad(Convert.toNumber(idDisponibilidad, (Integer)null));
			regla.setEstado(estado);
			regla.setDescripcion(descripcion);
			regla.setDesde(Convert.toTimestampFromDDMMYYYY(fechaDesde));
			regla.setHasta(Convert.toTimestampFromDDMMYYYY(fechaHasta));
			try {
				Connection conn = DBUtil.buildConnection();
				try {
					conn.setAutoCommit(false);
					if (secuencia != null) {
						RequestDispatcher dispatcher = request.getRequestDispatcher(MainHelper.ACTION_ELIMINAR_REGLA + "?" + MainHelper.PARAM_INCLUIDO + "=true");
						request.setAttribute("conn", conn);
						dispatcher.include(request, response);
					}
					try {
						Integer nuevaSecuencia = new Integer(ReglaManager.getSecuencia());
						regla.setSecuencia(nuevaSecuencia);
						try {
							ReglaManager.insertRegla(regla, conn);
							
							try {
								if (regla.getDesde() == null || regla.getDesde().before(new java.util.Date())) {
									ArticuloManager.setDisponibilidadYHabilitado(Convert.toNumber(idArticulo, 0), 
											Convert.toNumber(idDisponibilidad, 0), estado, conn);
									try {
										conn.commit();
										//le paso 0 como idSeccion por que el nuevo generador no le importa este parametro.	
									//	if (estado.equals("S")) {
											try {
												GeneradorDeArticulo.generarDetalle(regla.getIdArticulo(),0);
												//RequestDispatcher dispatcher = request.getRequestDispatcher(MainHelper.ACTION_GENERAR_ARTICULO + "?" + MainHelper.PARAM_INCLUIDO + "=true");
												//dispatcher.include(request, response);
												respuesta = successMsg + " y se ha generado el articulo correspondiente</msg></success>";
											} catch (Exception e) {
												//fallo en generacion de articulo
												respuesta = errorMsg;
												TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
											}
										/*} else {
											RequestDispatcher dispatcher = request.getRequestDispatcher(MainHelper.ACTION_ELIMINAR_ARTICULO_GENERADO + "?" + MainHelper.PARAM_INCLUIDO + "=true");
											dispatcher.include(request, response);
											respuesta = successMsg + " y se ha borrado el articulo generado correspondiente</msg></success>";
										}*/
									} catch (Exception e) {
										//fallo comit
										respuesta = errorMsg;
										TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
									}
								} else {
									try {
										conn.commit();
										respuesta = successMsg + "</msg></success>";
									} catch (Exception e) { 	
//										fallo comit
										respuesta = errorMsg;
										TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
									}
								}
							} catch (Exception e) {
								//fallo en modificación de disponibilidad y habilitacion
								conn.rollback();
								respuesta = errorMsg;
								TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
							}
							
						} catch (Exception e) {
							//fallo insercion de regla
							conn.rollback();
							respuesta = errorMsg;
							TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
						}
					} catch (Exception e) {
						//fallo obtencion de secuencia
						conn.rollback();
						respuesta = errorMsg;
						TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
					}
				} catch (Exception e) {
					//fallo en borrado de regla
					conn.rollback();
					respuesta = errorMsg;
					TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
				} finally {
					conn.close();
				}
				
			} catch (Exception e) {
				respuesta = errorMsg;
				TmkLogger.error(cabecera.append(e.toString()).append(" ").append(MainHelper.getMessage(e).toString()));
				//error de conexion
			}
			response.setContentType("text/xml"); 
			PrintWriter out = response.getWriter(); 
			out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			out.print(respuesta);
			out.close();
		}
	}	
}
