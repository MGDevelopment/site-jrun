<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_GENERAL));
	//request.setAttribute("detalle", new String("detalle"));
%>
<tiles:insert definition="seccion.general.comentario.confirmado"/>