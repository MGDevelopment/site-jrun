<%@ page import="com.tmk.kernel.DBUtil,
                 javax.naming.NamingException,
                 com.tmk.kernel.Convert,
                 java.sql.*,
                 com.tmk.kernel.TmkLogger,
                 java.util.Date,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.extranet.reporte.ReporteHelper" %>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}

	int estado = Convert.toNumber(request.getParameter(ReporteHelper.ESTADO), ReporteHelper.COBRADAS);
	String fechaDesde = request.getParameter(ReporteHelper.FECHA_DESDE);
	String fechaHasta = request.getParameter(ReporteHelper.FECHA_HASTA);
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Reporte de Comisiones Liquidadas") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table bgcolor="#FFFFFF" align="center" width="770" cellpadding="0" cellspacing="0" height="100%">
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
					COMISIONES <%= (estado == ReporteHelper.PENDIENTES)?"EN PROCESO DE LIQUIDACION":"COBRADAS" %>
				</font>

				<br><br><br>
				<font style="font-size:12px" color="#003366">
					<%= fechaDesde %>&nbsp;-&nbsp;<%= fechaHasta %>
				</font>
				<br><br>

				<table align="center" cellspacing="0" cellpadding="5" style="border: 1px solid #5AB5DE; font-size: 14px;">
				<tr bgcolor="#59B3D9" align="center">
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Id de pago</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Calculado al..</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Tipo Comision</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Porcentaje</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Importe Vendido</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Importe Comision</td>
				</tr>

				<%	double total = 0;

					try {
						Connection conn = DBUtil.buildConnection();
						try {
							StringBuffer sql = new StringBuffer();

							sql.append(" SELECT  ord.*,");
							sql.append("       ROUND((ord.importe_vendido * ord.porcentaje_comision) / 100, 2) importe_comision");
							sql.append("    FROM (SELECT    alliq.id_liquidacion id_pago,");
							sql.append("                    alliq.fecha_liquidacion fecha_liquidacion,");
							sql.append("                    ali.razon_social alianza,");
							sql.append("                    tcomal.descripcion tipo_comision_calculada,");
							sql.append("                    itli.porc_comision_alianza porcentaje_comision,");
							sql.append("                    SUM(ROUND(   (itmo.cantidad * precio_unitario)");
							sql.append("                               + itmo.precio_unitario");
							sql.append("                               + itmo.iva_imp_tasa_gral");
							sql.append("                               + itmo.iva_imp_tasa_adic");
							sql.append("                               + itmo.imp_percep_video");
							sql.append("                              , 2");
							sql.append("                             )");
							sql.append("                       ) importe_vendido,");
							sql.append("                    SUM(itmo.cantidad) cantidad");
							sql.append("               FROM tipo_comision_alianza tcomal,");
							sql.append("                    alianza ali,");
							sql.append("                    items_movimientos itmo,");
							sql.append("                    items_liquidaciones itli,");
							sql.append("                    alianza_liquidacion alliq");
							sql.append("              WHERE tcomal.tipo_comision = itli.tipo_comision_alianza");
							sql.append("                AND ali.id_alianza = alliq.id_alianza");
							sql.append("                AND itmo.item = itli.item");
							sql.append("                AND itmo.id_movimiento = itli.id_movimiento");
							sql.append("                AND itmo.id_sucursal = itli.id_sucursal");
							sql.append("                AND itli.estado = ").append((estado == ReporteHelper.PENDIENTES)?"'PP'":"'PA'");
							sql.append("                AND itli.tipo_comision_alianza = 'VOLV'");
							sql.append("                AND itli.id_liquidacion_alianza = alliq.id_liquidacion");
							sql.append("                AND alliq.id_alianza = ").append(idAlianza);
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) <= TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
							sql.append("           GROUP BY alliq.id_liquidacion,");
							sql.append("                    ali.razon_social,");
							sql.append("                    tcomal.descripcion,");
							sql.append("                    alliq.fecha_liquidacion,");
							sql.append("                    itli.porc_comision_alianza");
							sql.append("           UNION ALL");
							sql.append("           SELECT   alliq.id_liquidacion,");
							sql.append("                    alliq.fecha_liquidacion,");
							sql.append("                    ali.razon_social,");
							sql.append("                    TRIM(tcomal.descripcion) || ' ' || catsec.descripcion,");
							sql.append("                    itli.porc_comision_alianza,");
							sql.append("                    SUM(ROUND(  (itmo.cantidad * itmo.precio_unitario)");
							sql.append("                               + itmo.iva_imp_tasa_gral");
							sql.append("                               + itmo.iva_imp_tasa_adic");
							sql.append("                               + itmo.imp_percep_video");
							sql.append("                              , 2");
							sql.append("                             )");
							sql.append("                       ),");
							sql.append("                    SUM(itmo.cantidad)");
							sql.append("               FROM categ_secciones catsec,");
							sql.append("                    articulos art,");
							sql.append("                    tipo_comision_alianza tcomal,");
							sql.append("                    alianza ali,");
							sql.append("                    items_movimientos itmo,");
							sql.append("                    items_liquidaciones itli,");
							sql.append("                    alianza_liquidacion alliq");
							sql.append("              WHERE catsec.categoria_seccion = art.categoria_seccion");
							sql.append("                AND art.id_articulo = itli.id_articulo");
							sql.append("                AND tcomal.tipo_comision = itli.tipo_comision_alianza");
							sql.append("                AND ali.id_alianza = alliq.id_alianza ");
							sql.append("                AND itmo.item = itli.item");
							sql.append("                AND itmo.id_movimiento = itli.id_movimiento");
							sql.append("                AND itmo.id_sucursal = itli.id_sucursal");
							sql.append("                AND itli.estado = ").append((estado == ReporteHelper.PENDIENTES)?"'PP'":"'PA'");
							sql.append("                AND itli.tipo_comision_alianza = 'TPRO'");
							sql.append("                AND itli.id_liquidacion_alianza = alliq.id_liquidacion");
							sql.append("                AND alliq.id_alianza = ").append(idAlianza);
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) <= TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
							sql.append("           GROUP BY alliq.id_liquidacion,");
							sql.append("                    ali.razon_social,");
							sql.append("                    TRIM(tcomal.descripcion) || ' ' || catsec.descripcion,");
							sql.append("                    alliq.fecha_liquidacion,");
							sql.append("                    itli.porc_comision_alianza");
							sql.append("           UNION ALL");
							sql.append("           SELECT   alliq.id_liquidacion,");
							sql.append("                    alliq.fecha_liquidacion,");
							sql.append("                    ali.razon_social,");
							sql.append("                    tcomal.descripcion,");
							sql.append("                     itli.porc_comision_alianza,");
							sql.append("                    SUM(ROUND(   (itmo.cantidad * itmo.precio_unitario)");
							sql.append("                               + itmo.iva_imp_tasa_gral");
							sql.append("                               + itmo.iva_imp_tasa_adic");
							sql.append("                               + itmo.imp_percep_video");
							sql.append("                              , 2");
							sql.append("                             )");
							sql.append("                       ),");
							sql.append("                    SUM(itmo.cantidad)");
							sql.append("               FROM tipo_comision_alianza tcomal,");
							sql.append("                    alianza ali,");
							sql.append("                    items_movimientos itmo,");
							sql.append("                    items_liquidaciones itli,");
							sql.append("                    alianza_liquidacion alliq");
							sql.append("              WHERE tcomal.tipo_comision = itli.tipo_comision_alianza");
							sql.append("                AND ali.id_alianza = alliq.id_alianza");
							sql.append("                AND itmo.item = itli.item");
							sql.append("                AND itmo.id_movimiento = itli.id_movimiento");
							sql.append("                AND itmo.id_sucursal = itli.id_sucursal");
							sql.append("                AND itli.estado = ").append((estado == ReporteHelper.PENDIENTES)?"'PP'":"'PA'");
							sql.append("                AND itli.tipo_comision_alianza = 'PORC'");
							sql.append("                AND itli.id_liquidacion_alianza = alliq.id_liquidacion");
							sql.append("                AND alliq.id_liquidacion = ").append(idAlianza);
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
							sql.append("                AND TRUNC(alliq.fecha_liquidacion) <= TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
							sql.append("           GROUP BY alliq.id_liquidacion,");
							sql.append("                    ali.razon_social,");
							sql.append("                    tcomal.descripcion,");
							sql.append("                    alliq.fecha_liquidacion,");
							sql.append("                    itli.porc_comision_alianza) ord");
							sql.append(" ORDER BY 1,");
							sql.append("          2,");
							sql.append("          3,");
							sql.append("          4");

							Statement statement = conn.createStatement();
							try {
								ResultSet resultSet = statement.executeQuery(sql.toString());
								try {
									while(resultSet.next()) {
										String idPago = resultSet.getString("id_pago");
										Date fechaLiquidacion = resultSet.getDate("fecha_liquidacion");
										String tipoComisionCalculada = resultSet.getString("tipo_comision_calculada");
										double porcentajeComision = resultSet.getInt("porcentaje_comision");
										double importeVendido = resultSet.getDouble("importe_vendido");
										double importeComision = resultSet.getDouble("importe_comision");

										total += importeComision;
				%>
										<tr align="center" class="TextoDescripcion">
											<td style="border-right: 1px solid #099BDA;">
												<%= Convert.toString(idPago) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Convert.toString(fechaLiquidacion) %>
											</td>

											<td align="left" style="border-right: 1px solid #099BDA;">
												<%= Convert.capitalizar(tipoComisionCalculada, false) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Contenido.porcentajeToString(porcentajeComision) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Contenido.precioToString(importeVendido)%>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Contenido.precioToString(importeComision) %>
											</td>
										</tr>
				<%					}
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
						TmkLogger.error("No se pudo ejecutar el reporte de comisiones cobradas. " + e.getMessage());
					}
				%>

				<tr bgcolor="#099BDA" align="center" class="TextoNegro" >
                    <td colspan="5" style="border-right: 1px solid #099BDA;" class="TextoNegro">
						TOTAL
					</td>
                    <td style="border-right: 1px solid #099BDA;" class="TextoNegro">
 						<%= Contenido.precioToString(total) %>
					</td>
                </tr>
				</table>

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
