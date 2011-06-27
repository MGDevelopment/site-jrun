<%@ page import="java.sql.Connection,
                 com.tmk.kernel.DBUtil,
                 java.sql.Statement,
                 java.sql.ResultSet,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.setup.Contenido,
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
		<%= Globals.title("Reporte de Ventas por Producto") %>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
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
					VENTAS POR PRODUCTO
				</font>

				<br><br><br>
				<font style="font-size:12px" color="#003366">
					<%= fechaDesde %>&nbsp;-&nbsp;<%= fechaHasta %>
				</font>
				<br><br>

				<%	StringBuffer sql = new StringBuffer();

					sql.append(" SELECT   cse.descripcion producto,");
					sql.append("          SUM(itmo.cantidad) cantidad,");
					sql.append("          SUM((itmo.cantidad * itmo.precio_unitario)");
					sql.append("              + itmo.iva_imp_tasa_gral");
					sql.append("              + itmo.iva_imp_tasa_adic");
					sql.append("              + itmo.imp_percep_video");
					sql.append("          ) ventas");
					sql.append("     FROM categ_secciones cse,");
					sql.append("          articulos art,");
					sql.append("          items_movimientos itmo,");
					sql.append("          envios env,");
					sql.append("          movimientos mov1,");
					sql.append("          movimientos mov2,");
					sql.append("          orden ord");
					sql.append("    WHERE INSTR(parametro_alfa('SECC_NO_LIQUIDABLE'), ',' || art.categoria_seccion || ',') = 0");
					sql.append("      AND cse.categoria_seccion = art.categoria_seccion");
					sql.append("      AND art.id_articulo = itmo.id_articulo");
					sql.append("      AND itmo.id_movimiento = mov2.id_movimiento");
					sql.append("      AND itmo.id_sucursal = mov2.id_sucursal");
					sql.append("      AND mov2.fecha >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
					sql.append("      AND mov2.fecha < TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
					sql.append("      AND mov2.id_comprobante = 'FAC'");
					sql.append("      AND mov2.id_movimiento = env.id_movimiento_fact");
					sql.append("      AND mov2.id_sucursal = env.id_sucursal_fact");
					sql.append("      AND env.id_movimiento = mov1.id_movimiento");
					sql.append("      AND env.id_sucursal = mov1.id_sucursal");
					sql.append("      AND mov1.nro_comprobante = ord.id_orden");
					sql.append("      AND mov1.nrodgi = 800");
					sql.append("      AND mov1.letra = '*'");
					sql.append("      AND mov1.id_comprobante = 'ORD'");
					sql.append("      AND ord.id_alianza = ").append(idAlianza);
					sql.append(" GROUP BY cse.descripcion");
				%>

				<table align="center" cellspacing="0" cellpadding="5" style="border: 1px solid #099BDA;">
				<tr bgcolor="#59B3D9" align="center">
					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">Producto</td>
					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">Cantidad</td>
					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">Ventas</td>
				</tr>

 				<%	int cantidadTotal = 0;
					double ventasTotales = 0;
					try {
						Connection conn = DBUtil.buildConnection();
						try {
							Statement statement = conn.createStatement();
							try {
								ResultSet resultSet = statement.executeQuery(sql.toString());
								try {
									while(resultSet.next()) {
										String producto = resultSet.getString("producto");
										int cantidad = resultSet.getInt("cantidad");
										double ventas = resultSet.getDouble("ventas");

										cantidadTotal += cantidad;
										ventasTotales += ventas;
				%>
										<tr align="center">
											<td style="border-right: 1px solid #099BDA;" width="150">
 												<%= Convert.capitalizar(producto, false)%>
											</td>

											<td style="border-right: 1px solid #099BDA;" width="150">
 												<%= Convert.toString(cantidad) %>
											</td>

											<td style="border-right: 1px solid #099BDA;" width="150">
 												<%= Contenido.precioToString(ventas) %>
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
						TmkLogger.error("No se pudo ejecutar el reporte de ventas por producto. " + e.getMessage());
					}
				%>
				<tr bgcolor="#099BDA" align="center">
					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
						TOTALES
					</td>

					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
 						<%= Convert.toString(cantidadTotal) %>
					</td>

					<td class="TextoNegro" style="border-right: 1px solid #099BDA;">
						<%= Contenido.precioToString(ventasTotales) %>
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
<html>
