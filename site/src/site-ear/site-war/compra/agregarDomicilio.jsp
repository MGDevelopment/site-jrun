<%@ page import="com.tmk.kernel.Globals"%>

<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	String tipoDomicilio = request.getParameter("TIPO_DOMICILIO");
%>
<jsp:include flush="true" page="/compra/index.jsp?seccionCompra=agregarDomicilio"/>

