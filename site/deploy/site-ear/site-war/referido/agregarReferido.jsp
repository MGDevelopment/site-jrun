<%@page import="com.tmk.kernel.Globals"%>
<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<%@page import="com.tmk.src.socio.SocioPK" %>
<%
	//request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK == null ) {
		response.sendRedirect("/miCuenta");
	}
%>
<tiles:insert definition="tiles.micuenta.referidos.agregar"/>