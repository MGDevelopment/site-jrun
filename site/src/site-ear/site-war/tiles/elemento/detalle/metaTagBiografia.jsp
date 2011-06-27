<%@page import="com.tmk.kernel.Globals, com.tmk.bus.articulo.ArticuloClass"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="request" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="articulo" scope="page" ignore="true" classname="com.tmk.bus.articulo.ArticuloClass"/>
<%
String tagPage ="";
if (Globals.esModoRelease()) {
	tagPage = "/contenidosEstaticos/articulos/" + ((int)Math.floor(articulo.getIdArticulo()/1000) * 1000) + "/tagBio" + articulo.getIdArticulo() + ".html";
} else {
	tagPage = "/articulo/componentes/tag.jsp?idArticulo=" + articulo.getIdArticulo() + "&textoSeccion=Biografia";
}%>
<jsp:include page="<%=tagPage%>"/>

<%
String ajaxPage = "/articulo/componentes/funcionesAjax.jsp?idSeccion=" + articulo.getIdSeccion() + "&precio=" + articulo.getPrecio();
%>
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/prototype-1.6.0.3.js" type="text/javascript"></script>
<jsp:include page="<%=ajaxPage%>"/>