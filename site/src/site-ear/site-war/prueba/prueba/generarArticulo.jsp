
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.generacion.articulo.GeneradorDeArticulo"%>
<%
	Globals.GENERANDO_DETALLES = false;
	GeneradorDeArticulo.generarArticulo();	
%>
