<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(request.getParameter("idSeccion")));
	//request.setAttribute("requiereLogo", new String("true"));
%>
<tiles:insert definition="seccion.general.buscador.avanzado"/>