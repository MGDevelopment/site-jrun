<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.kernel.EstadoOrdenDAO"%>
<%@page import="com.tmk.orden.PagoOrdenLocalHome"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.orden.PagoOrdenLocal"%>
<%@page import="com.tmk.kernel.MedioDeCobroDAO"%>
<html>
<%
String idOrden = request.getParameter("idOrden");
%>
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
						</table>
						<table>
							<tr>
								<td width="70">
								</td>
								<td>
									<br>
										<font color="#990000" style="font-size: 12px;">
											<b>Ordenes con cheque aplicado en la orden <%=idOrden%></b>
										</font>
								</td>
							</tr>
						</table>

						<table width="600" align="center">
							<tr>
								<td>
									<table width="100%" align="center" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;">
										<tr bgcolor="#59B3D9" align="center">
											<td>
												<b>Orden</b>
											</td>
											<td align="center" >
												<b>Medio de Pago</b>
											</td>
											<td align="center">
												<b>Fecha</b>
											</td>
											<td align="center">
												<b>Estado</b>
											</td>
										</tr>
										<%
										try {
											Connection conn = DBUtil.buildConnection();
											try {
												StringBuffer qry = new StringBuffer("SELECT id_orden, fecha, estado FROM orden WHERE cupon =( ");
												qry.append(" SELECT cupon FROM orden WHERE id_orden = ").append(idOrden);
												qry.append(" ) AND estado NOT IN ('11', '52', '21', '5', '51', '0')");
												qry.append(" AND id_orden <>").append(idOrden);
												qry.append(" ORDER BY fecha ");
												Statement st = conn.createStatement();
												try {
													ResultSet rs = st.executeQuery(qry.toString());
													try {
														while (rs.next()) {
%>
										<tr>
											<td width="50" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
											<font style="text-decoration: none; color: black;">
												<a href="javascript:detalleOrden(<%=rs.getInt("id_orden") %>)">
													<b><%=rs.getInt("id_orden") %></b>
												</a>
											</font>
											</td>
											<td style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
											<%
											PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
											Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(new Integer(idOrden)).iterator();
											PagoOrdenLocal pagoOrden = (PagoOrdenLocal) pagosOrden.next();
											MedioDeCobroDAO medioCobroDAO = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrden.getID_MEDIO_COBRO());
											out.println(medioCobroDAO.getNombre());
											%>
											</td>
											<td width="145" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
											<%=Convert.toStringLargo(rs.getTimestamp("fecha")) %>
											</td>
											<td width="180" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
											<%=EstadoOrdenDAO.buscaEstadoOrden(rs.getString("estado")).getNombre()  %>
											</td>
										</tr>
<%
														}
													} finally {
														rs.close();
													}
												} finally {
													st.close();
												}
											} finally {
												conn.close();
											}
										} catch (Exception e) {
											TmkLogger.error (e.toString());
										}
									%>



									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>

		</td>
	</tr>

</table>
</body>
</html>