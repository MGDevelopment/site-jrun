<%@page import="com.tmk.kernel.Globals"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
%>

<jsp:include flush="true" page="/miCuenta/index.jsp?seccionMiCuenta=12&opcionMenuTarjetas=1"/>
