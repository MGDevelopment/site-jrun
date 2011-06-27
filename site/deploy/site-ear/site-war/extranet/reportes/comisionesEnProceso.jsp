<%@ page import="com.tmk.kernel.DBUtil,
                 javax.naming.NamingException,
                 com.tmk.kernel.Convert,
                 java.sql.*,
                 com.tmk.kernel.TmkLogger,
                 java.util.Date,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper,
				 com.tmk.controllers.extranet.reporte.ReporteHelper" %>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}
%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Reporte de Comisiones en Proceso") %>
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
					COMISIONES EN PROCESO
				</font>

				<br><br><br>
				<font style="font-size:12px" color="#003366">
					<%= Convert.toString(new Date(System.currentTimeMillis())) %>
				</font>
				<br><br>

				<table align="center" cellspacing="0" cellpadding="5" style="border: 1px solid #5AB5DE; font-size: 14px;" >
				<tr bgcolor="#59B3D9" align="center">
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Tipo Comision</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Porcentaje</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Importe Vendido</td>
					<td style="border-right: 1px solid #099BDA;" class="TextoNegro">Importe Comision</td>
				</tr>

				<%	int idLiquidacion = 0;
					double total = 0;

					try {
						Connection conn = DBUtil.buildConnection();
						try {

							CallableStatement cs = conn.prepareCall("{call PA_LIQUIDACION_ALIANZAS.pr_liquidar_comisiones_alianza (?, ?, ?, ?)}");

							try {
								int index = 0;
								cs.setInt(++index, idAlianza.intValue());
								cs.setDate(++index, new java.sql.Date(new Date().getTime()));
								cs.setString(++index, "P");
								cs.registerOutParameter(++index, java.sql.Types.INTEGER);
								cs.execute();
								idLiquidacion  = cs.getInt(4);
								TmkLogger.debug("La clave para el reporte es " + idLiquidacion);

							} finally {
								cs.close();
							}

							StringBuffer sql = new StringBuffer();

							sql.append(" select z.razon_social                                  alianza,");
							sql.append("        t.descripcion                                   tipo_comision_calculada,");
							sql.append("        x.porc_comision                                 porcentaje_comision,");
							sql.append("        sum( round(x.cantidad * x.precio_promocion, 2)) importe_vendido,");
							sql.append("        sum( round(((x.cantidad * x.precio_promocion) * x.porc_comision) / 100, 2)) importe_comision");
							sql.append("   from tipo_comision_alianza t,");
							sql.append("        alianza z,");
							sql.append("        tmp_calc_liquidacion_alianza x");
							sql.append("   where t.tipo_comision  = z.tipo_comision");
							sql.append("     and z.id_alianza     = x.id_alianza ");
							sql.append("     and x.tipo_comision  = 'VOLV'");
							sql.append("     and x.id_liquidacion = ").append(idLiquidacion);
							sql.append("   group by z.razon_social,");
							sql.append("            t.descripcion,");
							sql.append("            x.porc_comision");
							sql.append(" union all");
							sql.append(" select z.razon_social                                  ,            ");
							sql.append("        trim(t.descripcion)||' '||c.descripcion         ,           ");
							sql.append("        x.porc_comision                                 ,         ");
							sql.append("        sum( round(x.cantidad * x.precio_promocion, 2)) ,");
							sql.append("        sum( round(((x.cantidad * x.precio_promocion) * x.porc_comision) / 100, 2))");
							sql.append("   from categ_secciones c,");
							sql.append("        articulos       a,");
							sql.append("        tipo_comision_alianza t,");
							sql.append("        alianza z,");
							sql.append("        tmp_calc_liquidacion_alianza x");
							sql.append("   where c.categoria_seccion = a.categoria_seccion");
							sql.append("     and a.id_articulo       = x.id_articulo");
							sql.append("     and t.tipo_comision     = z.tipo_comision");
							sql.append("     and z.id_alianza        = x.id_alianza ");
							sql.append("     and x.tipo_comision     = 'TPRO'");
							sql.append("     and x.id_liquidacion    = ").append(idLiquidacion);
							sql.append("   group by z.razon_social,");
							sql.append("            trim(t.descripcion)||' '||c.descripcion,");
							sql.append("            x.porc_comision");
							sql.append(" union all");
							sql.append(" select z.razon_social                                  alianza,");
							sql.append("        t.descripcion                                   tipo_comision_calculada,");
							sql.append("        x.porc_comision                                 porcentaje_comision,");
							sql.append("        sum( round(x.cantidad * x.precio_promocion, 2)) importe_vendido,");
							sql.append("        sum( round(((x.cantidad * x.precio_promocion) * x.porc_comision) / 100, 2)) importe_comision");
							sql.append("   from tipo_comision_alianza t,");
							sql.append("        alianza z,");
							sql.append("        tmp_calc_liquidacion_alianza x");
							sql.append("   where t.tipo_comision  = z.tipo_comision");
							sql.append("     and z.id_alianza     = x.id_alianza ");
							sql.append("     and x.tipo_comision  = 'PORC'");
							sql.append("     and x.id_liquidacion = ").append(idLiquidacion);
							sql.append("   group by z.razon_social,");
							sql.append("            t.descripcion,");
							sql.append("            x.porc_comision");
							sql.append("  order by 1, 2, 3, 4");

							Statement statement = conn.createStatement();
							try {
								ResultSet resultSet = statement.executeQuery(sql.toString());
								try {
									while(resultSet.next()) {
										String tipo_comision_calculada = resultSet.getString("tipo_comision_calculada");
										double porcentaje_comision = resultSet.getInt("porcentaje_comision");
										double importe_vendido = resultSet.getDouble("importe_vendido");
										double importe_comision = resultSet.getDouble("importe_comision");

										total += importe_comision;
				%>
										<tr align="center" class="TextoDescripcion">
											<td align="left" style="border-right: 1px solid #099BDA;">
												<%= Convert.capitalizar(tipo_comision_calculada, false) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Contenido.porcentajeToString(porcentaje_comision) %>
											</td>

											<td style="border-right: 1px solid #099BDA;">
												<%= Contenido.precioToString(importe_vendido)%>
											</td>

											<td>
												<%= Contenido.precioToString(importe_comision) %>
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
                    <td colspan="3" style="border-right: 1px solid #099BDA;" class="TextoNegro">
						TOTAL
					</td>
                    <td style="border-right: 1px solid #099BDA;" class="TextoNegro">
 						<%= Contenido.precioToString(total) %>
					</td>
                </tr>
				</table>
			</td>
		</tr>

		<tr>
			<td>
				<table align="center" cellspacing="5">
				<tr>
					<td align="right" width="600">
						<%	if (total >= 100) {
						%>
								<form name="gestionComsicion" action="/GestionarComision">
									<input type="hidden" name="<%= AlianzaHelper.ID_ALIANZA%>" value="<%= idAlianza %>">
									<input type="image" src="/imagenes/extranet/botonGestionar.gif" value="Gestionar comision">
								</form>
						<%	}
						%>
					</td>

					<td align="right">
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
