
<%@page import="com.tmk.kernel.TmkLogger"%><%@page import="java.io.IOException"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>
<%-- agregado para los modales de las listas  --%>
	<link href="/estilos/listasTmk.css" rel="stylesheet" type="text/css"/>

<%
	Integer idArticulo = (Integer)request.getAttribute("idArticulo");
	String tagPage = "";
	if (Globals.esModoRelease()) {		
		tagPage = "/contenidosEstaticos/articulos/" + ((int)Math.floor(idArticulo.intValue()/1000) * 1000) + "/tagDetalle" + idArticulo.intValue() + ".html";		
	} else {
		tagPage = new String("/articulo/componentes/tag.jsp?idArticulo=" + idArticulo.intValue());
	}
	try {
		pageContext.include(tagPage);
	}catch(IOException io){
		tagPage = new String("/articulo/componentes/tag.jsp?idArticulo=" + idArticulo.intValue());
		pageContext.include(tagPage);
	}
%>