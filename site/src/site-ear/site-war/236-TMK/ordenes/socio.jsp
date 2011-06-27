<%@ page import="com.tmk.util.ShortCuts,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.kernel.*,
                 java.util.Iterator,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.orden.PagoOrdenLocalHome,
                 com.tmk.orden.PagoOrdenLocal,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.setup.Contenido,
                 com.tmk.src.fidelizacion.FidelizacionHelper,
                 com.tmk.src.fidelizacion.PuntajeWrapper,
                 java.sql.Connection,
                 com.tmk.bus.socio.SocioTMK"%>

<%--
				com.tmk.socio.SocioLocal 
--%>

<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<html>
<script type="text/javascript">
	function detalleOrden(idOrden){
		window.open('/236-TMK/ordenes/estadoOrden.jsp?idOrden=' + idOrden,'',
			"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=700, height=700");
	}
</script>
<html>
	<head>
		<%= Globals.estiloBasico() %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>
	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="770">
			<tr>
				<td>
					<table width="100%" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<jsp:include page="/236-TMK/comunes/header.jsp"/>
							</td>
						</tr>
					</table>

				<br>

				<%
                    String mensaje = "No existe el socio en el sitio";

					//SocioLocal socioLocal = null;
					Socios2 socioLocal = null;
					SocioTMK socioTMK = new SocioTMK();
                    try {
						String email = Convert.toString(request.getParameter("email"), null);
						if (email != null) {
							TmkLogger.debug("Intranet: Busqueda de socio por email: " + email);
							// busca por login
							//socioLocal = ShortCuts.findSocioByLogin(email);
							socioLocal = ShortCuts.findSocioByLogin(email);
                            if (socioLocal == null) {
                                // no lo encontro, busca por email migrado
								//socioLocal = ShortCuts.findSocioByEMail1(email);
								try {
									Connection conn = DBUtil.buildConnection();
							 	 	try {
							 			socioTMK.select(conn, new String[] {"login ='" + email.toUpperCase() + "'"});

									 } finally {
								 		 conn.close();
								 	}
								 } catch (Exception e) {
								 	//fallo al abrir conn
								 }
							}

						} else {

							Integer sucursal = Convert.toNumber(request.getParameter("sucursal"), (Integer)null);
							Integer socio = Convert.toNumber(request.getParameter("socio"), (Integer)null);

							if ((sucursal != null) && (socio != null)) {
								TmkLogger.debug("Intranet: Busqueda de socio por sucursal: " + sucursal + ", socio: " + socio);
								// directo al usuario
								SocioPK socioPK = new SocioPK();
								socioPK.ID_SUCURSAL = sucursal;
								socioPK.ID_SOCIO = socio;
								socioLocal = ShortCuts.findSocioById(socioPK);
							}
						}

	                    //TmkLogger.debug("Intranet: Busqueda de socio: " + socioLocal.getEMAIL());
						TmkLogger.debug("Intranet: Busqueda de socio: " + socioLocal.getlogin());

                    } catch (Exception e) {
	                    // Si fallo no hace nada
	                    TmkLogger.debug(e.toString());
	                    mensaje = "No se pudo cargar el socio. Notifique a desarrollo.";
                    }
				%>

				<table align="center" width="600" border="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<%	if (socioLocal == null && socioTMK.getIdSucursal() == null) {%>
						<tr valign="top">
							<td align="center">
								<br><br><br>
								<h2>
									<%= mensaje %>

								</h2>
							</td>
						</tr>
					<%	} else if(socioLocal != null) {%>
						<tr>
							<td>
								<br>
								<div align="center">
									<font class="TextoBordo">Datos Personales</font>
								</div>
								<br><br>
								<table width="100%" style="border: 1px solid #59B3D9;" border="0" cellspacing="1" cellpadding="0">
									<font class=" TextoDescripcion">

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td width="20%"><b>NOMBRES:</b></td>
											<%--<td width="30%"><%=Convert.toString(socioLocal.getNOMBRES())%></td>--%>
											<td width="30%"><%=Convert.toString(socioLocal.getNombres())%></td>
											<td width="20%"><b>APELLIDOS:</b></td>
											<%--<td width="30%"><%=Convert.toString(socioLocal.getAPELLIDOS())%></td>--%>
											<td width="30%"><%=Convert.toString(socioLocal.getApellidos())%></td>
										</tr>

										<tr>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										</tr>

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<%  if (Globals.FIDELIZACION_VIGENTE) { %>
										<tr>
											<td><b>Fidelización:</b></td>
											<%
												PuntajeWrapper puntajeWrapper = null;
												try {
													//puntajeWrapper = FidelizacionHelper.consultarPuntos(socioLocal.getID_SUCURSAL(), socioLocal.getID_SOCIO());
													puntajeWrapper = FidelizacionHelper.consultarPuntos(socioLocal.getId_sucursal(), socioLocal.getId_socio());
												} catch (Exception e) {
													// IGNORA EL ERROR Y SIMPLEMENTE NO MUESTRA LOS PUNTOS
												}
											%>
											<td><%=Convert.toString((puntajeWrapper == null) ? "No tiene cuenta informada" : Convert.pluralCompleto(puntajeWrapper.getPuntos(), "punto"))%></td>
											<td>&nbsp;<b>Más datos:</b></td>
											<td>&nbsp;<%=Convert.toString((puntajeWrapper == null) ? "-" : puntajeWrapper.toString())%></td>
										</tr>
										<%  } %>

										<tr>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										</tr>

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
                                    <%-- if (socioLocal.getLOGIN() != null) {--%>
                                    <% if (socioLocal.getlogin() != null) {%>
										<tr>
											<td><b>Login:</b></td>
											<%--<td><%=Convert.toString(new String(CryptUtil.desEncriptar(socioLocal.getLOGIN())))%></td>--%>
											<td><%=Convert.toString(socioLocal.getlogin())%></td>
											<td><b>Password:</b></td>
											<%--<td><%=Convert.toString(new String(CryptUtil.desEncriptar(socioLocal.getPASSWORD())))%></td>--%>
											<td><%=Convert.toString(socioLocal.getpassword())%></td>
										</tr>
                                    <% }%>
										<tr>
											<td><b>Mail:</b></td>
											<%--<td><%=Convert.toString(socioLocal.getE_MAIL1())%></td>--%>
											<td><%=Convert.toString(socioLocal.getE_mail1())%></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										</tr>

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td><b>Tipo de Documento:</b></td>
											<%--<td><%=Convert.toString(socioLocal.getTIPO_DOC())%></td>--%>
											<td><%=Convert.toString(socioLocal.getTipo_doc())%></td>
											<td><b>Documento:</b></td>
											<td><%=Convert.toString(socioLocal.getNro_doc())%></td>
										</tr>
										<tr>
											<td><b>Estado Civil:</b></td>
											<td><%=EstadoCivilDAO.getEstadoCivil(socioLocal.getEstado_civil()).getNombre()%></td>
											<td><b>Profesion:</b></td>
											<td><%=ProfesionDAO.getProfesion(socioLocal.getId_profesion()).getNombre()%></td>
										</tr>
										<tr>
											<td><b>Hijos:</b></td>
											<td><%=Convert.toString(socioLocal.getHijos())%></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
											<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										</tr>

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td><b>Sucursal:</b></td>
											<td><%=Convert.toString(socioLocal.getId_sucursal())%></td>
											<td><b>Socio:</b></td>
											<td><%=Convert.toString(socioLocal.getId_socio())%></td>
										</tr>

										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</font>
								</table>
							</td>
					</tr>

					<%out.flush();%>

					<%
						PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
						OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
						Iterator ordenes = ordenLocalHome.findOrdenesPorSocio(socioLocal.getId_sucursal(), socioLocal.getId_socio()).iterator();
					%>
					<tr>
						<td>
							<br><br>
							<div align="center">
								<font class="TextoBordo">Ordenes</font>
								<br><br>
							</div>
							<table width="100%" cellpadding="3" cellspacing="0" style="border: 1px solid #59B3D9;"  >
                               <tr align="center" bgColor="#59B3D9">
                                   <td width="99"><b>Orden</b></td>
                                   <td width="125"><b>Fecha</b></td>
                                   <td width="231"><b>Estado</b></td>
                                   <td width="180"><b>Medio de Pago</b></td>
                                   <td width="87"><b>Total</b></td>
                               </tr>
                                <%
                                while (ordenes.hasNext()) {
                                    OrdenLocal ordenLocal = (OrdenLocal)ordenes.next();
	                                Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN()).iterator();
                                    //PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN());
                                    //MedioDeCobroDAO medioCobroDAO = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());%>

                                    <tr>
										<td width="14%" align="right" style="border-right: 1px solid #59B3D9; "><a href="javascript:detalleOrden(<%= ordenLocal.getID_ORDEN() %>)"><%=Convert.toString(ordenLocal.getID_ORDEN())%></a></td>

										<td width="17%" style="border-right: 1px solid #59B3D9; " align="center"><%=Convert.toStringLargo(ordenLocal.getFECHA())%></td>

										<td width="32%" style="border-right: 1px solid #59B3D9; "><%=EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getDescripcion()%></td>


										<td width="25%" style="border-right: 1px solid #59B3D9; ">
                                        <% while (pagosOrden.hasNext()) {
	                                        PagoOrdenLocal pagoOrdenLocal = (PagoOrdenLocal)pagosOrden.next();
                                            MedioDeCobroDAO medioCobroDAO = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());%>

                                        <%=Convert.toString(medioCobroDAO.getNombre())%>
                                        <br>
                                        <% }%>

                                        </td>

										<td width="12%" align="right"><%=Contenido.precioToString(ordenLocal.getTOTAL().doubleValue())%></td>
									</tr>
							  <% }%>

							</table>
						</td>
					</tr>

				<%	} else if(socioTMK.getIdSucursal() != null) {
				%>
					<tr>
						<td>
							<br>
							<div align="center">
								<font class="TextoBordo">Datos Personales</font>
							</div>
							<br><br>
							<table width="100%" style="border: 1px solid #59B3D9;" border="0" cellspacing="1" cellpadding="0">
								<font class=" TextoDescripcion">

									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td width="20%"><b>NOMBRES:</b></td>
										<td width="30%"><%=Convert.toString(socioTMK.getNombres())%></td>
										<td width="20%"><b>APELLIDOS:</b></td>
										<td width="30%"><%=Convert.toString(socioTMK.getApellidos())%></td>
									</tr>

									<tr>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td><b>Login:</b></td>
										<td><%=Convert.toString(socioTMK.getLogin())%></td>
										<td><b>Password:</b></td>
										<td><%=Convert.toString(new String(CryptUtil.desEncriptar(socioTMK.getPassword())))%></td>
									</tr>

									<tr>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
										<td style="border-bottom: 1px solid #59B3D9;">&nbsp;</td>
									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td><b>Sucursal:</b></td>
										<td><%=Convert.toString(socioTMK.getIdSucursal())%></td>
										<td><b>Socio:</b></td>
										<td><%=Convert.toString(socioTMK.getIdSocio())%></td>
									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								</font>
							</table>
						</td>
					</tr>
				<%	} %>
				</table>
				</td>
			</tr>
		</table>
	</body>
</html>
