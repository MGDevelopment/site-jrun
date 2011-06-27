<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_PELICULA));
	request.setAttribute("mostrarTodos",new Integer(1));
	//request.setAttribute("requiereMesa", "true");
%>

<%--<tiles:insert definition="seccion.general.seccion"/>--%>
<tiles:insert definition="seccion.general.peliculas"/>