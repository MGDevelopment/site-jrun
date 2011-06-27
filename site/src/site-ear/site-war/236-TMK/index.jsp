<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.usuario.UsuarioHelper,
                 com.tmk.kernel.Globals" %>

<%@include file="/componentes/comunes/controlDeModo.jsp"%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración") %>
	</head>
	<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" onLoad="frm.<%=UsuarioHelper.LOGIN%>.focus()">
<table width="100%" height="100%">
	<tr>
		<td>
		<form name="frm" action="/LoginIntranet" method="post">
			<table width="740" align="center" cellpadding="0" cellspacing="0" height="100%">
				<tr bgcolor="#DEDBDE">
					<td>
						<img src="/imagenes/intranet/logoTematika.png">
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<td height="100%">
						<table width="330" height="163" border="0" background="/imagenes/intranet/cuadrado.jpg" bgcolor="#FFFFFF">
        					<tr valign="bottom">
								<td width="258" align="right">
									<b>Usuario: </b><input type="text" name="<%=UsuarioHelper.LOGIN%>">
								</td>
								<td width="62"></td>
							</tr>
							<tr>
								<td align="right">
									<b>Contraseña: </b><input type="password" name="<%=UsuarioHelper.PASSWORD%>">
								</td>
								<td></td>
							</tr>
							<tr>
								<td align="right">
									<table width="142">
                    					<tr valign="top">
                      						<td height="38" align="center" valign="top"> <a href="javascript:document.frm.submit();">
                        						<img src="/imagenes/botonContinuar.gif" border="0"> </a>&nbsp;
                      						</td>
										</tr>
									</table>
								</td>
								<td></td>
							</tr>
						</table>
					</td>
				</tr>
		</table>
		</form>
				</td>
			</tr>
	</table>
	</body>
</html>