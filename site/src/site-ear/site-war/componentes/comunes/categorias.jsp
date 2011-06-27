<%@ page import="com.tmk.kernel.Convert,
				 com.tmk.articulo.*,
				 com.tmk.kernel.site.*,
				 com.tmk.kernel.site.Producto,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals"%>
<%{%>
	<%PrimerLista categorias = pagina.getPrimerLista();%>
	<%for (int index = 0; index < categorias.getListaMultipleTypeItemCount(); index++) {%>
		<td valign="top" >
		<%ListaMultipleTypeItem elemento = categorias.getListaMultipleTypeItem(index);%>
		<%if (elemento.getProducto() != null) {%>
			<%ArticuloLocal articuloLocal = Contenido.getArticulo(elemento.getProducto());%>
     		<img src="/imagenes/top_<%=articuloLocal.getCATEGORIA_SECCION().intValue()%>.gif" width="40"><br>
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
<%}%>
