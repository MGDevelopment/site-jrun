<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	
	//seteo el path del file que quiero incluir
	request.setAttribute("pathFileAncluir", "/tiles/elemento/institucional/conozcanos.jsp");
%>
<tiles:insert definition="tiles.institucional" />
