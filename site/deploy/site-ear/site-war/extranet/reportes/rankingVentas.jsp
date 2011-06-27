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
		<%= Globals.title("Reporte de Ranking de Ventas") %>
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
					RANKING DE VENTAS
				</font>

				<br><br><br>
				<font style="font-size:12px" color="#003366">
					<%= fechaDesde %>&nbsp;-&nbsp;<%= fechaHasta %>
				</font>
				<br><br>

            	<%	StringBuffer sql = new StringBuffer();

					sql.append(" SELECT  NVL(art.cod_ext_visual, art.id_articulo) isbn,");
					sql.append("         art.titulo titulo,");
					sql.append("         SUM(itmo.cantidad) cantidad,");
					sql.append("             itmo.precio_unitario");
					sql.append("           + itmo.iva_imp_tasa_gral");
					sql.append("           + itmo.iva_imp_tasa_adic");
					sql.append("           + itmo.imp_percep_video precio_unitario,");
					sql.append("         SUM(   (itmo.cantidad * itmo.precio_unitario)");
					sql.append("              + itmo.iva_imp_tasa_gral");
					sql.append("              + itmo.iva_imp_tasa_adic");
					sql.append("              + itmo.imp_percep_video");
					sql.append("             ) precio_total");
					sql.append("     FROM articulos art,");
					sql.append("          items_movimientos itmo,");
					sql.append("          movimientos mov2,");
					sql.append("          envios env,");
					sql.append("          movimientos mov1,");
					sql.append("          orden ord");
					sql.append("    WHERE art.categoria_seccion != 99");
					sql.append("      AND art.id_articulo = itmo.id_articulo");
					sql.append("      AND itmo.id_movimiento = mov2.id_movimiento");
					sql.append("      AND itmo.id_sucursal = mov2.id_sucursal");
					sql.append("      AND mov2.fecha >= TO_DATE('").append(fechaDesde).append("', 'dd/mm/yyyy')");
					sql.append("      AND mov2.fecha < TO_DATE('").append(fechaHasta).append("', 'dd/mm/yyyy') + 1");
					sql.append("      AND mov2.id_movimiento = env.id_movimiento_fact");
					sql.append("      AND mov2.id_sucursal = env.id_sucursal_fact");
					sql.append("      AND env.id_movimiento = mov1.id_movimiento");
					sql.append("      AND env.id_sucursal = mov1.id_sucursal");
					sql.append("      AND mov1.nro_comprobante = ord.id_orden");
					sql.append("      AND mov1.nrodgi = 800");
					sql.append("      AND mov1.letra = '*'");
					sql.append("      AND mov1.id_comprobante = 'ORD'");
					sql.append("      AND ord.id_alianza = ").append(idAlianza);
					sql.append(" GROUP BY art.id_articulo,");
					sql.append("          NVL(art.cod_ext_visual, art.id_articulo),");
					sql.append("          art.titulo,");
					sql.append("             itmo.precio_unitario");
					sql.append("           + itmo.iva_imp_tasa_gral");
					sql.append("           + itmo.iva_imp_tasa_adic");
					sql.append("           + itmo.imp_percep_video");
					sql.append(" ORDER BY 1,");
					sql.append("          2,");
					sql.append("          3");
				%>

            	<table align="center" cellspacing="0" cellpadding="5" style="border: 1px solid #099BDA; font-size: 14px;">
                <tr  bgcolor="#59B3D9" align="center" style="border-right: 1px solid #099BDA;">
                    <td width="93" class="TextoNegro" style="border-right: 1px solid #099BDA;">
						ISBN / Código
					</td>

					<td width="229" class="TextoNegro" style="border-right: 1px solid #099BDA;">
						Título
					</td>

					<td width="99" class="TextoNegro" style="border-right: 1px solid #099BDA;">
						Cantidad
					</td>

					<td width="108" class="TextoNegro" style="border-right: 1px solid #099BDA;">
						Precio Unitario
					</td>

					<td width="117" class="TextoNegro" style="border-right: 1px solid #099BDA;">
						Precio Total
					</td>
                </tr>

 				<%	int cantidadTotal = 0;
                	double precioTotal = 0;

					try {
						Connection conn = DBUtil.buildConnection();
						try {
							Statement statement = conn.createStatement();
							try {
								ResultSet resultSet = statement.executeQuery(sql.toString());
								try {
									while(resultSet.next()) {
										String isbn = resultSet.getString("isbn");
										String titulo = resultSet.getString("titulo");
										int cantidad = resultSet.getInt("cantidad");
										double precio_unitario = resultSet.getDouble("precio_unitario");
										double precio_total = resultSet.getDouble("precio_total");

										cantidadTotal += cantidad;
										precioTotal += precio_total;

				%>
										<tr align="center" class="TextoDescripcion">
											<td style="border-right: 1px solid #099BDA;">
 												<%= Convert.toString(isbn) %>
											</td>

											<td align="left" style="border-right: 1px solid #099BDA;">
 												<%= Convert.capitalizar(titulo, true) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
 												<%= Convert.toString(cantidad) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
 												<%= Contenido.precioToString(precio_unitario)%>
											</td>

											<td style="border-right: 1px solid #099BDA;">
 												<%= Contenido.precioToString(precio_total) %>
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
						TmkLogger.error(e.getMessage());
					}
                %>
                <tr bgcolor="#099BDA" align="center" class="TextoNegro" >
                    <td style="border-right: 1px solid #099BDA;">&nbsp;</td>

					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">
						TOTAL
					</td>

					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">
 						<%= Convert.toString(cantidadTotal) %>
					</td>

					<td style="border-right: 1px solid #099BDA;">&nbsp;</td>

                    <td style="border-right: 1px solid #099BDA;" class="TextoNegro">
						<%= Contenido.precioToString(precioTotal) %>
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