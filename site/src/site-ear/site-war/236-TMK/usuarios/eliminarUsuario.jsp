<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.usuario.UsuarioHelper,
                 com.tmk.kernel.Globals" %>


<script type="text/javascript" src="/js/Validation.js"></script>
<script>

function Eliminar()
{
	form= document.formEliminarUsuario;
	form.action= "/EliminarUsuario?<%=UsuarioHelper.IDUSUARIO%>=" + form.cboApps.options[form.cboApps.selectedIndex].value;
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
	<form name="formEliminarUsuario" method="post">
<table width="100%" height="100%">
	<tr>
		<td valign="top">
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

						<table width="330" height="181" border="0" bgcolor="#EBEBEB">
							<tr>
								<td height="73" align="center"><b> Usuarios: </b><br>
									<select  name="cboApps" size="5" style="Width:200 px;">
									<%for (int i=0 ; i<5; i++){%>
										<option value="<%=i%>">Usuario <%=i%></option>
									<%}%>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									 <table width="142" align="right">
											<tr valign="top">
												<td height="38" align="center" valign="top"> <a href="javascript:Eliminar();">
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