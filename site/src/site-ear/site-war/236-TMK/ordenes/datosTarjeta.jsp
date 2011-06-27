<%@ page import="com.tmk.kernel.Convert,
				 com.tmk.kernel.DBUtil,
				 com.tmk.controllers.intranet.ordenes.OrdenesHelper,
				 com.tmk.service.orden.OrdenService,
				 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.Globals" %>

<%	int idOrden = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_), 0);
    OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Datos de la tarjeta de la orden " + idOrden) %>
		<script type="text/javascript">
			function volver() {
				window.close();
			}
		</script>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="400" align="center">
		<tr>
			<td>
				<table align="center">
				<tr>
					<td height="33" colspan="5">
						<br><br><br>
						<hr color="#59B3D9" size="1" width="350">
					</td>
				</tr>
				</table>

				<table width="250">
				<tr>
					<td>
						<font color="#990000" style="font-size: 12px;">
							<b>Datos de la tarjeta</b>
							<br><br><br>
						</font>
					</td>
    			</tr>
				</table>

				<table class="textoClasico" style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="300" border="1" align="center" cellspacing="0" cellpadding="5">
				<tr>
					<td>
						<b>Fecha:<b>
					</td>

					<td>
						<%= Convert.toString(ordenDAO.getFechaDeCierre()) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Nro. de tarjeta:<b>
					</td>

					<td>
						<%= Convert.toString(ordenDAO.get_NumeroTarjetaCompletoDesencriptado()) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Nro. de orden:<b>
					</td>

					<td>
						<%= Convert.toString(idOrden) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Titular:<b>
					</td>

					<td>
						<%= Convert.toString(ordenDAO.getNombreCliente()) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Documento:<b>
					</td>

					<td>
						<%= ordenDAO.getTipoDocumento() %> - <%= Convert.toString(ordenDAO.getNumeroDocumento()) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Direccion:<b>
					</td>

					<td>
						<%= Convert.toString(ordenDAO.getDomicilioResumen()) %>
					</td>
				</tr>
				</table>

				<table align="right">
				<tr>
					<td align="right">
						<br><br><br>
						<a href="javascript:volver()">
							<img src="/imagenes/botonVolver.gif" border="0">
						</a>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</body>
</html>
