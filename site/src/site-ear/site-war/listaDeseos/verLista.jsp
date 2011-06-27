<%@page import="com.tmk.kernel.Globals"%>
<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld"%>

<%
	request.setAttribute("idSeccion",new Integer(Globals.SECCION_HOME));
%>

<tiles:insert definition="seccion.general.ver.lista"/>
