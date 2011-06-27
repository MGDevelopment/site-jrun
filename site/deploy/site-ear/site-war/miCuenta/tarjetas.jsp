<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
%>
<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/tarjetas.jsp");
%>

<jsp:forward page="/miCuenta" />
<%	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/miCuenta/tarjetas.jsp");
%>
		<jsp:forward page="/miCuenta/registroSocioCadena.jsp"/>
<%	}%>
<%	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA)); %>
<jsp:include flush="true" page="/miCuenta/index.jsp?seccionMiCuenta=12&opcionMenuTarjetas=0"/>