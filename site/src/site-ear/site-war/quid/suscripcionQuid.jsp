<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	//request.setAttribute("idSeccion", new Integer(Globals.SECCION_GENERAL));
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_QUID));
%>
<tiles:insert definition="seccion.quid.suscripcion"/>