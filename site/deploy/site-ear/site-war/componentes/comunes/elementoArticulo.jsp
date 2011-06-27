<%@ page import="com.tmk.articulo.ArticuloLocal,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Pair,
                 com.tmk.kernel.Globals" %>

<% try {%>
<table width="94%" height="20" border="0">
	<tr height="20" align="center">
		<td width="912" height="10">

		    <%  ArticuloLocal detalle = Contenido.getArticulo(producto);
		    int categoria = 1;
			   categoria = detalle.getCATEGORIA_SECCION().intValue();
			 
                Pair tamImagen = Globals.tamañoImagen(categoria, Globals.IMAGEN_CHICA);
	    
                altoImagen = ((Integer)tamImagen.getValue1()).intValue();
                anchoImagen = ((Integer)tamImagen.getValue2()).intValue();         %>
            <table border="0" align="center" cellpadding= "0" cellspacing= "0">
				<tr valign="middle" >
					<td height="95" valign="middle" align="center">
                        <a href= "/articulo/detalleArticulo.jsp?idArticulo=<%= producto.getId()%>">
				            <img src="<%= Contenido.getTapa (producto, anchoImagen, altoImagen)%>" border="0"  width="<%= anchoImagen%>" height="<%= altoImagen%>" alt="<%=Contenido.getAyuda(producto)%>">
			            </a>
			 		</td>
				</tr>
				<tr>
					<td align = "center" style="font-weight: bold; font-size: 9px; color: #000000;">
						<a href="/articulo/detalleArticulo.jsp?idArticulo=<%= producto.getId()%>"><%= Contenido.getTitulo(producto,22)%></a>
					</td>
				</tr>
				<tr>
					<td align = "center" style="font-size: 9px; color: #000000;">
					<% //String atributoPrincipal = Convert.toString(Convert.toString(detalle.getATRIBUTO_PRINCIPAL(),""), 22);
			    	 //  String urlBusquedaXAtributoPrincipal = detalle.getUrlBusquedaXAtributoPrincipal();
					%>

                    <%//if (urlBusquedaXAtributoPrincipal != null) {
	                %>
	                    <a href="<%//= urlBusquedaXAtributoPrincipal%>"><%//= atributoPrincipal%></a>
	                <%
                       //} else {
		            %>
                    <%//=	atributoPrincipal%>
                    <%//}
	                    %>
                    </td>
                <tr>
				<tr>
					<td align = "center" style="font-size: 9px; color: #000000;">
					<a href="<%//= detalle.getUrlBusquedaXCategoria()%>"><%//=detalle.getCategorizacion()%></a>
	            </td>
                <tr>


                    <td>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<%} catch (Exception e) {
out.println(e.toString());
}%>
