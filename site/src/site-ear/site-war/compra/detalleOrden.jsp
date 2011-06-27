<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals"
                 %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>                 
<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK == null){
		pageContext.forward("/miCuenta");
	}
%>
<%	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME)); %>

	<%--<jsp:include flush="true" page="/compra/index.jsp?seccionCompra=detalleOrden"/>--%>
	<tiles:insert definition="seccion.general.compra.detalleOrden"/>
