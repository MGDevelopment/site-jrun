<%@page import="com.tmk.kernel.Globals"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%
	//request.setAttribute("idSeccion",Globals.SECCION_MICUENTA);
request.setAttribute("idSeccion",Globals.SECCION_HOME);
%>
<tiles:insert definition="seccion.popego"></tiles:insert>

