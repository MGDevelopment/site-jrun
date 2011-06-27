<%@page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
MainHelper.controlDeModo(request, response);
request.setAttribute("idSeccion", new Integer(Globals.SECCION_EXTRA));
%>

<tiles:insert definition="seccion.extra.beneficios"/>