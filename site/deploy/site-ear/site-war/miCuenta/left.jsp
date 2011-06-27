<%@ page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<tr>
					<td align="left" valign="top"><table width="140" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top"><span class="FTtit01">DATOS DE SU CUENTA<br />
									</span>
										<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
											<tr>
												<td class="preguntasceldas"><a href="/miCuenta/modificarSocio.jsp" class="FAyuda">Datos Personales</a></td><!-- modificarSocio.jsp -->
											</tr>
											<tr>
												<td class="preguntasceldas"><a href="/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI" class="FAyuda">Domicilios</a></td>

											</tr>
									</table></td>
							</tr>
							<!-- WORK-FLOW DE POPEGO -->
							<tr>
								<td valign="top"><span class="FTtit01">SERVICIOS ADICIONALES<br />
									</span>
										<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
											<tr>
											<%
												SocioPK estaLogueado = (SocioPK)session.getAttribute("Registracion.socioPK");
											%>
												<td class="preguntasceldas"><a href="/miCuenta/servicios/servicioPopego.jsp" target="<%=(estaLogueado!=null)?"_blank" : "_self"%>" class="FAyuda">Popego</a></td>
<%--												<a href="popupex.html" onclick="return popitup('/miCuenta/servicios/servicioPopego.jsp')"	>Popego</a>--%>
												
											</tr>
									</table></td>
							</tr>
							<!-- FIN-WORK-FLOW -->							
					</table></td>
				</tr>

	<tr>
					<td align="left" valign="top">
						<table width="140" border="0" cellspacing="0" cellpadding="0">
								<tr>
										<td valign="top"><span class="FTtit01">PROGRAMA EXTRA<br />
														</span>
												<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
													<tr>
															<% if (request.getSession().getAttribute(MainHelper.SESSION_PUNTAJE_FIDELIZACION) != null) {%>
															<td class="preguntasceldas"><a id="linkExtraConsultar" href="/fidelizacion/panel/puntos.jsp" class="FAyuda">Consultar mis Puntos</a></td>
															<% } else { %>
															<td class="preguntasceldas"><a  id="linkExtraAsociar" href="/miCuenta/registroSocioEXtra.jsp" class="FAyuda">Ingresar al Programa</a></td>
															<% }%>

													</tr>
											</table>
										</td>
								</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td align="left" valign="top"><span class="FTtit01">DATOS DE SU LISTA DE DESEOS </span></td>
				</tr>
				<tr>
					<td align="left" valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
							<tr>
								<td class="preguntasceldas"><a href="/listaDeseos/verListaPropia.jsp" class="FAyuda">Configuraci&oacute;n de B&uacute;squeda</a></td>
							</tr>
							<tr>
								<td class="preguntasceldas"><a href="/listaDeseos/domicilios.jsp" class="FAyuda">Domicilios</a></td>
							</tr>
							<tr>
								<td class="preguntasceldas"><a href="/listaDeseos/enviarCorreo.jsp" class="FAyuda">Env&iacute;o de e-Mails</a></td>
							</tr>
					</table></td>
				</tr>
				<tr>
					<td align="left" valign="top"><span class="FTtit01">PROGRAMA DE REFERIDOS </span></td>
				</tr>
				<tr>
					<td align="left" valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
							<tr>
								<td class="preguntasceldas"><a href="/referido/" class="FAyuda">Informaci&oacute;n y reglas del programa</a></td>
							</tr>
							<tr>
								<td class="preguntasceldas"><a href="/AgregarReferido" class="FAyuda">Agregar Referidos</a></td>
							</tr>
							<tr>
								<td class="preguntasceldas"><a href="/referido/consultarReferido.jsp" class="FAyuda">Mis Referidos</a></td>
							</tr>
					</table></td>
				</tr>
				<tr>
					<td align="left" valign="top"><span class="FTtit01">DATOS DE PAGO </span></td>
				</tr>
				<tr>
					<td align="left" valign="top">
						<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
								<tr>
										<td class="preguntasceldas"><a href="/miCuenta/tarjetas.jsp" class="FAyuda">Informaci&oacute;n de Tarjetas de Cr&eacute;dito</a></td>
								</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="left" valign="top"><span class="FTtit01">PROMOCIONES </span></td>
				</tr>
				<tr>
					<td align="left" valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
							<tr>
									<td class="preguntasceldas"><a href="/miCuenta/promocionesHistoricas.jsp" class="FAyuda">Promociones Utilizadas</a></td>
										</tr>
								</table></td>
							</tr>
							<tr>
								<td align="left" valign="top"><span class="FTtit01">HISTORIAL DE COMPRAS </span></td>
							</tr>
							<tr>
								<td align="left" valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
										<tr>
  											<td class="preguntasceldas"><a href="/compra/misOrdenes.jsp" class="FAyuda">Mis Ordenes</a></td>
										</tr>
								</table></td>
							
							<tr>
								<td align="left" valign="top"><span class="FTtit01">MIS LISTAS</span></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
										<tr>
  											<td class="preguntasceldas"><a href="/miCuenta/listasDeUsuarios/verTodasMisListas.jsp" class="FAyuda">Mis Listas</a></td>
										</tr>
									</table>
								</td>								
							</tr>							
							