<%@ page
	import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.comentario.ComentarioHelper,
				 com.tmk.common.ComentarioClass"%>
<%
       ComentarioClass comentarios[] = ComentarioClass.getComentariosPorEstado(ComentarioHelper.PENDIENTE);

%>
<html>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR"))) {
%>
<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>" />
<%	}
%>

<head>
<%= Globals.icon() %>
<%= Globals.charset() %>
<%= Globals.estiloBasico() %>
<%= Globals.title("Lista de Comentarios") %>
<script type="text/javascript" src="/js/prototype-1.6.0.3.js"></script>
<style type="text/css" rel="stylesheet">
font.TituloBordo {
	color: #990000;
	font-size: 14px;
	font-family: verdana;
	text-transform: uppercase;
	font-weight: bold;
	text-align: center;
}

font.TextoBordo {
	color: #990000;
	font-size: 12px;
	font-family: verdana;
	text-transform: uppercase;
	font-weight: bold;
	text-align: center;
}

a.EnlaceNegro {
	font-size: 11px;
	font-family: verdana;
	color: #000000;
	text-decoration: none;
}

table.BordeFino {
	border-collapse: collapse;
	border: 2px solid;
	border-color: #5AB5DE;
}
</style>
	<script type="text/javascript" language="javascript" src="_236TMK.comentario.aprobarComentario_jsp/_236TMK.comentario.aprobarComentario_jsp.nocache.js"></script>
</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0"	topmargin="0" marginwidth="0" marginheight="0">

<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0"
	width="770" height="100%">
	<tr>
		<td valign="top">
		<table cellpadding="0" cellspacing="0" width="770">
			<tr>
				<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td><jsp:include page="/236-TMK/comunes/header.jsp" /></td>
					</tr>
				</table>
				<br>
				<table style="align: center;">
					<tr>
						<td>
						<div id="divRoot">
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>
