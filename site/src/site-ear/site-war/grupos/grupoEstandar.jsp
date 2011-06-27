<%@ page import="com.tmk.kernel.Convert, com.tmk.kernel.Globals"%>
<%
	String urlGrupo = request.getParameter(Contenido.URL_GRUPO);
	boolean tieneCostado = Convert.toBoolean(request.getParameter(Contenido.COSTADO_GRUPO), false);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Información Adicional") %>
		<style type="text/css" rel="stylesheet">
		td
		{
			font-family: verdana;
			font-size: 11px;
		}
		div.TextoNegro
		{
			font-size: 10px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}
		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}
		a.EnlaceNegro
		{
			font-size: 11px;
			font-family: verdana;
			color: #000000;
			text-decoration: none;
		}
		</style>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table width="770" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td width="390">
					<%@include file="/componentes/comunes/logo.jsp"%>
				</td>

				<td width="350" align="right" valign="top">
					<jsp:include page="/componentes/comunes/carrito.jsp" />
				</td>
			</tr>
		</table>

		<table bgcolor="#dce1e6" pad="#C20200" width="745" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td colspan="2" bgcolor="#ffffff">
				<jsp:include page="/componentes/comunes/solapas.jsp?modo=rojo" />
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center" height="33">
				<jsp:include page="/componentes/inicio/buscador.jsp" />
			</td>
		</tr>

		<tr>
			<td style="background: url('/imagenes/sombraesquina.gif')  no-repeat right; ">
			</td>

		<tr valign="top" bgcolor="#DEE3E7">
			<%	if (tieneCostado) {
			%>
					<td width="123" height="8" style="background: url('/imagenes/sombraesquina.gif') no-repeat right; ">
					</td>

					<td width="629" height="8" style="background: url('/imagenes/sombrasuperior.gif')">
					</td>
			<%	} else {
			%>
					<td width="750" height="8" style="background: url('/imagenes/sombrasuperior.gif')">
					</td>
			<%	}
			%>
		</tr>

		<tr valign="top" bgcolor="#ffffff">
			<td width="629" bgcolor="#ffffff" colspan="2">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="95%" height="300">
						<jsp:include page="<%= urlGrupo %>" />
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalytics()%>
	</body>
</html>
