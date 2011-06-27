/*Log$
 *
 */
package com.tmk.controllers.fidelizacion;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.fidelizacion.ActualizacionEMailManager;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
//import com.tmk.seguridad.EncripcionURL;
//import com.tmk.kernel.Convert;

public class FinalizarActDeEmail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter(ActualizacionEMailManager.CAMPO_CODIGO);
		String cabeceraMsg = "";
		try {
			new Long(codigo);
			cabeceraMsg = "FinalizarActDeEmail.doGet(" + codigo + ")";
		} catch (Exception e) {
			try {
				//codigo =  EncripcionURL.desEncriptar(request.getParameter(ActualizacionEMailManager.CAMPO_CODIGO));
				codigo = new String(CryptUtil.desEncriptar(codigo.getBytes("ISO-8859-1")));
				cabeceraMsg = "FinalizarActDeEmail.doGet(" + codigo + ")";
			} catch (Exception e1) {
				request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "El codigo de actualización es inválido.");
				response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
				cabeceraMsg = "FinalizarActDeEmail.doGet(" + codigo + ")";
				TmkLogger.error(cabeceraMsg + "]" + " ERROR, No se pudo desencriptar el codigo");
				return;
			}
		}
		//cabeceraMsg = "FinalizarActDeEmail.doGet(" + codigo + ")";

		if (!ActualizacionEMailManager.esCodigoValido(codigo)) {
			request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "El codigo de actualización es inválido.");			
			response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
			return;
		}


		if (ActualizacionEMailManager.esActualizacionCerrada(new Long(codigo).longValue())) {
			request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "La actualización cerrada previamente o codigo incorrecto.");
			response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
			TmkLogger.info(cabeceraMsg + "] La actualización cerrada previamente o codigo incorrecto.");
			return;
		}



		TmkLogger.info(cabeceraMsg + "] codigo valido");
		String datos [] = ActualizacionEMailManager.getDatosAActualizar(codigo);

		if (ActualizacionEMailManager.mailEnUso(datos[0])) {
			request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "El e-mail " + datos[0] + " se encuentra actualmente en uso.");
			response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
			return;
		}

		boolean cerrarActualizacion = true;
		String estado = null;

		if (datos != null) {
			//Tengo los datos
			TmkLogger.info(cabeceraMsg + "] datos del socio correctos");
			try {
				Connection con = DBUtil.buildConnection();
				con.setAutoCommit(false);

				try {
					if (!ActualizacionEMailManager.actualizarDatos(con, datos[0], datos[1], datos[2], new Long(datos[3]).longValue(),
							new Integer(datos[4]).intValue(), datos[5])) {
						throw new Exception (" Error actualizando Datos del socio");
					} else {
	//					Datos actualizados
						TmkLogger.info(cabeceraMsg + "] datos del socio actualizados");
					}
					//si pidio actualizacion de domicilio
					if (datos[10] != null) {
						if (!datos[17].equals("99999")) {
							datos[20] = null;
						}
						if (!datos[18].equals("99999")) {
							datos[21] = null;
						}
						if (!ActualizacionEMailManager.agregarDomicilio(con, new Integer(datos[22]).intValue(),
								new Integer(datos[23]).intValue(), datos[10], datos[11],
								(datos[12]!= null)? new Integer(datos[12]).intValue(): 0, datos[13],
								(datos[14]!= null)? new Integer(datos[14]).intValue(): 0,
								datos[15], datos[16],
								(datos[17]!= null)? new Integer(datos[17]).intValue(): 0,
								(datos[18]!= null)? new Integer(datos[18]).intValue(): 0,
								(datos[19]!= null)?	new Integer(datos[19]).intValue(): 0,
								datos[20], datos[21])) {
							throw new Exception (" Error actualizando Datos del domicilio");
						} else {
		//					Datos actualizados
							TmkLogger.info(cabeceraMsg + "] datos del domicilio actualizados");
						}
					}

	//				si pidio actualizacion de telefono
					if (datos[6] != null) {
						if (!ActualizacionEMailManager.agregarTelefono(con, new Integer(datos[22]).intValue(),
								new Integer(datos[23]).intValue(), datos[6], datos[7], datos[8], datos[9])) {
							throw new Exception (" Error actualizando Datos del Telefono");
						} else {
		//					Datos actualizados
							TmkLogger.info(cabeceraMsg + "] datos del Telefono actualizados");
						}
					}

					if (!ActualizacionEMailManager.actualizadoPreviamente(datos[2], new Long(datos[3]).longValue(),
							new Integer(datos[4]).intValue(), datos[5])) {
						//no hubo actualizacion anterior, otorgo puntos
						TmkLogger.info(cabeceraMsg + "] Se van a otorgar puntos");
						String datosFDN []= ActualizacionEMailManager.getDatosParaPuntos(datos[2], new Long(datos[3]).longValue(),
							new Integer(datos[4]).intValue(), datos[5]);
							if (datosFDN != null) {
								TmkLogger.info(cabeceraMsg + "] Datos FDN correctos");
								try {
									if (ActualizacionEMailManager.otorgarPuntos(con, new Integer(datosFDN[0]).intValue(),
											new Integer(datosFDN[1]).intValue(), new Integer(datosFDN[2]).intValue(),
											new Integer(datosFDN[3]).intValue(), datosFDN[4])) {
										estado = ActualizacionEMailManager.ESTADO_FINAL;
										TmkLogger.info(cabeceraMsg + "] Se otorgaron los puntos");
									} else {
										request.getSession().setAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR, "No se pudieron otorgar los puntos eXtra, intentelo nuevamente");
										response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_ERROR);
										TmkLogger.error(cabeceraMsg + "]" + " ERROR, otorgando puntos eXtra");
										MainHelper.enviarMailDeError(cabeceraMsg + "] ERROR, otorgando puntos eXtra");
										cerrarActualizacion = false;
										con.close();
										return;
									}
								} catch (Exception e) {
									TmkLogger.debug("Error otorgando puntos " + e.toString());
									throw new Exception("Error otorgando puntos " + e.toString());
								}
							} else {
								//no se pudieron obtener los datos de fdn
								TmkLogger.error(cabeceraMsg + "]" + " ERROR, No se pudieron obtener los datos FDN");
								MainHelper.enviarMailDeError(cabeceraMsg + "] ERROR, No se pudieron obtener los datos FDN");
								response.sendRedirect(Globals.PAGINA_ERROR);
								con.close();
								return;
							}
						} else {
							TmkLogger.info(cabeceraMsg + "] No se otorgan puntos, actualización preexistente");
							estado = ActualizacionEMailManager.ESTADO_FINAL_SIN_PUNTOS;
						}
					if (cerrarActualizacion) {
						try {
							if (ActualizacionEMailManager.cerrarActualizacion(new Long(codigo).longValue(), estado)) {
								TmkLogger.info(cabeceraMsg + "] Actualizacion cerrada con exito");
							} else {
								TmkLogger.error(cabeceraMsg + "]" + " ERROR, No se pudo cerrar la actualizacion");
								MainHelper.enviarMailDeError(cabeceraMsg + "] ERROR, No se pudo cerrar la actualizacion");
								response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_FIN);
								con.close();
								return;
							}
						} catch (Exception e) {
							TmkLogger.info("Error cerrando actualizacion " + e.toString());
							throw new Exception("Error cerrando actualizacion " + e.toString());
						}
					}
					con.commit();
				} catch (Exception e) {
	//				No se pudieron actualizar los datos
					TmkLogger.error(cabeceraMsg + "]" + " ERROR, No se pudieron actualizar los datos " + e.toString());
					MainHelper.enviarMailDeError(cabeceraMsg + "] ERROR, No se pudieron actualizar los datos " + e.toString());
					con.rollback();
					response.sendRedirect(Globals.PAGINA_ERROR);
					return;
				}  finally {
					con.close();
					TmkLogger.debug(cabeceraMsg + "]" + " Cerrando la conexion");

				}

			} catch (Exception e) {
				TmkLogger.error(cabeceraMsg + "]" + " ERROR, conexion para actualizacion de datos " + e.toString());
			}
		} else {
			//no encontre los datos
			TmkLogger.error(cabeceraMsg + "]" + " ERROR, No se pudieron obtener los datos");
			MainHelper.enviarMailDeError(cabeceraMsg + "] ERROR, No se pudieron obtener los datos");
			response.sendRedirect(Globals.PAGINA_ERROR);
			return;

		}
		response.sendRedirect(ActualizacionEMailManager.PAGINA_MSG_FIN);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}