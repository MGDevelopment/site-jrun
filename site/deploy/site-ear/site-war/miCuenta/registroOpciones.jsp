<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
	String opcion = request.getParameter("opcionMenuRegistro");
	Integer op = new Integer(opcion);
%>
<%
	switch(op.intValue())
	{
		case 0:
			pageContext.include("/miCuenta/registroSocioTMK.jsp");
		break;
		case 1:
			pageContext.include("/miCuenta/registroSocioTMKExitoso.jsp");
		break;
	}
%>
