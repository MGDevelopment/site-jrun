<%@page import="com.tmk.kernel.Globals"%>
<html>
	<head>
		<META HTTP-EQUIV="Refresh" CONTENT="5; URL=/index.jsp">
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Tematika.com") %>
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

		<table width="770" border="0">
			<tr>
				<br>
				<br>
				<br>
				<td align="center"><H2><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Gracias por participar de la promoción en <%= Globals.NOMBRE_DEL_SITIO%>.</font></H2></td>
			</tr>
			<tr>
				<td align="center">

					<a href="/index.jsp">
						<img src="/imagenes/botonContinuar.gif" border="0">
					</a>
				</td>
			</tr>
		</table>
<%=Globals.getGoogleAnalytics()%>
	</body>
</html>
