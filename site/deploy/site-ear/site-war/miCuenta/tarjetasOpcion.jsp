<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
	String opcion = request.getParameter("opcionMenuTarjetas");
	Integer op = new Integer(opcion);
%>
<%
	switch(op.intValue())
	{
		case 0://para ver los domicilios
%>
			<jsp:include page="/miCuenta/tarjetasPage.jsp" flush="true"/>
<%		break;
		case 1://modificar
%>
			<jsp:include page="/miCuenta/agregarTarjetaPage.jsp" flush="true"/>
<%		break;

	}
%>