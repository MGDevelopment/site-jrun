<%@ page import="com.tmk.src.socio.SocioPK" %>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%	
	MainHelper.controlDeModo(request,response);
%>
	
<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/verCuponDePago.jsp?idOrden=" + idOrden);
		session.setAttribute("Registracion.feedback", "Para acceder a la impresi�n de cupones debes inciar sesi�n con tu usuario y contrase�a.");
%>		
		
<jsp:forward page="/miCuenta" />
<%	
	} 
%>

<% 
	request.setAttribute("idSeccion", Globals.SECCION_MICUENTA); 
%>		
<tiles:insert definition="seccion.cupones.vercupondepago"/>