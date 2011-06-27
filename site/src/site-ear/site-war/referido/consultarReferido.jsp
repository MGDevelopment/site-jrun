<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>

<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/referido/consultarReferido.jsp");
		response.sendRedirect("/miCuenta/index.jsp");
		return;
	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/referido/consultarReferido.jsp");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
		return;
	}
%>

<%	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME)); %>

<tiles:insert definition="tiles.micuenta.referidos.consultar"/>