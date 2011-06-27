<%@ page import="com.tmk.kernel.Globals"%>

<%	String tipoDomicilio = request.getParameter("TIPO_DOMICILIO");
	String url = "/compra/index.jsp?seccionCompra=modificarDomicilio&TIPO_DOMICILIO="+ tipoDomicilio;
%>

<jsp:include flush="true" page="<%=url%>"/>