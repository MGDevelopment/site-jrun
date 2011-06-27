<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.common.ReporteDeSociosRegistradosDaemon"%>

<html>
	<body>
		<b>Reporte Socios Registrados en el mes anterior</b><br><br>
<%
	Vector sociosRegistrados = ReporteDeSociosRegistradosDaemon.sociosRegistrados;
	//if (sociosRegistrados == null) {
    if(sociosRegistrados.isEmpty()){
%>
				<p>&nbps;No se encontraron resultados.
<%  } else { %>
		<table align="center" width="90%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td>
					<B>Login</B>
				</td>
				<td>
					<B>Apellido</B>
				</td>

				<td>
					<B>Nombre</B>
				</td>
				<td>
					<B>Nro Tarjeta</B>
				</td>
				<td>
					<B>Pais Fact</B>
				</td>
    	    </tr>
<%	for (int i = 0; i < sociosRegistrados.size(); i++) {
%>
            <tr>
				<td>
				<%= Convert.toString(((Vector)sociosRegistrados.get(i)).get(0), "") %>
				</td>
                <td>
				<%= Convert.toString(((Vector)sociosRegistrados.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)sociosRegistrados.get(i)).get(2), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)sociosRegistrados.get(i)).get(3), "NO FIDELIZADO") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)sociosRegistrados.get(i)).get(4), "SIN PAIS") %>
				</td>
    	    </tr>
<% 	} %>
        </table>

<% } %>
	</body>
</html>
