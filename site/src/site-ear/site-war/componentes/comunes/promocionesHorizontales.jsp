<%@ page import="com.tmk.kernel.site.*" %>
<%if (pagina.getPromocionesHorz() != null) {%>
	<table width="100%" style="border: solid 1px; border-collapse: collapse;" align="center" cellspacing="0" cellpadding="0" border="0">
		<tr>
		<%PromocionesHorz promociones = pagina.getPromocionesHorz();%>
		<%for (int index = 0; index < promociones.getListaMultipleTypeItemCount(); index++) {%>
			<%ListaMultipleTypeItem elemento = promociones.getListaMultipleTypeItem(index);%>
			<td style="border: dotted 1px;">
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
		<%}%>
		</tr>
	</table>
<%}%>