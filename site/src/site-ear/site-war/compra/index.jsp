<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
//	MainHelper.controlDeModo(request, response);
	request.setAttribute("idSeccion", new Integer(500));
	String opMenuIzq = Convert.toString(request.getParameter("seccionCompra"), "1");
    SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
%>


<%
if(socioPK != null)
{
	//PAPEL DE REGALO
	if(opMenuIzq.equals("papelDeRegalo") ) {
%>
		<tiles:insert definition="seccion.general.compra.papel.regalo"/>
<%
	}else if(opMenuIzq.equals("carrito") ) {
	%>
		<tiles:insert definition="seccion.general.compra.carrito"/>
	<%
	}else if(opMenuIzq.equals("domicilios") ) {
%>
		<tiles:insert definition="seccion.general.compra.domicilio"/>
<%
	}else if(opMenuIzq.equals("agregarDomicilio") ) {
%>
		<tiles:insert definition="seccion.general.compra.agregar.domicilio"/>
<%
	}
	else if(opMenuIzq.equals("modificarDomicilio") ) {
%>
		<tiles:insert definition="seccion.general.compra.modificar.domicilio"/>
<%
	}
	else if(opMenuIzq.equals("medioDeCobro") ) {
%>
		<tiles:insert definition="seccion.general.compra.cobro"/>
<%
	}else if(opMenuIzq.equals("confirmacion") ) {
	%>
		<tiles:insert definition="seccion.general.compra.confirmacion"/>
<%
	}else if(opMenuIzq.equals("detalleDeOrden") ) {
		%>
		<tiles:insert definition="seccion.general.compra.detalle"/>
<%
	}if(opMenuIzq.equals("detalleOrden") ) {
		%>
		<tiles:insert definition="seccion.general.compra.detalleOrden"/>
<%
	}else if(opMenuIzq.equals("pagoConFallas") ) {
		%>
		<tiles:insert definition="seccion.general.compra.pago.fallas"/>
<%	}
}//NO TIENE SESION DEBE LOGUEARSE
else { if(opMenuIzq.equals("carrito") ) {
	%>
	<tiles:insert definition="seccion.general.compra.carrito"/>
<%
	} else {
%>
	<tiles:insert definition="seccion.general.micuenta"/>
<%	 } } %>
