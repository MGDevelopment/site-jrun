<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.tmk.kernel.Globals"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<tiles:insert attribute="metaTag"/>
	<tiles:insert attribute="estilos"/>
	<tiles:insert attribute="js"/>
</head>
<body>	
<center>
	<!-- **** INICIO DEL CONTENIDO DEL SITIO **** -->
		<div class="lienzo">	
			<!-- **** HEADER **** -->	
			<tiles:insert attribute="header"/>	
			<!-- **** BODY -->	
			<!-- **** BARRA CENTRAL **** -->	
			<div class="barraCentral" id="barraCentral">	
				<tiles:insert attribute="body"/>
			</div>	
			<!-- **** FIN BARRA CENTRAL **** -->
			<!-- **** FOOTER **** -->
			<div class="footer">	
				<tiles:insert attribute="footer"/>	
			</div>
		</div>
<!-- **** FIN DEL CONTENIDO DEL SITIO **** -->
</center>
<%=Globals.getGoogleAnalytics()%>
</body><div id="divCarrito" class="efectoCarritoMod" style="display:none">
<div class="efectoCarritoTxt">
<span class="txtMsgCarritoOK" id="msgCarritoOK">
</span><span  id="msgCarritoERROR" style="font-size:12;color:red">
</span><br />
<span id="spnPrecioCarrito" class="txtPrecioCarrito">PRECIO: $ <span  class="txtPrecioCarrito" id="precioCarrito"></span>.-</span>
</div>
<div class="efectoCarritoImages">
<img id="carritoImagen"  class="efectoCarritoImag">
</div><div id="efectoCarritoB">
<a href="javascript:carrito_CloseCarrito()">
<img src="/imagenes/b-carrContinuar.gif" alt="Continuar" border="0">
</a>
</div>
</div>
<div id="modalBack" style="display:none">
</div>
</html>