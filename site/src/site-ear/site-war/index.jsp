<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals"%>
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.copyright() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title(Globals.NOMBRE_DEL_SITIO) %>
		<%= Globals.keywords(Globals.NOMBRE_DEL_SITIO) %>
	</head>
	    <jsp:forward page="/inicio/index.jsp" />
</html>