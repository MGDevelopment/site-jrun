<%@ page import="com.tmk.setup.Contenido,
				 com.tmk.kernel.site.*,
                 com.tmk.articulo.ArticuloReducidoLocalHome,
                 com.tmk.kernel.*"%>

<%
    if (pagina.getPromocionesVert() != null) {

		String colorIzquierda = Globals.colorIzquierda(tipoArticulo);
        String colorDerecha = Globals.colorDerecha(tipoArticulo);
%>

<%{
        PromocionesVert promociones = pagina.getPromocionesVert();
	    if (promociones.getListaMultipleTypeItemCount() > 0) {
%>
	<table style="border: solid 1px; border-collapse: collapse;" border="1" cellspacing="0" cellpadding="0" width="157" >
		<tr >

			<td  style="border: solid 0px;"  bgcolor="<%=colorDerecha%>"><img src="/imagenes/promoN_<%=tipoArticulo%>.gif"></td>

		</tr>
<%}%>

		<%for (int index = 0; index < promociones.getListaMultipleTypeItemCount(); index++) {%>
		<%ListaMultipleTypeItem elemento = promociones.getListaMultipleTypeItem(index);%>
		<tr>
			<td  style="border-bottom: solid 1px;">
				<%if (elemento.getProducto() != null) {%>
					<%Producto producto = elemento.getProducto();%>
					<%@ include file="/componentes/comunes/elementoArticulo.jsp" %>
				<%} else if (elemento.getLink() != null) {%>
					<%Link link = elemento.getLink();%>
					<%@ include file="/componentes/comunes/elementoLink.jsp" %>
				<%} else if (elemento.getFlash() != null) {%>
					<%Flash flash = elemento.getFlash();%>
					<%@ include file="/componentes/comunes/elementoFlash.jsp" %>
				<%}%>
			</td>
		</tr>
		<%}%>
	</table>
<%}
	}%>