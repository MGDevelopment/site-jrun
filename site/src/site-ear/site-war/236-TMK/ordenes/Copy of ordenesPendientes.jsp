<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.orden.OrdenLocal,
				 com.tmk.orden.PagoOrdenLocal,
				 com.tmk.orden.PagoOrdenLocalHome,
                 com.tmk.service.orden.OrdenService,
				 com.tmk.socio.SocioPK,
                 com.tmk.controllers.intranet.ordenes.OrdenesHelper,
                 com.tmk.kernel.*,
                 java.util.Collection,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
<%
	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	int cantidadOrdenes = 0;
	boolean aprobacionFinal = "TARJETA".equalsIgnoreCase(request.getParameter(OrdenesHelper.MEDIO_COBRO));
	boolean esAdministracion = "SI".equalsIgnoreCase(request.getParameter(OrdenesHelper.ADMNISTRACION));
	boolean relacionadas = Convert.toBoolean(request.getParameter("RELACIONADAS"), false);

	String medioDeCobro = Convert.toString(request.getParameter(OrdenesHelper.MEDIO_DE_COBRO), "%%");

	Integer ordenInicial = new Integer(Convert.toNumber(request.getParameter(OrdenesHelper.ORDEN_INICIAL), 0));
	Integer cantidadPorPagina = new Integer(Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_CANTIDAD_ORDENES), 10));
	EstadoOrdenDAO estadoOrdenDAO = (aprobacionFinal) ? Globals.ESTADO_ORDEN_ENVIADA_LOGISTICA : Globals.ESTADO_ORDEN_DATOS_A_COMPLETAR;


	Collection resultados;

	if (relacionadas) {
		cantidadOrdenes = 20;
		int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
		resultados = ordenLocalHome.findOrdenesRelacionadas(new Integer(idOrden));
	} else {
		if (medioDeCobro.equals("EFCO")) {
		   resultados = ordenLocalHome.findOrdenesEnEstadoParaEfectivo(ordenInicial, estadoOrdenDAO.getId(), cantidadPorPagina, medioDeCobro);
		} else {
		   resultados = ordenLocalHome.findOrdenesEnEstado(ordenInicial, estadoOrdenDAO.getId(), cantidadPorPagina, medioDeCobro);
		}
	}

	int totalDeOrdenes = resultados.size();
	Iterator ordenesPendientes = resultados.iterator();
