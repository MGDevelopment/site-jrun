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
	response.setDateHeader("Expires",-1);
  	response.setHeader("Pragma","no-cache");
  	if(request.getProtocol().equals("HTTP/1.1")){
  		response.setHeader("Cache-Control","no-cache");
  	}
%>

<tiles:insert definition="tiles.micuenta.modificarsocio"/>