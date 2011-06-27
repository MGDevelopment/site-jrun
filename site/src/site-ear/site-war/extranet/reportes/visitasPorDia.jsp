<%@ page import="java.sql.Connection,
                 com.tmk.kernel.DBUtil,
                 java.sql.Statement,
                 java.sql.ResultSet,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.extranet.reporte.ReporteHelper"%>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}

	String fechaDesde = request.getParameter(ReporteHelper.FECHA_DESDE);
	String fechaHasta = request.getParameter(ReporteHelper.FECHA_HASTA);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Reporte de Visitas por Dia") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">

	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table bgcolor="#FFFFFF" align="center" width="770" cellpadding="0" cellspacing="0" height="100%" border="0">
		<tr>
			<td align="center" valign="top">
				<table align="center" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<jsp:include page="/extranet/comunes/header.jsp"/>
							<jsp:include page="/extranet/comunes/solapas.jsp"/>
						</td>
					</tr>
				</table>
				<br><br>

				<font class="TextoBordo">
					VISITAS POR DIA
				</font>

				<br><br><br>
				<font style="font-size:12px" color="#003366">
					<%= fechaDesde %>&nbsp;-&nbsp;<%= fechaHasta %>
				</font>
				<br><br>
				<%	StringBuffer sql = new StringBuffer();

					sql.append(" SELECT   alz.razon_social,");
					sql.append("          als.seccion_nombre seccion,");
					sql.append("          TO_CHAR(vas.fecha_visita, 'dd') dia,");
					sql.append("          MIN(DECODE(TO_CHAR(vas.fecha_visita, 'mm'),");
					sql.append("                     '01', 'Enero',");
					sql.append("                     '02', 'Febrero',");
					sql.append("                     '03', 'Marzo',");
					sql.append("                     '04', 'Abril',");
					sql.append("                     '05', 'Mayo',");
					sql.append("                     '06', 'Junio',");
					sql.append("                     '07', 'Julio',");
					sql.append("                     '08', 'Agosto',");
					sql.append("                     '09', 'Septiembre',");
					sql.append("                     '10', 'Octubre',");
					sql.append("                     '11', 'Noviembre',");
					sql.append("                     'Diciembre'");
					sql.append("                    )");
					sql.append("             ) mes,");
					sql.append("          TO_CHAR(vas.fecha_visita, 'rrrr') anio,");
					sql.append("          SUM(vas.cant_visitas) visitas");
					sql.append("     FROM alianza alz,");
					sql.append("          alianza_seccion als,");
					sql.append("          visita_x_alianza_seccion vas");
					sql.append("    WHERE alz.id_alianza = als.id_alianza");
					sql.append("      AND als.id_seccion = vas.id_seccion");
					sql.append("      AND als.id_alianza = vas.id_alianza");
					sql.append("      AND vas.id_alianza = ").append(idAlianza);
					sql.append("      AND vas.fecha_visita >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
					sql.append("      AND vas.fecha_visita < TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
					sql.append(" GROUP BY alz.razon_social,");
					sql.append("          als.seccion_nombre,");
					sql.append("          TO_CHAR(vas.fecha_visita, 'rrrr'),");
					sql.append("          TO_CHAR(vas.fecha_visita, 'mm'),");
					sql.append("          TO_CHAR(vas.fecha_visita, 'dd')");
					sql.append(" ORDER BY 1,");
					sql.append("          2,");
					sql.append("          TO_CHAR(vas.fecha_visita, 'rrrr'),");
					sql.append("          TO_CHAR(vas.fecha_visita, 'mm'),");
					sql.append("          TO_CHAR(vas.fecha_visita, 'dd')");

					String seccion = "";
					int ultimoAnio = 0;
					String ultimoMes = null;
					int subTotal = 0;
					int total = 0;

					try {
						Connection conn = DBUtil.buildConnection();
						try {
							Statement statement = conn.createStatement();
							try {
								ResultSet resultSet = statement.executeQuery(sql.toString());

								try {
									while(resultSet.next()) {
										int anio = resultSet.getInt("anio");
										String mes = resultSet.getString("mes");
										int dia = resultSet.getInt("dia");
										int visitas = resultSet.getInt("visitas");

									    if (!resultSet.getString("seccion").equals(seccion)) {

											if (!"".equals(seccion)) {
												total += subTotal;
				%>
												<tr align="center">
													<td style="border-right: 1px solid #099BDA;">&nbsp;</td>
													<td style="border-right: 1px solid #099BDA;">&nbsp;</td>

													<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #59B3D9 ;">
														SUBTOTAL
													</td>

													<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #59B3D9 ;">
														<%= subTotal %>
													</td>
												</tr>

												<tr bgcolor="#099BDA" align="center" style="border-right: 1px solid #59B3D9 ;">
													<td height="30" style="border-right: 1px solid #099BDA;">&nbsp;</td>
													<td height="30" style="border-right: 1px solid #099BDA;">&nbsp;</td>

													<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
														TOTAL
													</td>

													<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
														<%= total %>
													</td>
												</tr>
												</table>
												<br><br>
				<%							}

											seccion = resultSet.getString("seccion");

											ultimoAnio = 0;
											ultimoMes = null;
											subTotal = 0;
											total = 0;
				%>
                							<br><br>
											<table align="center" cellpadding="0" cellspacing="0" width="400" border="0">
											<tr>
												<td width="70">
													<font class="TextoBordo">
														Seccion:
													</font>
												</td>
												<td>
													<font class="TextoNegro">
														<%= seccion %>
													</font>
												</td>
											</tr>
											</table>
											<br>

											<table align="center" cellspacing="0" cellpadding="3" style="border: 1px solid #099BDA">
												<tr bgcolor="#59B3D9" align="center">
													<td width="97" class="TextoNegro" style="border-right: 1px solid #099BDA;">Año</td>
													<td width="95" class="TextoNegro" style="border-right: 1px solid #099BDA;">Mes</td>
													<td width="94" class="TextoNegro" style="border-right: 1px solid #099BDA;">Dia</td>
													<td width="108" class="TextoNegro" style="border-right: 1px solid #099BDA;">Visitas</td>
												</tr>

				<%						}

										if(mes.equals(ultimoMes) == false && ultimoMes != null) {
				%>
											<tr align="center">
												<td style="border-right: 1px solid #099BDA;">&nbsp;</td>
												<td style="border-right: 1px solid #099BDA;">&nbsp;</td>

												<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #099BDA;">
													SUBTOTAL
												</td>

												<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #099BDA;">
 													<%= subTotal %>
												</td>
											</tr>
				<%
											total += subTotal;
											subTotal = 0;
										}

										subTotal += visitas;
				%>
										<tr align="center" class="TextoDescripcion" >
											<td style="border-right: 1px solid #099BDA;">
				<%								if(ultimoAnio == 0 || ultimoAnio != anio) {
													ultimoAnio = anio;
				%>
 													<%= ultimoAnio %>
 				<%								} else {
				%>									&nbsp;
 				<%								}
				%>
											</td>

											<td style="border-right: 1px solid #099BDA;">
				<%								if(ultimoMes == null || ultimoMes.equals(mes) == false) {
													ultimoMes = mes;
				%>
													<%= ultimoMes %>
 				<%								} else {
				%>									&nbsp;
 				<%								}
				%>
											</td>

											<td style="border-right: 1px solid #099BDA;">
 												<%= dia %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
 												<%= visitas %>
											</td>
										</tr>
				<%					}

									if (subTotal > 0 ){
				%>
										<tr align="center">
											<td style="border-right: 1px solid #099BDA;">&nbsp;</td>
											<td style="border-right: 1px solid #099BDA;">&nbsp;</td>

											<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #59B3D9 ;">
												SUBTOTAL
											</td>

											<td bgcolor="#59B3D9" class="TextoNegro" style="border-right: 1px solid #59B3D9 ;">
												<%= subTotal %>
											</td>
										</tr>
 				<%					}
									total += subTotal;

								} finally {
									resultSet.close();
								}
							} finally {
								statement.close();
							}
						} finally {
							conn.close();
						}
					} catch (Exception e) {
						TmkLogger.error("No se pudo ejecutar el reporte de visitas por dias. " + e.getMessage());
					}

					if (total > 0 ) {
				%>
						<tr bgcolor="#099BDA" align="center" style="border-right: 1px solid #59B3D9 ;">
							<td height="30" style="border-right: 1px solid #099BDA;">&nbsp;</td>
							<td height="30" style="border-right: 1px solid #099BDA;">&nbsp;</td>

							<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
								TOTAL
							</td>

							<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
								<%= total %>
							</td>
						</tr>
						</table>
				<%	}
				%>
				<br><br>
			</td>
		</tr>

		<tr>
			<td>
				<table>
				<tr>
					<td align="right" width="750">
						<a href="<%= ReporteHelper.HOME_REPORTES %>">
							<img src="/imagenes/botonVolver.gif" border="0">
						</a>
					</td>
				</tr>
				</table>

				<br><br>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>