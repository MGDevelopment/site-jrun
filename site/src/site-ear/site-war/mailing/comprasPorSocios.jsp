<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.common.ReporteDeComprasPorSociosDaemon"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<body>
		<b>Reporte Compras por Socios en el mes anterior</b><br><br>
<%
	Vector comprasPorSocios = ReporteDeComprasPorSociosDaemon.comprasPorSocios;
	if (comprasPorSocios.isEmpty()) {
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else { %>
		<table align="center" width="95%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="20%">
					<B>Login</B>
				</td>
                <td width="20%">
					<B>Apellido</B>
				</td>
				<td width="20%">
					<B>Nombre</B>
				</td>
				<td width="10%">
					<B>Monto</B>
				</td>
				<td width="20%">
					<B>País</B>
				</td>
				<td width="10%">
					<B>Tarjeta</B>
				</td>
    	    </tr>
<%	for (int i = 0; i <  comprasPorSocios.size(); i++) {
%>
            <tr>
				<td>
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(0), "") %>
				</td>
                <td>
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(2), "") %>
				</td>
				<td align="right">
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(3), "0") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(4), "SIN PAIS") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)comprasPorSocios.get(i)).get(5), "NO FIDELIZADO") %>
				</td>
    	    </tr>
<% 	} %>
        </table>

<% } %>
	</body>
</html>
