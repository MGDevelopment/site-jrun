<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	request.setAttribute("idSeccion",Globals.SECCION_HOME);
%>

<tiles:insert definition="seccion.mantenimiento"/>
