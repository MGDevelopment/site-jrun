<%@ page import="com.tmk.kernel.Convert, com.tmk.orden.OrdenDAO,
    com.tmk.setup.Contenido"%><%

OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
int cantidadArticulos     = (ordenDAO == null) ? 0 : ordenDAO.getCantidadArticulosEnTotal();
double precioSitioCompleto = (ordenDAO == null) ? 0.0 : ordenDAO.totalSitioCompleto();
String titulo = Convert.toString(request.getParameter("titulo"), "");
String error = Convert.toString(request.getParameter("error"), null);
String imagen = Convert.toString(request.getParameter("imagen"), "");
String precio = Convert.toString(request.getParameter("precio"), "");
String msg = Convert.toString(request.getParameter("msg"), "");


response.setHeader("Content-Type", "text/xml");StringBuffer xml = new StringBuffer();
xml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
xml.append("<carrito>\n");
if (error == null) {
	xml.append("<error/>");
} else {
	xml.append("<error>").append(error).append("</error>");
}	
if ((ordenDAO == null) || (!ordenDAO.tieneArticulos())) { 
	xml.append("<item>");
	xml.append("No hay &amp;iacute;tems en el carrito.");
	xml.append("</item>\n");
	xml.append("<importe/>\n");
	xml.append("<link>");
	xml.append("javascript:alert('No se puede pagar esta compra debido a que no tiene productos en el carrito.')");
	xml.append("</link>\n");
	xml.append("<imagen/>\n");
	xml.append("<titulo/>\n");
	xml.append("<precio/>\n");
} else {
	xml.append("<item>");	
	xml.append("tenés ").append(Convert.pluralCompleto(cantidadArticulos ,"ítem"));
	xml.append("</item>\n");
	xml.append("<importe>").append(Contenido.precioToString(precioSitioCompleto).replace('&',' ').replace(';', ' ').replaceAll("nbsp ", "")).append("</importe>\n");
	xml.append("<link>");
	xml.append("/IniciarCompra");
	xml.append("</link>\n");
	xml.append("<imagen>").append(imagen).append("</imagen>\n");
	xml.append("<titulo>").append(titulo).append("</titulo>");
	xml.append("<msg>").append(msg).append("</msg>");
	xml.append("<precio>").append(precio).append("</precio>");
}
xml.append("</carrito>");
out.println(xml.toString());
%>
