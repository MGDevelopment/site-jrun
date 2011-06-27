<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.bus.socio.SociosIntegracion"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	SociosIntegracion socio = ServiceLocator.getSocioService().getSocioIntegracion(socioPK,"popego.com");
	request.setAttribute("socioIntegracion",socio);

	request.setAttribute("idSeccion",Globals.SECCION_HOME);
%>

<tiles:insert definition="tiles.micuenta.servicios.popego"></tiles:insert>