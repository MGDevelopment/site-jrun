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

	boolean gestionOK = Convert.toBoolean(request.getParameter(AlianzaHelper.GESTION_COMISION));
	int idLiquidacion = Convert.toNumber(request.getParameter(ReporteHelper.ID_LIQUIDACION), 0);
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Gestion de Comisiones") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table bgcolor="#FFFFFF" align="center" width="770" cellpadding="0" cellspacing="0" height="100%" border="0">
		<tr>
			<td align="center" valign="top" height="20%">
				<table align="center" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<jsp:include page="/extranet/comunes/header.jsp"/>
							<jsp:include page="/extranet/comunes/solapas.jsp"/>
						</td>
					</tr>
				</table>
				<br><br>
			</td>
		</tr>

		<tr>
			<td align="center" valign="top">
				<font class="TextoBordo">
					<%	if (gestionOK && (idLiquidacion != 0)) {
					%>
						   	Su comision se ha gestionado correctamente bajo el numero <%= idLiquidacion %>
							<br>
							Ante cualquier duda comuniquese con nosotros mencionando este numero.
					<%	} else {
					%>
							Ha ocurrido un error al gestionar su comision.
							<br>
							Contactese con nosotros, por favor.
					<%	}
					%>
				</font>
				<br><br>
				<font class="TextoNegro">
                	Muchas gracias.
				</font>
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