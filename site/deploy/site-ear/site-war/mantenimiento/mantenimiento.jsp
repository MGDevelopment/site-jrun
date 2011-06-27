<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<tiles:insert attribute="metaTag"/>
	<tiles:insert attribute="estilos"/>
</head>
<body>
	<center>
	<!-- **** INICIO DEL CONTENIDO DEL SITIO **** -->
	<div class="lienzo">

		<!-- **** BODY -->
			<!-- **** BARRA CENTRAL **** -->
				<div class="barraCentral" id="barraCentral">
					<tiles:insert attribute="body"/>
				</div>
	</div>
	<!-- **** FIN DEL CONTENIDO DEL SITIO **** -->
	</center>
</body>
</html>
