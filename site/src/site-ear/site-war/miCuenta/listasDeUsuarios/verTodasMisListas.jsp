<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals, com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if (socioPK == null) {
	 	response.sendRedirect("/miCuenta/");
	}	
%>
<%request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME)); %>
<tiles:insert definition="tiles.listas.vertodasmislistas"/>