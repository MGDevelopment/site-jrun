<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MUSICA));
	request.setAttribute("mostrarTodos",new Integer(1));
	//request.setAttribute("requiereMesa", "true");
	if(session.getAttribute("resultadoDeBusquedaForm")!=null){
		//System.out.println("se borra");
		session.removeAttribute("resultadoDeBusquedaForm");
	}
%>
<%--<tiles:insert definition="seccion.general.seccion"/>--%>
<tiles:insert definition="seccion.general.musica"/>

