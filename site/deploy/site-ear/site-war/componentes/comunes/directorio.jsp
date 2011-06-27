<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.generacion.directorio.Directorio"
                 %>
<%  if (Globals.directorioHabilitado()) {%>
<tr>
	<td> <hr size="1" color="#C0C0C0">
		<%
			String letra = "A";
			for (int i=0; i<3; i++) {
				if (Directorio.CARACTERESVALIDOS.indexOf(articuloLocal.getTITULO().substring(i,i+1)) != -1) {
					letra = articuloLocal.getTITULO().substring(i,i+1);
					i = 3;
				}
			}
		%>
		<a href="/indice/index.jsp?letra=<%=letra%>"><b>Indice Alfabético</b></a>
	</td>
</tr>
<%
	}
%>
