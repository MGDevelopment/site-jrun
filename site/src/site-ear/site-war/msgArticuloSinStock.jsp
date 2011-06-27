<%@ page import="com.tmk.setup.Contenido,
com.tmk.kernel.Globals"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Página de Error") %>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table width="780" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td>
				<%@include file="/componentes/comunes/logo.jsp"%>
			</td>
            <td width="350" align="right" valign="top">
				<jsp:include page="/componentes/comunes/carrito.jsp" />
			</td>
		</tr>
		</table>

		<table bgcolor="#99CCFF" pad="#003366" width="780" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td colspan="2" bgcolor="#ffffff">
				<jsp:include page="/componentes/comunes/solapas.jsp" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<br><br>&nbsp;
			</td>
		</tr>
		<tr>
			<td valign="top" width="100%" bgcolor="#ffffff">
			<table cellspacing="2" cellpadding="5" border="0" width="100%">
			<tr><td>

			<center>
			<b>Actualmente no poseemos stock del producto seleccionado.</b>
			</center>
			<p>
			<center>
			<a href="/index.jsp">
				<img src="/imagenes/botonContinuar.gif" border="0">
			</a>
			</center>
			</td></tr>
			</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalytics()%>		
	</body>
</html>

