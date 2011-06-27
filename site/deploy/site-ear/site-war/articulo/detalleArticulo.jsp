<%--
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	//response.sendRedirect("/articulo/componentes/detalle.jsp?"+request.getQueryString());
	String path = "/articulo/componentes/detalle.jsp?" + request.getQueryString();
%>

<jsp:include page="<%=path%>"></jsp:include>
--%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="java.util.Vector"%>
<%
	MainHelper.controlDeModo(request, response);
	if ((!Globals.sitioDisponible()) &&
	        (Convert.toBoolean(request.getParameter("CONTROLAR_SERVER"),true)) &&
	        (Convert.toBoolean(request.getSession().getAttribute("RESPETAR_MODO"), true))) {
		response.sendRedirect("/mantenimiento.jsp");
	}
	Integer idArticulo = new Integer(request.getParameter("idArticulo"));
	request.setAttribute("idArticulo",idArticulo);
	Integer idSeccion = Convert.toNumber(request.getParameter("idSeccion" ),ServiceLocator.getArticuloService().getDatosPrincipal(idArticulo).getCategoria_seccion());
	request.setAttribute("idSeccion", idSeccion);
	
	// Levanta los ultimos visitados y quita el actual para agregarlo luego
	Vector articulosVisitados = ((Vector)(session.getAttribute("articulosVisitados")));
	articulosVisitados = (articulosVisitados == null)? new Vector(): articulosVisitados;
	articulosVisitados.remove(idArticulo);

	if(articulosVisitados.size()==10) {
		articulosVisitados.remove(0);
	}
	session.setAttribute("articulosVisitados", articulosVisitados);
%>
<tiles:insert definition="seccion.detalle.articulo2"/>
<%articulosVisitados.add(idArticulo);%>