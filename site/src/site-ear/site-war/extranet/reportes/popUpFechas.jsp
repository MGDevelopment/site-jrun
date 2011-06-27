<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper,
				 com.tmk.controllers.extranet.reporte.ReporteHelper,
				 java.util.Date"%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Seleccion de Fechas") %>
		<style type="text/css">
			.TextoCampo
			{
				font-size: 13px;
			}
		</style>

		<script type="text/javascript" src="/js/Validation.js">
		</script>

		<script type="text/javascript">
			function inicio() {
				document.fechasReporte.<%= ReporteHelper.FECHA_DESDE %>.focus();
			}

			function cerrar() {
				window.close();
			}

			function continuar() {
				if (!isEmpty(document.fechasReporte.<%= ReporteHelper.FECHA_DESDE %>.value) &&
					isDate(document.fechasReporte.<%= ReporteHelper.FECHA_DESDE %>)) {
					if (!isEmpty(document.fechasReporte.<%= ReporteHelper.FECHA_HASTA %>.value) &&
						isDate(document.fechasReporte.<%= ReporteHelper.FECHA_HASTA %>)) {

						window.opener.location= "/EjecutarReporte?" +
						"<%= ReporteHelper.TIPO_REPORTE %>=<%= Convert.toNumber(request.getParameter(ReporteHelper.TIPO_REPORTE), ReporteHelper.REPORTE_VISITAS) %>" +
						"&" +
						"<%= ReporteHelper.FECHA_DESDE %>=" +  document.fechasReporte.<%= ReporteHelper.FECHA_DESDE %>.value +
						"&" +
						"<%= ReporteHelper.FECHA_HASTA %>=" +  document.fechasReporte.<%= ReporteHelper.FECHA_HASTA %>.value;

						window.close();
					} else {
						window.alert("Debe indicar una fecha de fin valida para el reporte");
						return;
					}
				} else {
					window.alert("Debe indicar una fecha de inicio valida para el reporte");
					return;
				}
			}
		</script>

		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" onLoad="inicio()">
		<form name="fechasReporte" onSubmit="continuar()">
			<table align="center">
			<tr>
				<td valign="center">
					<br>

					<table width="286" height="150" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border: 1px solid #59B3D9;">
					<tr bgcolor="#59B3D9" align="center" class="TextoNegro">
						<td>
							Ingrese las fechas para el reporte
						</td>
					</tr>

					<tr>
						<td>
							<table width="200" align="center">
							<tr>
								<td class="TextoCampo">
									Fecha desde:
								</td>

								<td>
									<input type="text" name="<%= ReporteHelper.FECHA_DESDE %>" class="TextoCampo" maxlength="10" size="10" value="<%= Convert.toString(new Date(System.currentTimeMillis())) %>">
								</td>
							</tr>

							<tr>
								<td class="TextoCampo">
									Fecha hasta:
								</td>

								<td>
									<input type="text" name="<%= ReporteHelper.FECHA_HASTA %>" class="TextoCampo" maxlength="10" size="10" value="<%= Convert.toString(new Date(System.currentTimeMillis())) %>">
								</td>
							</tr>
							</table>
						</td>
					<tr>
					</table>

					<br>
					<table width="286" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right">
							<a href="javascript:continuar();">
								<img src="/imagenes/botonContinuar.gif" border="0">
							</a>

							<a href="javascript:cerrar();">
								<img src="/imagenes/botonVolver.gif" border="0">
							</a>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
		</form>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>