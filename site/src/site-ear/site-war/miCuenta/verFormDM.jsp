<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals" %>


<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/verFormDM.jsp?idOrden=" + idOrden);
		session.setAttribute("Registracion.feedback", "Para acceder los pagos con Dinero Mail debes inciar sesión con tu usuario y contraseña.");
%>
		
<jsp:forward page="/miCuenta" />
<%	} 


%>
		
<% 
	request.setAttribute("idSeccion", Globals.SECCION_MICUENTA); 
%>		
<tiles:insert definition="seccion.cupones.verformdm"/>