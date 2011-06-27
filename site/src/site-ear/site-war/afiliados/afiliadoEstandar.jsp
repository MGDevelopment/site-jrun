<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>

<%
	request.setAttribute("idSeccion", Globals.SECCION_GENERAL);
%>

<tiles:insert definition="seccion.general.afiliado"/>
