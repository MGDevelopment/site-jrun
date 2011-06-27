<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper,
				 com.tmk.controllers.extranet.reporte.ReporteHelper"%>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet") %>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">

		<script type="text/javascript">
			function abrirPopUp(tipoReporte) {
				window.open("/extranet/reportes/popUpFechas.jsp?<%= ReporteHelper.TIPO_REPORTE %>=" + tipoReporte, "popUpFechas",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=320, height=230");
			}
		</script>
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table width="770" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
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
			</td>
		</tr>
		</table>

		<table width="770" height="80%" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
		<tr>
			<td align="left">
				<font style= "font-size:12px" color="#003366">
					&nbsp;&nbsp;&nbsp;
					Seleccione alguno de los reportes
				</font>
			</td>
		</tr>

		<tr>
			<td align="center" valign="top">
				<table cellspacing="15">
				<tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="javascript:abrirPopUp(<%= ReporteHelper.REPORTE_VISITAS %>)" class="EnlaceNegro">
							Visitas por dia
						</a>
					</td>
				</tr>

				<tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="javascript:abrirPopUp(<%= ReporteHelper.REPORTE_VENTAS %>)" class="EnlaceNegro">
							Ranking de ventas
						</a>
					</td>
				</tr>

				<tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="javascript:abrirPopUp(<%= ReporteHelper.REPORTE_PRODUCTO %>)" class="EnlaceNegro">
							Ventas por producto
						</a>
					</td>
				</tr>

                <tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="javascript:abrirPopUp(<%= ReporteHelper.REPORTE_COBRADAS %>)" class="EnlaceNegro">
							Comisiones cobradas
						</a>
					</td>
				</tr>

				<tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="javascript:abrirPopUp(<%= ReporteHelper.REPORTE_LIQUIDADAS %>)" class="EnlaceNegro">
							Comisiones en proceso de liquidacion
						</a>
					</td>
				</tr>

				<tr>
					<td>
						<img src="/imagenes/extranet/vineta.gif">
						<a href="/EjecutarReporte?<%= ReporteHelper.TIPO_REPORTE %>=<%= ReporteHelper.REPORTE_LIQUIDABLES %>" class="EnlaceNegro">
							Comisiones liquidables
						</a>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>
