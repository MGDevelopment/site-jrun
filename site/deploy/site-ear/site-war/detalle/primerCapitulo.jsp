<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.bus.articulo.ArticuloClass"%>
<%@page import="com.tmk.bus.articulo.ArticuloManager"%>
<%@page import="com.tmk.controllers.alianza.EstadisticaVisitas"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%
	MainHelper.controlDeModo(request, response);
	EstadisticaVisitas.incrementarAccesoABiografia();
	int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
	ArticuloClass articulo;
	articulo = ArticuloManager.getArticuloParaDetalle(idArticulo);
	if (articulo == null) {
		response.sendRedirect("/");
	}


	// Levanta los ultimos visitados y quita el actual para agregarlo luego
	Vector articulosVisitados = ((Vector)(session.getAttribute("articulosVisitados")));
	articulosVisitados = (articulosVisitados == null)? new Vector(): articulosVisitados;
	articulosVisitados.remove(new Integer(articulo.getIdArticulo()));

	if(articulosVisitados.size()==10) {
		articulosVisitados.remove(0);
	}

	session.setAttribute("articulosVisitados", articulosVisitados);


	request.setAttribute("idSeccion", new Integer(articulo.getIdSeccion()));
	request.setAttribute("articulo", articulo);
	request.setAttribute("detalle", "true");
	request.setAttribute("mostrarTodos", new Integer(1));



	//request.setAttribute("requiereMesa", "false");
%>



<tiles:insert definition="seccion.primerCapituloArticulo"/>
<%articulosVisitados.add(new Integer(articulo.getIdArticulo()));%>