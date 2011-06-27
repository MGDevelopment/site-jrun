<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferenteComprasDaemon,
                 java.sql.Timestamp"%>

<html>
	<body>
		<b>Reporte de Compras de Referentes</b><br><br>
<%
	Vector referenteCompras = ReporteDeReferenteComprasDaemon.referenteCompras;
	//if (referenteCompras == null || referenteCompras.size()==0) {
    if(referenteCompras.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {

	%>
		<div Style="font-family:verdana; font-size:10">Compras x referente.</div><br>
		<table align="left" width="640" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
		<tr bgcolor = "#E1E1E3">
			<td width="180">
				<b>eMail Referente</b>
			</td>
			<td width="120">
				<b>Apellido</b>
			</td>
			<td width="120">
				<b>Nombre</b>
			</td>
			<td width="120">
				<b>Fecha de Orden</b>
			</td>
			<td width="100">
				<b>Monto</b>
			</td>
		</tr>



<%

		for (int i = 0; i < referenteCompras.size(); i++) {
%>
			<tr>
<%

%>
				<td>
			<%= Convert.toString(((Vector)referenteCompras.get(i)).get(0), "")%>
				</td>

			<td>
			<%= Convert.toString(((Vector)referenteCompras.get(i)).get(1), "")%>
				</td>

				<td>
			<%= Convert.toString(((Vector)referenteCompras.get(i)).get(2), "")%>
				</td>

				<td>
			<%= Convert.toString((Timestamp)((Vector)referenteCompras.get(i)).get(3))%>
				</td>

				<td  align="right">
			<%= Convert.toString(((Vector)referenteCompras.get(i)).get(4), "")%>
				</td>

<% 	    } %>
    </tr>


<%
//	referenteCompras.clear();
//	referenteCompras = null;

%>
		</table>
<%
	}
%>
	</body>
</html>
