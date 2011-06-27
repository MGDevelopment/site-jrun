<%@page import="com.tmk.soa.servicios.interfaces.DetalleService"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tmk.soa.servicios.interfaces.ArticuloService"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.tmk.kernel.Globals"%>
<%
	Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);			
	Articulo articulo = null;
	ArticuloService servicio = ServiceLocator.getArticuloService();
	try {	
		articulo = servicio.getArticuloById(idArticulo);
		DetalleService servicioDetalle = ServiceLocator.getDetalleArticuloService();
		out.println(servicioDetalle.getTemplate(articulo,"tmpDetalleGeneral"));		
	} catch (Throwable e) {		
		//e.printStackTrace();
		throw e;		
	}			
%>

