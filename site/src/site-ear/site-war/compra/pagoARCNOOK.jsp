<%@taglib prefix="tiles" uri="/WEB-INF/struts-tiles.tld" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	//los datos  viene por post desde el site de arcash si el error code no esta informado, redirecciono a 
	//la home por que se entiende que se accedio de manera que no deberia ser esta jsp
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	if(request.getParameter("ErrorCode") == null) {
		response.sendRedirect("/");
	}
%>
<tiles:insert definition="seccion.arcash.pagonook"/>
