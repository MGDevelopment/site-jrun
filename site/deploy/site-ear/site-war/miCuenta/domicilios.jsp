<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Convert"%>

<%	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI");
		response.sendRedirect("/miCuenta/index.jsp");
		return;
	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
  	} 
%>

<% request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME)); %>
<tiles:insert definition="tiles.micuenta.domicilios"/>
