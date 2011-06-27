<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@ page import="com.tmk.src.socio.SocioPK"%>


<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
  	if (socioPK != null) {
  		response.sendRedirect("/miCuenta/index.jsp");
	  	return;
	}  
%>
<tiles:insert definition="seccion.general.registroTMK"/>