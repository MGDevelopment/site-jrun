<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals" %>

<%-- 
                 //com.tmk.socio.SocioPK,
--%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title() %>
		<%= Globals.keywords(Globals.PAGINA_SITIO) %>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

		<table width="740" cellspacing="0" cellpadding="0" border="0">
  		<tr>
			<td width="740">
				<%@include file="/componentes/comunes/logo.jsp"%>
			</td>
		</tr>
		</table>

		<table bgcolor="#dce1e6" pad="#003366"  cellspacing="0" cellpadding="0" border="0" width="740">
  		<tr>
			<td colspan="2" bgcolor="#ffffff">
				<br>

				<table width="100%" cellspacing="0" cellpadding="0" border="0">
				<tr valign="bottom" align="center" height="17">
					<td></td>
				</tr>

				<tr>
					<td bgcolor="#C20200" colspan="6" height="5"></td>
				</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="2" align="right">
				<br><br>&nbsp;
			</td>
		</tr>

		<tr valign="top" bgcolor="#DEE3E7">
			<%	if (tieneCostado) {
			%>
					<td width="122" style="background: url('/imagenes/sombraesquina.gif') no-repeat right; "></td>
					<td height="8" style="background: url('/imagenes/sombrasuperior.gif')"></td>
			<%	} else {
			%>
					<td height="8" aling="right" width="100%" style="background: url('/imagenes/sombrasuperior.gif')"></td>
			<%	}
			%>
		</tr>
		</table>

