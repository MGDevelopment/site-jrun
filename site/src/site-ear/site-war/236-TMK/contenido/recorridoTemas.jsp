<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>


<%	int altoImagen = 88;
	int anchoImagen = 59;
	boolean tieneCostado = false;

	Producto producto;
	int indice;
	int componente = ContenidoHelper.RECOMENDADO;
%>

<%@ include file="/componentes/comunes/header.jsp" %>
	<style type="text/css" rel="stylesheet">
		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		table.BordeFino
		{
			border-collapse: collapse;
			border: 2px solid;
			border-color: #5AB5DE;
		}
	</style>

	<br><br>
	<table align="center">
	<tr>
		<td width="263"  valign="top">
		</td>

		<td width="32" valign="top">
			<img src="/imagenes/miCuenta/bienIsq.gif" width="32" height="52">
		</td>

		<td width="166" align="center" valign="middle">
			<!--img src="/imagenes/intranet/tituloRecorridoTemas.gif" -->
			recorrido x temas
		</td>

		<td width="34" valign="top">
			<img src="/imagenes/miCuenta/bienDer.gif" width="34" height="52">
		</td>

		<td width="262"  valign="top" height="50%">
		</td>
	</tr>

	<tr>
		<td height="33" colspan="5" align="center">
			<br>
			<hr color="#59B3D9" size="1" width="650">
		</td>
	</tr>
	</table>

	<br>
	<table cellspacing="0" cellpadding="0" align="center" width="650">
	<tr>
		<td>
			<font class="TextoBordo">
				Recorrido por temas
			</font>

			<br><br>

		</td>
	</tr>
	</table>



<%@ include file="/componentes/comunes/footer.jsp" %>