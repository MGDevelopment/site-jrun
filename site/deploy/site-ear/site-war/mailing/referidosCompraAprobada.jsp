<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferidosCompraAprobadaDaemon,
                 java.sql.Timestamp,
                 com.tmk.referido.ReporteReferido"%>

<html>
	<body>
		<b>Reporte de Referidos Compra Aprobada</b><br><br>
<%
	Vector referidosCompraAprobada = ReporteDeReferidosCompraAprobadaDaemon.referidosCompraAprobada;
	//if (referidosCompraAprobada == null || referidosCompraAprobada.size()==0) {
    if(referidosCompraAprobada.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {

	%>
		<div Style="font-family:verdana; font-size:10">Montos de compra Aprobada de Referidos.</div><br>
		<table align="left" width="760" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="120">
					<b>Fecha de Compra</b>
				</td>
				<td width="220">
					<b>eMail</b>
				</td>
                <td width="150">
					<b>Apellido</b>
				</td>
                <td width="150">
					<b>Nombre</b>
				</td>
				<td width=120 align="right">
					<b>Monto de Compra<b>
				</td>

    	    </tr>

<%

		for (int i = 0; i < referidosCompraAprobada.size(); i++) {
%>
            <tr>
				<td>
				<%= Convert.toString(((Vector)referidosCompraAprobada.get(i)).get(0), "")%>

				</td>
                <td>
				<%= Convert.toString(((Vector)referidosCompraAprobada.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosCompraAprobada.get(i)).get(2), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosCompraAprobada.get(i)).get(3), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosCompraAprobada.get(i)).get(4), "") %>
				</td>
    	    </tr>
<% 	   } %>
        </table>
<%


}

%>

<%


%>
	</body>
</html>
