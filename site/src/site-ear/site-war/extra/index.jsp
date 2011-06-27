<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals,
				com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>

<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_EXTRA));
	String seccionEXtra = Convert.toString(request.getParameter("seccionEXtra"), "5");
%>

<% if (seccionEXtra.equals("1")) { %>
	<tiles:insert definition="seccion.extra.inicio"/>
<%} %>

<% if (seccionEXtra.equals("2")) { %>
	<tiles:insert definition="seccion.extra.beneficios"/>
<%} %>

<% if (seccionEXtra.equals("3")) { %>
	<tiles:insert definition="seccion.extra.catalogo" />
<%} %>

<% if (seccionEXtra.equals("5")) { %>
	<tiles:insert definition="seccion.extra.puntos"/>
<%} %>

<% if (seccionEXtra.equals("6")) { %>
	<tiles:insert definition="seccion.extra.preguntasFrecuentes"/>
<%} %>

<% if (seccionEXtra.equals("7")) { %>
	<tiles:insert definition="seccion.extra.reglamento"/>
<%} %>

<% if (seccionEXtra.equals("8")) { %>
	<tiles:insert definition="seccion.extra.actualizaTusDatos"/>
<%} %>



