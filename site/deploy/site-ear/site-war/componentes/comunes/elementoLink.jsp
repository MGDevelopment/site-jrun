<%@ page import="com.tmk.setup.Contenido"%>

<table width="100%" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center">
			<%String paginaDestino = Contenido.getPagina(link);%>
			<%if (paginaDestino != null) {%><a href="<%=paginaDestino%>"><%}%>
			<img src="<%=Contenido.getImagen(link)%>" border="0" alt="<%=Contenido.getAyuda(link)%>">
			<%if (paginaDestino != null) {%></a><%}%>
		</td>
	</tr>
	<%if (link.getTexto() != null) {%>
		<td  align="center">
		<b><%=Contenido.getTexto(link)%></b><br>
		</td>
	<%}%>
</table>
