<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.Site,
                 com.tmk.kernel.site.Ranking,
				 com.tmk.kernel.site.RankingSeccion,
 				 com.tmk.kernel.site.RankingGrupo"%>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
    if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("GENERAR_CONTENIDOS_ESTATICOS"))) {%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}%>

<html>
	<head>
	<%= Globals.estiloBasico() %>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
	<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" height="100%" width="770" >
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>
		</tr>
	</table>
</body>