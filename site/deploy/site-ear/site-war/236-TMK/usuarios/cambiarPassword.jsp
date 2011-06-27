<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.usuario.UsuarioHelper,
                 com.tmk.kernel.Globals" %>


<script type="text/javascript" src="/js/Validation.js"></script>
<script>
function cambiarPassword()
{
	var form = document.formCambiarPassword;

	if (isEmpty(form.<%=UsuarioHelper.LOGIN%>.value)) {
		alert('Debe ingresar el Usuario');
		form.<%=UsuarioHelper.LOGIN%>.focus();
		return;
	}

	if (isEmpty(form.<%=UsuarioHelper.PASSWORD%>.value)) {
		alert('Debe ingresar la contraseña');
		form.<%=UsuarioHelper.PASSWORD%>.focus();
		return;
	}
	if (isEmpty(form.confirmacionPassword.value)) {
		alert('Debe confirmar su contraseña');
		form.confirmacionPassword.focus()
		return;
	}

	if( (form.<%=UsuarioHelper.PASSWORD%>.value) != (form.confirmacionPassword.value)){
		alert('La clave y su confirmacion deben ser iguales');
		return;
	}

form.submit();
}
</script>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración") %>
	</head>
<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table width="100%" height="100%">
	<tr>
		<td valign="top">
		<form name="formCambiarPassword" action="/CambiarPassword" method="post">
		<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"  width="770" height="100%">
			<tr>
				<td>
					<table width="100%" align="center" cellpadding="0" cellspacing="0">
						<tr bgcolor="#DEDBDE">
							<td align="right"><jsp:include page="/236-TMK/comunes/header.jsp"/></td>
						</tr>
					</table>
			<tr bgcolor="#FFFFFF" align="center">
				<td height="100%">
					<table width="330" height="154" border="0" background="/imagenes/intranet/cuadrado.jpg" bgcolor="#FFFFFF">
						<tr valign="bottom">
							<td width="93" height="34" align="right"> <b>Usuario: </b> </td>
							<td width="217"><input type="text" name="<%=UsuarioHelper.LOGIN %>"></td>
							<td width="6"></td>
						</tr>
						<tr>
							<td align="right">
								<b>Contraseña: </b>
							</td>
							<td><input type="password" name="<%=UsuarioHelper.PASSWORD%>"></td>
							<td></td>
						</tr>
						<tr>
							<td align="right">
								<b>Confirme Contraseña: </b>
							</td>
							<td><input type="password" name="confirmacionPassword"></td>
							<td></td>
						</tr>
						<tr>
							<td align="right"></td>
							<td>
								<table width="142">
									<tr valign="top">
										<td height="38" align="center" valign="top"> <a href="javascript:cambiarPassword();">
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
		</form>
	</td>
</tr>
</table>
</body>
</html>