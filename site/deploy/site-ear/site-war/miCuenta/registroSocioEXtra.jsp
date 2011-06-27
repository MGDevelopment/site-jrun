<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>

<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
	//String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
	if (socioPK == null) {
		request.getSession().setAttribute("Registracion.feedback", "Si ya sos usuario tenes que loguearte, caso contrario registrarte ingresando tu email. Y podrás participar del programa eXtra!!");
		response.sendRedirect("/miCuenta/index.jsp");
		return;
	}
	if(esSocioTMK) {
		request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/miCuenta/registroSocioEXtra.jsp");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
		return;
	}
	if(request.getSession().getAttribute(MainHelper.SESSION_PUNTAJE_FIDELIZACION) != null) {
		response.sendRedirect("/fidelizacion/panel/puntos.jsp");
		return;
	}
%>
<tiles:insert definition="seccion.general.extra.registro"/>


