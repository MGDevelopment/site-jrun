<%--@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%  MainHelper.controlDeModo(request, response); %>
<%	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME)); %>
<tiles:insert definition="proceso.compras.carrito" />
--%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));	
	response.sendRedirect("/compra/carrito.do");
%>