%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.tmk.orden.DireccionOrdenLocalHome"%>
<%@page import="com.tmk.orden.DireccionOrdenLocal"%>
<%@page import="com.tmk.socio.SocioDomicilioLocalHome"%>
<%@page import="com.tmk.socio.SocioDomicilioPK"%>
<%@page import="com.tmk.socio.SocioDomicilioLocal"%>
<%@page import="com.tmk.controllers.carrito.CarritoUtil"%>
<%@page import="com.tmk.orden.OrdenDAO"%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Ordenes pendientes") %>
		<style>
			a.EnlaceNegro
			{
				font-size: 11px;
				font-family: verdana;
				font-weight: bold;
				color: #000000;
				text-decoration: none;
			}

			p.TextoNegro
			{
				font-size: 11px;
				font-family: verdana;
				font-weight: bold;
				color: #000000;
				text-decoration: none;
			}
		</style>

		<script type="text/javascript">
			function armarURL() {
				var saltos = document.navegacion.saltos;
				var distancia = saltos.options[saltos.selectedIndex].text;
				var pagina = '/236-TMK/ordenes/ordenesPendientes.jsp';

				<%	if (esAdministracion) {
				%>
						pagina = pagina + '?<%= OrdenesHelper.ADMNISTRACION %>=SI';
				<%	}

					if (aprobacionFinal) {
						if (esAdministracion) {
				%>
							pagina = pagina + '&<%= OrdenesHelper.MEDIO_COBRO %>=TARJETA';
				<%		} else {
				%>
				            pagina = pagina + '?<%= OrdenesHelper.MEDIO_COBRO %>=TARJETA';
				<%		}
					}
				%>

				pagina = pagina + '&<%= OrdenesHelper.CAMPO_CANTIDAD_ORDENES %>=' + distancia;
				return pagina;
			}

			function datosTarjeta(idOrden) {
				window.open("/236-TMK/ordenes/datosTarjeta.jsp?<%= OrdenesHelper.CAMPO_ID_ORDEN_ %>=" + idOrden,
							"datosTarjeta",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=450, height=450");
			}

			function ordenFax(idOrden) {
				window.open("/236-TMK/ordenes/pagoPorFax.jsp?<%= OrdenesHelper.CAMPO_ID_ORDEN_ %>=" + idOrden,
							"pagoPorFax",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=450, height=550");
			}

			function ordenEFCO(idOrden) {
				window.open("/236-TMK/ordenes/pagoEFCO.jsp?<%= OrdenesHelper.CAMPO_ID_ORDEN_ %>=" + idOrden,
							"pagoEFCO",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=450, height=350");
			}

			function cambiarSaltos() {
                var pagina = armarURL();
				var medioDeCobro = '<%=medioDeCobro%>';
                if (medioDeCobro == '%%') {
                    medioDeCobro = '';
                }

				pagina = pagina + '&<%= OrdenesHelper.ORDEN_INICIAL %>=<%= ordenInicial.intValue() %>'  + '&<%=OrdenesHelper.MEDIO_DE_COBRO%>=' + medioDeCobro;
				document.location = pagina;
			}

			function inicio() {
				var pagina = armarURL();

				pagina = pagina + '&<%= OrdenesHelper.ORDEN_INICIAL %>=0';
				document.location = pagina;
			}

			function anterior() {
                history.go(-1);
			}

			function siguiente(ultimaOrden) {
				var pagina = armarURL();
                var medioDeCobro = '<%=medioDeCobro%>';
                if (medioDeCobro == '%%') {
                    medioDeCobro = '';
                }
				pagina = pagina + '&<%= OrdenesHelper.ORDEN_INICIAL %>=' + (document.estadoOrdenes.ultimaOrden.value) + '&<%=OrdenesHelper.MEDIO_DE_COBRO%>=' + medioDeCobro;
				document.location = pagina;
			}

			function detalleOrden(idOrden){
				window.open('/236-TMK/ordenes/estadoOrden.jsp?idOrden=' + idOrden,'',
				"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=700, height=700");
			}
		</script>
	</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="770" height="100%">
	<tr>
		<td valign="top">
			<table cellpadding="0" cellspacing="0" >
				<tr>
					<td width="1005">
					<table width="100%" cellspacing="0" cellpadding="0" border="0">
					<tr>
					<td colspan="5">
					<table width="100%" align="center" cellpadding="0" cellspacing="0">
                    	<tr>
							<td>
								<jsp:include page="/236-TMK/comunes/header.jsp"/>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<table>
						<tr>
							<td width="70">
							</td>

							<td>
								<br>
								<font color="#990000" style="font-size: 12px;">
									<%	if (esAdministracion) {
									%>
											<b>Ordenes pendientes de validacion</b>
									<%	} else {
									%>
											<b>Estado de las ordenes</b>
									<%	}
									%>
								</font>
							</td>
						</tr>
						</table>
					</tr>
					</table>

					<form name="navegacion">
						<table cellpadding="2" cellspacing="2" width="500">
						<tr>
							<td width="70">
							</td>

							<td width="90">
								<p class="TextoNegro">
									Mostrar de a
								</p>
							</td>

							<td>
								<select name="saltos" onChange="cambiarSaltos()">
									<option <%= cantidadPorPagina.intValue() == 10 ? "selected" : "" %>>
										10
									</option>

									<option <%= cantidadPorPagina.intValue() == 20 ? "selected" : "" %>>
										20
									</option>

									<option <%= cantidadPorPagina.intValue() == 30 ? "selected" : "" %>>
										30
									</option>

									<option <%= cantidadPorPagina.intValue() == 50 ? "selected" : "" %>>
										50
									</option>

									<option <%= cantidadPorPagina.intValue() == 100 ? "selected" : "" %>>
										100
									</option>
								</select>
							</td>

							<td align="center">
								<%	if (ordenInicial.intValue() != 0) {
								%>
										<a href="javascript:inicio();" width="50" class="EnlaceNegro">
											Inicio
										</a>
								<%	} else {
								%>
										<p class="TextoNegro">
											Inicio
										</p>
								<%	}
								%>
							</td>

							<td align="center">
								<%	if (ordenInicial.intValue() != 0) {
								%>
										<a href="javascript:anterior();" width="100" class="EnlaceNegro">
											< Anterior
										</a>
								<%	} else {
								%>
										<p class="TextoNegro">
											< Anterior
										</b>
								<%	}
								%>
							</td>

							<td align="center">
								<%	if (totalDeOrdenes >= cantidadPorPagina.intValue()) {
								%>
										<a href="javascript:siguiente();" width="100" class="EnlaceNegro">
											Siguiente >
										</a>
								<%	} else {
								%>
										<p class="TextoNegro">
											Siguiente >
										</p>
								<%	}
								%>
							</td>
						</tr>
						</table>
					</form>

					<%	if (ordenesPendientes.hasNext()) {
					%>
							<form name="estadoOrdenes" action="/OrdenesPendientes">
								<table width="752">
								<tr>
									<td>
										<table align="center" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;">
										<tr bgcolor="#59B3D9" align="center">
										<%  if (aprobacionFinal) {%>
											<td height="25">
												<b>Riesgo</b>
											</td>
										<%	} %>
										<td align="center" >
											<b>Medio de Pago</b>
										</td>

											<td >
												<b>Orden</b>
											</td>
											<td align="center">
												<b>Fecha</b>
											</td>

											<%	if (esAdministracion) {
											%>
													<td >
														<b>Aprobar</b>
													</td>

													<td >
														<b>Rechazar</b>
													</td>

													<td >
														<b>Pendiente</b>
													</td>

													<%	if (aprobacionFinal) {
													%>
															<td>
																<b>Motivo</b>
															</td>

													<%	}
													%>
													<td>
																<b>Cheque obsequio<b>
															</td>
											<%	} else {
											%>
													<td>
														<b>Estado</b>
													</td>
											<%	}
											%>

											<td align="center">
												<b>Total</b>
											</td>
										</tr>

										<%	OrdenLocal ordenLocal = null;

											int idPaisHonduras = 1149;
											PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
											DireccionOrdenLocalHome direccionOrdenLocalHome = (DireccionOrdenLocalHome) DBUtil.getHome("DireccionOrden");
											while (ordenesPendientes.hasNext()) {
												int idPaisOrden = -1;
												ordenLocal = (OrdenLocal)ordenesPendientes.next();
												//PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN());
												Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN()).iterator();
												PagoOrdenLocal pagoOrden = (PagoOrdenLocal) pagosOrden.next();
												MedioDeCobroDAO medioCobroDAO = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrden.getID_MEDIO_COBRO());
												MedioDeCobroDAO medioCobroDAO2 = null;
                                                String importeMedio1 = "";
												String importeMedio2 = "";
												importeMedio1  = Contenido.precioToString(pagoOrden.getIMPORTE().doubleValue());

                                                if (pagosOrden.hasNext()) {
													pagoOrden = (PagoOrdenLocal) pagosOrden.next();
	                                                medioCobroDAO2 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrden.getID_MEDIO_COBRO());
	                                                importeMedio2 = Contenido.precioToString(pagoOrden.getIMPORTE().doubleValue());
	                                                if (medioCobroDAO2.esTarjeta() || medioCobroDAO.esReembolso()) {
		                                                MedioDeCobroDAO auxMedio = medioCobroDAO;
														String auxImporte = importeMedio1;
														medioCobroDAO = medioCobroDAO2;
														medioCobroDAO2 = auxMedio;
														importeMedio1 = importeMedio2;
														importeMedio2 = auxImporte;
	                                                }
                                                }

												Iterator domicilioEnvio = direccionOrdenLocalHome.findByOrden(ordenLocal.getID_ORDEN()).iterator();
												DireccionOrdenLocal direccionOrdenLocal = null;
												while (domicilioEnvio.hasNext()) {
													direccionOrdenLocal = (DireccionOrdenLocal)domicilioEnvio.next();
													if (direccionOrdenLocal.getTIPO_DOMICILIO().startsWith("EN")) {
														break;
													}
												}

												if (direccionOrdenLocal != null) {
													SocioDomicilioLocalHome socioDomicilioLocalHome = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
													SocioDomicilioLocal socioDomicilioLocal = (SocioDomicilioLocal)socioDomicilioLocalHome.findByPrimaryKey(new SocioDomicilioPK(direccionOrdenLocal.getID_SUCURSAL_SOCIO(),
																direccionOrdenLocal.getID_SOCIO(), direccionOrdenLocal.getTIPO_DOMICILIO()));
														idPaisOrden = socioDomicilioLocal.getID_PAIS().intValue();
												}

										    %>
													<tr style="font-size: 12px;" cellspacing="2" <%=(aprobacionFinal && idPaisOrden == idPaisHonduras)?"bgColor=\"#cccccc\"":""%>>
													<%
															//BLOQUE PARA VER SI ES SUSCRIPCION MOSTRAR TODOS LAS PELOLITAS GRIS
															OrdenDAO ordenDao = OrdenService.cargarOrden(ordenLocal.getID_ORDEN().intValue());															
															boolean esSuscripion = CarritoUtil.estaEnlaOrden(ordenDao,new Integer(505382));
															
													%>
													 <%	if (aprobacionFinal && !esSuscripion) { %>
														<td align="center" width="25" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<%	NivelDeRiesgoDAO nivelDeRiesgo = NivelDeRiesgoDAO.buscaNivelDeRiesgo(ordenLocal.getNIVEL_RIESGO());	%>
																<img src="<%=Contenido.getImagen(nivelDeRiesgo)%>" width="20" height="20" alt="<%=Convert.htmlEscape(nivelDeRiesgo.getNombre())%>">

														</td>
													<%	} else {  %>
														<td align="center" width="25" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<img height="20" width="20" alt="SUSCRIPCION" src="/imagenes/nivelDeRiesgo.gif"/>
														</td>													
													<%  } %>
													<td style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
														<%
																if (medioCobroDAO.esFax() && (!aprobacionFinal)) {
														%>
																	<a href="javascript:ordenFax(<%= ordenLocal.getID_ORDEN().intValue() %>)">
																		<%=  medioCobroDAO.getNombre() %>
																	</a>
																	<% if (medioCobroDAO2 != null) {%>
																	   	&nbsp; (<%=importeMedio1%>)
																		<br>
																		<%=  medioCobroDAO2.getNombre() %>
																		&nbsp; (<%=importeMedio2%>)
																	<%}%>
														<%		} else if (medioCobroDAO.esReembolso() && (!aprobacionFinal)) {
														%>
																	<a href="javascript:ordenEFCO(<%= ordenLocal.getID_ORDEN().intValue() %>)">
																		<%=  medioCobroDAO.getNombre() %>
																	<% if (medioCobroDAO2 != null) {%>
																	   	&nbsp; (<%=importeMedio1%>)
																		<br>
																		<%=  medioCobroDAO2.getNombre() %>
																		&nbsp; (<%=importeMedio2%>)
																	<%}%>
																	</a>
														<%		} else {
														%>
																	<%=  medioCobroDAO.getNombre() %>
																	<% if (medioCobroDAO2 != null) {%>
																	   	&nbsp; (<%=importeMedio1%>)
																		<br>
																		<%=  medioCobroDAO2.getNombre() %>
																		&nbsp; (<%=importeMedio2%>)
																	<%}%>
														<%		}
														%>

													</td>

													<td align="center" width="60" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
														<font style="text-decoration: none; color: black;">
																	<a href="javascript:detalleOrden(<%= ordenLocal.getID_ORDEN() %>)">
																		<b><%= ordenLocal.getID_ORDEN() %></b>
																	</a>
														</font>
														<input type="hidden" name="<%= OrdenesHelper.CAMPO_ID_ORDEN_  + cantidadOrdenes %>" value="<%= ordenLocal.getID_ORDEN().intValue() %>" >
													</td>
													<td style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
														<%= Convert.toStringLargo(ordenLocal.getFECHA())%>
													</td>
													<%	if (esAdministracion) {
													%>
															<td align="center" width="70" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<%	if ((medioCobroDAO.esFax() && aprobacionFinal) || medioCobroDAO.esReembolso() || medioCobroDAO.esHomeBanking() || medioCobroDAO.esNetBanking() || medioCobroDAO.esPagoFacil() || medioCobroDAO.esRapiPago() || medioCobroDAO.esDineroMail()|| medioCobroDAO.esArcash()) {
																		if (ordenLocal.getESTADO().equals(Globals.ESTADO_ORDEN_ENVIADA_LOGISTICA.getId())) {
																%>
																			<input type="radio" name="<%= OrdenesHelper.CAMPO_ESTADO_ + ordenLocal.getID_ORDEN().toString() %>" value="<%= Globals.ESTADO_ORDEN_APROBADA.getId() %>">
																<%		} else {
																%>
																			<input type="radio" name="<%= OrdenesHelper.CAMPO_ESTADO_ + ordenLocal.getID_ORDEN().toString() %>" value="<%= Globals.ESTADO_ORDEN_INICIA_LOGISTICA.getId() %>">
																<%		}
																	} else if (medioCobroDAO.esTarjeta()) {
																%>
																		<input type="radio" name="<%= OrdenesHelper.CAMPO_ESTADO_ + ordenLocal.getID_ORDEN().toString() %>" value="<%= Globals.ESTADO_ORDEN_APROBADA.getId() %>">
																<%	} else { %>
																		&nbsp;
																<%	}
																%>
															</td>

															<td align="center" width="70" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<input type="radio" name="<%= OrdenesHelper.CAMPO_ESTADO_ + ordenLocal.getID_ORDEN().toString() %>" value="<%= Globals.ESTADO_ORDEN_RECHAZADA.getId() %>">
															</td>

															<td align="center" width="70" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<input type="radio" name="<%= OrdenesHelper.CAMPO_ESTADO_ + ordenLocal.getID_ORDEN().toString() %>" value="<%=OrdenesHelper.DEJAR_ESTADO%>" checked="checked">
															</td>

															<%	if (aprobacionFinal) {
															%>
																	<td height="21" width="150" align="justify" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																		<%= Convert.toString(ordenLocal.getMOTIVO_RIESGO(), "Sin motivos de fraude") %>
																		<% if (ordenLocal.getID_ORDEN_MOTIVO_RIESGO() != null) { %>
																			<a href="javascript:detalleOrden(<%= ordenLocal.getID_ORDEN_MOTIVO_RIESGO() %>)">
																				<br>Ver orden <b><%=Convert.toString(ordenLocal.getID_ORDEN_MOTIVO_RIESGO())%></b>
																			</a>
																		<% }%>
																	</td>

															<%	}
															String cheque = null;
															boolean fraude = false;
															boolean es95 = false;
															if (ordenLocal.getCUPON() != null && ordenLocal.getCUPON().length() == 13){%>
														<%


															try {
																Connection conn = DBUtil.buildConnection();
																try {
																	StringBuffer qry = new StringBuffer("SELECT nro FROM cheques_obsequios WHERE nro =?");
																	PreparedStatement ps = conn.prepareStatement(qry.toString());
																	try {
																		ps.setString(1, ordenLocal.getCUPON().substring(0, 12));
																		ResultSet rs = ps.executeQuery();
																		try {
																			if (rs.next()) {
																				cheque = ordenLocal.getCUPON();
																				es95 = (cheque.startsWith("95"))? true:false;
																				StringBuffer qry2 = new StringBuffer("SELECT count(id_orden) cantidad FROM orden WHERE cupon = ? ");
																				qry2.append(" AND estado NOT IN ('11', '52', '21', '5', '51', '0') ");
																				qry2.append(" AND id_orden <> ?");
																				PreparedStatement ps2 = conn.prepareStatement(qry2.toString());
																				try {
																					ps2.setString(1, cheque);
																					ps2.setInt(2, ordenLocal.getID_ORDEN().intValue());
																					ResultSet rs2 = ps2.executeQuery();
																					try {
																						if (rs2.next()) {
																							if (rs2.getInt("cantidad")>0) {
																								cheque = cheque + "<br>(" + rs2.getInt("cantidad") + " " + Convert.plural(rs2.getInt("cantidad"), "orden", "ordenes") + ")";
																								fraude = true;
																							}
																						}
																					} finally {
																						rs2.close();
																					}
																				} finally {
																					ps2.close();
																				}
																			}
																		} finally {
																			rs.close();
																		}


																	} finally {
																		ps.close();
																	}

																} finally {
																	conn.close();
																}
															} catch (Exception e) {
																TmkLogger.error (e.toString());
															}
														%>

														<%} %>

													<td align="center" style="<%=(fraude || es95)?"background-color:red;font-weight:bolder;":""%>border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
														<%if (fraude) { %>
															<a href="/236-TMK/ordenes/listaOrdenCheque.jsp?idOrden=<%=ordenLocal.getID_ORDEN()%>" target="_blank"><%=(cheque!= null)?cheque:"" %></a>
														<%} else { %>
															<%=(cheque!= null)?cheque:"" %>
														<%} %>
													</td>

													<%	} else {
													%>
															<td align="center" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
																<%= EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getNombre() %>
															</td>
													<%	}
													%>

													<td height="21" align="right"style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
														<%= ordenLocal.getTOTAL()==null?"0":Contenido.precioToString(ordenLocal.getTOTAL().doubleValue()) %>
													</td>
												</tr>

										<%	       cantidadOrdenes++;
											}
										%>

										<tr>
											<%	if (esAdministracion) {
											%>
													<td colspan="10" bgcolor="#59B3D9" height="20" >
													</td>
											<%	} else {
											%>
													<td colspan="5" bgcolor="#59B3D9" height="20" >
													</td>
											<%	}
											%>
										</tr>
										</table>

										<input type="hidden" name="<%= OrdenesHelper.CAMPO_CANTIDAD_ORDENES %>" value="<%= cantidadOrdenes %>" >
										<input type="hidden" name="ultimaOrden" value="<%= ordenLocal.getID_ORDEN().intValue() + 1 %>" >
										<br><br>

										<table width="200" align="right">
										<tr>
											<td>
												<%	if (esAdministracion) {
												%>
														<a href="/OrdenesPendientes">
															<input type="image" src="/imagenes/botonActualizar.gif">
														</a>
												<%	}
												%>
											</td>

											<td>
												<a href="/236-TMK/ordenes/index.jsp">
													<img src="/imagenes/botonVolver.gif" border="0">
												</a>
											</td>
										</tr>
										</table>
									</td>
								</tr>
								</table>
							</form>
					<%	} else {
					%>
							<table width="752" cellspacing="0" cellpadding="0" border="0">
							<tr>
								<td align="center">
									<br><br>
									<b>
										NO HAY ORDENES PARA MOSTRAR
									</b>
								</td>
							</tr>
							</table>
					<%	}
					%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
	</body>
</html>