<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	session.setAttribute("busquedaNueva",new Boolean(true));
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	request.setAttribute("fondoSecciones", "true");
	response.sendRedirect("/");
%>
	<%--<tiles:insert definition="seccion.inicio"/>--%>


