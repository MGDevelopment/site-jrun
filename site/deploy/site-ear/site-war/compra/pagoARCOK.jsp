<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	if(request.getParameter("ErrorCode") == null) {
		response.sendRedirect("/");
	}
%>
<tiles:insert definition="seccion.arcash.pagook"/>
