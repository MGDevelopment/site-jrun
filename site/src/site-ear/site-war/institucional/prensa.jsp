<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>

<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	request.setAttribute("page", request.getParameter("page"));
%>
<tiles:insert definition="tiles.institucional"/>