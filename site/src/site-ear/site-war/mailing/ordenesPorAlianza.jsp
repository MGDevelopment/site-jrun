<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.common.ReporteDeComprasPorSociosDaemon,
                 com.tmk.common.ReporteDeOrdenesPorAlianzaDaemon"%>

<html>
	<body>
		<b>Reporte de Ordenes Por alianza</b><br><br>
<%
	Vector ordenesPorAlianza = ReporteDeOrdenesPorAlianzaDaemon.ordenesPorAlianza;
	if (ordenesPorAlianza.isEmpty()) {
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else { %>
		<table  width="410" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
                <td width="80">
					<B>Id de Alianza</B>
				</td>
				<td width="250">
					<B>Descripción de Alianza</B>
				</td>
				<td width="80">
					<B>Cantidad de Ordenes</B>
				</td>
    	    </tr>
<%	for (int i = 0; i <  ordenesPorAlianza.size(); i++) {
%>
            <tr>
                <td>
				<%= Convert.toString(((Vector)ordenesPorAlianza.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)ordenesPorAlianza.get(i)).get(2), "") %>
				</td>
				<td align="right">
				<%= Convert.toString(((Vector)ordenesPorAlianza.get(i)).get(0), "") %>
				</td>
    	    </tr>
<% 	} %>
        </table>

<% } %>
	</body>
</html>