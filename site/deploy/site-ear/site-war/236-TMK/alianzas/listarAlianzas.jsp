<%@ page import="com.tmk.admin.AlianzaLocalHome,
                 com.tmk.kernel.DBUtil,
                 com.tmk.admin.AlianzaLocal,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals" %>

<style type="text/css">
	.columnaProducto
	{
		border-right: 1px solid #D9D9D9;
		border-left: 1px solid #D9D9D9;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		color:#000000 ;
		font-size=12"
		font-decoration:none;
	}
</style>


<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>


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
</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770">
	<tr>
		<td>
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<jsp:include page="/236-TMK/comunes/header.jsp"/>
					</td>
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
            <br>
			<font style="font-size: 17 px; color:#003366 ;font-family: Verdana, Arial, Helvetica, sans-serif">Listado de alianzas</font><br><br>
			<table width="100%" style="border: 1px solid gray;" cellspacing="0" cellpadding="3">
			<tr align="center" bgcolor="#D9D9D9">
                <td class="columnaProducto"><b>Id Alianza</b></td>
				<td class="columnaProducto"><b>Razon Social</b></td>
				<td class="columnaProducto"><b>Nombre de Contacto</b></td>
				<td class="columnaProducto"><b>e-Mail</b></td>
				<td class="columnaProducto"><b>URL</b></td>
				<td class="columnaProducto"><b>Opciones</b></td>
			</tr>
			<%
				AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
				Iterator alianzas = alianzaHome.findAll().iterator();
				while(alianzas.hasNext())
				{
					AlianzaLocal alianza = (AlianzaLocal)alianzas.next();
					%>
					<tr>
						<td align="right" class="columnaProducto"><%= Convert.toString(alianza.getID_ALIANZA(),"&nbsp;")%></td>
						<td align="left" class="columnaProducto"><%= Convert.toString(alianza.getRAZON_SOCIAL(),"&nbsp;") %></td>
						<td align="left" class="columnaProducto"><%= Convert.toString(alianza.getNOMBRE_CONTACTO(),"&nbsp;") %></td>
						<td align="left" class="columnaProducto"><%= Convert.toString(alianza.getE_MAIL_1(),"&nbsp;") %></td>
						<td align="left" class="columnaProducto"><%= Convert.toString(alianza.getURL(),"&nbsp;") %></td>
						<td align="center" class="columnaProducto">
							<a href="javascript:verSecciones(<%= alianza.getID_ALIANZA() %>);"><font class="columnaProducto">Ver Secciones </font></a> |
							<%if (usuarioDAO.tieneAcceso("ALIANZAS", 'M')) {%>
							<a href="javascript:modificarAlianza(<%= alianza.getID_ALIANZA() %>);"><font class="columnaProducto">Modificar</font></a> |
							<%}%>
							<%if (usuarioDAO.tieneAcceso("ALIANZAS", 'B')) {%>
							<a href="javascript:borrarAlianza(<%= alianza.getID_ALIANZA() %>, '<%= alianza.getRAZON_SOCIAL() %>');"><font class="columnaProducto">Borrar</font></a>
							<%}%>
						</td>
					</tr>
					<%
				}
			%>
			</table>
		</td>
	</tr>
</table>
</body>
</html>