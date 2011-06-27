<%@ page import="com.tmk.kernel.Globals"%>

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
					Seleccione alguna de las opciones
				</font>
			</td>
		</tr>

		<tr>
			<td align="center" valign="top">
				<table>
				<tr>
					<td>
						<br><br><br>
						<img src="/imagenes/extranet/vineta.gif"> <a href="/extranet/afiliados/modificarDatos.jsp" class="EnlaceNegro">Modificar Datos</a><br>
						<br>
						<img src="/imagenes/extranet/vineta.gif"> <a href="/extranet/afiliados/verSecciones.jsp" class="EnlaceNegro">Secciones</a><br>
						<br>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>
