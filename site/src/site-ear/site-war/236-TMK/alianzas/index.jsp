<%@ page import="com.tmk.admin.AlianzaLocalHome,
                 com.tmk.kernel.DBUtil,
                 com.tmk.admin.AlianzaLocal,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.Globals" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {
%>
 		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración de Alianzas") %>

	<script type="text/javascript">

	function borrarAlianza(ID_ALIANZA, RAZON_SOCIAL)
	{
		if(confirm('¿ Seguro desea eliminar la alianza "'+RAZON_SOCIAL+'" ?'))
		{
			document.location = '/EliminarAlianza?ID_ALIANZA='+ID_ALIANZA+"&RAZON_SOCIAL="+RAZON_SOCIAL;
		}
	}

	function modificarAlianza(ID_ALIANZA)
	{
		document.location = '/236-TMK/alianzas/modificarAlianza.jsp?ID_ALIANZA='+ID_ALIANZA;
	}

	function verSecciones(ID_ALIANZA)
	{
		document.location = '/236-TMK/alianzas/verSecciones.jsp?ID_ALIANZA='+ID_ALIANZA;
	}

	</script>

<style>

.items{
font-family: Verdana, Arial, Helvetica, sans-serif;
color:#003366 ;
font-size=18"
}


</style>
</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"  width="770" height="100%">
	<tr>
		<td valign="top">
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#DEDBDE">
					<td align="right"><jsp:include page="/236-TMK/comunes/header.jsp"/></td>
				</tr>
			</table>


			<%
				String feedback = (String)session.getAttribute("Alianzas.feedback");
				if(feedback != null)
				{
					session.removeAttribute("Alianzas.feedback");

					%>
					<div align="center" style="font-color: red; font-family: Verdana;">
					<%= feedback %>
					</div>
					<%
				}
			%>

			<table width="80%" cellspacing="0" cellpadding="3" align="center">
				<tr align="center">

				<td height="75" colspan="2" class="items">Seleccione alguna de las opciones</td>
				</tr>
				<tr>
					<td width="44%" align="right"><img src="/imagenes/clickTrans.gif"></td>
					<td width="56%"><a href="agregarAlianza.jsp"><font style=" font-family: Verdana, Arial, Helvetica, sans-serif; text-decoration:none; font-weight: bold; color: #000000; font-size:12" >Alta</font></a></td>
				</tr>
				<tr>
					<td align="right"><img src="/imagenes/clickTrans.gif"></td>
					<td><a href="listarAlianzas.jsp " ><font style=" font-family: Verdana, Arial, Helvetica, sans-serif; text-decoration:none; font-weight: bold; color: #000000; font-size:12" >Modificaci&oacute;n - Baja</font></a></td>
				</tr>
				<tr>
					<td align="right"><img src="/imagenes/clickTrans.gif"></td>
					<td><a href="listarAlianzas.jsp " ><font style=" font-family: Verdana, Arial, Helvetica, sans-serif; text-decoration:none; font-weight: bold; color: #000000; font-size:12" >Secciones</font></a></td>
				</tr>
				<tr>
					<td height="200">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>