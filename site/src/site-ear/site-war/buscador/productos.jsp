<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.TmkLogger"%>	
<%
MainHelper.controlDeModo(request, response);
Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion"), new Integer(Globals.SECCION_HOME));
request.setAttribute("idSeccion", idSeccion);
try {	
	if (idSeccion.intValue() == Globals.SECCION_HOME) {
%>	
		<tiles:insert definition="seccion.general.busqueda.inicio"/>
<%
	} else {
%>
		<tiles:insert definition="seccion.general.busqueda"/>
<%
	}
} catch(Throwable e ) {
	TmkLogger.debug("Error en productos.jsp");
}%>