<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK == null) {
		session.setAttribute("URL_REDIRECT", "/listaDeseos/verListaPropia.jsp");
		response.sendRedirect("/miCuenta/index.jsp");
		return;
	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT, "/listaDeseos/verListaPropia.jsp");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
		return;
	}
%>
<%	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));%>
<%--<jsp:include flush="true" page="/miCuenta/index.jsp?seccionMiCuenta=6"/>--%>

<tiles:insert definition="seccion.general.lista.deseo"/>