<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.usuario.UsuarioHelper,
                 com.tmk.kernel.Globals" %>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración") %>
	</head>
<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<form name="frm" action="/AgregarUsuario" method="post">
<table width="100%" height="100%">
	<tr>
		<td>
			<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"  width="770" height="100%">
				<tr>
					<td>
						<table width="100%" align="center" cellpadding="0" cellspacing="0">
							<tr bgcolor="#DEDBDE">
								<td align="right"><jsp:include page="/236-TMK/comunes/header.jsp"/></td>
							</tr>
						</table>
						<br><br>
				<tr bgcolor="#FFFFFF" align="center">
					<td height="100%" valign="top" >
						<table width="368" height="237" border="0" bgcolor="#EBEBEB">
							<tr valign="bottom">
								<td width="136" height="34" align="right" valign="middle"> <b>Nombre: </b> </td>
								<td width="185" valign="middle"><input type="text" name="<%=UsuarioHelper.NOMBRE%>" size="35"></td>
								<td width="67"></td>
							</tr>
							<tr valign="bottom">
								<td width="136" height="34" align="right" valign="middle"> <b>Apellido: </b> </td>
								<td width="185" valign="middle"><input type="text" name="<%=UsuarioHelper.APELLIDO%>" size="35"></td>
								<td width="67"></td>
							</tr>
							<tr valign="bottom">
								<td  height="34" align="right"> <b>Usuario: </b> </td>
								<td width="185"><input type="text" name="<%=UsuarioHelper.LOGIN%>"></td>
								<td width="67"></td>
							</tr>
							<tr>
								<td height="35" align="right" valign="middle"> <b>Contraseña: </b> </td>
								<td valign="middle"><input type="password" name="<%=UsuarioHelper.PASSWORD%>"></td>
								<td></td>
							</tr>
							<tr>
								<td align="right" valign="middle">
									<b>Confirme <br> Contraseña: </b>
								</td>
								<td valign="middle"><input type="password" name="<%=UsuarioHelper.PASSWORD%>"></td>
								<td></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td>
									 <table width="142" align="right">
										<tr valign="top">
											<td height="38" align="center" valign="top"> <a href="javascript:document.frm.submit();">
												<img src="/imagenes/botonContinuar.gif" border="0"> </a>&nbsp;
											</td>
										</tr>
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
	</form>
</body>
</html>