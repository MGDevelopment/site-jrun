<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>

<tiles:insert definition="seccion.general.recuperar"/>