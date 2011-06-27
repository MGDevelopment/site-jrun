<%@ page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@ taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>

<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion",new Integer(Globals.SECCION_EXTRA));
%>

<tiles:insert definition="seccion.extra.proceso.fin"/>
