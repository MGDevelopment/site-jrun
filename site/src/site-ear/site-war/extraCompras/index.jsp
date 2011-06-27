<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals" %>

<% SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>

        <meta name="robots" content="noindex, nofollow">
        <meta name="GOOGLEBOT" content="noindex, nofollow">

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

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
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
				<td style="background:  url(/imagenes/sombraesquina.gif) no-repeat right; ">
				</td>

				<td width="750" height="8" style="background:  url(/imagenes/sombrasuperior.gif)">
				</td>
			</tr>

			<tr valign="top" bgcolor="#ffffff">
				<td width="1">&nbsp;</td>
				<td valing="middle">
					<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0">
					  <tr>
						<td><img src="/imagenes/cabecera-eXtraCompras.gif" width="760" height="120"></td>
					  </tr>


					  <tr>
						<td><table  width="760" border="0"  cellspacing="2" cellpadding="0">
							<tr>
							  <td bgcolor="#FFE6C3">&nbsp;</td>
							</tr>
						  </table></td>
					  </tr>
					</table>

				</td>
			</tr>
		</table>

	</body>
</html>
