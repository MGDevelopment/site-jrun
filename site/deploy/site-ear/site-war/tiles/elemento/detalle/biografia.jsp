<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="request" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="articulo" scope="page" ignore="true" classname="com.tmk.bus.articulo.ArticuloClass"/>
<tiles:useAttribute name="idAutor" scope="request" ignore="true" classname="java.lang.Integer"/>
<%  String detallePage ="";
	if (Globals.esModoRelease()) {
		detallePage  = "/contenidosEstaticos/articulos/" + ((int)Math.floor(articulo.getIdArticulo()/1000) * 1000) + "/biografia" + articulo.getIdArticulo() + ".html";
	} else {
		detallePage  = "/articulo/componentes/biografia.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion() + "&idAutor=" + idAutor;
	}
%>
<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
<jsp:include page="<%=detallePage%>"/>
</table>
<script language="javascript">

	var tablas = document.getElementsByTagName('table').length;
	for (i=0; i<tablas; i++) {
		if (document.getElementsByTagName('table')[i].className == 'Gfooter') {
			document.getElementsByTagName('table')[i].style.display = 'none';
			break;
		}
	}
	var div = document.getElementsByTagName('div').length;
	for (i=0; i<div; i++) {
		if (document.getElementsByTagName('div')[i].className == 'Gfooter3') {
			document.getElementsByTagName('div')[i].style.display = 'none';
			break;
		}
	}
</script>
