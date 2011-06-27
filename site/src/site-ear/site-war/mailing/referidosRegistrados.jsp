<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferidosRegistradosDaemon,
                 com.tmk.referido.ReporteReferido"%>

<html>
	<body>
		<b>Reporte de Referidos Registrados</b><br><br>
<%
	Vector referidosRegistrados = ReporteDeReferidosRegistradosDaemon.referidosRegistrados;
    //Vector referidosRegistrados = ReporteReferido.referidosRegistrados();
	if (referidosRegistrados == null || referidosRegistrados.size()==0) {
    //if(referidosRegistrados.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {

	%>
		<div Style="font-family:verdana; font-size:10">Referidos registrados sin compras realizadas o con compras en proceso de aprobación.</div><br>
		<table align="left" width="760" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="120">
					<b>Fecha de Compra</b>
				</td>
				<td width="120">
					<b>Fecha de Registro</b>
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

    	    </tr>

<%

		for (int i = 0; i < referidosRegistrados.size(); i++) {
%>
            <tr>
				<td>
				<%= Convert.toString(((Vector)referidosRegistrados.get(i)).get(0), "")%>
				</td>
                <td>
				<%= Convert.toString(((Vector)referidosRegistrados.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosRegistrados.get(i)).get(2), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosRegistrados.get(i)).get(3), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosRegistrados.get(i)).get(4), "") %>
				</td>
    	    </tr>
<% 	    } %>
        </table>

<%
	referidosRegistrados.clear();
	//referidosRegistrados = null;
	} %>

	</body>
</html>
