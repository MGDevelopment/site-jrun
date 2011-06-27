<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%--
	String opcion = request.getParameter("opcionMenuReferido");
	Integer op = new Integer(opcion);
%>
<%
	switch(op.intValue())
	{
		case 0://para ver los domicilios
%>
			<jsp:include page="/miCuenta/referidos.jsp" flush="true"/>
<%		break;
		case 1://modificar agregar
%>
			<jsp:include page="/miCuenta/agregarReferido.jsp" flush="true"/>
<%		break;
		case 2://confirmacion
%>
			<jsp:include page="/miCuenta/referidoConfirmado.jsp" flush="true"/>
<%
		break;
		case 3://mis referidos
%>
			<jsp:include page="/miCuenta/consultaReferido.jsp" flush="true"/>
<%
		break;

	}//fin switch
--%>