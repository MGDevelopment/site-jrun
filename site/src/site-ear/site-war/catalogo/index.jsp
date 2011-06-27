<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>

<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(request.getParameter("idSeccion")));
	/*request.setAttribute("idGrupo", request.getParameter("idGrupo"));
	request.setAttribute("idFamilia", request.getParameter("idFaimilia"));
	request.setAttribute("idSubFamilia", request.getParameter("idSubFamilia"));*/
	request.setAttribute("mostrarTodos",new Integer(1));
	request.setAttribute("requiereMesa", "true");
%>
<tiles:insert definition="seccion.general.catalogo" flush="true"/>