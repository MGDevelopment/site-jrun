<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
	String opcion = request.getParameter("opcionMenu");
	Integer op = new Integer(opcion);
%>
<%
	switch(op.intValue())
	{
		case 0://para ver los domicilios
%>
			<jsp:include page="/miCuenta/domiciliosGeneral.jsp" flush="true"/>
<%		break;
		case 1://modificar
%>
			<jsp:include page="/miCuenta/modificarDomicilio.jsp" flush="true"/>
<%		break;
		case 2://agregar domicilios
%>
			<jsp:include page="/miCuenta/agregarDomicilio.jsp" flush="true"/>
<%		break;
	}
%>
