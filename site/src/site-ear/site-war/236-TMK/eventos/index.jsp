<%@ page import="com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.common.SucursalLocalHome,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Eventos,
                 com.tmk.kernel.site.Evento,
                 com.tmk.kernel.Globals" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);

	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("EVENTOS")) {
%>
 		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

<html>
	<head>
	<%= Globals.estiloBasico() %>

		<style>
		.titulos{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			font-weight: bold;
		}

		.contenido{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			text-decoration: none;
			color: #000000;
		}

		</style>
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

				<font style="font-size: 18px; color:#003366">&nbsp;&nbsp;Listado de eventos</font><br>
				<br>
				<table width="761" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
					<tr class="titulos" >
						<td bgcolor="#59B3D9" align="center"  height="20">Descripción</td>
						<td bgcolor="#59B3D9"align="center">Fecha</td>
						<td bgcolor="#59B3D9" align="center">Sucursal</td>
						<td bgcolor="#59B3D9" align="center">Activo</td>
						<td bgcolor="#59B3D9" align="center"></td>
						<td bgcolor="#59B3D9" align="center"></td>
					</tr>
				<%
					SucursalLocalHome sucursalHome = (SucursalLocalHome)DBUtil.getHome("Sucursal");
					Eventos eventos = Contenido.getSite().getEventos();
					for (int index = 0; index < eventos.getEventoCount(); index++) {
						Evento evento = eventos.getEvento(index);
				%>
					<tr>
						<td style="border-right: 1px solid #59B3D9;" class="contenido">
                            <%if (!evento.getActivo()) {%><strike><%}%>
							<%= evento.getDescripcion() %>
                            <%if (!evento.getActivo()) {%></strike><%}%>
						</td>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><%= Convert.toStringLargo(evento.getFecha()) %></td>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido">
							<%= (evento.hasSucursal())
					            ? Convert.capitalizar(sucursalHome.findByPrimaryKey(new Integer(evento.getSucursal())).getDESCRIPCION(), true)
					            : "No especificada" %>
						</td>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"> <%= Convert.toString(evento.getActivo()) %></td>
						<td align="center" style="border-right: 1px solid #59B3D9;">
							<a href="/236-TMK/eventos/modificarEvento.jsp?ID_EVENTO=<%= index %>">Modificar</a>
						</td>
						<td align="center" style="border-right: 1px solid #59B3D9;" >
							<a href="/EliminarEvento?ID_EVENTO=<%= index %>">Eliminar</a>
						</td>
					</tr>
				<%}%>
				</table>
				<table width="788">
				  <tr>
					<td width="780">
						<br><br>
						<div align="right">
						<a href="/AgregarEvento"><img src="/imagenes/boton_Agregar_Evento.gif" border="0"></a>
						<a href="/236-TMK/eventos/"><img src="/imagenes/botonVolver.gif" border="0"></a>
						</div>
					</td>
				  </tr>
				</table>
			</td>
		</tr>
	</table>
</body>
