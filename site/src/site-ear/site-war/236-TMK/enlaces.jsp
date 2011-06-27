<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>

<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>

<html>
<head>
	<base target="cuerpo">
	<style type="text/css">

	td
	{
		font-famly: tahoma;
		font-size: 15px;
	}

	a
	{
		color: black;
	}

	a.Salir
	{
		font-weight: bold;
		color: black;
	}

	</style>
</head>
<body topmargin="0" leftmargin="0" marginwidth="0" marginheight="0">
	<script type="text/javascript">

	function salirAdministracion()
	{
		if(confirm('¿ Seguro desea salir de la administracion ?'))
		{
			parent.location = '/236-TMK/index.jsp';
		}
	}

	</script>

<table width="100%">
<tr>
	<td>
	<img src="/imagenes/<%= Contenido.getLogo() %>">
	</td>
	<td>
	<table width="100%">

	<tr align="center">

		<%if (usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {%>
			<td><a href="/236-TMK/alianzas/index.jsp">Alianzas</a></td>
        <%}%>
		<%if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")) {%>
			<td><a href="/236-TMK/contenido/index.jsp">Contenido</a></td>
        <%}%>
		<%if (usuarioDAO.tieneAlgunAcceso("EVENTOS")) {%>
			<td><a href="/236-TMK/eventos/index.jsp">Eventos</a></td>
        <%}%>
		<%if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
			<td><a href="/236-TMK/ordenes/index.jsp">Ordenes</a></td>
        <%}%>
		<td><a href="/236-TMK/ayuda/intranet_ayuda.htm">Ayuda</a></td>
		<td><a target="enlaces" href="javascript:salirAdministracion();" class="Salir">Salir</a></td>

	</tr>

	</table>
	</td>
</tr>
</table>

</body>
</html>