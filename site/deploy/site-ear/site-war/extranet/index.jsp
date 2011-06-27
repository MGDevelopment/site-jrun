<%@ page import="com.tmk.kernel.Globals" %>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Bienvenido a nuestra Extranet") %>
		<%= Globals.keywords("Extranet, Alianzas, Afiliados, Acuerdo, Administración, Ventas") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<script type="text/javascript" src="/js/Validation.js"></script>

	<body background="/imagenes/intranet/fondo.gif" onLoad="document.frm.USUARIO.focus()" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table width="770" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
		<tr align="center">
			<td valign="top">
				<table width="770" align="center" cellspacing="0" cellpadding="0" border="0">
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

		<table width="770" height="80%" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0" >
		<%	String feedback = (String)session.getAttribute("Extranet.feedback");
			if(feedback != null) {
				session.removeAttribute("Extranet.feedback");
		%>
				<tr>
					<td align="center" valign="middle">
						<font color="red">
 							<b><%= feedback %></b>
						</font>
						<hr size="1">
					</td>
				</tr>
		<%	}
		%>

		<tr valign="middle" align="center">
			<td>
				<form action="/IngresarExtranet" method="post" name="frm">
					<table width="330" height="163" border="0" background="/imagenes/intranet/cuadrado.jpg" bgcolor="#FFFFFF">
        			<tr valign="bottom">
						<td width="258" align="right">
							<font class="TextoNegro">Usuario: </font>
							<input type="text" name="USUARIO" onKeyPress="cambiarFoco(event,'document.frm.CLAVE');">
						</td>
						<td width="62"></td>
					</tr>

					<tr>
						<td align="right">
							<font class="TextoNegro">Contraseña: </font>
							<input type="password" name="CLAVE" onKeyPress="enviar(event, 'document.frm.submit();');">
						</td>
						<td></td>
					</tr>

					<tr>
						<td align="right">
							<table width="142">
								<tr valign="top">
									<td height="38" align="center" valign="top">
										<a href="javascript:document.frm.submit();">
											<img src="/imagenes/botonContinuar.gif" border="0">
										</a>
									</td>
								</tr>
							</table>
						</td>
						<td></td>
					</tr>
					</table>
				</form>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>