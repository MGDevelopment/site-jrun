<%@ page import="com.tmk.kernel.site.ListaDeDeseos,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Producto" %>

<table align="center">
<tr align="center">
	<td>
		<table>
		<tr valign="middle">
			<td><img src="/imagenes/semiCirculoIzq.gif"></td>
			<td><img src="/imagenes/recomendaciones.gif"></td>
			<td><img src="/imagenes/semiCirculoDer.gif"></td>
		</tr>
		</table>
		<br>
		<br>
	</td>
</tr>
<tr align="center">
	<td>
	<%
		ListaDeDeseos recomendacion = Contenido.getSite().getListaDeDeseos();
		for(int i = 0; i < recomendacion.getListaProductosTypeItemCount(); i++)
		{
			Producto producto = recomendacion.getListaProductosTypeItem(i).getProducto();

			StringBuffer detalleProducto = new StringBuffer();
			detalleProducto.append("/componentes/comunes/detalleReducido.jsp?idArticulo=");
			detalleProducto.append(producto.getId());
			detalleProducto.append("&orden=");
			detalleProducto.append(i);

			%>
			<jsp:include page="<%= detalleProducto.toString() %>" />
			<%
		}
	%>
	</td>
</tr>
</table>
