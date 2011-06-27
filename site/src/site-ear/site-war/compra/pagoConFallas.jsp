<%@page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp"%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
%>
<%
	/*boolean esProcesoNuevo = (session.getAttribute("procesoDeCompraNuevo") != null);
	if(esProcesoNuevo){
		esProcesoNuevo = ((String)session.getAttribute("procesoDeCompraNuevo")).equals("true");
	}*/
	boolean esProcesoNuevo = ProcesoCompraUtilImp.getInstance().esProcesoNueo(request);
%>
<%	if(esProcesoNuevo){
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));	
%>
		<tiles:insert definition="tiles.proceso.compras.pagoConFallas"/>
<%	}else{ %>
		<jsp:include flush="true" page="/compra/index.jsp?seccionCompra=pagoConFallas"/>
<%	} %>
