<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.common.ReporteDeComprasPorAlianzasDaemon,
                 java.sql.Timestamp,
                 com.tmk.setup.Contenido"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<body>
		<b>Reporte Compras por Alianzas en el mes anterior</b><br><br>
<%
	Vector comprasPorAlianzas = ReporteDeComprasPorAlianzasDaemon.comprasPorAlianzas;
	if (comprasPorAlianzas.isEmpty()) {
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else { %>
		<table align="center" width="90%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
                <td width="25%">
					<B>Orden</B>
				</td>
                <td width="30%">
					<B>Fecha</B>
				</td>
                <td width="30%">
					<B>Alianza</B>
				</td>
                <td width="40%">
					<B>Seccion</B>
				</td>
                <td width="50%">
					<B>Titulo</B>
				</td>
                <td width="40%">
					<B>ISBN formateado</B>
				</td>
                <td width="20%">
					<B>Cantidad</B>
				</td>
                <td width="20%">
					<B>Precio</B>
				</td>
                <td width="20%">
					<B>Estado</B>
				</td>
    	    </tr>
<%	for (int i = 0; i <  comprasPorAlianzas.size(); i++) {
		String precioStr = Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(7), "0");
		//double precio = Convert.toNumber(precioStr, (double)0); //Pro algo siempre retorna 0.0
%>
            <tr>
                <td align="right">
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(0), "VACIO") %>
				</td>
                <td align="center">
				<%= Convert.toStringFromDDMMYYYY((Timestamp)((Vector)comprasPorAlianzas.get(i)).get(1) ) %>
				</td>
                <td>
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(2), "VACIO") %>
				</td>
                <td align="right">
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(3), "VACIO") %>
				</td>
                <td>
				<%= Convert.corregir(Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(4), "VACIO"), true) %>
				</td>
                <td>
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(5), "VACIO") %>
				</td>
                <td align="right">
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(6), "Sin cantidad") %>
				</td>
                <td align="right">
				<%=precioStr %>
				</td>
                <td align="center">
				<%= Convert.toString(((Vector)comprasPorAlianzas.get(i)).get(8), "Sin estado") %>
				</td>
    	    </tr>
<% 	} %>
        </table>

<% } %>
	</body>
</html>
