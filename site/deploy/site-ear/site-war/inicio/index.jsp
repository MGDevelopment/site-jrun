<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%
	session.removeAttribute("resultadoBusquedaForm");
	MainHelper.controlDeModo(request, response);
	request.setAttribute("mostrarTodos", new Integer(0));
	String URL_GRUPO  =  request.getParameter("URL_GRUPO");
	if(session.getAttribute("resultadoDeBusquedaForm")!=null){
		session.removeAttribute("resultadoDeBusquedaForm");
	}
%>
<%if("".equals(URL_GRUPO) || URL_GRUPO == null) {
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	//request.setAttribute("requiereMesa", "true");
	request.setAttribute("fondoSecciones", "true");
%>
<tiles:insert definition="seccion.inicio"/>
<%}else{
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_GENERAL));
%>
<tiles:insert definition="seccion.inicio.manuales"/>
<%} %>
<%=Globals.getGoogleAnalytics()%>